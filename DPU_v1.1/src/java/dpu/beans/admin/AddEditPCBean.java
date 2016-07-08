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
public class AddEditPCBean {
    private String taDescription,txtTitle,txtVat,txtShippingCharges;
    private int rbStatus,txtcategoryId;

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

    public String getTxtVat() {
        return txtVat;
    }

    public void setTxtVat(String txtVat) {
        this.txtVat = txtVat;
    }

    public String getTxtShippingCharges() {
        return txtShippingCharges;
    }

    public void setTxtShippingCharges(String txtShippingCharges) {
        this.txtShippingCharges = txtShippingCharges;
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
    
}
