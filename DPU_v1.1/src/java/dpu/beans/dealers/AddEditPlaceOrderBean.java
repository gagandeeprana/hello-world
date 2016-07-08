/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.beans.dealers;

/**
 *
 * @author SONY
 */
public class AddEditPlaceOrderBean {
    
    private String txtOrderTitle,txtOrderDate,ddlCategory,ddlProduct,txtQuantity;

    public String getTxtOrderTitle() {
        return txtOrderTitle;
    }

    public void setTxtOrderTitle(String txtOrderTitle) {
        this.txtOrderTitle = txtOrderTitle;
    }

    public String getTxtOrderDate() {
        return txtOrderDate;
    }

    public void setTxtOrderDate(String txtOrderDate) {
        this.txtOrderDate = txtOrderDate;
    }

    public String getDdlCategory() {
        return ddlCategory;
    }

    public void setDdlCategory(String ddlCategory) {
        this.ddlCategory = ddlCategory;
    }

    public String getDdlProduct() {
        return ddlProduct;
    }

    public void setDdlProduct(String ddlProduct) {
        this.ddlProduct = ddlProduct;
    }

    public String getTxtQuantity() {
        return txtQuantity;
    }

    public void setTxtQuantity(String txtQuantity) {
        this.txtQuantity = txtQuantity;
    }
    
}
