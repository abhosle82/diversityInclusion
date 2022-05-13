package enablement.trasnformers.hackathon.repositories;

import enablement.trasnformers.hackathon.entities.CompanyDiversityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDiversityInfoRepository extends JpaRepository<CompanyDiversityInfo,Integer> {
}
