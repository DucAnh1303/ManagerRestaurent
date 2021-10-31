package com.project.repository;

import com.project.model.entity.ProductDetails;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProDeRepository extends JpaRepository<ProductDetails, Integer> {
    @Query(nativeQuery = true,
    value = "select project.productdetails.id, (product.product_name) as product_name,(product.numbers)as numbers,(product.product_type) as product_type, " +
            "productdetails.price,(product.numbers*productdetails.price) as total_price,productdetails.place_import, " +
            "productdetails.item_code " +
            "from project.productdetails join project.product on project.productdetails.item_code=project.product.id ")
    List<ProductDetails> getAll();

    @Query(nativeQuery = true,
    value = "select project.productdetails.id,(product.product_name) as product_name,(product.numbers)as numbers,(product.product_type) as product_type, " +
            "productdetails.price,(product.numbers*productdetails.price) as total_price,productdetails.place_import, " +
            "productdetails.item_code " +
            "from project.productdetails join project.product on project.productdetails.item_code=project.product.id " +
            "where productdetails.item_code = :itemId ")
    List<ProductDetails> getById(
            @Param("itemId") int itemId
    );

    @Query(nativeQuery = true,
    value = "select project.productdetails.id,(product.product_name) as product_name,(product.numbers)as numbers,(product.product_type) as product_type, " +
            "productdetails.price,(product.numbers*productdetails.price) as total_price,productdetails.place_import, " +
            "productdetails.item_code " +
            "from project.productdetails join project.product on project.productdetails.item_code=project.product.id " +
            "where productdetails.item_code = :itemId  ")
    List<ProductDetails> addProductDetails(
            @Param("itemId") int itemId
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.productdetails set productdetails.price = :price " +
            "where productdetails.item_code = :itemId ")
    void updatePrice(int itemId,int price);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.productdetails set productdetails.place_import = :place " +
            "where productdetails.item_code = :itemId ")
    void updatePlace(int itemId,String place);


    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "delete from project.productdetails " +
            "where productdetails.item_code = :itemId ")
    void deleteById(int itemId);


}
