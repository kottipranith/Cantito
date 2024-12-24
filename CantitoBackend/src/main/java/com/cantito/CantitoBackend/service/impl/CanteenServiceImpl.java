package com.cantito.CantitoBackend.service.impl;

import com.cantito.CantitoBackend.entities.Canteen;
import com.cantito.CantitoBackend.exceptions.ResourceAlreadyExistsException;
import com.cantito.CantitoBackend.exceptions.ResourceNotFoundException;
import com.cantito.CantitoBackend.repository.CanteenRepository;
import com.cantito.CantitoBackend.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenServiceImpl implements CanteenService {

    @Autowired
    private CanteenRepository canteenRepository;

    @Override
    public Canteen save(Canteen canteen) {
        if(canteenRepository.existsById(canteen.getCanteenId()))
            throw new ResourceAlreadyExistsException("canteen " + canteen.getCanteenName() + " already exists.");
        return canteenRepository.save(canteen);
    }

    @Override
    public List<Canteen> findAll() {
        return canteenRepository.findAll();
    }

    @Override
    public Canteen findById(int canteenId) {
        return canteenRepository.findById(canteenId).orElseThrow(()-> new ResourceNotFoundException("canteen with canteed id " + canteenId + " doesn't exist."));
    }

    @Override
    public String delete(int canteenId) {
        if(!canteenRepository.existsById(canteenId))
            throw new ResourceNotFoundException("canteen with canteed id " + canteenId + " doesn't exist.");
        return "canteen with canteen id " + canteenId + " deleted successfully.";
    }
}
