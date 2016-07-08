<%@page import="dpu.services.dealers.PlaceNewOrderServicesImpl"%>
<%@page import="dpu.services.dealers.PlaceNewOrderServicesDAO"%>
<%@page import="dpu.beans.dealers.OrderItembean"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% PlaceNewOrderServicesDAO objServices = new PlaceNewOrderServicesImpl();
    String result = "";%>

<c:choose>
    <c:when test="${param.sbtnPlaceOrder!=null}">
        <jsp:useBean id="objBean" class="dpu.beans.dealers.PlaceNewOrderBean">
            <jsp:setProperty name="objBean" property="*"/>
        </jsp:useBean>
        <%
            result = objServices.placeOrder(objBean, (List<OrderItembean>) session.getAttribute("LIST_ITEMS"));
            response.sendRedirect("ManageOrders.jsp?result=" + result);
        %>
    </c:when>
    
</c:choose>
