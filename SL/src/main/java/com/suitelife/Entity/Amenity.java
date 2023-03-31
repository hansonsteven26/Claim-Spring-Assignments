package com.suitelife.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "amenity")
public class Amenity {
    
    @Id
    
    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "activity")
    private String activity;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    // both place and amenities need @manytomany
    @ManyToMany
    @JsonIgnore
    private List<Place> places;

    public Amenity() {
    }

    public Amenity(Integer id, String activity, String type, String description) {
        this.id = id;
        this.activity = activity;
        this.type = type;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Amenity [id=" + id + ", activity=" + activity + ", type=" + type + ", description=" + description + "]";
    }
}