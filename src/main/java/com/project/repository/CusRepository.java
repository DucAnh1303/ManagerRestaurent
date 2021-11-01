package com.project.repository;

import com.project.model.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CusRepository extends JpaRepository<Customers, Integer> {
    @Query(nativeQuery = true,
    value = "select *from project.customers " )
    List<Customers> getAll(
    );

    @Query(nativeQuery = true,
    value = "select *from project.customers where   customers.id = :id")
    List<Customers> getById(
            @Param("id") int id
    );


    @Query(nativeQuery = true,
    value = "select * from project.customers where customers.cus_name = :name")
    List<Customers> addCustomers(
            @Param("name")String name
    );


    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.customers set project.customers.descriptions = :des " +
            "where customers.cus_name = :name")
    void updateCustomer(String name,String des);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "delete  from project.customers where customers.id = :id")
    void deleteCustomer(int id);

}
