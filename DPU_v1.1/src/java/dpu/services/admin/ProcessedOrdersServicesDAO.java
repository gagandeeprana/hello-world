/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.ProcessedOrdersBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface ProcessedOrdersServicesDAO {

    List<ProcessedOrdersBean> getAllProcessedOrders(String startDate, String endDate, String search, String status, String order);
    
}
