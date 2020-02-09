package gr.codehub.api.repositories;

import gr.codehub.api.model.Company;
import gr.codehub.api.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Companies extends JpaRepository<Company, Integer> {
    Company findFirstByRegion(String region);

    Optional<List<Company>> findAllByRegion(String region);

    Company findFirstById(int company_id);

//
//    @Query(value = "SELECT *  FROM job_offer WHERE region = :region", nativeQuery = true)
//    Optional<Company> findByRegion(@Param("region") String region);

}
