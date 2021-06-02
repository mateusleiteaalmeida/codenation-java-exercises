package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query(value = "SELECT s.score FROM submission AS s" +
            " INNER JOIN challenge AS c ON c.id = s.challenge_id" +
            " WHERE s.challenge_id = :challengeId" +
            " ORDER BY s.score DESC" +
            " LIMIT 1",
            nativeQuery = true)
    Float findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value = "SELECT * FROM submission AS s" +
            " INNER JOIN challenge AS c ON c.id = s.challenge_id" +
            " INNER JOIN acceleration AS a ON a.challenge_id = c.id" +
            " WHERE s.challenge_id = :challengeId AND a.id = :accelerationId",
            nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
}
