package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    @Query(value = "SELECT * FROM acceleration AS a" +
            " INNER JOIN candidate AS ca ON ca.acceleration_id = a.id" +
            " INNER JOIN company AS co ON co.id = ca.company_id" +
            " WHERE co.id = :companyId",
            nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
