package com.project.controller;

import com.project.model.entity.Customers;
import com.project.model.request.CusRequest;
import com.project.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CusController {
    @Autowired
    private CusService service;

    @GetMapping("/api/customers")
    public Object getAll() {
        return service.getAll();
    }
    @GetMapping("/api/customers/{id}")
    public List<Customers> getById(
            @PathVariable("id") int id
    ){
        return service.getById(id);
    }
    @PostMapping("/api/customers")
    public Object addCustomers(
            @RequestBody CusRequest cusRequest
            ){
        return service.addCustomers(cusRequest);
    }

    @PutMapping("/api/customers")
    public Object update(
            @RequestParam("name") String name,
            @RequestParam("des") String des
    ){
        return service.updateCustomer(name,des);
    }

    @DeleteMapping("/api/customers/{id}")
    public Object deleteCustomers(
            @PathVariable("id") int id
    ){
        return service.deleteCustomer(id);
    }
}

