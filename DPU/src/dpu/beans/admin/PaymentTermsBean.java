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
@Table(name = "payment_terms")
public class PaymentTermsBean {

    @Id
    @GeneratedValue
    @Column(name = "term_id")
    private int termId;
    
    @Column(name = "term")
    private String term;
    
    @Column(name = "net_due_in")
    private int netDueIn;
    
    @Column(name = "discount_percent")
    private double discountPercent;
    
    @Column(name = "is_discount_paid")
    private int isDiscountPaid;
    
    @Column(name = "discount_within_days")
    private int discountWithinDays;
    
    @Column(name = "status")
    private int status;
}
