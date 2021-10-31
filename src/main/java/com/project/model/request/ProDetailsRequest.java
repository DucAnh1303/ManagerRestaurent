package com.project.model.request;

public class ProDetailsRequest {
    private int price;
    private String placeImport;
    private int itemCode;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
