/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gagandeep.rana
 */
@Getter
@Setter
public class AdditionalContactBean {

    private int additionalContactId;
    private int contactId;
    private String customerName;
    private String position;
    private String phone;
    private String ext;
    private String fax;
    private String prefix;
    private String cellular;
    private int status;
    private String email;
    Map<Integer, List<WorkingHoursAdditionalContactBean>> map = new HashMap<>();
}
