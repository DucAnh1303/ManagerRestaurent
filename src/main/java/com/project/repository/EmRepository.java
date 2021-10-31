package com.project.repository;

import com.project.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmRepository extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true,
            value = "select * from project.employee")
    List<Employee> getAll();

    @Query(nativeQuery = true,
            value = "select * from project.employee where employee.id = :id")
    List<Employee> getById(
            @Param("id") int id
    );

    @Query(nativeQuery = true,
            value = "select *from project.employee where employee.name = :name")
    List<Employee> addEmployee(
            @Param("name") String name
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "update project.employee set employee.name= :name,employee.address = :address,employee.phone = :phone," +
            "employee.contract_date = :date, " +
            "employee.contract_work = :work,employee.position = :position where employee.user_login_id = :id")
    void updateEmployee(int id,String name,String address,String phone,String date,String work,String position);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "delete from project.employee where employee.id = :id ")
    void deleteById(int id);


}
