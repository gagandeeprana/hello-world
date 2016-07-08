<%@page import="dpu.services.admin.FaqServicesImpl"%>
<%@page import="dpu.services.admin.FaqServicesDAO"%>
<jsp:useBean id="objFaqBean" class="dpu.beans.admin.AddEditFaqBean">
    <jsp:setProperty name="objFaqBean" property="*"/>
</jsp:useBean>
<%
    FaqServicesDAO objServices=new FaqServicesImpl();
    String result="";
    if(request.getParameter("sbtnSave")!=null)
    {
        result=objServices.addFaq(objFaqBean);
        response.sendRedirect("ManageFAQ.jsp?msg="+result);
    }
    if(request.getParameter("sbtnSave&AddNew")!=null)
    {
        result=objServices.addFaq(objFaqBean);
        response.sendRedirect("AddFAQ.jsp?msg="+result);
    }
    if(request.getParameter("status")!=null)
    {
        int faqId=Integer.parseInt(request.getParameter("faqId"));
        int status=Integer.parseInt(request.getParameter("status"));
        result=objServices.changeStatus(status,faqId);
        response.sendRedirect("ManageFAQ.jsp?msg="+result);
    }
    if(request.getParameter("sbtnUpdate")!=null)
    {
        result=objServices.updateFaq(objFaqBean);
        response.sendRedirect("ManageFAQ.jsp?msg="+result);
    }
%>
