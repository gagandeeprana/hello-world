<%@page import="dpu.services.admin.CountryServicesImpl"%>
<%@page import="dpu.services.admin.CountryServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.admin.CountryBean"%>
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
        <script type="text/javascript" src="../include/validations.js"></script>
        <script type="text/javascript">
            function check()
            {
                var s=document.getElementById("txtSearch").value;
                var msg=document.getElementById('dmsg');
                if(isEmpty(s))
                {
                    msg.innerHTML="Please enter something in order to search";
                    document.getElementById("txtSearch").focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <% CountryServicesDAO objServices = new CountryServicesImpl();
            List<CountryBean> lstCountries = objServices.getAllCountries("name");
            if (request.getParameter("sbtnSearch") != null) {
                String search = request.getParameter("txtSearch");
                lstCountries = objServices.getAllCountries(search);
            } else {
                lstCountries = objServices.getAllCountries("");
            }
            pageContext.setAttribute("LIST_COUNTRIES", lstCountries);
        %>
        
        <form action="#" method="GET" onsubmit="return check()">
           <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8 ">
                        <div class="panel">
                            <div class="panel-body">
                                <div align="center"><h2><b>Manage Countries</b></h2></div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group ">
                                            <input class="btn btn-success " type="button" name="sbtnSearch" value="Add Country" onclick="window.location = 'AddCountry.jsp'">


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
                                                    <th>Country Name</th>
                                                    <th>Status</th>
                                                    <th>Links</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_COUNTRIES}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.countryName}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${obj.status==0}">
                                                <c:set var="status" value="InActive"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="status" value="Active"></c:set>
                                            </c:otherwise>
                                        </c:choose>

                                        <a href="ControllerCountry.jsp?countryId=${obj.countryId}&status=${obj.status}">${status}</a></td>
                                    <td><a href="EditCountry.jsp?countryId=${obj.countryId}">View & Edit</a> | <a href="ManageStates.jsp?countryId=${obj.countryId}&countryName=${obj.countryName}">States</a></td>
                                </tr>
                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            
            
            
            
            
            
            
            
            
            
            
<!--            <table align="center" cellpadding="5">
                <tr>
                    <td align="center">
                  <div id="dmsg" style="color:red; background-color:white;"></div>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <strong>
                            Manage Countries
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
                                    <input type="button" class="button" value="Add Country" name="sbtnAdd" onclick="window.location = 'AddCountry.jsp'"/>
                                </td>
                                <td align="right">
                                    <input type="text" class="txtStyle" name="txtSearch" id="txtSearch"/>
                                    <input type="submit" class="button" name="sbtnSearch" value="Search"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table width="100%" style="border-collapse: collapse; border-style: inset" border="1">
                            <tr>
                                <th>
                                    S.No.
                                </th>
                                <th>
                                    Country Name
                                </th>
                                <th>
                                    Status
                                </th>
                                <th>
                                    Links
                                </th>
                            </tr>
                            <c:forEach items="${LIST_COUNTRIES}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.countryName}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${obj.status==0}">
                                                <c:set var="status" value="InActive"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="status" value="Active"></c:set>
                                            </c:otherwise>
                                        </c:choose>

                                        <a href="ControllerCountry.jsp?countryId=${obj.countryId}&status=${obj.status}">${status}</a></td>
                                    <td><a href="EditCountry.jsp?countryId=${obj.countryId}">View & Edit</a>|<a href="ManageStates.jsp?countryId=${obj.countryId}&countryName=${obj.countryName}">States</a></td>
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
