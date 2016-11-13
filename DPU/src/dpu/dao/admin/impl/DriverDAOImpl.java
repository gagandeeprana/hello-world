/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.HibernateUtil;
import dpu.beans.admin.DriverBean;
import dpu.common.properties.Iconstant;
import dpu.dao.admin.DriverDAO;
import dpu.dao.common.ConnectDB;
import dpu.entity.admin.Driver;
import dpu.ui.common.AddDriverFrame;
import dpu.ui.common.DriverPanel;
import static dpu.ui.common.DriverPanel.cbShowAll;
import dpu.ui.common.helper.DriverUIHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
 

public class DriverDAOImpl implements DriverDAO {

   
     
    Logger logger = Logger.getLogger(DriverDAOImpl.class);

     //DriverUIHelper driverUIHelper = new DriverUIHelper();

    @Override
    public String addDriver(Driver driver) {
        Session session = null;
        Transaction tx = null;
         
        
        if(AddDriverFrame.flag.equals("add")){
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            logger.info("class ID : ." +driver.getClassId());
            session.saveOrUpdate(driver);
            
            tx.commit();
            DriverUIHelper driverUIHelper = new DriverUIHelper();
            driverUIHelper.QuickFilterDrivers();
            JOptionPane.showMessageDialog(null, "Driver Added Successfully.");
            logger.info("Driver Added Successfully." );
            return "Driver Added Successfully.";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("DriverDAOImpl : addType : " + e);
        }
       }  else if(AddDriverFrame.flag.equals("update")){
           
       }
         
        return "Failed to Add Driver";
        
    }

    @Override
    public List<Driver> updateDriver(String driverCode) {
         
            Session session = HibernateUtil.getSession();
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
            session = HibernateUtil.getSession();
            session.clear() ;
            tx = session.beginTransaction();
             
            session.update(driver);
            logger.info("Driver ID : "+ driver.getDriverId() );
            logger.info("Driver FRTST NAME : "+ driver.getFirstName() );
            tx.commit();
             DriverUIHelper driverUIHelper = new DriverUIHelper();
            driverUIHelper.QuickFilterDrivers();
            JOptionPane.showMessageDialog(null, "Driver Updated Successfully.");
            logger.info("Driver Updated Successfully." );
             
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("[DriverDAOImpl ]: UpdatedDriver : " + e);
        } //finally {
            //try {
              //  if (session != null) {
                //    session.close();
                //}
            //} catch (Exception e) {
            //}
        //}
         
         
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
                 Driver deleteDriver = drivers.get(0);
                 int id = deleteDriver.getDriverId();
                 deleteDriver.setDriverId(id);
                 deleteDriver.setStatusId("InActive");
                 session.update(deleteDriver);
                 tx.commit();
                 JOptionPane.showMessageDialog(null, "Driver Deleted Successfully.");
                 
                 DriverUIHelper driverUIHelper = new DriverUIHelper();
                // driverUIHelper.QuickFilterDrivers();
                 driverUIHelper.showAllDrivers();
                }
                logger.info("Driver Deleted Successfully." );
                
                
                return "Driver Deleted Successfully";
             
        } catch (Exception e) {
            logger.error("[deleteDriver]Exception : " +e);
            tx.rollback();
              
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
         List<Driver> listOfDriver = null;  
        try{
            Session session = HibernateUtil.getSession();
            Criteria  driverCriteria = session.createCriteria(Driver.class);
            driverCriteria.add(Restrictions.eq("statusId", Iconstant.statusActive));
            listOfDriver = driverCriteria.list();
            logger.info("List Of Drivers showing..." );
            return listOfDriver;
        
        }catch(Exception e){
            
        } finally{
            HibernateUtil.closeSession();
        }
        
        return listOfDriver;
        }
    
    @Override
     public List<Driver> QuickFilterDrivers(){
        
        Session session = HibernateUtil.getSession();
        
         
        
        String filterByName = null;
        filterByName = "%"+DriverPanel.txtQuickFilter.getText().trim()+"%";
        logger.info("List Of Drivers showing...] filterByName :" + filterByName);
         
                if(filterByName.equals("%%")  && cbShowAll.isSelected() == true){
                    Criteria  driverCriteria = session.createCriteria(Driver.class);
             
                    List<Driver> listOfDriver = driverCriteria.list();
                    logger.info("List Of Drivers showing..." );
                    return listOfDriver;
               }
        if(filterByName.equals("%%") && cbShowAll.isSelected() == false) {
            Criteria  driverCriteria = session.createCriteria(Driver.class);
            driverCriteria.add(Restrictions.eq("statusId", Iconstant.statusActive));
            List<Driver> listOfDriver = driverCriteria.list();
            logger.info("List Of Drivers showing..." );
            return listOfDriver;
        } 
        
        else{
             if(cbShowAll.isSelected() == true){
                Criteria cr = session.createCriteria(Driver.class);
                cr.add(Restrictions.like("firstName", filterByName));
                List<Driver> listOfDriver = cr.list();
                for(Driver driver : listOfDriver){
                logger.info("driver Name : "+driver.getFirstName() );
            }
            logger.info("List Of Filter Drivers showing..." );
        
         
        return listOfDriver;
        }else{
                  Criteria driverCriteria = session.createCriteria(Driver.class);
                driverCriteria.add(Restrictions.like("firstName", filterByName));
                driverCriteria.add(Restrictions.eq("statusId", Iconstant.statusActive));
                List<Driver> listOfDriver = driverCriteria.list();
                for(Driver driver : listOfDriver){
                logger.info("driver Name : "+driver.getFirstName() );
            }
            logger.info("List Of Filter Drivers showing..." );
        
         
        return listOfDriver;
             }
        }
     }

    @Override
    public List<Driver> getAllDrivers(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Driver> showAll() {
          List<Driver> listOfDriver = null;  
        try{
            Session session = HibernateUtil.getSession();
            Criteria  driverCriteria = session.createCriteria(Driver.class);
             
            listOfDriver = driverCriteria.list();
            logger.info("List Of Drivers showing..." );
            return listOfDriver;
        
        }catch(Exception e){
            
        } finally{
            HibernateUtil.closeSession();
        }
        
        return listOfDriver;
    }
         
    }
