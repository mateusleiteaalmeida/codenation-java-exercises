package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query(value = "SELECT * FROM company AS c" +
            " INNER JOIN candidate AS ca ON ca.company_id = c.id" +
            " INNER JOIN acceleration AS a ON a.id = ca.acceleration_id" +
            " WHERE a.id = :accelerationId" +
            " LIMIT 1",
            nativeQuery = true)
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT * FROM company AS c" +
            " INNER JOIN candidate AS ca ON ca.company_id = c.id" +
            " INNER JOIN users AS u ON u.id = ca.user_id" +
            " WHERE u.id = :userId",
            nativeQuery = true)
    List<Company> findByUserId(@Param("userId") Long userId);
}
