package com.example.delluna.model;

public class Album {
    private String albumId;
    private String albumName;
    private int albumPrice;
    private int albumSold;
    private String albumDescription;
    private String albumImage;

    public Album(String albumId, String albumName, int albumPrice, int albumSold, String albumDescription, String albumImage) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumPrice = albumPrice;
        this.albumSold = albumSold;
        this.albumDescription = albumDescription;
        this.albumImage = albumImage;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getAlbumPrice() {
        return albumPrice;
    }

    public int getAlbumSold() {
        return albumSold;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public String getAlbumImage() {
        return albumImage;
    }
}
