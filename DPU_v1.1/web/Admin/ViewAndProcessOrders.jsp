<%@page import="dpu.services.admin.ProcessedOrdersKanikaServicesImpl"%>
<%@page import="dpu.services.admin.ProcessedOrdersKanikaServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.admin.OrderDetailsBean"%>
<%@page import="dpu.beans.admin.DealerInfoBean"%>
<%@page import="dpu.beans.admin.ProcessedOrdersBean"%>
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
        <script type="text/javascript" src="../include/validations.js">

        </script>
        <script>
            function check()
            {
                var p = document.getElementById("txtPayment").value;
                var msg = document.getElementById("dmsg");
                if (isEmpty(p)) {
                    msg.innerHTML = "This field cannot be empty";
                    document.getElementById("txtPayment").focus();
                    return false;
                }
                return true;
            }
        </script> 
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            ProcessedOrdersKanikaServicesDAO objServices = new ProcessedOrdersKanikaServicesImpl();
            DealerInfoBean obj = objServices.getDealerOrderInfoById(Integer.parseInt(request.getParameter("order_id")));
            pageContext.setAttribute("obj", obj);

            List<OrderDetailsBean> lstOrderedItems = objServices.getOrderDetailInfo();
            double totalAmount = 0.0;
            double shippingCharges = 0.0;
            for (int i = 0; i < lstOrderedItems.size(); i++) {
                OrderDetailsBean objO = lstOrderedItems.get(i);
                totalAmount += (objO.getPrice() * objO.getQuantity());
                shippingCharges += (objO.getShipping_charges() * objO.getQuantity());
            }
            pageContext.setAttribute("LIST_ORDERS", lstOrderedItems);

        %>
        <form action="ControllerProcess.jsp" method="post" onsubmit="return check()">
            <input type="hidden" name="order_id" value="${param.order_id}"/>
            <input type="hidden" name="total_charges" value="<%=totalAmount%>"/>
            <input type="hidden" name="order_processed_by" value="${sessionScope.userId}"/>
            <input type="hidden" name="shipping_charges" value="<%=shippingCharges%>"/>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8">
                        <div class="panel panel-success">
                            <div align="center"><h2><b>View And Process Order</b></h2></div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-6" align="">

                                        <b>Order title :  </b>${obj.order_title}
                                    </div>
                                    <div class="col-md-6 " align="">
                                        <b>Order Date :  </b>${obj.order_date}


                                    </div>
                                </div>
                            </div>
                            <div class="panel-heading">
                                <b>Dealer Info</b>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-4" align="">

                                        <b>Name :  </b>${obj.name}
                                    </div>
                                    <div class="col-md-4 " align="">
                                        <b>Contact :  </b>${obj.contact}


                                    </div>
                                    <div class="col-md-4 " align="">
                                        <b>Email : </b>${obj.email}


                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-2" align="">
                                        <b>Address :</b>
                                    </div>
                                    <div class="col-md-10" align="">

                                        <textarea rows="4" cols="32" class="form-control">${obj.address}</textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12" align="">
                                        <table class="table table-hover table-responsive ">

                                            <thead>
                                                <tr>
                                                    <th>
                                                        S.No.
                                                    </th>
                                                    <th>
                                                        Item Title
                                                    </th>
                                                    <th>
                                                        Qty
                                                    </th>
                                                    <th>
                                                        Price
                                                    </th>
                                                    <th>
                                                        VAT
                                                    </th>
                                                    <th>
                                                        Shipping Charges
                                                    </th>
                                                    <th>
                                                        Total
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_ORDERS}" var="obj1" varStatus="i">
                                                    <tr>
                                                        <td>${i.index+1}</td>
                                                        <td>${obj1.productTitle}</td>
                                                        <td>${obj1.quantity}</td>
                                                        <td>${obj1.price}</td>
                                                        <td>${obj1.vat}</td>
                                                        <td>${obj1.shipping_charges}</td>
                                                        <td>${(obj1.quantity*obj1.price)+obj1.vat+obj1.shipping_charges}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-2" >

                                        <b>Payment</b>
                                    </div>
                                    <div class="col-md-10" >
                                        <label class="radio-inline">
                                            <input type="radio" name="rbStatus" value="Done"/>Done

                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="rbStatus" value="Pending" checked/>Pending
                                        </label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3" align="">
                                        <b>Payment via :</b>
                                    </div>
                                    <div class="col-md-9" align="">
                                        <input type="text" class="txtStyle" name="payment_via" id="txtPayment" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12" align="right">
                                        <input type="submit" class="btn btn-success" name="sbtnProcess" value="Process"/>
                                        <input type="button" class="btn btn-success" name="btnBack" value="Cancel" onclick="window.location = 'ManageOrders.jsp'"/>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


























<!--            <table align="center" cellpadding="5">
                <tr>
                    <td align="center" colspan="2">
                        <strong>View And Process Orders</strong>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <div id="dmsg" style="color: red;background-color: white;"></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table width="100%">
                            <tr>
                                <td>
                                    <b>Order Title:&nbsp;</b>${obj.order_title}
                                </td>

                                <td align="right"><b>Order Date:&nbsp;</b>${obj.order_date}</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table width="100%">
                            <tr>
                                <td>
                                    <fieldset>
                                        <legend>
                                            <b>Dealer Info</b>
                                        </legend>
                                        <table width="100%" cellpadding="5">
                                            <tr>
                                                <th align="left">
                                                    Name:
                                                </th>
                                                <td>
                                                    ${obj.name}
                                                </td>
                                                <th align="left"> Contact:&nbsp;</th>
                                                <td> ${obj.contact}</td>
                                                <th align="left">Email:&nbsp;</th> 	<td>${obj.email}</td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Address
                                                </th>

                                                <td colspan="3">
                                                    <textarea rows="4" cols="32">${obj.address}</textarea>
                                                </td>
                                            </tr>

                                        </table>
                                    </fieldset>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table width="100%">
                            <tr>
                                <td>
                                    <fieldset>
                                        <legend>
                                            <b>Order Details</b>
                                        </legend>
                                        <table width="100%" style="border-collapse: collapse; border-style: inset" border="1">
                                            <tr>
                                                <th>
                                                    S.No.
                                                </th>
                                                <th>
                                                    Item Title
                                                </th>
                                                <th>
                                                    Qty
                                                </th>
                                                <th>
                                                    Price
                                                </th>
                                                <th>
                                                    VAT
                                                </th>
                                                <th>
                                                    Shipping Charges
                                                </th>
                                                <th>
                                                    Total
                                                </th>
                                            </tr>
                                            <c:forEach items="${LIST_ORDERS}" var="obj1" varStatus="i">
                                                <tr>
                                                    <td>${i.index+1}</td>
                                                    <td>${obj1.productTitle}</td>
                                                    <td>${obj1.quantity}</td>
                                                    <td>${obj1.price}</td>
                                                    <td>${obj1.vat}</td>
                                                    <td>${obj1.shipping_charges}</td>
                                                    <td>${(obj1.quantity*obj1.price)+obj1.vat+obj1.shipping_charges}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </fieldset>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table>
                            <tr>
                                <th align="left">Payment</th>
                                <td>
                                    <input type="radio" name="rbStatus" value="Done"/>Done
                                    <input type="radio" name="rbStatus" value="Pending" checked/>Pending
                                </td>
                            </tr>
                            <tr>
                                <th align="left">Payment Via</th>
                                <td>
                                    <input type="text" class="txtStyle" name="txtPaymentVia" id="txtPayment" />
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td align="right" colspan="2">
                        <input type="submit" class="button" name="sbtnProcess" value="Process"/>
                        <input type="button" class="button" name="btnBack" value="Cancel" onclick="window.location = 'ManageOrders.jsp'"/>
                    </td>
                </tr>
            </table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
