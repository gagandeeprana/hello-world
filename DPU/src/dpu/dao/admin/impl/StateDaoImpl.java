/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.dao.admin.StateDAO;
import dpu.entity.admin.State;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author lakhvir
 */
public class StateDaoImpl implements StateDAO{

    @Override
    public List<State> getAllStates() {
        Session session = null;
        List<State> stateList = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria  stateCriteria = session.createCriteria(State.class);
            stateList = stateCriteria.list();
            
        } catch (Exception e) {
            
            System.out.println("dpu.dao.admin.impl.StateDaoImpl.getAllStates()"+e.getMessage());
              
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return stateList;
    }
    
}
