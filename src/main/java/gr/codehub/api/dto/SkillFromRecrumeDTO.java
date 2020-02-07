package gr.codehub.api.dto;

import gr.codehub.api.model.SkillSet;
import gr.codehub.api.model.SkillSetForJobOffer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SkillFromRecrumeDTO {
    private String skillName;

    private List<SkillSet> skillSets;
    private List<SkillSetForJobOffer> skillSetForJobOffers;

}
