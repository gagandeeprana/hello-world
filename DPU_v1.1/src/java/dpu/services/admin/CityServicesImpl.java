/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditCityBean;
import dpu.beans.admin.CityBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class CityServicesImpl implements CityServicesDAO {

    @Override
    public List<CityBean> getAllCities(int stateId, String name) {
        List<CityBean> lstCities = new ArrayList<>();
        try (Connection conn = ConnectDB.connect();
                PreparedStatement pstmt = conn.prepareStatement("select * from city where state_Id=? and name like ?");) {
            pstmt.setInt(1, stateId);
            pstmt.setString(2, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CityBean obj = new CityBean();
                obj.setCityId(rs.getInt("city_id"));
                obj.setName(rs.getString("name"));
                obj.setStatus(rs.getInt("status"));
                lstCities.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllCities(): " + e);
        }
        return lstCities;
    }

    @Override
    public String addCity(AddEditCityBean obj) {
        String result = "Failed to add city";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("insert into city(name,status,state_id) values(?,?,?)");
            pstmt.setString(1, obj.getTxtCityName());
            pstmt.setInt(2, obj.getRbStatus());
            pstmt.setInt(3, obj.getStateId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "City Added Successfully";
            }
        } catch (Exception e) {
            System.out.println("addCity(): " + e);
        }
        return result;
    }

    @Override
    public String updateCity(AddEditCityBean obj) {
        String result = "Failed to update city";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("update  city set name=?,status=? where city_id=?");
            pstmt.setString(1, obj.getTxtCityName());
            pstmt.setInt(2, obj.getRbStatus());
            pstmt.setString(3, obj.getTxtCityId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "City Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updateCity(): " + e);
        }
        return result;
    }

    @Override
    public List<CityBean> getCitiesByStateId(int stateId) {
        List<CityBean> lstCities = new ArrayList<>();
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from city where state_id=?");
            pstmt.setInt(1, stateId);
            System.out.println("query:: " + pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CityBean obj = new CityBean();
                obj.setCityId(rs.getInt("city_id"));
                obj.setName(rs.getString("name"));
                lstCities.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getCitiesByStateId(): " + e);
        }

        return lstCities;
    }
    @Override
    public CityBean getCityInfoById(int id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        CityBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from city where city_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new CityBean();
                obj.setCityId(rs.getInt("city_id"));
                obj.setStatus(rs.getInt("status"));
                obj.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("getCityInfoById(): " + e);
        }
        return obj;
    }
    @Override
     public String changeStatus(int status,int cityId)
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
           PreparedStatement pstmt=conn.prepareStatement("update city set status=? where city_id=?");
           pstmt.setInt(1,status);
           pstmt.setInt(2,cityId);
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
