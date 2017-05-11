package com.example.repository;

import com.example.domain.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Integer> {

}
