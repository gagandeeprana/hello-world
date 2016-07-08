<%@page import="dpu.services.admin.OrderServicesImpl"%>
<%@page import="dpu.services.admin.OrderServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.OrdersBean"%>
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
        <% OrderServicesDAO objServices = new OrderServicesImpl();
            List<OrdersBean> lstOrders = null;
            if (request.getParameter("sbtnFilter") != null) {
                String st = request.getParameter("txtFrom");
                String et = request.getParameter("txtTo");
                String status = request.getParameter("ddlStatus");
                String order = request.getParameter("ddlOrderBy");
                lstOrders = objServices.getAllOrders(st, et, status, order);
            } else {
                lstOrders = objServices.getAllOrders("", "", "", "");
            }
            pageContext.setAttribute("LIST_ORDERS", lstOrders);
            pageContext.setAttribute("st_" + request.getParameter("ddlStatus"), "selected='selected'");
        %>
        <form>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8 ">
                        <div class="panel panel-success">
                            <div class="panel-body">
                                <div align="center"><h2><b>Manage Orders</b></h2></div>
                                <div class="row">
                                    <div class="col-md-2">
                                        <div class="form-group ">
                                            <select name="ddlOrderBy" class="form-control">
                                        <option value="0">Select</option>
                                        <option value="1">Date</option>
                                        <option value="2">A-Z</option>
                                        <option value="3">Z-A</option>
                                    </select>		

                                        </div>



                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <select name="ddlStatus" class="form-control">
                                        <option value="0" ${st_0}>All</option>
                                        <option value="1" ${st_1}>Pending</option>
                                        <option value="2" ${st_2}>Cancel</option>
                                    </select>




                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="From" name="txtFrom"/>




                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">

                                            <input type="text" class="form-control" placeholder="To" name="txtTo"/>






                                        </div>
                                    </div>
                                    <div class="col-md-1">
                                        <div class="form-group">



                                             <input type="submit" class="btn btn-success" name="sbtnFilter" value="Filter"/>
                            



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
                                                        Order Title
                                                    </th>
                                                    <th>
                                                        Order Date
                                                    </th>
                                                    <th>
                                                        Dealer
                                                    </th>
                                                    <th>
                                                        Status
                                                    </th>
                                                    <th>
                                                        Links
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_ORDERS}" var="obj" varStatus="i">
                                                <td>${i.index+1}</td>
                                                <td>${obj.order_title}</td>
                                                <td>${obj.order_date}</td>
                                                <td>${obj.dealer}</td>
                                                <td>${obj.status}</td>
                                                <td>
                                                    <c:choose>

                                                        <c:when test="${obj.status.equalsIgnoreCase('pending')}">
                                                            <a href="ViewAndProcessOrders.jsp?order_id=${obj.order_id}">View & Process</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            Processed
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
                        </div>
                    </div>
                    <div class="col-md-2">

                    </div>
                </div>
            </div>




















<!--            <table align="center" cellpadding="5">
                <tr>
                    <td colspan="5">
                        ${param.msg}
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <strong>
                            Manage Orders
                        </strong><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label id="lblMsg" style="color:red">
                            <small>lblMsg</small>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table width="100%">

                            <tr>
                                <td align='right'>
                                    <b>Order By</b> <select name="ddlOrderBy">
                                        <option value="0">Select</option>
                                        <option value="1">Date</option>
                                        <option value="2">A-Z</option>
                                        <option value="3">Z-A</option>
                                    </select>	
                                    <b>Status</b>
                                    <select name="ddlStatus">
                                        <option value="0" ${st_0}>All</option>
                                        <option value="1" ${st_1}>Pending</option>
                                        <option value="2" ${st_2}>Cancel</option>
                                    </select>
                                    <b>From</b><input type="text" class="txtStyle" name="txtFrom"/>
                                    <b>To</b><input type="text" class="txtStyle" name="txtTo"/>


                                    <input type="submit" class="button" name="sbtnFilter" value="Filter"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table width="100%" style="border-collapse: collapse; border-style: inset" border="1">
                            <tr>
                                <th>
                                    S.No.
                                </th>
                                <th>
                                    Order Title
                                </th>
                                <th>
                                    Order Date
                                </th>
                                <th>
                                    Dealer
                                </th>
                                <th>
                                    Status
                                </th>
                                <th>
                                    Links
                                </th>

                            </tr>
                            <c:forEach items="${LIST_ORDERS}" var="obj" varStatus="i">
                                <td>${i.index+1}</td>
                                <td>${obj.order_title}</td>
                                <td>${obj.order_date}</td>
                                <td>${obj.dealer}</td>
                                <td>${obj.status}</td>
                                <td>
                                    <c:choose>

                                        <c:when test="${obj.status.equalsIgnoreCase('pending')}">
                                            <a href="ViewAndProcessOrders.jsp?order_id=${obj.order_id}">View & Process</a>
                                        </c:when>
                                        <c:otherwise>
                                            Processed
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
