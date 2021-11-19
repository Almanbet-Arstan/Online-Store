package com.example.onlinestore.controller;

import com.example.onlinestore.entity.Image;
import com.example.onlinestore.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAll() {
        return imageService.getAll();
    }

    @PostMapping
    public Image saveImage(@RequestParam(name = "file") MultipartFile file) {
        return imageService.saveImage(file);
    }
}
