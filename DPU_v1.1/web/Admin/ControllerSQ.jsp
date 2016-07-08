<%@page import="dpu.services.admin.SecurityQuestionServicesImpl"%>
<%@page import="dpu.services.admin.SecurityQuestionServicesDAO"%>
<jsp:useBean id="objSQBean" class="dpu.beans.admin.AddEditSQBean">
    <jsp:setProperty name="objSQBean" property="*"/>
</jsp:useBean>
<%
    SecurityQuestionServicesDAO objServices=new SecurityQuestionServicesImpl();
    String result="";
     if(request.getParameter("sbtnSave")!=null)
    {
        result=objServices.addSQ(objSQBean);
        response.sendRedirect("ManageSecurityQuestions.jsp?msg="+result);
    }
    if(request.getParameter("sbtnSave&AddNew")!=null)
    {
        result=objServices.addSQ(objSQBean);
        response.sendRedirect("AddSecurityQuestion.jsp?msg="+result);
    }
     if(request.getParameter("sbtnUpdate")!=null)
    {
        result=objServices.updateSQ(objSQBean);
        response.sendRedirect("ManageSecurityQuestions.jsp?msg="+result);
    }
     if(request.getParameter("status")!=null)
    {
        int qId=Integer.parseInt(request.getParameter("questionId"));
        int status=Integer.parseInt(request.getParameter("status"));
        result=objServices.changeStatus(status,qId);
        response.sendRedirect("ManageSecurityQuestions.jsp?msg="+result);
    }
     
%>