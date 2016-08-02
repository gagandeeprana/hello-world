/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.TrailerBean;
import dpu.dao.admin.TrailerDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class TrailerDAOImpl implements TrailerDAO {

    ConnectDB connectDB = ConnectDB.getInstance();
    Logger logger = Logger.getLogger(TrailerDAOImpl.class);

    @Override
    public List<TrailerBean> getAllTrailers(String name) {
        List<TrailerBean> lstTrailers = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from trailermaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TrailerBean obj = new TrailerBean();
                obj.setTrailerId(rs.getInt("trailer_id"));
                obj.setClassId(rs.getInt("class_id"));
                obj.setEquipmentId(rs.getInt("equipment_id"));
                obj.setLength(rs.getInt("length"));
                obj.setVIN(rs.getString("VIN"));
                obj.setMake(rs.getString("make"));
                obj.setModel(rs.getString("model"));
                obj.setYear(rs.getInt("year"));
                obj.setPlateNo(rs.getString("plate_no"));
                obj.setJurisdiction(rs.getString("jurisdiction"));
                obj.setTareWeight(rs.getString("tare_weight"));
                obj.setRgw(rs.getString("rgw"));
                obj.setCurrentOdometer(rs.getString("current_odometer"));
                obj.setReadingTakenDate(rs.getDate("reading_taken_date"));
                obj.setCreatedBy(rs.getInt("created_by"));
                obj.setCreatedOn(rs.getDate("created_on"));
                lstTrailers.add(obj);
            }
        } catch (Exception e) {
            logger.error("TrailerDAOImpl : getAllTrailers : " + e);
        }
        return lstTrailers;
    }

    @Override
    public String addTrailer(TrailerBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into trailermaster values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, obj.getTrailerId());
            pstmt.setInt(2, obj.getClassId());
            pstmt.setInt(3, obj.getEquipmentId());
            pstmt.setInt(4, obj.getLength());
            pstmt.setString(5, obj.getVIN());
            pstmt.setString(6, obj.getMake());
            pstmt.setString(7, obj.getModel());
            pstmt.setInt(8, obj.getYear());
            pstmt.setString(9, obj.getPlateNo());
            pstmt.setString(10, obj.getJurisdiction());
            pstmt.setString(11, obj.getTareWeight());
            pstmt.setString(12, obj.getRgw());
            pstmt.setString(13, obj.getCurrentOdometer());
            pstmt.setDate(14, obj.getReadingTakenDate());
            pstmt.setInt(15, obj.getCreatedBy());
            pstmt.setDate(16, obj.getCreatedOn());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Trailer Added";
            }
        } catch (Exception e) {
            logger.error("TrailerDAOImpl : addTrailer : " + e);
        }
        return "Failed to Add Trailer";
    }

    @Override
    public String updateTrailer(TrailerBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update trailermaster set class_id = ?, equipment_id = ?, length = ?, VIN=?,make=?,model=?,year=?,plate_no=?,jurisdiction=?,tare_weight=?,rgw=?,current_odometer=?,reading_taken_date =?,created_by=?,create_on=? where trailer_id = ?");
            pstmt.setInt(1, obj.getClassId());
            pstmt.setInt(2, obj.getEquipmentId());
            pstmt.setInt(3, obj.getLength());
            pstmt.setString(4, obj.getVIN());
            pstmt.setString(5, obj.getMake());
            pstmt.setString(6, obj.getModel());
            pstmt.setInt(7, obj.getYear());
            pstmt.setString(8, obj.getPlateNo());
            pstmt.setString(9, obj.getJurisdiction());
            pstmt.setString(10, obj.getTareWeight());
            pstmt.setString(11, obj.getRgw());
            pstmt.setString(12, obj.getCurrentOdometer());
            pstmt.setDate(13, obj.getReadingTakenDate());
            pstmt.setInt(14, obj.getCreatedBy());
            pstmt.setDate(15, obj.getCreatedOn());
            pstmt.setInt(16, obj.getTrailerId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Trailer Updated";
            }
        } catch (Exception e) {
            logger.error("TrailerDAOImpl : updateTrailer : " + e);
        }
        return "Failed to Update Trailer";
    }

    @Override
    public String deleteTrailer(int trailerId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from trailermaster where trailer_id = ?");
            pstmt.setInt(1, trailerId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Trailer Deleted";
            }
        } catch (Exception e) {
            logger.error("TrailerDAOImpl : deleteTrailer : " + e);
        }
        return "Failed to Delete Trailer";
    }
}
