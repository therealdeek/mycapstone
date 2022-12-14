package com.project.controller;


import com.project.database.entity.Products;
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
    @RequestMapping(value = "/login", method = RequestMethod.GET)
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

}
