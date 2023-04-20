package com.teksystems.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.teksystems.database.entity.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    @Query("FROM User u")
    List<User> getAllUsers();

    User findById(Integer id);

    User findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    User findByEmail(String email);
}