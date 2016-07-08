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
public class AddEditProductBean {
   private String txtProductTitle,txtProductCode,txtModelNo,txtCompany,txtPrice,taDescription,txtProductId;
   private int rbStatus,ddlCategory;

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

    public int getRbStatus() {
        return rbStatus;
    }

    public void setRbStatus(int rbStatus) {
        this.rbStatus = rbStatus;
    }

    public int getDdlCategory() {
        return ddlCategory;
    }

    public void setDdlCategory(int ddlCategory) {
        this.ddlCategory = ddlCategory;
    }
   
}
