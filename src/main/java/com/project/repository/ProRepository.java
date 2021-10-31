package com.project.repository;

import com.project.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProRepository extends JpaRepository<Product,Integer> {
    @Query(nativeQuery = true,
    value = "select * from project.product")
    List<Product> getAllProduct();

    @Query(nativeQuery = true,
    value = "select * from project.product where product.id = :id")
    List<Product> getByIdProduct(
            @Param("id") int id
    );


    @Query(nativeQuery = true,
            value = "select * from project.product where product_name= :productname " +
                    "and product_type = :type")
    List<Product> addProduct(
            @Param("productname") String productname,
            @Param("type") String type
    );


    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.product set product.numbers = :numbers " +
            "where product.id = :id")
    void updateProductNumbers(int id,int numbers);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.product set product.product_type = :type " +
            "where product.id = :id")
    void updateProductType(int id, String type);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.product set product.product_name = :name " +
            "where product.id = :id")
    void updateProductName(int id,String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "delete from project.product where " +
            "product.id = :id ")
    void delete(int id);




}
