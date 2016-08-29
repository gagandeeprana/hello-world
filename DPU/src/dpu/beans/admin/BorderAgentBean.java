/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

/**
 *
 * @author Gagandeep
 */
public class BorderAgentBean {

    private int borderAgentId;
    private String code;
    private String borderAgent;
    private String borderCrossing;
    private String phone;
    private String ext;
    private String fax;
    private int status;
    private String email;
    private String openFrom;
    private String openTo;
    private String afterHour;
    private int is24Hr;
    private String comments;
    private int customBrokerId;

    public String getAfterHour() {
        return afterHour;
    }

    public void setAfterHour(String afterHour) {
        this.afterHour = afterHour;
    }

    public int getBorderAgentId() {
        return borderAgentId;
    }

    public void setBorderAgentId(int borderAgentId) {
        this.borderAgentId = borderAgentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBorderAgent() {
        return borderAgent;
    }

    public void setBorderAgent(String borderAgent) {
        this.borderAgent = borderAgent;
    }

    public String getBorderCrossing() {
        return borderCrossing;
    }

    public void setBorderCrossing(String borderCrossing) {
        this.borderCrossing = borderCrossing;
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

    public String getOpenFrom() {
        return openFrom;
    }

    public void setOpenFrom(String openFrom) {
        this.openFrom = openFrom;
    }

    public String getOpenTo() {
        return openTo;
    }

    public void setOpenTo(String openTo) {
        this.openTo = openTo;
    }

    public int getIs24Hr() {
        return is24Hr;
    }

    public void setIs24Hr(int is24Hr) {
        this.is24Hr = is24Hr;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomBrokerId() {
        return customBrokerId;
    }

    public void setCustomBrokerId(int customBrokerId) {
        this.customBrokerId = customBrokerId;
    }

}
