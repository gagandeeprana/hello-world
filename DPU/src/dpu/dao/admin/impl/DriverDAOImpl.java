/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.DriverBean;
import dpu.dao.admin.DriverDAO;
import dpu.dao.common.ConnectDB;
import dpu.entity.admin.Driver;
import dpu.ui.common.DriverPanel;
import dpu.ui.common.helper.DriverUIHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverDAOImpl implements DriverDAO {

   @Autowired
    ConnectDB connectDB;
    Logger logger = Logger.getLogger(DriverDAOImpl.class);

    @Override
    public List<Driver> getAllDrivers(String name) {
        List<Driver> lstDrivers = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from drivermaster where first_name like ?");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Driver obj = new Driver();
                obj.setDriverId(rs.getInt("driver_id"));
                obj.setFirstName(rs.getString("first_name"));
                obj.setLastName(rs.getString("last_name"));
                 
                lstDrivers.add(obj);
            }
        } catch (Exception e) {
            logger.error("DriverDAOImpl : getAllDrivers : " + e);
        }
        return lstDrivers;
    }

    @Override
    public String addDriver(Driver driver) {
        Session session = null;
        Transaction tx = null;
        int maxId = 0;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            logger.info("class ID : ." +driver.getClassId());
            session.saveOrUpdate(driver);
            
            tx.commit();
            DriverUIHelper driverUIHelper = new DriverUIHelper();
            driverUIHelper.QuickFilterDrivers();
            logger.info("Driver Added Successfully." );
            return "Driver Added Successfully.";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("DriverDAOImpl : addType : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
         
        return "Failed to Add Driver";
    }

    @Override
    public List<Driver> updateDriver(String driverCode) {
        Session session = null;
        Transaction tx = null;
         
        
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Driver.class);
            criteria.add(Restrictions.eq("driverCode",driverCode));
            List<Driver> drivers = criteria.list();
             return drivers;
        }
    @Override
    public void updateDriver(Driver driver) {
        
        Session session = null;
        Transaction tx = null;
         
        try{
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(driver);
            
            tx.commit();
            logger.info("Driver Updated Successfully." );
             
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("[DriverDAOImpl ]: UpdatedDriver : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
         
         
    }

    @Override
    public String deleteDriver(String driverCode) {
        System.out.println("driverCode :"+driverCode);
         Session session = null;
        Transaction tx = null;
         
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Driver driver = new Driver();
            Criteria criteria = session.createCriteria(Driver.class);
            criteria.add(Restrictions.eq("driverCode",driverCode));
            List<Driver> drivers = criteria.list();
            //driver = session.get(Driver.class,new String());
            if(drivers != null){
                for(Driver deleteDriver : drivers){
                    session.delete(deleteDriver);
                }
                logger.info("Driver Deleted Successfully." );
                tx.commit();
                return "Driver Deleted Successfully";
            }
        } catch (Exception e) {
            logger.error("[deleteDriver]Exception : " +e);
              
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
         
        return "Failed to delete Driver";
    }

    @Override
    public List<Driver> showAllDrivers() {
        Session session = null;
        
        session = DPU.getSessionFactory().openSession();
        Criteria  driverCriteria = session.createCriteria(Driver.class);
        List<Driver> listOfDriver = driverCriteria.list();
        logger.info("List Of Drivers showing..." );
        return listOfDriver;
        }
    
    @Override
     public List<Driver> QuickFilterDrivers(){
        Session session = null;
        session = DPU.getSessionFactory().openSession();
        
        String filterByName = null;
        filterByName = "%"+DriverPanel.txtQuickFilter.getText().trim()+"%";
        logger.info("List Of Drivers showing...] filterByName :" + filterByName);
        if(filterByName.equals("%%") || filterByName == null){
            Criteria  driverCriteria = session.createCriteria(Driver.class);
            List<Driver> listOfDriver = driverCriteria.list();
            logger.info("List Of Drivers showing..." );
            return listOfDriver;
        } 
        
        Criteria cr = session.createCriteria(Driver.class);
        cr.add(Restrictions.like("firstName", filterByName));
        
       // Criteria  driverNameCriteria = session.createCriteria(Driver.class);
        //Criterion criterion = Restrictions.like("firstName", filterByName);
        //driverNameCriteria.add(criterion);
        
        List<Driver> listOfDriver = cr.list();
        for(Driver driver : listOfDriver){
            logger.info("driver Name : "+driver.getFirstName() );
        }
        logger.info("List Of Filter Drivers showing..." );
        return listOfDriver;
     }
         
    }
