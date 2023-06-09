package getUser;

public class LoginRequest {


  private String username;
  private String password_encrypted;
  private String role;

  public LoginRequest(String username, String password_encrypted, String role) {
    super();
    this.username = username;
    this.password_encrypted = password_encrypted;
    this.role = role;

  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword_encrypted() {
    return password_encrypted;
  }

  public void setPassword_encrypted(String password_encrypted) {
    this.password_encrypted = password_encrypted;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


}
