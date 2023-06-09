package repos;



import org.springframework.data.jpa.repository.JpaRepository;
import models.Count;
import java.util.List;

public interface CountRepo extends JpaRepository<Count, Long> {


    List<Count> findByDivision(String values);

    List<Count> findByCircle(String values);

    List<Count> findByCitynrural(String values);
    
   
}