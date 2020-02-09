package gr.codehub.api.controller;

import gr.codehub.api.dto.MatcherDTO;
import gr.codehub.api.dto.SkillFromRecrumeDTO;
import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.JobOffer;
import gr.codehub.api.model.Matcher;
import gr.codehub.api.model.SkillFromRecrume;
import gr.codehub.api.service.MatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatcherController {
    @Autowired
    private MatcherService matcherService;

    @PostMapping("manualMatcher")   //Here is manual matching
    public Matcher getMatch(@RequestBody MatcherDTO matcherDTO1) {
        return matcherService.getManualMatch(matcherDTO1);
    }

    @PostMapping("automatedMatcher")
    public Matcher getAllPairsMatched(@RequestBody MatcherDTO matcherDTO1){
        return matcherService.getAutomatedMatch(matcherDTO1);
    }

    @PutMapping("manualMatch/update/{id}")
    public Matcher updateOne(@PathVariable int id, @RequestBody MatcherDTO matcherDTO){
        return matcherService.updateOne(id, matcherDTO);
    }

    @PutMapping("manualMatch/finalize/{id}")
    public String softDelete( @PathVariable int id) {
        return matcherService.finalizedMatch(id);
    }

//    @DeleteMapping("customer/{id}" )
//    public String deleteManualMatch(@PathVariable int id){
//        return matcherService.deleteManualMatch(id);
//    }
}
