<%@page import="beans.*" %>
<%@page import="datalayer.*" %>
<%@page import="java.util.*" %>



<%

    response.setHeader("Cache-Control", "no-cache");
    String id = request.getParameter("q");

%>
<select id="ddlPCity" name="ddlPCity" style="width: 126px" > 
    <option value="0" selected="selected">Select</option>

    <%
       
            LocationServices objServices = new LocationServices();
            ArrayList al = objServices.getAllCities(Integer.parseInt(id));
    %>


    <%
        for (int a = 0; a < al.size(); a++) {
            CityMasterBean obj = (CityMasterBean) al.get(a);

    %>

    <option value="<%=obj.getCityId()%>"  ><%=obj.getTxtCityName()%></option>

    <%
                }
           %>

</select>