<%@page import="beans.*" %>
<%@page import="datalayer.*" %>
<%@page import="java.util.*" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    String id = request.getParameter("q");
    RequestResponseServices rrsObj = new RequestResponseServices();
    ArrayList alst = new ArrayList();
    alst = rrsObj.getAllPendingRequestsAccSpecifiedCriteria(Integer.parseInt(id));
%>    
<div id="showSortedData">
    <table border="1" cellpadding="5" cellspacing="0" class="tblStyle" >
        <tr class="header">
            <th>
                Title
            </th>
            <th>
                Description
            </th>
            <th>
                Request
                Date
            </th>
            <th>
                Name
            </th>
        </tr>
        <%
            if (alst.size() > 0) {
                for (int i = 0; i < alst.size(); i++) {
                    RequestMasterBean objBean = (RequestMasterBean) alst.get(i);
        %>
        <tr>
            <td >
                <a href="PostResponse.jsp?id=<%=objBean.getRequestId()%>"><%=objBean.getTxtRequestTitle()%></a>
            </td>
            <td >
                <label id="lblDescription" name="lblDescription" title="<%=objBean.getTaDescription()%>">
                    <%
                        if (objBean.getTaDescription() != null) {
                            if (objBean.getTaDescription().length() > 10) {%>
                    <%=objBean.getTaDescription().substring(0, 9)%>...
                    <%} else {
                    %>
                    <%=objBean.getTaDescription()%>
                    <%
                                }
                            }%></label>
            </td>
            <td >
                <label id="lblRequestDate" name="lblRequestDate"><%
                    if (objBean.getRequestDate() != null) {
                    %>
                    <%=objBean.getRequestDate().split(" ")[0]%>
                    <%
                        }
                    %></label>
            </td>
            <td >
                <label id="lblName" name="lblResponseDate"><%=objBean.getName()%></label>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">No requests</td>
        </tr>    
        <%            }
        %>
    </table>
</div>
