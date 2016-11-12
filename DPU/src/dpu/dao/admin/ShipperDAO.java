/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.AdditionalShippperContactBean;
import dpu.beans.admin.ShippermasterBean;
import dpu.beans.admin.WorkingHoursAdditionalShipperBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jagvir
 */
public interface ShipperDAO {

     public String addShipper(ShippermasterBean shippermasterBean);

    public ArrayList getAllShipper(String search);

    public ShippermasterBean getShipperInfoById(int shipperId);

    public String updateShipper(ShippermasterBean shippermasterBean);

    public String deleteShipper(int shipperId);

    public int getMaxShipperId();

    public String addShippingHours(List<WorkingHoursAdditionalShipperBean> lstReceivingHours, List<WorkingHoursAdditionalShipperBean> lstShippingHours);

    public List<WorkingHoursAdditionalShipperBean> getRecevingHoursByShipperId(int shipperId);

    public List<WorkingHoursAdditionalShipperBean> getShippingHoursByShipperId(int shipperId);

    public String updateShippingHours(List<WorkingHoursAdditionalShipperBean> lstReceivingHours, List<WorkingHoursAdditionalShipperBean> lstShippingHours);

    public String addAdditionalContact(AdditionalShippperContactBean additionalShippperContactBean);

    public List<AdditionalShippperContactBean> getAllShipperContactsByShipperId(int shipperId);
    
    public String updateAdditionalContact(AdditionalShippperContactBean additionalShippperContactBean);
    
    public String deleteContact(int contactId);
        
}
