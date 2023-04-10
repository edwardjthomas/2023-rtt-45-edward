package com.teksystems.controller;

import com.teksystems.database.dao.ServicesDAO;
import com.teksystems.database.dao.UserRoleDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Services;
import com.teksystems.database.entity.User;
import com.teksystems.database.entity.UserRole;
import com.teksystems.formbeans.UserFormBean;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Slf4j // Slf4j allows for the log.info() to work
@Controller
public class SlashController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ServicesDAO servicesDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
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
        ModelAndView response = new ModelAndView("create");

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

    // post mapping for create
    @PostMapping("/create")
    public ModelAndView setup(UserFormBean form) {

        ModelAndView response = new ModelAndView("create");
        log.debug("In the create controller method after making new user.");

        User user = new User();
        user.setUsername(form.getUsername());
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPreferredContact(form.getPreferredContact());

        // this is needed by spring security to encrypt passwords as the user is being
        // created. (4/7)
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        // doing it this way will have not not require to do the many to ones and the
        // ones to manys
        // save our user .. when hibernate saves this user it will auto generate the ID
        // AND it will populate the fild in the user entity
        userDAO.save(user);

        // create our user role object
        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        // so when we go to set the user id FK on the user role entity the user id has
        // been populated already.
        userRole.setUserId((user.getId()));

        // the user is created first
        // THEN the userRole is created
        // they both finish before the controller method finishes
        userRoleDAO.save(userRole);

        log.debug(form.toString());

        return response;
    }

    // depreciated and changed to "login" inside LoginController
    // @RequestMapping(value = "/signin", method = RequestMethod.GET)
    // public ModelAndView signin() {
    // log.debug("In the signin controller method.");
    // ModelAndView response = new ModelAndView("signin");
    // return response;
    // }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("details");

        log.debug("In details controller method with id = " + id);
        Services services = servicesDAO.findById(id);

        // this allows for the employee details to appear on the details page
        response.addObject("services", services);

        log.debug(services + "");
        return response;
    }

}
