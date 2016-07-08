<%@page import="dpu.services.admin.ProductsServicesImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.services.admin.ProductsServicesDAO"%>
<%@page import="dpu.beans.admin.ProductsBean"%>
<%@page import="java.util.List"%>
<%
    String catId = request.getParameter("categoryId");
    List<ProductsBean> lstProducts = new ProductsServicesImpl().getAllProducts("",catId);
    pageContext.setAttribute("lstP", lstProducts);
%>
<option value="0">Select</option>
<c:forEach items="${lstP}" var="obj">
    <option value="${obj.productId}">${obj.product_title}</option>
</c:forEach>