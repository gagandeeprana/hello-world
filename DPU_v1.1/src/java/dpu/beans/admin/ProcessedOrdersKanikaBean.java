/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.beans.admin;

/**
 *
 * @author sikka
 */
public class ProcessedOrdersKanikaBean {
     private String order_title,processed_date,dispatch_date;
     private int order_dispatched_by,order_id,bill_no;
private double amount;

    public int getBill_no() {
        return bill_no;
    }

    public void setBill_no(int bill_no) {
        this.bill_no = bill_no;
    }

    public int getOrder_dispatched_by() {
        return order_dispatched_by;
    }

    public void setOrder_dispatched_by(int order_dispatched_by) {
        this.order_dispatched_by = order_dispatched_by;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
