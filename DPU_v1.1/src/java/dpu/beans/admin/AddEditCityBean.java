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
public class AddEditCityBean {

    private String txtCityName,txtCityId;
    private int cityId, stateId,rbStatus;

    public String getTxtCityId() {
        return txtCityId;
    }

    public void setTxtCityId(String txtCityId) {
        this.txtCityId = txtCityId;
    }
    
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getTxtCityName() {
        return txtCityName;
    }

    public void setTxtCityName(String txtCityName) {
        this.txtCityName = txtCityName;
    }

    public int getRbStatus() {
        return rbStatus;
    }

    public void setRbStatus(int rbStatus) {
        this.rbStatus = rbStatus;
    }
}
