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
			document.getElementById("frm1").action = "updateCat";
			$("#modelTitle").html("Edit Category");		
		}
		else if(field == 'add') {
			document.getElementById("btnSave").value = "Save";			
			$("#modelTitle").html("Add New Category");		
		}
	}
</script>
<script type="text/javascript">
        function onClickMethod(catId){
        	if(catId != 0) {
        		alert(catId);
				$.get("getCat/catId",{"catId" : catId}, function(data) {
					alert(data.title + " ::title");
	            	document.getElementById('title').value = data.title;
		            document.getElementById('categoryid').value = data.categoryId;
		            if(data.status == 1) {
		               	document.getElementById('status').selectedIndex = 0;            		
		            }
		            else {
		               	document.getElementById('status').selectedIndex = 1;            		            		
		            }
            	});
        	}
        	else {
           		document.getElementById('title').value = "";
           		document.getElementById('status').selectedIndex = 0;            		
        	}	
        }
</script>
</head>
<body>
	<%
		List<CategoryBean> lstCategory = ((List<CategoryBean>) request.getAttribute("LIST_CAT"));
		pageContext.setAttribute("LIST_CAT1", lstCategory);
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	
		<div class="row">
			<div class="col-sm-12">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="checkFlag('add');onClickMethod('0')" >Add New</button>
					<div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog">

					      <!-- Modal content-->
					      	<form action="saveCat" method="POST" name="cat" id="frm1">
							<input type="hidden" id = "addUpdateFlag" value = "" />
							<input type="hidden" id = "categoryid" name = "categoryid" value = "" />					      
					      <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title"><p id ="modelTitle">Add New Category</p></h4>
											
					        </div>
					        <div class="modal-body">
					        	
								<div class = "row">
									<div class="col-sm-12">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													 <i class="glyphicon glyphicon-inbox"></i>												
												</span>
												<input type="text" class="form-control" placeHolder="Enter CategoryName" id="title" name="title" value="" />
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													 <i class="glyphicon glyphicon-list-alt"></i>												
												</span>
												<select class="form-control" name="status" id="status">
													<option value="1">Active</option>
													<option value="0">Inactive</option>
												</select>
											</div>
										</div>
									</div>
					        	</div>
					        </div>
					        <div class="modal-footer">
					          <input type="button" class="btn btn-primary" data-dismiss="modal" value="Save" id="btnSave" />
							  <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					        </div>
					      </div>
					      </form>
					    </div>
					  </div>
					 
			</div>
		</div>
		<div class="table-responsive">
			<table class="table table-striped table-hover table-condensed">
				<thead>
					<tr>
						<th>Title</th>
						<th>Status</th>
						<th>Links</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${LIST_CAT1}" var="obj">
						<c:if test="${obj ne null}">
							<tr class="info">
								<td>${obj.title}</td>
								<td>${obj.status}</td>
								<c:if test="${obj.status == 1}">
									<c:set var="status" value="0"/>
								</c:if>
								<c:if test="${obj.status == 0}">
									<c:set var="status" value="1"/>
								</c:if>
								<td><a href = "#" data-toggle="modal" data-target="#myModal" onclick="checkFlag('update');onClickMethod('${obj.categoryId}')">Update</a> / <a href="deleteCat/sta/${status}/catId/${obj.categoryId}">Delete</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>