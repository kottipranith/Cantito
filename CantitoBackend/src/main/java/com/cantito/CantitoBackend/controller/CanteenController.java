package com.cantito.CantitoBackend.controller;

import com.cantito.CantitoBackend.entities.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canteens")
public class CanteenController {

    @PostMapping("/additem")
    public ResponseEntity<Item> addItem(@RequestBody Item item){

    }

    @GetMapping("/{canteenId}/items/{itemId}")
    public List<Item> getMenu(@PathVariable("canteenId") int canteenId, @PathVariable("itemId")int itemId){

    }

    @GetMapping("/menu/{canteenId}")
    public List<Item> getMenu(@PathVariable("canteenId") int canteenId){

    }

    @DeleteMapping("/{canteenId}/items/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("canteenId") int canteenId, @PathVariable("itemId") int itemId){

    }

    @PutMapping("/{canteenId}/items/{itemId}")
    public ResponseEntity<String> makeItemsAvailable(@PathVariable("canteenId") int canteenId, @PathVariable("itemId") int itemId){

    }

    @PutMapping("/{canteenId}/items/{itemId}")
    public ResponseEntity<String> makeItemsUnavailable(@PathVariable("canteenId") int canteenId, @PathVariable("itemId") int itemId){

    }

    @PutMapping("/{canteenId}/items/{itemId}/{price}")
    public ResponseEntity<String> makeItemsUnavailable(@PathVariable("canteenId") int canteenId, @PathVariable("itemId") int itemId, @PathVariable("price")double price){

    }

}
