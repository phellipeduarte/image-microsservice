package com.example.image.controllers;

import com.example.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping()
    public ResponseEntity<Object> saveImage(@RequestParam("file") MultipartFile file){
        return ResponseEntity.ok().body(imageService.upload(file));
    }
}
