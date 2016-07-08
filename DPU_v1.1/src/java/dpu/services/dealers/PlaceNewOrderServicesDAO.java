/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.dealers;

import dpu.beans.dealers.OrderItembean;
import dpu.beans.dealers.PlaceNewOrderBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface PlaceNewOrderServicesDAO {

    String placeOrder(PlaceNewOrderBean obj, List<OrderItembean> lstOrderedItems);
    
}
