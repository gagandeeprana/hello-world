package com.jiqa.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name = "categorymaster")
@JsonSerialize
public class CategoryBean {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int categoryId;

	
	@Column(name = "title")
	private String title;

	@Column(name = "status")
	private int status;

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoryBean", cascade=CascadeType.ALL)
//	private Set<QuestionBean> questions;

	public int getCategoryId() {
		return categoryId;
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
