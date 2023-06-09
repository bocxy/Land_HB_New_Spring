package getChangePassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import models.User;

import java.util.List;


@RestController


@CrossOrigin("*")


@RequestMapping(value = "/api")
public class GetChangePasswordController {


  @Autowired
  PasswordEncoder encoder;


  @Autowired
  private GetChangePasswordService service;


  @RequestMapping(method = RequestMethod.PUT, path = "/changepassword", consumes = MediaType.APPLICATION_JSON_VALUE)
  public List<User> updateAllemployees(@RequestBody User user) {


    return (service.updatealldetails(user.getUsername(), encoder.encode(user.getPassword_encrypted())));


  }


}




	
	






