/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.PaymentTermsBean;
import dpu.dao.admin.PaymentTermsDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class PaymentTermsDAOImpl implements PaymentTermsDAO {

    Logger logger = Logger.getLogger(PaymentTermsDAOImpl.class);

    @Override
    public List<PaymentTermsBean> getAllPaymentTerms(String term) {
        List<PaymentTermsBean> lstPaymentTermss = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(PaymentTermsBean.class);
            if (!"".equals(term)) {
                criteria.add(Restrictions.like("term", term, MatchMode.ANYWHERE));
            }
            lstPaymentTermss = (List<PaymentTermsBean>) criteria.list();
        } catch (Exception e) {
            logger.error("PaymentTermsDAOImpl : getAllPaymentTerms : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstPaymentTermss;
    }

    @Override
    public int addPaymentTerm(PaymentTermsBean obj) {
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
            logger.error("PaymentTermsDAOImpl : addPaymentTerm : " + e);
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
    public String updatePaymentTerm(PaymentTermsBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "PaymentTerms Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("PaymentTermsDAOImpl : updatePaymentTerm : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update PaymentTerms";
    }

    @Override
    public String deletePaymentTerm(int typeId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            PaymentTermsBean obj = (PaymentTermsBean) session.get(PaymentTermsBean.class, typeId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "PaymentTerm Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("PaymentTermsDAOImpl : deletePaymentTerm : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete PaymentTerms";
    }

    @Override
    public PaymentTermsBean getPaymentTermInfoById(int id) {
        Session session = null;
        PaymentTermsBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (PaymentTermsBean) session.get(PaymentTermsBean.class, id);
        } catch (Exception e) {
            logger.error("PaymentTermsDAOImpl : getPaymentTermInfoById : " + e);
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
