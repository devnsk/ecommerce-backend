package com.dev.ecommerce.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryImageService {

    Map uploadImage(MultipartFile file);
}
