<%@page import="dpu.services.admin.EmployeesServicesImpl"%>
<%@page import="dpu.services.admin.EmployeesServicesDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.EmployeesBean"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <jsp:include page="stylesheet.jsp"/>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            EmployeesServicesDAO objServices = new EmployeesServicesImpl();
            String status = "";
            List<EmployeesBean> lstEmployees = objServices.getAllEmployees("", "Search");
            if (request.getParameter("sbtnSearch") != null) {
                String search = request.getParameter("txtSearch");
                status = request.getParameter("ddlStatus");
                lstEmployees = objServices.getAllEmployees(status, search);
            } else {
                lstEmployees = objServices.getAllEmployees("0", "");
            }
            pageContext.setAttribute("LIST_EMPLOYEES", lstEmployees);
            pageContext.setAttribute("st_" + status.toLowerCase(), "selected='selected'");
        %>

        <form action="#" method="GET">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8 ">
                        <div class="panel panel-success">
                            <div class="panel-body">
                                <div align="center"><h2><b>Manage Employees</b></h2>

                                    <label id="lblMsg" style="color:red">
                                        <small>${param.msg}</small>
                                    </label>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group ">
                                            <c:if test="${sessionScope.userType.equalsIgnoreCase('admin')}">
                                                <input class="btn btn-success " type="button" name="sbtnSearch" value="Add Employee" onclick="window.location = 'AddEmployee.jsp'">
                                            </c:if>


                                        </div>



                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <select id="ddlStatus" name="ddlStatus" class="form-control">
                                                <option value="0" ${st_0}>Select</option>
                                                <option value="Active" ${st_active}>Active</option>
                                                <option value="Inactive" ${st_inactive}>InActive</option>
                                            </select>




                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="Name" name="txtSearch" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">



                                            <input class="btn btn-success  " type="submit" name="sbtnSearch" value="Search">




                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 col-xs-6 ">
                                        <table class="table table-hover table-responsive ">

                                            <thead>
                                                <tr>
                                                    <th>S.no</th>
                                                    <th>Name</th>
                                                    <th>Contact</th>
                                                    <th>Email</th>
                                                    <th>Status</th>
                                                    <th>Links</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_EMPLOYEES}" var="obj" varStatus="i">
                                                    <tr>
                                                        <td>${i.index+1}</td>
                                                        <td>${obj.name}</td>
                                                        <td>${obj.contact}</td>
                                                        <td>${obj.mail}</td>
                                                        <td>

                                                            <a href="ControllerEmployee.jsp?employeeId=${obj.employeeId}&status=${obj.status}">${obj.status}</a>
                                                        </td>
                                                        <td><a href="EditEmployee.jsp?employeeId=${obj.employeeId}">View & Edit</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">

                    </div>
                </div>
            </div>
















            <!--            <table align="center" cellpadding="5">
            
                            <tr>
                                <td align="center">
                                    <strong>
                                        Manage Employees
                                    </strong>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label id="lblMsg" style="color:red">
                                        <small>${param.msg}</small>
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="100%">
                                        <tr>
                                            <td>
                                                <input type="button" class="button" name="sbtnAddEmployee" value="Add Employee" onclick="window.location = 'AddEmployee.jsp'"/>
                                            </td>
                                            <td align="right">
                                                <label><b>Status</b></label>
                                                <select id="ddlStatus" name="ddlStatus">
                                                    <option value="0" ${st_0}>Select</option>
                                                    <option value="Active" ${st_active}>Active</option>
                                                    <option value="Inactive" ${st_inactive}>InActive</option>
                                                </select>
                                                <input type="text" class="txtStyle" name="txtSearch"/>
                                                <input type="submit" class="button" name="sbtnSearch" value="Search"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table style="border-collapse: collapse; border-style: inset" align = "center" width="100%" border="1">
                                        <tr>
                                            <th>
                                                S.No
                                            </th>
                                            <th>
                                                Name
                                            </th>
                                            <th>
                                                Contact
                                            </th>
                                            <th>
                                                Email
                                            </th>
                                            <th>
                                                Status
                                            </th>
                                            <th>
                                                Links
                                            </th>
                                        </tr>
            <c:forEach items="${LIST_EMPLOYEES}" var="obj" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${obj.name}</td>
                    <td>${obj.contact}</td>
                    <td>${obj.mail}</td>
                    <td>

                        <a href="ControllerEmployee.jsp?employeeId=${obj.employeeId}&status=${obj.status}">${obj.status}</a>
                    </td>
                    <td><a href="EditEmployee.jsp?employeeId=${obj.employeeId}">View & Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </td>
</tr>
</table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
