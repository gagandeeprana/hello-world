/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.SalesPersonBean;
import dpu.dao.admin.SalesPersonDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class SalesPersonDAOImpl implements SalesPersonDAO {

    Logger logger = Logger.getLogger(SalesPersonDAOImpl.class);

    @Override
    public List<SalesPersonBean> getAllSalesPersons(String salesPersonName) {
        List<SalesPersonBean> lstSalesPersons = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(SalesPersonBean.class);
            if (!"".equals(salesPersonName)) {
                criteria.add(Restrictions.like("name", salesPersonName, MatchMode.ANYWHERE));
            }
            lstSalesPersons = (List<SalesPersonBean>) criteria.list();
        } catch (Exception e) {
            logger.error("SalesPersonDAOImpl : getAllSalesPersons : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstSalesPersons;
    }

    @Override
    public int addSalesPerson(SalesPersonBean obj) {
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
            logger.error("SalesPersonDAOImpl : addSalesPerson : " + e);
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
    public String updateSalesPerson(SalesPersonBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "SalesPerson Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("SalesPersonDAOImpl : updateSalesPerson : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update SalesPerson";
    }

    @Override
    public String deleteSalesPerson(int salesPersonId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            SalesPersonBean obj = (SalesPersonBean) session.get(SalesPersonBean.class, salesPersonId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "SalesPerson Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("SalesPersonDAOImpl : deleteSalesPerson : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete SalesPerson";
    }

    @Override
    public SalesPersonBean getSalesPersonInfoById(int id) {
        Session session = null;
        SalesPersonBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (SalesPersonBean) session.get(SalesPersonBean.class, id);
        } catch (Exception e) {
            logger.error("SalesPersonDAOImpl : getSalesPersonInfoById : " + e);
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
