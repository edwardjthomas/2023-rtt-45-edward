package com.teksystems.controller;

import com.teksystems.database.entity.Services;
import io.micrometer.common.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import com.teksystems.database.dao.ServicesDAO;
import com.teksystems.database.dao.UserRoleDAO;
import com.teksystems.database.dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j // Slf4j allows for the log.info() to work
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ServicesDAO servicesDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView serviceSearch(@RequestParam(required = false) String artistName) {
        log.debug("In the search controller method with artistName = " + artistName);
        ModelAndView response = new ModelAndView("user/search");

        List<Services> services = new ArrayList<>();

        if (!StringUtils.isEmpty(artistName)) {
            // if so run the query that works with both values
            log.debug("artistName has a value");
            services = servicesDAO.findByArtistNameContainingIgnoreCase(artistName);
        }

        response.addObject("servicesList", services);

        // anything you add on to the search bar will be stored on the search.jsp page
        response.addObject("artistNameParameter", artistName);

        return response;
    }
}
