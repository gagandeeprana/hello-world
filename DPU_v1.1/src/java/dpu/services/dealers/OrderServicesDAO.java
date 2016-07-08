/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.dealers;

import dpu.beans.dealers.OrderBean;
import dpu.beans.dealers.OrderItembean;
import java.util.List;

/**
 *
 * @author student
 */
public interface OrderServicesDAO {

    List<OrderBean> getAllOrders(String from, String to, String status);

    List<OrderBean> getAllOrdersByDealersId(String from, String to, String dealerId);

    List<OrderBean> getAllOrdersById(String order, String dealerId);

    List<OrderItembean> getAllOrdersItemsByOrderId(String orderId);

    OrderBean getUserInfoById(int id);

    String updateOrders(String orderId);
    
}
