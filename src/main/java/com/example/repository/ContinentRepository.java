package com.example.repository;

import com.example.model.Book;
import com.example.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Art on 11/24/16.
 */
public interface ContinentRepository extends JpaRepository<Continent, Integer> {

}
