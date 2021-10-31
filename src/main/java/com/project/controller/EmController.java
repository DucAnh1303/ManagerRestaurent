package com.project.controller;

import com.project.model.request.EmployeeRequest;
import com.project.service.EmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmController {
    @Autowired
    private EmService emService;

    @GetMapping("/api/employee")
    public Object getAll() {
        return emService.getAll();
    }

    @GetMapping("/api/employee/{id}")
    public Object getById(
            @PathVariable("id") int id
    ) {
        return emService.getById(id);
    }

    @PostMapping("/api/employee")
    public Object addEmployee(
            @RequestBody EmployeeRequest employeeRequest
    ) {
        return emService.addEmployee(employeeRequest);
    }

    @PutMapping("/api/employee/{id}")
    public Object updateEmPloyee(
            @PathVariable("id")int id,
            @RequestBody EmployeeRequest employeeRequest
    ){
        return emService.updateEmployee(id,employeeRequest);
    }

    @DeleteMapping("/api/employee/{id}")
    public Object deleteById(
            @PathVariable("id") int id
    ){
        return emService.deleteById(id);
    }
}
