package gr.codehub.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillSetForJobOfferDTO {
    private int job_offer_id;
    private int skill_from_recrume_id;
}
