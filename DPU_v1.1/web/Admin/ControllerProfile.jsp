<%@page import="dpu.services.admin.ProfileServicesImpl"%>
<%@page import="dpu.services.admin.ProfileServicesDAO"%>
<jsp:useBean id="objProfileBean" class="dpu.beans.admin.ProfileBean">
    <jsp:setProperty name="objProfileBean" property="*"/>
</jsp:useBean>
<%
    ProfileServicesDAO objServices=new ProfileServicesImpl();
    String result="";
    if(request.getParameter("btnUpdate")!=null)
    {
         result=objServices.updateProfile(objProfileBean);
        response.sendRedirect("ManageProfile.jsp?msg="+result);
    }
    
%>
    