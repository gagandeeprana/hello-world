<%@page import="dpu.services.admin.ProcessedOrdersKanikaServicesImpl"%>
<%@page import="dpu.services.admin.ProcessedOrdersKanikaServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ProcessedOrdersKanikaServicesDAO objServices=new ProcessedOrdersKanikaServicesImpl();
String result=""; %>
<c:choose>
<c:when test="${param.sbtnProcess!=null}">
     <jsp:useBean id="objBean" class="dpu.beans.admin.PaymentBean">
            <jsp:setProperty name="objBean" property="*"/>
        </jsp:useBean>
        <%
            
            result = objServices.addPayment(objBean);
            response.sendRedirect("ManageOrders.jsp?result=" + result);
        %>

</c:when>
</c:choose>