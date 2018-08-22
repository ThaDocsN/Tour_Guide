package com.thadocizn.myapplication;

public class Place {
    private String attraction;
    private String attractionAddress;
    private String attractionCity;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Place(String attraction, String attractionAddress, String attractionCity){
        this.attraction = attraction;
        this.attractionAddress = attractionAddress;
        this.attractionCity = attractionCity;
    }

    public Place(String attraction, String attractionAddress, String attractionCity,int imageResourceId){
        this.attraction = attraction;
        this.attractionAddress = attractionAddress;
        this.attractionCity = attractionCity;
        this.imageResourceId = imageResourceId;
    }

    public String getAttraction() {
        return attraction;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getAttractionAddress() {
        return attractionAddress;
    }

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getAttractionCity() {
        return attractionCity;
    }
}
