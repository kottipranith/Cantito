package com.cantito.CantitoBackend.controller;

import com.cantito.CantitoBackend.entities.Canteen;
import com.cantito.CantitoBackend.service.CanteenService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canteens")
public class CanteenController {

    @Autowired
    private CanteenService canteenService;

    @PostMapping("/")
    public ResponseEntity<Canteen> save(@RequestBody Canteen canteen){
        return new ResponseEntity<>(canteenService.save(canteen), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Canteen>> findAll(){
        return ResponseEntity.ok(canteenService.findAll());
    }

    @GetMapping("/{canteenId}")
    public ResponseEntity<Canteen> findById(@PathVariable("canteenId")int canteenId){
        return new ResponseEntity<>(canteenService.findById(canteenId), HttpStatus.OK);
    }

    @DeleteMapping("/{canteenId}")
    public ResponseEntity<String> deleteById(@PathVariable("canteenId")int canteenId){
        return new ResponseEntity<>(canteenService.delete(canteenId), HttpStatus.OK);
    }
}
