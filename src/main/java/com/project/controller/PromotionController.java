package com.project.controller;

import com.project.model.request.PromotionRequest;
import com.project.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionController {
    @Autowired
    private PromotionService service;

    @GetMapping("/api/promotion")
    public Object getAll() {
        return service.getAll();
    }

    @PostMapping("/api/promotion")
    public Object addPromotion(
            @RequestBody PromotionRequest request
    ) {
        return service.addPromotion(request);
    }
}
