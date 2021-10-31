package com.project.repository;

import com.project.model.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
    @Query(nativeQuery = true,
    value = "select * from project.promotion")
    List<Promotion> getAll();

    @Query(nativeQuery = true,
    value = "select * from project.promotion where descriptions = :des ")
    List<Promotion> addPromotion(
            @Param("des") String des
    );
}
