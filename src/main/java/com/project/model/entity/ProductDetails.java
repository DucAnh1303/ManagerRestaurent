package com.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "productdetails")
public class ProductDetails {
    @Id
    private int id;
    @Column(name = "product_name")
    private String productName;
    private int numbers;
    @Column(name = "product_type")
    private String productType;
    private int price;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "place_import")
    private String placeImport;
    @Column(name = "item_code")
    private int itemCode;
    @Column(name = "created_at")
    private Date  createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPlaceImport() {
        return placeImport;
    }

    public void setPlaceImport(String placeImport) {
        this.placeImport = placeImport;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }
}
