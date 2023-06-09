package models;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class LanDetailsResponseModel {

    // First tab
    private BigDecimal id;
    private String village;
    private String circle;
    private String citynrural;
    private String division;
    private String geo_tagging_geo_fencing;
    private String land_name;
    private String unique_code;
    
    // Second tab
    private List<FirstTabModel> firstTabList;

    private List<Object> secondTabList;
    private List<Object> thirdTabList;
    private List<Object> fourthTabList;
    private List<Object> fifthTabList;
    private List<Object> sixthTabList;
    private List<Object> seventhTabList;
    
}
