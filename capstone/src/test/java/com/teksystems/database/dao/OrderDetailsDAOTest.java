package com.teksystems.database.dao;

import com.teksystems.MainApplication;
import com.teksystems.database.entity.OrderDetails;
import com.teksystems.database.entity.Orders;
import com.teksystems.database.entity.Services;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = MainApplication.class)
public class OrderDetailsDAOTest {

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private OrdersDAO ordersDAO;

    @Autowired
    private ServicesDAO servicesDAO;

    @Test
    @Order(0)
    public void addTestOrder() {
        // create the order to be tested
        ordersDAO.testAdd();
    }

    @Test
    @Order(1)
    public void createOrderDetail() {

        // what is given
        OrderDetails given = new OrderDetails();
        Orders order = ordersDAO.findById(1000);
        Services service = servicesDAO.findById(1);
        given.setOrderId(order.getId());
        given.setOrders(order);
        given.setServicesId(service.getId());
        given.setServices(service);
        given.setQuantity(1);

        // when
        orderDetailsDAO.save(given);

        // then
        OrderDetails actual = orderDetailsDAO.findByOrderIdAndServicesId(1000, 1);

        Assertions.assertEquals(given.getOrderId(), actual.getOrderId());
        Assertions.assertEquals(given.getServicesId(), actual.getServicesId());
        Assertions.assertEquals(given.getQuantity(), actual.getQuantity());
    }

    @Test
    @Order(2)
    public void updateOrderDetail() {
        // what is given
        OrderDetails given = orderDetailsDAO.findByOrderIdAndServicesId(1000, 1);

        given.setQuantity(5);

        // when
        orderDetailsDAO.save(given);

        OrderDetails actual = orderDetailsDAO.findByOrderIdAndServicesId(1000, 1);

        Assertions.assertEquals(given.getOrderId(), actual.getOrderId());
        Assertions.assertEquals(given.getServicesId(), actual.getServicesId());
        Assertions.assertEquals(given.getQuantity(), actual.getQuantity());
    }

    @Test
    @Order(3)
    public void deleteOrderDetail() {
        OrderDetails given = orderDetailsDAO.findByOrderIdAndServicesId(1000, 1);

        orderDetailsDAO.delete(given);

        OrderDetails actual = orderDetailsDAO.findByOrderIdAndServicesId(1000, 1);
        Assertions.assertNull(actual);

    }

    @Test
    @Order(4)
    public void deleteTestOrder() {
        ordersDAO.testDelete();

    }

}
