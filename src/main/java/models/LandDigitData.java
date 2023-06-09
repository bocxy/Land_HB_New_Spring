package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "landdigitData")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LandDigitData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String division;
    
    private String circle;
    
    private String citynrural;

    private String land_name;
    
    private String unique_code;

	private String Village;

	private String geo_tagging_geo_fencing;


}
