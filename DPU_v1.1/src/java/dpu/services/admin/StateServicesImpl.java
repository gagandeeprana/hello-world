/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditStateBean;
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
public class StateServicesImpl implements StateServicesDAO {

    @Override
    public List<StateBean> getAllStates(int countryId, String name) {
        List<StateBean> lstStates = new ArrayList<>();
        try (Connection conn = ConnectDB.connect();
                PreparedStatement pstmt = conn.prepareStatement("select * from state where country_id = ? and name like ?");) {
            pstmt.setInt(1, countryId);
            pstmt.setString(2, "%" + name + "%");
            System.out.println(pstmt.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                StateBean obj = new StateBean();
                obj.setStateId(rs.getInt("state_id"));
                obj.setName(rs.getString("name"));
                obj.setStatus(rs.getInt("status"));
                lstStates.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllStates(): " + e);
        }
        return lstStates;
    }

    @Override
    public String addState(AddEditStateBean obj) {
        String res = "Failed to add State";
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("insert into state (name,status,country_id) values (?,?,?)");) {
            pstmt.setString(1, obj.getTxtStateName());
            pstmt.setInt(2, obj.getRbStatus());
            pstmt.setInt(3, obj.getTxtCountryId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                res = "State Added Successfully";
            }
        } catch (Exception e) {
            System.out.println("addState(): " + e);
        }
        return res;
    }
    @Override
    public String updateState(AddEditStateBean obj) {
        String res = "Failed to update state";
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("update state set name=?,status=? where state_id=?");) {
            pstmt.setString(1, obj.getTxtStateName());
            pstmt.setInt(2, obj.getRbStatus());
            pstmt.setInt(3, obj.getTxtStateId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                res = "State Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updateState(): " + e);
        }
        return res;
    }
    
    @Override
 public List<StateBean> getStatesByCountryId(int countryId)
    {
        List<StateBean> lstStates=new ArrayList<>();
        PreparedStatement pstmt= null;
        Connection conn= null;
        try
        {
               conn= ConnectDB.connect();
               pstmt=conn.prepareStatement("select * from state where country_id=?");
               pstmt.setInt(1, countryId);
               System.out.println(pstmt.toString());
               ResultSet rs=pstmt.executeQuery();
               while(rs.next())
               {
                   StateBean obj =new StateBean();
                   obj.setStateId(rs.getInt("state_id"));
                   obj.setStateName(rs.getString("name"));
                   lstStates.add(obj);
                }
        }
        catch(Exception e)
        {
            System.out.println("getStatesByCountryId(): "+e);
        }
    
    return lstStates;
    }
    @Override
 public StateBean getStateInfoById(int id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        StateBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from state where state_id=?");
            pstmt.setInt(1, id);
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new StateBean();
                obj.setStateId(rs.getInt("state_id"));
                obj.setStatus(rs.getInt("status"));
                obj.setStateName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("getStateInfoById(): " + e);
        }
        return obj;
    }
    @Override
  public String changeStatus(int status,int stateId)
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
           PreparedStatement pstmt=conn.prepareStatement("update state set status=? where state_id=?");
           pstmt.setInt(1,status);
           pstmt.setInt(2,stateId);
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