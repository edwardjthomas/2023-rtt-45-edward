package com.teksystems.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teksystems.database.entity.UserRole;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Integer id);
}
