package com.example.repository;

import com.example.model.Continent;
import com.example.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Art on 11/24/16.
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
