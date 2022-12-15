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
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/users/editusers", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam Integer id) {
        //incoming id is the id of the user we want to edit
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/create_user");

        Users users = usersDAO.findById(id);

        CreateUserForm form = new CreateUserForm();

        form.setFirstName(users.getFirstName());
        form.setLastName(users.getLastName());
        form.setEmail(users.getEmail());
        form.setAddress(users.getAddress());
        form.setCity(users.getCity());
        form.setState(users.getState());
        form.setZip(users.getZip());


        response.addObject("form", form);

        log.debug("This is in the GET method for edit user");
        return response;
    }

}
