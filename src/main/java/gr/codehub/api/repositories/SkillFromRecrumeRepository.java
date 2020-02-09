package gr.codehub.api.repositories;

import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.SkillFromRecrume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillFromRecrumeRepository extends JpaRepository<SkillFromRecrume, Integer>{
    SkillFromRecrume findById(int id);

    SkillFromRecrume findFirstById(int skill_from_recrume_id);
}
