<%@page import="dpu.services.admin.StateServicesImpl"%>
<%@page import="dpu.services.admin.StateServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.StateBean"%>
<%@page import="java.util.List"%>
<%

    int countryId = Integer.parseInt(request.getParameter("countryId"));
    StateServicesDAO obj = new StateServicesImpl();
    List<StateBean> lstStates = obj.getStatesByCountryId(countryId);
    pageContext.setAttribute("LIST_STATES", lstStates);
%>
<option value="0">select</option>
<c:forEach items="${LIST_STATES}" var="obj">
    <option value="${obj.stateId}">${obj.stateName}</option>
</c:forEach>