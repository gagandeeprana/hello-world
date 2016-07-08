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
public class DispatchBean {
    private String name,contact,email,order_title,address;
            private double shipping_charges,total_charges,amount;
            private int bill_no; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getShipping_charges() {
        return shipping_charges;
    }

    public void setShipping_charges(double shipping_charges) {
        this.shipping_charges = shipping_charges;
    }

    public double getTotal_charges() {
        return total_charges;
    }

    public void setTotal_charges(double total_charges) {
        this.total_charges = total_charges;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBill_no() {
        return bill_no;
    }

    public void setBill_no(int bill_no) {
        this.bill_no = bill_no;
    }
            
            
}
