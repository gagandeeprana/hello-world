/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.RoleBean;
import dpu.dao.admin.RoleDAO;
import dpu.dao.admin.RoleDAO;
import dpu.dao.common.ConnectDB;
import dpu.entity.admin.Category;
import dpu.entity.admin.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleDAOImpl implements RoleDAO {

   @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(RoleDAOImpl.class);

    @Override
    public List<RoleBean> getAllRoles(String title) {
        List<RoleBean> lstRoles = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from rolemaster where title like ? order by title");
            pstmt.setString(1, "%" + title + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                RoleBean obj = new RoleBean();
                obj.setRoleId(rs.getInt("role_id"));
                obj.setRoleName(rs.getString("title"));
                lstRoles.add(obj);
            }
        } catch (Exception e) {
            logger.error("RoleDAOImpl : getAllRoles : " + e);
        }
        return lstRoles;
    }

    @Override
    public String addRole(RoleBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into rolemaster values(?,?)");
            pstmt.setInt(1, obj.getRoleId());
            pstmt.setString(2, obj.getRoleName());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Role Added";
            }
        } catch (Exception e) {
            logger.error("RoleDAOImpl : addRole : " + e);
        }
        return "Failed to Add Role";
    }

    @Override
    public String updateRole(RoleBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update rolemaster set title = ? where role_id = ?");
            pstmt.setString(1, obj.getRoleName());
            pstmt.setInt(2, obj.getRoleId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Role Updated";
            }
        } catch (Exception e) {
            logger.error("RoleDAOImpl : updateRole : " + e);
        }
        return "Failed to Update Role";
    }

    @Override
    public String deleteRole(int roleId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from rolemaster where role_id = ?");
            pstmt.setInt(1, roleId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Role Deleted";
            }
        } catch (Exception e) {
            logger.error("RoleDAOImpl : deleteRole : " + e);
        }
        return "Failed to Delete Role";
    }

    @Override
    public List<Role> getAllRole() {
         List<Role> listOfRoles = new ArrayList<Role>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Role.class);
            listOfRoles = criteria.list();
        } catch (Exception e) {
            logger.error("RoleDAOImpl : getAllRoles : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return listOfRoles;
    }
     
}
