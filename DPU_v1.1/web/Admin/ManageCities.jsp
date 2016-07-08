<%@page import="dpu.services.admin.CityServicesImpl"%>
<%@page import="dpu.services.admin.CityServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.CityBean"%>
<%@page import="java.util.List"%>

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
            CityServicesDAO objServices = new CityServicesImpl();
            List<CityBean> lstCities = null;
            int sId = 0;
            String sName = "";
            if (request.getParameter("stateId") != null) {
                sId = Integer.parseInt(request.getParameter("stateId"));
                sName = request.getParameter("countryName");
                session.setAttribute("sId", sId);
                session.setAttribute("sName", request.getParameter("stateName"));
            } else {
                sId = Integer.parseInt(request.getSession().getAttribute("sid").toString());
                sName = request.getSession().getAttribute("sName").toString();
            }
            if (request.getParameter("sbtnSearch") != null) {
                lstCities = objServices.getAllCities(sId, request.getParameter("txtSearch"));
            } else {
                lstCities = objServices.getAllCities(sId, "");
            }
            pageContext.setAttribute("LIST_CITIES", lstCities);
        %>
        <form action="ManageCities.jsp" method="GET">
            
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8 ">
                        <div class="panel">
                            <div class="panel-body">
                                <div align="center"><h2><b>Manage Cities</b></h2></div>
                                <div class="row" style="margin-bottom: 5px;">
                                    <div class="col-md-9 ">
                                        <b>Country: </b>${sessionScope.cName}
                                    </div>
                                    <div class="col-md-3 ">
                                        <b>State:</b>
                                        ${sessionScope.sName}
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group ">
                                            <input class="btn btn-success " type="button" name="sbtnSearch" value="<" onclick="window.location = 'ManageCountry.jsp'">
                                            <input class="btn btn-success " type="button" name="sbtnSearch" value="Add City" onclick="window.location = 'AddCity.jsp'">


                                        </div>



                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="CityName" name="txtSearch" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">



                                            <input class="btn btn-success  " type="submit" name="sbtnSearch" value="Search">




                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 col-xs-12 ">
                                        <table class="table table-hover table-responsive ">

                                            <thead>
                                                <tr>
                                                    <th>S.no</th>
                                                    <th>State Name</th>
                                                    <th>Status</th>
                                                    <th>Links</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_CITIES}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.name}</td>
                                    <td> <c:choose>
                                            <c:when test="${obj.status==0}">
                                                <c:set var="status" value="InActive"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="status" value="Active"></c:set>
                                            </c:otherwise>
                                        </c:choose>
                                        <a href="ControllerCity.jsp?cityId=${obj.cityId}&status=${obj.status}">${status}</a></td>
                                    <td>
                                        <a href="EditCity.jsp?cityId=${obj.cityId}">View & Edit</a>&nbsp;
                                    </td>
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
                    <td align="center" colspan="2">
                        <strong>
                            Manage Cities
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
                        <b>Country :</b> 
                        <label>${sessionScope.cName}</label>
                    </td>
                    <td align="right">
                        <b>State :</b> 
                        <label>${sessionScope.sName}</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table width="100%">
                            <tr>
                                <td>
                                    <input type="button" class="button" value="Add City" onclick="window.location = 'AddCity.jsp'"/>
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
                    <td colspan="2">
                        <table width="100%" style="border-collapse: collapse; border-style: inset" border="1">
                            <tr>
                                <th>
                                    S.No.
                                </th>
                                <th>
                                    City Name
                                </th>
                                <th>
                                    Status
                                </th>
                                <th>
                                    Links
                                </th>
                            </tr>
                            <c:forEach items="${LIST_CITIES}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.name}</td>
                                    <td> <c:choose>
                                            <c:when test="${obj.status==0}">
                                                <c:set var="status" value="InActive"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="status" value="Active"></c:set>
                                            </c:otherwise>
                                        </c:choose>
                                        <a href="ControllerCity.jsp?cityId=${obj.cityId}&status=${obj.status}">${status}</a></td>
                                    <td>
                                        <a href="EditCity.jsp?cityId=${obj.cityId}">View & Edit</a>&nbsp;
                                    </td>
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
