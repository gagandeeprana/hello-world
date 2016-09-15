/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.CompanyBean;
import dpu.beans.admin.ContainerBean;
import dpu.dao.admin.ContainerDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class ContainerDAOImpl implements ContainerDAO {

    Logger logger = Logger.getLogger(ContainerDAOImpl.class);

    @Override
    public List<ContainerBean> getAllContainers(String owner) {
        List<ContainerBean> lstContainers = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(ContainerBean.class);
            if (!"".equals(owner)) {
                criteria.add(Restrictions.like("owner", owner, MatchMode.ANYWHERE));
            }
            lstContainers = (List<ContainerBean>) criteria.list();
        } catch (Exception e) {
            logger.error("ContainerDAOImpl : getAllContainers : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstContainers;
    }

    @Override
    public int addContainer(ContainerBean obj) {
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
            logger.error("ContainerDAOImpl : addContainer : " + e);
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
    public String updateContainer(ContainerBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "Container Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("ContainerDAOImpl : updateContainer : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update Container";
    }

    @Override
    public String deleteContainer(int typeId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            ContainerBean obj = (ContainerBean) session.get(ContainerBean.class, typeId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "Container Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("ContainerDAOImpl : deleteContainer : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete Container";
    }

    @Override
    public ContainerBean getContainerInfoById(int id) {
        Session session = null;
        ContainerBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (ContainerBean) session.get(ContainerBean.class, id);
        } catch (Exception e) {
            logger.error("ContainerDAOImpl : getContainerInfoById : " + e);
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
