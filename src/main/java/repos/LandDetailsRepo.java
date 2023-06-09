package repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.User;

public interface LandDetailsRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT id,village,circle,citynrural,division,geo_tagging_geo_fencing,land_name,unique_code FROM landdigit.landdigit_data where id= ?1", nativeQuery = true)
    List<Object[]> getFirstTabDetails(int id);

}
