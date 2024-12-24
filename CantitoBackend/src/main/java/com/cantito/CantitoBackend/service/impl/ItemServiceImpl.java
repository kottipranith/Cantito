package com.cantito.CantitoBackend.service.impl;

import com.cantito.CantitoBackend.entities.Canteen;
import com.cantito.CantitoBackend.entities.Item;
import com.cantito.CantitoBackend.exceptions.ResourceAlreadyExistsException;
import com.cantito.CantitoBackend.exceptions.ResourceNotFoundException;
import com.cantito.CantitoBackend.repository.ItemRepository;
import com.cantito.CantitoBackend.service.CanteenService;
import com.cantito.CantitoBackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CanteenService canteenService;

    @Override
    public Item save(int canteenId, Item item) {
        // check weather it already exists or not
        if(itemRepository.existsByItemIdAndCanteen_CanteenId(item.getItemId(), canteenId))
            throw new ResourceAlreadyExistsException("item with id" + item.getItemId() + " already exists in canteen with id" + canteenId);
        Canteen canteen = canteenService.findById(canteenId);
        item.setCanteen(canteen);
        return itemRepository.save(item);
    }

    @Override
    public Item findById(int canteenId, int itemId) {
        Item item = itemRepository.findByItemIdAndCanteen_CanteenId(itemId, canteenId);
        if(item == null)
            throw new ResourceNotFoundException("Item with id " + itemId + " in canteen with id" + canteenId + " doesn't exist.");
        return item;
    }

    @Override
    public List<Item> findByCanteenId(int canteenId) {
        return itemRepository.findByCanteen_CanteenId(canteenId);
    }

    @Override
    public String delete(int canteenId, int itemId) {
        if(!itemRepository.existsByItemIdAndCanteen_CanteenId(itemId, canteenId))
            throw new ResourceNotFoundException("item with id " + itemId + " in canteen with id " + canteenId + " doesn't exist.");
        itemRepository.deleteByItemIdAndCanteen_CanteenId(itemId, canteenId);
        return "Item deleted";
    }

    @Override
    public String makeItemAvailable(int canteenId, int itemId) {
        Item item = findById(canteenId, itemId);
        item.setAvaliable(true);
        itemRepository.save(item);
        return "Item with id " + itemId + " are available now.";
    }

    @Override
    public String makeItemUnavailable(int canteenId, int itemId) {
        Item item = findById(canteenId, itemId);
        item.setAvaliable(false);
        itemRepository.save(item);
        return "Item with id " + itemId + " are unavailable now.";
    }

    @Override
    public Item updatePrice(int canteenId, int itemId, double price) {
        Item item = findById(canteenId, itemId);
        item.setPrice(price);
        return itemRepository.save(item);
    }
}
