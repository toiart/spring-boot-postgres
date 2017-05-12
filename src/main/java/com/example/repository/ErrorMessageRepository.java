package com.example.repository;

import com.example.domain.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, Integer> {

    ErrorMessage findByErrorCode(String code);
}
