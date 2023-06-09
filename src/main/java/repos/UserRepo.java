package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import models.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  User findByAdmin(String admin);

  User findByUsername(String username);


}
