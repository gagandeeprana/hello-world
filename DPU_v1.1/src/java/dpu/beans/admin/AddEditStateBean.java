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
public class AddEditStateBean {

    private int txtCountryId,txtStateId;
    private String txtStateName;

    public int getTxtStateId() {
        return txtStateId;
    }

    public void setTxtStateId(int txtStateId) {
        this.txtStateId = txtStateId;
    }

    public int getTxtCountryId() {
        return txtCountryId;
    }

    public void setTxtCountryId(int txtCountryId) {
        this.txtCountryId = txtCountryId;
    }

    public String getTxtStateName() {
        return txtStateName;
    }

    public void setTxtStateName(String txtStateName) {
        this.txtStateName = txtStateName;
    }

    public int getRbStatus() {
        return rbStatus;
    }

    public void setRbStatus(int rbStatus) {
        this.rbStatus = rbStatus;
    }
    private int rbStatus;

}
