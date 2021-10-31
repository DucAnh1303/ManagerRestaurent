package com.project.service;

import com.project.model.BaseResponse;
import com.project.model.entity.OrdersDetails;
import com.project.model.request.OrDeRequest;
import com.project.repository.OrDetailsRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersDetailsService {
    @Autowired
    private OrDetailsRepository detailsRepository;

    public Object getAll(){
     return    detailsRepository.getAll();
    }

    public Object getById(int cusId){
     return    detailsRepository.getById(cusId);
    }

    public Object addOrdersDetails(OrDeRequest request){
        List<OrdersDetails>ordersDetailsList=detailsRepository.addOrderDetails(
                request.getOrdersId(), request.getFoodId()
        );
        if (ordersDetailsList.size()>0){
            return new BaseResponse(400,"NOT SUCCESS");
        }else {
            OrdersDetails ordersDetails=new OrdersDetails();
            ordersDetails.setCusName(request.getCusName());
            ordersDetails.setEmail(request.getEmail());
            ordersDetails.setPhone(request.getPhone());
            ordersDetails.setOrdersId(request.getOrdersId());
            ordersDetails.setFoodId(request.getFoodId());
            ordersDetails.setNumbers(request.getNumbers());
            ordersDetails=detailsRepository.save(ordersDetails);
            return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS" ,ordersDetails);
        }
    }

    public  Object update(int cusId,int foodId,String name,String email,String phone,int numbers){
        detailsRepository.updateOrdersDetails(cusId,foodId,name,email,phone,numbers);
        return new BaseResponse(BaseResponse.SUCCESS,"UPDATE SUCCESS");
    }

    public Object updateNameCustomers(int cusId,String name,String email,String phone){
        detailsRepository.updateOrdersDetailsNameCustomers(cusId,name,email,phone);
        return new BaseResponse(200,"UPDATE SUCCESS");
    }
    public Object updateNumbers(int cusId,int foodId,int numbers){
        detailsRepository.updateOrdersDetailsNumbers(cusId,foodId,numbers);
        return new BaseResponse(200,"UPDATE SUCCESS");
    }

    public Object deleteByCusIdAndFoodId(int cusId,int foodId){
        detailsRepository.deleteByCusIdAndFoodId(cusId,foodId);
        return new BaseResponse(200,"UPDATE SUCCESS");
    }

    public Object deleteByCusId(int cusId){
        detailsRepository.deleteByCusId(cusId);
        return new BaseResponse(200,"UPDATE SUCCESS");
    }

}
