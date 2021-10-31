package com.project.controller;

import com.project.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/image/upload")
    public Object updateImage(
            @RequestParam MultipartFile multipartFile
            ){
        return imageService.updateImage(multipartFile);
    }

    @GetMapping(
            value = "/image/{imageName}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImage(
            @PathVariable("imageName") String imageName
    ) {
        return imageService.getImage(imageName);
    }
}
