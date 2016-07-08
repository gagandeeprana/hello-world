<%@page import="dpu.services.admin.ProductsServicesImpl"%>
<%@page import="dpu.services.admin.ProductsServicesDAO"%>
<jsp:useBean id="objProductBean" class="dpu.beans.admin.AddEditProductBean">
    <jsp:setProperty name="objProductBean" property="*"/>
</jsp:useBean>
<%
    ProductsServicesDAO objServices=new ProductsServicesImpl();
    String result="";
    if(request.getParameter("sbtnSave")!=null)
    {
        result=objServices.addProduct(objProductBean);
        response.sendRedirect("ManageProducts.jsp?msg="+result);
    }
    if(request.getParameter("sbtnSaveAddNew")!=null)
    {
        result=objServices.addProduct(objProductBean);
        response.sendRedirect("AddProduct.jsp?msg="+result);
    }
    if(request.getParameter("sbtnUpdate")!=null)
    {
        result=objServices.updateProduct(objProductBean);
        response.sendRedirect("ManageProducts.jsp?msg="+result);
    }
     if(request.getParameter("status")!=null)
    {
        int productId=Integer.parseInt(request.getParameter("productId"));
        int status=Integer.parseInt(request.getParameter("status"));
        result=objServices.changeStatus(status,productId);
        response.sendRedirect("ManageProducts.jsp?msg="+result);
    }
 %>
    