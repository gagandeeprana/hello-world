/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditDealerBean;
import dpu.beans.admin.DealersBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface DealersServicesDAO {

    String addDealers(AddEditDealerBean obj);

    String changeStatus(int status, int dealerId);

    List<DealersBean> getAllDealers(String Location, String name);

    DealersBean getDealerInfoById(int id);

    String updateDealer(AddEditDealerBean obj);
    
}
