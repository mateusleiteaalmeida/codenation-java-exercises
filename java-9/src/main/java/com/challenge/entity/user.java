package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(EntityListeners.class)
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    private String fullname;

    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    private Timestamp createdat;

    @OneToMany
    private List<candidate> candidates;

    @OneToMany
    private List<submission> submissions;
}
