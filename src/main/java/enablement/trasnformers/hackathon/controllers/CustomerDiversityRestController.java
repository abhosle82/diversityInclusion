package enablement.trasnformers.hackathon.controllers;

import enablement.trasnformers.hackathon.entities.CompanyDiversityInfo;
import enablement.trasnformers.hackathon.service.DiversityInclusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerDiversityRestController {

    @Autowired
    DiversityInclusionService service;

    @GetMapping(value="/companies")
    public List<CompanyDiversityInfo> getAllCompanies(){
        System.out.println("in companies");
        return service.findAllCompanies();
    }
}
