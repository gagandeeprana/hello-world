/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.beans.dealers;

import java.util.List;

/**
 *
 * @author SONY
 */
public class OrderBean {
    private int order_id,dealer_id,is_cancelled,is_payment_done;
    double totalAmount;

    private List<OrderItembean> lstItems;

    public List<OrderItembean> getLstItems() {
        return lstItems;
    }

    public void setLstItems(List<OrderItembean> lstItems) {
        this.lstItems = lstItems;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    private String order_title,order_date,order_status,last_update_date,links;

    public int getIs_cancelled() {
        return is_cancelled;
    }

    public void setIs_cancelled(int is_cancelled) {
        this.is_cancelled = is_cancelled;
    }

    public int getIs_payment_done() {
        return is_payment_done;
    }

    public void setIs_payment_done(int is_payment_done) {
        this.is_payment_done = is_payment_done;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(int dealer_id) {
        this.dealer_id = dealer_id;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

   

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }

    
}
