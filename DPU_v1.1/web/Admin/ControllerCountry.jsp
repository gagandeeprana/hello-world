<%@page import="dpu.services.admin.CountryServicesImpl"%>
<%@page import="dpu.services.admin.CountryServicesDAO"%>
<jsp:useBean id="objCountryBean" class="dpu.beans.admin.AddEditCountryBean">
    <jsp:setProperty name="objCountryBean" property="*" />
</jsp:useBean>
<%
    CountryServicesDAO objServices = new CountryServicesImpl();
    String result = "";
    if (request.getParameter("sbtnSave") != null) {
        result = objServices.addCountry(objCountryBean);
        response.sendRedirect("ManageCountry.jsp?msg=" + result);
    } else if (request.getParameter("sbtnSave&AddNew") != null) {
        result = objServices.addCountry(objCountryBean);
        response.sendRedirect("AddCountry.jsp?msg=" + result);
    }
    if (request.getParameter("sbtnUpdate") != null) {
        result = objServices.updateCountry(objCountryBean);
        response.sendRedirect("ManageCountry.jsp?msg=" + result);
    }
    if(request.getParameter("status")!=null)
    {
        int countryId=Integer.parseInt(request.getParameter("countryId"));
        int status=Integer.parseInt(request.getParameter("status"));
        result=objServices.changeStatus(status,countryId);
        response.sendRedirect("ManageCountry.jsp?msg="+result);
    }
%>






