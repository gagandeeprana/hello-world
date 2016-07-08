<%@page import="dpu.services.admin.ProcessedOrdersKanikaServicesImpl"%>
<%@page import="dpu.services.admin.ProcessedOrdersKanikaServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ProcessedOrdersKanikaServicesDAO objServices=new ProcessedOrdersKanikaServicesImpl();
String result=""; %>

<c:choose>
    <c:when test="${param.sbtnDispatch!=null}">
        <jsp:useBean id="objBean1" class="dpu.beans.admin.ProcessedOrdersKanikaBean">
            <jsp:setProperty name="objBean1" property="*"/>
        </jsp:useBean>
        <jsp:useBean id="objBean2" class="dpu.beans.admin.OrdersBean">
            <jsp:setProperty name="objBean2" property="*"/>
            
        </jsp:useBean>
        <%
        result=objServices.dispatchOrder(objBean1, objBean2);
        response.sendRedirect("ManageProcessedOrders.jsp?result="+result);
        %>
    </c:when>
</c:choose>

        