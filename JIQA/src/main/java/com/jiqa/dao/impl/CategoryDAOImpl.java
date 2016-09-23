package com.jiqa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiqa.beans.CategoryBean;
import com.jiqa.dao.CategoryDAO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	Logger logger = Logger.getLogger(CategoryDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public int addCategory(CategoryBean categoryBean) {
		Session session = null;
		Transaction tx = null;
		int maxId = 0;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			maxId = (Integer) session.save(categoryBean);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("CategoryDAOImpl: Inside addCategory: Exception is: "
					+ e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				logger.error("CategoryDAOImpl: Inside addCategory: Inside Finally: Exception is: "
						+ e2.getMessage());
			}
		}
		return maxId;
	}

	public boolean updateCategory(CategoryBean categoryBean) {
		Session session = null;
		Transaction tx = null;
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(categoryBean);
			tx.commit();
			flag = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("CategoryDAOImpl: Inside updateCategory: Exception is: "
					+ e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				logger.error("CategoryDAOImpl: Inside updateCategory: Inside Finally: Exception is: "
						+ e2.getMessage());
			}
		}
		return flag;
	}

	public int softDeleteCategory(int status, int categoryId) {
		Session session = null;
		int result = 0;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			query = session
					.createQuery("update categorymaster set status = :status where category_is = :categoryId");
			query.setParameter("status", status);
			query.setParameter("categoryId", categoryId);
			result = query.executeUpdate();
		} catch (Exception e) {
			logger.error("CategoryDAOImpl: Inside softDeleteCategory: Exception is: "
					+ e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				logger.error("CategoryDAOImpl: Inside softDeleteCategory: Inside Finally: Exception is: "
						+ e2.getMessage());
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<CategoryBean> getAllCategories(String title) {
		Session session = null;
		System.out.println("222222");
		List<CategoryBean> lstCategories = new ArrayList<CategoryBean>();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CategoryBean.class);
			System.out.println("33333333");
			if(!"".equals(title)) {
				criteria.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
			}
			System.out.println("44444444");
			lstCategories = (List<CategoryBean>) criteria.list();
			System.out.println("MMssss: " + lstCategories.size());
		} catch (Exception e) {
			logger.error("CategoryDAOImpl: Inside getAllCategories: Exception is: "
					+ e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				logger.error("CategoryDAOImpl: Inside getAllCategories: Inside Finally: Exception is: "
						+ e2.getMessage());
			}
		}
		return lstCategories;
	}

}
