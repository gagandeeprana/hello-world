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
 * @author gagandeep.rana
 */
@Getter
@Setter
public class StandardChargesBean {

    private int standardChargesId;
    private String code;
    private int chargeType1;
    private String description;
    private int amountAs;
    private String baseCharge;
    private String maxCharge;
    private int chargeType2;
    private int status;
    private int includeChargeAmount;
    private int calculateFuelSurcharge;
    private int includeDriverPayroll;
}
