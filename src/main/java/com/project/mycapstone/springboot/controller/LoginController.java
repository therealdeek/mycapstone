package com.project.mycapstone.springboot.controller;


import com.project.mycapstone.springboot.database.dao.UsersDAO;
import com.project.mycapstone.springboot.database.entity.Users;
import form.CreateUserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "users/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/login");
        return response;
    }

    @RequestMapping(value = "/users/createusers", method = RequestMethod.GET)
    public ModelAndView createUser(CreateUserForm form) {
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
            log.debug(e.getDefaultMessage());
        }

        if (!bindingResult.hasErrors()) {

            Users users = new Users();

            users.setFirstName(form.getFirstName());
            users.setLastName(form.getLastName());
            users.setEmail(form.getEmail());
            users.setPassword(form.getPassword());
            users.setAddress(form.getAddress());
            users.setCity(form.getCity());
            users.setState(form.getState());
            users.setZip(form.getZip());
            users.setCreateDate(new Date());

            usersDAO.save(users);

        } else {
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        }
        return response;
    }
}
