package repos;


import models.LandDigitData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LandDigitDataRepo extends JpaRepository<LandDigitData, Long> {


    List<LandDigitData> findByDivision(String values);

    List<LandDigitData> findByCircle(String values);

    List<LandDigitData> findByCitynrural(String values);
    
    Optional<LandDigitData> findById(Long id);



}