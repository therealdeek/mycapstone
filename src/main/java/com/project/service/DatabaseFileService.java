//package com.project.service;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//@Service
//public class DatabaseFileService {
//
//    @Autowired
//    private DatabaseFileRepository dbFileRepository;
//
//    public DatabaseFile storeFile(MultipartFile file) {
//
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        try {
//            // Checking for invalid characters
//            if (fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence" + fileName);
//            }
//
//            DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());
//
//            return dbFileRepository.save(dbFile);
//        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + "Try again!", ex);
//        }
//    }
//
//    public DatabaseFile getFile(String fileId) {
//        return dbFileRepository.findById(fileId)
//                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
//    }
//    }
//}
