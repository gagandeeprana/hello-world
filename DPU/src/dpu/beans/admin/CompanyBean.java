package dpu.beans.admin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CompanyBean {

    private int companyId;
    private String companyName;
    private String address;
    private String unitNo;
    private String city;
    private String provinceState;
    private String zip;
    private String email;
    private String website;
    private String contact;
    private String position;
    private String phone;
    private String ext;
    private String fax;
    private String prefix;
    private String tollfree;
    private String cellular;
    private String pager;
    private String notes;
    private String afterHours;

}
