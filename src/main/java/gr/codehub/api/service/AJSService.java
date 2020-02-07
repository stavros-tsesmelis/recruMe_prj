package gr.codehub.api.service;

//import gr.codehub.api.dto.ApplicantDTO;
import gr.codehub.api.dto.ApplicantDTO;
import gr.codehub.api.dto.SkillFromRecrumeDTO;
import gr.codehub.api.model.*;
import gr.codehub.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AJSService {
    @Autowired
    private Applicants applicantsRepo;

    @Autowired
    private Companies companiesRepo;

    @Autowired
    private JobOffers jobOffersRepo;

    @Autowired
    private SkillFromRecrumes skillFromRecrumeRepo;

    @Autowired
    private SkillSetForJobOffers skillSetForJobOffers;

    public List<Company> getCompanies(){return companiesRepo.findAll();}
    public Company getCompanyByRegion(String region){return companiesRepo.findFirstByRegion(region);}
    public Optional<List<Company>> getCompaniesByRegion(String region){return  companiesRepo.findAllByRegion(region);}

    public List<JobOffer> getJobOffers() {
        return jobOffersRepo.findAll();
    }

    public JobOffer getJobOfferById(int id){
        //Deuteros tropos.
        return jobOffersRepo.findFirstByCompanyId(id);
       /* //Prwtos tropos.
        JobOffer jo = jobOffersRepo.findById(id).get();
        return jo;*/
    }

    public List<Applicant> getAllApplicantsFromDB() {
        return applicantsRepo.findAll();
    }

    public List<SkillFromRecrume> getAllSkillsFromDB() {
        return skillFromRecrumeRepo.findAll();
    }

    public List<Company> getAllCompaniesFromDB() {
        return companiesRepo.findAll();
    }

    public Applicant getApplicantFromDB(int id) {
        return applicantsRepo.findById(id);
    }

    public JobOffer getJobOfferByNameFromDB(String name) {
        return jobOffersRepo.findByName(name);
    }

    public Applicant getApplicantByNameFromDB(String lastName) {
        return applicantsRepo.findByName(lastName);
    }

    public Optional<List<Applicant>> getApplicantByRegionFromDB(String region) {
        return  applicantsRepo.findAllByRegion(region);
    }

    public SkillFromRecrume getSkillByIdFromDB(int id) {
        return skillFromRecrumeRepo.findById(id);
    }

    public List<JobOffer> getJobOffersBySkillFromDB(String skill) {
        //return  skillSetForJobOffers.findAllBySkillFromRecrume(skill);
       // return jobOffersRepo.findBySkill(skill);
        Iterator<JobOffer> jobOfferIterator = jobOffersRepo.findAll().iterator();
        List<JobOffer> requestedJobOffers = new ArrayList<>();
        while(jobOfferIterator.hasNext()){
            JobOffer jobOffer = jobOfferIterator.next();
            for(SkillSetForJobOffer s: jobOffer.getSkillSetForJobOffers()){
                if(s.getSkillFromRecrume().getSkillName().equals(skill)){
                    requestedJobOffers.add(jobOffer);
                    break;
                }
            }
        }
        return requestedJobOffers;
    }

    public List<Applicant> getApplicantsBySkillFromDB(String skill) {
        Iterator<Applicant> applicantIterator = applicantsRepo.findAll().iterator();
        List<Applicant> requestedApplicants = new ArrayList<>();
        while(applicantIterator.hasNext()){
            Applicant applicant = applicantIterator.next();
            for(SkillSet s: applicant.getSkillSets()){
                if(s.getSkillFromRecrume().getSkillName().equals(skill)){
                    requestedApplicants.add(applicant);
                    break;
                }
            }
        }
        return requestedApplicants;
    }

    public SkillFromRecrume save(SkillFromRecrumeDTO skillFromRecrumeDTO) {
        SkillFromRecrume skillFromRecrume = new SkillFromRecrume();
        skillFromRecrume.setSkillName(skillFromRecrumeDTO.getSkillName());
//        skillFromRecrume.setSkillSets(skillFromRecrumeDTO.getSkillSets());
//        skillFromRecrume.setSkillSetForJobOffers(skillFromRecrumeDTO.getSkillSetForJobOffers());
        return skillFromRecrumeRepo.save(skillFromRecrume);
    }

//    public JobOffer getJobOfferByDate(Date date) {
//        return  jobOffersRepo.findByDate(date);
//    }

    public Applicant save(ApplicantDTO applicantDTO) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDTO.getFirstName());
        applicant.setLastName(applicantDTO.getLastName());
        applicant.setDateOfRegistration(applicantDTO.getDateOfRegistration());
        applicant.setYearsOfExperience(applicantDTO.getYearsOfExperience());
        applicant.setRegion(applicantDTO.getRegion());
        applicant.setEmail(applicantDTO.getEmail());
        applicant.setProfession(applicantDTO.getProfession());
        return applicantsRepo.save(applicant);
    }
}
