<%@page import="dpu.services.dealers.OrderServicesImpl"%>
<%@page import="dpu.services.dealers.OrderServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.dealers.OrderItembean"%>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.dealers.OrderBean"%>
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
            OrderBean obj = objServices.getUserInfoById(Integer.parseInt(request.getParameter("order_id")));

            pageContext.setAttribute("obj", obj);
            List<OrderItembean> lstOrderedItems = objServices.getAllOrdersItemsByOrderId(request.getParameter("order_id"));
            pageContext.setAttribute("LIST_ORDERS", lstOrderedItems);
        %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8 ">
                    <div class="panel panel-success">
                        <div class="panel-body">
                            <div align="center"><h2><b>View Order Details</b></h2></div>
                            <div class="row">
                                <div class="col-md-2 ">
                                    <b>Order Title :</b>
                                </div>
                                <div class="col-md-10 ">
                                    ${obj.order_title}
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2 ">
                                    <b>Order Date :</b>
                                </div>
                                <div class="col-md-10 ">
                                    ${obj.order_date}
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2 ">
                                    <b>Last Updated :</b>
                                </div>
                                <div class="col-md-10 ">
                                    ${obj.last_update_date}
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2 ">
                                    <b>Order Status :</b>
                                </div>
                                <div class="col-md-10 ">
                                    ${obj.order_status}
                                </div>
                            </div>
                        </div>
                        <div class=" panel-heading">
                            Order Details
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-12 col-xs-6 ">
                                    <table class="table table-hover table-responsive ">

                                        <thead>
                                            <tr>
                                                <th>
                                                    S.No.
                                                </th>
                                                <th>
                                                    Product Name
                                                </th>
                                                <th>
                                                    Price
                                                </th>
                                                <th>
                                                    Quantity
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${LIST_ORDERS}" var="obji" varStatus="i">
                                                <tr>
                                                    <td>${i.index+1}</td>
                                                    <td>${obji.product_title}</td>
                                                    <td>${obji.price}</td>
                                                    <td>${obji.quantity}</td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-md-8 " align="right"> 
                                    <b>Total Estimate Amt : </b>
                                </div>
                                <div class="col-md-4 " align="left">
                                    -Rs.${obj.totalAmount}
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-md-12 " align="right"> 
                                    <input type="button" name="btnBack" value="Cancel" class="btn btn-success" onclick="history.go(-1)"/>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>













<!--        <table align="center" cellpadding="5">
            <tr>
                <td align="center" colspan="2">
                    <strong>View Order Details</strong>
                </td>
            </tr>
            <tr>
                <td>
                    <fieldset>
                        <table width="100%">
                            <tr>
                                <td>
                                    <table>
                                        <tr>
                                            <td>
                                                <b>Order Title :</b>${obj.order_title}
                                            </td>
                                        </tr>
                                        <tr><td><b>Order Date :</b>${obj.order_date}</td></tr>
                                        <tr><td><b>Last Updated :</b>${obj.last_update_date}</td></tr>
                                        <tr><td><b>Order Status :</b>${obj.order_status}</td></tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <fieldset>
                                        <legend>
                                            <b>Order Details</b>
                                        </legend>
                                        <table width="100%" style="border-collapse: collapse; border-style: inset; margin-top: 20px" border="1">
                                            <tr>
                                                <th>
                                                    S.No.
                                                </th>
                                                <th>
                                                    Product Name
                                                </th>
                                                <th>
                                                    Price
                                                </th>
                                                <th>
                                                    Quantity
                                                </th>
                                            </tr>
                                            <c:forEach items="${LIST_ORDERS}" var="obji" varStatus="i">
                                                <tr>
                                                    <td>${i.index+1}</td>
                                                    <td>${obji.product_title}</td>
                                                    <td>${obji.price}</td>
                                                    <td>${obji.quantity}</td>

                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </fieldset>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <table>
                                        <tr>
                                            <td><b>Total Estimate Amt</b>:-Rs.${obj.totalAmount}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right" colspan="2">
                                                <input type="button" name="btnBack" value="Cancel" class="button" onclick="history.go(-1)"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
        </table>-->
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
