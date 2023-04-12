package springexamples.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.dao.UserDAO;
import springexamples.database.dao.UserRoleDAO;
import springexamples.database.entity.User;
import springexamples.database.entity.UserRole;
import springexamples.formbeans.CreateUserFormBean;
import springexamples.security.AuthenticatedUserService;

// this is not considered a rest controller
// RESTFul applications typically return data in JSON or XML format
// This is an MVC
//
@Slf4j
@Controller
public class SlashController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

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

    // you can test spring security here on the signup page (4/7)
    // added HttpSession session for AuthenticatedUserService addon (4/11)
    @PostMapping("/signup")
    public ModelAndView setup(CreateUserFormBean form, HttpSession session) {

        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller method.");

        User user = new User();
        user.setEmail(form.getEmail());
        user.setFullName(form.getFullName());

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

        // very important that this line of code is after both the user and user role is saved to the database (4/11) in conjunction with AuthenticatedUserService
        // authenticate the user that was just created
        // session that was mention above is used here
        authenticatedUserService.changeLoggedInUsername(session, form.getEmail(), form.getPassword());

        log.debug(form.toString());

        return response;
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ModelAndView bootstrap() {
        log.debug("In the bootstrap controller method.");

        ModelAndView response = new ModelAndView("bootstrap");
        return response;
    }
}
