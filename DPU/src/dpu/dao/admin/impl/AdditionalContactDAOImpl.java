/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.CompanyBean;
import dpu.beans.admin.AdditionalContactBean;
import dpu.dao.admin.AdditionalContactDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class AdditionalContactDAOImpl implements AdditionalContactDAO {

    Logger logger = Logger.getLogger(AdditionalContactDAOImpl.class);

    @Override
    public List<AdditionalContactBean> getAllAdditionalContacts() {
        List<AdditionalContactBean> lstAdditionalContacts = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(AdditionalContactBean.class);
            lstAdditionalContacts = (List<AdditionalContactBean>) criteria.list();
        } catch (Exception e) {
            logger.error("AdditionalContactDAOImpl : getAllAdditionalContacts : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstAdditionalContacts;
    }

    @Override
    public int addAdditionalContact(AdditionalContactBean obj) {
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
            logger.error("AdditionalContactDAOImpl : addAdditionalContact : " + e);
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
    public String updateAdditionalContact(AdditionalContactBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "AdditionalContact Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("AdditionalContactDAOImpl : updateAdditionalContact : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update AdditionalContact";
    }

    @Override
    public String deleteAdditionalContact(int additionalContactId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            AdditionalContactBean obj = (AdditionalContactBean) session.get(AdditionalContactBean.class, additionalContactId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "AdditionalContact Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("AdditionalContactDAOImpl : deleteAdditionalContact : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete AdditionalContact";
    }

    @Override
    public AdditionalContactBean getAdditionalContactInfoById(int id) {
        Session session = null;
        AdditionalContactBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (AdditionalContactBean) session.get(AdditionalContactBean.class, id);
        } catch (Exception e) {
            logger.error("AdditionalContactDAOImpl : getAdditionalContactInfoById : " + e);
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
    public List<AdditionalContactBean> getAllAdditionalContactsByCompanyId(int id) {
        List<AdditionalContactBean> lstAdditionalContacts = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(AdditionalContactBean.class);
            criteria.createCriteria("companyBean");
            criteria.add(Restrictions.eq("companyBean.companyId", id));
            lstAdditionalContacts = (List<AdditionalContactBean>) criteria.list();
        } catch (Exception e) {
            logger.error("AdditionalContactDAOImpl : getAllAdditionalContactsByCompanyId : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstAdditionalContacts;
    }
}
