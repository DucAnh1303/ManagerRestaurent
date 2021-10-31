package com.project.controller;

import com.project.model.request.ProRequest;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/product")
    public Object getAll(){
        return productService.getAll();
    }

    @GetMapping("/api/product/{id}")
    public Object getByIdProduct(
            @PathVariable("id")int id
    ){
        return productService.getByIdProduct(id);
    }

    @PostMapping ("/api/product")
    public Object addProduct(
            @RequestBody ProRequest proRequest
            ){
        return productService.addProduct(proRequest);
    }

    @PutMapping ("/api/product/name/{id}")
    public Object updateProductName(
            @PathVariable("id") int id,
            @RequestParam("name") String name
    ){
        return productService.updateName(id,name);
    }

    @PutMapping ("/api/product/numbers/{id}")
    public Object updateProductNumbers(
            @PathVariable("id") int id,
            @RequestParam("numbers") int numbers
            ){
        return productService.updateNumbers(id,numbers);
    }
    @PutMapping ("/api/product/type/{id}")
    public Object updateProductType(
            @PathVariable("id") int id,
            @RequestParam("type") String type
    ){
        return productService.updateType(id,type);
    }
    @DeleteMapping("/api/product/{id}")
    public Object deleteById(
            @PathVariable("id")int id
    ){
        return productService.delete(id);
    }
}
