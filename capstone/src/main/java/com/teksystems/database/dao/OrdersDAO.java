package com.teksystems.database.dao;

import com.teksystems.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersDAO extends JpaRepository<Orders, Long> {

    Orders findById(Integer id);

    Orders findByStatus(String status);

    Orders findByUserId(Integer userId);

    @Query("FROM Orders o WHERE o.status = 'Cart' AND o.user.id = :userId ")
    Orders findByStatusEqualsCartAndUserId(Integer userId);

    @Query("FROM Orders o WHERE o.status = 'Cart' AND o.user.id = :userId ")
    List<Orders> findListByStatusEqualsCartAndUserId(Integer userId);
}
