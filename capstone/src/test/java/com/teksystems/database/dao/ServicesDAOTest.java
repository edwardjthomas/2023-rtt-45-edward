package com.teksystems.database.dao;

import com.teksystems.database.entity.Services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServicesDAOTest {

    @Autowired
    private ServicesDAO servicesDAO;

    @Test
    public void findByTypeContainingIgnoreCaseTest() {
        servicesDAO.findByTypeContainingIgnoreCase("Art");
        Services services = servicesDAO.findById(1);
        Assertions.assertEquals(services.getArtistName(),"Ame");
        Assertions.assertEquals(services.getType(),"Art");

    }

}
