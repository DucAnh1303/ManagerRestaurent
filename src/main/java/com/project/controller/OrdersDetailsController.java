package com.project.controller;

import com.project.model.request.OrDeRequest;
import com.project.service.OrdersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersDetailsController {
    @Autowired
    private OrdersDetailsService deService;

    @GetMapping("/api/orders/details")
    public Object getAll(){
        return deService.getAll();
    }

    @GetMapping("/api/orders/details/{cusId}")
    public Object getById(
            @PathVariable("cusId") int cusId
    ){
        return deService.getById(cusId);
    }

    @PostMapping("/api/orders/details")
    public Object addOrdersDetails(
            @RequestBody OrDeRequest request
            ){
        return deService.addOrdersDetails(request);
    }

    @PutMapping("/api/orders/details/{cusId}/{foodId}")
    public Object updateOrderDetails(
            @PathVariable("cusId") int cusId,
            @PathVariable("foodId") int foodId,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("numbers") int numbers
    ){
        return deService.update(cusId,foodId,name,email,phone,numbers);
    }
    @PutMapping("/api/orders/details/{cusId}")
    public Object updateOrderDetails(
            @PathVariable("cusId") int cusId,
            @RequestParam("name") String name,
            @RequestParam("email")String email,
            @RequestParam("phone")String phone
    ){
        return deService.updateNameCustomers(cusId,name,email,phone);
    }

    @DeleteMapping("/api/orders/details/{cusId}/{foodId}")
    public Object deleteCusIdAndFoodId(
            @PathVariable("cusId") int cusId,
            @PathVariable("foodId") int foodId
    ){
        return deService.deleteByCusIdAndFoodId(cusId,foodId);
    }

    @DeleteMapping("/api/orders/details/{cusId}")
    public Object deleteCusId(
            @PathVariable("cusId") int cusId
    ){
        return deService.deleteByCusId(cusId);
    }
}
