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
public class ProductCategoryBean {
     private int categoryId,status,txtcategoryId;
     private double vat,charges,txtVat,txtShippingCharges ;
     private String title,description,txtTitle,taDescription;

    public double getTxtVat() {
        return txtVat;
    }

    public void setTxtVat(double txtVat) {
        this.txtVat = txtVat;
    }

    public double getTxtShippingCharges() {
        return txtShippingCharges;
    }

    public void setTxtShippingCharges(double txtShippingCharges) {
        this.txtShippingCharges = txtShippingCharges;
    }

    public int getTxtcategoryId() {
        return txtcategoryId;
    }

    public void setTxtcategoryId(int txtcategoryId) {
        this.txtcategoryId = txtcategoryId;
    }

   

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTaDescription() {
        return taDescription;
    }

    public void setTaDescription(String taDescription) {
        this.taDescription = taDescription;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     
}
