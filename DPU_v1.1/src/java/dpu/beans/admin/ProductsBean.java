/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.beans.admin;

/**
 *
 * @author sikka
 */
public class ProductsBean {
    private double price;
    private String product_title,model_no,category,productId,txtProductId,txtProductTitle,txtProductCode,txtModelNo,txtCompany,txtPrice,taDescription,category_id;
    private int status,ddlCategory,rbStatus;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTxtProductId() {
        return txtProductId;
    }

    public void setTxtProductId(String txtProductId) {
        this.txtProductId = txtProductId;
    }

    public String getTxtProductTitle() {
        return txtProductTitle;
    }

    public void setTxtProductTitle(String txtProductTitle) {
        this.txtProductTitle = txtProductTitle;
    }

    public String getTxtProductCode() {
        return txtProductCode;
    }

    public void setTxtProductCode(String txtProductCode) {
        this.txtProductCode = txtProductCode;
    }

    public String getTxtModelNo() {
        return txtModelNo;
    }

    public void setTxtModelNo(String txtModelNo) {
        this.txtModelNo = txtModelNo;
    }

    public String getTxtCompany() {
        return txtCompany;
    }

    public void setTxtCompany(String txtCompany) {
        this.txtCompany = txtCompany;
    }

    public String getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(String txtPrice) {
        this.txtPrice = txtPrice;
    }

    public String getTaDescription() {
        return taDescription;
    }

    public void setTaDescription(String taDescription) {
        this.taDescription = taDescription;
    }

    public int getDdlCategory() {
        return ddlCategory;
    }

    public void setDdlCategory(int ddlCategory) {
        this.ddlCategory = ddlCategory;
    }

    public int getRbStatus() {
        return rbStatus;
    }

    public void setRbStatus(int rbStatus) {
        this.rbStatus = rbStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getModel_no() {
        return model_no;
    }

    public void setModel_no(String model_no) {
        this.model_no = model_no;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
