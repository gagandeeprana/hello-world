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

import com.jiqa.beans.QuestionBean;
import com.jiqa.dao.QuestionDAO;

class QuestionDAOImpl implements QuestionDAO {

	Logger logger = Logger.getLogger(QuestionDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public int addQuestion(QuestionBean questionBean) {
		Session session = null;
		Transaction tx = null;
		int maxId = 0;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			maxId = (Integer) session.save(questionBean);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("QuestionDAOImpl: Inside addQuestion: Exception is: "
					+ e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				logger.error("QuestionDAOImpl: Inside addQuestion: Inside Finally: Exception is: "
						+ e2.getMessage());
			}
		}
		return maxId;
	}

	public boolean updateQuestion(QuestionBean questionBean) {
		Session session = null;
		Transaction tx = null;
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(questionBean);
			tx.commit();
			flag = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("QuestionDAOImpl: Inside updateQuestion: Exception is: "
					+ e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				logger.error("QuestionDAOImpl: Inside updateQuestion: Inside Finally: Exception is: "
						+ e2.getMessage());
			}
		}
		return flag;
	}

	public int softDeleteQuestion(int status, int questionId) {
		Session session = null;
		int result = 0;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			query = session
					.createQuery("update questionmaster set status = :status where question_id = :questionId");
			query.setParameter("status", status);
			query.setParameter("questionId", questionId);
			result = query.executeUpdate();
		} catch (Exception e) {
			logger.error("QuestionDAOImpl: Inside softDeleteQuestion: Exception is: "
					+ e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				logger.error("QuestionDAOImpl: Inside softDeleteQuestion: Inside Finally: Exception is: "
						+ e2.getMessage());
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<QuestionBean> getAllQuestions(String question, String answer, int categoryId) {
		Session session = null;
		List<QuestionBean> lstCategories = new ArrayList<QuestionBean>();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(QuestionBean.class);
			if(!"".equals(question)) {
				criteria.add(Restrictions.like("question", question, MatchMode.ANYWHERE));
			}
			if(!"".equals(answer)) {
				criteria.add(Restrictions.like("answer", answer, MatchMode.ANYWHERE));
			}
			if(categoryId != 0) {
				criteria.createCriteria("categoryBean");
				criteria.add(Restrictions.eq("categoryBean.categoryId", categoryId));
			}
			lstCategories = (List<QuestionBean>) criteria.list();
		} catch (Exception e) {
			logger.error("QuestionDAOImpl: Inside getAllCategories: Exception is: "
					+ e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				logger.error("QuestionDAOImpl: Inside getAllCategories: Inside Finally: Exception is: "
						+ e2.getMessage());
			}
		}
		return lstCategories;
	}
}