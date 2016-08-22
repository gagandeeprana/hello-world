/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.ShippermasterBean;
import dpu.dao.admin.ShipperDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jagvir
 */
public class ShipperDAOImpl implements ShipperDAO {

    ConnectDB connectDB = ConnectDB.getInstance();

    @Override
    public String addShipper(ShippermasterBean shippermasterBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into shippermaster values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, shippermasterBean.getShipperId());
            pstmt.setString(2, shippermasterBean.getCompany());
            pstmt.setString(3, shippermasterBean.getAddress());
            pstmt.setString(4, shippermasterBean.getUnit());
            pstmt.setString(5, shippermasterBean.getCity());
            pstmt.setString(6, shippermasterBean.getProvinceState());
            pstmt.setString(7, shippermasterBean.getPostalZip());
            pstmt.setString(8, shippermasterBean.getZone());
            pstmt.setInt(9, shippermasterBean.getStatus());
            pstmt.setString(10, shippermasterBean.getLeadTime());
            pstmt.setString(11, shippermasterBean.getTimeZone());
            pstmt.setString(12, shippermasterBean.getInternalNotes());
            pstmt.setString(13, shippermasterBean.getContact());
            pstmt.setString(14, shippermasterBean.getPosition());
            pstmt.setString(15, shippermasterBean.getPhone());
            pstmt.setString(16, shippermasterBean.getFax());
            pstmt.setString(17, shippermasterBean.getTollFree());
            pstmt.setString(18, shippermasterBean.getExt());
            pstmt.setString(19, shippermasterBean.getPrefix());
            pstmt.setString(20, shippermasterBean.getPlant());
            pstmt.setString(21, shippermasterBean.getEmail());
            pstmt.setString(22, shippermasterBean.getImporter());
            pstmt.setString(23, shippermasterBean.getStandardNotes());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Shipper Added";
            }
        } catch (Exception e) {
            System.out.println("in addShipper " + e);
        }
        return "Failed To Add Shipper";
    }

    @Override
    public ArrayList getAllShipper(String search) {
        ArrayList arrayList = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from shippermaster where address like ?");
            pstmt.setString(1, "%" + search + "%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ShippermasterBean shippermasterBean = new ShippermasterBean();
                shippermasterBean.setAddress(resultSet.getString("address"));
                shippermasterBean.setCity(resultSet.getString("city"));
                shippermasterBean.setCompany(resultSet.getString("company"));
                shippermasterBean.setContact(resultSet.getString("contact"));
                shippermasterBean.setEmail(resultSet.getString("email"));
                shippermasterBean.setExt(resultSet.getString("ext"));
                shippermasterBean.setFax(resultSet.getString("fax"));
                shippermasterBean.setImporter(resultSet.getString("importer"));
                shippermasterBean.setInternalNotes(resultSet.getString("internam_notes"));
                shippermasterBean.setLeadTime(resultSet.getString("lead_time"));
                shippermasterBean.setPhone(resultSet.getString("phone"));
                shippermasterBean.setPlant(resultSet.getString("plant"));
                shippermasterBean.setPosition(resultSet.getString("position"));
                shippermasterBean.setPostalZip(resultSet.getString("postal_zip"));
                shippermasterBean.setPrefix(resultSet.getString("prefix"));
                shippermasterBean.setProvinceState(resultSet.getString("prov_state"));
                shippermasterBean.setStandardNotes(resultSet.getString("standard_notes"));
                shippermasterBean.setStatus(resultSet.getInt("status"));
                shippermasterBean.setShipperId(resultSet.getInt("shipper_id"));
                shippermasterBean.setTimeZone(resultSet.getString("time_zone"));
                shippermasterBean.setTollFree(resultSet.getString("toll_free"));
                shippermasterBean.setUnit(resultSet.getString("unit"));
                shippermasterBean.setZone(resultSet.getString("zone"));
                arrayList.add(shippermasterBean);
            }
        } catch (Exception e) {
            System.out.println("in getAllShipper  " + e);
        }
        return arrayList;
    }

}
