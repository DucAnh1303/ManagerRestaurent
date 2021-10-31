package com.project.service;

import com.project.model.BaseResponse;
import com.project.model.entity.Employee;
import com.project.model.request.EmployeeRequest;
import com.project.repository.EmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmService {
    @Autowired
    private EmRepository emRepository;

    public Object getAll(){
        return emRepository.getAll();
    }

    public Object getById(int id){
        return emRepository.getById(id);
    }

    public Object addEmployee(EmployeeRequest employeeRequest){
        List<Employee> employeeList=emRepository.addEmployee(employeeRequest.getName());
        if (employeeList.size()>0){
            return new BaseResponse(BaseResponse.FAIL,"NOT EXISTED");
        }else {
            Employee employee=new Employee();
            employee.setName(employeeRequest.getName());
            employee.setAddress(employeeRequest.getAddress());
            employee.setPhone(employeeRequest.getPhone());
            employee.setContractDate(employeeRequest.getContractDate());
            employee.setContractWork(employeeRequest.getContractWork());
            employee.setPosition(employeeRequest.getPosition());
            employee.setEmployeeUserId(employeeRequest.getEmployeeUserId());
            employee=emRepository.save(employee);
            return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS",employee);
        }
    }

    public Object updateEmployee(int id,EmployeeRequest employeeRequest){
        emRepository.updateEmployee(id,employeeRequest.getName(),employeeRequest.getAddress(),
                employeeRequest.getPhone(),employeeRequest.getContractDate(),
                employeeRequest.getContractWork(),employeeRequest.getPosition());
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
    public Object deleteById(int id){
        emRepository.deleteById(id);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
}
