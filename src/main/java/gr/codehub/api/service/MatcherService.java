package gr.codehub.api.service;


import gr.codehub.api.dto.MatcherDTO;
import gr.codehub.api.model.JobOffer;
import gr.codehub.api.model.Matcher;
import gr.codehub.api.repositories.Applicants;
import gr.codehub.api.repositories.Companies;
import gr.codehub.api.repositories.JobOffers;
import gr.codehub.api.repositories.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatcherService {

    @Autowired
    private Matchers matchersRepo;

    @Autowired
    private Applicants applicantsRepo;

    @Autowired
    private JobOffers jobOffersRepo;

    public Matcher getMatch(MatcherDTO matcherDTO1) {
        Matcher matcher = new Matcher();
        matcher.setJobOffer(jobOffersRepo.findFirstById(matcherDTO1.getJob_offer_id()));
        matcher.setApplicant(applicantsRepo.findFirstById(matcherDTO1.getApplicant_id()));
        return matchersRepo.save(matcher);
    }
}
