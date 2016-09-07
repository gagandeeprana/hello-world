/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.BillingLocationBean;
import dpu.beans.admin.CompanyBean;
import dpu.dao.admin.BillingLocationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class BillingLocationDAOImpl implements BillingLocationDAO {

    Logger logger = Logger.getLogger(BillingLocationDAOImpl.class);

    @Override
    public List<BillingLocationBean> getAllBillingLocations(String name) {
        List<BillingLocationBean> lstBillingLocations = new ArrayList<>();
        Session session = null;
//        Connection conn = null;
//        ResultSet rs = null;
//        PreparedStatement pstmt = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(BillingLocationBean.class);
            if (!"".equals(name)) {
                criteria.add(Restrictions.like("name", name));
            }
            lstBillingLocations = (List<BillingLocationBean>) criteria.list();
            return lstBillingLocations;
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("select * from billinglocationmaster where name like ? order by name");
//            pstmt.setString(1, "%" + name + "%");
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                BillingLocationBean obj = new BillingLocationBean();
//                obj.setBillingLocationId(rs.getInt("billing_location_id"));
//                obj.setName(rs.getString("name"));
//                obj.setAddress(rs.getString("address"));
//                obj.setUnitNo(rs.getString("unit_no"));
//                obj.setCity(rs.getString("city"));
//                obj.setProvinceState(rs.getString("province_state"));
//                obj.setZip(rs.getString("zip"));
//                obj.setArCDN(rs.getString("ar_cdn"));
//                obj.setArUS(rs.getString("ar_us"));
//                obj.setStatus(rs.getInt("status"));
//                obj.setContact(rs.getString("contact"));
//                obj.setPosition(rs.getString("position"));
//                obj.setEmail(rs.getString("email"));
//                obj.setCellular(rs.getString("cellular"));
//                obj.setPhone(rs.getString("phone"));
//                obj.setExt(rs.getString("ext"));
//                obj.setFax(rs.getString("fax"));
//                obj.setPrefix(rs.getString("prefix"));
//                obj.setTollfree(rs.getString("tollfree"));
//                obj.setCompanyId(rs.getInt("company_id"));
//                lstBillingLocations.add(obj);
//            }
        } catch (Exception e) {
            System.out.println("BillingLocationDAOImpl : getAllBillingLocations : " + e);
            logger.error("BillingLocationDAOImpl : getAllBillingLocations : " + e);
        }
        return lstBillingLocations;
    }

    @Override
    public int addBillingLocation(BillingLocationBean obj) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
        int maxBillingLocationId = 0;
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            maxBillingLocationId = (int) session.save(obj);
            tx.commit();
            return maxBillingLocationId;
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("insert into billinglocationmaster (name,address,unit_no,city,province_state,zip,ar_cdn,ar_us,status,contact,position,email,cellular,phone,ext,fax,prefix,tollfree,company_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//            pstmt.setString(1, obj.getName());
//            pstmt.setString(2, obj.getAddress());
//            pstmt.setString(3, obj.getUnitNo());
//            pstmt.setString(4, obj.getCity());
//            pstmt.setString(5, obj.getProvinceState());
//            pstmt.setString(6, obj.getZip());
//            pstmt.setString(7, obj.getArCDN());
//            pstmt.setString(8, obj.getArUS());
//            pstmt.setInt(9, obj.getStatus());
//            pstmt.setString(10, obj.getContact());
//            pstmt.setString(11, obj.getPosition());
//            pstmt.setString(12, obj.getEmail());
//            pstmt.setString(13, obj.getCellular());
//            pstmt.setString(14, obj.getPhone());
//            pstmt.setString(15, obj.getExt());
//            pstmt.setString(16, obj.getFax());
//            pstmt.setString(17, obj.getPrefix());
//            pstmt.setString(18, obj.getTollfree());
//            pstmt.setInt(19, obj.getCompanyId());
//            int i = pstmt.executeUpdate();
//            if (i > 0) {
//                return "BillingLocation Added";
//            }
        } catch (Exception e) {
//            System.out.println("BillingLocationDAOImpl : addBillingLocation : " + e);
            logger.error("BillingLocationDAOImpl : addBillingLocation : " + e);
        }
        return maxBillingLocationId;
    }

    @Override
    public String updateBillingLocation(BillingLocationBean obj) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("update billinglocationmaster set name = ?,address=?,unit_no=?,city=?,province_state=?,zip=?,ar_cdn=?,ar_us=?,status=?,contact=?,position=?,email=?,cellular=?,phone=?,ext=?,fax=?,prefix=?,tollfree=?,company_id=? where billing_location_id = ?");
//            pstmt.setString(1, obj.getName());
//            pstmt.setString(2, obj.getAddress());
//            pstmt.setString(3, obj.getUnitNo());
//            pstmt.setString(4, obj.getCity());
//            pstmt.setString(5, obj.getProvinceState());
//            pstmt.setString(6, obj.getZip());
//            pstmt.setString(7, obj.getArCDN());
//            pstmt.setString(8, obj.getArUS());
//            pstmt.setInt(9, obj.getStatus());
//            pstmt.setString(10, obj.getContact());
//            pstmt.setString(11, obj.getPosition());
//            pstmt.setString(12, obj.getEmail());
//            pstmt.setString(13, obj.getCellular());
//            pstmt.setString(14, obj.getPhone());
//            pstmt.setString(15, obj.getExt());
//            pstmt.setString(16, obj.getFax());
//            pstmt.setString(17, obj.getPrefix());
//            pstmt.setString(18, obj.getTollfree());
//            pstmt.setInt(19, obj.getCompanyId());
//            pstmt.setInt(20, obj.getBillingLocationId());
//            int i = pstmt.executeUpdate();
//            if (i > 0) {
            return "BillingLocation Updated";
//            }
        } catch (Exception e) {
//            System.out.println("BillingLocationDAOImpl : updateBillingLocation : " + e);
            logger.error("BillingLocationDAOImpl : updateBillingLocation : " + e);
        }
        return "Failed to Update BillingLocation";
    }

    @Override
    public String deleteBillingLocation(int billingLocationId) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            BillingLocationBean obj = (BillingLocationBean) session.get(BillingLocationBean.class, billingLocationId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("delete from billinglocationmaster where billing_location_id = ?");
//            pstmt.setInt(1, billingLocationId);
//            int i = pstmt.executeUpdate();
//            if (i > 0) {
                return "BillingLocation Deleted";
//            }
        } catch (Exception e) {
//            System.out.println("BillingLocationDAOImpl : deleteBillingLocation : " + e);
            logger.error("BillingLocationDAOImpl : deleteBillingLocation : " + e);
        }
        return "Failed to Delete BillingLocation";
    }

    @Override
    public BillingLocationBean getBillingLocationById(int id) {
        BillingLocationBean obj = null;
//        Connection conn = null;
//        ResultSet rs = null;
//        PreparedStatement pstmt = null;
        Session session = null;
//        CompanyBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (BillingLocationBean) session.get(BillingLocationBean.class, id);
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("select * from billinglocationmaster where billing_location_id = ?");
//            pstmt.setInt(1, id);
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//                obj = new BillingLocationBean();
//                obj.setBillingLocationId(rs.getInt("billing_location_id"));
//                obj.setName(rs.getString("name"));
//                obj.setAddress(rs.getString("address"));
//                obj.setUnitNo(rs.getString("unit_no"));
//                obj.setCity(rs.getString("city"));
//                obj.setProvinceState(rs.getString("province_state"));
//                obj.setZip(rs.getString("zip"));
//                obj.setArCDN(rs.getString("ar_cdn"));
//                obj.setArUS(rs.getString("ar_us"));
//                obj.setStatus(rs.getInt("status"));
//                obj.setContact(rs.getString("contact"));
//                obj.setPosition(rs.getString("position"));
//                obj.setEmail(rs.getString("email"));
//                obj.setCellular(rs.getString("cellular"));
//                obj.setPhone(rs.getString("phone"));
//                obj.setExt(rs.getString("ext"));
//                obj.setFax(rs.getString("fax"));
//                obj.setPrefix(rs.getString("prefix"));
//                obj.setTollfree(rs.getString("tollfree"));
//                obj.setCompanyId(rs.getInt("company_id"));
//            }
        } catch (Exception e) {
//            System.out.println("BillingLocationDAOImpl : getBillingLocationById : " + e);
            logger.error("BillingLocationDAOImpl : getBillingLocationById : " + e);
        }
        return obj;
    }

    @Override
    public List<BillingLocationBean> getBillingLocationsByCompanyId(int id) {
        List<BillingLocationBean> lstBillingLocations = new ArrayList<>();
//        Connection conn = null;
//        ResultSet rs = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = connectDB.connect();
//            pstmt = conn.prepareStatement("select * from billinglocationmaster where company_id = ?");
//            pstmt.setInt(1, id);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                BillingLocationBean obj = new BillingLocationBean();
//                obj.setBillingLocationId(rs.getInt("billing_location_id"));
//                obj.setName(rs.getString("name"));
//                obj.setAddress(rs.getString("address"));
//                obj.setUnitNo(rs.getString("unit_no"));
//                obj.setCity(rs.getString("city"));
//                obj.setProvinceState(rs.getString("province_state"));
//                obj.setZip(rs.getString("zip"));
//                obj.setArCDN(rs.getString("ar_cdn"));
//                obj.setArUS(rs.getString("ar_us"));
//                obj.setStatus(rs.getInt("status"));
//                obj.setContact(rs.getString("contact"));
//                obj.setPosition(rs.getString("position"));
//                obj.setEmail(rs.getString("email"));
//                obj.setCellular(rs.getString("cellular"));
//                obj.setPhone(rs.getString("phone"));
//                obj.setExt(rs.getString("ext"));
//                obj.setFax(rs.getString("fax"));
//                obj.setPrefix(rs.getString("prefix"));
//                obj.setTollfree(rs.getString("tollfree"));
//                obj.setCompanyId(rs.getInt("company_id"));
//                lstBillingLocations.add(obj);
//            }
//        } catch (Exception e) {
//            System.out.println("BillingLocationDAOImpl : getBillingLocationsByCompanyId : " + e);
//            logger.error("BillingLocationDAOImpl : getBillingLocationsByCompanyId : " + e);
//        }
        return lstBillingLocations;
    }
}
