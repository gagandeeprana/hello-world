/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Gagandeep
 */
@Getter
@Setter
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
}
