package com.teksystems.database.dao;

import com.teksystems.database.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void getAllUsersTest() {
        userDAO.getAllUsers();
    }

    @Test
    public void findByIdTest() {
        User user = userDAO.findById(1);



        Assertions.assertEquals(user.getName(),"Kyle Timm");
        Assertions.assertEquals(user.getId(),1);
        Assertions.assertEquals(user.getUsername(),"JellyFishRFake");
    }
}
