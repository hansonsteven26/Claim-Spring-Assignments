package com.suitelife.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suitelife.Entity.Place;
import com.suitelife.Repo.PlaceRepo;


@Service
public class PlaceService {
    
    @Autowired
    PlaceRepo placeRepo;

    // Create

    public Place save(Place place) {
        return placeRepo.save(place);
    }

    // Read

    public Place findPlaceById(Integer id) {
        return placeRepo.findById(id).get();
    }

    public List<Place> findAll() {
        return placeRepo.findAll();
    }

    // Update

    public Place update(Place place) throws Exception {

        if(place.getId() == null) {
            throw new Exception("No id present. Git outta here Billy");
        }
        return placeRepo.save(place);
    }

    // Delete

    public void deletePlaceById(Integer id) {
        placeRepo.deleteById(id);
    }
}