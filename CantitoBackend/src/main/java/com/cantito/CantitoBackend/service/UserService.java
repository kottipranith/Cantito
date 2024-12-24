package com.cantito.CantitoBackend.service;

import com.cantito.CantitoBackend.entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(User user);
    String delete(String username);
    User findById(String username);
    List<User> findAll();
}
