package com.project.service;

import com.project.model.BaseResponse;
import com.project.model.entity.FoodMenu;
import com.project.model.request.FoodRequest;
import com.project.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public Object getAll(){
        return foodRepository.getAll();
    }

    public Object addFoodMenu(FoodRequest request){
        List<FoodMenu> foodMenuList=foodRepository.addFoodMenu(request.getFoodName());
        if (foodMenuList.size()>0){
            return new BaseResponse(BaseResponse.FAIL,"NOT EXISTED");
        }else {
            FoodMenu foodMenu=new FoodMenu();
            foodMenu.setFoodName(request.getFoodName());
            foodMenu.setFoodPrice(request.getFoodPrice());
            foodMenu.setFoodImage(request.getFoodImage());
            foodMenu=foodRepository.save(foodMenu);
            return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS",foodMenu);
        }

    }

    public Object updateFoodMenu(int id,String name,int price,String image ){
        foodRepository.updateMenu(id,name,price,image);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
    public Object deleteFood(int id){
        foodRepository.deleteMenu(id);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
}
