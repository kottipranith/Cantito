package com.cantito.CantitoBackend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/img/";

    public String saveFile(MultipartFile file, String fileName) {
        try {

            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Create directories if not exist
            }
            String originalName = file.getOriginalFilename();
            String filePath = UPLOAD_DIR + fileName+originalName.substring(originalName.lastIndexOf("."));
            file.transferTo(new File(filePath));
            return filePath;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return "failed";
        }

    }
}
