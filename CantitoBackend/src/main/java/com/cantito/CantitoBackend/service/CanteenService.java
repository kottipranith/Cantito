package com.cantito.CantitoBackend.service;

import com.cantito.CantitoBackend.entities.Canteen;

import java.util.List;

public interface CanteenService {
    Canteen save(Canteen canteen); // adds a canteen
    List<Canteen> findAll(); // retrieves all the canteens
    Canteen findById(int canteenId); // //retrieve a canteen by id
    String delete(int id); // delete a canteen by id
}
