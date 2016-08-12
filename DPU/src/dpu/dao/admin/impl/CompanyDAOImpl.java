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
                obj.setAddress(rs.getString("address"));
                obj.setUnitNo(rs.getString("unit_no"));
                obj.setCity(rs.getString("city"));
                obj.setProvinceState(rs.getString("province_state"));
                obj.setZip(rs.getString("zip"));
                obj.setEmail(rs.getString("email"));
                obj.setWebsite(rs.getString("website"));
                obj.setContact(rs.getString("contact"));
                obj.setPosition(rs.getString("position"));
                obj.setPhone(rs.getString("phone"));
                obj.setExt(rs.getString("ext"));
                obj.setFax(rs.getString("fax"));
                obj.setPrefix(rs.getString("prefix"));
                obj.setTollfree(rs.getString("tollfree"));
                obj.setCellular(rs.getString("cellular"));
                obj.setPager(rs.getString("pager"));
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
            pstmt = conn.prepareStatement("insert into companymaster (name,address,unit_no,city,province_state,zip,email,website,contact,position,phone,ext,fax,prefix,tollfree,cellular,pager) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getCompanyName());
            pstmt.setString(2, obj.getAddress());
            pstmt.setString(3, obj.getUnitNo());
            pstmt.setString(4, obj.getCity());
            pstmt.setString(5, obj.getProvinceState());
            pstmt.setString(6, obj.getZip());
            pstmt.setString(7, obj.getEmail());
            pstmt.setString(8, obj.getWebsite());
            pstmt.setString(9, obj.getContact());
            pstmt.setString(10, obj.getPosition());
            pstmt.setString(11, obj.getPhone());
            pstmt.setString(12, obj.getExt());
            pstmt.setString(13, obj.getFax());
            pstmt.setString(14, obj.getPrefix());
            pstmt.setString(15, obj.getTollfree());
            pstmt.setString(16, obj.getCellular());
            pstmt.setString(17, obj.getPager());
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
            pstmt = conn.prepareStatement("update companymaster set name = ?,address=?,unit_no=?,city=?,province_state=?,zip=?,email=?,website=?,contact=?,position=?,phone=?,ext=?,fax=?,prefix = ?,tollfree=?,cellular=?,pager=? where company_id = ?");
            pstmt.setString(1, obj.getCompanyName());
            pstmt.setString(2, obj.getAddress());
            pstmt.setString(3, obj.getUnitNo());
            pstmt.setString(4, obj.getCity());
            pstmt.setString(5, obj.getProvinceState());
            pstmt.setString(6, obj.getZip());
            pstmt.setString(7, obj.getEmail());
            pstmt.setString(8, obj.getWebsite());
            pstmt.setString(9, obj.getContact());
            pstmt.setString(10, obj.getPosition());
            pstmt.setString(11, obj.getPhone());
            pstmt.setString(12, obj.getExt());
            pstmt.setString(13, obj.getFax());
            pstmt.setString(14, obj.getPrefix());
            pstmt.setString(15, obj.getTollfree());
            pstmt.setString(16, obj.getCellular());
            pstmt.setString(17, obj.getPager());
            pstmt.setInt(18, obj.getCompanyId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Company Updated";
            }
        } catch (Exception e) {
            System.out.println(e);
            logger.error("CompanyDAOImpl : updateCompany : " + e);
        }
        return "Failed to Update Company";
    }

    @Override
    public String deleteCompany(int companyId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from companymaster where company_id = ?");
            pstmt.setInt(1, companyId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Company Deleted";
            }
        } catch (Exception e) {
            logger.error("CompanyDAOImpl : deleteCompany : " + e);
        }
        return "Failed to Delete Company";
    }

    @Override
    public CompanyBean getCompanyInfoById(int companyId) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        CompanyBean obj = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from companymaster where company_id = ?");
            pstmt.setInt(1, companyId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new CompanyBean();
                obj.setCompanyId(rs.getInt("company_id"));
                obj.setCompanyName(rs.getString("name"));
                obj.setAddress(rs.getString("address"));
                obj.setUnitNo(rs.getString("unit_no"));
                obj.setCity(rs.getString("city"));
                obj.setProvinceState(rs.getString("province_state"));
                obj.setZip(rs.getString("zip"));
                obj.setEmail(rs.getString("email"));
                obj.setWebsite(rs.getString("website"));
                obj.setContact(rs.getString("contact"));
                obj.setPosition(rs.getString("position"));
                obj.setPhone(rs.getString("phone"));
                obj.setExt(rs.getString("ext"));
                obj.setFax(rs.getString("fax"));
                obj.setPrefix(rs.getString("prefix"));
                obj.setTollfree(rs.getString("tollfree"));
                obj.setCellular(rs.getString("cellular"));
                obj.setPager(rs.getString("pager"));
            }
        } catch (Exception e) {
            logger.error("CompanyDAOImpl : getCompanyInfoById : " + e);
        }
        return obj;
    }
}
