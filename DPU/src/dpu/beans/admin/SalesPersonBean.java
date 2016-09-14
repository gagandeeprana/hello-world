/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gagandeep.rana
 */
@Getter
@Setter
@Entity
@Table(name = "salespersonmaster")
public class SalesPersonBean {

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private int personId;

    @Column(name = "status")
    private int status;
    
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "unit_no")
    private String unitNo;

    @Column(name = "city")
    private String city;

    @Column(name = "present_state")
    private String presentState;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "fax_no")
    private String faxNo;

    @Column(name = "cellular_no")
    private String cellularNo;

    @Column(name = "pager_no")
    private String pagerNo;

    @Column(name = "ext")
    private String ext;

    @Column(name = "sales_person_prefix")
    private String salesPersonPrefix;

    @Column(name = "email")
    private String email;

    @Column(name = "ar_cdn")
    private String arCdn;

    @Column(name = "ar_us")
    private String arUs;

    @Column(name = "base_salary")
    private double baseSalary;

    @Column(name = "paid")
    private int paid;

    @Column(name = "percent_on_applicable_revenue")
    private String percentOnApplicableRevenue;

    @Column(name = "percent_on_gross_profit")
    private String percentOnGrossProfit;

    @Column(name = "max_commission_paid")
    private String maxCommissionPaid;

}
