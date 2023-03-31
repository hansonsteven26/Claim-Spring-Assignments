package com.suitelife.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suitelife.Entity.Reservation;
import com.suitelife.Repo.ReservationRepo;


@Service
public class ReservationService {
    
    @Autowired
    ReservationRepo reservationRepo;

    // Create

    public Reservation save(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    // Read

    public Reservation findReservationById(Integer id) {
        return reservationRepo.findById(id).get();
    }

    public List<Reservation> findAll() {
        return reservationRepo.findAll();
    }

    // Update

    public Reservation update(Reservation reservation) throws Exception {

        if(reservation.getId() == null) {
            throw new Exception("No id present. Git outta here Billy");
        }
        return reservationRepo.save(reservation);
    }

    // Delete

    public void deleteReservationById(Integer id) {
        reservationRepo.deleteById(id);
    }
}