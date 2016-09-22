package com.jiqa.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorymaster")
@Getter
@Setter
public class QuestionBean {

	@Id
	@GeneratedValue
	@Column(name = "question_id")
	private int questionId;

	@Column(name = "question")
	private String question;

	@Column(name = "answer")
	private String answer;

	@Column(name = "status")
	private int status;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CategoryBean categoryBean;
}
