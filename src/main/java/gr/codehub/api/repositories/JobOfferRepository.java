package gr.codehub.api.repositories;

import gr.codehub.api.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Integer> {
   // JobOffer findFirstByCompanyId(int id);
   //H grammh 14 me tis grammes 16, 17 einai idies.
   @Query(value = "SELECT *  FROM job_offer WHERE id = :id", nativeQuery = true)
   JobOffer findFirstByCompanyId(@Param("id") int id);

    @Query(value = "SELECT *  FROM job_offer WHERE job_offer_name = :name", nativeQuery = true)
    JobOffer findByName(@Param("name") String name);

    JobOffer findFirstById(int job_offer_id);


//    @Query(value = "SELECT job_offer_name FROM job_offer WHERE id = (SELECT job_offer_id FROM skill_set_for_job_offer WHERE skill_from_recrume_id = (SELECT id FROM  skill_from_recrume WHERE skill_name = :name))", nativeQuery = true)
//    Optional<List<JobOffer>> findBySkill(String skill);

    //JobOffer findByDate(Date date);
}
