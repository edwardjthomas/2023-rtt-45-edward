package com.teksystems.database.dao;

import com.teksystems.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersDAO extends JpaRepository<Orders, Long> {

    Orders findById(Integer id);

    Orders findByStatus(String status);

    Orders findByUserId(Integer userId);

    //%:user_id% creates unsatisfied dependency error, why?
    @Query(value = "SELECT * FROM orders o WHERE o.status = 'Cart' AND o.user_id LIKE user_id ;", nativeQuery = true)
    List<Orders> findByStatusAndUserId(String status, Integer userId);

}
