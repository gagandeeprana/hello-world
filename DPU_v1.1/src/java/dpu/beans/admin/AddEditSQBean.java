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
public class AddEditSQBean {

    public String taQuestion;
    public int rbStatus, txtSecurityId;

    public int getTxtSecurityId() {
        return txtSecurityId;
    }

    public void setTxtSecurityId(int txtSecurityId) {
        this.txtSecurityId = txtSecurityId;
    }

    public String getTaQuestion() {
        return taQuestion;
    }

    public void setTaQuestion(String taQuestion) {
        this.taQuestion = taQuestion;
    }

    public int getRbStatus() {
        return rbStatus;
    }

    public void setRbStatus(int rbStatus) {
        this.rbStatus = rbStatus;
    }

}
