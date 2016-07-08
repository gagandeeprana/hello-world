/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.beans.admin;

/**
 *
 * @author SONY
 */
public class PaymentBean {
    private int order_id,order_processed_by,order_dispatched_by;
    private String payment,payment_via,processed_date,dispatch_date,bill_no;
    private double total_charges,shipping_charges;

    public int getOrder_processed_by() {
        return order_processed_by;
    }

    public void setOrder_processed_by(int order_processed_by) {
        this.order_processed_by = order_processed_by;
    }

    public int getOrder_dispatched_by() {
        return order_dispatched_by;
    }

    public void setOrder_dispatched_by(int order_dispatched_by) {
        this.order_dispatched_by = order_dispatched_by;
    }

    public String getProcessed_date() {
        return processed_date;
    }

    public void setProcessed_date(String processed_date) {
        this.processed_date = processed_date;
    }

    public String getDispatch_date() {
        return dispatch_date;
    }

    public void setDispatch_date(String dispatch_date) {
        this.dispatch_date = dispatch_date;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public double getTotal_charges() {
        return total_charges;
    }

    public void setTotal_charges(double total_charges) {
        this.total_charges = total_charges;
    }

    public double getShipping_charges() {
        return shipping_charges;
    }

    public void setShipping_charges(double shipping_charges) {
        this.shipping_charges = shipping_charges;
    }
    

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPayment_via() {
        return payment_via;
    }

    public void setPayment_via(String payment_via) {
        this.payment_via = payment_via;
    }
    
}
