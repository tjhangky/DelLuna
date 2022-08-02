package com.example.delluna.model;

public class Cloth {
    private String clothId;
    private String clothName;
    private int clothPrice;
    private int clothSold;
//    private String clothDescription;

    public Cloth(String clothId, String clothName, int clothPrice, int clothSold) {
        this.clothId = clothId;
        this.clothName = clothName;
        this.clothPrice = clothPrice;
        this.clothSold = clothSold;
//        this.clothDescription = clothDescription;
    }

    public String getClothId() {
        return clothId;
    }

    public String getClothName() {
        return clothName;
    }

    public int getClothPrice() {
        return clothPrice;
    }

    public int getClothSold() {
        return clothSold;
    }

//    public String getClothDescription() {
//        return clothDescription;
//    }
}
