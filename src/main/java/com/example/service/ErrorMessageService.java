package com.example.service;

import com.example.domain.ErrorMessage;
import com.example.repository.ErrorMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorMessageService {

    @Autowired
    ErrorMessageRepository errorMessageRepository;

    public ErrorMessage getErrorMessage(String errorCode) {
        return errorMessageRepository.findByErrorCode(errorCode);
    }

}
