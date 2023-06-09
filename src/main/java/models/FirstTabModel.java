package models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FirstTabModel {
    
    private BigDecimal id;
    private String village;
    private String circle;
    private String citynrural;
    private String division;
    private String geo_tagging_geo_fencing;
    private String land_name;
    private String unique_code;
}
