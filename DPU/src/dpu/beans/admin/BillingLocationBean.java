/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Gagandeep
 */
@Getter
@Setter
@Entity
@Table(name = "billinglocationmaster")
public class BillingLocationBean {

    @Id
    @Column(name = "billing_location_id")
    @GeneratedValue
    private int billingLocationId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "unit_no")
    private String unitNo;

    @Column(name = "city")
    private String city;

    @Column(name = "province_state")
    private String provinceState;

    @Column(name = "zip")
    private String zip;

    @Column(name = "ar_cdn")
    private String arCDN;

    @Column(name = "ar_us")
    private String arUS;

    @Column(name = "status")
    private int status;

    @Column(name = "contact")
    private String contact;

    @Column(name = "position")
    private String position;

    @Column(name = "email")
    private String email;

    @Column(name = "cellular")
    private String cellular;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ext")
    private String ext;

    @Column(name = "fax")
    private String fax;

    @Column(name = "billing_prefix")
    private String prefix;

    @Column(name = "tollfree")
    private String tollfree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyBean companyBean;
}
