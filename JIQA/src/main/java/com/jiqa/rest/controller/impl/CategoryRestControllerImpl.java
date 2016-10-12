package com.jiqa.rest.controller.impl;


import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jiqa.beans.CategoryBean;
import com.jiqa.rest.controller.CategoryRestController;
import com.jiqa.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryRestControllerImpl implements CategoryRestController{

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
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
}
