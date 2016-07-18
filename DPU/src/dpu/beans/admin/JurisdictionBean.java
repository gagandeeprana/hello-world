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
public class JurisdictionBean {

    private int jurisdictionId;
    private String jurisdictionName;
    private String IFAJurisdiction;
    private String countryName;
    private int countryId;
    private double roadTax;

    public int getJurisdictionId() {
        return jurisdictionId;
    }

    public void setJurisdictionId(int jurisdictionId) {
        this.jurisdictionId = jurisdictionId;
    }

    public String getJurisdictionName() {
        return jurisdictionName;
    }

    public void setJurisdictionName(String jurisdictionName) {
        this.jurisdictionName = jurisdictionName;
    }

    public String getIFAJurisdiction() {
        return IFAJurisdiction;
    }

    public void setIFAJurisdiction(String IFAJurisdiction) {
        this.IFAJurisdiction = IFAJurisdiction;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public double getRoadTax() {
        return roadTax;
    }

    public void setRoadTax(double roadTax) {
        this.roadTax = roadTax;
    }
}
