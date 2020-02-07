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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="skill_set_id")
//    @JsonIgnore
//    private SkillSet skillSet;

    @OneToMany(mappedBy="skillFromRecrume", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SkillSet> skillSets;


    //----------------------------------------------------------
    @OneToMany(mappedBy="skillFromRecrume", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SkillSetForJobOffer> skillSetForJobOffers;

}
