/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.dao.admin.StatusDAO;
import dpu.entity.admin.Role;
import dpu.entity.admin.Status;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Durga
 */
public class StatusDAOImpl implements StatusDAO{

    @Override
    public List<Status> getAllStatus() {
           List<Status> listOfStatus = new ArrayList<Status>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Status.class);
            listOfStatus = criteria.list();
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
        return listOfStatus;
    }
     
    
}
