/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gagandeep.rana
 */
@Getter
@Setter
public class StraightTruckBean {
    
    private int unitNo;
    private String straightTruckClass;
    private String VIN;
    private String make;
    private String model;
    private int year;
    private String plateNo;
    private String jurisdiction;
    private String tareWeight;
    private String rgw;
    private int trackingId;
    private String currentOdometer;
    private Date readingTaken;
    private int createdBy;
    private Date createdOn;
    private String division;
    private int terminalId;
    private int categoryId;
    private String IFTAAccount;
}
