/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.AdditionalContactBean;
import dpu.beans.admin.AdditionalContactBean;
import dpu.dao.admin.AdditionalContactDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class AdditionalContactDAOImpl implements AdditionalContactDAO {

    ConnectDB connectDB = ConnectDB.getInstance();
//    Logger logger = Logger.getLogger(AdditionalContactDAOImpl.class);

    @Override
    public List<AdditionalContactBean> getAllAdditionalContacts(String name) {
        List<AdditionalContactBean> lstAdditionalContacts = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from additionalcontactmaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                AdditionalContactBean obj = new AdditionalContactBean();
                obj.setAdditionalContactId(rs.getInt("add_contact_id"));
                obj.setContactId(rs.getInt("company_id"));
                obj.setCustomerName(rs.getString("customer_name"));
                obj.setAddress(rs.getString("address"));
                obj.setPhone(rs.getString("phone"));
                obj.setExt(rs.getString("ext"));
                obj.setFax(rs.getString("fax"));
                obj.setPrefix(rs.getString("prefix"));
                obj.setProvinceState(rs.getInt("province_state"));
                obj.setStatus(rs.getInt("status"));
                obj.setEmail(rs.getString("email"));
                lstAdditionalContacts.add(obj);
            }
        } catch (Exception e) {
//            logger.error("AdditionalContactDAOImpl : getAllAdditionalContactes : " + e);
        }
        return lstAdditionalContacts;
    }

    @Override
    public String addAdditionalContact(AdditionalContactBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into additionalcontactmaster (company_id,customer_name,address,phone,ext,fax,prefix,province_state,status,email) values(?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, obj.getContactId());
            pstmt.setString(2, obj.getCustomerName());
            pstmt.setString(3, obj.getAddress());
            pstmt.setString(4, obj.getPhone());
            pstmt.setString(5, obj.getExt());
            pstmt.setString(6, obj.getFax());
            pstmt.setString(7, obj.getPrefix());
            pstmt.setInt(8, obj.getProvinceState());
            pstmt.setInt(9, obj.getStatus());
            pstmt.setString(10, obj.getEmail());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "AdditionalContact Added";
            }
        } catch (Exception e) {
//            logger.error("AdditionalContactDAOImpl : addAdditionalContact : " + e);
        }
        return "Failed to Add AdditionalContact";
    }

    @Override
    public String updateAdditionalContact(AdditionalContactBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update additionalcontactmaster set company_id = ?,customer_name = ?,address=?,phone=?,ext=?,fax=?,prefix=?,province_state=?,status=?,email=? where add_contact_id = ?");
            pstmt.setInt(1, obj.getContactId());
            pstmt.setString(2, obj.getCustomerName());
            pstmt.setString(3, obj.getAddress());
            pstmt.setString(4, obj.getPhone());
            pstmt.setString(5, obj.getExt());
            pstmt.setString(6, obj.getFax());
            pstmt.setString(7, obj.getPrefix());
            pstmt.setInt(8, obj.getProvinceState());
            pstmt.setInt(9, obj.getStatus());
            pstmt.setString(10, obj.getEmail());
            pstmt.setInt(11, obj.getAdditionalContactId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "AdditionalContact Updated";
            }
        } catch (Exception e) {
//            logger.error("AdditionalContactDAOImpl : updateAdditionalContact : " + e);
        }
        return "Failed to Update AdditionalContact";
    }

    @Override
    public String deleteAdditionalContact(int additionalContactId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from additionalcontactmaster where add_contact_id = ?");
            pstmt.setInt(1, additionalContactId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "AdditionalContact Deleted";
            }
        } catch (Exception e) {
//            logger.error("AdditionalContactDAOImpl : deleteAdditionalContact : " + e);
        }
        return "Failed to Delete AdditionalContact";
    }

    @Override
    public AdditionalContactBean getAdditionalContactInfoById(int additionalContactId) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        AdditionalContactBean obj = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from additionalcontactmaster where add_contact_id = ?");
            pstmt.setInt(1, additionalContactId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new AdditionalContactBean();
                obj.setAdditionalContactId(rs.getInt("add_contact_id"));
                obj.setContactId(rs.getInt("company_id"));
                obj.setCustomerName(rs.getString("customer_name"));
                obj.setAddress(rs.getString("address"));
                obj.setPhone(rs.getString("phone"));
                obj.setExt(rs.getString("ext"));
                obj.setFax(rs.getString("fax"));
                obj.setPrefix(rs.getString("prefix"));
                obj.setProvinceState(rs.getInt("province_state"));
                obj.setStatus(rs.getInt("status"));
                obj.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj;
    }
}
