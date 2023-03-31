package com.suitelife.Entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity

@Table(name = "reservation")

public class Reservation {
    
    @Id
    
    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    // One way or round trip.
    @Column(name = "roundtrip")
    private Boolean roundTrip;

    @Column(name = "number_of_people")
    private Integer numberOfPeople;

    @Column(name = "start_of_trip")
    private LocalDateTime startOfTrip; 

    @Column(name = "end_of_trip")
    private LocalDateTime endOfTrip;

    @OneToMany(orphanRemoval = true)
    // on a one-to-many, you state the parent as the foreign key,
    // to be placed on the child
    @JoinColumn(name = "reservation_id")
    private List<Place> place;

    public Reservation() {
    }

    public Reservation(Integer id, Boolean roundTrip, Integer numberOfPeople, LocalDateTime startOfTrip,
            LocalDateTime endOfTrip, List<Place> place) {
        this.id = id;
        this.roundTrip = roundTrip;
        this.numberOfPeople = numberOfPeople;
        this.startOfTrip = startOfTrip;
        this.endOfTrip = endOfTrip;
        this.place = place;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRoundTrip() {
        return roundTrip;
    }

    public void setRoundTrip(Boolean roundTrip) {
        this.roundTrip = roundTrip;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public LocalDateTime getStartOfTrip() {
        return startOfTrip;
    }

    public void setStartOfTrip(LocalDateTime startOfTrip) {
        this.startOfTrip = startOfTrip;
    }

    public LocalDateTime getEndOfTrip() {
        return endOfTrip;
    }

    public void setEndOfTrip(LocalDateTime endOfTrip) {
        this.endOfTrip = endOfTrip;
    }

    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", roundTrip=" + roundTrip + ", numberOfPeople=" + numberOfPeople
                + ", startOfTrip=" + startOfTrip + ", endOfTrip=" + endOfTrip + ", place=" + place + "]";
    }
}