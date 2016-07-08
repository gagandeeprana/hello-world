<%@page import="dpu.services.dealers.RequestServicesImpl"%>
<%@page import="dpu.services.dealers.RequestServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.dealers.RequestBean"%>
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
            RequestServicesDAO objServices = new RequestServicesImpl();
            List<RequestBean> lstUsers = null;
            String userId = session.getAttribute("userId").toString();
            if (request.getParameter("sbtnSearch") != null) {
                String search = request.getParameter("txtSearch");
                lstUsers = objServices.getAllRequest(search, userId);
            } else {
                lstUsers = objServices.getAllRequest("", userId);
            }
            pageContext.setAttribute("LIST_REQUEST", lstUsers);
        %>
        <form action="ManageRequest.jsp">
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
                                        <input type="button" name="sbtnPostRequest" value="Post Request" class="btn btn-success" onclick="window.location = 'PostRequest.jsp'"/>
                                    </div>
                                    <div class="col-md-4 ">
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
                                                    <th>
                                                        S.No.
                                                    </th>
                                                    <th>
                                                        Request
                                                    </th>
                                                    <th>
                                                        Date
                                                    </th>
                                                    <th>
                                                        Status
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_REQUEST}" var="obj" varStatus="i">
                                                <tr>
                                                    <td>${i.index+1}</td>
                                                    <td><a href="ViewResponse.jsp?request_id=${obj.request_id}">${obj.request_title}</a></td>
                                                    <td>${obj.request_date}</td>
                                                    <td>${obj.status}</td>

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


 
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
<!--            <table align="center">
                <tr><td colspan="2" align="center"><strong>Manage Request</strong></td></tr>
                <tr>
                    <td>
                        <label id="lblMsg" style="color:red">
                            <small>${param.result}</small>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table width="100%" align="center">
                            <tr>
                                <td>
                                    <input type="button" name="sbtnPost" value="PostRequest" class="button" onclick="window.location = 'PostRequest.jsp'"/>
                                </td>
                                <td align="right">
                                    <input type="text" name='txtSearch' class="txtStyle"/>
                                    <input type="submit" name="sbtnSearch" value="Search" class="button"/>               
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table align="center" width="100%">
                            <tr>
                                <td>
                                    <table width="100%" border="1" style="border-collapse:collapse" align="center">
                                        <thead>
                                            <tr>
                                                <th>S.no</th>
                                                <th>Request</th>
                                                <th>Date</th>
                                                <th>Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${LIST_REQUEST}" var="obj" varStatus="i">
                                                <tr>
                                                    <td>${i.index+1}</td>
                                                    <td><a href="ViewResponse.jsp?request_id=${obj.request_id}">${obj.request_title}</a></td>
                                                    <td>${obj.request_date}</td>
                                                    <td>${obj.status}</td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>-->
            <jsp:include page="mp_footer.jsp"/>
        </form>
    </body>
</html>
