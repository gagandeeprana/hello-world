/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.ResponseBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class ResponseServicesImpl implements ResponseServicesDAO {

    @Override
    public List<ResponseBean> getAllResponses(String request, String orderBy) {
       
        List<ResponseBean> lstResponses = new ArrayList<>();
        try (Connection conn = ConnectDB.connect();) {
            StringBuilder query = new StringBuilder("select * from requestmaster a left outer join responsemaster b on a.request_id=b.request_id where a.request_title like '%" + request + "%'");
            if (orderBy != null) {
                if (orderBy.equals("0")) {
                    query.append(" order by a.request_title");
                }
                if (orderBy.equals("1")) {
                    query.append(" order by a.request_title desc");
                }
                if (orderBy.equals("post_date")) {
                    query.append(" order by a.request_date");
                }
            }
            System.out.println("quey:; " + query.toString());
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ResponseBean obj = new ResponseBean();
                obj.setRequest_id(rs.getInt("request_id"));
                obj.setResponse_id(rs.getInt("response_id"));
                obj.setRequest_title(rs.getString("request_title"));
                obj.setRequest_date(rs.getString("request_date"));
                obj.setStatus(rs.getString("status"));
                obj.setTaDescription(rs.getString("description"));
                lstResponses.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllResponses(): " + e);
        }
        return lstResponses;
    }

    @Override
    public String addResponse(ResponseBean obj) {
        String res = "Failed to Add Response";
        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("insert into responsemaster(request_id,response,response_date,response_user_id) values(?,?,sysdate(),?)");
            pstmt.setInt(1, obj.getRequest_id());
            pstmt.setString(2, obj.getTaResponse());
            pstmt.setInt(3, obj.getResponse_user_id());
            System.out.println("UserId=" + pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                    PreparedStatement pstmt1 = conn.prepareStatement("update requestmaster set status='completed' where request_id=?");
                    pstmt1.setInt(1, obj.getRequest_id());
                    int j = pstmt1.executeUpdate();
                    if (j > 0) {
                        res = "Response Added Successfully";
                    }
            }

        } catch (Exception e) {
            System.out.println("addResponse(): " + e);
        }
        return res;
    }
}
