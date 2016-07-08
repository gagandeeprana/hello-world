<%@page import="dpu.services.admin.ProductCategoryServicesImpl"%>
<%@page import="dpu.services.admin.ProductCategoryServicesDAO"%>
<%@page import="dpu.services.admin.ProductsServicesImpl"%>
<%@page import="dpu.services.admin.ProductsServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.ProductCategoryBean"%>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.admin.ProductsBean"%>
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
        <script type="text/javascript" src="../include/validations.js"></script>
        <script type="text/javascript">
            function check() {

                var title = document.getElementById("txtProductTitle").value;

                var code = document.getElementById("txtProductCode").value;

                var model = document.getElementById("txtModelNo").value;
                var category = document.getElementById("ddlCategory").value;
                var company = document.getElementById("txtCompany").value;
                var price = document.getElementById("txtPrice").value;
                var des = document.getElementById("taDescription").value;
                var msg = document.getElementById("divMsg");
                if (isEmpty(title)) {
                    msg.innerHTML = "Product Title is Required";
                    document.getElementById("txtProductTitle").focus();
                    return false;
                }
                if (isEmpty(code)) {
                    msg.innerHTML = "Product Code is Required";
                    document.getElementById("txtProductCode").focus();
                    return false;
                }
                if (isEmpty(model)) {
                    msg.innerHTML = "Model No is Required";
                    document.getElementById("txtModelNo").focus();
                    return false;
                }
                if (isSelected(category)) {
                    msg.innerHTML = "Category is Required";
                    document.getElementById("ddlCategory").focus();
                    return false;
                }
                if (isEmpty(company)) {
                    msg.innerHTML = "Company is Required";
                    document.getElementById("txtCompany").focus();
                    return false;
                }
                if (isEmpty(price)) {
                    msg.innerHTML = "Price is Required";
                    document.getElementById("txtPrice").focus();
                    return false;
                }
                if (isEmpty(des)) {
                    msg.innerHTML = "Description is Required";
                    document.getElementById("taDescription").focus();
                    return false;
                }

                return true;

            }
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            ProductsServicesDAO objServices = new ProductsServicesImpl();
            ProductsBean obj = objServices.getProductInfoById(Integer.parseInt(request.getParameter("productId")));
            pageContext.setAttribute("obj", obj);
            ProductCategoryServicesDAO objPCServices = new ProductCategoryServicesImpl();
            List<ProductCategoryBean> lstCategories = objPCServices.getAllProductCategories("");
            pageContext.setAttribute("LIST_CATEGORIES", lstCategories);
        %>
        <div id="divMsg" style="color:red"></div>
        <form action="ControllerProduct.jsp" method="GET" onsubmit="return check()">
            <input type="hidden" name="txtProductId" value="${param.productId}"/>
            <table align="center" cellpadding="5">
                <tr>
                    <td align="center">
                        <strong>Edit Product</strong>
                    </td>
                </tr>

                <tr>
                    <td>
                        <table width="100%">
                            <tr>
                                <td>
                                    <fieldset>

                                        <table width="100%">
                                            <tr>
                                                <td>
                                                    <b>Product Title</b>
                                                </td>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtProductTitle" id="txtProductTitle" value="${obj.txtProductTitle}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <b>Product Code</b>
                                                </td>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtProductCode" id="txtProductCode" value="${obj.txtProductCode}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <b>Model No</b>
                                                </td>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtModelNo" id="txtModelNo" value="${obj.txtModelNo}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <b>Category</b>
                                                </td>
                                                <td>
                                                    <select name="ddlCategory" id="ddlCategory">
                                                        <option value="0">Select</option>
                                                        <c:forEach items="${LIST_CATEGORIES}" var="obj">
                                                            <option value="${obj.categoryId}">${obj.title}</option>
                                                        </c:forEach>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <b>Company</b>
                                                </td>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtCompany" id="txtCompany" value="${obj.txtCompany}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <b>Price</b>
                                                </td>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtPrice" id="txtPrice" value="${obj.txtPrice}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <b>Description</b>
                                                </td>
                                                <td>
                                                    <textarea name="taDescription" id="taDescription" rows="4" cols="32">${obj.taDescription}</textarea>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <b>Status</b>
                                                </td>
                                                <td>
                                                    <%
                                                        if (obj.getStatus() == 1) {
                                                    %>
                                                    Active<input type="radio" name="rbStatus" value="1" checked="checked"/>
                                                    InActive<input type="radio" name="rbStatus" value="0">
                                                    <%} else {
                                                    %>
                                                    Active<input type="radio" name="rbStatus" value="1" />
                                                    InActive<input type="radio" name="rbStatus" value="0" checked="checked" >
                                                    <%}
                                                    %>
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
                        <input type="submit" class="button" name="sbtnUpdate" value="Update"/>
                        <input type="button" class="button" name="btnBack" value="Back" onclick="window.location = 'ManageProducts.jsp'"/>
                    </td>
                </tr>
            </table>
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
