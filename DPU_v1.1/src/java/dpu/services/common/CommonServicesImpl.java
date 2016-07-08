/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.common;

import dpu.beans.common.LoginBean;
import dpu.mail.SendSMTP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sikka
 */
public class CommonServicesImpl implements CommonServicesDAO {

    @Override
    public LoginBean authUser(String username, String password) {
        LoginBean obj = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from usermaster where username=? and password=binary(?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new LoginBean();
                obj.setUserId(rs.getInt("user_id"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setUserStatus(rs.getString("user_status"));
                obj.setUserType(rs.getString("user_type"));
            }
        } catch (Exception e) {
            System.out.println("authUser(): " + e);
        }

        return obj;
    }

    @Override
    public LoginBean checkUser(String username) {
        LoginBean obj = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from usermaster um,userdetail ud where um.user_id=ud.user_id and username=?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new LoginBean();
                obj.setUserId(rs.getInt("user_id"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setEmail(rs.getString("email"));
                obj.setUserStatus(rs.getString("user_status"));
                obj.setUserType(rs.getString("user_type"));
            }
        } catch (Exception e) {
            System.out.println("checkUser(): " + e);
        }

        return obj;
    }

    @Override
    public String forgotPassword(String username) {
        String result = "No such user exists in our records";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from usermaster um left join userdetail ud on um.user_id=ud.user_id where username=?");
            pstmt.setString(1, username);
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = new SendSMTP().sendMail(rs.getString("email"), "Your BugFix Recovery Password Is:" + rs.getString("password"), "BugFix Recovery Password Email");
                if (result.equalsIgnoreCase("sent")) {
                    result = "Password Sent Successfully to Your Email-ID";
                } else {
                    result = "Something gone wrong while Sending Password to Your Email-ID";
                }
            }
        } catch (Exception e) {
            System.out.println("forgotPassword(): " + e);
        }
        return result;
    }

    @Override
    public String forgotPasswordUsername(String username) {
        String result = "No such user exists in our records";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from usermaster um inner join userdetail ud on um.user_id=ud.user_id where (username=? or email=?)");
            pstmt.setString(1, username);
            pstmt.setString(2, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = new SendSMTP().sendMail(rs.getString("email"), "Your recovered Password is: " + rs.getString("password"), "");
            }
        } catch (Exception e) {
            System.out.println("forgotPassword(): " + e);
        }
        return result;
    }

    @Override
    public String changePassword(String username, String oldPass, String newPass) {
        String result = "No such record exists";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {

            pstmt = conn.prepareStatement("select * from usermaster where username=? and password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, oldPass);
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            if (rs.next()) // y is there no else part??
            {
                pstmt = conn.prepareStatement("update usermaster set password=? where username=?");
                pstmt.setString(1, newPass);
                pstmt.setString(2, username);
                System.out.println(pstmt.toString());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    result = "Your password has been changed successfully";
                }
            }
        } catch (Exception e) {
            System.out.println("changePassword(): " + e);
        }
        return result;
    }

    @Override
    public String changePass(int userId, String oldPass, String newPass) {
        String result = "No such record exists";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {

            pstmt = conn.prepareStatement("select * from usermaster where user_id=? and password=?");
            pstmt.setInt(1, userId);
            pstmt.setString(2, oldPass);
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            if (rs.next()) // y is there no else part??
            {
                pstmt = conn.prepareStatement("update usermaster set password=? where user_id=?");
                pstmt.setString(1, newPass);
                pstmt.setInt(2, userId);
                System.out.println(pstmt.toString());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    result = "Your password has been changed successfully";
                }
            }
        } catch (Exception e) {
            System.out.println("changePassword(): " + e);
        }
        return result;
    }
}
