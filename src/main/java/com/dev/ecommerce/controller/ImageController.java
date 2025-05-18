package com.dev.ecommerce.controller;


import com.dev.ecommerce.service.CloudinaryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
public class ImageController {

    @Autowired
    private CloudinaryImageService cloudinaryImageService;

    @PostMapping("/image")
    public ResponseEntity<Map> upload(@RequestParam("image") MultipartFile file) {
        Map data = this.cloudinaryImageService.uploadImage(file);
        return new ResponseEntity<>(data, HttpStatus.OK);

    }



}
