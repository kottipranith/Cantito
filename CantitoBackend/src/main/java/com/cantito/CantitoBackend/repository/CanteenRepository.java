package com.cantito.CantitoBackend.repository;

import com.cantito.CantitoBackend.entities.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanteenRepository extends JpaRepository<Canteen, Integer> {
}
