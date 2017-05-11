package com.example.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Continent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer continentId;

    private String continentName;

    @JsonManagedReference
    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    private Set<Country> countries;

    public Continent() {
    }

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

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
