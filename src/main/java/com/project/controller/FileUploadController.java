package com.project.controller;

import com.project.database.entity.dao.ProductsDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private ProductsDAO productsDAO;

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
}
