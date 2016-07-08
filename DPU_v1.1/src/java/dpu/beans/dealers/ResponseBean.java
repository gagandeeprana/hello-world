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
public class ResponseBean {
    private int request_id,response_id,userId;
    private String request_title,request_description,request_date,response_description,response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getResponse_id() {
        return response_id;
    }

    public void setResponse_id(int response_id) {
        this.response_id = response_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRequest_description() {
        return request_description;
    }

    public void setRequest_description(String request_description) {
        this.request_description = request_description;
    }

    public String getResponse_description() {
        return response_description;
    }

    public void setResponse_description(String response_description) {
        this.response_description = response_description;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getRequest_title() {
        return request_title;
    }

    public void setRequest_title(String request_title) {
        this.request_title = request_title;
    }

  
    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    
}
