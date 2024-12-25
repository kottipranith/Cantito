package com.cantito.CantitoBackend.service.impl;

import com.cantito.CantitoBackend.exceptions.ResourceNotFoundException;
import com.cantito.CantitoBackend.entities.User;
import com.cantito.CantitoBackend.exceptions.ResourceAlreadyExistsException;
import com.cantito.CantitoBackend.repository.UserRepository;
import com.cantito.CantitoBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        if(userRepository.existsByUsername(user.getUsername()))
            throw new ResourceAlreadyExistsException("User with username " + user.getUsername() + " already exists.");
        user.setProfileUrl("default.jpg");
        user.setCreatedAt(LocalDate.now());
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if(!userRepository.existsByUsername(user.getUsername()))
            throw new ResourceNotFoundException("User with username " + user.getUsername() + " doesn't exist." );
        User prevUser = userRepository.findById(user.getUsername()).get();
        if(user.getPassword() == null)
            user.setPassword(prevUser.getPassword());
        if(user.getEmail() == null)
            user.setEmail(prevUser.getEmail());
        if(user.getName() == null)
            user.setName(prevUser.getName());
        if(user.getMobile() == null)
            user.setMobile(prevUser.getMobile());
        user.setCreatedAt(prevUser.getCreatedAt());
        
        return userRepository.save(user);
    }

    @Override
    public String delete(String username) {
        if(!userRepository.existsByUsername(username))
            throw new ResourceNotFoundException("user with username " + username + " doesn't exist.");
        userRepository.deleteById(username);
        return "User with username " + username + " successfully deleted.";
    }

    @Override
    public User findById(String username) {
        if(!userRepository.existsByUsername(username))
            throw new ResourceNotFoundException("user with username " + username + " doesn't exist.");

        return userRepository.findById(username).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
