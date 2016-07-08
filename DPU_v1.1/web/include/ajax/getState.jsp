<%@page import="beans.*" %>
<%@page import="datalayer.*" %>
<%@page import="java.util.*" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    String id = request.getParameter("q");
    String sid = request.getParameter("sid");
%>
<select id="ddlState" name="ddlState"   onChange="getCities(this.value)"  style="width: 126px" >
    <option value="0" selected="selected">Select</option>
    <%
        if (id.equalsIgnoreCase("select")) {
        } else {
            ArrayList al;
            LocationServices objServices = new LocationServices();
            al = objServices.getAllStates(Integer.parseInt(id));
    %>


    <%
        for (int a = 0; a < al.size(); a++) {
            StateMasterBean obj = (StateMasterBean) al.get(a);
    %>

    <option value="<%=obj.getStateId()%>"><%=obj.getTxtStateName()%></option>

    <%
            }
        }
    %>

</select>  
