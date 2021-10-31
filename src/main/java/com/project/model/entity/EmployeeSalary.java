package com.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "employee_salary")
public class EmployeeSalary {
    @Id
    private int id;
    @Column(name = "employee_code")
    private int employeeCode;
    @Column(name = "employee_name")
    private String employeeName;
    private String position;
    private int workday;
    private int fullday;
    private int offday;
    @Column(name = "hard_salary")
    private int hardSalary;
    @Column(name = "position_salary")
    private double positionSalary;
    private int overtime;
    private int worktime;
    private int bonus;
    @Column(name = "minus_salary")
    private double minusSalary;
    @Column(name = "total_salary")
    private double totalSalary;
    @Column(name = "created_at")
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getWorkday() {
        return workday;
    }

    public void setWorkday(int workday) {
        this.workday = workday;
    }

    public int getFullday() {
        return fullday;
    }

    public void setFullday(int fullday) {
        this.fullday = fullday;
    }

    public int getOffday() {
        return offday;
    }

    public void setOffday(int offday) {
        this.offday = offday;
    }

    public int getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(int hardSalary) {
        this.hardSalary = hardSalary;
    }

    public double getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(double positionSalary) {
        this.positionSalary = positionSalary;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public double getMinusSalary() {
        return minusSalary;
    }

    public void setMinusSalary(double minusSalary) {
        this.minusSalary = minusSalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
