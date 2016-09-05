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
public class DriverBean {

    private int driverId;
    private String firstName;
    private String lastName;
    private String defTruck;
    private String address;
    private String homePhone;
    private String cellular;
    private String pager;
    private int status;
    private String lastTrip;
    private Date lastETA;
    private String lastEvent;
    private String lastLocation;
    private String lastCity;
    private String lastState;
    private String faxNo;
    private int divisionId;
    private int terminalId;
    private int categoryId;
    private int classId;
    private String zip;
    private int roleId;

}
