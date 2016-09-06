/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.PowerUnitBean;
import dpu.dao.admin.PowerUnitDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class PowerUnitDAOImpl implements PowerUnitDAO {

   @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(PowerUnitDAOImpl.class);

    @Override
    public List<PowerUnitBean> getAllPowerUnits(String name) {
        List<PowerUnitBean> lstPowerUnits = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from powerunitmaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                PowerUnitBean obj = new PowerUnitBean();
                obj.setUnitNo(rs.getInt("unit_no"));
                obj.setStatus(rs.getString("status"));
                obj.setPowerUnitClass(rs.getString("truck_class"));
                obj.setOwnerId(rs.getInt("owner_id"));
                obj.setVIN(rs.getString("VIN"));
                obj.setMake(rs.getString("make"));
                obj.setModel(rs.getString("model"));
                obj.setYear(rs.getInt("truck_year"));
                obj.setPlateNo(rs.getString("plate_no"));
                obj.setJurisdiction(rs.getString("jurisdiction"));
                obj.setTareWeight(rs.getInt("tare_weight"));
                obj.setRgw(rs.getString("rgw"));
                obj.setTrackingId(rs.getInt("tracking_id"));
                obj.setCurrentOdometer(rs.getString("current_odometer"));
                obj.setEquipmentType(rs.getString("equipment_type"));
                obj.setTerminalId(rs.getInt("terminal_id"));
                lstPowerUnits.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
            logger.error("PowerUnitDAOImpl : getAllPowerUnits : " + e);
        }
        return lstPowerUnits;
    }

    @Override
    public String addPowerUnit(PowerUnitBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into powerunitmaster values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, obj.getUnitNo());
            pstmt.setString(2, obj.getStatus());
            pstmt.setString(3, obj.getPowerUnitClass());
            pstmt.setInt(4, obj.getOwnerId());
            pstmt.setString(5, obj.getVIN());
            pstmt.setString(6, obj.getMake());
            pstmt.setString(7, obj.getModel());
            pstmt.setInt(8, obj.getYear());
            pstmt.setString(9, obj.getPlateNo());
            pstmt.setString(10, obj.getJurisdiction());
            pstmt.setInt(11, obj.getTareWeight());
            pstmt.setString(12, obj.getRgw());
            pstmt.setInt(13, obj.getTrackingId());
            pstmt.setString(14, obj.getCurrentOdometer());
            pstmt.setString(15, obj.getEquipmentType());
            pstmt.setInt(16, obj.getTerminalId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "PowerUnit Added";
            }
        } catch (Exception e) {
            logger.error("PowerUnitDAOImpl : addPowerUnit : " + e);
        }
        return "Failed to Add PowerUnit";
    }

    @Override
    public String updatePowerUnit(PowerUnitBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update powerunitmaster set status = ?, truck_class = ?,owner_id = ?, VIN=?,make=?,model=?,truck_year=?,plate_no=?,jurisdiction=?,tare_weight=?,rgw=?,tracking_id = ?,current_odometer=?,equipment_type=?,terminal_id = ? where unit_no = ?");
            pstmt.setString(1, obj.getStatus());
            pstmt.setString(2, obj.getPowerUnitClass());
            pstmt.setInt(3, obj.getOwnerId());
            pstmt.setString(4, obj.getVIN());
            pstmt.setString(5, obj.getMake());
            pstmt.setString(6, obj.getModel());
            pstmt.setInt(7, obj.getYear());
            pstmt.setString(8, obj.getPlateNo());
            pstmt.setString(9, obj.getJurisdiction());
            pstmt.setInt(10, obj.getTareWeight());
            pstmt.setString(11, obj.getRgw());
            pstmt.setInt(12, obj.getTrackingId());
            pstmt.setString(13, obj.getCurrentOdometer());
            pstmt.setString(14, obj.getEquipmentType());
            pstmt.setInt(15, obj.getTerminalId());
            pstmt.setInt(16, obj.getUnitNo());
      
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "PowerUnit Updated";
            }
        } catch (Exception e) {
            logger.error("PowerUnitDAOImpl : updatePowerUnit : " + e);
        }
        return "Failed to Update PowerUnit";
    }

    @Override
    public String deletePowerUnit(int unitNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from powerunitmaster where unit_no = ?");
            pstmt.setInt(1, unitNo);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "PowerUnit Deleted";
            }
        } catch (Exception e) {
            logger.error("PowerUnitDAOImpl : deletePowerUnit : " + e);
        }
        return "Failed to Delete PowerUnit";
    }
}
