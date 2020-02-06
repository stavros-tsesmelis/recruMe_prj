package gr.codehub.api.repositories;

import gr.codehub.api.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOffers extends JpaRepository<JobOffer, Integer> {
   // JobOffer findFirstByCompanyId(int id);
   @Query(value = "SELECT [job_offer_id]  FROM job_offer WHERE job_offer_id = :id", nativeQuery = true)
   JobOffer findFirstByCompanyId(@Param("id") int id);

}
