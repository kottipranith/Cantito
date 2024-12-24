package com.cantito.CantitoBackend.service;

import com.cantito.CantitoBackend.entities.Item;

import java.util.List;

public interface ItemService {
    Item save(int canteenId, Item item);
    Item findById(int canteenId, int itemId);
    List<Item> findByCanteenId(int canteenId);
    String delete(int canteenId, int itemId);
    String makeItemAvailable(int canteenId, int itemId);
    String makeItemUnavailable(int canteenId, int itemId);
    Item updatePrice(int canteenId, int itemId, double price);
}
