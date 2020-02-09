package gr.codehub.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfRegistration;
    private int yearsOfExperience;
    private String profession;
    private String region;

    @OneToMany(mappedBy="applicant", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JobOffer> jobOffers;


    @OneToMany(mappedBy="applicant", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SkillSet> skillSets;


    //----------------------------------------------------------
//    @OneToOne(mappedBy = "matcher")
//    private Matcher matcher;
}
