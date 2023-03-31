package com.suitelife.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suitelife.Entity.Amenity;

@Repository
public interface AmenityRepo extends JpaRepository<Amenity, Integer> {
    
}