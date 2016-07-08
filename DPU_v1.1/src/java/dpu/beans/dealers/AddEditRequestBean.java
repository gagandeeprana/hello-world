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
public class AddEditRequestBean {
    private String txtUserId;
   private String txtRequestTitle,taDescription;

    public String getTxtUserId() {
        return txtUserId;
    }

    public void setTxtUserId(String txtUserId) {
        this.txtUserId = txtUserId;
    }

    public String getTxtRequestTitle() {
        return txtRequestTitle;
    }

    public void setTxtRequestTitle(String txtRequestTitle) {
        this.txtRequestTitle = txtRequestTitle;
    }

    public String getTaDescription() {
        return taDescription;
    }

    public void setTaDescription(String taDescription) {
        this.taDescription = taDescription;
    }
   
}
