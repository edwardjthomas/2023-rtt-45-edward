package com.teksystems.controller;

import com.teksystems.database.dao.*;
import com.teksystems.database.entity.OrderDetails;
import com.teksystems.database.entity.Services;
import com.teksystems.formbeans.OrdersFormBean;
import com.teksystems.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.teksystems.database.entity.User;
import com.teksystems.database.entity.Orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j // Slf4j allows for the log.info() to work
@Controller
@RequestMapping("/order")
@PreAuthorize("hasAuthority('USER')")
public class OrderController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ServicesDAO servicesDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private OrdersDAO ordersDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = { "/addtocart" }, method = RequestMethod.GET)
    // 1) incoming argument to controller is the product_id
    public ModelAndView addtocart(@RequestParam(required = true) Integer serviceId) {
        log.debug("In the addtocart controller method.");
        ModelAndView response = new ModelAndView();

        Services service = servicesDAO.findById(serviceId);

        User user = authenticatedUserService.loadCurrentUser();

        // does making a new orders here wipe whatever was previously established?
        // 3) query for an order where status = "cart" and user_id = "logged in user id"
        Orders order = ordersDAO.findByStatusEqualsCartAndUserId(user.getId());

        // 4) if not found create a new order with status = "cart" and save
        if (order == null) {
            // this is the case where the order doesn't exist in the database
            order = new Orders();
            order.setStatus("Cart");
            order.setUser(user);
            order.setStartDate(new Date());
            ordersDAO.save(order);
        }

        // 5) use the product_id and the order id to create query for the order product
        OrderDetails orderDetails = orderDetailsDAO.findByOrderIdAndServicesId(order.getId(), service.getId());

        // 6) if it exists then increment the quantity by 1 otherwise create it with
        // quantity = 1
        if (orderDetails == null) {
            orderDetails = new OrderDetails();
            orderDetails.setQuantity(1);
            orderDetails.setServices(service);
            orderDetails.setOrders(order);
        } else {
            orderDetails.setQuantity(orderDetails.getQuantity() + 1);
        }
        orderDetailsDAO.save(orderDetails);
        response.setViewName("redirect:/order/viewcart");
        return response;
    }

    @RequestMapping(value = { "/removefromcart" }, method = RequestMethod.GET)
    // 1) incoming argument to controller is the product_id
    public ModelAndView removefromcart(@RequestParam(required = true) Integer serviceId) {
        log.debug("In the removefromcart controller method.");
        ModelAndView response = new ModelAndView();

        Services service = servicesDAO.findById(serviceId);

        User user = authenticatedUserService.loadCurrentUser();

        // does making a new orders here wipe whatever was previously established?
        // 3) query for an order where status = "cart" and user_id = "logged in user id"
        Orders order = ordersDAO.findByStatusEqualsCartAndUserId(user.getId());

        // 5) use the product_id and the order id to create query for the order product
        OrderDetails orderDetails = orderDetailsDAO.findByOrderIdAndServicesId(order.getId(), service.getId());

        orderDetailsDAO.removeFromCartByOrderIdAndServicesId(order.getId(), service.getId());

        orderDetailsDAO.save(orderDetails);
        response.setViewName("redirect:/order/viewcart");
        return response;
    }

    @RequestMapping(value = { "/viewcart" }, method = RequestMethod.GET)
    public ModelAndView viewcart() {
        log.debug("In the viewcart controller method.");
        ModelAndView response = new ModelAndView("order/viewcart");

        User user = authenticatedUserService.loadCurrentUser();

        List<Map<String, Object>> orderDetails = ordersDAO.findCartProductsByUserId(user.getId());

        response.addObject("orderDetailsList", orderDetails);

        return response;
    }

    @RequestMapping(value = { "/submitOrder" }, method = RequestMethod.GET)
    public ModelAndView submitOrder() {
        log.debug("In the submitOrder controller method.");
        ModelAndView response = new ModelAndView();

        User user = authenticatedUserService.loadCurrentUser();

        Orders order = ordersDAO.findByStatusEqualsCartAndUserId(user.getId());

        order.setStatus("Complete");
        ordersDAO.save(order);

        response.setViewName("redirect:/order/ordercomplete");
        return response;

    }

    @RequestMapping(value = { "/ordercomplete" }, method = RequestMethod.GET)
    public ModelAndView ordercomplete() {
        log.debug("In the ordercomplete controller method.");
        ModelAndView response = new ModelAndView("order/ordercomplete");
        return response;
    }

    @GetMapping("/pastorders")
    public ModelAndView pastorders() {
        ModelAndView response = new ModelAndView("order/pastorders");
        User user = authenticatedUserService.loadCurrentUser();

        log.debug("In pastorders controller method");
        List<Map<String, Object>> order = ordersDAO.findPastOrdersByUserId(user.getId());

        // this allows for the employee details to appear on the details page
        response.addObject("order", order);

        log.debug(order + "");
        return response;
    }

}
