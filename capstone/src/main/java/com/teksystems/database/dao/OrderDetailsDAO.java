package com.teksystems.database.dao;

import com.teksystems.database.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Long> {

    OrderDetails findById(Integer id);

    // need to do select * from orderdetails where (status...)
    // join the orderdetails to the order table
    // and then you want where the order status = "Cart" and the user_id is the logged in user
    // can be done as either native or jpa query (native preferred)

    // get the view cart page working, add 2 products to the cart, then write the query to get the order products

    @Query(value = "SELECT * FROM orderdetails od WHERE od.order_id = :orderId AND od.services_id = :servicesId ;", nativeQuery = true)
    OrderDetails findByOrderIdAndServicesId(Integer orderId, Integer servicesId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM orderdetails WHERE order_id = :orderId AND services_id = :servicesId ;", nativeQuery = true)
    void removeFromCartByOrderIdAndServicesId(Integer orderId, Integer servicesId);


}
