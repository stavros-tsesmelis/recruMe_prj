package gr.codehub.api.repositories;

import gr.codehub.api.model.Matcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Matchers extends JpaRepository<Matcher, Integer> {
}
