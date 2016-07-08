
<%@page import="dpu.services.admin.ProcessedOrdersServicesImpl"%>
<%@page import="dpu.services.admin.ProcessedOrdersServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.ProcessedOrdersBean"%>
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
        <% ProcessedOrdersServicesDAO objServices = new ProcessedOrdersServicesImpl();

            List<ProcessedOrdersBean> lstProcessedOrders = null;
            if (request.getParameter("sbtnFilter") != null) {
                String st = request.getParameter("txtFrom");
                String et = request.getParameter("txtTo");
                String search = request.getParameter("txtOrderTitle");
                String status = request.getParameter("ddlStatus");
                String order = request.getParameter("ddlOrderBy");
                lstProcessedOrders = objServices.getAllProcessedOrders(st, et, search, status, order);
                pageContext.setAttribute("ob_" + order, "selected='selected'");
                pageContext.setAttribute("st_" + status, "selected='selected'");
            } else {
                lstProcessedOrders = objServices.getAllProcessedOrders("", "", "", "All", "0");
            }
            pageContext.setAttribute("LIST_PORDERS", lstProcessedOrders);
        %>
        <form>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8 ">
                        <div class="panel panel-success">
                            <div class="panel-body">
                                <div align="center"><h2><b>Manage Processed Orders</b></h2></div>
                                <div class="row">
                                    <div class="col-md-2">
                                        <div class="form-group ">
                                            <select name="ddlOrderBy" class="form-control">
                                                <option value="0" ${ob_0}>Select</option>
                                                <option value="1" ${ob_1}>Processed Date</option>
                                                <option value="2" ${ob_2}>Dispatch Date</option>
                                            </select>

                                        </div>



                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <select name="ddlStatus" class="form-control">
                                                <option value="All" ${st_All}>All</option>
                                                <option value="Processed" ${st_Processed}>Processed</option>
                                                <option value="Dispatched" ${st_Dispatched}>Dispatched</option>
                                            </select>




                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="From" name="txtSearch" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="To" name="txtSearch" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="Title" name="txtSearch" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-1">
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
                                                        Order Title
                                                    </th>
                                                    <th>
                                                        Processed Date
                                                    </th>
                                                    <th>
                                                        Dispatch Date
                                                    </th>
                                                    <th>
                                                        Amount
                                                    </th>
                                                    <th>
                                                        Links
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                              <c:forEach items="${LIST_PORDERS}" var="obj" varStatus="i">
                                <td>${i.index+1}</td>
                                <td>${obj.order_title}</td>
                                <td>${obj.processed_date}</td>
                                <td>${obj.dispatch_date}</td>
                                <td>${obj.amount}</td>

                                <td>
                                    <c:choose>
                                        <c:when test="${obj.order_status.equalsIgnoreCase('dispatched')}">
                                            Order Dispatched          
                                        </c:when>
                                        <c:otherwise>
                                            <a href="DispatchOrder.jsp?order_id=${obj.order_id}">Dispatch Order</a>
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




















<!--
            <table align="center" cellpadding="5">
                <tr>
                    <td colspan="5">
                        ${param.msg}
                    </td>
                </tr>
                <tr>                                            
                    <td align="center">
                        <strong>
                            Manage Processed Orders
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
                    <td align="right">
                        <table width="100%" >
                            <tr>
                                <td  colspan="4" align="right"><b>OrderBy</b>
                                    <select name="ddlOrderBy">
                                        <option value="0" ${ob_0}>Select</option>
                                        <option value="1" ${ob_1}>Processed Date</option>
                                        <option value="2" ${ob_2}>Dispatch Date</option>
                                    </select>

                                    <b>&nbsp;Status</b>
                                    <select name="ddlStatus">
                                        <option value="All" ${st_All}>All</option>
                                        <option value="Processed" ${st_Processed}>Processed</option>
                                        <option value="Dispatched" ${st_Dispatched}>Dispatched</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><b>From</b> 
                                    <input type="text" class="txtStyle" name="txtFrom"/>
                                </td>
                                <td><b>To</b> 
                                    <input type="text" class="txtStyle" name="txtTo"/>
                                </td>
                                <td>
                                    <b>Title</b><input type="text" class="txtStyle" name="txtOrderTitle"/>
                                </td>
                                <td>
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
                                    Processed Date
                                </th>
                                <th>
                                    Dispatch Date
                                </th>
                                <th>
                                    Amount
                                </th>
                                <th>
                                    Links
                                </th>

                            </tr>
                            <c:forEach items="${LIST_PORDERS}" var="obj" varStatus="i">
                                <td>${i.index+1}</td>
                                <td>${obj.order_title}</td>
                                <td>${obj.processed_date}</td>
                                <td>${obj.dispatch_date}</td>
                                <td>${obj.amount}</td>

                                <td>
                                    <c:choose>
                                        <c:when test="${obj.order_status.equalsIgnoreCase('dispatched')}">
                                            Order Dispatched          
                                        </c:when>
                                        <c:otherwise>
                                            <a href="DispatchOrder.jsp?order_id=${obj.order_id}">Dispatch Order</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                    </tr>
                </c:forEach>
            </table>-->
<!--        </td>
    </tr>
</table>-->
</form>
<jsp:include page="mp_footer.jsp"/>
</body>
</html>
