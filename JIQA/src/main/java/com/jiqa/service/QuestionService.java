package com.jiqa.service;

import java.util.List;

import com.jiqa.beans.QuestionBean;

public interface QuestionService {
	public int addQuestion(QuestionBean QuestionBean);

	public boolean updateQuestion(QuestionBean questionBean);

	public int softDeleteQuestion(int status, int questionId);

	public List<QuestionBean> getAllQuestions(String question, String answer,
			int categoryId);
}
