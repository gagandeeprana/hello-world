/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.BillingLocationBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface BillingLocationDAO {
    
    List<BillingLocationBean> getAllBillingLocations(String name);
    BillingLocationBean getBillingLocationById(int id);
    List<BillingLocationBean> getBillingLocationsByCompanyId(int id);
    int addBillingLocation(BillingLocationBean obj);
    String updateBillingLocation(BillingLocationBean obj);
    String deleteBillingLocation(int billingLocationId);
}
