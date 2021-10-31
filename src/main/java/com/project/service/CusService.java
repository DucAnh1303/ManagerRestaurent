package com.project.service;

import com.project.model.BaseResponse;
import com.project.model.entity.Customers;
import com.project.model.request.CusRequest;
import com.project.repository.CusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusService {
    @Autowired
    private CusRepository cusRepository;

    public Object getAll() {
        return cusRepository.getAll();
    }

    public List<Customers> getById(int id) {
        return  cusRepository.getById(id);
    }

    public Object addCustomers(CusRequest cusRequest) {
        List<Customers> customersList = cusRepository.addCustomers(cusRequest.getCusName());
        if (customersList.size() > 0) {
            return new BaseResponse(BaseResponse.FAIL, "NO EXISTED");
        } else {
            Customers customers = new Customers();
            customers.setCusName(cusRequest.getCusName());
            customers.setAddress(cusRequest.getAddress());
            customers.setEmail(cusRequest.getEmail());
            customers.setPhone(cusRequest.getPhone());
            customers.setDescriptions(cusRequest.getDescriptions());
            customers = cusRepository.save(customers);
            return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS",customers);

        }
    }

    public Object updateCustomer(String name,String des){
        cusRepository.updateCustomer(name,des);
        return new BaseResponse(200,"SUCCESS");
    }
    public Object deleteCustomer(int id){
        cusRepository.deleteCustomer(id);
        return new BaseResponse(200,"SUCCESS");
    }
}
