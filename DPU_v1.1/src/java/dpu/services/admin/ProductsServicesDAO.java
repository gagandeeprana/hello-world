/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditProductBean;
import dpu.beans.admin.ProductsBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface ProductsServicesDAO {

    String addProduct(AddEditProductBean obj);

    String changeStatus(int status, int productId);

    List<ProductsBean> getAllProducts(String search, String categoryId);

    ProductsBean getProductInfoById(int id);

    String updateProduct(AddEditProductBean obj);
    
}
