<%@page import="dpu.services.dealers.RequestServicesImpl"%>
<%@page import="dpu.services.dealers.RequestServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
    RequestServicesDAO obj=new RequestServicesImpl();
    String result="";
%>

<c:choose>
    <c:when test="${param.sbtnPost!=null}">
        <jsp:useBean id="objBean" class="dpu.beans.dealers.AddEditRequestBean">
            <jsp:setProperty name="objBean" property="*"/>
        </jsp:useBean>
        <%
            result= obj.postRequest(objBean);
            response.sendRedirect("ManageRequest.jsp?result="+result);
    
        %>
    
    </c:when>
</c:choose>