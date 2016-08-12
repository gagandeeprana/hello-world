/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

/**
 *
 * @author gagandeep.rana
 */
public class AdditionalContactBean {

    private int additionalContactId;
    private int contactId;
    private String customerName;
    private String address;
    private String phone;
    private String ext;
    private String fax;
    private String prefix;
    private int provinceState;
    private int status;
    private String email;

    public int getAdditionalContactId() {
        return additionalContactId;
    }

    public void setAdditionalContactId(int additionalContactId) {
        this.additionalContactId = additionalContactId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(int provinceState) {
        this.provinceState = provinceState;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
