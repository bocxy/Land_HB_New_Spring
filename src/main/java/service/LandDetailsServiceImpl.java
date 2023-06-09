package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import models.FirstTabModel;
import models.LanDetailsResponseModel;
import repos.LandDetailsRepo;

public class LandDetailsServiceImpl implements LandDetailsService {

    @Autowired
    LandDetailsRepo landDetailsRepo;

    @Override
    public LanDetailsResponseModel getAllLandDetails(int id) {

        LanDetailsResponseModel LanDetailsResponseModel = new LanDetailsResponseModel();

        List<Object[]> firstTabList = landDetailsRepo.getFirstTabDetails(id);

        List<FirstTabModel> firstTabArray = new ArrayList<FirstTabModel>();

        for (Object[] values : firstTabList) {

            FirstTabModel obj = new FirstTabModel();

            obj.setId(values[0] != null ? (BigDecimal) values[0] : null);
            obj.setVillage(values[1] != null ? values[1].toString() : null);
            obj.setCircle(values[2] != null ? values[2].toString() : null);
            obj.setCitynrural(values[3] != null ? values[3].toString() : null);
            obj.setDivision(values[4] != null ? values[4].toString() : null);
            obj.setGeo_tagging_geo_fencing(values[5] != null ? values[5].toString() : null);
            obj.setLand_name(values[6] != null ? values[6].toString() : null);
            obj.setUnique_code(values[7] != null ? values[7].toString() : null);
            firstTabArray.add(obj);
        }

        LanDetailsResponseModel.setFirstTabList(firstTabArray);
        return LanDetailsResponseModel;
    }

}
