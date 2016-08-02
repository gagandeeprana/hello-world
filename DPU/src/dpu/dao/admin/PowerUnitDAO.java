/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.PowerUnitBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface PowerUnitDAO {

    List<PowerUnitBean> getAllPowerUnits(String name);

    String addPowerUnit(PowerUnitBean obj);

    String updatePowerUnit(PowerUnitBean obj);

    String deletePowerUnit(int powerunitId);
}
