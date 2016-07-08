/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditCountryBean;
import dpu.beans.admin.CountryBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface CountryServicesDAO {

    String addCountry(AddEditCountryBean obj);

    String changeStatus(int status, int countryId);

    List<CountryBean> getAllCountries(String name);

    CountryBean getCountryInfoById(int id);

    String updateCountry(AddEditCountryBean obj);
    
}
