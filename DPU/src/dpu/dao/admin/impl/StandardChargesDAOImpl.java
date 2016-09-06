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
import org.springframework.beans.factory.annotation.Autowired;

public class StandardChargesDAOImpl implements StandardChargesDAO {

   @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(StandardChargesDAOImpl.class);

    @Override
    public List<StandardChargesBean> getAllStandardCharges(String code) {
        List<StandardChargesBean> lstStandardCharges = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from standard_charges where code like ?");
            pstmt.setString(1, "%" + code + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                StandardChargesBean obj = new StandardChargesBean();
                obj.setStandardChargesId(rs.getInt("standard_charges_id"));
                obj.setCode(rs.getString("code"));
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
            System.out.println("StandardChargesDAOImpl : getAllStandardCharges: " + e);
            logger.error("StandardChargesDAOImpl : getAllStandardCharges : " + e);
        }
        return lstStandardCharges;
    }

    @Override
    public String addStandardCharges(StandardChargesBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into standard_charges (code,charge_type1,description,amount_as,base_charge,max_charge,charge_type2,status,include_charge_amount,calculate_fuel_surcharge,include_driver_payroll) values (?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getCode());
            pstmt.setInt(2, obj.getChargeType1());
            pstmt.setString(3, obj.getDescription());
            pstmt.setInt(4, obj.getAmountAs());
            pstmt.setString(5, obj.getBaseCharge());
            pstmt.setString(6, obj.getMaxCharge());
            pstmt.setInt(7, obj.getChargeType2());
            pstmt.setInt(8, obj.getStatus());
            pstmt.setInt(9, obj.getIncludeChargeAmount());
            pstmt.setInt(10, obj.getCalculateFuelSurcharge());
            pstmt.setInt(11, obj.getIncludeDriverPayroll());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "StandardCharges Added";
            }
        } catch (Exception e) {
            logger.error("StandardChargesDAOImpl : addStandardCharges : " + e);
        }
        return "Failed to Add StandardCharges";
    }
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

    @Override
    public String deleteStandardCharges(int standardChargesId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from standard_charges where standard_charges_id = ?");
            pstmt.setInt(1, standardChargesId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Failed to Delete StandardCharges";
            }
        } catch (Exception e) {
            System.out.println("");
        }
        return "StandardCharges Deleted";
    }

    @Override
    public String updateStandardCharges(StandardChargesBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update standard_charges set code=?,charge_type1=?,description=?,amount_as=?,base_charge=?,max_charge=?,charge_type2=?,status=?,include_charge_amount=?,calculate_fuel_surcharge=?,include_driver_payroll=? where standard_charges_id = ?");
            pstmt.setString(1, obj.getCode());
            pstmt.setInt(2, obj.getChargeType1());
            pstmt.setString(3, obj.getDescription());
            pstmt.setInt(4, obj.getAmountAs());
            pstmt.setString(5, obj.getBaseCharge());
            pstmt.setString(6, obj.getMaxCharge());
            pstmt.setInt(7, obj.getChargeType2());
            pstmt.setInt(8, obj.getStatus());
            pstmt.setInt(9, obj.getIncludeChargeAmount());
            pstmt.setInt(10, obj.getCalculateFuelSurcharge());
            pstmt.setInt(11, obj.getIncludeDriverPayroll());
            pstmt.setInt(12, obj.getStandardChargesId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "StandardCharges Updated";
            }
        } catch (Exception e) {
            logger.error("StandardChargesDAOImpl : updateStandardCharges : " + e);
        }
        return "Failed to Update StandardCharges";
    }
}
