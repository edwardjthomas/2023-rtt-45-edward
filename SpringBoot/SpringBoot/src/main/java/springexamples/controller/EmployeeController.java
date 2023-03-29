package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstsearch, @RequestParam(required = false) String lastsearch) {
        // this log info here reflects inside intellij so don't get confused with where it prints out
        log.info("In the employee search controller method with search = " + lastsearch);
        ModelAndView response = new ModelAndView("employee/employee-search");

        // bringing in the list of employees
        // there was a slight change from here instead of finding all employees, you can search by firstname now based off the DAO
        // List<Employee> employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(search, search);

        // challenge three (second parameter to the DAO)
        List<Employee> employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstsearch, lastsearch);

        
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
