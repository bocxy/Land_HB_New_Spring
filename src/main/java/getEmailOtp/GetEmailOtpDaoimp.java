package getEmailOtp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

public class GetEmailOtpDaoimp {

  String myUrl = "jdbc:mysql://localhost:3306/landdigit";
  String root = "root";
  String pswd = "yazhini1998";

  public String GenetrateOTP() {

    try {
      String otp = "";
      String numbers = "1234567890";
      Random random = new Random();
      char[] ch = new char[7];

      for (int i = 0; i < 6; i++) {
        ch[i] = numbers.charAt(random.nextInt(numbers.length()));
        otp = ch[i] + otp;
      }
      return otp;
    } catch (Exception ex) {
      throw ex;
    }
  }

  public String UpdateOTPbyEmailSent(String username, String emailid, String OTP) throws Exception {
    String Infomsg = "";
    if (emailid != null && emailid != "" && OTP != null && OTP != "" && username != null && username != "") {

      Connection conc = DriverManager.getConnection(myUrl, root, pswd);
      String query = "Update landdigit.users set otp= " + "'" + OTP + "'" + " where username=" + "'" + username + "'";
      Statement stm = conc.createStatement();
      int rset = stm.executeUpdate(query);
      try {

        if (rset != 0) {
          Infomsg = username + "," + OTP;
        } else {
          Infomsg = "Failed to Update OTP";
        }
      } catch (Exception ex) {
        throw ex;
      } finally {
        stm.close();
        conc.close();

      }
    }
    return Infomsg;
  }


}