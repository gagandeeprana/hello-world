package com.jiqa.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryBean")
	private Set<QuestionBean> setOfQuestionBeans;
}
