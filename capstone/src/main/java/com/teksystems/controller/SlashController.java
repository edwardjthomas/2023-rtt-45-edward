package com.teksystems.controller;

import com.teksystems.database.dao.ServicesDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Services;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.UserFormBean;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Slf4j //Slf4j allows for the log.info() to work
@Controller
public class SlashController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ServicesDAO servicesDAO;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        log.debug("In the home controller method.");
        ModelAndView response = new ModelAndView("home");
        return response;
    }

    @RequestMapping(value = "/portfolio", method = RequestMethod.GET)
    public ModelAndView portfolio() {
        log.debug("In the portfolio controller method.");
        ModelAndView response = new ModelAndView("portfolio");
        return response;
    }

    @RequestMapping(value = "/commission", method = RequestMethod.GET)
    public ModelAndView commission() {
        log.debug("In the commission controller method.");
        ModelAndView response = new ModelAndView("commission");
        return response;
    }

    @RequestMapping(value = "/waitlist", method = RequestMethod.GET)
    public ModelAndView waitlist() {
        log.debug("In the waitlist controller method.");
        ModelAndView response = new ModelAndView("waitlist");
        return response;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        log.debug("In the create controller method.");
        ModelAndView response = new ModelAndView("create");
        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(UserFormBean form) {
        ModelAndView response = new ModelAndView("/create");

        log.debug("!!!!!!!!!!!!!!!!!!!!!!!!!! In the / create controller method.");
        log.debug(form.toString());


        User user = new User();


        if (form.getId() != null && form.getId() > 0) {
            user = userDAO.findById(form.getId());
        }

        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPreferredContact(form.getPreferredContact());

        userDAO.save(user);
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        log.debug("In the signin controller method.");
        ModelAndView response = new ModelAndView("signin");
        return response;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("/details");

        log.debug("In details controller method with id = " + id);
        Services services = servicesDAO.findById(id);

        // this allows for the employee details to appear on the details page
        response.addObject("services", services);

        log.debug(services + "");
        return response;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView serviceSearch(@RequestParam(required = false) String artistName) {
        log.debug("In the search controller method with artistName = " + artistName);
        ModelAndView response = new ModelAndView("/search");

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
