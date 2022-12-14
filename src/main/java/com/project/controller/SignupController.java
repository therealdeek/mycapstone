package com.project.controller;

import com.project.database.entity.Products;
import com.project.database.entity.UserRole;
import com.project.database.entity.Users;
import com.project.database.entity.dao.UserRoleDAO;
import com.project.database.entity.dao.UsersDAO;
import com.project.form.CreateUserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

public class SignupController {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Value("${spring.datasource.url}")
    private String variable;

    @RequestMapping(value = "/createusers", method = RequestMethod.GET)
    public ModelAndView createUser() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/createusers");

        log.debug("This is in the GET method for create user");
        return response;
    }

    @RequestMapping(value = "/createusers", method = RequestMethod.POST)
    public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/createusers");
        log.debug("This is in the POST method for create user");

        log.debug(form.toString());

        for (ObjectError e : bindingResult.getAllErrors()) {
            log.debug(e.getObjectName() + " : " + e.getDefaultMessage());
        }

        if ( ! bindingResult.hasErrors()) {
            Users users = new Users();
            Products products = new Products();

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
