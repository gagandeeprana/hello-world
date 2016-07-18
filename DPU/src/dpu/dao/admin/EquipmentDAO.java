/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.EquipmentBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface EquipmentDAO {
    
    List<EquipmentBean> getAllEquipments(String name);
    String addEquipment(EquipmentBean obj);
    String updateEquipment(EquipmentBean obj);
    String deleteEquipment(int equipmentId);
}
