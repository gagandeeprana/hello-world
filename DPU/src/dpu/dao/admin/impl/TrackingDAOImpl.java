/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.TrackingBean;
import dpu.dao.admin.TrackingDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class TrackingDAOImpl implements TrackingDAO {

    ConnectDB connectDB = ConnectDB.getInstance();
    Logger logger = Logger.getLogger(TrackingDAOImpl.class);

    @Override
    public List<TrackingBean> getAllTrackings(String trackingDate) {
        List<TrackingBean> lstTrackings = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from trackingmaster where tracking_date like ? order by tracking_date");
            pstmt.setString(1, "%" + trackingDate + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TrackingBean obj = new TrackingBean();
                obj.setTrackingId(rs.getInt("tracking_id"));
                obj.setTrackingDate(rs.getDate("tracking_date"));
                lstTrackings.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
            logger.error("TrackingDAOImpl : getAllTrackings : " + e);
        }
        return lstTrackings;
    }

    @Override
    public String addTracking(TrackingBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into trackingmaster values(?,?)");
            pstmt.setInt(1, obj.getTrackingId());
            pstmt.setDate(2, obj.getTrackingDate());
            System.out.println("QQ: " + pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Tracking Added";
            }
        } catch (Exception e) {
            logger.error("TrackingDAOImpl : addTracking : " + e);
        }
        return "Failed to Add Tracking";
    }

    @Override
    public String updateTracking(TrackingBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update trackingmaster set tracking_date = ? where terminal_id = ?");
            pstmt.setDate(1, obj.getTrackingDate());
            pstmt.setInt(2, obj.getTrackingId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Tracking Updated";
            }
        } catch (Exception e) {
            logger.error("TrackingDAOImpl : updateTracking : " + e);
        }
        return "Failed to Update Tracking";
    }

    @Override
    public String deleteTracking(int terminalId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from trackingmaster where terminal_id = ?");
            pstmt.setInt(1, terminalId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Tracking Deleted";
            }
        } catch (Exception e) {
            logger.error("TrackingDAOImpl : deleteTracking : " + e);
        }
        return "Failed to Delete Tracking";
    }
}
