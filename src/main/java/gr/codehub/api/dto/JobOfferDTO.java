package gr.codehub.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class JobOfferDTO {
    private String jobOfferName;
    private Date dateOfOffer;

    private int company_id;
    private int applicant_id;
   // List<CompanyDTO> companyDTOs;
   // List<ApplicantDTO> applicantDTOs;
}
