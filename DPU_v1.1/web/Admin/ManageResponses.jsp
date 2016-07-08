<%@page import="dpu.services.admin.ResponseServicesImpl"%>
<%@page import="dpu.services.admin.ResponseServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.ResponseBean"%>
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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%

            ResponseServicesDAO objServices = new ResponseServicesImpl();
            List<ResponseBean> lstResponse = null;
            if (request.getParameter("sbtnSearch") != null) {
                String search = request.getParameter("txtSearch");
                lstResponse = objServices.getAllResponses(search, request.getParameter("rbOrderBy"));
            } else {
                lstResponse = objServices.getAllResponses("", request.getParameter("rbOrderBy"));
            }
            pageContext.setAttribute("LIST_RESPONSE", lstResponse);
        %>
        <form>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8 ">
                        <div class="panel">
                            <div class="panel-body">
                                <div align="center"><h2><b>Manage Responses</b></h2></div>
                                <div class="row">
                                    <div class="col-md-2 ">
                                    </div>
                                    <div class="col-md-4 ">
                                        <label class="radio-inline">
                                             <input type="radio" name="rbOrderBy" value="0"/><b></b>&nbsp;&nbsp;
                                            A-Z
                                        </label>
                                        <label class="radio-inline">
                                    <input type="radio" name="rbOrderBy" value="1"/><b></b>&nbsp;&nbsp;
                                            Z-A
                                        </label>
                                        <label class="radio-inline">
                                    <input type="radio" name="rbOrderBy" value="post_date"/><b></b>
                                            Posted Date
                                        </label>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="Request title" name="txtTo" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">



                                            <input class="btn btn-success  " type="submit" name="sbtnSearch" value="Search">




                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 col-xs-6 ">
                                        <table class="table table-hover table-responsive ">

                                            <thead>
                                                <tr>
                                                    <th>S.No.</th>
                                                    <th>Request</th>
                                                    <th>Request Date</th>
                                                    <th>Status</th>
                                                    <th>Links</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_RESPONSE}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.request_title}</td>
                                    <td>${obj.request_date}</td>
                                    <td>${obj.status}</td>
                                    <td><c:choose>
                                            <c:when test="${obj.status.equalsIgnoreCase('pending')}">
                                                <a href="PostResponse.jsp?requestId=${obj.request_id}&requestTitle=${obj.request_title}&requestDate=${obj.request_date}&description=${obj.taDescription}">Post Response</a>
                                            </c:when>
                                            <c:otherwise>
                                                Response Posted
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
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


            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            <!--            <table align="center" cellpadding="5">
            
                            <tr>
                                <td align="center">
                                    <strong>
                                        Manage Responses
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
                                    <table align="center" width="100%">
                                        <tr>
                                            <td align="center">
                                                <input type="radio" name="rbOrderBy" value="0"/><b>A-Z</b>&nbsp;&nbsp;
                                                <input type="radio" name="rbOrderBy" value="1"/><b>Z-A</b>&nbsp;&nbsp;
                                                <input type="radio" name="rbOrderBy" value="post_date"/><b>Posted Date</b>
                                            </td>
                                            <td align="left">
                                                <input type="text" class="txtStyle" name="txtSearch"/>
                                                <input type="submit" class="button" name="sbtnSearch" value="Search"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td> 
                            </tr>
                            <tr>
                                <td>
                                    <table align="center" style="border-collapse: collapse" border="1" width = 100%>
                                        <tr>
                                            <th>
                                                S.No.
                                            </th>
                                            <th>
                                                Request
                                            </th>
                                            <th>
                                                Request Date
                                            </th>
                                            <th>
                                                Status
                                            </th>
                                            <th>
                                                Links
                                            </th>
                                        </tr>
            <c:forEach items="${LIST_RESPONSE}" var="obj" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${obj.request_title}</td>
                    <td>${obj.request_date}</td>
                    <td>${obj.status}</td>
                    <td><c:choose>
                    <c:when test="${obj.status.equalsIgnoreCase('pending')}">
                        <a href="PostResponse.jsp?requestId=${obj.request_id}&requestTitle=${obj.request_title}&requestDate=${obj.request_date}&description=${obj.taDescription}">Post Response</a>
                    </c:when>
                    <c:otherwise>
                        Response Posted
                    </c:otherwise>
                </c:choose>
            </td>
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
