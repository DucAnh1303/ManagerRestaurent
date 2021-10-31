package com.project.repository;

import com.project.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrRepository extends JpaRepository<Orders, Integer> {

    @Query(nativeQuery = true,
    value = "select project.orders.id, project.orders.cus_id,count(project.ordersdetails.food_id) " +
            "as sum_food,sum(project.ordersdetails.numbers) as numbers,project.orders.created_at " +
            "from project.orders join project.ordersdetails on project.orders.cus_id=project.ordersdetails.orders_id " +
            "where project.orders.cus_id = :cusId ")
List<Orders> getById(
        @Param("cusId") int cusId
    );

    @Query(nativeQuery = true,
    value = "select project.orders.id, project.orders.cus_id,count(project.ordersdetails.food_id) " +
            "as sum_food,sum(project.ordersdetails.numbers) as numbers,project.orders.created_at  " +
            "from project.orders join project.ordersdetails on project.orders.cus_id=project.ordersdetails.orders_id " +
            "where project.orders.cus_id = :cusId ")
List<Orders> addOrders(
        @Param("cusId") int cusId
    );



}
