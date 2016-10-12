package com.jiqa.rest.controller.impl;


import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jiqa.entity.CategoryBean;
import com.jiqa.model.Category;
import com.jiqa.model.Failed;
import com.jiqa.model.Success;
import com.jiqa.rest.controller.CategoryRestController;
import com.jiqa.service.CategoryService;
import com.jiqa.util.HelperUtil;

@RestController
@RequestMapping(value = "/category")
public class CategoryRestControllerImpl implements CategoryRestController{

	@Autowired
	CategoryService categoryService;
	
	@Value("${category_added_code}")
	private String categoryAddedCode;
	
	@Value("${category_added_message}")
	private String categoryAddedMessage;
	
	@Value("${status_not_valid_code}")
	private String statusNotValidCode;
	
	@Value("${status_not_valid_message}")
	private String statusNotValidMessage;
	
	HelperUtil helperUtil = new HelperUtil();
	
	@Override
	public Object getCategories() {
		String json = null;
		try {
			List<CategoryBean> lstCategories = categoryService.getAllCategories("");
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(lstCategories);
		} catch (Exception e) {
			System.out.println(e);
		}
		return json;
	}

	@Override
	public Object addCategory(@RequestBody Category category) {
		String json = null;
		try {
			CategoryBean categoryBean = new CategoryBean();
//			if(category.getTitle() )
			categoryBean.setTitle(category.getTitle());
			categoryBean.setStatus(category.getStatus());
			int categoryId = categoryService.addCategory(categoryBean);
			if(categoryId > 0) {
				return helperUtil.getSuccessJSONString(categoryAddedCode, categoryAddedMessage);
			} 
		} catch (Exception e) {	
			System.out.println(e);
		}
		return json;
	}

	@Override
	public Object softDeleteCategory(@PathVariable("status") int status, @PathVariable("id") int id) {
		try {
			if(status != 0 || status != 1) {
				categoryService.softDeleteCategory(status, id);
			} else {
				Failed error = new Failed(statusNotValidCode, statusNotValidMessage);
				ObjectMapper mapper = new ObjectMapper();
//				json = mapper.writeValueAsString(success);	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
