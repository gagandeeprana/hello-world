/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.StraightTruckBean;
import dpu.dao.admin.StraightTruckDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class StraightTruckDAOImpl implements StraightTruckDAO {

   @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(StraightTruckDAOImpl.class);

    @Override
    public List<StraightTruckBean> getAllStraightTrucks(String name) {
        List<StraightTruckBean> lstStraightTrucks = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from straighttruckmaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                StraightTruckBean obj = new StraightTruckBean();
                obj.setUnitNo(rs.getInt("unit_no"));
                obj.setStraightTruckClass(rs.getString("class"));
                obj.setVIN(rs.getString("vin"));
                obj.setMake(rs.getString("make"));
                obj.setModel(rs.getString("model"));
                obj.setYear(rs.getInt("year"));
                obj.setPlateNo(rs.getString("plate_no"));
                obj.setJurisdiction(rs.getString("jurisdiction"));
                obj.setTareWeight(rs.getString("tare_weight"));
                obj.setRgw(rs.getString("rgw"));
                obj.setTrackingId(rs.getInt("tracking_id"));
                obj.setCurrentOdometer(rs.getString("current_odometer"));
                obj.setReadingTaken(rs.getDate("reading_taken"));
                obj.setCreatedBy(rs.getInt("created_by"));
                obj.setCreatedOn(rs.getDate("created_on"));
                obj.setDivision(rs.getString("division"));
                obj.setTerminalId(rs.getInt("terminal_id"));
                obj.setCategoryId(rs.getInt("category_id"));
                obj.setIFTAAccount(rs.getString("IFTA_account"));
                lstStraightTrucks.add(obj);
            }
        } catch (Exception e) {
            logger.error("StraightTruckDAOImpl : getAllStraightTrucks : " + e);
        }
        return lstStraightTrucks;
    }

    @Override
    public String addStraightTruck(StraightTruckBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into straighttruckmaster values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, obj.getUnitNo());
            pstmt.setString(2, obj.getStraightTruckClass());
            pstmt.setString(3, obj.getVIN());
            pstmt.setString(4, obj.getMake());
            pstmt.setString(5, obj.getModel());
            pstmt.setInt(6, obj.getYear());
            pstmt.setString(7, obj.getPlateNo());
            pstmt.setString(8, obj.getJurisdiction());
            pstmt.setString(9, obj.getTareWeight());
            pstmt.setString(10, obj.getRgw());
            pstmt.setInt(11, obj.getTrackingId());
            pstmt.setString(12, obj.getCurrentOdometer());
            pstmt.setDate(13, obj.getReadingTaken());
            pstmt.setInt(14, obj.getCreatedBy());
            pstmt.setDate(15, obj.getCreatedOn());
            pstmt.setString(16, obj.getDivision());
            pstmt.setInt(17, obj.getTerminalId());
            pstmt.setInt(18, obj.getCategoryId());
            pstmt.setString(19, obj.getIFTAAccount());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "StraightTruck Added";
            }
        } catch (Exception e) {
            logger.error("StraightTruckDAOImpl : addStraightTruck : " + e);
        }
        return "Failed to Add StraightTruck";
    }

    @Override
    public String updateStraightTruck(StraightTruckBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update straighttruckmaster set class = ?,VIN=?,make=?,model=?,year=?,plate_no=?,jurisdiction=?,tare_weight=?,rgw=?,tracking_id = ?,current_odometer=?,reading_taken=?,created_by=?,create_on=?,division=?,terminal_id = ?,category_id= ?,IFTA_account=? where unit_no = ?");
            pstmt.setString(1, obj.getStraightTruckClass());
            pstmt.setString(2, obj.getVIN());
            pstmt.setString(3, obj.getMake());
            pstmt.setString(4, obj.getModel());
            pstmt.setInt(5, obj.getYear());
            pstmt.setString(6, obj.getPlateNo());
            pstmt.setString(7, obj.getJurisdiction());
            pstmt.setString(8, obj.getTareWeight());
            pstmt.setString(9, obj.getRgw());
            pstmt.setInt(10, obj.getTrackingId());
            pstmt.setString(11, obj.getCurrentOdometer());
            pstmt.setDate(12, obj.getReadingTaken());
            pstmt.setInt(13, obj.getCreatedBy());
            pstmt.setDate(14, obj.getCreatedOn());
            pstmt.setString(15, obj.getDivision());
            pstmt.setInt(16, obj.getTerminalId());
            pstmt.setInt(17, obj.getCategoryId());
            pstmt.setString(18, obj.getIFTAAccount());
            pstmt.setInt(19, obj.getUnitNo());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "StraightTruck Updated";
            }
        } catch (Exception e) {
            logger.error("StraightTruckDAOImpl : updateStraightTruck : " + e);
        }
        return "Failed to Update StraightTruck";
    }

    @Override
    public String deleteStraightTruck(int straightTruckId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from straighttruckmaster where unit_no = ?");
            pstmt.setInt(1, straightTruckId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "StraightTruck Deleted";
            }
        } catch (Exception e) {
            logger.error("StraightTruckDAOImpl : deleteStraightTruck : " + e);
        }
        return "Failed to Delete StraightTruck";
    }
}
