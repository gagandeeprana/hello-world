<%@page import="dpu.services.dealers.OrderServicesImpl"%>
<%@page import="dpu.services.dealers.OrderServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.dealers.OrderBean"%>
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
            OrderServicesDAO objServices = new OrderServicesImpl();
            List<OrderBean> lstOrders = null;
            if (session.getAttribute("LIST_ITEMS") != null) {
                session.removeAttribute("LIST_ITEMS");
            }
            if (request.getParameter("sbtnFilter") != null) {
                String status = request.getParameter("ddlStatus");
                String from = request.getParameter("txtFrom");
                String to = request.getParameter("txtTo");
                lstOrders = objServices.getAllOrders(from, to, status);
                pageContext.setAttribute("status_" + request.getParameter("ddlStatus"), "selected");
            } else {
                lstOrders = objServices.getAllOrders("", "", "0");
            }
            pageContext.setAttribute("LIST_ORDERS", lstOrders);
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
                                            <input type="button" name="btnPlaceOrder" value="Place Order" class="btn btn-success" onclick="window.location = 'PlaceNewOrder.jsp'"/>


                                        </div>



                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="From" name="txtSearch" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="To" name="txtSearch" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <select name="ddlStatus" class="form-control">
                                                <option value="0">All</option>
                                                <option value="Cancelled" ${status_Cancelled}>Cancelled</option>
                                                <option value="Pending" ${status_Pending}>Pending</option>
                                                <option value="Dispatched" ${status_Dispatched}>Dispatched</option>
                                            </select>




                                        </div>
                                    </div>
                                    <div class="col-md-1">
                                        <div class="form-group">


                                            <input type="submit" name="sbtnFilter" value="Filter" class="btn btn-success"/>




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
                                                        Order Status
                                                    </th>
                                                    <th>
                                                        Links
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_ORDERS}" var="obj" varStatus="i">
                                                    <tr>
                                                        <td>${i.index+1}</td>
                                                        <td>${obj.order_title}</td>
                                                        <td>${obj.order_date}</td>
                                                        <td>${obj.order_status}</td>
                                                        <td><a href="ViewOrderDetails.jsp?order_id=${obj.order_id}">View</a></td>
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
                                <td align="center">
                                    <strong>
                                        Manage Orders
                                    </strong>
                                    <br/>
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
                                            <td valign="top">
                                                <input type="button" name="btnPlaceOrder" value="Place Order" class="button" onclick="window.location = 'PlaceNewOrder.jsp'"/>
            
                                            </td>
                                            <td align="right">
                                                <b>From</b><input type="text" name="txtFrom" class="txtStyle"/>
                                                <b>To</b><input type="text" name="txtTo" class="txtStyle"/>
                                                <b>Status</b>
                                                <select name="ddlStatus">
                                                    <option value="0">All</option>
                                                    <option value="Cancelled" ${status_Cancelled}>Cancelled</option>
                                                    <option value="Pending" ${status_Pending}>Pending</option>
                                                    <option value="Dispatched" ${status_Dispatched}>Dispatched</option>
                                                </select>
                                                <input type="submit" name="sbtnFilter" value="Filter" class="button"/>
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
                                                Order Status
                                            </th>
                                            <th>
                                                Links
                                            </th>
                                        </tr>
            <c:forEach items="${LIST_ORDERS}" var="obj" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${obj.order_title}</td>
                    <td>${obj.order_date}</td>
                    <td>${obj.order_status}</td>
                    <td><a href="ViewOrderDetails.jsp?order_id=${obj.order_id}">View</a></td>
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
