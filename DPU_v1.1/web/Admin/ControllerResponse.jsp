<%@page import="dpu.services.admin.ResponseServicesImpl"%>
<%@page import="dpu.services.admin.ResponseServicesDAO"%>
<jsp:useBean id="objResponseBean" class="dpu.beans.admin.ResponseBean">
    <jsp:setProperty name="objResponseBean" property="*"/>
</jsp:useBean>
<%
    ResponseServicesDAO objServices=new ResponseServicesImpl();
    String result="";
    if(request.getParameter("sbtnPost")!=null)
    {
        result=objServices.addResponse(objResponseBean);
        response.sendRedirect("ManageResponses.jsp?msg="+result);
    }
%>