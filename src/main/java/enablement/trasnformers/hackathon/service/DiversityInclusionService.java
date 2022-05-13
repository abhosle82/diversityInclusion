package enablement.trasnformers.hackathon.service;

import enablement.trasnformers.hackathon.entities.CompanyDiversityInfo;
import enablement.trasnformers.hackathon.entities.LeaderDiversityInfo;

import java.util.List;

public interface DiversityInclusionService {
    public void saveCompanyDiversityInfo(List<CompanyDiversityInfo> lsCompanyDI);
    public void saveLeaderDiversityInfo(List<LeaderDiversityInfo> lsLeaderDI);
}
