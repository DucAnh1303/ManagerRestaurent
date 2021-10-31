package com.project.repository;

import com.project.model.entity.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface FoodRepository  extends JpaRepository<FoodMenu ,Integer> {
    @Query(nativeQuery = true,
    value = "select *from project.food_menu")
    List<FoodMenu> getAll();

    @Query(nativeQuery = true,
    value = "select *from project.food_menu where project.food_menu.food_name = :foodname")
    List<FoodMenu> addFoodMenu(
            @Param("foodname") String foodname
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.food_menu set project.food_menu.food_name = :name,project.food_menu.food_price= :price, " +
            "project.food_menu.food_image = :image where food_menu.id = :id")
    void updateMenu(int id,String name,int price,String image);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "delete from project.food_menu where food_menu.id = :id")
    void deleteMenu(int id);



}
