package com.cantito.CantitoBackend.repository;

import com.cantito.CantitoBackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
}
