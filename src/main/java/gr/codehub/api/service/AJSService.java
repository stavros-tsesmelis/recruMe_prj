package gr.codehub.api.service;

//import gr.codehub.api.dto.ApplicantDTO;
import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.Company;
import gr.codehub.api.model.JobOffer;
import gr.codehub.api.model.SkillFromRecrume;
import gr.codehub.api.repositories.Applicants;
import gr.codehub.api.repositories.Companies;
import gr.codehub.api.repositories.JobOffers;
import gr.codehub.api.repositories.SkillFromRecrumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

//    public JobOffer getJobOfferByDate(Date date) {
//        return  jobOffersRepo.findByDate(date);
//    }

//    public Applicant save(ApplicantDTO applicantDTO) {
//        Applicant applicant = new Applicant();
//        applicant.setFirstName(applicantDTO.getFirstName());
//        applicant.setLastName(applicantDTO.getLastName());
//        applicant.setDateOfRegistration(applicantDTO.getDateOfRegistration());
//        applicant.setYearsOfExperience(applicantDTO.getYearsOfExperience());
//        applicant.setRegion(applicantDTO.getRegion());
//        applicant.setEmail(applicantDTO.getEmail());
//        applicant.setProfession(applicantDTO.getProfession());
//        return applicantsRepo.save(applicant);
//    }
}
