package springexamples.controller;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstsearch, @RequestParam(required = false) String lastsearch) {
        // this log info here reflects inside intellij so don't get confused with where it prints out
        log.info("In the employee search controller method with firstName = " + firstsearch + " lastName = " + lastsearch);
        ModelAndView response = new ModelAndView("employee/employee-search");

        List<Employee> employees = new ArrayList<>();

        // an example of using commons.lang3's StringUtils
        if (!StringUtils.isEmpty(lastsearch)) {
        }

        // check if both firstName and lastName have a value
        if ( ! StringUtils.isEmpty(firstsearch) && ! StringUtils.isEmpty(lastsearch)) {
            // if so run the query that works with both values
            log.info("Both first name and last name have a value");
            employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstsearch, lastsearch);
        }

        // check if the first name is not empty and the last name is empty
        if ( ! StringUtils.isEmpty(firstsearch) && StringUtils.isEmpty(lastsearch)) {
            // we run our query that checks the first name field only
            log.info("First name has a value and last name is empty");
            employees = employeeDAO.findByFirstNameContainingIgnoreCase(firstsearch);

        }

        // check if the first name is empty and the last name is not empty
        if ( StringUtils.isEmpty(firstsearch) && ! StringUtils.isEmpty(lastsearch)) {
            // if so run the query that works with both values
            log.info("Last name has a value and first name is empty");
            employees = employeeDAO.findByLastNameContainingIgnoreCase(lastsearch);

        }
        // bringing in the list of employees
        // there was a slight change from here instead of finding all employees, you can search by firstname now based off the DAO
        // List<Employee> employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(search, search);

        // challenge three (second parameter to the DAO)
        // List<Employee> employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstsearch, lastsearch);

        
        // challenge one
        // List<Employee> employees = employeeDAO.usingNativeQuery(search, search);

        // challenge two
        // List<Employee> employees = employeeDAO.usingJPAQuery(search, search);
        
        // finishing the employeecontroller
        response.addObject("employeesList", employees);
        
        // anything you add on to the search bar will be stored on the employee-search.jsp page
        response.addObject("firstsearchParameter", firstsearch);
        response.addObject("lastsearchParameter", lastsearch);

        return response;
    }
}
