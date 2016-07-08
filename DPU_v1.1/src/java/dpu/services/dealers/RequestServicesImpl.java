/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.dealers;

import dpu.beans.dealers.AddEditFeedbackBean;
import dpu.beans.dealers.AddEditRequestBean;
import dpu.beans.dealers.OrderBean;

import dpu.beans.dealers.RequestBean;
import dpu.beans.dealers.ResponseBean;
import dpu.services.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SONY
 */
public class RequestServicesImpl implements RequestServicesDAO {

    @Override
    public List<RequestBean> getAllRequest(String request, String userId) {
        List<RequestBean> lstUsers = new ArrayList<>();
        ResultSet rs = null;

        PreparedStatement ps = null;
        try (Connection conn = ConnectDB.connect();) {

            ps = conn.prepareStatement("select * from requestmaster where request_title like ? and user_id=?");
            ps.setString(1, "%" + request + "%");
            ps.setString(2, userId);
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                RequestBean obj = new RequestBean();
                obj.setRequest_id(rs.getInt("request_id"));
                obj.setRequest_date(rs.getString("request_date"));
                obj.setStatus(rs.getString("status"));
                obj.setRequest_title(rs.getString("request_title"));
                lstUsers.add(obj);
            }

        } catch (Exception e) {
            System.out.println("getAllRequest()" + e);
        }
        return lstUsers;
    }

    @Override
    public String postRequest(AddEditRequestBean obj) {
        String result = "Failed to post Request";
        PreparedStatement ps = null;
        try (Connection conn = ConnectDB.connect();) {
            ps = conn.prepareStatement("insert into requestmaster(request_title,description,request_date,user_id,status) values(?,?,sysdate(),?,'Pending')");
            ps.setString(1, obj.getTxtRequestTitle());
            ps.setString(2, obj.getTaDescription());
            ps.setString(3, obj.getTxtUserId());
            int i = ps.executeUpdate();
            if (i > 0) {
                result = "Request is posted";
            }
        } catch (Exception e) {
            System.out.println("postRequest()" + e);
        }
        return result;
    }

    @Override
    public String postFeedback(AddEditFeedbackBean obj) {
        String result = "Not able to produce feedback";
        PreparedStatement ps = null;
        try (Connection conn = ConnectDB.connect();) {
            ps = conn.prepareStatement("insert into feedbackmaster(feedback,feedback_time,user_id)values(?,sysdate(),?)");
            ps.setString(1, obj.getTaFeedback());
            ps.setInt(2, obj.getTxtuserId());
            int i = ps.executeUpdate();
            if (i > 0) {
                result = "Feedback is provided successfully";
            }

        } catch (Exception e) {
            System.out.println("postFeedback()" + e);
        }
        return result;
    }

    @Override
    public String PlaceNewOrder(OrderBean objOrder) {
        String result = "No Order is Placed";
        PreparedStatement ps = null;
        try (Connection conn = ConnectDB.connect();) {
            ps = conn.prepareStatement("insert into ordermaster(order_title,order_date,dealer_id,order_status,is_cancelled,last_update_date,is_payment_done)values(?,sysdate(),?,?,?,sysdate(),?)");
            ps.setString(1, objOrder.getOrder_title());
            ps.setInt(1, objOrder.getDealer_id());
            ps.setString(1, objOrder.getOrder_status());
            ps.setInt(1, objOrder.getIs_cancelled());
            ps.setInt(1, objOrder.getIs_payment_done());
            int i = ps.executeUpdate();
            if (i > 0) {
                result = "order is placed successfully";
            }
//           ps=conn.prepareStatement("insert into productmaster(title,product_code,model_no,category_id,company,description,price,status,weight)values(?,?,?,?,?,?,?,?,?)");
//           ps.setString(1, objProduct.getTitle());
//           ps.setString(2, objProduct.getProduct_code());
//           ps.setString(3, objProduct.getModel_no());
//           ps.setInt(4, objProduct.getCategory_id());
//           ps.setString(5, objProduct.getCompany());
//           ps.setString(6, objProduct.getDescription());
        } catch (Exception e) {
            System.out.println("PlaceNewOrder" + e);
        }
        return result;

    }

    @Override
    public ResponseBean getRequestInfo(int id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResponseBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            ps = conn.prepareStatement("select * from requestmaster rm left outer join responsemaster rsm on rm.request_id=rsm.request_id where rm.request_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new ResponseBean();
                obj.setRequest_title(rs.getString("request_title"));
                obj.setRequest_description(rs.getString("description"));
                obj.setRequest_date(rs.getString("request_date"));
                obj.setResponse_description(rs.getString("response"));
                obj.setRequest_id(rs.getInt("request_id"));
                obj.setResponse_id(rs.getInt("response_id"));
                obj.setResponse(rs.getString("response"));
            }
        } catch (Exception e) {
            System.out.println("getRequestInfo():" + e);
        }
        return obj;
    }
}
