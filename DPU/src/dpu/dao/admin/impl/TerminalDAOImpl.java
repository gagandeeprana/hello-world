/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.HibernateUtil;
import dpu.beans.admin.TerminalBean;
import dpu.dao.admin.TerminalDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class TerminalDAOImpl implements TerminalDAO {

    Logger logger = Logger.getLogger(TerminalDAOImpl.class);

    @Override
    public List<TerminalBean> getAllTerminals(String terminalName) {
        List<TerminalBean> lstTerminals = new ArrayList<>();
        System.out.println("terminalName"+terminalName);
        Session session = null;
        try {
            
            session = HibernateUtil.getSession();
             
            
            Criteria criteria = session.createCriteria(TerminalBean.class);
            if (!"".equals(terminalName)) {
                criteria.add(Restrictions.like("terminalName", terminalName, MatchMode.ANYWHERE));
            }
            lstTerminals = (List<TerminalBean>) criteria.list();
        } catch (Exception e) {
            logger.error("TerminalDAOImpl : getAllTerminals : " + e);
        } finally{
            HibernateUtil.closeSession();;
        }
        return lstTerminals;
    }

    @Override
    public int addTerminal(TerminalBean obj) {
        Session session = null;
        Transaction tx = null;
        int maxId = 0;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            maxId = (int) session.save(obj);
            tx.commit();
            return maxId;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("TerminalDAOImpl : addTerminal : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return maxId;
    }

    @Override
    public String updateTerminal(TerminalBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "Terminal Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("TerminalDAOImpl : updateTerminal : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update Terminal";
    }

    @Override
    public String deleteTerminal(int terminalId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            TerminalBean obj = (TerminalBean) session.get(TerminalBean.class, terminalId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "Terminal Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("TerminalDAOImpl : deleteTerminal : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete Terminal";
    }

    @Override
    public TerminalBean getTerminalInfoById(int id) {
        Session session = null;
        TerminalBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (TerminalBean) session.get(TerminalBean.class, id);
        } catch (Exception e) {
            logger.error("TerminalDAOImpl : getTerminalInfoById : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return obj;
    }
}
