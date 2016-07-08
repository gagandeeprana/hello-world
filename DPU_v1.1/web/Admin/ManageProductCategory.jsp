<%@page import="dpu.services.admin.ProductCategoryServicesImpl"%>
<%@page import="dpu.services.admin.ProductCategoryServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.admin.ProductCategoryBean"%>
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
         <% ProductCategoryServicesDAO objServices = new ProductCategoryServicesImpl();
            List<ProductCategoryBean> lstCategories = null;
             if (request.getParameter("sbtnSearch") != null) {
                 String search = request.getParameter("txtSearch");
                 lstCategories=objServices.getAllProductCategories(search);
             }
             else{
                    lstCategories=objServices.getAllProductCategories("");
             }
            pageContext.setAttribute("LIST_CATEGORIES", lstCategories);
            %>
            <form action="#" method="GET">
            <table align="center" cellpadding="5">
                <tr>
                    <td align="center">
                        <strong>
                            Manage Product Category
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
                                    <input type="button" onclick="window.location='AddProductCategory.jsp'" class="button" value="Add Category"/>
                                </td>
                                <td align="right">
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
                                    Title
                                </th>
                                <th>
                                    Description
                                </th>
                                <th>
                                    Status
                                </th>
                                <th>
                                    VAT
                                </th>
                                <th>
                                   SHIPPING CHARGES
                                </th>
                                <th>
                                    Links
                                </th>
                            </tr>
                            <c:forEach items="${LIST_CATEGORIES}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.title}</td>
                                   <td>${obj.description}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${obj.status==0}">
                                                <c:set var="status" value="InActive"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="status" value="Active"></c:set>
                                            </c:otherwise>
                                        </c:choose>

                                        <a href="ControllerPC.jsp?categoryId=${obj.categoryId}&status=${obj.status}">${status}</a></td>
                                     <td>${obj.vat}</td>
                                      <td>${obj.charges}</td>
                                    <td><a href="EditProductCategory.jsp?categoryId=${obj.categoryId}">View & Edit</a></td>
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
