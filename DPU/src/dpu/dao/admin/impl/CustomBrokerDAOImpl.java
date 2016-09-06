/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.CustomBrokerBean;
import dpu.beans.admin.CustomBrokerBean;
import dpu.dao.admin.CustomBrokerDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Gagandeep
 */
public class CustomBrokerDAOImpl implements CustomBrokerDAO {

   @Autowired
    ConnectDB connectDB;

    @Override
    public List<CustomBrokerBean> getAllCustomBrokers(String name) {
        List<CustomBrokerBean> lstCustomBrokers = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from custombrokermaster where custom_broker like ?");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomBrokerBean obj = new CustomBrokerBean();
                obj.setCustomBrokerId(rs.getInt("custom_broker_id"));
                obj.setCustomBroker(rs.getString("custom_broker"));
                obj.setContactName(rs.getString("contact_name"));
                obj.setPhone(rs.getString("phone"));
                obj.setExt(rs.getString("ext"));
                obj.setFaxNo(rs.getString("fax_no"));
                obj.setStatus(rs.getInt("status"));
                obj.setEmail(rs.getString("email"));
                obj.setWebsite(rs.getString("website"));
                lstCustomBrokers.add(obj);
            }
        } catch (Exception e) {
            System.out.println("CustomBrokerDAOImpl : getAllCustomBrokers : " + e);
//            logger.error("AdditionalContactDAOImpl : getAllAdditionalContactes : " + e);
        }
        return lstCustomBrokers;
    }

    @Override
    public String deleteCustomBroker(int customBrokerId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from custombrokermaster where custom_broker_id = ?");
            pstmt.setInt(1, customBrokerId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "CustomBroker Deleted";
            }
        } catch (Exception e) {
            System.out.println("CustomBrokerDAOImpl : deleteCustomBroker : " + e);
//            logger.error("CompanyDAOImpl : deleteCompany : " + e);
        }
        return "Failed to Delete CustomBroker";
    }

    @Override
    public String addCustomBroker(CustomBrokerBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into custombrokermaster(custom_broker,contact_name,phone,ext,fax_no,status,email,website) values(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getCustomBroker());
            pstmt.setString(2, obj.getContactName());
            pstmt.setString(3, obj.getPhone());
            pstmt.setString(4, obj.getExt());
            pstmt.setString(5, obj.getFaxNo());
            pstmt.setInt(6, obj.getStatus());
            pstmt.setString(7, obj.getEmail());
            pstmt.setString(8, obj.getWebsite());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "CustomBroker Added";
            }
        } catch (Exception e) {
            System.out.println("CustomBrokerDAOImpl : addCustomBroker : " + e);
//            logger.error("CompanyDAOImpl : addCompany : " + e);
        }
        return "Failed to Add CustomBroker";
    }

    @Override
    public String updateCustomBroker(CustomBrokerBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update custombrokermaster set custom_broker = ?,contact_name = ?,phone = ?,ext = ?,fax_no = ?,status = ?,email = ?,website = ? where custom_broker_id = ?");
            pstmt.setString(1, obj.getCustomBroker());
            pstmt.setString(2, obj.getContactName());
            pstmt.setString(3, obj.getPhone());
            pstmt.setString(4, obj.getExt());
            pstmt.setString(5, obj.getFaxNo());
            pstmt.setInt(6, obj.getStatus());
            pstmt.setString(7, obj.getEmail());
            pstmt.setString(8, obj.getWebsite());
            pstmt.setInt(9, obj.getCustomBrokerId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "CustomBroker Updated";
            }
        } catch (Exception e) {
            System.out.println("CustomBrokerDAOImpl : updateCustomBroker : " + e);
//            logger.error("CompanyDAOImpl : addCompany : " + e);
        }
        return "Failed to Update CustomBroker";
    }

    @Override
    public int getMaxCustomBrokerId() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select max(custom_broker_id) from custombrokermaster");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("CustomBrokerDAOImpl : deleteCustomBroker : " + e);
//            logger.error("CompanyDAOImpl : deleteCompany : " + e);
        }
        return 0;
    }
}
