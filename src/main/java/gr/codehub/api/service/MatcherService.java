package gr.codehub.api.service;


import gr.codehub.api.dto.MatcherDTO;
import gr.codehub.api.model.*;
import gr.codehub.api.repositories.ApplicantRepository;
import gr.codehub.api.repositories.JobOfferRepository;
import gr.codehub.api.repositories.MatcherRepository;
import gr.codehub.api.repositories.SkillSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MatcherService {

    @Autowired
    private MatcherRepository matchersRepo;

    @Autowired
    private ApplicantRepository applicantsRepo;

    @Autowired
    private JobOfferRepository jobOffersRepo;

    @Autowired
    private SkillSetRepository skillSetsRepo;

    public Matcher getManualMatch(MatcherDTO matcherDTO1) {
        Matcher matcher = new Matcher();
        matcher.setJobOffer(jobOffersRepo.findFirstById(matcherDTO1.getJob_offer_id()));
        matcher.setApplicant(applicantsRepo.findFirstById(matcherDTO1.getApplicant_id()));
        return matchersRepo.save(matcher);
    }

    public Matcher getAutomatedMatch(MatcherDTO matcherDTO1) { //null pointer exception error 500.
        Matcher matcher = new Matcher();
        JobOffer jobOffer = jobOffersRepo.findFirstById(matcherDTO1.getJob_offer_id());
        Applicant applicant = applicantsRepo.findFirstById(matcherDTO1.getApplicant_id());
        Iterator<JobOffer> jobOfferIterator = jobOffersRepo.findAll().iterator();
        Iterator<SkillSet> skillSetIterator = skillSetsRepo.findAll().iterator();

        int required = 0;
        for(SkillSetForJobOffer s : jobOffer.getSkillSetForJobOffers()){
            SkillFromRecrume jobOfferSkill = s.getSkillFromRecrume();
            for(SkillSet aS : applicant.getSkillSets()){
                SkillFromRecrume applicantSkill = aS.getSkillFromRecrume();
                if(jobOfferSkill.equal(applicantSkill)){
                    required++;
                    break;
                }
            }
            if(jobOffer.getSkillSetForJobOffers().size() == required){
                matcher.setJobOffer(jobOffer);
                matcher.setApplicant(applicant);
                break;
            }
        }
        return matchersRepo.save(matcher);
    }

    public Matcher updateOne(int id, MatcherDTO matcherDTO) {
        Matcher matcher = matchersRepo.findById(id);
        matcher.setApplicant(applicantsRepo.findFirstById(matcherDTO.getApplicant_id()));
        matcher.setJobOffer(jobOffersRepo.findFirstById(matcherDTO.getJob_offer_id()));
        return matchersRepo.save(matcher);
    }

    public String finalizedMatch(int id) {
        Matcher matcher = matchersRepo.findById(id);
        matcher.setNotFinalized(true);
        matchersRepo.save(matcher);
        return "Your match is finalized";
    }

//    public String deleteManualMatch(int id) {
//        matchersRepo.deleteById(id);
//        return "Successfully deleted";
//    }
}
