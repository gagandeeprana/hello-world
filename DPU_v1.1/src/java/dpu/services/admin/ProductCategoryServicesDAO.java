/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditPCBean;
import dpu.beans.admin.ProductCategoryBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface ProductCategoryServicesDAO {

    String addPC(AddEditPCBean obj);

    String changeStatus(int status, int categoryId);

    List<ProductCategoryBean> getAllProductCategories(String search);

    ProductCategoryBean getPCInfoById(int id);

    String updatePC(AddEditPCBean obj);
    
}
