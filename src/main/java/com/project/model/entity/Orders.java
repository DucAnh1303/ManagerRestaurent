package com.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.zip.DataFormatException;

@Entity(name = "orders")
public class Orders {
    @Id
    private int id;
    @Column(name = "cus_id")
    private int cusId;
    @Column(name = "sum_food")
    private int sumFood;
    private int numbers;
    @Column(name = "total_price")
    private int totalPrice;
    @Column (name = "created_at")
    private Date createdAt;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int nameId) {
        this.cusId = nameId;
    }

    public int getSumFood() {
        return sumFood;
    }

    public void setSumFood(int foodId) {
        this.sumFood = foodId;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

}
