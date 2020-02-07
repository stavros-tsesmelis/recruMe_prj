package gr.codehub.api.controller;

//import gr.codehub.api.dto.ApplicantDTO;
import gr.codehub.api.model.Applicant;
import gr.codehub.api.model.Company;
import gr.codehub.api.model.JobOffer;
import gr.codehub.api.model.SkillFromRecrume;
import gr.codehub.api.service.AJSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerRestful {

    @Autowired
    private AJSService ajsService;

    @GetMapping("applicants")
    public List<Applicant> getAllApplicants() {
        return ajsService.getAllApplicantsFromDB();
    }

    @GetMapping("applicant/{id}")
    public Applicant getAllApplicantById(@PathVariable int id) {
        return ajsService.getApplicantFromDB(id);
    }

    @GetMapping("applicants/{lastName}")
    public Applicant getApplicantByName(@PathVariable String lastName) {
        return ajsService.getApplicantByNameFromDB(lastName);
    }

    @GetMapping("applicantss/{region}")
    public Optional<List<Applicant>>getApplicantByRegion(@PathVariable String region) {
        Optional<List<Applicant>> applicants = ajsService.getApplicantByRegionFromDB(region);
        return applicants;
    }
//
//    @GetMapping("skills")
//    public List<SkillFromRecrume> getAllSkills() {
//        return ajsService.getAllSkillsFromDB();
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
        //System.out.println(offer);
        return offer;
    }

    @GetMapping("joboffer/{name}")
    public JobOffer getJobOfferByName(@PathVariable String name) {
        JobOffer offer =  ajsService.getJobOfferByNameFromDB(name);
        return offer;
    }
//    @GetMapping("joboffer/{date}")
//    public JobOffer getJobOfferByDate(@PathVariable Date date){
//        JobOffer offer = ajsService.getJobOfferByDate(date);
//        //System.out.println(offer);
//        return offer;
//    }

    @GetMapping("companies")
    public List<Company> getCompanies() {
        return ajsService.getAllCompaniesFromDB();
    }
    @GetMapping("company/{region}")  //Auth sou gyrnaei tin prwth etaireia pou tha vrei me region gia paradeigma Athens
    public Company getFirstJobOfferByRegion(@PathVariable String region){
        Company company = ajsService.getCompanyByRegion(region);
        //System.out.println(offer);
        return company;
    }

    @GetMapping("companies/{region}") //Enw edw sou gyrnaw oles tis etaireies me region tade.
    public Optional<List<Company>> getJobOffersByRegion(@PathVariable String region){
        Optional<List<Company>> companies = ajsService.getCompaniesByRegion(region);
        //System.out.println(offer);
        //----> Skills.Java.setSkillToDB();
        return companies;
    }

//    @PostMapping("newApplicant")
//    public Applicant newApplicant(@RequestBody ApplicantDTO applicantDTO) {
//        return ajsService.save(applicantDTO);
//    }
}
