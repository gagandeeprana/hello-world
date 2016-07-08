/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditStateBean;
import dpu.beans.admin.StateBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface StateServicesDAO {

    String addState(AddEditStateBean obj);

    String changeStatus(int status, int stateId);

    List<StateBean> getAllStates(int countryId, String name);

    StateBean getStateInfoById(int id);

    List<StateBean> getStatesByCountryId(int countryId);

    String updateState(AddEditStateBean obj);
    
}
