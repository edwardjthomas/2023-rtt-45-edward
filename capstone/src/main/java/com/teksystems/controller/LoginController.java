package com.teksystems.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

    // this method is used to display the login page itself and that's it
    // it just gives us a url for the login.jsp
    // connected to SecurityConfig
    // BasicAuth
    // or Forms-Based Authentication
    @GetMapping("/login/loginPage")
    public ModelAndView setup() {
        log.debug("In the login controller method.");

        ModelAndView response = new ModelAndView("login/login");
        return response;
    }
}
