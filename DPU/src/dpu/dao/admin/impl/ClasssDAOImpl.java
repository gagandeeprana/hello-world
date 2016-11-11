/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.ClassBean;
import dpu.dao.admin.ClassDAO;
import dpu.dao.admin.ClasssDAO;
import dpu.entity.admin.Classs;
import dpu.entity.admin.Status;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Durga
 */
public class ClasssDAOImpl implements ClasssDAO{

    @Override
    public List<Classs> getAllClass() {
          List<Classs> listOfClass = new ArrayList<Classs>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Classs.class);
            listOfClass = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return listOfClass;
    }
   

 }
