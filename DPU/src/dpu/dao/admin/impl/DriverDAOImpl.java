/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.DriverBean;
import dpu.dao.admin.DriverDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverDAOImpl implements DriverDAO {

   @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(DriverDAOImpl.class);

    @Override
    public List<DriverBean> getAllDrivers(String name) {
        List<DriverBean> lstDrivers = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from drivermaster where first_name like ?");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                DriverBean obj = new DriverBean();
                obj.setDriverId(rs.getInt("driver_id"));
                obj.setFirstName(rs.getString("first_name"));
                obj.setLastName(rs.getString("last_name"));
                obj.setDefTruck(rs.getString("def_truck"));
                obj.setAddress(rs.getString("address"));
                obj.setHomePhone(rs.getString("home_phone"));
                obj.setCellular(rs.getString("cellular"));
                obj.setPager(rs.getString("pager"));
                obj.setStatus(rs.getInt("status"));
                obj.setLastTrip(rs.getString("last_trip"));
                obj.setLastETA(rs.getDate("last_ETA"));
                obj.setLastEvent(rs.getString("last_event"));
                obj.setLastLocation(rs.getString("last_location"));
                obj.setLastCity(rs.getString("last_city"));
                obj.setLastState(rs.getString("L/S"));
                obj.setFaxNo(rs.getString("fax_no"));
                obj.setDivisionId(rs.getInt("division_id"));
                obj.setTerminalId(rs.getInt("terminal_id"));
                obj.setCategoryId(rs.getInt("category_id"));
                obj.setClassId(rs.getInt("class_id"));
                obj.setZip(rs.getString("zip"));
                obj.setRoleId(rs.getInt("role_id"));
                lstDrivers.add(obj);
            }
        } catch (Exception e) {
            logger.error("DriverDAOImpl : getAllDrivers : " + e);
        }
        return lstDrivers;
    }

    @Override
    public String addDriver(DriverBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into drivermaster values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, obj.getDriverId());
            pstmt.setString(2, obj.getFirstName());
            pstmt.setString(3, obj.getLastName());
            pstmt.setString(4, obj.getDefTruck());
            pstmt.setString(5, obj.getAddress());
            pstmt.setString(6, obj.getHomePhone());
            pstmt.setString(7, obj.getCellular());
            pstmt.setString(8, obj.getPager());
            pstmt.setInt(9, obj.getStatus());
            pstmt.setString(10, obj.getLastTrip());
            pstmt.setDate(11, obj.getLastETA());
            pstmt.setString(12, obj.getLastEvent());
            pstmt.setString(13, obj.getLastLocation());
            pstmt.setString(14, obj.getLastCity());
            pstmt.setString(15, obj.getLastState());
            pstmt.setString(16, obj.getFaxNo());
            pstmt.setInt(17, obj.getDivisionId());
            pstmt.setInt(18, obj.getTerminalId());
            pstmt.setInt(19, obj.getCategoryId());
            pstmt.setInt(20, obj.getClassId());
            pstmt.setString(21, obj.getZip());
            pstmt.setInt(22, obj.getRoleId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Driver Added";
            }
        } catch (Exception e) {
            logger.error("DriverDAOImpl : addDriver : " + e);
        }
        return "Failed to Add Driver";
    }

    @Override
    public String updateDriver(DriverBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update drivermaster set first_name = ?,last_name=?,def_truck=?,address=?,home_phone=?,cellular=?,pager=?,status=?,last_trip=?,last_ETA=?,last_event=?,last_location=?,last_city=?,L/S=?,fax_no=?,division_id=?,terminal_id = ?,category_id=?, class_id = ?,zip=?,role_id = ? where driver_id = ?");
            pstmt.setString(1, obj.getFirstName());
            pstmt.setString(2, obj.getLastName());
            pstmt.setString(3, obj.getDefTruck());
            pstmt.setString(4, obj.getAddress());
            pstmt.setString(5, obj.getHomePhone());
            pstmt.setString(6, obj.getCellular());
            pstmt.setString(7, obj.getPager());
            pstmt.setInt(8, obj.getStatus());
            pstmt.setString(9, obj.getLastTrip());
            pstmt.setDate(10, obj.getLastETA());
            pstmt.setString(11, obj.getLastEvent());
            pstmt.setString(12, obj.getLastLocation());
            pstmt.setString(13, obj.getLastCity());
            pstmt.setString(14, obj.getLastState());
            pstmt.setString(15, obj.getFaxNo());
            pstmt.setInt(16, obj.getDivisionId());
            pstmt.setInt(17, obj.getTerminalId());
            pstmt.setInt(18, obj.getCategoryId());
            pstmt.setInt(19, obj.getClassId());
            pstmt.setString(20, obj.getZip());
            pstmt.setInt(21, obj.getRoleId());
            pstmt.setInt(22, obj.getDriverId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Driver Updated";
            }
        } catch (Exception e) {
            logger.error("DriverDAOImpl : updateDriver : " + e);
        }
        return "Failed to Update Driver";
    }

    @Override
    public String deleteDriver(int driverId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from drivermaster where driver_id = ?");
            pstmt.setInt(1, driverId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Driver Deleted";
            }
        } catch (Exception e) {
            logger.error("DriverDAOImpl : deleteDriver : " + e);
        }
        return "Failed to Delete Driver";
    }
}
