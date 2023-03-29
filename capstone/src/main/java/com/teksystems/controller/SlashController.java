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
        log.info("In the home controller method.");
        ModelAndView response = new ModelAndView("home");
        return response;
    }

    @RequestMapping(value = "/portfolio", method = RequestMethod.GET)
    public ModelAndView portfolio() {
        log.info("In the portfolio controller method.");
        ModelAndView response = new ModelAndView("portfolio");
        return response;
    }

    @RequestMapping(value = "/commission", method = RequestMethod.GET)
    public ModelAndView commission() {
        log.info("In the commission controller method.");
        ModelAndView response = new ModelAndView("commission");
        return response;
    }

    @RequestMapping(value = "/queue", method = RequestMethod.GET)
    public ModelAndView queue() {
        log.info("In the queue controller method.");
        ModelAndView response = new ModelAndView("queue");
        return response;
    }

}
