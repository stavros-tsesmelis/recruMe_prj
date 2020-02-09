package gr.codehub.api.dto;

import gr.codehub.api.model.SkillSet;
import gr.codehub.api.model.SkillSetForJobOffer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillFromRecrumeDTO {
    private String skillName;

    private boolean active;
}
