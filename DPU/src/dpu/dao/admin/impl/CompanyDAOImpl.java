/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.CompanyBean;
import dpu.dao.admin.CompanyDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class CompanyDAOImpl implements CompanyDAO {

    ConnectDB connectDB = ConnectDB.getInstance();
    Logger logger = Logger.getLogger(CompanyDAOImpl.class);

    @Override
    public List<CompanyBean> getAllCompanies(String name) {
        List<CompanyBean> lstCompanies = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from companymaster where name like ?");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CompanyBean obj = new CompanyBean();
                obj.setCompanyId(rs.getInt("company_id"));
                obj.setCompanyName(rs.getString("name"));
                lstCompanies.add(obj);
            }
        } catch (Exception e) {
            logger.error("CompanyDAOImpl : getAllCompanies : " + e);
        }
        return lstCompanies;
    }

    @Override
    public String addCompany(CompanyBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into companymaster (name) values(?)");
            pstmt.setString(1, obj.getCompanyName());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Company Added";
            }
        } catch (Exception e) {
            logger.error("CompanyDAOImpl : addCompany : " + e);
        }
        return "Failed to Add Company";
    }

    @Override
    public String updateCompany(CompanyBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update classmaster set name = ? where company_id = ?");
            pstmt.setString(1, obj.getCompanyName());
            pstmt.setInt(2, obj.getCompanyId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Company Updated";
            }
        } catch (Exception e) {
            logger.error("CompanyDAOImpl : updateCompany : " + e);
        }
        return "Failed to Update Company";
    }
}
