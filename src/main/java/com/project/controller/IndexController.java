package com.project.controller;

import com.project.database.entity.dao.UsersDAO;
import com.project.database.entity.Users;
import com.project.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private AuthenticatedUserService authService;


    @Value("${spring.datasource.url}")
    private String variable;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView slash(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String email){

        ModelAndView response = new ModelAndView();
        response.setViewName("homepage");

        response.addObject("name", "David");

        // print out the incoming value in search variable

        System.out.println("Search parameter to page first_name     : " + firstName);
        System.out.println("Search parameter to page email : " + email);

        // add the search variable to the model, so it can be displayed on the page.

        response.addObject("firstNameKey", firstName);
        response.addObject("emailKey", email);

        response.addObject("search", firstName);

        List<Users> users = usersDAO.findByFirstName(firstName);
        for (Users u : users) {
            System.out.println(u.getFirstName());
        }
        response.addObject("users", users);

        if (authService.isAuthenticated()) {
            boolean isAdmin = authService.isUserInRole("ADMIN");
            log.debug(authService.getCurrentUsername() + " is current logged in and admin access = " + isAdmin);
            log.debug(authService.getCurrentUsers() + "");
        } else {
            log.debug("USER NOT LOGGED IN");
        }

        return response;
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public ModelAndView search() {
        System.out.println("Index controller search request");

        return null;
    }

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public ModelAndView users() {
        // this method is called when /users is in the URL
        log.info("Index controller users request method");

        ModelAndView response = new ModelAndView();
        response.setViewName("users");

        return response;
    }

    @RequestMapping(value = {"/usersSubmit"}, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView usersSubmit(@RequestParam(required = false) String firstName,
                                     @RequestParam(required = false) String email) {

        ModelAndView response = new ModelAndView();
        response.setViewName("users");

        log.info("Index controller course submit method");
        log.info("Users Submit : userName     : " + firstName);
        log.info("Users Submit : email : " + email);

        List<String> errormessages = new ArrayList<>();
        if (firstName == null || firstName.equals("")) {
            errormessages.add("The user name can not be empty");
        }

        if (email == null || email.equals("")) {
            errormessages.add("The email can not be empty");
        }

        if (!errormessages.isEmpty()) {
            // there is an error
            for (String error : errormessages) {
                log.info(error);
            }
            response.addObject("errors", errormessages);

            // by putting these incoming values back into the model we can prepopulate the
            // form so the user does not have to enter the values again.
            // we only want to do this in the case of an error.
            response.addObject("firstNameKey", firstName);
            response.addObject("emailKey", email);
        } else {
            Users users = new Users();
            users.setFirstName(firstName);
            users.setEmail(email);

            usersDAO.save(users);
        }

        return response;
    }

    @RequestMapping(value = {"/users/path/{id}"}, method = RequestMethod.GET)
    public Users pathVar(@PathVariable Integer id, HttpSession session){
        log.info("Incoming path variable" + id);

        Users u = usersDAO.findById(id);
        log.info("this is the user name " + u.getFirstName());

        if (session.getAttribute("key") == null) {
            log.info("Key not found in session");
            session.setAttribute("key", "value");
        } else {
            log.info("Key is in the session ");
        }

        return u;
    }

    @ResponseBody
    @RequestMapping(value = {"/users/all"}, method = RequestMethod.GET)
    public List<Users> allUsers(){
        log.error("This is an error");
        log.warn("This is a warning");
        log.info("This is info");
        log.debug("This is debug");

        System.out.println("This is never okay");

        List<Users> users = usersDAO.findAll();

        return users;
    }

    @RequestMapping(value = { "/fileupload" }, method = RequestMethod.GET)
    public ModelAndView fileupload() {
        ModelAndView response = new ModelAndView();
        response.setViewName("fileupload");

        return response;
    }

    @RequestMapping(value = { "/fileuploadSubmit" }, method = RequestMethod.POST)
    public ModelAndView fileuploadSubmit(@RequestParam MultipartFile file) throws IOException {
        ModelAndView response = new ModelAndView();
        response.setViewName("fileupload");

        log.debug("Filename  = " + file.getOriginalFilename());
        log.debug("File Size = " + file.getSize() + " bytes" );

        // step 1 : this will save the file to the disk .. within your project in the pub/images folder
        File targetFile = new File("./src/main/webapp/pub/images/" + file.getOriginalFilename());
        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
        log.debug("File Path = " + targetFile.getAbsolutePath() );

        // step 2 : this URL goes in the database as to where the image was saved
        String url = "/pub/images/" + file.getOriginalFilename();
        log.debug("File URL  = " + url);
        response.addObject("filename", url);

        return response;
    }

    @RequestMapping(value = { "/ajax" }, method = RequestMethod.GET)
    public ModelAndView ajax() {
        ModelAndView response = new ModelAndView();
        response.setViewName("ajax");

        return response;
    }

	@ResponseBody
	@RequestMapping(value = { "/ajaxcall" }, method = RequestMethod.GET)
    public String ajaxCall(@RequestParam String clickedValue) {
		log.debug("in the ajax call method : " + clickedValue);

		return "success from server : " + clickedValue;
	}


}
