/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.dealers;

import dpu.beans.dealers.OrderBean;
import dpu.beans.dealers.OrderItembean;
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
public class OrderServicesImpl implements OrderServicesDAO {

    @Override
    public List<OrderBean> getAllOrders(String from, String to, String status) {
        List<OrderBean> lstOrders = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conn = ConnectDB.connect();) {
            StringBuilder query = new StringBuilder("select a.*,b.* from ordermaster a inner join userdetail b on a.dealer_id=b.user_id ");
            if (!status.equals("0")) {
                query.append(" where a.order_status = '" + status + "'");
            }
            if (!from.equals("")) {
                if (query.toString().contains("where")) {
                    query.append(" and a.order_date >= '" + from + "'");
                } else {
                    query.append(" where a.order_date >= '" + from + "'");
                }
            }
            if (!to.equals("")) {
                if (query.toString().contains("where")) {
                    query.append(" and a.order_date <= '" + to + "'");
                } else {
                    query.append(" where a.order_date <= '" + to + "'");
                }
            }
            ps = conn.prepareStatement(query.toString());
            System.out.println("query:: " + ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderBean obj = new OrderBean();
                obj.setOrder_id(rs.getInt("order_id"));
                obj.setDealer_id(rs.getInt("user_id"));
                obj.setOrder_title(rs.getString("order_title"));
                obj.setOrder_status(rs.getString("order_status"));
                obj.setOrder_date(rs.getString("order_date"));
                obj.setIs_cancelled(rs.getInt("is_cancelled"));
                obj.setIs_payment_done(rs.getInt("is_payment_done"));
                obj.setLast_update_date(rs.getString("last_update_date"));
                lstOrders.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllOrders()" + e);
        }
        return lstOrders;
    }

    @Override
    public List<OrderBean> getAllOrdersByDealersId(String from, String to, String dealerId) {
        List<OrderBean> lstOrders = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conn = ConnectDB.connect();) {
            StringBuilder query = new StringBuilder("select a.*,b.* from ordermaster a inner join dealermaster b on a.dealer_id=b.dealer_id where is_cancelled=0 and a.dealer_id=" + dealerId + "");

            if (!from.equals("")) {
                query.append(" and a.order_date >= '" + from + "'");
            }
            if (!to.equals("")) {
                query.append(" and a.order_date <= '" + to + "'");
            }
            ps = conn.prepareStatement(query.toString());
            System.out.println("query:: " + ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderBean obj = new OrderBean();
                obj.setOrder_id(rs.getInt("order_id"));
                obj.setDealer_id(rs.getInt("dealer_id"));
                obj.setOrder_title(rs.getString("order_title"));
                obj.setOrder_status(rs.getString("order_status"));
                obj.setOrder_date(rs.getString("order_date"));
                obj.setIs_cancelled(rs.getInt("is_cancelled"));
                obj.setIs_payment_done(rs.getInt("is_payment_done"));
                obj.setLast_update_date(rs.getString("last_update_date"));
                lstOrders.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllOrders()" + e);
        }
        return lstOrders;
    }

    @Override
    public List<OrderBean> getAllOrdersById(String order, String dealerId) {
        List<OrderBean> lstUsers = new ArrayList<>();
        ResultSet rs = null;

        PreparedStatement ps = null;
        try (Connection conn = ConnectDB.connect();) {

            ps = conn.prepareStatement("select * from ordermaster where is_cancelled=0 and order_title like ? and dealer_id=?");
            ps.setString(1, "%" + order + "%");
            ps.setString(2, dealerId);
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderBean obj = new OrderBean();
                obj.setOrder_id(rs.getInt("order_id"));
                obj.setDealer_id(rs.getInt("dealer_id"));
                obj.setOrder_date(rs.getString("order_date"));
                obj.setOrder_status(rs.getString("order_status"));
                obj.setOrder_title(rs.getString("order_title"));
                lstUsers.add(obj);
            }

        } catch (Exception e) {
            System.out.println("getAllOrdersById()" + e);
        }
        return lstUsers;
    }

    @Override
    public List<OrderItembean> getAllOrdersItemsByOrderId(String orderId) {
        List<OrderItembean> lstOrders = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conn = ConnectDB.connect();) {
            StringBuilder query = new StringBuilder("select * from orderitemmaster oim,productmaster pm where oim.product_id=pm.product_id and order_id=?");
            ps = conn.prepareStatement(query.toString());
            ps.setString(1, orderId);
            System.out.println("query:: " + ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderItembean obj = new OrderItembean();
                obj.setOrder_id(rs.getInt("order_id"));
                obj.setProduct_title(rs.getString("title"));
                obj.setOrder_item_id(rs.getInt("order_item_id"));
                obj.setPrice(rs.getDouble("price"));
                obj.setProduct_id(rs.getInt("product_id"));
                obj.setQuantity(rs.getInt("quantity"));
                lstOrders.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllOrdersItems()" + e);
        }
        return lstOrders;
    }
      
    @Override
   public String updateOrders(String orderId) {
       String result = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conn = ConnectDB.connect();) {
            StringBuilder query = new StringBuilder("update ordermaster set is_cancelled=1 where order_id=?");
            ps = conn.prepareStatement(query.toString());
            ps.setString(1, orderId);
            System.out.println("query:: " + ps.toString());
            int i=ps.executeUpdate();
            if(i>0)
            {
                result="Orders Updated";
            }
        } catch (Exception e) {
            System.out.println("updateOrders()" + e);
        }
        return result;
    }
      
    
    @Override
    public OrderBean getUserInfoById(int id) {
        PreparedStatement ps = null;
        Connection conn = null;
        OrderBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            ps = conn.prepareStatement("select *,(select sum(price)*quantity from productmaster pm,orderitemmaster oim where pm.product_id=oim.product_id and order_id=?) as totalAmount from ordermaster where order_id=?");
            ps.setInt(1, id);
            ps.setInt(2, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new OrderBean();
                obj.setTotalAmount(rs.getDouble("totalAmount"));
                obj.setDealer_id(rs.getInt("dealer_id"));
                obj.setIs_cancelled(rs.getInt("is_cancelled"));
                obj.setIs_payment_done(rs.getInt("is_payment_done"));
                obj.setLast_update_date(rs.getString("last_update_date"));

                obj.setOrder_date(rs.getString("order_date"));

                obj.setOrder_status(rs.getString("order_status"));
                obj.setOrder_title(rs.getString("order_title"));
            }
        } catch (Exception e) {
            System.out.println("getUserInfoById():" + e);
        }
        return obj;
    }
}
