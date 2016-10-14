package com.jiqa.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiqa.entity.CategoryBean;
import com.jiqa.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	Logger logger = Logger.getLogger(CategoryController.class);
	
	@RequestMapping(value = "/showcat", method = RequestMethod.GET)
	public ModelAndView showCategoryScreen() {
		ModelAndView modelAndView = new ModelAndView();
		List<CategoryBean> lstCategories = categoryService.getAllCategories("");
		modelAndView.addObject("LIST_CAT", lstCategories);
		modelAndView.setViewName("category");
		return modelAndView;
	}
	
	@RequestMapping(value = "/saveCat" , method = RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("cat") CategoryBean categoryBean) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView();
			System.out.println(categoryBean.getTitle() + "   " + categoryBean.getStatus());
			categoryService.addCategory(categoryBean);
			modelAndView.setViewName("redirect:/showcat");
		} catch (Exception e) {
			System.out.println("CategoryController: Exception is: " + e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateCat" , method = RequestMethod.POST)
	public ModelAndView updateCategory(@ModelAttribute("cat") CategoryBean categoryBean, @RequestParam("categoryid") int categoryId) {
		ModelAndView modelAndView = new ModelAndView();
		categoryBean.setCategoryId(categoryId);
		categoryService.updateCategory(categoryBean);
		modelAndView.setViewName("redirect:showcat");
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteCat/sta/{sta}/catId/{catId}" , method = RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("catId") int categoryId,@PathVariable("sta") int status) {
		ModelAndView modelAndView = new ModelAndView();
		categoryService.softDeleteCategory(status, categoryId);
		modelAndView.setViewName("redirect:/showcat");
		return modelAndView;
	}
	
	@RequestMapping(value = "getCat/catId" , method = RequestMethod.GET)
	@ResponseBody  public CategoryBean getCategory(@RequestParam("catId") int categoryId) {
		CategoryBean categoryBean = null;
		try {
			categoryBean = categoryService.getCategoryInfoById(categoryId);
		} catch (Exception e) {
			System.out.println(e);
			logger.info("Exception in getCategory is: " + e);
		}
		return categoryBean;
	}
	
}
