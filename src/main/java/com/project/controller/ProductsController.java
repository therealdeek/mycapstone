package com.project.controller;


import com.project.database.entity.Products;
import com.project.database.entity.dao.ProductsDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ProductsController {

    @Autowired
    private ProductsDAO productsDAO;

    @Value("${spring.datasource.url}")
    private String variable;

    @GetMapping(value = "/products")
    public ModelAndView search(@RequestParam(value = "price", required = false) Integer price) {
        ModelAndView response = new ModelAndView();
        response.setViewName("products");
        List<Products> products = productsDAO.findByPrice(price);
        response.addObject("products", products);

        return response;

    }
}
