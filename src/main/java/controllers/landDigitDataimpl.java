package controllers;


import models.LandDigitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class landDigitDataimpl implements landDigitDataDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/landdigit");
        dataSource.setUsername("root");
        dataSource.setPassword("yazhini1998");
    }

    public List<LandDigitData> getalldivisionforcircle(String circle) {
        List<LandDigitData> domain = new ArrayList<>();
        String sqlQuery = "SELECT distinct division FROM landdigit.landdigitData where circle = '" + circle + "'";
        domain = namedParameterJdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(LandDigitData.class));
        return domain;
    }


    public List<LandDigitData> getalldivisionforcircleall() {
        List<LandDigitData> domain = new ArrayList<>();
        String sqlQuery = "SELECT distinct division,citynrural FROM landdigit.landdigitData ";
        domain = namedParameterJdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(LandDigitData.class));
        return domain;
    }

}