package com.example.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Calendar;

@MappedSuperclass
public class BaseDomain {

    String createdBy;

    Timestamp createdDate;

    String updatedBy;

    Timestamp updatedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    @PrePersist
    public void prePersist() {
        createdDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
        updatedDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
    }
}
