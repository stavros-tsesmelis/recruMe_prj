package gr.codehub.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SkillFromRecrume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String skillName;

    @Column(columnDefinition = "bit default 1")
    private boolean active;

    @OneToMany(mappedBy="skillFromRecrume", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SkillSet> skillSets;


    //----------------------------------------------------------
    @OneToMany(mappedBy="skillFromRecrume", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SkillSetForJobOffer> skillSetForJobOffers;


//    @Override
    public boolean equal(SkillFromRecrume applicantSkill) {
        if (this == applicantSkill) return true;
        if (!(applicantSkill instanceof SkillFromRecrume)) return false;
        SkillFromRecrume skillFromRecrume = (SkillFromRecrume) applicantSkill;
        return getSkillName().equals(skillFromRecrume.getSkillName());
    }

}
