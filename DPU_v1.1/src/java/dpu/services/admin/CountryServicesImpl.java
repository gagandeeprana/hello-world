/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditCountryBean;
import dpu.beans.admin.CountryBean;
import dpu.beans.admin.StateBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class CountryServicesImpl implements CountryServicesDAO {

    @Override
    public List<CountryBean> getAllCountries(String name) {
        List<CountryBean> lstCountries = new ArrayList<>();
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("select * from country where name like '%" + name + "%'");
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                CountryBean obj = new CountryBean();
                obj.setCountryId(rs.getInt("country_id"));
                obj.setCountryName(rs.getString("name"));
                obj.setStatus(rs.getInt("status"));
                lstCountries.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllCountries(): " + e);
        }
        return lstCountries;
    }

    @Override
    public String addCountry(AddEditCountryBean obj) {
        String res = "Failed to add country";
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("insert into country (name,status) values (?,?)");) {
            pstmt.setString(1, obj.getTxtCountryName());
            pstmt.setString(2, obj.getRbStatus());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                res = "Country Added Successfully";
            }
        } catch (Exception e) {
            System.out.println("addCountry(): " + e);
        }
        return res;
    }

    @Override
    public String updateCountry(AddEditCountryBean obj) {
        String res = "Failed to update country";
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("update country set name=?,status=? where country_id=?");) {
            pstmt.setString(1, obj.getTxtCountryName());
            pstmt.setString(2, obj.getRbStatus());
            pstmt.setInt(3, obj.getTxtCountryId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                res = "Country Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updateCountry(): " + e);
        }
        return res;
    }

    @Override
    public CountryBean getCountryInfoById(int id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        CountryBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from country where country_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new CountryBean();
                obj.setCountryId(rs.getInt("country_id"));
                obj.setStatus(rs.getInt("status"));
                obj.setCountryName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("getCountryInfoById(): " + e);
        }
        return obj;
    }
    @Override
       public String changeStatus(int status,int countryId)
    {
        String result="Failed To Update Status";
        if(status==1)
        {
            status=0;
        }
        else
        {
            status=1;
        }
        try(Connection conn=ConnectDB.connect();)
        {
           PreparedStatement pstmt=conn.prepareStatement("update country set status=? where country_id=?");
           pstmt.setInt(1,status);
           pstmt.setInt(2,countryId);
           int i=pstmt.executeUpdate();
           if(i>0)
           {
               result="Status changed successfully";
           }
        }
        catch(Exception e)
        {
            System.out.println("changeStatus(): "+e);
        }
        return result;
    }   
}
