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
public class CustomBrokerBean {

    private int customBrokerId;
    private String customBroker;
    private String contactName;
    private String phone;
    private String ext;
    private String faxNo;
    private int status;
    private String email;
    private String website;
}
