package com.suitelife.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suitelife.Entity.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
    
}