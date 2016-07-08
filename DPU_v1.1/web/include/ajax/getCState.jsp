<%@page import="beans.*" %>
<%@page import="datalayer.*" %>
<%@page import="java.util.*" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    String id = request.getParameter("q");
%>
<select id="ddlCState" name="ddlCState"   onChange="getCCities(this.value)"  style="width: 126px" >
    <option value="0" selected="selected">Select</option>
    <%
      
            ArrayList al;
            LocationServices objServices = new LocationServices();
            al = objServices.getAllStates(Integer.parseInt(id));
    %>


    <%
        for (int a = 0; a < al.size(); a++) {
            StateMasterBean obj = (StateMasterBean) al.get(a);
    %>

    <option value="<%=obj.getStateId()%>"  ><%=obj.getTxtStateName()%></option>

    <%
            }
        
    %>

</select>  
