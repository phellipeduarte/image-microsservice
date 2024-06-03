package com.example.image.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Service
public class ImageService {

    @Autowired
    Cloudinary cloudinary;

    public Object upload(MultipartFile multipartFile) {

        Map params1 = ObjectUtils.asMap(
                "use_filename", false,
                "unique_filename", true,
                "overwrite", true
        );
        try {
            Path path = Files.createTempFile("temp", multipartFile.getOriginalFilename());
            File file = path.toFile();
            multipartFile.transferTo(file);
            Map uploadResult = cloudinary.uploader().upload(file, params1);
            file.delete();
            return uploadResult.get("url");
        } catch (IOException exception){
            throw new RuntimeException("Error while uploading file.");
        }

    }


}