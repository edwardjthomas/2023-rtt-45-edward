package com.teksystems.controller;

import com.teksystems.database.dao.OrdersDAO;
import com.teksystems.database.dao.ServicesDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.dao.UserRoleDAO;
import com.teksystems.formbeans.OrdersFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.teksystems.database.entity.User;
import com.teksystems.database.entity.Orders;

import java.util.List;


@Slf4j // Slf4j allows for the log.info() to work
@Controller
@RequestMapping("/order")
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
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = { "/addtocart" }, method = RequestMethod.GET)
    // 1) incoming argument to controller is the product_id
    public ModelAndView addtocart(@RequestParam(required = false) Integer id) {
        log.debug("In the addtocart controller method.");
        ModelAndView response = new ModelAndView("redirect:/order/viewcart");

        Orders orders = new Orders();
        User user = new User();
        // but doesn't this return an empty id?
        id = orders.getId();

        // 2) get the logged in user from the authenticated user service
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        // 3) query for an order where status = "cart" and user_id = "logged in user id"
        ordersDAO.findByStatusAndUserId(orders.getStatus(), orders.getUserId());

        // 4) if not found create a new order with status = "cart" and save
        if (ordersDAO.findByStatus(orders.getStatus()) != null) {

        } else  {
            orders.setStatus("Cart");
            ordersDAO.save(orders);
        }

        return response;
    }

    @RequestMapping(value = { "/viewcart" }, method = RequestMethod.GET)
    public ModelAndView viewcart() {
        log.debug("In the viewcart controller method.");
        ModelAndView response = new ModelAndView("order/viewcart");
        return response;
    }
}
