/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.beans.dealers;

/**
 *
 * @author SONY
 */
public class AddEditFeedbackBean {
   private int txtuserId;
   private String taFeedback;

    public String getTaFeedback() {
        return taFeedback;
    }

    public void setTaFeedback(String taFeedback) {
        this.taFeedback = taFeedback;
    }

    public int getTxtuserId() {
        return txtuserId;
    }

    public void setTxtuserId(int txtuserId) {
        this.txtuserId = txtuserId;
    }

   
}
