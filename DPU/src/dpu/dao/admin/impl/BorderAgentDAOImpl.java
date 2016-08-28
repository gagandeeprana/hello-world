/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.BorderAgentBean;
import dpu.dao.admin.BorderAgentDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gagandeep
 */
public class BorderAgentDAOImpl implements BorderAgentDAO {

    ConnectDB connectDB = ConnectDB.getInstance();

    @Override
    public List<BorderAgentBean> getAllBorderAgents() {
        List<BorderAgentBean> lstBorderAgents = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from border_agent");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BorderAgentBean obj = new BorderAgentBean();
                obj.setBorderAgentId(rs.getInt("border_agent_id"));
                obj.setCode(rs.getString("code"));
                obj.setBorderAgent(rs.getString("border_agent"));
                obj.setBorderCrossing(rs.getString("border_crossing"));
                obj.setPhone(rs.getString("phone"));
                obj.setExt(rs.getString("ext"));
                obj.setFax(rs.getString("fax"));
                obj.setStatus(rs.getInt("status"));
                obj.setEmail(rs.getString("email"));
                obj.setOpenFrom(rs.getString("open_from"));
                obj.setOpenTo(rs.getString("open_to"));
                obj.setIs24Hr(rs.getInt("is24Hr"));
                obj.setComments(rs.getString("comments"));
                obj.setCustomBrokerId(rs.getInt("custom_broker_id"));
                lstBorderAgents.add(obj);
            }
        } catch (Exception e) {
            System.out.println("BorderAgentDAOImpl : getAllBorderAgents : " + e);
//            logger.error("AdditionalContactDAOImpl : getAllAdditionalContactes : " + e);
        }
        return lstBorderAgents;
    }

    @Override
    public String deleteBorderAgent(int borderAgentId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from border_agent where border_agent_id = ?");
            pstmt.setInt(1, borderAgentId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "BorderAgent Deleted";
            }
        } catch (Exception e) {
            System.out.println("BorderAgentDAOImpl : deleteBorderAgent : " + e);
//            logger.error("CompanyDAOImpl : deleteCompany : " + e);
        }
        return "Failed to Delete BorderAgent";
    }

    @Override
    public String addBorderAgent(BorderAgentBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into border_agent(code,border_agent,border_crossing,phone,ext,fax,status,email,open_from,open_to,is24Hr,comments,custom_broker_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getCode());
            pstmt.setString(2, obj.getBorderAgent());
            pstmt.setString(3, obj.getBorderCrossing());
            pstmt.setString(4, obj.getPhone());
            pstmt.setString(5, obj.getExt());
            pstmt.setString(6, obj.getFax());
            pstmt.setInt(7, obj.getStatus());
            pstmt.setString(8, obj.getEmail());
            pstmt.setString(9, obj.getOpenFrom());
            pstmt.setString(10, obj.getOpenTo());
            pstmt.setInt(11, obj.getIs24Hr());
            pstmt.setString(12, obj.getComments());
            pstmt.setInt(13, obj.getCustomBrokerId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "BorderAgent Added";
            }
        } catch (Exception e) {
            System.out.println("BorderAgentDAOImpl : addBorderAgent : " + e);
//            logger.error("CompanyDAOImpl : addCompany : " + e);
        }
        return "Failed to Add BorderAgent";
    }

    @Override
    public String updateBorderAgent(BorderAgentBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update border_agent set code=?,border_agent=?,border_crossing=?,phone=?,ext=?,fax=?,status=?,email=?,open_from=?,open_to=?,is24Hr=?,comments=?,custom_broker_id=? where border_agent_id = ?");
            pstmt.setString(1, obj.getCode());
            pstmt.setString(2, obj.getBorderAgent());
            pstmt.setString(3, obj.getBorderCrossing());
            pstmt.setString(4, obj.getPhone());
            pstmt.setString(5, obj.getExt());
            pstmt.setString(6, obj.getFax());
            pstmt.setInt(7, obj.getStatus());
            pstmt.setString(8, obj.getEmail());
            pstmt.setString(9, obj.getOpenFrom());
            pstmt.setString(10, obj.getOpenTo());
            pstmt.setInt(11, obj.getIs24Hr());
            pstmt.setString(12, obj.getComments());
            pstmt.setInt(13, obj.getCustomBrokerId());
            pstmt.setInt(14, obj.getBorderAgentId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "BorderAgent Updated";
            }
        } catch (Exception e) {
            System.out.println("BorderAgentDAOImpl : updateBorderAgent : " + e);
//            logger.error("CompanyDAOImpl : addCompany : " + e);
        }
        return "Failed to Update BorderAgent";
    }

    @Override
    public List<BorderAgentBean> getAllBorderAgentsByCustomBrokerId(int customBrokerId) {
        List<BorderAgentBean> lstBorderAgents = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from border_agent where custom_broker_id = ?");
            pstmt.setInt(1, customBrokerId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BorderAgentBean obj = new BorderAgentBean();
                obj.setBorderAgentId(rs.getInt("border_agent_id"));
                obj.setCode(rs.getString("code"));
                obj.setBorderAgent(rs.getString("border_agent"));
                obj.setBorderCrossing(rs.getString("border_crossing"));
                obj.setPhone(rs.getString("phone"));
                obj.setExt(rs.getString("ext"));
                obj.setFax(rs.getString("fax"));
                obj.setStatus(rs.getInt("status"));
                obj.setEmail(rs.getString("email"));
                obj.setOpenFrom(rs.getString("open_from"));
                obj.setOpenTo(rs.getString("open_to"));
                obj.setIs24Hr(rs.getInt("is24Hr"));
                obj.setComments(rs.getString("comments"));
                obj.setCustomBrokerId(rs.getInt("custom_broker_id"));
                lstBorderAgents.add(obj);
            }
        } catch (Exception e) {
            System.out.println("BorderAgentDAOImpl : getAllBorderAgentsByCustomBrokerId : " + e);
//            logger.error("AdditionalContactDAOImpl : getAllAdditionalContactes : " + e);
        }
        return lstBorderAgents;
    }
}
