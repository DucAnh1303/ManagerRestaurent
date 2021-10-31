package com.project.controller;

import com.project.model.request.EmployeeSalaryRequest;
import com.project.service.EmSaService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmSaController {
    @Autowired
    private EmSaService emSaService;

    @GetMapping("/api/employee/salary")
    public Object getAll() {
        return emSaService.getAll();
    }

    @GetMapping("/api/employee/salary/{id}")
    public Object getById(
            @PathVariable("id") int id
    ) {
        return emSaService.getById(id);
    }

    @PostMapping("/api/employee/salary")
    public Object addSalary(
            @RequestBody EmployeeSalaryRequest request
    ) {
        return emSaService.addSalary(request);
    }

    @PutMapping("/api/employee/salary")
    public Object update(
            @RequestParam("codeId") int codeId,
            @RequestParam("offday") int offday,
            @RequestParam("posisalary") double posisalary,
            @RequestParam("overtime") int overtime,
            @RequestParam("worktime") int worktime,
            @RequestParam("bonus") int bonus
    ) {
        return emSaService.update(codeId, offday, posisalary, overtime, bonus, worktime);
    }

    @PutMapping("/api/employee/salary/{codeId}/offday")
    public Object updateOffday(
            @PathVariable("codeId") int codeId,
            @RequestParam("offday") int offday
    ) {
        return emSaService.updateOffday(codeId, offday);
    }

    @PutMapping("/api/employee/salary/{codeId}/overtime")
    public Object updateOvertime(
            @PathVariable("codeId") int codeId,
            @RequestParam("overtime") int overtime
    ) {
        return emSaService.updateOvertime(codeId,overtime);
    }

    @PutMapping("/api/employee/salary/{codeId}/positionsalary")
    public Object updatePosition(
            @PathVariable("codeId") int codeId,
            @RequestParam("positionsalary") double positionsalary
    ) {
        return emSaService.updatePosition(codeId,positionsalary);
    }


}
