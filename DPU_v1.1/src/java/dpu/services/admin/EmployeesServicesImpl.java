/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditEmployeeBean;
import dpu.beans.admin.EmployeesBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class EmployeesServicesImpl implements EmployeesServicesDAO {

    @Override
    public List<EmployeesBean> getAllEmployees(String status, String Search) {
        List<EmployeesBean> lstEmployees = new ArrayList<>();
        StringBuilder query = new StringBuilder("select * from usermaster um,userdetail ud where um.user_id=ud.user_id and name like ? ");
        if (!status.equals("0")) {
            if (status.equalsIgnoreCase("active")) {
                query.append(" and user_status='" + status + "'");
            } else {
                query.append(" and user_status='" + status + "'");
            }
        }
        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, "%" + Search + "%");
            ResultSet rs = pstmt.executeQuery();
            System.out.println(pstmt.toString());
            while (rs.next()) {
                EmployeesBean obj = new EmployeesBean();
                obj.setEmployeeId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setContact(rs.getInt("phone"));
                obj.setMail(rs.getString("email"));
                obj.setStatus(rs.getString("user_status"));
                lstEmployees.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllEmployees(): " + e);
        }
        return lstEmployees;
    }

    @Override
    public String addEmp(AddEditEmployeeBean obj) {
        String result = "Failed To Add Employee";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("insert into usermaster(username,password,user_type,user_status) values(?,?,'employee','InActive')");
            pstmt.setString(1, obj.getTxtUsername());
            pstmt.setString(2, obj.getTxtPassword());
            int i = pstmt.executeUpdate();
            pstmt = conn.prepareStatement("insert into userdetail(user_id,name,gender,dob,phone,mobile,email,address,country_id,state_id,city_id,pin_code) values((select max(user_id) from usermaster),?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getTxtName());
            pstmt.setString(2, obj.getRbGender());
            pstmt.setString(3, obj.getTxtDob());
            pstmt.setString(4, obj.getTxtPhone());
            pstmt.setString(5, obj.getTxtMobile());
            pstmt.setString(6, obj.getTxtEmail());
            pstmt.setString(7, obj.getTaAddress());
            pstmt.setInt(8, obj.getDdlCountry());
            pstmt.setInt(9, obj.getDdlState());
            pstmt.setInt(10, obj.getDdlCity());
            pstmt.setString(11, obj.getTxtPin());
            int j = pstmt.executeUpdate();
            if (i > 0 && j > 0) {
                result = "Employee Added Successfully";
            }
        } catch (Exception e) {
            System.out.println("addEmp(): " + e);
        }
        return result;
    }

    @Override
    public EmployeesBean getEmployeeInfoById(int id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        EmployeesBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from userdetail ud,usermaster um where ud.user_id=um.user_id and um.user_id=?");
            pstmt.setInt(1, id);
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new EmployeesBean();
                obj.setTxtEmployeeId(rs.getString("ud.user_id"));
                obj.setTxtUsername(rs.getString("username"));
                obj.setTxtPassword(rs.getString("password"));
                obj.setTxtName(rs.getString("name"));
                obj.setRbGender(rs.getString("gender"));
                obj.setTxtDob(rs.getString("dob"));
                obj.setTxtPhone(rs.getString("phone"));
                obj.setTxtMobile(rs.getString("mobile"));
                obj.setTxtEmail(rs.getString("email"));
                obj.setTaAddress(rs.getString("address"));
                obj.setDdlCountry(rs.getInt("country_id"));
                obj.setDdlState(rs.getInt("state_id"));
                obj.setDdlCity(rs.getInt("city_id"));
                obj.setTxtPin(rs.getString("pin_code"));
            }
        } catch (Exception e) {
            System.out.println("getEmployeeInfoById(): " + e);
        }
        return obj;
    }

    @Override
    public String updateEmployee(AddEditEmployeeBean obj) {
        String result = "Failed to update employee";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("update usermaster set username=?,password=? where user_id=?");
            pstmt.setString(1, obj.getTxtUsername());
            pstmt.setString(2, obj.getTxtPassword());
            pstmt.setString(3, obj.getTxtEmployeeId());
            int j = pstmt.executeUpdate();
            pstmt = conn.prepareStatement("update userdetail set name=?,gender=?,dob=?,phone=?,mobile=?,email=?,address=?,country_id=?,state_id=?,city_id=?,pin_code=? where user_id=?");
            pstmt.setString(1, obj.getTxtName());
            pstmt.setString(2, obj.getRbGender());
            pstmt.setString(3, obj.getTxtDob());
            pstmt.setString(4, obj.getTxtPhone());
            pstmt.setString(5, obj.getTxtMobile());
            pstmt.setString(6, obj.getTxtEmail());
            pstmt.setString(7, obj.getTaAddress());
            pstmt.setInt(8, obj.getDdlCountry());
            pstmt.setInt(9, obj.getDdlState());
            pstmt.setInt(10, obj.getDdlCity());
            pstmt.setString(11, obj.getTxtPin());
            pstmt.setString(12, obj.getTxtEmployeeId());
            int i = pstmt.executeUpdate();
            if (j > 0 && i > 0) {
                result = "Employee Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updateEmployee(): " + e);
        }
        return result;
    }
    @Override
     public String changeStatus(String status,int employeeId)
    {
        String result="Failed To Update Status";
        if(status.equalsIgnoreCase("active"))
        {
            status="Inactive";
        }
        else
        {
            status="Active";
        }
        try(Connection conn=ConnectDB.connect();)
        {
           PreparedStatement pstmt=conn.prepareStatement("update usermaster set user_status=? where user_id=?");
           pstmt.setString(1,status);
           pstmt.setInt(2,employeeId);
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
