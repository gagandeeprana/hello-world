<%@page import="dpu.services.admin.EmployeesServicesImpl"%>
<%@page import="dpu.services.admin.EmployeesServicesDAO"%>
<jsp:useBean id="objEmpBean" class="dpu.beans.admin.AddEditEmployeeBean">
    <jsp:setProperty name="objEmpBean" property="*"/>
</jsp:useBean>
<%
    EmployeesServicesDAO objServices=new EmployeesServicesImpl();
    String result="";
if(request.getParameter("sbtnSave")!=null)
{
    result=objServices.addEmp(objEmpBean);
    response.sendRedirect("ManageEmployees.jsp?msg="+result);
}
if(request.getParameter("sbtnUpdate")!=null)
{
    result=objServices.updateEmployee(objEmpBean);
    response.sendRedirect("ManageEmployees.jsp?msg="+result);
}
  if(request.getParameter("status")!=null)
    {
        int employeeId=Integer.parseInt(request.getParameter("employeeId"));
        String status=request.getParameter("status");
        result=objServices.changeStatus(status,employeeId);
        response.sendRedirect("ManageEmployees.jsp?msg="+result);
    }   
%>