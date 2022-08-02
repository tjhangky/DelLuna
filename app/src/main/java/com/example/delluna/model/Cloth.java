package com.example.delluna.model;

public class Cloth {
    private String clothId;
    private String clothName;
    private int clothPrice;
    private int clothSold;
    private String clothDescription;
    private String clothImage;

    public Cloth(String clothId, String clothName, int clothPrice, int clothSold, String clothDescription, String clothImage) {
        this.clothId = clothId;
        this.clothName = clothName;
        this.clothPrice = clothPrice;
        this.clothSold = clothSold;
        this.clothDescription = clothDescription;
        this.clothImage = clothImage;
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

    public String getClothDescription() {
        return clothDescription;
    }

    public String getClothImage() {
        return clothImage;
    }
}
