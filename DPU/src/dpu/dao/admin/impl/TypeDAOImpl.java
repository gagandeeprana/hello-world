/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.CompanyBean;
import dpu.beans.admin.TypeBean;
import dpu.dao.admin.TypeDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class TypeDAOImpl implements TypeDAO {

    Logger logger = Logger.getLogger(TypeDAOImpl.class);

    @Override
    public List<TypeBean> getAllTypes(String typeName) {
        List<TypeBean> lstTypes = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(TypeBean.class);
            if (!"".equals(typeName)) {
                criteria.add(Restrictions.like("typeName", typeName, MatchMode.ANYWHERE));
            }
            lstTypes = (List<TypeBean>) criteria.list();
        } catch (Exception e) {
            logger.error("TypeDAOImpl : getAllTypes : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstTypes;
    }

    @Override
    public int addType(TypeBean obj) {
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
            logger.error("TypeDAOImpl : addType : " + e);
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
    public String updateType(TypeBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "Type Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("TypeDAOImpl : updateType : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update Type";
    }

    @Override
    public String deleteType(int typeId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            TypeBean obj = (TypeBean) session.get(TypeBean.class, typeId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "Type Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("TypeDAOImpl : deleteType : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete Type";
    }

    @Override
    public TypeBean getTypeInfoById(int id) {
        Session session = null;
        TypeBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (TypeBean) session.get(TypeBean.class, id);
        } catch (Exception e) {
            logger.error("TypeDAOImpl : getTypeInfoById : " + e);
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
