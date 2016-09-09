/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.StandardChargesBean;
import dpu.dao.admin.StandardChargesDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class StandardChargesDAOImpl implements StandardChargesDAO {

    Logger logger = Logger.getLogger(StandardChargesDAOImpl.class);

    @Override
    public List<StandardChargesBean> getAllStandardCharges(String code) {
        List<StandardChargesBean> lstStandardChargess = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(StandardChargesBean.class);
            if (!"".equals(code)) {
                criteria.add(Restrictions.like("code", code, MatchMode.ANYWHERE));
            }
            lstStandardChargess = (List<StandardChargesBean>) criteria.list();
        } catch (Exception e) {
            logger.error("StandardChargesDAOImpl : getAllStandardCharges : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstStandardChargess;
    }

    @Override
    public int addStandardCharges(StandardChargesBean obj) {
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
            logger.error("StandardChargesDAOImpl : addStandardCharges : " + e);
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
    public String updateStandardCharges(StandardChargesBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "StandardCharges Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("StandardChargesDAOImpl : updateStandardCharges : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update StandardCharges";
    }

    @Override
    public String deleteStandardCharges(int standardChargesId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            StandardChargesBean obj = (StandardChargesBean) session.get(StandardChargesBean.class, standardChargesId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "StandardCharges Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("StandardChargesDAOImpl : deleteStandardCharges : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete StandardCharges";
    }

    @Override
    public StandardChargesBean getStandardChargesInfoById(int id) {
        Session session = null;
        StandardChargesBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (StandardChargesBean) session.get(StandardChargesBean.class, id);
        } catch (Exception e) {
            logger.error("StandardChargesDAOImpl : getStandardChargesInfoById : " + e);
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
