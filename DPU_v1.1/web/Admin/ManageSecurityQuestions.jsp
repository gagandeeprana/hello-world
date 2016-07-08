<%@page import="dpu.services.admin.SecurityQuestionServicesImpl"%>
<%@page import="dpu.services.admin.SecurityQuestionServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.QuestionsBean"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <jsp:include page="stylesheet.jsp"/>
        <title>TODO supply a title</title>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <% SecurityQuestionServicesDAO objServices = new SecurityQuestionServicesImpl();
            List<QuestionsBean> lstQuestions;
            if (request.getParameter("ddlStatus") != null) {
                lstQuestions = objServices.getAllQuestions(Integer.parseInt(request.getParameter("ddlStatus")));
                pageContext.setAttribute("st_" + request.getParameter("ddlStatus"), "selected");
            } else {
                lstQuestions = objServices.getAllQuestions(2);
            }
            pageContext.setAttribute("LIST_QUESTIONS", lstQuestions);
        %>
        <form id="frm" action="ManageSecurityQuestions.jsp">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8 ">
                    <div class="panel">
                    <div class="panel-body">
                        <div align="center"><h2><b>Manage Security Question</b></h2></div>
                        <div class="row">
                            <div class="col-md-9">
                                <div class="form-group ">
                                    <input class="btn btn-success " type="button" name="sbtnSearch" value="Add Security Question" onclick="window.location = 'AddSecurityQuestion.jsp'">


                                </div>



                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <select name="ddlStatus" onchange="submit()" class="form-control">
                                        <option value="2" ${st_2}>Select</option>
                                        <option value="1" ${st_1}>Active</option>
                                        <option value="0" ${st_0}>InActive</option>
                                    </select>




                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 col-xs-6 ">
                                <table class="table table-hover table-responsive ">

                                    <thead>
                                        <tr>
                                            <th>S.no</th>
                                            <th>Question</th>
                                            <th>Status</th>
                                            <th>Links</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                     <c:forEach items="${LIST_QUESTIONS}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.question}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${obj.status==0}">
                                                <c:set var="status" value="InActive"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="status" value="Active"></c:set>
                                            </c:otherwise>
                                        </c:choose>

                                        <a href="ControllerSQ.jsp?questionId=${obj.qId}&status=${obj.status}">${status}</a></td>
                                    <td><a href="EditSecurityQuestion.jsp?qId=${obj.qId}">View & Edit</a></td>
                                </tr>
                            </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">

                    </div>
                </div>
                </div>
                </div>
            </div>


            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
<!--            <table align="center" cellpadding="5" width="60%">
                <tr>
                    <td align="center">
                        <strong>
                            Manage Security Question
                        </strong>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label id="lblMsg" style="color:red">
                            <small>${param.msg}</small>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table width="100%" align="center" >
                            <tr>
                                <td>
                                    <input type="button" class="button" onclick="window.location = 'AddSecurityQuestion.jsp'" name="sbtnAddSecurityQuestion" value="Add Security Question"/>
                                </td>
                                <td align="right">
                                    <label><b>Status</b></label>
                                    <select name="ddlStatus" onchange="submit()">
                                        <option value="2" ${st_2}>Select</option>
                                        <option value="1" ${st_1}>Active</option>
                                        <option value="0" ${st_0}>InActive</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table style="border-collapse: collapse; border-style: inset" align = "center" width="100%" border="1">
                            <tr>
                                <th>
                                    S.No
                                </th>
                                <th>
                                    Question
                                </th>
                                <th>
                                    Status
                                </th>
                                <th>
                                    Links
                                </th>
                            </tr>

                            <c:forEach items="${LIST_QUESTIONS}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.question}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${obj.status==0}">
                                                <c:set var="status" value="InActive"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="status" value="Active"></c:set>
                                            </c:otherwise>
                                        </c:choose>

                                        <a href="ControllerSQ.jsp?questionId=${obj.qId}&status=${obj.status}">${status}</a></td>
                                    <td><a href="EditSecurityQuestion.jsp?qId=${obj.qId}">View & Edit</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
