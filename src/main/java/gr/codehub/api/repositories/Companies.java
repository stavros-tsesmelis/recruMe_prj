package gr.codehub.api.repositories;

import gr.codehub.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Companies extends JpaRepository<Company, Integer> {
}
