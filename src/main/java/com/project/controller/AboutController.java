package com.project.controller;

import com.project.database.entity.dao.OrderDetailsDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller

public class AboutController {

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Value("${spring.datasource.url}")
    private String variable;

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public ModelAndView orderDetails() {
        // this method is called when /about is in the URL
        log.info("Index controller products request method");

        ModelAndView response = new ModelAndView();
        response.setViewName("about");

        return response;
    }
}
