package com.jiqa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jiqa.beans.CategoryBean;
import com.jiqa.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/showcat", method = RequestMethod.GET)
	public ModelAndView showCategoryScreen() {
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryBean> lstCategories = categoryService.getAllCategories("");
		System.out.println("BB:  " + lstCategories.size());
		modelAndView.addObject("LIST_CAT", lstCategories);
		modelAndView.setViewName("category");
		return modelAndView;
	}
}
