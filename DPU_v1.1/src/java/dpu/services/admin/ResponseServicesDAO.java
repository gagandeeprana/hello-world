/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.ResponseBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface ResponseServicesDAO {

    String addResponse(ResponseBean obj);

    List<ResponseBean> getAllResponses(String request, String orderBy);
    
}
