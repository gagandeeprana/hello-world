package com.jiqa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "categorymaster")
public class CategoryBean {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int categoryId;

	
	@Column(name = "title")
	private String title;

	@Column(name = "status")
	private int status;
	
	@Column(name = "image_name")
	private String imageName;

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoryBean", cascade=CascadeType.ALL)
//	private Set<QuestionBean> questions;

	public int getCategoryId() {
		return categoryId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

//	public Set<QuestionBean> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(Set<QuestionBean> questions) {
//		this.questions = questions;
//	}
}
