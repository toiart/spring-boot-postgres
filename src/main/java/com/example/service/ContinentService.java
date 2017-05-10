package com.example.service;

import com.example.model.Continent;
import com.example.model.Country;
import com.example.repository.ContinentRepository;
import com.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Art on 11/24/16.
 */
@Service
public class ContinentService {

    @Autowired
    ContinentRepository continentRepository;
    @Autowired
    CountryRepository countryRepository;

    public Continent getContinent(Integer continentId) {
        return continentRepository.findOne(continentId);
    }

    public List<Continent> getContinentList() {
        return continentRepository.findAll();
    }

    public void saveContinent(Continent continent) {
        continentRepository.save(continent);
    }

    public void deleteContinent(Integer continentId) {
        continentRepository.delete(continentId);
    }

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }
}
