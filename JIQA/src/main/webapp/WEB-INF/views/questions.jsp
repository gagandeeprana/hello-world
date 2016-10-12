<%@page import="com.jiqa.entity.QuestionBean"%>
<%@page import="com.jiqa.service.impl.CategoryServiceImpl"%>
<%@page import="com.jiqa.entity.CategoryBean"%>
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
<script type="text/javascript">
	$(document).ready(function(){
		$('#btnSave').click(function(){
			$('#frm1').submit();
		});
	});
</script>
<script type="text/javascript">
	function checkFlag(field) {
		document.getElementById("addUpdateFlag").value = field;
		if(field == 'update') {
			document.getElementById("btnSave").value = "Update";
			document.getElementById("frm1").action = "updateQues";
			$("#modelTitle").html("Edit Question");		
		}
		else if(field == 'add') {
			document.getElementById("btnSave").value = "Save";			
			$("#modelTitle").html("Add New Question");		
		}
	}
</script>
<script type="text/javascript">
        function onClickMethod(quesId){
        	if(catId != 0) {
				$.get("getQues/quesId",{"quesId" : quesId}, function(data) {
	            	document.getElementById('question').value = data.question;
		            document.getElementById('quesid').value = data.quesId;
		            if(data.status == 1) {
		               	document.getElementById('status').selectedIndex = 0;            		
		            }
		            else {
		               	document.getElementById('status').selectedIndex = 1;            		            		
		            }
            	});
        	}
        	else {
           		document.getElementById('question').value = "";
           		document.getElementById('status').selectedIndex = 0;            		
        	}	
        }
</script>
</head>
<body>
	<%
		List<QuestionBean> lstQuestions = ((List<QuestionBean>) request.getAttribute("LIST_QUES"));
		pageContext.setAttribute("LIST_QUES", lstQuestions);
		List<CategoryBean> lstCategories = ((List<CategoryBean>) request.getAttribute("LIST_CAT"));
		pageContext.setAttribute("LIST_CAT", lstCategories);
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="checkFlag('add','0')" >Add New</button>
					<input type="hidden" id = "addUpdateFlag" value = "" />					
					<div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog">

					      <!-- Modal content-->
					      <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title"><p id ="modelTitle">Add New Question</p></h4>
					        </div>
					        <div class="modal-body">
								<form action="saveQues" method="POST" name="ques" id="frm1">
								<div class = "row">
									<div class="col-sm-12">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													 <i class="glyphicon glyphicon-inbox"></i>												
												</span>
												<input type="text" class="form-control" placeHolder="Enter Question..." id="question" name="question" value="" />
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													 <i class="glyphicon glyphicon-inbox"></i>												
												</span>
												<input type="text" class="form-control" placeHolder="Enter Answer" id="answer" name="answer" value="" />
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													 <i class="glyphicon glyphicon-list-alt"></i>												
												</span>
												<select class="form-control" name="status">
													<option value="1">Active</option>
													<option value="0">Inactive</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													 <i class="glyphicon glyphicon-list"></i>												
												</span>
												<select class="form-control" name="categoryId">
													<c:forEach items="${LIST_CAT}" var="obj">
														<option value="${obj.categoryId}">${obj.title}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
					        	</div>
					        </div>
					        	 </form>
					        <div class="modal-footer">
					          <input type="button" class="btn btn-primary" data-dismiss="modal" value="Save" id="btnSave" onclick="submitForm()" />
							  <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					        </div>
					      </div>
					      
					    </div>
					  </div>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<input type="text" name="question" placeholder="Write Question to Search..." class="form-control" />
			</div>
			<div class="col-sm-4">
				<input type="text" name="answer" placeholder="Write Answer to Search..." class="form-control" />
			</div>
			<div class="col-sm-2">
				<select class="form-control" name="categoryId">
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
</body>
</html>