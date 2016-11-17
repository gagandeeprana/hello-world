/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.DPU;
import dpu.HibernateUtil;
import dpu.beans.admin.CategoryBean;
import dpu.beans.admin.TerminalBean;
import dpu.dao.admin.CategoryDAO;
import dpu.entity.admin.Category;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

public class CategoryDAOImpl implements CategoryDAO {

    Logger logger = Logger.getLogger(CategoryDAOImpl.class);

    @Override
    public List<CategoryBean> getAllCategories(String categoryName, int status) {
        List<CategoryBean> lstCategories = new ArrayList<>();
        Session session = null;
        try {
            session = DPU.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(CategoryBean.class);
            if (!"".equals(categoryName)) {
                criteria.add(Restrictions.like("categoryName", categoryName, MatchMode.ANYWHERE));
            }
            if (status != 2) {
                criteria.add(Restrictions.eq("status", status));
            }
            criteria.addOrder(Order.desc("createdOn"));
            lstCategories = (List<CategoryBean>) criteria.list();
        } catch (Exception e) {
            logger.error("CategoryDAOImpl : getAllCategories : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return lstCategories;
    }

    @Override
    public int addCategory(CategoryBean obj) {
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
            logger.error("CategoryDAOImpl : addCategory : " + e);
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
    public String updateCategory(CategoryBean obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return "Category Updated";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("CategoryDAOImpl : updateCategory : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Update Category";
    }

    @Override
    public String deleteCategory(int categoryId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DPU.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("update CategoryBean set status =:s where categoryId=:c");
            query.setParameter("s", 1);
            query.setParameter("c", categoryId);
            query.executeUpdate();
            tx.commit();
            return "Category Deleted";
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("CategoryDAOImpl : deleteCategory : " + e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
            }
        }
        return "Failed to Delete Category";
    }

    @Override
    public List<CategoryBean> getAllCategory() {
        List<CategoryBean> listOfCategory = new ArrayList<CategoryBean>();
        Session session = null;
        try {
             session = HibernateUtil.getSession();
             
            Criteria criteria = session.createCriteria(CategoryBean.class);
            listOfCategory = criteria.list();
        } catch (Exception e) {
            logger.error("CategoryDAOImpl : getAllCategories : " + e);
        }  //finally{
            //HibernateUtil.closeSession();
            //}
        return listOfCategory;
    }
     
}
