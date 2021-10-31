package com.project.controller;

import com.project.model.entity.ProductDetails;
import com.project.model.request.OrDeRequest;
import com.project.model.request.ProDetailsRequest;
import com.project.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductDetailsController {
    @Autowired
    private ProductDetailsService detailsService;


    @GetMapping("/api/product/details")
    public Object getAll(){
        return detailsService.getAll();
    }
     @GetMapping("/api/product/details/{itemId}")
    public Object getById(
            @PathVariable("itemId")int iemId
     ){
        return detailsService.getById( iemId);
    }

    @PostMapping("/api/product/details")
    public Object addProductDetails(
            @RequestBody ProDetailsRequest detailsRequest
    ){
        return detailsService.addProductDetails(detailsRequest);
    }

    @PutMapping("/api/product/details/{itemId}/price")
    public Object updatePrice(
            @PathVariable("itemId")int itemId,
            @RequestParam("price")int price
    ){
        return detailsService.updatePrice(itemId,price);
    }

    @PutMapping("/api/product/details/{itemId}/place")
    public Object updatePlace(
            @PathVariable("itemId")int itemId,
            @RequestParam("place")String place
    ){
        return detailsService.updatePlace(itemId,place);
    }
    @DeleteMapping("/api/product/details/{itemId}")
    public Object deleteById(
            @PathVariable("itemId")int itemId
    ){
        return detailsService.deleteById(itemId);
    }


}
