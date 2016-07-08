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
import java.util.List;

/**
 *
 * @author student
 */
public interface RequestServicesDAO {

    String PlaceNewOrder(OrderBean objOrder);

    List<RequestBean> getAllRequest(String request, String userId);

    ResponseBean getRequestInfo(int id);

    String postFeedback(AddEditFeedbackBean obj);

    String postRequest(AddEditRequestBean obj);
    
}
