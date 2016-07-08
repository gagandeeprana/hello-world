/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditEmployeeBean;
import dpu.beans.admin.EmployeesBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface EmployeesServicesDAO {

    String addEmp(AddEditEmployeeBean obj);

    String changeStatus(String status, int employeeId);

    List<EmployeesBean> getAllEmployees(String status, String Search);

    EmployeesBean getEmployeeInfoById(int id);

    String updateEmployee(AddEditEmployeeBean obj);
    
}
