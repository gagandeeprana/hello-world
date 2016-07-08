package dpu.services.admin;

import dpu.beans.admin.AddEditDealerBean;
import dpu.beans.admin.DealersBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sikka
 */
public class DealersServicesImpl implements DealersServicesDAO {

    @Override
    public List<DealersBean> getAllDealers(String Location, String name) {
        List<DealersBean> lstDealers = new ArrayList<>();
        StringBuilder query = new StringBuilder("select * from usermaster um,userdetail ud where um.user_id=ud.user_id and address like '%" + Location + "%' and  name like '%" + name + "%' and user_type='dealer'");
        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DealersBean obj = new DealersBean();
                obj.setDealerId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setContact(rs.getString("phone"));
                obj.setMail(rs.getString("email"));
                if (rs.getString("user_status").equalsIgnoreCase("active")) {

                    obj.setStatus(1);
                } else {
                    obj.setStatus(0);

                }
                lstDealers.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllDealers(): " + e);
        }
        return lstDealers;
    }

    @Override
    public String addDealers(AddEditDealerBean obj) {
        String result = "Failed to add Dealer";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("insert into dealermaster(username,password,name,phone_office,phone_mobile,email,address,country_id,state_id,city_id,pin_code,user_status) values(?,?,?,?,?,?,?,?,?,?,?,1)");
            pstmt.setString(1, obj.getTxtUsername());
            pstmt.setString(2, obj.getTxtPassword());
            pstmt.setString(3, obj.getTxtName());
            pstmt.setString(4, obj.getTxtDob());
            pstmt.setString(5, obj.getTxtMobile());
            pstmt.setString(6, obj.getTxtEmail());
            pstmt.setString(7, obj.getTaAddress());
            pstmt.setInt(8, obj.getDdlCountry());
            pstmt.setInt(9, obj.getDdlState());
            pstmt.setInt(10, obj.getDdlCity());
            pstmt.setString(11, obj.getTxtPin());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Dealer Added Successfully";
            }
        } catch (Exception e) {
            System.out.println("addDealer(): " + e);
        }
        return result;
    }

    @Override
    public DealersBean getDealerInfoById(int id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        DealersBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from usermaster um,userdetail ud  where um.user_id=? and user_type='dealer'");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new DealersBean();
                obj.setTxtDealerId(rs.getInt("user_id"));
                obj.setTxtUsername(rs.getString("username"));
                obj.setTxtPassword(rs.getString("password"));
                obj.setTxtName(rs.getString("name"));
                obj.setTxtDob(rs.getString("dob"));
                obj.setContact(rs.getString("phone"));
                obj.setTxtMobile(rs.getString("mobile"));
                obj.setTxtEmail(rs.getString("email"));
                obj.setTaAddress(rs.getString("address"));
                obj.setDdlCountry(rs.getInt("country_id"));
                obj.setDdlState(rs.getInt("state_id"));
                obj.setDdlCity(rs.getInt("city_id"));
                obj.setTxtPin(rs.getString("pin_code"));
            }
        } catch (Exception e) {
            System.out.println("getDealerInfoById(): " + e);
        }
        return obj;
    }

    @Override
    public String updateDealer(AddEditDealerBean obj) {
        String result = "Failed to update dealer";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("update dealermaster set username=?,password=?,name=?,phone_office=?,phone_mobile=?,email=?,address=?,country_id=?,state_id=?,city_id=?,pin_code=? where dealer_id=?");
            pstmt.setString(1, obj.getTxtUsername());
            pstmt.setString(2, obj.getTxtPassword());
            pstmt.setString(3, obj.getTxtName());
            pstmt.setString(4, obj.getTxtDob());
            pstmt.setString(5, obj.getTxtMobile());
            pstmt.setString(6, obj.getTxtEmail());
            pstmt.setString(7, obj.getTaAddress());
            pstmt.setInt(8, obj.getDdlCountry());
            pstmt.setInt(9, obj.getDdlState());
            pstmt.setInt(10, obj.getDdlCity());
            pstmt.setString(11, obj.getTxtPin());
            pstmt.setString(12, obj.getTxtDealerId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Dealer Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updateDealer(): " + e);
        }
        return result;
    }

    @Override
    public String changeStatus(int status, int dealerId) {
        String result = "Failed To Update Status";
        if (status == 1) {
            status = 0;
        } else {
            status = 1;
        }
        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("update dealermaster set user_status=? where dealer_id=?");
            pstmt.setInt(1, status);
            pstmt.setInt(2, dealerId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Status changed successfully";
            }
        } catch (Exception e) {
            System.out.println("changeStatus(): " + e);
        }
        return result;
    }
}
