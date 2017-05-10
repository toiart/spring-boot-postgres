package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Art on 11/24/16.
 */
@Entity
public class Continent {

    private Integer continentId;
    private String continentName;
    private Set<Country> countries;

    public Continent() {
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
