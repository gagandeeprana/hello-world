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
@Table(name = "standard_charges")
public class StandardChargesBean {

    @Id
    @Column(name = "standard_charges_id")
    @GeneratedValue
    private int standardChargesId;

    @Column(name = "code")
    private String code;

    @Column(name = "charge_type1")
    private int chargeType1;

    @Column(name = "description")
    private String description;

    @Column(name = "amount_as")
    private int amountAs;

    @Column(name = "base_charge")
    private String baseCharge;

    @Column(name = "max_charge")
    private String maxCharge;

    @Column(name = "charge_type2")
    private int chargeType2;

    @Column(name = "status")
    private int status;

    @Column(name = "include_charge_amount")
    private int includeChargeAmount;

    @Column(name = "calculate_fuel_surcharge")
    private int calculateFuelSurcharge;

    @Column(name = "include_driver_payroll")
    private int includeDriverPayroll;
}
