<%@page import="dpu.services.admin.CityServicesImpl"%>
<%@page import="dpu.services.admin.CityServicesDAO"%>
<%@page import="dpu.services.admin.StateServicesImpl"%>
<%@page import="dpu.services.admin.StateServicesDAO"%>
<%@page import="dpu.services.admin.CountryServicesImpl"%>
<%@page import="dpu.services.admin.CountryServicesDAO"%>
<%@page import="dpu.services.admin.EmployeesServicesImpl"%>
<%@page import="dpu.services.admin.EmployeesServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.CityBean"%>
<%@page import="dpu.beans.admin.StateBean"%>
<%@page import="dpu.beans.admin.CountryBean"%>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.admin.EmployeesBean"%>
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
            function check() {

                var user = document.getElementById("txtUsername").value;

                var pass = document.getElementById("txtPassword").value;

                var cpass = document.getElementById("txtConfirmPassword").value;

                var name = document.getElementById("txtName").value;

                var dob = document.getElementById("txtDob").value;

                var OP = document.getElementById("txtPhone").value;

                var mobile = document.getElementById("txtMobile").value;

                var email = document.getElementById("txtEmail").value;

                var add = document.getElementById("taAddress").value;

                var country = document.getElementById("ddlCountry").value;

                var state = document.getElementById("ddlState").value;
                var city = document.getElementById("ddlCity").value;
                var pin = document.getElementById("txtPin").value;
                var msg = document.getElementById("divMsg");
                if (isEmpty(user)) {
                    msg.innerHTML = "Username is Required";
                    document.getElementById("txtUsername").focus();
                    return false;
                }
                if (isEmpty(pass)) {
                    msg.innerHTML = "Password is Required";
                    document.getElementById("txtPassword").focus();
                    return false;
                }
                if (isInRange(6, 20, pass))
                {
                    msg.innerHTML = "New Password Field is exceeding its range";
                    document.getElementById("txtPassword").focus();
                    return false;
                }

                if (cpass != pass) {
                    msg.innerHTML = "Confirm Password Field is not matched with the password";
                    document.getElementById("txtConfirmPassword").focus();
                    return false;
                }
                if (isEmpty(name)) {
                    msg.innerHTML = "Name is Required";
                    document.getElementById("txtName").focus();
                    return false;
                }
                if (isEmpty(dob)) {
                    msg.innerHTML = "DOB is Required";
                    document.getElementById("txtDob").focus();
                    return false;
                }
                if (isEmpty(OP)) {
                    msg.innerHTML = "Office Phone is Required";
                    document.getElementById("txtPhone").focus();
                    return false;
                }
                if (isEmpty(mobile)) {
                    msg.innerHTML = "Mobile is Required";
                    document.getElementById("txtMobile").focus();
                    return false;
                }
                if (!isEmail(email)) {
                    msg.innerHTML = "Email is Required/Incorrect Syntax";
                    document.getElementById("txtEmail").focus();
                    return false;
                }
                if (isEmpty(add)) {
                    msg.innerHTML = "Address is Required";
                    document.getElementById("taAddress").focus();
                    return false;
                }
                if (isSelected(country)) {
                    msg.innerHTML = "Country is Required";
                    document.getElementById("ddlCountry").focus();
                    return false;
                }
                if (isSelected(state)) {
                    msg.innerHTML = "State is Required";
                    document.getElementById("ddlState").focus();
                    return false;
                }
                if (isSelected(city)) {
                    msg.innerHTML = "City is Required";
                    document.getElementById("ddlCity").focus();
                    return false;
                }
                if (isEmpty(pin)) {
                    msg.innerHTML = "Pin Code is Required";
                    document.getElementById("txtPin").focus();
                    return false;
                }
                return true;
            }
            $(document).ready(function () {
                $('#ddlCountry').change(function () {
                    var cid = $('#ddlCountry').val();
                    $('#ddlCity').html('<option selected="selected" value="0">select</option>');
                    $.get('States.jsp?countryId=' + cid, function (res) {
                        $('#ddlState').html(res);

                    });
                });
                $('#ddlState').change(function () {

                    var sid = $('#ddlState').val();

//                    $.ajax({
//                        type: 'GET',
//                        data: 'stateId=' + sid,
//                        url: "Cities.jsp",
//                        success: function(data, textStatus, jqXHR) {
//                            alert("Success " + data)
//
//                        },
//                        error: function(jqXHR, textStatus, errorThrown) {
//                            alert("Error " + errorThrown)
//                        }
//                    })

                    $.get('Cities.jsp?stateId=' + sid, function (resp) {

                        $('#ddlCity').html(resp);
                    });
                });
            });
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            EmployeesServicesDAO objServices = new EmployeesServicesImpl();
            EmployeesBean objEmp = objServices.getEmployeeInfoById(Integer.parseInt(request.getParameter("employeeId")));
            pageContext.setAttribute("objEmp", objEmp);
            CountryServicesDAO obj = new CountryServicesImpl();
            List<CountryBean> lstCountries = obj.getAllCountries("");
            pageContext.setAttribute("LIST_COUNTRIES", lstCountries);
            StateServicesDAO objSS = new StateServicesImpl();
            List<StateBean> lstStates = objSS.getStatesByCountryId(objEmp.getDdlCountry());
            pageContext.setAttribute("LIST_STATES", lstStates);
            CityServicesDAO objCI = new CityServicesImpl();
            List<CityBean> lstCities = objCI.getCitiesByStateId(objEmp.getDdlState());
            pageContext.setAttribute("LIST_CITIES", lstCities);
        %>
        <div id="divMsg" style="color:red"></div>
        <form action="ControllerEmployee.jsp" method="GET" onsubmit="return check()">
            <input type="hidden" name="txtEmployeeId" value="${param.employeeId}"/>
            <div class="container">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8">
                       
                        <div class="panel panel-success">
                            <div class="panel-heading " align="center">
                                <b>Edit Employee</b>
                                 <div id="divMsg">${param.msg}</div>
                            </div>
                            <div class="panel-heading " >
                                <b>Account Information</b>
                            </div>
                            <div class="panel-body" >
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-user"></i>
                                            </span> 
                                            <input type="text" class="form-control" name="txtUsername" id="txtUsername" value="${objEmp.txtUsername}" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input type="password" class="form-control" name="txtPassword" id="txtPassword" value="${objEmp.txtPassword}" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input type="password" class="form-control" name="txtConfirmPassword" id="txtConfirmPassword" value="${objEmp.txtPassword}"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-heading " >
                                <b>Personal Information</b>
                            </div>
                            <div class="panel-body" >
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-user"></i>
                                            </span> 
                                            <input type="text" class="form-control" name="txtName" id="txtName" value="${objEmp.txtName}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-2" >

                                        <b>Gender</b>
                                    </div>
                                    <c:choose>
                                        <c:when test="${obj.rbGender.equalsIgnoreCase('M')}">
                                            <c:set var="Male" value="checked"/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="Female" value="checked"/>
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="col-md-10" >
                                        <label class="radio-inline">
                                            <input type="radio" name="rbGender" value="M" checked="checked" ${Male}/>Male
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="rbGender" value="F" ${Female}/>Female
                                        </label>
                                    </div>
                                </div>


                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-calendar"></i>
                                            </span> 
                                            <input type="text" class="form-control" name="txtDob" id="txtDob" value="${objEmp.txtDob}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-phone-alt"></i>
                                            </span> 
                                            <input type="text" class="form-control" name="txtPhone" id="txtPhone" value="${objEmp.txtPhone}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-phone"></i>
                                            </span> 
                                            <input type="text" class="form-control" id="txtMobile" value="${objEmp.txtMobile}" name="txtMobile"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-globe"></i>
                                            </span> 
                                            <input type="text" class="form-control" name="txtEmail" value="${objEmp.txtEmail}" id="txtEmail"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-heading " >
                                <b>Address Information</b>
                            </div>
                            <div class="panel-body" >
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-home"></i>
                                            </span> 
                                            <textarea name="taAddress" id="taAddress" class="form-control">${objEmp.taAddress}</textarea>
                                        </div>
                                    </div>
                                </div>



                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-globe"></i>
                                            </span> 
                                            <select id="ddlCountry" name="ddlCountry" class="form-control">
                                                <option selected="selected" value="0">Select</option>
                                                <c:forEach items="${LIST_COUNTRIES}" var="objC">
                                                    <c:set var="flag" value=""/>
                                                    <c:if test="${objEmp.ddlCountry==objC.countryId}">
                                                        <c:set var="flag" value="selected"/>

                                                    </c:if>
                                                    <option value="${objC.countryId}" ${flag}>${objC.countryName}</option>
                                                </c:forEach>
                                            </select>

                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-globe"></i>
                                            </span> 
                                            <div id="divS">
                                                <select id="ddlState" name="ddlState" class="form-control">
                                                    <option selected="selected" value="0">select</option>
                                                    <c:forEach items="${LIST_STATES}" var="objSS">
                                                        <c:set var="flag" value=""/>
                                                        <c:if test="${objEmp.ddlState==objSS.stateId}">
                                                            <c:set var="flag" value="selected"/>

                                                        </c:if>
                                                        <option value="${objSS.stateId}"  ${flag} >${objSS.stateName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-globe"></i>
                                            </span> 
                                            <div id="divC">
                                                <select id="ddlCity" name="ddlCity" class="form-control">
                                                    <option selected="selected" value="0">select</option>
                                                    <c:forEach items="${LIST_CITIES}" var="objCI">
                                                        <c:set var="flag" value=""/>
                                                        <c:if test="${objEmp.ddlCity==objCI.cityId}">
                                                            <c:set var="flag" value="selected"/>

                                                        </c:if>
                                                        <option value="${objCI.cityId}" ${flag} >${objCI.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-ban-circle"></i>
                                            </span> 
                                       <input type="text" class="form-control" name="txtPin" id="txtPin" value="${objEmp.txtPin}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="form-group pull-right">
                                            <input type="submit" class="btn btn-success" name="sbtnUpdate" value="Update"/>
                                            <input type="button" class="btn btn-success" name="btnBack" value="Back" onclick="window.location = 'ManageEmployees.jsp'"/>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="panel-body" >









                            </div>

                        </div>
                        <div class="col-md-2">

                        </div>

                    </div>
                </div>
            </div>

























            <!--            <table align="center" cellpadding="5">
                            <tr>
                                <td align="center">
                                    <strong>Edit Employee</strong>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="100%">
                                        <tr>
                                            <td>
                                                <fieldset>
                                                    <legend>
                                                        <b>Account Info</b>
                                                    </legend>
                                                    <table width="100%">
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                Username
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtUsername" id="txtUsername" value="${objEmp.txtUsername}" />
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                Password
                                                            </th>
                                                            <td>
                                                                <input type="password" class="txtStyle" name="txtPassword" id="txtPassword" value="${objEmp.txtPassword}" />
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                Confirm Password
                                                            </th>
                                                            <td>
                                                                <input type="password" class="txtStyle" name="txtConfirmPassword" id="txtConfirmPassword" value="${objEmp.txtPassword}"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </fieldset>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="100%">
                                        <tr>
                                            <td>
                                                <fieldset>
                                                    <legend><b>Personal Info</b></legend>
                                                    <table width="100%">
                                                        <tr>
                                                            <th width="30%" align="left">
                                                                Name
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtName" id="txtName" value="${objEmp.txtName}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                Gender
                                                            </th>
                                                            <td>
                                                                <input type="radio" name="rbGender" value="M" checked="checked"/>Male
                                                                <input type="radio" name="rbGender" value="F"/>Female
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                DOB
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtDob" id="txtDob" value="${objEmp.txtDob}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                Phone
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtPhone" id="txtPhone" value="${objEmp.txtPhone}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                Mobile
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" id="txtMobile" value="${objEmp.txtMobile}" name="txtMobile"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                Email
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtEmail" value="${objEmp.txtEmail}" id="txtEmail"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </fieldset>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="100%">
                                        <tr>
                                            <td>
                                                <fieldset>
                                                    <legend>
                                                        <b>Address Info</b>
                                                    </legend>
                                                    <table width="100%">
                                                        <tr>
                                                            <th align="left" valign="top" width="30%">
                                                                Address  
                                                            </th>
                                                            <td>
                                                                <textarea name="taAddress" id="taAddress" rows="4" cols="32">${objEmp.taAddress}</textarea>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left" width="30%">
                                                                Country
                                                            </th>
                                                            <td>
                                                                <select id="ddlCountry" name="ddlCountry">
                                                                    <option selected="selected" value="0">Select</option>
            <c:forEach items="${LIST_COUNTRIES}" var="objC">
                <c:set var="flag" value=""/>
                <c:if test="${objEmp.ddlCountry==objC.countryId}">
                    <c:set var="flag" value="selected"/>

                </c:if>
                <option value="${objC.countryId}" ${flag}>${objC.countryName}</option>
            </c:forEach>
        </select>
    </td>
</tr>
<tr>
    <th align="left" width="30%">
        State
    </th>
    <td>
        <select id="ddlState" name="ddlState">
            <option selected="selected" value="0">select</option>
            <c:forEach items="${LIST_STATES}" var="objSS">
                <c:set var="flag" value=""/>
                <c:if test="${objEmp.ddlState==objSS.stateId}">
                    <c:set var="flag" value="selected"/>

                </c:if>
                <option value="${objSS.stateId}"  ${flag} >${objSS.stateName}</option>
            </c:forEach>
        </select>
    </td>
</tr>
<tr>
    <th align="left" width="30%">
        City
    </th>
    <td>
        <select id="ddlCity" name="ddlCity">
            <option selected="selected" value="0">select</option>
            <c:forEach items="${LIST_CITIES}" var="objCI">
                <c:set var="flag" value=""/>
                <c:if test="${objEmp.ddlCity==objCI.cityId}">
                    <c:set var="flag" value="selected"/>

                </c:if>
                <option value="${objCI.cityId}" ${flag} >${objCI.name}</option>
            </c:forEach>
        </select>
    </td>
</tr>
<tr>
    <th align="left" valign="top" width="30%">
        Pin  
    </th>
    <td>
        <input type="text" class="txtStyle" name="txtPin" id="txtPin" value="${objEmp.txtPin}"/>
    </td>
</tr>
</table>
</fieldset>
</td>
</tr>
</table>
</td>
</tr>
<tr>
<td align="right">
<input type="submit" class="button" name="sbtnUpdate" value="Update"/>
<input type="button" class="button" name="btnBack" value="Back" onclick="window.location = 'ManageEmployees.jsp'"/>
</td>
</tr>
</table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
