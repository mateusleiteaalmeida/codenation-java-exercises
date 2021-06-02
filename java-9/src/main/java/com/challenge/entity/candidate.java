package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(EntityListeners.class)
public class candidate {

    @EmbeddedId
    private candidateIdentity candidateIdentity;

    @NotNull
    private int status;

    @CreatedDate
    private Timestamp createdat;

}
