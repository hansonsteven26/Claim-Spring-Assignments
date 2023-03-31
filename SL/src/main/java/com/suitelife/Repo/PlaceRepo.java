package com.suitelife.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suitelife.Entity.Place;

@Repository
public interface PlaceRepo extends JpaRepository<Place, Integer> {
    
}