package com.project.service;

import com.project.model.BaseResponse;
import com.project.model.entity.ProductDetails;
import com.project.model.request.ProDetailsRequest;
import com.project.repository.ProDeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsService {
    @Autowired
    private ProDeRepository repository;

    public Object getAll(){
        return repository.getAll();
    }
    public Object getById(int itemId){
        return repository.getById(itemId);
    }
    public Object addProductDetails(ProDetailsRequest detailsRequest){
        List<ProductDetails> productDetailsList=repository.addProductDetails(
                detailsRequest.getItemCode()
        );
        if (productDetailsList.size()>0){
            return new BaseResponse(400,"NOT SUCCESS");
        }else {
            ProductDetails productDetails=new ProductDetails();
            productDetails.setItemCode(detailsRequest.getItemCode());
            productDetails.setPlaceImport(detailsRequest.getPlaceImport());
            productDetails.setPrice(detailsRequest.getPrice());
            productDetails=repository.save(productDetails);
            return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS",productDetails);
        }
    }

    public Object updatePrice(int itemId,int price){
        repository.updatePrice(itemId,price);
        return new BaseResponse(200,"SUCCESS");
    }

    public Object updatePlace(int itemId,String place){
        repository.updatePlace(itemId,place);
        return new BaseResponse(200,"SUCCESS");
    }
    public Object deleteById(int itemId){
        repository.deleteById(itemId);
        return new BaseResponse(200,"SUCCESS");
    }
}
