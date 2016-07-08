<%@page import="dpu.services.admin.CityServicesImpl"%>
<%@page import="dpu.services.admin.CityServicesDAO"%>
<jsp:useBean id="objCityBean" class="dpu.beans.admin.AddEditCityBean">
    <jsp:setProperty name="objCityBean" property="*"/>
</jsp:useBean>

<%

    CityServicesDAO objSer = new CityServicesImpl();
    String res = "";
    if (request.getParameter("sbtnSave") != null) {
        res = objSer.addCity(objCityBean);
        response.sendRedirect("ManageCities.jsp?msg="+res);
    }
if (request.getParameter("sbtnSave&AddNew") != null) {
        res = objSer.addCity(objCityBean);
        response.sendRedirect("AddCity.jsp?msg="+res);
    }
if (request.getParameter("sbtnUpdate") != null) {
        res = objSer.updateCity(objCityBean);
        response.sendRedirect("ManageCities.jsp?msg="+res);
    }
if(request.getParameter("status")!=null)
    {
        int cityId=Integer.parseInt(request.getParameter("cityId"));
        int status=Integer.parseInt(request.getParameter("status"));
        String result=objSer.changeStatus(status,cityId);
        response.sendRedirect("ManageCities.jsp?msg="+result);
    }
%>
