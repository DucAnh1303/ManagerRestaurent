package com.project.model.request;


public class EmployeeRequest {
    private String name;
    private String address;
    private String phone;
    private String contractDate;
    private String contractWork;
    private String position;
    private int employeeUserId;

    public int getEmployeeUserId() {
        return employeeUserId;
    }

    public void setEmployeeUserId(int employeeUserId) {
        this.employeeUserId = employeeUserId;
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
