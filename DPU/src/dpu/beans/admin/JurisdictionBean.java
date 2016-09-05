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
public class JurisdictionBean {

    private int jurisdictionId;
    private String jurisdictionName;
    private String IFAJurisdiction;
    private String countryName;
    private int countryId;
    private double roadTax;

}
