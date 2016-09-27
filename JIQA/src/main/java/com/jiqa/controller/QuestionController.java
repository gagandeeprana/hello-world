package com.jiqa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jiqa.beans.CategoryBean;
import com.jiqa.beans.QuestionBean;
import com.jiqa.service.CategoryService;
import com.jiqa.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/showques", method = RequestMethod.GET)
	public ModelAndView showCategoryScreen() {
		ModelAndView modelAndView = new ModelAndView();
		List<QuestionBean> lstQuestions = questionService.getAllQuestions("", "", 0);
		List<CategoryBean> lstCategories = categoryService.getAllCategories("");
		modelAndView.addObject("LIST_QUES", lstQuestions);
		modelAndView.addObject("LIST_CAT", lstCategories);
		modelAndView.setViewName("questions");
		return modelAndView;
	}
}
