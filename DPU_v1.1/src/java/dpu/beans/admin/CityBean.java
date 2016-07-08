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
public class CityBean {
     private int status,cityId;
    private String name,txtCityId,txtCityName;

    public String getTxtCityName() {
        return txtCityName;
    }

    public void setTxtCityName(String txtCityName) {
        this.txtCityName = txtCityName;
    }

    public String getTxtCityId() {
        return txtCityId;
    }

    public void setTxtCityId(String txtCityId) {
        this.txtCityId = txtCityId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int CityId) {
        this.cityId = CityId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
