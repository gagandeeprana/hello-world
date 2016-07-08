/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditProductBean;
import dpu.beans.admin.ProductsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class ProductsServicesImpl implements ProductsServicesDAO {
    
    @Override
    public List<ProductsBean> getAllProducts(String search, String categoryId) {
        List<ProductsBean> lstProducts = new ArrayList<>();
        
        StringBuilder query = new StringBuilder("select pm.title,pcm.title,pm.*,pcm.* from productcategorymaster pcm,productmaster pm where pcm.category_id=pm.category_id and pm.title like '%" + search + "%'");
        if (!categoryId.equals("0")) {
            
            query.append(" and pcm.category_id=?");
            
        }
        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            if (!categoryId.equals("0")) {
                pstmt.setInt(1, Integer.parseInt(categoryId));
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductsBean obj = new ProductsBean();
                obj.setProductId(rs.getString("product_id"));
                obj.setProduct_title(rs.getString("pm.title"));
                obj.setCategory_id(rs.getString("pcm.category_Id"));
                obj.setPrice(rs.getDouble("price"));
                obj.setModel_no(rs.getString("model_no"));
                obj.setCategory(rs.getString("pcm.title"));
                obj.setStatus(rs.getInt("status"));
                lstProducts.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllProducts(): " + e);
        }
        return lstProducts;
    }
    
    @Override
    public String addProduct(AddEditProductBean obj) {
        String result = "Failed to Add Product";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("insert into productmaster(title,product_code,model_no,category_id,company,description,price,status) values(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getTxtProductTitle());
            pstmt.setString(2, obj.getTxtProductCode());
            pstmt.setString(3, obj.getTxtModelNo());
            pstmt.setInt(4, obj.getDdlCategory());
            pstmt.setString(5, obj.getTxtCompany());
            pstmt.setString(6, obj.getTaDescription());
            pstmt.setString(7, obj.getTxtPrice());
            pstmt.setInt(8, obj.getRbStatus());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Product Added Successfully";
            }
        } catch (Exception e) {
            System.out.println("addProduct(): " + e);
        }
        
        return result;
    }
    
    @Override
    public ProductsBean getProductInfoById(int id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ProductsBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from productmaster  where product_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new ProductsBean();
                obj.setTxtProductId(rs.getString("product_id"));
                obj.setTxtProductTitle(rs.getString("title"));
                obj.setTxtProductCode(rs.getString("product_code"));
                obj.setTxtModelNo(rs.getString("model_no"));
                obj.setDdlCategory(rs.getInt("category_id"));
                obj.setTxtCompany(rs.getString("company"));
                obj.setTaDescription(rs.getString("description"));
                obj.setTxtPrice(rs.getString("price"));
                obj.setRbStatus(rs.getInt("status"));
            }
        } catch (Exception e) {
            System.out.println("getProductInfoById(): " + e);
        }
        return obj;
    }
    
    @Override
    public String updateProduct(AddEditProductBean obj) {
        String result = "Failed to Update Product";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("update productmaster set title=?,product_code=?,model_no=?,category_id=?,company=?,price=?,description=?,status=? where product_id=?");
            pstmt.setString(1, obj.getTxtProductTitle());
            pstmt.setString(2, obj.getTxtProductCode());
            pstmt.setString(3, obj.getTxtModelNo());
            pstmt.setInt(4, obj.getDdlCategory());
            pstmt.setString(5, obj.getTxtCompany());
            pstmt.setString(6, obj.getTxtPrice());
            pstmt.setString(7, obj.getTaDescription());
            pstmt.setInt(8, obj.getRbStatus());
            pstmt.setString(9, obj.getTxtProductId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Product Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updateProduct(): " + e);
        }
        
        return result;
    }
    @Override
     public String changeStatus(int status,int productId)
    {
        String result="Failed To Update Status";
        if(status==1)
        {
            status=0;
        }
        else
        {
            status=1;
        }
        try(Connection conn=ConnectDB.connect();)
        {
           PreparedStatement pstmt=conn.prepareStatement("update productmaster set status=? where product_id=?");
           pstmt.setInt(1,status);
           pstmt.setInt(2,productId);
           int i=pstmt.executeUpdate();
           if(i>0)
           {
               result="Status changed successfully";
           }
        }
        catch(Exception e)
        {
            System.out.println("changeStatus(): "+e);
        }
        return result;
    } 
}
