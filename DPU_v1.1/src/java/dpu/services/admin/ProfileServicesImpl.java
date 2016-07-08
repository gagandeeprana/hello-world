/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.ProfileBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class ProfileServicesImpl implements ProfileServicesDAO {

    @Override
    public String updateProfile(ProfileBean obj) {
        String result = "Failed to Update Profile";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("update userdetail set name=?,gender=?,dob=?,phone=?,mobile=?,email=?,address=?,country_id=?,state_id=?,city_id=?,pin_code=? where user_id=?");
            pstmt.setString(1, obj.getTxtName());
            pstmt.setString(2, obj.getRbGender());
            pstmt.setString(3, obj.getTxtDOB());
            pstmt.setString(4, obj.getTxtPhone());
            pstmt.setString(5, obj.getTxtMobile());
            pstmt.setString(6, obj.getTxtEmail());
            pstmt.setString(7, obj.getTxtAddress());
            pstmt.setInt(8, obj.getDdlCountry());
            pstmt.setInt(9, obj.getDdlState());
            pstmt.setInt(10, obj.getDdlCity());
            pstmt.setString(11, obj.getTxtPin());
            pstmt.setString(12, obj.getUserId());
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Profile Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("addProfile(): " + e);
        }
        return result;
    }

    @Override
    public ProfileBean getUserInfoById(int id) {
        System.out.println("*********" + id);
        PreparedStatement pstmt = null;
        Connection conn = null;
        ProfileBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from userdetail where user_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new ProfileBean();
                obj.setUserId(rs.getString("user_id"));
                obj.setTxtName(rs.getString("name"));
                obj.setRbGender(rs.getString("gender"));
                obj.setFlImage(rs.getString("profile_pic_path"));
                obj.setTxtDOB(rs.getString("dob"));
                obj.setTxtPhone(rs.getString("phone"));
                obj.setTxtMobile(rs.getString("mobile"));
                obj.setTxtEmail(rs.getString("email"));
                obj.setTxtAddress(rs.getString("address"));
                obj.setDdlCountry(rs.getInt("country_id"));
                obj.setDdlState(rs.getInt("state_id"));
                obj.setDdlCity(rs.getInt("city_id"));
                obj.setTxtPin(rs.getString("pin_code"));
            }
        } catch (Exception e) {
            System.out.println("getUserInfoById(): " + e);
        }
        return obj;
    }
    @Override
     public String updateProfileImage(String fileName,String userid) {
        String result = "Failed to update Profile Image";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("update userdetail set profile_pic_path=? where user_id=?");
            pstmt.setString(1, fileName);
            pstmt.setString(2, userid);
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Profile Image Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updateProfileImage(): " + e);
        }
        return result;
    }
}
