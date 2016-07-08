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
public class AddEditFaqBean {
    public String txtFAQ,txtAnswer,taFAQ,taAnswer;
    public int faqId;

    public String getTaFAQ() {
        return taFAQ;
    }

    public void setTaFAQ(String taFAQ) {
        this.taFAQ = taFAQ;
    }

    public String getTaAnswer() {
        return taAnswer;
    }

    public void setTaAnswer(String taAnswer) {
        this.taAnswer = taAnswer;
    }

    public int getFaqId() {
        return faqId;
    }

    public void setFaqId(int faqId) {
        this.faqId = faqId;
    }

    public String getTxtFAQ() {
        return txtFAQ;
    }

    public void setTxtFAQ(String txtFAQ) {
        this.txtFAQ = txtFAQ;
    }

    public String getTxtAnswer() {
        return txtAnswer;
    }

    public void setTxtAnswer(String txtAnswer) {
        this.txtAnswer = txtAnswer;
    }
    
}
