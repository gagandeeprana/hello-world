<%@page import="dpu.services.admin.StateServicesImpl"%>
<%@page import="dpu.services.admin.StateServicesDAO"%>
<jsp:useBean id="objStateBean" class="dpu.beans.admin.AddEditStateBean">
    <jsp:setProperty name="objStateBean" property="*" />
</jsp:useBean>
<%
    StateServicesDAO objServices = new StateServicesImpl();
    String result = "";
    if (request.getParameter("sbtnSave") != null) {
        result = objServices.addState(objStateBean);
        response.sendRedirect("ManageStates.jsp?msg=" + result);
    } else if (request.getParameter("sbtnSave&AddNew") != null) {
        result = objServices.addState(objStateBean);
        response.sendRedirect("AddState.jsp?msg=" + result);
    }
     if (request.getParameter("sbtnUpdate") != null) {
        result = objServices.updateState(objStateBean);
        response.sendRedirect("ManageStates.jsp?msg=" + result);
    }
      if(request.getParameter("status")!=null)
    {
        int stateId=Integer.parseInt(request.getParameter("stateId"));
        int status=Integer.parseInt(request.getParameter("status"));
        result=objServices.changeStatus(status,stateId);
        response.sendRedirect("ManageStates.jsp?msg="+result);
    }
%>