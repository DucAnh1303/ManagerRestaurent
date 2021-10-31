package com.project.controller;

import com.project.model.request.FoodRequest;
import com.project.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/api/food/menu")
    public Object getALL(){
        return foodService.getAll();
    }
    @PostMapping ("/api/food/menu")
    public Object addFoodMenu(
            @RequestBody FoodRequest foodRequest
            ){
        return foodService.addFoodMenu(foodRequest);
    }

    @PutMapping("/api/food/menu")
    public Object updateFoodMenu(
           @RequestParam("id")int id,
           @RequestParam("name")String name,
           @RequestParam("price")int price,
           @RequestParam("image")String image
    ){
        return foodService.updateFoodMenu(id,name,price,image);
    }
    @DeleteMapping("/api/food/menu/{id}")
    public Object deleteFoodMenu(
            @PathVariable("id") int id
    ){
        return foodService.deleteFood(id);
    }


}
