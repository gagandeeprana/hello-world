<%@page import="dpu.services.admin.ProductCategoryServicesImpl"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.ProductCategoryBean"%>
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
        <script type="text/javascript" src="../include/validations.js">

        </script>
        <script type="text/javascript">
            function check() {
                var ot = document.getElementById("txtOrderTitle").value;
                var od = document.getElementById("txtOrderDate").value;
                var c = document.getElementById("ddlCategory").value;
                var p = document.getElementById("ddlProduct").value;
                var q = document.getElementById("txtQuantity").value;
                var msg = document.getElementById("divMsg");
                //alert("1")
                if (isEmpty(ot)) {
                    msg.innerHTML = "Order Title is required";
                    document.getElementById("txtOrderTitle").focus();
                    return false;
                }
                if (isEmpty(od)) {
                    msg.innerHTML = "Order Date is required";
                    document.getElementById("txtOrderDate").focus();
                    return false;
                }

                if (isEmpty(q)) {
                    msg.innerHTML = "Quantity is required";
                    document.getElementById("txtQuantity").focus();
                    return false;
                }
                if (isSelected(c)) {
                    msg.innerHTML = "Category is required";
                    document.getElementById("ddlCategory").focus();
                    return false;
                }
                if (isSelected(p)) {
                    msg.innerHTML = "Product is required";
                    document.getElementById("ddlProduct").focus();
                    return false;
                }
                return true;
            }

            $(document).ready(function () {
                $('#ddlCategory').change(function () {
                    var catId = $('#ddlCategory').val();
                    $.get('Products.jsp?categoryId=' + catId, function (data) {
                        $('#ddlProduct').html(data);
                    })
                })
            })
            function modifyQUntity(id) {
                $("#txtQuantity" + id + "").show();
                $("#quantity" + id + "").hide();
                $("#btn" + id + "").show();
            }
            function updateQUntity(id) {
                var quantity = $("#txtQuantity" + id + "").val();
                $.get('PlaceNewOrderAjaxx.jsp?update', {productId: id, quantity: quantity}, function (data) {
                    $('#divCart').html(data);
                })
            }
            function hideAll() {
                $("[name='txtQEdit']").hide();
                $("[name='btnQUpdate']").hide();
            }
            function addToCart() {
                var productId = $('#ddlProduct').val();
                var quantity = $('#txtQuantity').val();
                $.get('PlaceNewOrderAjaxx.jsp', {productId: productId, quantity: quantity}, function (data) {
                    $('#divCart').html(data);
                })
//                $.ajax({
//                    url: "PlaceNewOrderAjax.jsp",
//                    type: 'POST',
//                    data: "",
//                    success: function(data, textStatus, jqXHR) {
//                        alert(data);
//                    },                    ,
//                    error: function(jqXHR, textStatus, errorThrown) {
//                        alert(errorThrown);
//                    }
//                });

            }
        </script>
    </head>
    <body>
        <%
            List<ProductCategoryBean> lstC = new ProductCategoryServicesImpl().getAllProductCategories("");
            pageContext.setAttribute("LIST_PCB", lstC);
        %>
        <jsp:include page="mp_header.jsp"/>
        <div id="divMsg" style="color:red"></div>
        <form action="PlaceNewOrderController.jsp" method="post" onsubmit="return check()">
            <input type="hidden" name="dealer_id" value="${sessionScope.userId}"/>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8">
                        <div class="panel panel-success">
                            <div align="center"><h2><b>Place New Order</b></h2></div>                            
                            <div class="panel-body">
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Order Title" name="txtOrderTitle" id="txtOrderTitle" type="text"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Order Date" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" name="txtOrderDate" id="txtOrderDate" type="text"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-heading">
                                Order Details
                            </div>
                            <div class="panel-body" >
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-globe"></i>
                                            </span> 
                                            <select name="ddlCategory" id="ddlCategory" class="form-control">
                                                <option value="0">Select Category</option>
                                                <c:forEach items="${LIST_PCB}" var="obj">
                                                    <option value="${obj.categoryId}">${obj.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-globe"></i>
                                            </span> 
                                            <select class="form-control" name="ddlProduct" id="ddlProduct">
                                                <option value="0" selected>Select Product</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Quantity"id="txtQuantity" name="txtQuantity" type="text"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12 " >
                                        <input class="btn btn-success pull-right" onclick="addToCart()" type="button" name="btnAddToCart" value="Add To Cart"/>

                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12 " >
                                        <div id="divCart"> 

                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12 " align="right">
                                        <input type="submit" name="sbtnPlaceOrder" value="Place Order" class="btn btn-success"/>
                                        <input type="button" name="btnCancel" value="Back" class="btn btn-success" onclick="window.location = 'ManageOrders.jsp'"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



































<!--                <table align="center" cellpadding="5">
                    <tr>
                        <td align="center" colspan="2">
                            <strong>Place New Order</strong>
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
                                                        <b>Order Title</b>&nbsp;<input type="text"  class="txtStyle" name="txtOrderTitle" id="txtOrderTitle"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <b>Order Date</b>&nbsp;<input value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" name="txtOrderDate" id="txtOrderDate" type="text" class="txtStyle"/>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <fieldset>
                                                            <legend>
                                                                <b>Order Details</b>
                                                            </legend>
                                                            <table width="100%">
                                                                <tr>
                                                                    <td><b>Category</b></td>
                                                                    <td><select name="ddlCategory" id="ddlCategory">
                                                                            <option value="0">Select</option>
                                                                            <c:forEach items="${LIST_PCB}" var="obj">
                                                                                <option value="${obj.categoryId}">${obj.title}</option>
                                                                            </c:forEach>
                                                                        </select></td>
                                                                </tr>
                                                                <tr>
                                                                    <td><b>Product</b></td>
                                                                    <td><select name="ddlProduct" id="ddlProduct">
                                                                            <option value="0" selected>Select</option>
                                                                        </select></td>
                                                                </tr>
                                                                <tr>
                                                                    <td><b>Quantity</b></td>
                                                                    <td><input type="text" id="txtQuantity" name="txtQuantity" class="txtStyle"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="2" align="right"><input onclick="addToCart()" type="button" name="btnAddToCart" value="Add To Cart"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="2" align="center" width="100%">
                                                                        <div id="divCart"> 

                                                                        </div>
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
                                        <td align="right">
                                            <table>
                                                <tr>
                                                    <td>
                                                        <input type="submit" name="sbtnPlaceOrder" value="Place Order" class="button"/>
                                                        <input type="button" name="btnCancel" value="Back" class="button" onclick="window.location = 'ManageOrders.jsp'"/>
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
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
