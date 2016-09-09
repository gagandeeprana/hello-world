/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.StandardChargesBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface StandardChargesDAO {

    List<StandardChargesBean> getAllStandardCharges(String code);

    StandardChargesBean getStandardChargesInfoById(int id);

    int addStandardCharges(StandardChargesBean obj);

    String updateStandardCharges(StandardChargesBean obj);

    String deleteStandardCharges(int standardChargesId);
}
