package com.project.controller;

import com.project.model.request.OrRequest;
import com.project.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/api/orders")
    public Object getAll(){
        return ordersService.getAll();
    }
    @GetMapping("/api/orders/{cusId}")
    public Object getById(
            @PathVariable("cusId") int cusId
    ) {
        return ordersService.getById(cusId);
    }

    @PostMapping("/api/orders")
    public Object addOrder(
            @RequestBody OrRequest orRequest
    ) {
        return ordersService.addOrders(orRequest);
    }



}
