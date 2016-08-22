/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.ShippermasterBean;
import java.util.ArrayList;

/**
 *
 * @author jagvir
 */
public interface ShipperDAO {

    public String addShipper(ShippermasterBean shippermasterBean);

    public ArrayList getAllShipper(String search);
}
