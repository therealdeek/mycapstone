package com.project.controller;

import java.util.List;

import com.project.database.dao.UsersDAO;
import com.project.database.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    // the below is used when using slf4j - this is considered the old way
    // this can be used to put in all classes, but do not forget to change the name before .class
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UsersDAO usersDAO;

    @Value("${spring.datasource.url}")
    private String variable;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView slash(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String email) {

        ModelAndView response = new ModelAndView();
        response.setViewName("index");

        response.addObject("name", "David");

        // print out the incoming value in search variable

        System.out.println("Search parameter to page first_name     : " + firstName);
        System.out.println("Search parameter to page email : " + email);

        // add the search variable to the model, so it can be displayed on the page.

        response.addObject("firstNameKey", firstName);
        response.addObject("emailKey", email);

        return response;

    }



    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public ModelAndView search() {
        System.out.println("Index controller search request");

        return null;
    }

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public ModelAndView users() {
        // this method is called when /course is in the URL
        log.info("Index controller users request method");

        ModelAndView response = new ModelAndView();
        response.setViewName("users");

        return response;
    }

    @RequestMapping(value = {"/email"}, method = RequestMethod.GET)
    public ModelAndView email() {
        log.info("This is the email");

        ModelAndView response = new ModelAndView();
        response.setViewName("email");

        return response;
    }

    @RequestMapping(value = {"/city"}, method = RequestMethod.GET)
    public ModelAndView courseSubmit(@RequestParam(required = false) String firstName,
                                     @RequestParam(required = false) String city) {

        ModelAndView response = new ModelAndView();
        response.setViewName("users");

        log.info("Index controller users submit method");
        log.info("Users Submit : firstName     : " + firstName);
        log.info("Users Submit : city : " + city);

        String errormessage = "";
        boolean error = false;
        if (firstName == null || firstName.equals("")) {
            errormessage = errormessage + "The first name can not be empty";
            error = true;
        }

        if (firstName == null || firstName.equals("")) {
            errormessage = errormessage + "The first name can not be empty";
            error = true;
        }

        if (error) {
            // there is an error
            log.info(errormessage);
            response.addObject("errors", errormessage);
        } else {
            Users users = new Users();
            users.setFirstName(firstName);
            users.setCity(city);

            usersDAO.save(users);

        }

        return response;
    }

    @ResponseBody
    @RequestMapping(value = {"/users/{id}"}, method = RequestMethod.GET)
    public Users pathVar(@PathVariable Integer id, HttpSession session) {
        log.info("Incoming path variable = " + id);

        Users u = usersDAO.findById(id);
        log.info("This is the user first name: " + u.getFirstName());

        if (session.getAttribute("key") == null) {
            log.info("Key not found in session. ");
            session.setAttribute("key", "value");
        } else {
            log.info("Key is in the session. ");
        }

        return u;

    }

    @ResponseBody
    @RequestMapping(value = {"/course/all"}, method = RequestMethod.GET)
    public List<Users> allUsers() {
        log.error("this is an error");
        log.warn("this is a warning");
        log.info("this is info");
        log.debug("this is debug");

        System.out.println("This is never okay!"); //this doesn't provide any information but the print out only

        List<Users> users = usersDAO.findAll();

        return users;
    }

}
