package springexamples.controller;

import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.dao.OfficeDAO;
import springexamples.database.entity.Employee;
import springexamples.database.entity.Office;
import springexamples.formbeans.EmployeeFormBean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
// class controller level requestmapping
// makes it so you have to have "/employee" in front of the links that go to all
// pages of that respective controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDao;

    // example of an @PathVariable
    // @PathVariable is another annotation that is used to retrieve/extract data
    // from the URL.
    // Spring allows us to use multiple @PathVariable annotations in the same method
    // as shown in below syntax:
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");

        log.debug("In employee detail controller method with id = " + id);
        Employee employee = employeeDAO.findById(id);

        // this allows for the employee details to appear on the details page
        response.addObject("employee", employee);

        log.debug(employee + "");
        return response;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        // this log info here reflects inside intellij so don't get confused with where
        // it prints out
        log.debug("In the employee search controller method with firstName = " + firstName + " lastName = " + lastName);
        ModelAndView response = new ModelAndView("employee/search");

        List<Employee> employees = new ArrayList<>();

        // an example of using commons.lang3's StringUtils
        // if (!StringUtils.isEmpty(lastName)) {
        // }

        // check if both firstName and lastName have a value
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            // if so run the query that works with both values
            log.debug("Both first name and last name have a value");
            employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName, lastName);
        }

        // check if the first name is not empty and the last name is empty
        if (!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
            // we run our query that checks the first name field only
            log.debug("First name has a value and last name is empty");
            employees = employeeDAO.findByFirstNameContainingIgnoreCase(firstName);

        }

        // check if the first name is empty and the last name is not empty
        if (StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            // if so run the query that works with both values
            log.debug("Last name has a value and first name is empty");
            employees = employeeDAO.findByLastNameContainingIgnoreCase(lastName);

        }
        // bringing in the list of employees
        // there was a slight change from here instead of finding all employees, you can
        // search by firstname now based off the DAO
        // List<Employee> employees =
        // employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(search,
        // search);

        // challenge three (second parameter to the DAO)
        // List<Employee> employees =
        // employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName,
        // lastName);

        // challenge one
        // List<Employee> employees = employeeDAO.usingNativeQuery(search, search);

        // challenge two
        // List<Employee> employees = employeeDAO.usingJPAQuery(search, search);

        // finishing the employeecontroller
        response.addObject("employeesList", employees);

        // anything you add on to the search bar will be stored on the search.jsp page
        response.addObject("firstsearchParameter", firstName);
        response.addObject("lastsearchParameter", lastName);

        return response;
    }

    // GetMapping shortens RequestMapping where you simply have to use the @ call
    // and put the /page inside the ()
    // shortcut for @RequestMapping (method = RequestMethod.GET).
    // <!-- in conjunction with EmployeeFormBean.java we get things working -->
    @GetMapping("/create")
    public ModelAndView create(EmployeeFormBean form) {
        ModelAndView response = new ModelAndView("employee/create");

        log.debug("In the employee / create controller method.");
        log.debug(form.toString());

        List<Office> offices = officeDao.getAllOffices();
        // this is an interaction with the create page for the select for offices
        response.addObject("offices", offices);

        return response;
    }

    // this could be done as one function but we are going to be shown how to do it
    // in two functions
    // this is an example of doing an edit on a webpage
    // this way uses pathvariable like {id}
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/create");

        log.debug("In the employee / edit controller method.");

        Employee emp = employeeDAO.findById(id);
        EmployeeFormBean form = new EmployeeFormBean();

        // this sets the emplyee id and all other employee fields on the form object to pass through the jsp through the model
        // allows us to set the id for the edit on the create.jsp page
        form.setId(emp.getId());
        // in the case of an edit page, make sure that the form is being filled out by
        // the emp variable so that the empty spaces are properly populated
        form.setEmail(emp.getEmail());
        form.setFirstName(emp.getFirstName());
        form.setLastName(emp.getLastName());
        form.setExtension(emp.getExtension());
        form.setJobTitle(emp.getJobTitle());
        // insert profileimage here
        form.setProfileImage(emp.getProfileImage());
        form.setVacationHours(emp.getVacationHours());
        form.setOfficeId(emp.getOfficeId());

        // interaction with the edit page for the select out of the form?
        response.addObject("form", form);

        List<Office> offices = officeDao.getAllOffices();
        // this is an interaction with the create page for the select for offices
        response.addObject("offices", offices);

        return response;
    }

    // getting form submission button to work more efficiently by creating a
    // createSubmit page on the employee/create page
    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(EmployeeFormBean form) {
        ModelAndView response = new ModelAndView("employee/create");

        log.debug("!!!!!!!!!!!!!!!!!!!!!!!!!! In the employee / create controller method.");
        log.debug(form.toString());

        // this would be creating a new database entity
        // which will populate it with the incoming data from the submitted form
        Employee emp = new Employee();

        // creating a condition to where emp will get the id from the form if the form's
        // id is not equal to null and if it's greater than 0
        // initally the emp object will be empty before running through this statement
        // afterwards, it will run through and fill the emp object of whatever was
        // entered
        if (form.getId() != null && form.getId() > 0) {
            emp = employeeDAO.findById(form.getId());
        }

        emp.setEmail(form.getEmail());
        emp.setFirstName(form.getFirstName());
        emp.setLastName(form.getLastName());
        emp.setExtension(form.getExtension());
        emp.setJobTitle(form.getJobTitle());
        emp.setVacationHours(form.getVacationHours());
        // insert profile image here
        emp.setProfileImage(form.getProfileImage());
        emp.setOfficeId(form.getOfficeId());

        employeeDAO.save(emp);
        // to make sure this reflects the changes made on the page
        response.addObject("form", form);

        // if you haven't done it already, copy these two lines of code to retain the
        // submission inside the createSubmit page
        List<Office> offices = officeDao.getAllOffices();
        // this is an interaction with the create page for the select for offices
        response.addObject("offices", offices);

        return response;
    }
}
