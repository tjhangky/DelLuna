package com.example.delluna.model;

public class Other {
    private String otherId;
    private String otherName;
    private int otherPrice;
    private int otherSold;
    private String otherDescription;
    private String otherImage;

    public Other(String otherId, String otherName, int otherPrice, int otherSold, String otherDescription, String otherImage) {
        this.otherId = otherId;
        this.otherName = otherName;
        this.otherPrice = otherPrice;
        this.otherSold = otherSold;
        this.otherDescription = otherDescription;
        this.otherImage = otherImage;
    }

    public String getOtherId() {
        return otherId;
    }

    public String getOtherName() {
        return otherName;
    }

    public int getOtherPrice() {
        return otherPrice;
    }

    public int getOtherSold() {
        return otherSold;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public String getOtherImage() {
        return otherImage;
    }
}
