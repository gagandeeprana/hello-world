/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.JurisdictionBean;
import dpu.dao.admin.JurisdictionDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class JurisdictionDAOImpl implements JurisdictionDAO {

   @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(JurisdictionDAOImpl.class);

    @Override
    public List<JurisdictionBean> getAllJurisdictions(String name) {
        List<JurisdictionBean> lstJurisdictions = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from jurisdictionmaster jdm inner join countrymaster cm on jdm.country_id = cm.country_id where jurisdiction_name like ? order by jurisdiction_name");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                JurisdictionBean obj = new JurisdictionBean();
                obj.setJurisdictionId(rs.getInt("jurisdiction_id"));
                obj.setJurisdictionName(rs.getString("jurisdiction_name"));
                obj.setIFAJurisdiction(rs.getString("jurisdiction_IFA"));
                obj.setCountryId(rs.getInt("cm.country_id"));
                obj.setRoadTax(rs.getDouble("road_tax"));
                lstJurisdictions.add(obj);
            }
        } catch (Exception e) {
            logger.error("JurisdictionDAOImpl : getAllJurisdictions : " + e);
        }
        return lstJurisdictions;
    }

    @Override
    public String addJurisdiction(JurisdictionBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into jurisdictionmaster values(?,?,?,?,?)");
            pstmt.setInt(1, obj.getJurisdictionId());
            pstmt.setString(2, obj.getJurisdictionName());
            pstmt.setString(3, obj.getIFAJurisdiction());
            pstmt.setInt(4, obj.getCountryId());
            pstmt.setDouble(5, obj.getRoadTax());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Jurisdiction Added";
            }
        } catch (Exception e) {
            logger.error("JurisdictionDAOImpl : addJurisdiction : " + e);
        }
        return "Failed to Add Jurisdiction";
    }

    @Override
    public String updateJurisdiction(JurisdictionBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update jurisdictionmaster set jurisdiction_name = ?,jurisdiction_IFA = ?,country_id = ?,road_tax = ? where jurisdiction_id = ?");
            pstmt.setString(1, obj.getJurisdictionName());
            pstmt.setString(2, obj.getIFAJurisdiction());
            pstmt.setInt(3, obj.getCountryId());
            pstmt.setDouble(4, obj.getRoadTax());
            pstmt.setInt(5, obj.getJurisdictionId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Jurisdiction Updated";
            }
        } catch (Exception e) {
            logger.error("JurisdictionDAOImpl : updateJurisdiction : " + e);
        }
        return "Failed to Update Jurisdiction";
    }

    @Override
    public String deleteJurisdiction(int jurisdictionId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from jurisdictionmaster where jurisdiction_id = ?");
            pstmt.setInt(1, jurisdictionId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Jurisdiction Deleted";
            }
        } catch (Exception e) {
            logger.error("JurisdictionDAOImpl : deleteJurisdiction : " + e);
        }
        return "Failed to Delete Jurisdiction";
    }
}
