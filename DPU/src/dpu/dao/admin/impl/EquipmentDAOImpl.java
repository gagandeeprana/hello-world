/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.EquipmentBean;
import dpu.dao.admin.EquipmentDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class EquipmentDAOImpl implements EquipmentDAO {

   @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(EquipmentDAOImpl.class);

    @Override
    public List<EquipmentBean> getAllEquipments(String title) {
        List<EquipmentBean> lstEquipments = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from equipmentmaster where title like ? order by title");
            pstmt.setString(1, "%" + title + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                EquipmentBean obj = new EquipmentBean();
                obj.setEquipmentId(rs.getInt("equipment_id"));
                obj.setEquipmentName(rs.getString("title"));
                lstEquipments.add(obj);
                System.out.println("LSIT SII: " + lstEquipments.size());
            }
        } catch (Exception e) {
            System.out.println(e);
            logger.error("EquipmentDAOImpl : getAllEquipments : " + e);
        }
        return lstEquipments;
    }

    @Override
    public String addEquipment(EquipmentBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into equipmentmaster values(?,?)");
            pstmt.setInt(1, obj.getEquipmentId());
            pstmt.setString(2, obj.getEquipmentName());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Equipment Added";
            }
        } catch (Exception e) {
            logger.error("EquipmentDAOImpl : addEquipment : " + e);
        }
        return "Failed to Add Equipment";
    }

    @Override
    public String updateEquipment(EquipmentBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update equipmentmaster set title = ? where equipment_id = ?");
            pstmt.setString(1, obj.getEquipmentName());
            pstmt.setInt(2, obj.getEquipmentId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Equipment Updated";
            }
        } catch (Exception e) {
            logger.error("EquipmentDAOImpl : updateEquipment : " + e);
        }
        return "Failed to Update Equipment";
    }

    @Override
    public String deleteEquipment(int equipmentId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from equipmentmaster where equipment_id = ?");
            pstmt.setInt(1, equipmentId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Equipment Deleted";
            }
        } catch (Exception e) {
            logger.error("EquipmentDAOImpl : deleteEquipment : " + e);
        }
        return "Failed to Delete Equipment";
    }
}
