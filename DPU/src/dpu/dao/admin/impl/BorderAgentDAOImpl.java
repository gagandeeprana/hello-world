/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.BorderAgentBean;
import dpu.dao.admin.BorderAgentDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class BorderAgentDAOImpl implements BorderAgentDAO {

    Logger logger = Logger.getLogger(BorderAgentDAOImpl.class);

    @Override
    public List<BorderAgentBean> getAllBorderAgents() {
        List<BorderAgentBean> lstBorderAgents = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(BorderAgentBean.class);
            lstBorderAgents = (List<BorderAgentBean>) criteria.list();
        } catch (Exception e) {
            logger.error("BorderAgentDAOImpl : getAllBorderAgents : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstBorderAgents;
    }

    @Override
    public int addBorderAgent(BorderAgentBean obj) {
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
            logger.error("BorderAgentDAOImpl : addBorderAgent : " + e);
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
    public String updateBorderAgent(BorderAgentBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "BorderAgent Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("BorderAgentDAOImpl : updateBorderAgent : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update BorderAgent";
    }

    @Override
    public String deleteBorderAgent(int borderAgentId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            BorderAgentBean obj = (BorderAgentBean) session.get(BorderAgentBean.class, borderAgentId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "BorderAgent Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("BorderAgentDAOImpl : deleteBorderAgent : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete BorderAgent";
    }

    @Override
    public BorderAgentBean getBorderAgentInfoById(int id) {
        Session session = null;
        BorderAgentBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (BorderAgentBean) session.get(BorderAgentBean.class, id);
        } catch (Exception e) {
            logger.error("BorderAgentDAOImpl : getBorderAgentInfoById : " + e);
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

    @Override
    public List<BorderAgentBean> getAllBorderAgentsByCustomBrokerId(int customBrokerId) {
        List<BorderAgentBean> lstBorderAgents = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(BorderAgentBean.class);
            criteria.createCriteria("customBrokerBean");
            criteria.add(Restrictions.eq("customBrokerBean.customBrokerId", customBrokerId));
            lstBorderAgents = (List<BorderAgentBean>) criteria.list();
        } catch (Exception e) {
            logger.error("BorderAgentDAOImpl : getAllBorderAgentsByCustomBrokerId : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstBorderAgents;
    }
}
