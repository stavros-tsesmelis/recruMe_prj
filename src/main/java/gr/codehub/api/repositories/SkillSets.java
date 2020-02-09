package gr.codehub.api.repositories;

import gr.codehub.api.model.SkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.SkillSet;
import gr.codehub.api.model.SkillSetForJobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillSets extends JpaRepository<SkillSet, Integer>{
}






