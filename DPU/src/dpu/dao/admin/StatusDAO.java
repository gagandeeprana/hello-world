/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.entity.admin.Status;
import java.util.List;

/**
 *
 * @author Durga
 */
public interface StatusDAO {
    
    List<Status> getAllStatus();
    
}
