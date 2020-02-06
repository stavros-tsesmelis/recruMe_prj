package gr.codehub.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String jobOfferName;
    private Date dateOfOffer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="applicant_id")
    @JsonIgnore
    private Applicant applicant;*/
}
