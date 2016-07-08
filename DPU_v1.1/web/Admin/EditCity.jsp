<%@page import="dpu.services.admin.CityServicesImpl"%>
<%@page import="dpu.services.admin.CityServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.admin.CityBean"%>
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
        <script type="text/javascript" src="../include/validations.js">
        </script>
        <script type="text/javascript" >
            function checkCity() {
                var tc = document.getElementById("txtCityName").value;
                var msg = document.getElementById("city");
                if (isEmpty(tc)) {
                    msg.innerHTML = "City name is required";
                    document.getElementById("txtCityName").focus();
                    return false;
                }
                return true;
            }

        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            CityServicesDAO objServices = new CityServicesImpl();
            CityBean obj = objServices.getCityInfoById(Integer.parseInt(request.getParameter("cityId")));
            pageContext.setAttribute("obj", obj);
            pageContext.setAttribute("st_" + obj.getStatus(), "checked='checked'");
        %> 
        <form action="ControllerCity.jsp" method="GET" onsubmit="return checkCity()">
            <input type="hidden" name="txtCityId" value="${param.cityId}"/>
            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                        <div class="panel panel-default">
                            <div class="panel-body" >
                                <div align="center"><h2><b>Edit City</b></h2></div>
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
                                    <div class="col-md-12 col-xs-12 ">

                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-user"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="City Name" name="txtUserName" value="${obj.name}" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-2" >
                                                <c:choose>
                                                    <c:when test="${obj.status.equals('1')}">
                                                        <c:set var="active" value="checked"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:set var="inactive" value="checked"/>
                                                    </c:otherwise>
                                                </c:choose>
                                                <b>Status</b>
                                            </div>
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
                <div id="city" style="color: red;"></div>
                <tr>
                    <td align="center">
                        <strong>
                            Edit City
                        </strong><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table align="center" width="100%">
                                <tr>
                                    <td>
                                        <table width="100%">
                                            <tr>
                                                <td>
                                                    <b>Country: </b>
                                                    <label id="lblCountry">India</label>
                                                </td>
                                                <td>
                                                    <b>State: </b>
                                                    <label id="lblState">Punjab</label>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <table width="100%">
                                            <tr>
                                                <td align="left">
                                                    <label><b>City Name</b></label>
                                                </td>
                                                <td>
                                                    <input type="hidden" name="txtCityId" value="${obj.cityId}>">                                                                                
                                                    <input type="text" class="txtStyle" name="txtCityName" id="txtCityName" value="${obj.name}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="left">
                                                    <label><b>Status</b></label>
                                                </td>
                                                <td>

                                                    <input type="radio" name="rbStatus" value="1" ${st_1}/>
                                                    Active
                                                    <input type="radio" name="rbStatus" value="0" ${st_0}>
                                                    InActive


                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">
                                        <input type="submit" class="button" name="sbtnUpdate" value="Update"/>
                                        <input type="button" class="button" name="sbtnBack" value="Back" onclick="window.location = 'ManageCities.jsp'"/>
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
