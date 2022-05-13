package enablement.trasnformers.hackathon.service;

import enablement.trasnformers.hackathon.entities.CompanyDiversityInfo;
import enablement.trasnformers.hackathon.entities.LeaderDiversityInfo;
import enablement.trasnformers.hackathon.repositories.CompanyDiversityInfoRepository;
import enablement.trasnformers.hackathon.repositories.LeaderDiversityInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityInclusionServiceImpl implements DiversityInclusionService{

    @Autowired
    private CompanyDiversityInfoRepository companyRepository;

    @Autowired
    private LeaderDiversityInfoRepository leaderRepository;



    @Override
    public void saveCompanyDiversityInfo(List<CompanyDiversityInfo> lsCompanyDI) {
        companyRepository.saveAll(lsCompanyDI);
    }

    @Override
    public void saveLeaderDiversityInfo(List<LeaderDiversityInfo> lsLeaderDI) {
        leaderRepository.saveAll(lsLeaderDI);
    }
}
