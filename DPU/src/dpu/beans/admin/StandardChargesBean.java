/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

/**
 *
 * @author gagandeep.rana
 */
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

    public int getStandardChargesId() {
        return standardChargesId;
    }

    public void setStandardChargesId(int standardChargesId) {
        this.standardChargesId = standardChargesId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getChargeType1() {
        return chargeType1;
    }

    public void setChargeType1(int chargeType1) {
        this.chargeType1 = chargeType1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountAs() {
        return amountAs;
    }

    public void setAmountAs(int amountAs) {
        this.amountAs = amountAs;
    }

    public String getBaseCharge() {
        return baseCharge;
    }

    public void setBaseCharge(String baseCharge) {
        this.baseCharge = baseCharge;
    }

    public String getMaxCharge() {
        return maxCharge;
    }

    public void setMaxCharge(String maxCharge) {
        this.maxCharge = maxCharge;
    }

    public int getChargeType2() {
        return chargeType2;
    }

    public void setChargeType2(int chargeType2) {
        this.chargeType2 = chargeType2;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIncludeChargeAmount() {
        return includeChargeAmount;
    }

    public void setIncludeChargeAmount(int includeChargeAmount) {
        this.includeChargeAmount = includeChargeAmount;
    }

    public int getCalculateFuelSurcharge() {
        return calculateFuelSurcharge;
    }

    public void setCalculateFuelSurcharge(int calculateFuelSurcharge) {
        this.calculateFuelSurcharge = calculateFuelSurcharge;
    }

    public int getIncludeDriverPayroll() {
        return includeDriverPayroll;
    }

    public void setIncludeDriverPayroll(int includeDriverPayroll) {
        this.includeDriverPayroll = includeDriverPayroll;
    }
}
