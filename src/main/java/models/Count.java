package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "count")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Count {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String division;
  private String circle;
  private String citynrural;
  private String totalcount;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public String getCircle() {
	return circle;
}
public void setCircle(String circle) {
	this.circle = circle;
}
public String getCitynrural() {
	return citynrural;
}
public void setCitynrural(String citynrural) {
	this.citynrural = citynrural;
}
public String getTotalcount() {
	return totalcount;
}
public void setTotalcount(String totalcount) {
	this.totalcount = totalcount;
}


}