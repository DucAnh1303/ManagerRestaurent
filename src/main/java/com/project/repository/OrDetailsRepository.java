package com.project.repository;


import com.project.model.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrDetailsRepository  extends JpaRepository<OrdersDetails,Integer> {
    @Query(nativeQuery = true,
    value = "select ordersdetails.id, ordersdetails.cus_name,ordersdetails.email,ordersdetails.phone, " +
            "ordersdetails.orders_id,ordersdetails.food_id, ordersdetails.numbers,(food_menu.food_price) as price, " +
            "(ordersdetails.numbers *food_menu.food_price) as total_price,ordersdetails.created_at " +
            "from project.ordersdetails join project.food_menu on project.ordersdetails.food_id=project.food_menu.id")
    List<OrdersDetails> getAll();
    @Query(nativeQuery = true,
    value = "select ordersdetails.id, ordersdetails.cus_name,ordersdetails.email,ordersdetails.phone, " +
            "ordersdetails.orders_id,ordersdetails.food_id, ordersdetails.numbers,(food_menu.food_price) as price, " +
            "(ordersdetails.numbers *food_menu.food_price) as total_price,ordersdetails.created_at " +
            "from project.ordersdetails join project.food_menu on project.ordersdetails.food_id=project.food_menu.id " +
            "where ordersdetails.orders_id = :cusId")
    List<OrdersDetails> getById(@Param("cusId") int cusId);


    @Query(nativeQuery = true,
    value = "select ordersdetails.id,ordersdetails.cus_name,ordersdetails.email,ordersdetails.phone, " +
            "ordersdetails.orders_id,ordersdetails.food_id, ordersdetails.numbers,(food_menu.food_price) as price, " +
            "(ordersdetails.numbers *food_menu.food_price) as total_price,ordersdetails.created_at " +
            "from project.ordersdetails join project.food_menu on project.ordersdetails.food_id=project.food_menu.id " +
            "where ordersdetails.orders_id = :cusId and  ordersdetails.food_id = :foodId" )
    List<OrdersDetails> addOrderDetails(
            @Param("cusId") int cusId,
            @Param("foodId") int foodId

    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.ordersdetails set " +
            "ordersdetails.cus_name = :name, ordersdetails.email= :email,ordersdetails.phone = :phone, " +
            "ordersdetails.numbers= :numbers where ordersdetails.orders_id = :cusId and " +
            "ordersdetails.food_id = :foodId")
    void updateOrdersDetails(int cusId,int foodId,String name,String email,String phone,int numbers);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update project.ordersdetails set " +
                    "ordersdetails.cus_name = :name,ordersdetails.email = :email, " +
                    "ordersdetails.phone = :phone " +
                    "where ordersdetails.orders_id = :cusId ")
    void updateOrdersDetailsNameCustomers(int cusId,String name,String email,String phone);



    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update project.ordersdetails set " +
                    "ordersdetails.numbers = :numbers where ordersdetails.orders_id = :cusId and " +
                    "ordersdetails.food_id = :foodId")
    void updateOrdersDetailsNumbers(int cusId,int foodId,int numbers);


    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "delete from project.productdetails where " +
                    "project.ordersdetails.orders_id = :cusId and project.ordersdetails.food_id = :foodId")
    void deleteByCusIdAndFoodId(int cusId,int foodId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "delete from project.productdetails where " +
                    "project.ordersdetails.orders_id = :cusId ")
    void deleteByCusId(int cusId);

}
