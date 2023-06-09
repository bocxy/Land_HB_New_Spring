package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import models.User;

import java.util.List;

@Repository
public interface RepoVerifyOtp extends JpaRepository<User, Long> {

  List<User> findByUsernameAndOtp(String username, String otp);

}
