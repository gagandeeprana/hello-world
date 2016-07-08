/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditCityBean;
import dpu.beans.admin.CityBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface CityServicesDAO {

    String addCity(AddEditCityBean obj);

    String changeStatus(int status, int cityId);

    List<CityBean> getAllCities(int stateId, String name);

    List<CityBean> getCitiesByStateId(int stateId);

    CityBean getCityInfoById(int id);

    String updateCity(AddEditCityBean obj);
    
}
