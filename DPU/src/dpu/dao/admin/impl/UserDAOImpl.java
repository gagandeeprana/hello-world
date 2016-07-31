package dpu.dao.admin.impl;

import dpu.dao.admin.UserDAO;
import dpu.dao.common.ConnectDB;
import email.SendSMTP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

public class UserDAOImpl implements UserDAO {

    ConnectDB connectDB = ConnectDB.getInstance();
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
                msg = new SendSMTP().sendMail(rs.getString("email"), "Dispatch Processing Unit\nYour Password is:\n" + rs.getString("password"), "Regarding Your Password Recovery");
            }
        } catch (Exception e) {
            System.out.println("exception in forgotPassword " + e);
        }
        return msg;
    }

}
