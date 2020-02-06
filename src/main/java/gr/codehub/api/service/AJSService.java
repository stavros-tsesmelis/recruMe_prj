package gr.codehub.api.service;

import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.Company;
import gr.codehub.api.model.JobOffer;
import gr.codehub.api.repositories.Applicants;
import gr.codehub.api.repositories.Companies;
import gr.codehub.api.repositories.JobOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AJSService {
    @Autowired
    private Applicants applicantsRepo;

    @Autowired
    private Companies companiesRepo;

    public List<Applicant> getApplicant() {
        return applicantsRepo.findAll();
    }
    public List<Company> getCompanies(){return companiesRepo.findAll();}

    @Autowired
    private JobOffers jobOffersRepo;

    public List<JobOffer> getJobOffers() {
        return jobOffersRepo.findAll();
    }

    public JobOffer getJobOfferById(int id){
        return jobOffersRepo.findFirstByCompanyId(id);
    }
}
