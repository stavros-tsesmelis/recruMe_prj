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
public class SkillSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToMany(mappedBy="skillSet", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Applicant> applicants;
//
//    @OneToMany(mappedBy="skillSet", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<SkillFromRecrume> skillFromRecrumes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="applicant_id")
    @JsonIgnore
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skill_from_recrume_id")
    @JsonIgnore
    private SkillFromRecrume skillFromRecrume;

}
