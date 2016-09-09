/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gagandeep.rana
 */
@Getter
@Setter
@Entity
@Table(name = "additionalcontactmaster")
public class AdditionalContactBean {

    @Id
    @Column(name = "add_contact_id")
    @GeneratedValue
    private int additionalContactId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ext")
    private String ext;

    @Column(name = "fax")
    private String fax;

    @Column(name = "additional_contact_prefix")
    private String prefix;

    @Column(name = "cellular")
    private String cellular;

    @Column(name = "status")
    private int status;

    @Column(name = "email")
    private String email;

    @Transient
    private Map<Integer, List<WorkingHoursAdditionalContactBean>> map = new HashMap<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyBean companyBean;
}
