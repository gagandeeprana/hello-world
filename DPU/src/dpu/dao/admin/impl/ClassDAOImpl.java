/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.ClassBean;
import dpu.beans.admin.DivisionBean;
import dpu.dao.admin.ClassDAO;
import dpu.dao.admin.DivisionDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class ClassDAOImpl implements ClassDAO {

    ConnectDB connectDB = ConnectDB.getInstance();
    Logger logger = Logger.getLogger(ClassDAOImpl.class);

    @Override
    public List<ClassBean> getAllClasses(String name) {
        List<ClassBean> lstClasses = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from classmaster where title like ?");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ClassBean obj = new ClassBean();
                obj.setClassId(rs.getInt("class_id"));
                obj.setName(rs.getString("title"));
                lstClasses.add(obj);
            }
        } catch (Exception e) {
            logger.error("ClassDAOImpl : getAllClasses : " + e);
        }
        return lstClasses;
    }

    @Override
    public String addClass(ClassBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into classmaster (title) values(?)");
            pstmt.setString(1, obj.getName());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Class Added";
            }
        } catch (Exception e) {
            logger.error("ClassDAOImpl : addClass : " + e);
        }
        return "Failed to Add Class";
    }

    @Override
    public String updateClass(ClassBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update classmaster set title = ? where class_id = ?");
            pstmt.setString(1, obj.getName());
            pstmt.setInt(2, obj.getClassId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Class Updated";
            }
        } catch (Exception e) {
            logger.error("ClassDAOImpl : updateClass : " + e);
        }
        return "Failed to Update Class";
    }
}
