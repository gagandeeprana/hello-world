/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.OrdersBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class OrderServicesImpl implements OrderServicesDAO {

    @Override
    public List<OrdersBean> getAllOrders(String startDate, String endDate, String status, String order) {
        List<OrdersBean> lstOrders = new ArrayList<>();
        StringBuilder query = new StringBuilder("select * from ordermaster om,userdetail dm where om.dealer_id=dm.user_id ");
        if (status.equalsIgnoreCase("1")) {

            query.append(" and om.order_status='pending' ");
        } else if (status.equalsIgnoreCase("2")) {

//            query.append(" and om.is_cancelled='1' ");
            query.append(" and om.order_status='cancel' ");
        }
        if (!startDate.equals("")) {
            query.append(" and order_date >= '" + startDate + "'");
        }
        if (!endDate.equals("")) {
//            if (query.toString().contains("where")) {
//                query.append(" and last_update_date <= '" + endDate + "'");
//
//            } else {
            query.append(" and last_update_date <= '" + endDate + "'");

//            }
        }
        if (order != null) {
            if (order.equals("0")) {
                query.append(" order by order_date");
            }
            if (order.equals("1")) {
                query.append(" order by order_date");
            }
            if (order.equals("2")) {
                query.append(" order by order_title");
            }
            if (order.equals("3")) {
                query.append(" order by order_title desc");
            }
        }
        System.out.println("query::" + query.toString());
        try (Connection conn = ConnectDB.connect();
                PreparedStatement pstmt = conn.prepareStatement(query.toString());
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                OrdersBean obj = new OrdersBean();
                obj.setOrder_title(rs.getString("order_title"));
                obj.setOrder_id(rs.getInt("order_id"));
                obj.setOrder_date(rs.getString("order_date"));
                obj.setDealer(rs.getString("name"));
                obj.setStatus(rs.getString("order_status"));
                obj.setLast_update_date(rs.getString("last_update_date"));
                lstOrders.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllStates(): " + e);
        }
        return lstOrders;
    }
}
