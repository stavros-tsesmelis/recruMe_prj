package gr.codehub.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Matcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "bit default 0")
    private boolean notFinalized;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private Applicant applicant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_offer_id", referencedColumnName = "id")
    private JobOffer jobOffer;
}
