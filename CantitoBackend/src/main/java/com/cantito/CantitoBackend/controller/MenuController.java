package com.cantito.CantitoBackend.controller;

import com.cantito.CantitoBackend.entities.Item;
import com.cantito.CantitoBackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/{canteenId}/items/additem")
    public ResponseEntity<Item> addItem(@RequestBody Item item, @PathVariable("canteenId")int canteenId){
        return new ResponseEntity<>(itemService.save(canteenId, item), HttpStatus.CREATED);
    }

    @GetMapping("/{canteenId}/items/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable("canteenId") int canteenId, @PathVariable("itemId")int itemId){
        return new ResponseEntity<>(itemService.findById(canteenId, itemId), HttpStatus.OK);
    }

    @GetMapping("/{canteenId}")
    public ResponseEntity<List<Item>> getMenu(@PathVariable("canteenId") int canteenId){
        return new ResponseEntity<>(itemService.findByCanteenId(canteenId), HttpStatus.OK);
    }

    @DeleteMapping("/{canteenId}/items/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("canteenId") int canteenId, @PathVariable("itemId") int itemId){
        return new ResponseEntity<>(itemService.delete(canteenId, itemId), HttpStatus.OK);
    }

    @PutMapping("/{canteenId}/items/{itemId}")
    public ResponseEntity<String> makeItemsAvailable(@PathVariable("canteenId") int canteenId, @PathVariable("itemId") int itemId){
        return new ResponseEntity<>(itemService.makeItemAvailable(canteenId, itemId), HttpStatus.OK);
    }

    @PutMapping("/{canteenId}/items/{itemId}")
    public ResponseEntity<String> makeItemsUnavailable(@PathVariable("canteenId") int canteenId, @PathVariable("itemId") int itemId){
        return new ResponseEntity<>(itemService.makeItemUnavailable(canteenId, itemId), HttpStatus.OK);
    }

    @PutMapping("/{canteenId}/items/{itemId}/{price}")
    public ResponseEntity<Item> makeItemsUnavailable(@PathVariable("canteenId") int canteenId, @PathVariable("itemId") int itemId, @PathVariable("price")double price){
        return new ResponseEntity<>(itemService.updatePrice(canteenId, itemId, price), HttpStatus.OK);
    }

}
