package com.cantito.CantitoBackend.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Canteen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int canteenId;

    private String canteenName;

    private String ownerId;

    private String location;

    @OneToMany(mappedBy = "canteen")
    private List<Item> items = new ArrayList<>();

    private String canteenUrl; // to store canteen image location and file name

    public int getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(int canteenId) {
        this.canteenId = canteenId;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getCanteenUrl() {
        return canteenUrl;
    }

    public void setCanteenUrl(String canteenUrl) {
        this.canteenUrl = canteenUrl;
    }
}
