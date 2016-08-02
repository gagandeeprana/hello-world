/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.StraightTruckBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface StraightTruckDAO {

    List<StraightTruckBean> getAllStraightTrucks(String name);

    String addStraightTruck(StraightTruckBean obj);

    String updateStraightTruck(StraightTruckBean obj);

    String deleteStraightTruck(int straightTruckId);
}
