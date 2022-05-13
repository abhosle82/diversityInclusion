package enablement.trasnformers.hackathon.repositories;

import enablement.trasnformers.hackathon.entities.LeaderDiversityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderDiversityInfoRepository extends JpaRepository<LeaderDiversityInfo,Integer> {
}
