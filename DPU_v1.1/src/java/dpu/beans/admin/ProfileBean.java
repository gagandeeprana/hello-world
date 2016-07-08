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
public class ProfileBean {
    private String txtName,flImage,rbGender,txtDOB,txtPhone,txtMobile,txtEmail,txtChange,txtAddress,txtPin,userId;

    public String getFlImage() {
        return flImage;
    }

    public void setFlImage(String flImage) {
        this.flImage = flImage;
    }
    private int ddlCountry,ddlState,ddlCity;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getRbGender() {
        return rbGender;
    }

    public void setRbGender(String rbGender) {
        this.rbGender = rbGender;
    }

    public String getTxtDOB() {
        return txtDOB;
    }

    public void setTxtDOB(String txtDOB) {
        this.txtDOB = txtDOB;
    }

    public String getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(String txtPhone) {
        this.txtPhone = txtPhone;
    }

    public String getTxtMobile() {
        return txtMobile;
    }

    public void setTxtMobile(String txtMobile) {
        this.txtMobile = txtMobile;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtChange() {
        return txtChange;
    }

    public void setTxtChange(String txtChange) {
        this.txtChange = txtChange;
    }

    public String getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(String txtAddress) {
        this.txtAddress = txtAddress;
    }

    public String getTxtPin() {
        return txtPin;
    }

    public void setTxtPin(String txtPin) {
        this.txtPin = txtPin;
    }

    public int getDdlCountry() {
        return ddlCountry;
    }

    public void setDdlCountry(int ddlCountry) {
        this.ddlCountry = ddlCountry;
    }

    public int getDdlState() {
        return ddlState;
    }

    public void setDdlState(int ddlState) {
        this.ddlState = ddlState;
    }

    public int getDdlCity() {
        return ddlCity;
    }

    public void setDdlCity(int ddlCity) {
        this.ddlCity = ddlCity;
    }
    
}
