package com.example.controller;

import com.example.domain.Continent;
import com.example.domain.Country;
import com.example.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContinentController {

    @Autowired
    ContinentService continentService;

    @GetMapping(path = "/continents")
    public List<Continent> getContinents() {
        return continentService.getContinentList();
    }

    @PostMapping(path = "/continent")
    public ResponseEntity<Void> createContinent(@RequestBody Continent continent) {
        continentService.saveContinent(continent);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(path = "/country")
    public ResponseEntity<Void> createCountry(@RequestBody Country country) {
        continentService.saveCountry(country);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/continent/{id}")
    public ResponseEntity<Continent> getContinent(@PathVariable("id") String continentId) {

        try {
            Continent continent = continentService.getContinent(new Integer(continentId));
            if (continent == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(continent, HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/continent/{id}")
    public ResponseEntity<Continent> deleteContinent(@PathVariable("id") String continentId) {

        try {
            if (continentService.getContinent(new Integer(continentId)) == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            continentService.deleteContinent(new Integer(continentId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
