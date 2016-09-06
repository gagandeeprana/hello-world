package dpu.dao.admin.impl;

import dpu.dao.admin.UserDAO;
import dpu.dao.common.ConnectDB;
import email.SendSMTP;
import email.SendSMTPUsingEmailTemplate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImpl implements UserDAO {

    @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(TrackingDAOImpl.class);

    @Override
    public String retrievePassword(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String msg = "";
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from usermaster where username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                msg = new SendSMTP().sendMail(rs.getString("email"), "Your Password is:<br/>" + rs.getString("password"), "Regarding Your Password Recovery");
            }
        } catch (Exception e) {
            System.out.println("exception in forgotPassword " + e);
        }
        return msg;
    }

    @Override
    public String sendMail(String emailTo, String subject, String body) {
        String msg = "";
        try {
            msg = new SendSMTPUsingEmailTemplate().sendMail(emailTo, body, subject);
        } catch (Exception e) {
            System.out.println("exception in sendMail " + e);
        }
        return msg;
    }

}
