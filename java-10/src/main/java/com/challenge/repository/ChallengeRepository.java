package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query(value = "SELECT * FROM challenge AS c" +
            " INNER JOIN acceleration AS a ON a.challenge_id = c.id" +
            " INNER JOIN submission AS s ON s.challenge_id = c.id" +
            " WHERE a.challenge_id = :accelerationId OR s.user_id = :userId",
            nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
