package com.jiqa.service;

import java.util.List;

import com.jiqa.beans.CategoryBean;

public interface CategoryService {

	public int addCategory(CategoryBean categoryBean);

	public boolean updateCategory(CategoryBean categoryBean);

	public int softDeleteCategory(int status, int categoryId);

	public List<CategoryBean> getAllCategories(String title);

	public CategoryBean getCategoryInfoById(int id);

}
