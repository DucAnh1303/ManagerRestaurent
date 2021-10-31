package com.project.service;

import com.project.model.BaseResponse;
import com.project.model.entity.Product;
import com.project.model.request.ProRequest;
import com.project.repository.ProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProRepository proRepository;

    public Object getAll(){
       return proRepository.getAllProduct();
    }

    public Object getByIdProduct(int id){
        return proRepository.getByIdProduct(id);
    }

    public Object addProduct(ProRequest request){
        List<Product> productList=proRepository.addProduct(
                request.getProductName(),request.getProductType()
        );
        if (productList.size()>0){
            return new BaseResponse(400,"NOT SUCCESS");
        }
        else {
            Product product=new Product();
            product.setProductName(request.getProductName());
            product.setProductType(request.getProductType());
            product.setNumbers(request.getNumbers());
            product=proRepository.save(product);
            return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS",product);
        }

    }
    public Object updateNumbers(int id,int numbers){
        proRepository.updateProductNumbers(id, numbers);
        return new BaseResponse(200,"UPDATE SUCCESS");
    }
    public Object updateType(int id,String type){
        proRepository.updateProductType(id,type);
        return new BaseResponse(200,"UPDATE SUCCESS");
    }
    public Object updateName(int id,String name){
        proRepository.updateProductName(id,name);
        return new BaseResponse(200,"UPDATE SUCCESS");
    }

    public Object delete(int id){
        proRepository.delete(id);
        return new BaseResponse(200,"UPDATE SUCCESS");
    }
}
