package com.teksystems.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Slf4j //Slf4j allows for the log.info() to work
@Controller
public class SlashController {

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

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit() {
        log.debug("In the edit controller method.");
        ModelAndView response = new ModelAndView("edit");
        return response;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        log.debug("In the signin controller method.");
        ModelAndView response = new ModelAndView("signin");
        return response;
    }

}
