package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class candidateIdentity implements Serializable {

    @ManyToOne
    private user user;

    @ManyToOne
    private acceleration acceleration;

    @ManyToOne
    private company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof candidateIdentity)) return false;
        candidateIdentity that = (candidateIdentity) o;
        return Objects.equals(user, that.user) && Objects.equals(acceleration, that.acceleration) && Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, acceleration, company);
    }
}
