package com.project.controller;


import com.project.database.entity.dao.ProductsDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProductsController {

    @Autowired
    private ProductsDAO productsDAO;

    @Value("${spring.datasource.url}")
    private String variable;

    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public ModelAndView products() {
        // this method is called when /products is in the URL
        log.info("Index controller products request method");

        ModelAndView response = new ModelAndView();
        response.setViewName("products");

        return response;
    }



}
