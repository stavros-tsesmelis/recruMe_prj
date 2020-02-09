package gr.codehub.api.service;

//import gr.codehub.api.dto.ApplicantDTO;

import gr.codehub.api.dto.*;
import gr.codehub.api.exception.ApplicantNotFoundException;
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

    @Autowired
    private SkillSets skillSetsRepo;

    @Autowired
    private SkillSetForJobOffers skillSetForJobOffersRepo;

    public List<Company> getCompanies() {
        return companiesRepo.findAll();
    }

    public Company getCompanyByRegion(String region) {
        return companiesRepo.findFirstByRegion(region);
    }

    public Optional<List<Company>> getCompaniesByRegion(String region) {
        return companiesRepo.findAllByRegion(region);
    }

    public List<JobOffer> getJobOffers() {
        return jobOffersRepo.findAll();
    }

    public JobOffer getJobOfferById(int id) {
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

//    public Applicant getApplicantFromDB(int id) throws ApplicantNotFoundException {
//        try {
//            return applicantsRepo.findById(id);
//        }catch (Exception e){
//            throw new ApplicantNotFoundException("Applicant id = " + id);
//        }
//    }


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
        return applicantsRepo.findAllByRegion(region);
    }

    public SkillFromRecrume getSkillByIdFromDB(int id) {
        return skillFromRecrumeRepo.findById(id);
    }

    public List<JobOffer> getJobOffersBySkillFromDB(String skill) {
        //return  skillSetForJobOffers.findAllBySkillFromRecrume(skill);
        // return jobOffersRepo.findBySkill(skill);
        Iterator<JobOffer> jobOfferIterator = jobOffersRepo.findAll().iterator();
        List<JobOffer> requestedJobOffers = new ArrayList<>();
        while (jobOfferIterator.hasNext()) {
            JobOffer jobOffer = jobOfferIterator.next();
            for (SkillSetForJobOffer s : jobOffer.getSkillSetForJobOffers()) {
                if (s.getSkillFromRecrume().getSkillName().equals(skill)) {
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
        while (applicantIterator.hasNext()) {
            Applicant applicant = applicantIterator.next();
            for (SkillSet s : applicant.getSkillSets()) {
                if (s.getSkillFromRecrume().getSkillName().equals(skill)) {
                    requestedApplicants.add(applicant);
                    break;
                }
            }
        }
        return requestedApplicants;
    }

    public SkillFromRecrume save(SkillFromRecrumeDTO skillFromRecrumeDTO) {   //Method post for skill from recrume
        SkillFromRecrume skillFromRecrume = new SkillFromRecrume();
        skillFromRecrume.setSkillName(skillFromRecrumeDTO.getSkillName());
//        skillFromRecrume.setSkillSets(skillFromRecrumeDTO.getSkillSets());
//        skillFromRecrume.setSkillSetForJobOffers(skillFromRecrumeDTO.getSkillSetForJobOffers());
        return skillFromRecrumeRepo.save(skillFromRecrume);
    }

//    public JobOffer getJobOfferByDate(Date date) {
//        return  jobOffersRepo.findByDate(date);
//    }

    public Applicant save(ApplicantDTO applicantDTO) {   //Method post for applicants
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

    public List<JobOffer> getJobOfferOfACompany(String nameOfCompany, String nameOfJob) {
        Iterator<JobOffer> jobOfferIterator = jobOffersRepo.findAll().iterator();
        List<JobOffer> requestedJobOffers = new ArrayList<>();
        while (jobOfferIterator.hasNext()) {
            //pare to epomeno joboffer apo to iterator
            JobOffer jobOffer = jobOfferIterator.next();
            //ean to onoma tis etaireias tou joboffer isodinamei me to name pou ziti8ike kai
            if (jobOffer.getCompany().getCompanyName().equals(nameOfCompany) && jobOffer.getJobOfferName().equals(nameOfJob)) {
                //ean to name tou joboffer einai to idio me to name p ziti8ike, tote mpes mesa sto if
                //a einai? oraia balto sta joboffers pou 8a dikso ston user
                requestedJobOffers.add(jobOffer);
                //Vres ta ola kai emfanise ta mou!!
            }
        }
        return requestedJobOffers;
    }



    public JobOffer save(JobOfferDTO jobOfferDTO) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setApplicant(applicantsRepo.findFirstById(jobOfferDTO.getApplicant_id()));
        jobOffer.setCompany(companiesRepo.findFirstById(jobOfferDTO.getCompany_id()));
        jobOffer.setJobOfferName(jobOfferDTO.getJobOfferName());
        jobOffer.setDateOfOffer(jobOfferDTO.getDateOfOffer());
        return jobOffersRepo.save(jobOffer);
    }

    public SkillSet createSkillSet(SkillSetDTO skillSetDTO) {
        SkillSet skillSet = new SkillSet();
        skillSet.setApplicant(applicantsRepo.findFirstById(skillSetDTO.getApplicant_id()));
        skillSet.setSkillFromRecrume(skillFromRecrumeRepo.findFirstById(skillSetDTO.getSkill_from_recrume_id()));
        return skillSetsRepo.save(skillSet);

    }

    public SkillSetForJobOffer createSkillSetForJobOffer(SkillSetForJobOfferDTO skillSetForJobOfferDTO) {
        SkillSetForJobOffer skillSetForJobOffer = new SkillSetForJobOffer();
        skillSetForJobOffer.setJobOffer(jobOffersRepo.findFirstById(skillSetForJobOfferDTO.getJob_offer_id()));
        skillSetForJobOffer.setSkillFromRecrume(skillFromRecrumeRepo.findFirstById(skillSetForJobOfferDTO.getSkill_from_recrume_id()));
        return skillSetForJobOffersRepo.save(skillSetForJobOffer);
    }

    public Company createNewCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setCompanyName(companyDTO.getCompanyName());
        company.setRegion(companyDTO.getRegion());
        return companiesRepo.save(company);
    }

//    public SkillFromRecrume createNewMergeSkillFromRecrume(SkillFromRecrumeDTO skillFromRecrumeDTO1, SkillFromRecrumeDTO skillFromRecrumeDTO2) {
//        SkillFromRecrume skillFromRecrume = new SkillFromRecrume();
//        skillFromRecrume.setSkillName(skillFromRecrumeDTO1.getSkillName());
//        return skillFromRecrumeRepo.save(skillFromRecrume);
//    }
}
