package enablement.trasnformers.hackathon.poi;

import enablement.trasnformers.hackathon.entities.CompanyDiversityInfo;
import enablement.trasnformers.hackathon.entities.LeaderDiversityInfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DiversityInclusion {
    public void readDiversityOwnedData() throws IOException;
    public List<LeaderDiversityInfo> getLeaders();
    public List<CompanyDiversityInfo> getCompanies();
}
