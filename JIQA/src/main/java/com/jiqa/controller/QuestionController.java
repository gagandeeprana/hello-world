package com.jiqa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jiqa.entity.CategoryBean;
import com.jiqa.entity.QuestionBean;
import com.jiqa.service.CategoryService;
import com.jiqa.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/showques", method = RequestMethod.GET)
	public ModelAndView showCategoryScreen(@ModelAttribute("manageques") QuestionBean questionBean) {
		ModelAndView modelAndView = new ModelAndView();
		int categoryId = 0;
//		if(request.getParameter("categoryId")!=null) {
//			categoryId = Integer.parseInt(request.getParameter("categoryId"));
//		}
		List<QuestionBean> lstQuestions = questionService.getAllQuestions(questionBean.getQuestion(), questionBean.getAnswer(), categoryId);
		List<CategoryBean> lstCategories = categoryService.getAllCategories("");
		modelAndView.addObject("LIST_QUES", lstQuestions);
		modelAndView.addObject("LIST_CAT", lstCategories);
		modelAndView.setViewName("questions");
		return modelAndView;
	}
	
	@RequestMapping(value = "/saveQues" , method = RequestMethod.POST)
	public ModelAndView saveQuestion(@ModelAttribute("ques") QuestionBean questionBean,@RequestParam("categoryId") int categoryId) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Question Controller...");
		CategoryBean categoryBean = categoryService.getCategoryInfoById(categoryId);
		questionBean.setCategoryBean(categoryBean);
		questionService.addQuestion(questionBean);
		modelAndView.setViewName("redirect:showques");
		return modelAndView;
	}
}
