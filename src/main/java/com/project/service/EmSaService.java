package com.project.service;


import com.project.model.BaseResponse;
import com.project.model.entity.EmployeeSalary;
import com.project.model.request.EmployeeSalaryRequest;
import com.project.repository.EmSaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmSaService {
    @Autowired
    private EmSaRepository emSaRepository;

    public Object getAll(){
       return emSaRepository.getAll();
    }
    public Object getById(int id){
       return emSaRepository.getById(id);
    }
    public Object addSalary(EmployeeSalaryRequest request){
        List<EmployeeSalary> employeeSalaryList=emSaRepository.addSalary(
                request.getEmployeeCode()
        );
        if (employeeSalaryList.size()>0){
            return new BaseResponse(BaseResponse.FAIL,"NOT EXISTED");
        }else {
            EmployeeSalary employeeSalary=new EmployeeSalary();
            employeeSalary.setEmployeeCode(request.getEmployeeCode());
            employeeSalary.setFullday(request.getFullday());
            employeeSalary.setOffday(request.getOffday());
            employeeSalary.setHardSalary(request.getHardSalary());
            employeeSalary.setPositionSalary(request.getPositionSalary());
            employeeSalary.setOvertime(request.getOvertime());
            employeeSalary.setWorktime(request.getWorktime());
            employeeSalary.setBonus(request.getBonus());
            employeeSalary=emSaRepository.save(employeeSalary);
            return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS",employeeSalary);
        }
    }

    public Object update(int codeId,int offday,double posisalary,int overtime,int bonus,int worktime ){
        emSaRepository.updateSalary(codeId,offday,posisalary,overtime,bonus,worktime);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

    public Object updateOffday(int codeId,int offday){
        emSaRepository.updateOffday(codeId,offday);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

    public Object updateOvertime(int codeId,int overtime){
        emSaRepository.updateOverTime(codeId,overtime);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }


    public Object updatePosition(int codeId,double positionsalary){
        emSaRepository.updatePosition(codeId,positionsalary);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }




}
