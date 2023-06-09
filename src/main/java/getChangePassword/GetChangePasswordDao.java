package getChangePassword;

import models.User;

import java.util.List;

public interface GetChangePasswordDao {


  List<User> updatealldetails(String username, String password_encrypted);
}