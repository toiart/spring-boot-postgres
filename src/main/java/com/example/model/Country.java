package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Art on 11/24/16.
 */
@Entity
public class Country {

    private Integer countryId;
    private String countryName;
    private Continent continent;

    public Country() {
    }

    public Country(Continent continent) {
        this.continent = continent;
    }

    public Country(String countryName, Continent continent) {
        this.countryName = countryName;
        this.continent = continent;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "continent_id")
    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
