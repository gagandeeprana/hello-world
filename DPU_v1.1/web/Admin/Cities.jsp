<%@page import="dpu.services.admin.CityServicesImpl"%>
<%@page import="dpu.services.admin.CityServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.CityBean"%>
<%@page import="java.util.List"%>
<%

    int stateId = Integer.parseInt(request.getParameter("stateId"));
    CityServicesDAO obj = new CityServicesImpl();
    List<CityBean> lstCities = obj.getCitiesByStateId(stateId);
    System.out.println("LISTCITY " + lstCities.size());
    pageContext.setAttribute("LIST_CITIES", lstCities);
%>
<option value="0">select</option>
<c:forEach items="${LIST_CITIES}" var="obj">
    <option value="${obj.cityId}">${obj.name}</option>
</c:forEach>
