package com.example.controller;

import com.example.domain.ErrorMessage;
import com.example.exception.EntityNotFoundException;
import com.example.model.MessageInfo;
import com.example.service.ErrorMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandleExceptionController {

    @Autowired
    ErrorMessageService errorMessageService;

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	public ResponseEntity<MessageInfo> handleEntityNotFound(EntityNotFoundException ex) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode(ex.getCode());
        messageInfo.setDescription(ex.getMessage());

        ErrorMessage errorMessage = errorMessageService.getErrorMessage(ex.getCode());

        if (errorMessage != null) {
            messageInfo.setCode(errorMessage.getErrorCode());
            messageInfo.setDescription(errorMessage.getErrorMessage());
        }

		return new ResponseEntity(messageInfo, HttpStatus.NOT_FOUND);
	}


}	
