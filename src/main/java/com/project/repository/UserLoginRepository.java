package com.project.repository;

import com.project.model.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin,Integer> {
    @Query(nativeQuery = true,
    value = "select project.user_login.id, " +
            "project.user_login.username,project.user_login.password " +
            " from project.user_login where username = :username and password = :password")
    List<UserLogin> addUserLogin(
            @Param("username")String username,
            @Param("password") String password
    );
    @Query(nativeQuery = true,
    value = "select * from project.user_login where username = :username ")
    List<UserLogin> findByUserName(
            @Param("username")String username
    );

}
