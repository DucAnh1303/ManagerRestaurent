package com.project.service;

import com.project.model.BaseResponse;
import com.project.model.entity.FoodMenu;
import com.project.model.entity.Orders;
import com.project.model.request.FoodRequest;
import com.project.model.request.OrRequest;
import com.project.repository.FoodRepository;
import com.project.repository.OrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrRepository orRepository;


    public Object getById(int cusId) {
        return orRepository.getById(cusId);
    }

    public Object addOrders(OrRequest request) {
        List<Orders> ordersList = orRepository.addOrders(
                request.getCusId()
        );
        if (ordersList.size() > 0) {
            return new BaseResponse(400, "NOT SUCCESS");
        } else {
            Orders or = new Orders();
            or.setCusId(request.getCusId());
            or = orRepository.save(or);
            return new BaseResponse(BaseResponse.SUCCESS, "SUCCESS", or);
        }


    }
}
