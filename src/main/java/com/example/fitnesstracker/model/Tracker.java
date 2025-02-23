package com.example.fitnesstracker.model;

public class Tracker {
    private int id;
    private String name;
    private String imageUrl;
    private String description;
    private double price;
    private String features;

    public Tracker(int id, String name, String imageUrl, String description, double price, String features) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.features = features;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getFeatures() {
        return features;
    }
    public void setFeatures(String features) {
        this.features = features;
    }
}

