/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.services.admin;

import dpu.beans.admin.ProcessedOrdersBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class ProcessedOrdersServicesImpl implements ProcessedOrdersServicesDAO {
    @Override
     public List<ProcessedOrdersBean> getAllProcessedOrders(String startDate, String endDate,String search,String status,String order) {
        List<ProcessedOrdersBean> lstProcessedOrders = new ArrayList<>();
          StringBuilder query = new StringBuilder("select * from ordermaster om,transactionmaster tm where om.order_id=tm.order_id and order_title like '%"+search+"%'");
        if(status.equalsIgnoreCase("All")){
            
            query.append(" and (om.order_status = 'Processed' || om.order_status = 'Dispatched') ");
        }
        else{
            query.append(" and om.order_status = '"+status+"'");
            
        }
        if (!startDate.equals("")) {
            query.append(" and processed_date >= '" + startDate + "'");
        }
        if (!endDate.equals("")) {
            query.append(" and processed_date <= '" + endDate + "'");
        }
        if (order != null) {
                if (order.equals("0")) {
                    query.append(" order by tm.processed_date");
                }
                if (order.equals("1")) {
                    query.append(" order by tm.processed_date");
                }
                if (order.equals("2")) {
                    query.append(" order by tm.dispatch_date");
                }
            }
        try (Connection conn = ConnectDB.connect();
                PreparedStatement pstmt = conn.prepareStatement(query.toString());
                ResultSet rs=pstmt.executeQuery();) {
            System.out.println(pstmt);
            
            while(rs.next())
            {
                 ProcessedOrdersBean obj=new ProcessedOrdersBean();
                obj.setOrder_title(rs.getString("order_title"));
                obj.setOrder_id(rs.getInt("order_id"));
                obj.setProcessed_date(rs.getString("processed_date"));
                obj.setDispatch_date(rs.getString("dispatch_date"));
                obj.setOrder_status(rs.getString("order_status"));
                obj.setAmount(rs.getInt("total_charges"));
                lstProcessedOrders.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllProcessedOrders(): " + e);
        }
        return lstProcessedOrders;
    }
}
