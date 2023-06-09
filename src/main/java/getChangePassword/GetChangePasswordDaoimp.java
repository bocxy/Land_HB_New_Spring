package getChangePassword;

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
public class GetChangePasswordDaoimp implements GetChangePasswordDao {
  @Autowired
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/landdigit");
    dataSource.setUsername("root");
    dataSource.setPassword("yazhini1998");
  }
  public List<User> updatealldetails(String username, String password_encrypted) {

    String sqlQuery = " Update landdigit.users SET password_encrypted = '" + password_encrypted + "'"
            + " WHERE username = '" + username + "' ";
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