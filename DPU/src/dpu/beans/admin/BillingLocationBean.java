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
public class BillingLocationBean {

    private int billingLocationId;
    private String name;
    private String address;
    private String unitNo;
    private String city;
    private String provinceState;
    private String zip;
    private String arCDN;
    private String arUS;
    private int status;
    private String contact;
    private String position;
    private String email;
    private String cellular;
    private String phone;
    private String ext;
    private String fax;
    private String prefix;
    private String tollfree;
    private int companyId;
}
