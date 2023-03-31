package com.suitelife.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import javax.persistence.JoinColumn;

@Entity

@Table(name = "place")

public class Place {
    
    @Id
    
    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price", scale = 2)
    private Double price;

    // many places and many amenities
    @ManyToMany
    @JoinTable(
        joinColumns=
            @JoinColumn(name="place_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="amenity_id", referencedColumnName="id")
    )

    private List<Amenity> amenity;

    public Place() {
    }

    public Place(Integer id, String name, Double price, List<Amenity> amenity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amenity = amenity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Amenity> getAmenity() {
        return amenity;
    }

    public void setAmenity(List<Amenity> amenity) {
        this.amenity = amenity;
    }

    @Override
    public String toString() {
        return "Place [id=" + id + ", name=" + name + ", price=" + price + ", amenity=" + amenity + "]";
    }    
}