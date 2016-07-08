<%@page import="dpu.services.admin.ProductCategoryServicesImpl"%>
<%@page import="dpu.services.admin.ProductCategoryServicesDAO"%>
<jsp:useBean id="objPCBean" class="dpu.beans.admin.AddEditPCBean">
    <jsp:setProperty name="objPCBean" property="*"/>
</jsp:useBean>
<%
     ProductCategoryServicesDAO objServices=new ProductCategoryServicesImpl();
    String result="";
     if(request.getParameter("sbtnSave")!=null)
    {
        result=objServices.addPC(objPCBean);
        response.sendRedirect("ManageProductCategory.jsp?msg="+result);
    }
    if(request.getParameter("sbtnSaveAddNew")!=null)
    {
        result=objServices.addPC(objPCBean);
        response.sendRedirect("AddProductCategory.jsp?msg="+result);
    }
     if(request.getParameter("sbtnUpdate")!=null)
    {
        result=objServices.updatePC(objPCBean);
        response.sendRedirect("ManageProductCategory.jsp?msg="+result);
    }
    if(request.getParameter("status")!=null)
    {
        int categoryId=Integer.parseInt(request.getParameter("categoryId"));
        int status=Integer.parseInt(request.getParameter("status"));
        result=objServices.changeStatus(status,categoryId);
        response.sendRedirect("ManageProductCategory.jsp?msg="+result);
    }
%>