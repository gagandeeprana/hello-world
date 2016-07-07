/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.DivisionBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface DivisionDAO {
    
    List<DivisionBean> getAllDivisions(String name);
    String addDivision(DivisionBean obj);
    String updateDivision(DivisionBean obj);
}
