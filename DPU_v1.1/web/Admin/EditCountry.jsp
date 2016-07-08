<%@page import="dpu.services.admin.CountryServicesImpl"%>
<%@page import="dpu.services.admin.CountryServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            CountryServicesDAO objServices = new CountryServicesImpl();
            CountryBean obj = objServices.getCountryInfoById(Integer.parseInt(request.getParameter("countryId")));
            pageContext.setAttribute("obj", obj);
        %>
        <form action="ControllerCountry.jsp" method="GET">
            <input type="hidden" name="txtCountryId" value="${param.countryId}"/> 

            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                        <div align="center"><h2><b>Edit Country</b></h2></div>

                        <div class="row">
                            <div class="col-md-12 col-xs-12 ">
                                <div class="panel panel-default">
                                    <div class="panel-body" >
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <input type="hidden" name="txtCountryId" value="${param.countryId}"/>
                                                        <i class="glyphicon glyphicon-user"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="Country Name" value="${obj.countryName}" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-2" >

                                                <b>Status</b>
                                            </div>
                                            <c:choose>
                                                <c:when test="${obj.status==1}">
                                                    <c:set var="active" value="checked"/>
                                                </c:when>
                                                <c:when test="${obj.status==0}">
                                                    <c:set var="inactive" value="checked"/>
                                                </c:when>
                                            </c:choose>
                                            <div class="col-md-10" >
                                                <label class="radio-inline">
                                                    <input type="radio" name="gender" id="inlineCheckbox1" value="male" ${active}/>
                                                    Active
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="gender" id="inlineCheckbox2" value="female" ${inactive}/>
                                                    InActive
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="form-group pull-right">
                                                    <input class="btn btn-success " type="submit" name="sbtnLogIn" value="Save">




                                                    <input class="btn btn-success " type="reset" value="Back">
                                                </div>
                                            </div>
                                        </div>



                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">

                    </div>
                </div>
            </div>



















            <!--            <table align="center" cellpadding="5">
                            <tr>
                                <td align="center" colspan="2">
                                    <strong>
                                        Edit Country
                                    </strong>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <fieldset>
                                        <table align="center">
                                            <tr>
                                                <td align="left">
                                                    <label><b>Country Name<b></label>
                                                                </td>
                                                                <td>
                                                                    <input type="text" class="txtStyle" name="txtCountryName" value="${obj.countryName}"/>
                                                                </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left">
                                                                        <label><b>Status</b></label>
                                                                    </td>
                                                                    <td>
            <c:choose>
                <c:when test="${obj.status==1}">
                    <c:set var="active" value="checked"/>
                </c:when>
                <c:when test="${obj.status==0}">
                    <c:set var="inactive" value="checked"/>
                </c:when>
            </c:choose>
            <input type="radio" name="rbStatus" value="1" ${active}/>Active
            <input type="radio" name="rbStatus" value="0" ${inactive}/>InActive
        </td>
    </tr>
    <tr>
        <td colspan="2" align="right">
            <input type="submit" class="button" name="sbtnUpdate" value="Update"/>
            <input type="button" class="button" name="sbtnBack" value="Back" onclick="window.location = 'ManageCountry.jsp'"/>
        </td>
    </tr>
    </table>
    </fieldset>
    </td>
    </tr>
    </table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
