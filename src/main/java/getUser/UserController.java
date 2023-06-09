package getUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import models.User;

import java.util.List;


@RestController
@RequestMapping(value = "/api/")
public class UserController {
  @Autowired private GetUserService service;
  @GetMapping(path = "/GetUser")
  public List<User> getAllUsers() {return (service.getalldetail());}
}