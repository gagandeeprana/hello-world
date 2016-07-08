<%@page import="beans.*" %>
<%@page import="datalayer.*" %>
<%@page import="java.util.*" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    String id = request.getParameter("q");
    System.out.println("qqqqqqqqqqqqqq      "+id);
%>
<select id="ddlPlanName" name="ddlPlanName">
    <option value="" selected="selected">Select</option>
    <%
        
            ArrayList al;
            LoanPlanServices objServices = new LoanPlanServices();
            al = objServices.getAllActivePlans(Integer.parseInt(id));
    %>


    <%
        for (int a = 0; a < al.size(); a++) {
            ManageLoanPlansBean obj = (ManageLoanPlansBean) al.get(a);
    %>

    <option value="<%=obj.getId()%>" ><%=obj.getPlanTitle()%></option>

    <%
            }
     
    %>

</select>  
