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
public class DealersBean {
    private String name, mail;
    private int status,txtDealerId,dealerId;
   private String contact,txtUsername,txtPassword,txtConfirmPassword,txtName,txtDob,txtMobile,txtEmail,taAddress,txtPin;
   private int ddlCountry,ddlState,ddlCity;

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public String getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtConfirmPassword(String txtConfirmPassword) {
        this.txtConfirmPassword = txtConfirmPassword;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtDob() {
        return txtDob;
    }

    public void setTxtDob(String txtDob) {
        this.txtDob = txtDob;
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

    public String getTaAddress() {
        return taAddress;
    }

    public void setTaAddress(String taAddress) {
        this.taAddress = taAddress;
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

    public int getTxtDealerId() {
        return txtDealerId;
    }

    public void setTxtDealerId(int txtDealerId) {
        this.txtDealerId = txtDealerId;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
}
