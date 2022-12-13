package com.project.controller;


import com.project.database.entity.dao.UserRoleDAO;
import com.project.database.entity.dao.UsersDAO;
import com.project.database.entity.UserRole;
import com.project.database.entity.Users;
import com.project.form.CreateUserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    // this method is request mapping to show the actual login JSP page.
    // the URL here in the mapping is the same URL configured in spring security .loginPage
    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/login");
        return response;
    }

    // in this situation we are returning the view name as a string without a model
    @RequestMapping(value = "/users/example", method = RequestMethod.GET)
    public String example() {
        // so if the method returns just a string then that is considered to be the view name
        return "login_pages/login";

        // this is not to be confused with the @ResponseBody annotation, which would then return the string
        // directely to the browser with no view
    }


    @RequestMapping(value = "/users/createusers", method = RequestMethod.GET)
    public ModelAndView createUser() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/create_user");

        log.debug("This is in the GET method for create user");
        return response;
    }

    @RequestMapping(value = "/users/createusers", method = RequestMethod.POST)
    public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/create_user");
        log.debug("This is in the POST method for create user");

        log.debug(form.toString());

        for (ObjectError e : bindingResult.getAllErrors()) {
            log.debug(e.getObjectName() + " : " + e.getDefaultMessage());
        }

        if ( ! bindingResult.hasErrors()) {
            Users users = new Users();

            String encodedPassword = passwordEncoder.encode(form.getPassword());
            users.setPassword(encodedPassword);

            users.setFirstName(form.getFirstName());
            users.setLastName(form.getLastName());
            users.setEmail(form.getEmail());
            users.setAddress(form.getAddress());
            users.setCity(form.getCity());
            users.setState(form.getState());
            users.setZip(form.getZip());
            users.setCreateDate(new Date());

            usersDAO.save(users);

            UserRole ur = new UserRole();
            ur.setRoleName("USER");
            ur.setUserId(users.getId());

            userRoleDao.save(ur);


        } else {
            response.addObject("bindingResult", bindingResult);
            response.addObject("com/project/form", form);
        }

        return response;
    }
}
