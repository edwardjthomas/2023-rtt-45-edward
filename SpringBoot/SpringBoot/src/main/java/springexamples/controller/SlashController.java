package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;

// this is not considered a rest controller
// RESTFul applications typically return data in JSON or XML format
// This is an MVC
//
@Slf4j
@Controller
public class SlashController {

    @Autowired
    private EmployeeDAO employeeDAO;

    // an example of @RequestMapping with Multiple URIs
    // keep an eye on using the {} on the value = to indicate the multiple names
    // users can input to get you to that same page
    @RequestMapping(value = { "/index", "/", "/index.html" }, method = RequestMethod.GET)
    public ModelAndView index() {
        log.debug("In the index controller method.");
        ModelAndView response = new ModelAndView("index");

        // won't be able to see trace for the moment
        log.trace("This is a trace log example");
        log.debug("This is a debug log example");
        log.info("This is an info log example");
        log.warn("This is a warn log example");
        log.error("This is an error log example");

        return response;
    }

    // GetMapping shortens RequestMapping where you simply have to use the @ call
    // and put the /page inside the ()
    // shortcut for @RequestMapping (method = RequestMethod.GET).
    @GetMapping("/signup")
    public ModelAndView signup() {
        log.debug("In the signup controller method.");

        ModelAndView response = new ModelAndView("signup");
        return response;
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ModelAndView bootstrap() {
        log.debug("In the bootstrap controller method.");

        ModelAndView response = new ModelAndView("bootstrap");
        return response;
    }
}
