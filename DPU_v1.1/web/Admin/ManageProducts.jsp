<%@page import="dpu.services.admin.ProductCategoryServicesImpl"%>
<%@page import="dpu.services.admin.ProductsServicesImpl"%>
<%@page import="dpu.services.admin.ProductsServicesDAO"%>
<%@page import="dpu.beans.admin.ProductCategoryBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.ProductsBean"%>
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
         <% ProductsServicesDAO objServices = new ProductsServicesImpl();
            List<ProductsBean> lstProducts = null;
            if (request.getParameter("sbtnSearch") != null) {
                 String search = request.getParameter("txtSearch");
                 String categoryId = request.getParameter("ddlCategory");
                lstProducts=objServices.getAllProducts(search,categoryId);
             }
             else{
                   lstProducts=objServices.getAllProducts("","");
             }
            List<ProductCategoryBean> lstCategories=new ProductCategoryServicesImpl().getAllProductCategories("");
            pageContext.setAttribute("LIST_CATEGORIES", lstCategories);
            pageContext.setAttribute("LIST_PRODUCTS", lstProducts);
            %>
        <form>
            <table align="center" cellpadding="5">
                 
                <tr>
                    <td align="center">
                        <strong>
                            Manage Products
                        </strong><br/>
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
                        <table width="100%">
                            <tr>
                                <td>
                                    <input type="button" class="button" value="Add Product" onclick="window.location='AddProduct.jsp'"/>
                                </td>
                                <td align="right">
                                    <b>Category</b>
                                    <select name="ddlCategory" id="ddlCategory">
                                        <option value="0">Select</option>
                                        <c:forEach items="${LIST_CATEGORIES}" var="obj">
                                            <option value="${obj.categoryId}">${obj.title}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="text" class="txtStyle" name="txtSearch"/>
                                    <input type="submit" class="button" name="sbtnSearch" value="Search"/>
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
                                    Product Title
                                </th>
                                <th>
                                    Price
                                </th>
                                <th>
                                    Model No
                                </th>
                                <th>
                                    Category
                                </th>
                                <th>
                                    Status
                                </th>
                                <th>
                                    Links
                                </th>
                            </tr>
                            <c:forEach items="${LIST_PRODUCTS}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.product_title}</td>
                                   <td>${obj.price}</td>
                                   <td>${obj.model_no}</td>
                                   <td>${obj.category}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${obj.status==0}">
                                                <c:set var="status" value="InActive"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="status" value="Active"></c:set>
                                            </c:otherwise>
                                        </c:choose>

                                        <a href="ControllerProduct.jsp?productId=${obj.productId}&status=${obj.status}">${status}</a></td>
                                     
                                    <td><a href="EditProduct.jsp?productId=${obj.productId}">View & Edit</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
