/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.dealers;

import dpu.beans.dealers.OrderItembean;
import dpu.beans.dealers.PlaceNewOrderBean;
import dpu.services.admin.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author SONY
 */
public class PlaceNewOrderServicesImpl implements PlaceNewOrderServicesDAO {

    @Override
    public String placeOrder(PlaceNewOrderBean obj, List<OrderItembean> lstOrderedItems) {
        String result = "order is not placed";
        PreparedStatement ps = null;
        try (Connection conn = ConnectDB.connect();) {
            ps = conn.prepareStatement("insert into ordermaster (order_title,order_date,dealer_id,order_status,is_cancelled,last_update_date,is_payment_done)values(?,sysdate(),?,'Pending',0,sysdate(),0)");
            ps.setString(1, obj.getTxtOrderTitle());
            ps.setInt(2, obj.getDealer_id());
            System.out.println(ps.toString());
            int i = ps.executeUpdate();
            if (i > 0) {
                ps = conn.prepareStatement("insert into orderitemmaster(order_id,product_id,quantity)values((select max(order_id) from ordermaster),?,?)");
                for (i = 0; i < lstOrderedItems.size(); i++) {
                    OrderItembean objOIB = lstOrderedItems.get(i);
                    ps.setInt(1, objOIB.getProduct_id());
                    ps.setInt(2, objOIB.getQuantity());
                    System.out.println(ps.toString());
                    int j = ps.executeUpdate();
                    if (j > 0) {
                        result = "Order PLaced Successfully";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("placeOrder():" + e);
        }
        return result;
    }
}
