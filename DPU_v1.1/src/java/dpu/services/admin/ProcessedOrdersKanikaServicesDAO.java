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
import java.util.List;

/**
 *
 * @author student
 */
public interface ProcessedOrdersKanikaServicesDAO {

    String addPayment(PaymentBean obj);

    String dispatchOrder(ProcessedOrdersKanikaBean objPB, OrdersBean objOB);

    List<ProcessedOrdersKanikaBean> getAllProcessedOrders();

    DealerInfoBean getDealerOrderInfoById(int orderId);

    List<OrderDetailsBean> getOrderDetailInfo();
    
}
