package com.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "employee")
public class Employee {
    @Id
    private int id;
    private String name;
    private String address;
    private String phone;
    @Column(name = "contract_date")
    private String contractDate;
    @Column(name = "contract_work")
    private String contractWork;
    private String position;
    @Column(name ="created_at" )
    private Date createdAt;
    @Column(name = "employee_user_id")
    private int employeeUserId;

    public int getEmployeeUserId() {
        return employeeUserId;
    }

    public void setEmployeeUserId(int employeeUserId) {
        this.employeeUserId = employeeUserId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractWork() {
        return contractWork;
    }

    public void setContractWork(String contractWork) {
        this.contractWork = contractWork;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
