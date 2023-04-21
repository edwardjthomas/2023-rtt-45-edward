package com.teksystems.database.dao;

import com.teksystems.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrdersDAO extends JpaRepository<Orders, Long> {

    Orders findById(Integer id);

    Orders findByStatus(String status);

    Orders findByUserId(Integer userId);

    @Query("FROM Orders o WHERE o.status = 'Cart' AND o.user.id = :userId ")
    Orders findByStatusEqualsCartAndUserId(Integer userId);

    @Query("FROM Orders o WHERE o.status = 'Cart' AND o.user.id = :userId ")
    List<Orders> findListByStatusEqualsCartAndUserId(Integer userId);

    @Query(value = "select s.*, od.quantity from services s, orderdetails od where s.id = od.services_id and od.order_id = :orderId ;"
            , nativeQuery = true)
    List<Map<String,Object>> findCartProductsByOrderId(Integer orderId);

    @Query(value = "select s.*, od.quantity, o.status from services s, orderdetails od, orders o where s.id = od.services_id and od.order_id = o.id and o.status ='Cart' and o.user_id = :userId ;"
            , nativeQuery = true)
    List<Map<String,Object>> findCartProductsByUserId(Integer userId);

    @Query(value = "select s.*, od.quantity from services s, orderdetails od, orders o where s.id = od.services_id and od.order_id = o.id and o.status ='Complete' and o.user_id = :userId ;", nativeQuery = true)
    List<Map<String,Object>> findPastOrdersByUserId(Integer userId);
}
