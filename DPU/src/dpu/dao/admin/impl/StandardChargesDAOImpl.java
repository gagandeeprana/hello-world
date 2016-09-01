/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.StandardChargesBean;
import dpu.dao.admin.StandardChargesDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class StandardChargesDAOImpl implements StandardChargesDAO {

    ConnectDB connectDB = ConnectDB.getInstance();
    Logger logger = Logger.getLogger(StandardChargesDAOImpl.class);

    @Override
    public List<StandardChargesBean> getAllStandardCharges(String name) {
        List<StandardChargesBean> lstStandardCharges = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from standard_charges where name like ? order by name");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                StandardChargesBean obj = new StandardChargesBean();
                obj.setStandardChargesId(rs.getInt("standard_charge_id"));
                obj.setCode(rs.getString("name"));
                obj.setChargeType1(rs.getInt("charge_type1"));
                obj.setDescription(rs.getString("description"));
                obj.setAmountAs(rs.getInt("amount_as"));
                obj.setBaseCharge(rs.getString("base_charge"));
                obj.setMaxCharge(rs.getString("max_charge"));
                obj.setChargeType2(rs.getInt("charge_type2"));
                obj.setStatus(rs.getInt("status"));
                obj.setIncludeChargeAmount(rs.getInt("include_charge_amount"));
                obj.setCalculateFuelSurcharge(rs.getInt("calculate_fuel_surcharge"));
                obj.setIncludeDriverPayroll(rs.getInt("include_driver_payroll"));
                lstStandardCharges.add(obj);
            }
        } catch (Exception e) {
            logger.error("StandardChargesDAOImpl : getAllStandardCharges : " + e);
        }
        return lstStandardCharges;
    }

//    @Override
//    public String addStandardCharges(StandardChargesBean obj) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("insert into standard_charges values(?,?)");
//            pstmt.setInt(1, obj.getStandardChargesId());
//            pstmt.setString(2, obj.getStandardCharges());
//            int i = pstmt.executeUpdate();
//            if (i > 0) {
//                return "StandardCharges Added";
//            }
//        } catch (Exception e) {
//            logger.error("StandardChargesDAOImpl : addStandardCharges : " + e);
//        }
//        return "Failed to Add StandardCharges";
//    }
//
//    @Override
//    public String updateStandardCharges(StandardChargesBean obj) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("update standard_charges set name = ? where division_id = ?");
//            pstmt.setString(1, obj.getStandardCharges());
//            pstmt.setInt(2, obj.getStandardChargesId());
//            int i = pstmt.executeUpdate();
//            if (i > 0) {
//                return "StandardCharges Updated";
//            }
//        } catch (Exception e) {
//            logger.error("StandardChargesDAOImpl : updateStandardCharges : " + e);
//        }
//        return "Failed to Update StandardCharges";
//    }
//
//    @Override
//    public String deleteStandardCharges(int divisionId) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("delete from standard_charges where division_id = ?");
//            pstmt.setInt(1, divisionId);
//            int i = pstmt.executeUpdate();
//            if (i > 0) {
//                return "StandardCharges Deleted";
//            }
//        } catch (Exception e) {
//            logger.error("StandardChargesDAOImpl : deleteStandardCharges : " + e);
//        }
//        return "Failed to Delete StandardCharges";
//    }
}
