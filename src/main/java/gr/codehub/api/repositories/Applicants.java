package gr.codehub.api.repositories;

import gr.codehub.api.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Applicants extends JpaRepository<Applicant, Integer> {
}
