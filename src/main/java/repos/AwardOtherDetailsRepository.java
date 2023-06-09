//package repos;
//
//import models.AwardOtherDetails;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface AwardOtherDetailsRepository extends JpaRepository<AwardOtherDetails, Long> {
//    AwardOtherDetails findByFilename(String filename);
//
//
//
//    List<AwardOtherDetails> findAllByNameAndLandname(String name, String landname);
//}
//


package repos;

import models.AwardOtherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardOtherDetailsRepository  extends JpaRepository<AwardOtherDetails, Long> {


    List<AwardOtherDetails> findByNameAndLandname(String name, String landname);
}