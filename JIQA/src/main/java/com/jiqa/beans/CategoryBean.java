package com.jiqa.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorymaster")
@Getter
@Setter
public class CategoryBean {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "title")
	private String title;

	@Column(name = "status")
	private int status;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="categoryBean")
	private Set<QuestionBean> setOfQuestionBeans;
}
