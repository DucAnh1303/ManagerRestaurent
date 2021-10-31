package com.project.repository;

import com.project.model.entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface EmSaRepository extends JpaRepository<EmployeeSalary, Integer> {
    @Query(nativeQuery = true,
            value = "select employee_salary.id, employee_salary.employee_code, (employee.name) as employee_name,(employee.position) as position, " +
                    "(employee_salary.fullday-employee_salary.offday) as workday, employee_salary.fullday,employee_salary.offday, " +
                    "employee_salary.hard_salary,employee_salary.position_salary,employee_salary.overtime,employee_salary.worktime,employee_salary.bonus, " +
                    "((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*(employee_salary.fullday- " +
                    "(employee_salary.fullday-employee_salary.offday)) as minus_salary, " +
                    "(employee_salary.hard_salary+employee_salary.hard_salary*employee_salary.position_salary+employee_salary.bonus- " +
                    "(((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*(employee_salary.fullday- " +
                    "(employee_salary.fullday-employee_salary.offday)))+ " +
                    "(((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*employee_salary.overtime))  " +
                    "as total_salary ,employee_salary.created_at " +
                    "from project.employee_salary join project.employee on project.employee.id=project.employee_salary.employee_code  ")
    List<EmployeeSalary> getAll();

    @Query(nativeQuery = true,
            value = "select employee_salary.id, employee_salary.employee_code, (employee.name) as employee_name,(employee.position) as position, " +
                    "(employee_salary.fullday-employee_salary.offday) as workday, employee_salary.fullday,employee_salary.offday, " +
                    "employee_salary.hard_salary,employee_salary.position_salary,employee_salary.overtime,employee_salary.worktime,employee_salary.bonus, " +
                    "((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*(employee_salary.fullday- " +
                    "(employee_salary.fullday-employee_salary.offday)) as minus_salary, " +
                    "(employee_salary.hard_salary+employee_salary.hard_salary*employee_salary.position_salary+employee_salary.bonus- " +
                    "(((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*(employee_salary.fullday- " +
                    "(employee_salary.fullday-employee_salary.offday)))+ " +
                    "(((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*employee_salary.overtime)) " +
                    "as total_salary ,employee_salary.created_at " +
                    "from project.employee_salary join project.employee on project.employee.id=project.employee_salary.employee_code where employee_salary.employee_code = :id ")
    List<EmployeeSalary> getById(
            @Param("id") int id
    );

    @Query(nativeQuery = true,
            value = "select employee_salary.id, employee_salary.employee_code, (employee.name) as employee_name,(employee.position) as position, " +
                    "(employee_salary.fullday-employee_salary.offday) as workday, employee_salary.fullday,employee_salary.offday, " +
                    "employee_salary.hard_salary,employee_salary.position_salary,employee_salary.overtime,employee_salary.worktime,employee_salary.bonus, " +
                    "((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*(employee_salary.fullday- " +
                    "(employee_salary.fullday-employee_salary.offday)) as minus_salary, " +
                    "(employee_salary.hard_salary+employee_salary.hard_salary*employee_salary.position_salary+employee_salary.bonus- " +
                    "(((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*(employee_salary.fullday- " +
                    "(employee_salary.fullday-employee_salary.offday)))+ " +
                    "(((employee_salary.hard_salary/employee_salary.fullday)/employee_salary.worktime)*employee_salary.overtime)) " +
                    "as total_salary ,employee_salary.created_at " +
                    "from project.employee_salary join project.employee on " +
                    "project.employee.id=project.employee_salary.employee_code where employee_salary.employee_code = :code ")
    List<EmployeeSalary> addSalary(
            @Param("code") int code
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update project.employee_salary set " +
                    "employee_salary.offday = :offday,employee_salary.position_salary = :posisalary, " +
                    "employee_salary.overtime= :overtime,employee_salary.worktime = :worktime,employee_salary.bonus = :bonus" +
                    " where employee_salary.employee_code = :codeId ")
    void updateSalary(int codeId,int offday,double posisalary,int overtime,int bonus,int worktime);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update project.employee_salary set " +
                    "employee_salary.offday = :offday "+
                    "where employee_salary.employee_code = :codeId ")
    void updateOffday(int codeId,int offday);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update project.employee_salary set " +
                    "employee_salary.overtime= :overtime " +
                    " where employee_salary.employee_code = :codeId ")
    void updateOverTime(int codeId,int overtime);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update project.employee_salary set " +
                    "employee_salary.position_salary = :positionsalary " +
                    " where employee_salary.employee_code = :codeId ")
    void updatePosition(int codeId,double positionsalary);


}
