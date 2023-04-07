package com.teksystems.controller;

import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.UserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j //Slf4j allows for the log.info() to work
@Controller
public class SlashController {

    @Autowired
    private UserDAO userDAO;

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

}
