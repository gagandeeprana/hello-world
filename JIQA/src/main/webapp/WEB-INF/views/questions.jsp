<%@page import="com.jiqa.beans.QuestionBean"%>
<%@page import="com.jiqa.service.impl.CategoryServiceImpl"%>
<%@page import="com.jiqa.beans.CategoryBean"%>
<%@page import="java.util.List"%>
<%@page import="com.jiqa.service.CategoryService"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/jssor.slider.mini.js"></script>
</head>
<body>
<form action="showques" method="GET">
	<%
		List<QuestionBean> lstQuestions = ((List<QuestionBean>) request.getAttribute("LIST_QUES"));
		pageContext.setAttribute("LIST_QUES", lstQuestions);
		List<CategoryBean> lstCategories = ((List<CategoryBean>) request.getAttribute("LIST_CAT"));
		pageContext.setAttribute("LIST_CAT", lstCategories);
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<input type="text" name="question" placeholder="Write Question to Search..." class="form-control" />
			</div>
			<div class="col-sm-4">
				<input type="text" name="answer" placeholder="Write Answer to Search..." class="form-control" />
			</div>
			<div class="col-sm-2">
				<select class="form-control">
					<option value="0">Select</option>
					<c:forEach items="${LIST_CAT}" var="obj">
						<option value="${obj.categoryId}">${obj.title}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-2">
				<input type="submit" value="Search" class="btn btn-primary" />
			</div>
		</div>
	</div>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-striped table-hover table-condensed">
				<thead>
					<tr>
						<th>Question</th>
						<th>Answer</th>
						<th>Status</th>
						<th>Category</th>
						<th>Links</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${LIST_QUES}" var="obj">
						<tr class="info">
							<td>${obj.question}</td>
							<td>${obj.answer}</td>
							<td>${obj.status}</td>
							<td>${obj.categoryBean.title}</td>
							<td><a>Update</a> / <a>Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</form>
</body>
</html>