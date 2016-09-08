/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.AdditionalShippperContactBean;
import dpu.beans.admin.ShippermasterBean;
import dpu.beans.admin.WorkingHoursAdditionalShipperBean;
import dpu.dao.admin.ShipperDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            pstmt = conn.prepareStatement("insert into shippermaster(company,address,unit,city,prov_state,postal_zip,zone,status,lead_time,time_zone,internam_notes,"
                    + "contact,position,phone,fax,toll_free,ext,prefix,plant,email,importer,standard_notes,direction,date_stamp,report,report_name,cell_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//            pstmt.setInt(1, shippermasterBean.getShipperId());
            System.out.println("query::" + pstmt.toString());
            pstmt.setString(1, shippermasterBean.getCompany());
            pstmt.setString(2, shippermasterBean.getAddress());
            pstmt.setString(3, shippermasterBean.getUnit());
            pstmt.setString(4, shippermasterBean.getCity());
            pstmt.setString(5, shippermasterBean.getProvinceState());
            pstmt.setString(6, shippermasterBean.getPostalZip());
            pstmt.setString(7, shippermasterBean.getZone());
            pstmt.setInt(8, shippermasterBean.getStatus());
            pstmt.setString(9, shippermasterBean.getLeadTime());
            pstmt.setString(10, shippermasterBean.getTimeZone());
            pstmt.setString(11, shippermasterBean.getInternalNotes());
            pstmt.setString(12, shippermasterBean.getContact());
            pstmt.setString(13, shippermasterBean.getPosition());
            pstmt.setString(14, shippermasterBean.getPhone());
            pstmt.setString(15, shippermasterBean.getFax());
            pstmt.setString(16, shippermasterBean.getTollFree());
            pstmt.setString(17, shippermasterBean.getExt());
            pstmt.setString(18, shippermasterBean.getPrefix());
            pstmt.setString(19, shippermasterBean.getPlant());
            pstmt.setString(20, shippermasterBean.getEmail());
            pstmt.setString(21, shippermasterBean.getImporter());
            pstmt.setString(22, shippermasterBean.getStandardNotes());
            pstmt.setString(23, shippermasterBean.getDirections());
            pstmt.setString(24, shippermasterBean.getDateStamp());
            pstmt.setString(25, shippermasterBean.getReport());
            pstmt.setString(26, shippermasterBean.getReportName());
            pstmt.setString(27, shippermasterBean.getCellNumber());
            System.out.println("query:::" + pstmt.toString());
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
                shippermasterBean.setDirections(resultSet.getString("direction"));
                shippermasterBean.setZone(resultSet.getString("zone"));
                shippermasterBean.setDateStamp(resultSet.getString("date_stamp"));
                arrayList.add(shippermasterBean);
            }
        } catch (Exception e) {
            System.out.println("in getAllShipper  " + e);
        }
        return arrayList;
    }

    @Override
    public ShippermasterBean getShipperInfoById(int shipperId) {
        ShippermasterBean shippermasterBean = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            pstmt = conn.prepareStatement("select * from shippermaster where shipper_id=?");
            pstmt.setInt(1, shipperId);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                shippermasterBean = new ShippermasterBean();
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
            }
        } catch (Exception e) {
            System.out.println("in getShipperInfoById " + e);
        }
        return shippermasterBean;
    }

    @Override
    public String updateShipper(ShippermasterBean shippermasterBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update shippermaster set conpany=?,address=?,unit=?,city=?,prov_state=?,postal_zip=?,zone=?,status=?,lead_time=?,time_zone=?"
                    + "internam_notes=?,contact=?,position=?,phone=?,fax=?,toll_free=?,ext=?,prefix=?,plant=?,email=?,iporter=?,standard_notes=? where shipper_id=?");
            pstmt.setString(1, shippermasterBean.getCompany());
            pstmt.setString(2, shippermasterBean.getAddress());
            pstmt.setString(3, shippermasterBean.getUnit());
            pstmt.setString(4, shippermasterBean.getCity());
            pstmt.setString(5, shippermasterBean.getProvinceState());
            pstmt.setString(6, shippermasterBean.getPostalZip());
            pstmt.setString(7, shippermasterBean.getZone());
            pstmt.setInt(8, shippermasterBean.getStatus());
            pstmt.setString(9, shippermasterBean.getLeadTime());
            pstmt.setString(10, shippermasterBean.getTimeZone());
            pstmt.setString(11, shippermasterBean.getInternalNotes());
            pstmt.setString(12, shippermasterBean.getContact());
            pstmt.setString(13, shippermasterBean.getPosition());
            pstmt.setString(14, shippermasterBean.getPhone());
            pstmt.setString(15, shippermasterBean.getFax());
            pstmt.setString(16, shippermasterBean.getTollFree());
            pstmt.setString(17, shippermasterBean.getExt());
            pstmt.setString(18, shippermasterBean.getPrefix());
            pstmt.setString(19, shippermasterBean.getPlant());
            pstmt.setString(20, shippermasterBean.getEmail());
            pstmt.setString(21, shippermasterBean.getImporter());
            pstmt.setString(22, shippermasterBean.getStandardNotes());
            pstmt.setInt(23, shippermasterBean.getShipperId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Shipper Updated";
            }
        } catch (Exception e) {
            System.out.println("in updateShipper " + e);
        }
        return "Failed To Update Shipper";
    }

    @Override
    public String deleteShipper(int shipperId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from shippermaster where shipper_id=?");
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Shipper Deleted Successfully";
            }
        } catch (Exception e) {
            System.out.println("in delereShipper  " + e);
        }
        return "Failed To Delete Shipper ";
    }

    @Override
    public int getMaxShipperId() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select max(shipper_id) from shippermaster");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("in getMaxShipperId : " + e);
        }
        return 0;
    }

    @Override
    public String addShippingHours(List<WorkingHoursAdditionalShipperBean> lstReceivingHours, List<WorkingHoursAdditionalShipperBean> lstShippingHours) {
        System.out.println("lstReceiving:::" + lstReceivingHours.size());
        System.out.println("lstShipping:::" + lstShippingHours.size());
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean flag = false;
        try {
            conn = connectDB.connect();
            if (lstReceivingHours != null || lstReceivingHours.size() != 0) {
                for (WorkingHoursAdditionalShipperBean workingHoursAdditionalShipperBean : lstReceivingHours) {
                    flag = false;
                    pstmt = conn.prepareStatement("insert into working_hours_additionalshipper(working_day,open1,open2,close1,close2,is24Hr,additional_shipper_id,type) values(?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, workingHoursAdditionalShipperBean.getWorkingDay());
                    pstmt.setString(2, workingHoursAdditionalShipperBean.getOpen1());
                    pstmt.setString(3, workingHoursAdditionalShipperBean.getOpen2());
                    pstmt.setString(4, workingHoursAdditionalShipperBean.getClose1());
                    pstmt.setString(5, workingHoursAdditionalShipperBean.getClose2());
                    pstmt.setInt(6, workingHoursAdditionalShipperBean.getIs24Hrs());
                    pstmt.setInt(7, getMaxShipperId());
                    pstmt.setString(8, workingHoursAdditionalShipperBean.getType());
                    int i = pstmt.executeUpdate();
                    if (i > 0) {
                        flag = true;
                    }
                }
            } else {
                System.out.println("listReceivingHours Empty");
            }
            if (lstShippingHours != null || lstShippingHours.size() != 0) {
                for (WorkingHoursAdditionalShipperBean workingHoursAdditionalShipperBean : lstShippingHours) {
                    flag = false;
                    pstmt = conn.prepareStatement("insert into working_hours_additionalshipper(working_day,open1,open2,close1,close2, is24Hr,additional_shipper_id,type) values(?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, workingHoursAdditionalShipperBean.getWorkingDay());
                    pstmt.setString(2, workingHoursAdditionalShipperBean.getOpen1());
                    pstmt.setString(3, workingHoursAdditionalShipperBean.getOpen2());
                    pstmt.setString(4, workingHoursAdditionalShipperBean.getClose1());
                    pstmt.setString(5, workingHoursAdditionalShipperBean.getClose2());
                    pstmt.setInt(6, workingHoursAdditionalShipperBean.getIs24Hrs());
                    pstmt.setInt(7, getMaxShipperId());
                    pstmt.setString(8, workingHoursAdditionalShipperBean.getType());
                    int i = pstmt.executeUpdate();
                    if (i > 0) {
                        flag = true;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("in addShippingHours()  " + e);
        }
        if (flag == true) {
            return "ShippingHours Added Successfully";
        } else {
            return "Failed To Add ShippingHours";
        }
    }

    @Override
    public List<WorkingHoursAdditionalShipperBean> getRecevingHoursByShipperId(int shipperId) {

        List<WorkingHoursAdditionalShipperBean> lstReceivingHours = new ArrayList();
        WorkingHoursAdditionalShipperBean workingHoursAdditionalShipperBean = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from working_hours_additionalshipper where type='receiving' and additional_shipper_id=?");
            pstmt.setInt(1, shipperId);
            rs = pstmt.executeQuery();
            System.out.println("query:::" + pstmt.toString());
            while (rs.next()) {
                workingHoursAdditionalShipperBean = new WorkingHoursAdditionalShipperBean();
                workingHoursAdditionalShipperBean.setOpen1(rs.getString("open1"));
                workingHoursAdditionalShipperBean.setOpen2(rs.getString("open2"));
                workingHoursAdditionalShipperBean.setClose1(rs.getString("close1"));
                workingHoursAdditionalShipperBean.setClose2(rs.getString("close2"));
                workingHoursAdditionalShipperBean.setType(rs.getString("type"));
                workingHoursAdditionalShipperBean.setWorkingDay(rs.getString("working_day"));
                workingHoursAdditionalShipperBean.setIs24Hrs(rs.getInt("is24Hr"));
                workingHoursAdditionalShipperBean.setWorkingId(rs.getInt("working_id"));
                lstReceivingHours.add(workingHoursAdditionalShipperBean);

            }
        } catch (Exception e) {
            System.out.println("in getRecevingHoursByShipperId() " + e);
        }
        return lstReceivingHours;
    }

    @Override
    public List<WorkingHoursAdditionalShipperBean> getShippingHoursByShipperId(int shipperId) {
        List<WorkingHoursAdditionalShipperBean> lstShippingHours = new ArrayList();
        WorkingHoursAdditionalShipperBean workingHoursAdditionalShipperBean = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from working_hours_additionalshipper where type='shipping' and additional_shipper_id=?");
            pstmt.setInt(1, shipperId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                workingHoursAdditionalShipperBean = new WorkingHoursAdditionalShipperBean();
                workingHoursAdditionalShipperBean.setOpen1(rs.getString("open1"));
                workingHoursAdditionalShipperBean.setOpen2(rs.getString("open2"));
                workingHoursAdditionalShipperBean.setClose1(rs.getString("close1"));
                workingHoursAdditionalShipperBean.setClose2(rs.getString("close2"));
                workingHoursAdditionalShipperBean.setType(rs.getString("type"));
                workingHoursAdditionalShipperBean.setWorkingDay(rs.getString("working_day"));
                workingHoursAdditionalShipperBean.setIs24Hrs(rs.getInt("is24Hr"));
                workingHoursAdditionalShipperBean.setWorkingId(rs.getInt("working_id"));
                lstShippingHours.add(workingHoursAdditionalShipperBean);

            }
        } catch (Exception e) {
            System.out.println("in getShippingHoursByShipperId() " + e);
        }
        return lstShippingHours;
    }

    @Override
    public String updateShippingHours(List<WorkingHoursAdditionalShipperBean> lstReceivingHours, List<WorkingHoursAdditionalShipperBean> lstShippingHours) {
        System.out.println("lstReceiving:::" + lstReceivingHours.size());
        System.out.println("lstShipping:::" + lstShippingHours.size());
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean flag = false;
        try {
            conn = connectDB.connect();
            if (lstReceivingHours != null || lstReceivingHours.size() != 0) {
                for (WorkingHoursAdditionalShipperBean workingHoursAdditionalShipperBean : lstReceivingHours) {
                    flag = false;
                    pstmt = conn.prepareStatement("update working_hours_additionalshipper set working_day=?,open1=?,open2=?,close1=?,close2=?,is24Hr=?,additional_shipper_id=?,type=? where working_id=?");
                    pstmt.setString(1, workingHoursAdditionalShipperBean.getWorkingDay());
                    pstmt.setString(2, workingHoursAdditionalShipperBean.getOpen1());
                    pstmt.setString(3, workingHoursAdditionalShipperBean.getOpen2());
                    pstmt.setString(4, workingHoursAdditionalShipperBean.getClose1());
                    pstmt.setString(5, workingHoursAdditionalShipperBean.getClose2());
                    pstmt.setInt(6, workingHoursAdditionalShipperBean.getIs24Hrs());
                    pstmt.setInt(7, workingHoursAdditionalShipperBean.getAdditionalShipperId());
                    pstmt.setString(8, workingHoursAdditionalShipperBean.getType());
                    pstmt.setInt(1, workingHoursAdditionalShipperBean.getWorkingId());
                    int i = pstmt.executeUpdate();
                    if (i > 0) {
                        flag = true;
                    }
                }
            } else {
                System.out.println("listReceivingHours Empty");
            }
            if (lstShippingHours != null || lstShippingHours.size() != 0) {
                for (WorkingHoursAdditionalShipperBean workingHoursAdditionalShipperBean : lstShippingHours) {
                    flag = false;
                    pstmt = conn.prepareStatement("insert into working_hours_additionalshipper(working_day,open1,open2,close1,close2, is24Hr,additional_shipper_id,type) values(?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, workingHoursAdditionalShipperBean.getWorkingDay());
                    pstmt.setString(2, workingHoursAdditionalShipperBean.getOpen1());
                    pstmt.setString(3, workingHoursAdditionalShipperBean.getOpen2());
                    pstmt.setString(4, workingHoursAdditionalShipperBean.getClose1());
                    pstmt.setString(5, workingHoursAdditionalShipperBean.getClose2());
                    pstmt.setInt(6, workingHoursAdditionalShipperBean.getIs24Hrs());
                    pstmt.setInt(7, getMaxShipperId());
                    pstmt.setString(8, workingHoursAdditionalShipperBean.getType());
                    int i = pstmt.executeUpdate();
                    if (i > 0) {
                        flag = true;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("in addShippingHours()  " + e);
        }
        if (flag == true) {
            return "ShippingHours Added Successfully";
        } else {
            return "Failed To Add ShippingHours";
        }
    }

    @Override
    public String addAdditionalContact(AdditionalShippperContactBean additionalShippperContactBean) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into additionalcontactforshipper"
                    + "(contactname,position,phone,fax,cellular,email,ext,prefix,status,shipperid) values(?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, additionalShippperContactBean.getContactName());
            pstmt.setString(2, additionalShippperContactBean.getPosition());
            pstmt.setString(3, additionalShippperContactBean.getPhone());
            pstmt.setString(4, additionalShippperContactBean.getFax());
            pstmt.setString(5, additionalShippperContactBean.getCellular());
            pstmt.setString(6, additionalShippperContactBean.getEmail());
            pstmt.setString(7, additionalShippperContactBean.getExt());
            pstmt.setString(8, additionalShippperContactBean.getPrefix());
            pstmt.setInt(9, additionalShippperContactBean.getStatus());
            pstmt.setInt(10, getMaxShipperId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "AdditionalContact Added Successfully";
            }
        } catch (Exception e) {
            System.out.println("in addAdditionalContact  " + e);
        }
        return "Failed To Added AdditionalContact";
    }

    public List<AdditionalShippperContactBean> getAllShipperContacts() {
        List<AdditionalShippperContactBean> lstContacts = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        AdditionalShippperContactBean additionalShippperContactBean = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from additionalcontactforshipper");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                additionalShippperContactBean = new AdditionalShippperContactBean();
                additionalShippperContactBean.setCellular(rs.getString("cellular"));
                additionalShippperContactBean.setContactName(rs.getString("contactname"));
                additionalShippperContactBean.setEmail(rs.getString("email"));
                additionalShippperContactBean.setExt(rs.getString("ext"));
                additionalShippperContactBean.setFax(rs.getString("fax"));
                additionalShippperContactBean.setPhone(rs.getString("phone"));
                additionalShippperContactBean.setPosition(rs.getString("position"));
                additionalShippperContactBean.setPrefix(rs.getString("prefix"));
                additionalShippperContactBean.setContactId(rs.getInt("contactid"));
                additionalShippperContactBean.setShipperId(rs.getInt("shipperid"));
                additionalShippperContactBean.setStatus(rs.getInt("status"));
                lstContacts.add(additionalShippperContactBean);
            }
        } catch (Exception e) {
            System.out.println("in getAllShipperContacts::" + e);
        }
        return lstContacts;
    }

    @Override
    public List<AdditionalShippperContactBean> getAllShipperContactsByShipperId(int shipperId) {
        List<AdditionalShippperContactBean> lstContacts = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        AdditionalShippperContactBean additionalShippperContactBean = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from additionalcontactforshipper where shipperid=?");
            pstmt.setInt(1, shipperId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                additionalShippperContactBean = new AdditionalShippperContactBean();
                additionalShippperContactBean.setCellular(rs.getString("cellular"));
                additionalShippperContactBean.setContactName(rs.getString("contactname"));
                additionalShippperContactBean.setEmail(rs.getString("email"));
                additionalShippperContactBean.setExt(rs.getString("ext"));
                additionalShippperContactBean.setFax(rs.getString("fax"));
                additionalShippperContactBean.setPhone(rs.getString("phone"));
                additionalShippperContactBean.setPosition(rs.getString("position"));
                additionalShippperContactBean.setPrefix(rs.getString("prefix"));
                additionalShippperContactBean.setContactId(rs.getInt("contactid"));
                additionalShippperContactBean.setShipperId(rs.getInt("shipperid"));
                additionalShippperContactBean.setStatus(rs.getInt("status"));
                lstContacts.add(additionalShippperContactBean);
            }
        } catch (Exception e) {
            System.out.println("in getAllShipperContactsByShipperId::" + e);
        }
        return lstContacts;
    }

    @Override
    public String updateAdditionalContact(AdditionalShippperContactBean additionalShippperContactBean) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update additionalcontactforshipper set contactname=?,position=?,phone=?,fax=?,cellular=?,email=?,ext=?,prefix=?,status=? where contactid=?");
            pstmt.setString(1, additionalShippperContactBean.getContactName());
            pstmt.setString(2, additionalShippperContactBean.getPosition());
            pstmt.setString(3, additionalShippperContactBean.getPhone());
            pstmt.setString(4, additionalShippperContactBean.getFax());
            pstmt.setString(5, additionalShippperContactBean.getCellular());
            pstmt.setString(6, additionalShippperContactBean.getEmail());
            pstmt.setString(7, additionalShippperContactBean.getExt());
            pstmt.setString(8, additionalShippperContactBean.getPrefix());
            pstmt.setInt(9, additionalShippperContactBean.getStatus());
            pstmt.setInt(10, additionalShippperContactBean.getContactId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Contact Update Successfully";
            }
        } catch (Exception e) {
            System.out.println("in updateContact " + e);
        }
        return "Failed To Update Contact";
    }

    @Override
    public String deleteContact(int contactId) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from additionalcontactforshipper where contactid=?");
            pstmt.setInt(1, contactId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Contact Deleted Successfully";
            }
        } catch (Exception e) {
            System.out.println("in deleteContact " + e);
        }
        return "Failed To Delete Contact";

    }

}
