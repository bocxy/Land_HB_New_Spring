package getUser;

import models.User;

import java.util.List;

public interface GetUserDao {

  List<User> getalldetail();

  List<User> updatealldetail(String username, String role, String group_name, String admin, String password_encrypted, String devteam,
                             String prodaccess);


}
