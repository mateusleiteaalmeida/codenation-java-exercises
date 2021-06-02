package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(EntityListeners.class)
public class submission {

    @EmbeddedId
    private submissionIdentity submissionIdentity;

    @NotNull
    private float score;

    @CreatedDate
    private Timestamp createdat;

}
