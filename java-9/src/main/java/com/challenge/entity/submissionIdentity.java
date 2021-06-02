package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class submissionIdentity implements Serializable {

    @ManyToOne
    private user user;

    @ManyToOne
    private challenge challenge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof submissionIdentity)) return false;
        submissionIdentity that = (submissionIdentity) o;
        return Objects.equals(user, that.user) && Objects.equals(challenge, that.challenge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, challenge);
    }
}
