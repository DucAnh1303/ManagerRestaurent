package com.project.model.request;

public class EmployeeSalaryRequest {
    private int employeeCode;
    private int fullday;
    private int offday;
    private int hardSalary;
    private double positionSalary;
    private int overtime;
    private int worktime;
    private int bonus;

    public double getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(double positionSalary) {
        this.positionSalary = positionSalary;
    }


    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
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
}
