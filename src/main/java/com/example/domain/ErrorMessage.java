package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ErrorMessage {

    @Id
    private Integer errorId;
    private String errorCode;
    private String errorMessage;

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
