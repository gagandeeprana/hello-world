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
public class AddEditCountryBean {
    private int txtCountryId;

    public int getTxtCountryId() {
        return txtCountryId;
    }

    public void setTxtCountryId(int txtCountryId) {
        this.txtCountryId = txtCountryId;
    }
    public String txtCountryName,rbStatus;

    public String getTxtCountryName() {
        return txtCountryName;
    }

    public void setTxtCountryName(String txtCountryName) {
        this.txtCountryName = txtCountryName;
    }

    public String getRbStatus() {
        return rbStatus;
    }

    public void setRbStatus(String rbStatus) {
        this.rbStatus = rbStatus;
    }
    
}
