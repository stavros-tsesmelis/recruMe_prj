package gr.codehub.api.repositories;

import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Applicants extends JpaRepository<Applicant, Integer> {
    Applicant findById(int id);

    @Query(value = "SELECT *  FROM applicant WHERE last_name = :lastName", nativeQuery = true)
    Applicant findByName(@Param("lastName") String name);

    Optional<List<Applicant>> findAllByRegion(String region);
}
