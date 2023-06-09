package getUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import models.User;

import java.util.List;

@Service
public class GetUserServiceImp implements getUser.GetUserService {


  @Autowired
  GetUserDao dao;

  @Override
  public List<User> getalldetail() {
    return dao.getalldetail();
  }

  public List<User> updatealldetail(String username, String role, String group_name, String admin, String password_encrypted, String devteam,
                                    String prodaccess) {

    return dao.updatealldetail(username, role, group_name, admin, password_encrypted, devteam, prodaccess);
  }


}

