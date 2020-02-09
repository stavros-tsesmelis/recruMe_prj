package gr.codehub.api.controller;

import gr.codehub.api.dto.CompanyDTO;
import gr.codehub.api.dto.MatcherDTO;
import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.Matcher;
import gr.codehub.api.service.AJSService;
import gr.codehub.api.service.MatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatcherController {
    @Autowired
    private MatcherService matcherService;

    @PostMapping("matcher/{applicant_id}/{job_offer_id}")
    public Matcher getMatch(@RequestBody MatcherDTO matcherDTO1) {
        return matcherService.getMatch(matcherDTO1);
    }
}
