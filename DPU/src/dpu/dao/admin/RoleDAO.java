/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.RoleBean;
import dpu.entity.admin.Role;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface RoleDAO {

    List<Role> getAllRole();
    
    List<RoleBean> getAllRoles(String name);

    String addRole(RoleBean obj);

    String updateRole(RoleBean obj);

    String deleteRole(int roleId);
}
