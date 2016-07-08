/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.DealerInfoBean;
import dpu.beans.admin.OrderDetailsBean;
import dpu.beans.admin.OrdersBean;
import dpu.beans.admin.PaymentBean;
import dpu.beans.admin.ProcessedOrdersKanikaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sikka
 */
public class ProcessedOrdersKanikaServicesImpl implements ProcessedOrdersKanikaServicesDAO {

    @Override
    public List<ProcessedOrdersKanikaBean> getAllProcessedOrders() {
        List<ProcessedOrdersKanikaBean> lstProcessedOrders = new ArrayList<>();
        try (Connection conn = ConnectDB.connect();
                PreparedStatement pstmt = conn.prepareStatement("select * from ordermaster om,transactionmaster tm where om.order_id=tm.order_id");
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                ProcessedOrdersKanikaBean obj = new ProcessedOrdersKanikaBean();
                obj.setOrder_id(rs.getInt("order_id"));
                obj.setOrder_title(rs.getString("order_title"));
                obj.setProcessed_date(rs.getString("processed_date"));
                obj.setDispatch_date(rs.getString("dispatch_date"));
                obj.setAmount(rs.getDouble("total_charges") + rs.getDouble("shipping_charges"));
                lstProcessedOrders.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllProcessedOrders(): " + e);
        }
        return lstProcessedOrders;
    }

    @Override
    public List<OrderDetailsBean> getOrderDetailInfo() {
        List<OrderDetailsBean> lstOrders = new ArrayList<>();
        try (Connection conn = ConnectDB.connect();
                PreparedStatement pstmt = conn.prepareStatement("select * from orderitemmaster oi,productmaster pm,productcategorymaster pcm where oi.product_id=pm.product_id and pm.category_id=pcm.category_id ");
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                OrderDetailsBean obj = new OrderDetailsBean();
                obj.setOrder_id(rs.getInt("order_id"));
                obj.setPrice(rs.getDouble("price"));
                obj.setProductTitle(rs.getString("title"));
                obj.setQuantity(rs.getInt("quantity"));
                obj.setShipping_charges(rs.getDouble("shipping_charges_per_kg"));
                obj.setVat(rs.getDouble("vat_per_cent"));
                lstOrders.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getOrderDetailInfo(): " + e);
        }
        return lstOrders;
    }

    @Override
    public DealerInfoBean getDealerOrderInfoById(int orderId) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        DealerInfoBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from ordermaster om left join userdetail dm on om.dealer_id=dm.user_id left join transactionmaster tm on om.order_id=tm.order_id where tm.order_id=?");
            pstmt.setInt(1, orderId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                obj = new DealerInfoBean();
                obj.setOrder_date(rs.getString("order_date"));
                obj.setOrder_title(rs.getString("order_title"));
                obj.setShipping_charges(rs.getDouble("shipping_charges"));
                obj.setTotal_charges(rs.getDouble("total_charges"));
                obj.setNet_amount(obj.getShipping_charges() + obj.getTotal_charges());
                obj.setName(rs.getString("name"));
                obj.setContact(rs.getString("phone"));
                obj.setEmail(rs.getString("email"));
                obj.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            System.out.println("getDealerOrderInfoById(): " + e);
        }
        return obj;
    }

    @Override
    public String addPayment(PaymentBean obj) {
        String result = "failed transaction";
        PreparedStatement ps = null;
        try (Connection conn = ConnectDB.connect();) {
            ps = conn.prepareStatement("insert into transactionmaster(order_id,processed_date,total_charges,shipping_charges,payment_via,dispatch_date,order_processed_by,bill_no)values(?,sysdate(),?,?,?,?,?,?)");
            ps.setInt(1, obj.getOrder_id());
            ps.setDouble(2, obj.getTotal_charges());
            ps.setDouble(3, obj.getShipping_charges());
            ps.setString(4, obj.getPayment_via());
            ps.setString(5, obj.getDispatch_date());
            ps.setInt(6, obj.getOrder_processed_by());
            ps.setInt(7, obj.getOrder_id());
            System.out.println(ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                result = "transaction done sucessfully";
            }

        } catch (Exception e) {
            System.out.println("addPayment(): " + e);
        }
        return result;
    }

    @Override
    public String dispatchOrder(ProcessedOrdersKanikaBean objPB, OrdersBean objOB) {
        String result = "order is not dispatched";
        PreparedStatement ps = null;
        try (Connection conn = ConnectDB.connect();) {
            ps = conn.prepareStatement("update transactionmaster set bill_no=?, dispatch_date=sysdate(),order_dispatched_by=? where order_id=?");
            ps.setInt(1, objPB.getBill_no());
            ps.setInt(2, objPB.getOrder_dispatched_by());
            ps.setInt(3, objPB.getOrder_id());
            System.out.println(ps.toString());
            int i = ps.executeUpdate();
            if (i > 0) {
                ps = conn.prepareStatement("update ordermaster set order_status='Dispatched' where order_id=?");
                ps.setInt(1, objOB.getOrder_id());
                System.out.println(ps.toString());
                int j = ps.executeUpdate();
                if (j > 0) {
                    result = "order dispatched successfully";
                }
            }
        } catch (Exception e) {
            System.out.println("dipatchOrder()" + e);
        }
        return result;
    }
}
