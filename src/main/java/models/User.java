package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  public String emailid;
  public String otp;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String role;
  private String group_name;
  private String admin;
  private String password_encrypted;
  private String devteam;
  private String prodaccess;
  private String privilege;
  private String accesslevel1;
  private String accesslevel2;
  public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getGroup_name() {
	return group_name;
}
public void setGroup_name(String group_name) {
	this.group_name = group_name;
}
public String getAdmin() {
	return admin;
}
public void setAdmin(String admin) {
	this.admin = admin;
}
public String getPassword_encrypted() {
	return password_encrypted;
}
public void setPassword_encrypted(String password_encrypted) {
	this.password_encrypted = password_encrypted;
}
public String getDevteam() {
	return devteam;
}
public void setDevteam(String devteam) {
	this.devteam = devteam;
}
public String getProdaccess() {
	return prodaccess;
}
public void setProdaccess(String prodaccess) {
	this.prodaccess = prodaccess;
}
public String getPrivilege() {
	return privilege;
}
public void setPrivilege(String privilege) {
	this.privilege = privilege;
}
public String getAccesslevel1() {
	return accesslevel1;
}
public void setAccesslevel1(String accesslevel1) {
	this.accesslevel1 = accesslevel1;
}
public String getAccesslevel2() {
	return accesslevel2;
}
public void setAccesslevel2(String accesslevel2) {
	this.accesslevel2 = accesslevel2;
}
public String getLoggedin() {
	return loggedin;
}
public void setLoggedin(String loggedin) {
	this.loggedin = loggedin;
}
public String loggedin;
}