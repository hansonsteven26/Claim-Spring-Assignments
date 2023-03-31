package com.suitelife.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suitelife.Entity.Amenity;
import com.suitelife.Repo.AmenityRepo;


@Service
public class AmenityService {
    
    @Autowired
    AmenityRepo amenityRepo;

    // Create

    public Amenity save(Amenity amenity) {
        return amenityRepo.save(amenity);
    }

    // Read

    public Amenity findAmenityById(Integer id) {
        return amenityRepo.findById(id).get();
    }

    public List<Amenity> findAll() {
        return amenityRepo.findAll();
    }

    // Update

    public Amenity update(Amenity amenity) throws Exception {

        if(amenity.getId() == null) {
            throw new Exception("No id present. Git outta here Billy");
        }
        return amenityRepo.save(amenity);
    }

    // Delete

    public void deleteAmenityById(Integer id) {
        amenityRepo.deleteById(id);
    }
}