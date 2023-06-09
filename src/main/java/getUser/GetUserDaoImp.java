package getUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GetUserDaoImp implements GetUserDao {

  @Autowired
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;


  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/landdigit");
    dataSource.setUsername("root");
    dataSource.setPassword("yazhini1998");

  }

  @Override
  public List<User> getalldetail() {
    List<User> domain = new ArrayList<>();
    String sqlQuery = " Select * from landdigit.users ";
    domain = namedParameterJdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(User.class));
    return domain;
  }


  public List<User> updatealldetail(String username, String role, String group_name, String admin, String password_encrypted, String devteam,
                                    String prodaccess) {


    String sqlQuery = " Update landdigit.users SET username = '" + username + "'   WHERE id = 2 ";

    String DB_URL = "jdbc:mysql://localhost:3306/landdigit";
    String USER = "root";
    String PASS = "yazhini1998";


    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement()
    ) {

      stmt.executeUpdate(sqlQuery);
    } catch (SQLException e) {
      System.out.println(e);
    }


    List<User> domain = new ArrayList<>();
    String sqlQuery1 = " Select * from landdigit.users ";
    domain = namedParameterJdbcTemplate.query(sqlQuery1, new BeanPropertyRowMapper<>(User.class));


    return domain;

  }


}
