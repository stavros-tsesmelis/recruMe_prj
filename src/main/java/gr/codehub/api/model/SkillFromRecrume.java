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
//    @JoinColumn(name="job_offer_id")
//    @JsonIgnore
//    private JobOffer jobOffer;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="applicant_id")
//    @JsonIgnore
//    private Applicant applicant;


}
