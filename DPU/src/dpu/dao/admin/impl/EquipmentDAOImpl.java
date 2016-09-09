/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.beans.admin.EquipmentBean;
import dpu.dao.admin.EquipmentDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class EquipmentDAOImpl implements EquipmentDAO {

    Logger logger = Logger.getLogger(EquipmentDAOImpl.class);

    @Override
    public List<EquipmentBean> getAllEquipments(String equipmentName) {
        List<EquipmentBean> lstEquipments = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(EquipmentBean.class);
            if (!"".equals(equipmentName)) {
                criteria.add(Restrictions.like("equipmentName", equipmentName, MatchMode.ANYWHERE));
            }
            lstEquipments = (List<EquipmentBean>) criteria.list();
        } catch (Exception e) {
            logger.error("EquipmentDAOImpl : getAllEquipments : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstEquipments;
    }

    @Override
    public int addEquipment(EquipmentBean obj) {
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
            logger.error("EquipmentDAOImpl : addEquipment : " + e);
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
    public String updateEquipment(EquipmentBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "Equipment Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("EquipmentDAOImpl : updateEquipment : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update Equipment";
    }

    @Override
    public String deleteEquipment(int equipmentId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            EquipmentBean obj = (EquipmentBean) session.get(EquipmentBean.class, equipmentId);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return "Equipment Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("EquipmentDAOImpl : deleteEquipment : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete Equipment";
    }

    @Override
    public EquipmentBean getEquipmentInfoById(int id) {
        Session session = null;
        EquipmentBean obj = null;
        try {
            session = DPU.getSessionFactory().openSession();
            obj = (EquipmentBean) session.get(EquipmentBean.class, id);
        } catch (Exception e) {
            logger.error("EquipmentDAOImpl : getEquipmentInfoById : " + e);
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
