package repos;

import models.AwardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardDetailsRepository extends JpaRepository<AwardDetails, Long> {
    AwardDetails findByFilenameAndLandname(String filename,String landname);


}