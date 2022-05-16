package enablement.trasnformers.hackathon;

import enablement.trasnformers.hackathon.poi.DiversityInclusion;
import enablement.trasnformers.hackathon.poi.DiversityInclusionFactory;
import enablement.trasnformers.hackathon.service.DiversityInclusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class DiversityInclusionApplication implements CommandLineRunner {

    @Autowired
    DiversityInclusionService diversityInclusionService;

    public static void main(String[] args) {
        SpringApplication.run(DiversityInclusionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DiversityInclusion objDAndI = DiversityInclusionFactory.createDiversityInclusion("DI");
        objDAndI.readDiversityOwnedData();
        //System.out.println("Companies");
        //System.out.println(objDAndI.getCompanies());

        //System.out.println("Leaders");
        //System.out.println(objDAndI.getLeaders());

        //diversityInclusionService.saveCompanyDiversityInfo(objDAndI.getCompanies());
        //diversityInclusionService.saveLeaderDiversityInfo(objDAndI.getLeaders());

        System.out.println("######### Inserted Successfully ########");

    }
}
