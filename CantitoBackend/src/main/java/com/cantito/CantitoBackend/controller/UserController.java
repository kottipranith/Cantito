package com.cantito.CantitoBackend.controller;

import com.cantito.CantitoBackend.entities.User;
import com.cantito.CantitoBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable("username")String username){
        return ResponseEntity.ok(userService.findById(username));
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> delete(@PathVariable("username") String username){
        return new ResponseEntity<>(userService.delete(username), HttpStatus.OK);
    }

    @PostMapping("/{username}/addphoto")
    public ResponseEntity<String> updatePhoto(@PathVariable("username") String username, @RequestParam("image")MultipartFile image){
        return ResponseEntity.ok(userService.updatePhoto(username, image));
    }
}
