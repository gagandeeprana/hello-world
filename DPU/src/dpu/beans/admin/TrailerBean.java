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
public class TrailerBean {

    private int trailerId;
    private int classId;
    private int equipmentId;
    private int length;
    private String VIN;
    private String make;
    private String model;
    private int year;
    private String plateNo;
    private String jurisdiction;
    private String tareWeight;
    private String rgw;
    private String currentOdometer;
    private Date readingTakenDate;
    private int createdBy;
    private Date createdOn;
}
