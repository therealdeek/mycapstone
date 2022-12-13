//package com.project.controller;
//
//import com.project.service.DatabaseFileService;
//import org.apache.catalina.connector.Response;
//import org.hibernate.boot.model.relational.Database;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class FileUploadController {
//
//    @Autowired
//    private DatabaseFileService fileStorageService;
//
//    @PostMapping("/uploadFile")
//    public Response uploadFile(@RequestParam("file") MultipartFile file) {
//        DatabaseFile fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName.getFileName())
//                .toUriString();
//
//        return new Response(fileName.getFileName(), fileDownloadUrl,
//                file.getContentType(), file.getSize());
//    }
//
//    @PostMapping("/uploadMultipleFiles")
//    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }
//}
