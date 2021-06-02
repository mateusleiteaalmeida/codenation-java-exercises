package com.challenge.service.interfaces;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface{

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public Submission save(Submission object) {
        return this.submissionRepository.save(object);
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        if (this.submissionRepository.findHigherScoreByChallengeId(challengeId) == null) return BigDecimal.ZERO;
        return BigDecimal.valueOf(this.submissionRepository.findHigherScoreByChallengeId(challengeId));
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return this.submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
}
