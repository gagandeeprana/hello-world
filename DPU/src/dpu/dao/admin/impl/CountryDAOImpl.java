/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.CountryBean;
import dpu.dao.admin.CountryDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryDAOImpl implements CountryDAO {

    @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(CountryDAOImpl.class);

    @Override
    public List<CountryBean> getAllCountries(String name) {
        List<CountryBean> lstCompanies = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from countrymaster where name like ?");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CountryBean obj = new CountryBean();
                obj.setCountryId(rs.getInt("country_id"));
                obj.setCountryName(rs.getString("name"));
                lstCompanies.add(obj);
            }
        } catch (Exception e) {
            logger.error("CountryDAOImpl : getAllCompanies : " + e);
        }
        return lstCompanies;
    }

    @Override
    public String addCountry(CountryBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into countrymaster values(?,?)");
            pstmt.setInt(1, obj.getCountryId());
            pstmt.setString(2, obj.getCountryName());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Country Added";
            }
        } catch (Exception e) {
            logger.error("CountryDAOImpl : addCountry : " + e);
        }
        return "Failed to Add Country";
    }

    @Override
    public String updateCountry(CountryBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update countrymaster set name = ? where country_id = ?");
            pstmt.setString(1, obj.getCountryName());
            pstmt.setInt(2, obj.getCountryId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Country Updated";
            }
        } catch (Exception e) {
            logger.error("CountryDAOImpl : updateCountry : " + e);
        }
        return "Failed to Update Country";
    }

    @Override
    public String deleteCountry(int countryId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from countrymaster where country_id = ?");
            pstmt.setInt(1, countryId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Country Deleted";
            }
        } catch (Exception e) {
            logger.error("CountryDAOImpl : deleteCountry : " + e);
        }
        return "Failed to Delete Country";
    }

    @Override
    public CountryBean getCountryInfo(int countryId) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        CountryBean obj = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from countrymaster where country_id = ?");
            pstmt.setInt(1, countryId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new CountryBean();
                obj.setCountryId(rs.getInt("country_id"));
                obj.setCountryName(rs.getString("name"));
            }
        } catch (Exception e) {
            logger.error("CountryDAOImpl : getAllCompanies : " + e);
        }
        return obj;
    }
}
