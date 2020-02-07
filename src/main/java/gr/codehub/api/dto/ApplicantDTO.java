package gr.codehub.api.dto;

import gr.codehub.api.model.JobOffer;
import gr.codehub.api.model.SkillSet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ApplicantDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfRegistration;
    private int yearsOfExperience;
    private String profession;
    private String region;

//    private List<JobOffer> jobOffers;
//    private List<SkillSet> skillSets;

}
