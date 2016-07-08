/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.services.admin;

import dpu.beans.admin.AddEditPCBean;
import dpu.beans.admin.ProductCategoryBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class ProductCategoryServicesImpl implements ProductCategoryServicesDAO {
    @Override
     public List<ProductCategoryBean> getAllProductCategories(String search)
    {
        List<ProductCategoryBean> lstCategories=new ArrayList<>();
        try(Connection conn=ConnectDB.connect(); PreparedStatement pstmt=conn.prepareStatement("select * from productcategorymaster where title like '%"+search+"%'");
        ResultSet rs=pstmt.executeQuery();)
        {
            while(rs.next())
            {
                ProductCategoryBean obj=new ProductCategoryBean();
                obj.setCategoryId(rs.getInt("category_id"));
                obj.setTitle(rs.getString("title"));
                obj.setDescription(rs.getString("description"));
                obj.setStatus(rs.getInt("status"));
                obj.setVat(rs.getDouble("vat_per_cent"));
                obj.setCharges(rs.getDouble("shipping_charges_per_kg"));
                lstCategories.add(obj);
            }
        }
        catch(Exception e)
                {
                    System.out.println("getAllCountries(): "+e);
                }
        return lstCategories;
    }
    @Override
      public ProductCategoryBean getPCInfoById(int id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ProductCategoryBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from productcategorymaster where category_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new ProductCategoryBean();
                obj.setTxtcategoryId(rs.getInt("category_id"));
                obj.setTxtTitle(rs.getString("title"));
                obj.setTaDescription(rs.getString("description"));
                obj.setTxtVat(rs.getDouble("vat_per_cent"));
                obj.setTxtShippingCharges(rs.getDouble("shipping_charges_per_kg"));
            }
        } catch (Exception e) {
            System.out.println("getPCInfoById(): " + e);
        }
        return obj;
    }
    @Override
      public String updatePC(AddEditPCBean obj) {
        String result = "Failed to update Product Category";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("update productcategorymaster set title=?,description=?,vat_per_cent=?,shipping_charges_per_kg=? where category_id=?");
            pstmt.setString(1, obj.getTxtTitle());
            pstmt.setString(2, obj.getTaDescription());
            pstmt.setString(3, obj.getTxtVat());
            pstmt.setString(4, obj.getTxtShippingCharges());
            pstmt.setInt(5, obj.getTxtcategoryId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Product Category Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updatePC(): " + e);
        }
        return result;
    }
    @Override
      public String addPC(AddEditPCBean obj)
 {
     String result="Failed to add Product category";
     PreparedStatement pstmt=null;
     Connection conn=null;
     try{
         conn=ConnectDB.connect();
         pstmt=conn.prepareStatement("insert into productcategorymaster(title,description,status,vat_per_cent,shipping_charges_per_kg) values(?,?,?,?,?)");
         pstmt.setString(1, obj.getTxtTitle());
         pstmt.setString(2, obj.getTaDescription());
         pstmt.setInt(3, obj.getRbStatus());
         pstmt.setString(4, obj.getTxtVat());
         pstmt.setString(5, obj.getTxtShippingCharges());
         int i=pstmt.executeUpdate();
         if(i>0)
         {
             result="Product Category Added Successfully";
         }
     }   
     catch(Exception e)
     {
         System.out.println("addPC(): "+e);
     }
     return result;
 }
    @Override
      public String changeStatus(int status,int categoryId)
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
           PreparedStatement pstmt=conn.prepareStatement("update productcategorymaster set status=? where category_id=?");
           pstmt.setInt(1,status);
           pstmt.setInt(2,categoryId);
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
