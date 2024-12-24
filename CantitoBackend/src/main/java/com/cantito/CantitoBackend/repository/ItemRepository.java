package com.cantito.CantitoBackend.repository;

import com.cantito.CantitoBackend.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCanteen_CanteenId(int canteenId);

    @Transactional
    void deleteByItemIdAndCanteen_CanteenId(int itemId, int canteenId);

    boolean existsByItemIdAndCanteen_CanteenId(int itemId, int canteenId);

    Item findByItemIdAndCanteen_CanteenId(int itemId, int canteenId);

}
