package getChangePassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import models.User;

import java.util.List;


@Service

@Repository
public class GetChangePasswordServiceimp implements getChangePassword.GetChangePasswordService {


  @Autowired
  PasswordEncoder encoder;

  @Autowired
  GetChangePasswordDao dao;


  public List<User> updatealldetails(String username, String password_encrypted) {

    encoder.encode(password_encrypted);

    return dao.updatealldetails(username, password_encrypted);
  }


}


