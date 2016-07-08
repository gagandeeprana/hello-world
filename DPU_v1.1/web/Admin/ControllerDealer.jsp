<%@page import="dpu.services.admin.DealersServicesImpl"%>
<%@page import="dpu.services.admin.DealersServicesDAO"%>
<jsp:useBean id="objDealerBean" class="dpu.beans.admin.AddEditDealerBean">
    <jsp:setProperty name="objDealerBean" property="*"/>
</jsp:useBean>
<%
    DealersServicesDAO objServices=new DealersServicesImpl();   
    String res="";
    if(request.getParameter("sbtnSave")!=null)
    {
        res=objServices.addDealers(objDealerBean);
        response.sendRedirect("ManageDealers.jsp?msg="+res);
    }
    if(request.getParameter("sbtnUpdate")!=null)
    {
        res=objServices.updateDealer(objDealerBean);
        response.sendRedirect("ManageDealers.jsp?msg="+res);
    }
       if(request.getParameter("status")!=null)
    {
        int dealerId=Integer.parseInt(request.getParameter("dealerId"));
        int status=Integer.parseInt(request.getParameter("status"));
        String result=objServices.changeStatus(status,dealerId);
        response.sendRedirect("ManageDealers.jsp?msg="+result);
    }
%>