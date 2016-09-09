/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.CustomBrokerBean;
import dpu.dao.admin.CustomBrokerDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class CustomBrokerDAOImpl implements CustomBrokerDAO {

    Logger logger = Logger.getLogger(CustomBrokerDAOImpl.class);

    @Override
    public List<CustomBrokerBean> getAllCustomBrokers(String customBroker) {
        List<CustomBrokerBean> lstCustomBrokers = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(CustomBrokerBean.class);
            if (!"".equals(customBroker)) {
                criteria.add(Restrictions.like("customBroker", customBroker, MatchMode.ANYWHERE));
            }
            lstCustomBrokers = (List<CustomBrokerBean>) criteria.list();
        } catch (Exception e) {
            logger.error("CustomBrokerDAOImpl : getAllCustomBrokers : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstCustomBrokers;
    }

    @Override
    public int addCustomBroker(CustomBrokerBean obj) {
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
            logger.error("CustomBrokerDAOImpl : addCustomBroker : " + e);
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
    public String updateCustomBroker(CustomBrokerBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "CustomBroker Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("CustomBrokerDAOImpl : updateCustomBroker : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update CustomBroker";
    }

    @Override
    public String deleteCustomBroker(int customBrokerId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            CustomBrokerBean obj = (CustomBrokerBean) session.get(CustomBrokerBean.class, customBrokerId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "CustomBroker Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("CustomBrokerDAOImpl : deleteCustomBroker : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete CustomBroker";
    }

    @Override
    public CustomBrokerBean getCustomBrokerInfoById(int id) {
        Session session = null;
        CustomBrokerBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (CustomBrokerBean) session.get(CustomBrokerBean.class, id);
        } catch (Exception e) {
            logger.error("CustomBrokerDAOImpl : getCustomBrokerInfoById : " + e);
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
