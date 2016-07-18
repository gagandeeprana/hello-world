/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.JurisdictionBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface JurisdictionDAO {

    List<JurisdictionBean> getAllJurisdictions(String name);

    String addJurisdiction(JurisdictionBean obj);

    String updateJurisdiction(JurisdictionBean obj);

    String deleteJurisdiction(int JurisdictionId);
}
