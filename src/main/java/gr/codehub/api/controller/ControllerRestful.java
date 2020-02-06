package gr.codehub.api.controller;


import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.Company;
import gr.codehub.api.model.JobOffer;
import gr.codehub.api.service.AJSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ControllerRestful {

    @Autowired
    private AJSService ajsService;

//    @GetMapping("applicants")
//    public List<Applicant> getAllApplicants() {
//        return ajsService.getCompanies();
//    }

    @GetMapping("joboffers")
    public List<JobOffer> getAllJobOffers(){
        List<JobOffer> offers = ajsService.getJobOffers();
        System.out.println(offers.size());
        return offers;
    }

    @GetMapping("joboffers/{id}")
    public JobOffer getJobOfferById(@PathVariable int id){
        JobOffer offer = ajsService.getJobOfferById(id);
        System.out.println(offer);
        return offer;
    }

//    @GetMapping("test")
//    public JobOffer test(){
//        JobOffer offer = new JobOffer();
//        offer.setCompany(new Company());
//        offer.setDateOfOffer(new Date());
//        offer.setId(6);
//        return offer;
//    }
//
//    @GetMapping("add")
//    public String add(){
//        JobOffer offer = new JobOffer();
//        Company company = new Company();
//        company.setCompanyName("Trakter");
//        company.setId(3);
//        company.setRegion("Athens");
//        company.setCompanyName("Alphabank");
//        return "ok LOL";
//    }

}
