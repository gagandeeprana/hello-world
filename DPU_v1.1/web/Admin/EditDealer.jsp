<%@page import="dpu.services.admin.CityServicesImpl"%>
<%@page import="dpu.services.admin.CityServicesDAO"%>
<%@page import="dpu.services.admin.StateServicesImpl"%>
<%@page import="dpu.services.admin.StateServicesDAO"%>
<%@page import="dpu.services.admin.CountryServicesImpl"%>
<%@page import="dpu.services.admin.CountryServicesDAO"%>
<%@page import="dpu.services.admin.DealersServicesDAO"%>
<%@page import="dpu.services.admin.DealersServicesImpl"%>
<%@page import="dpu.beans.admin.CityBean"%>
<%@page import="dpu.beans.admin.StateBean"%>
<%@page import="dpu.beans.admin.DealersBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.CountryBean"%>
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
        <script type="text/javascript" src="../include/validations.js">
        </script>
        <script type="text/javascript">
            function check() {

                var user = document.getElementById("txtUsername").value;
                var pass = document.getElementById("txtPassword").value;
                var cpass = document.getElementById("txtConfirmPassword").value;
                var name = document.getElementById("txtName").value;
                var OP = document.getElementById("txtDob").value;
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
                if (isEmpty(OP)) {
                    msg.innerHTML = "Office Phone is Required";
                    document.getElementById("txtDob").focus();
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
            $(document).ready(function() {
                $('#ddlCountry').change(function() {
                    var cid = $('#ddlCountry').val();
                    $('#ddlCity').html('<option selected="selected" value="0">select</option>');
                    $.get('States.jsp?countryId=' + cid, function(res) {
                        $('#ddlState').html(res);
                    });
                });
                $('#ddlState').change(function() {

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

                    $.get('Cities.jsp?stateId=' + sid, function(resp) {

                        $('#ddlCity').html(resp);
                    });
                });
            });
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            DealersServicesDAO objServices = new DealersServicesImpl();
            DealersBean objDeal = objServices.getDealerInfoById(Integer.parseInt(request.getParameter("dealerId")));
            System.out.println(objDeal.getTxtUsername());
            pageContext.setAttribute("obj", objDeal);
            CountryServicesDAO obj = new CountryServicesImpl();
            List<CountryBean> lstCountries = obj.getAllCountries("");
            pageContext.setAttribute("LIST_COUNTRIES", lstCountries);
            StateServicesDAO objSS = new StateServicesImpl();
            List<StateBean> lstStates = objSS.getStatesByCountryId(objDeal.getDdlCountry());
            pageContext.setAttribute("LIST_STATES", lstStates);
            CityServicesDAO objCI = new CityServicesImpl();
            List<CityBean> lstCities = objCI.getCitiesByStateId(objDeal.getDdlState());
            pageContext.setAttribute("LIST_CITIES", lstCities);
        %>
        <div id="divMsg" style="color:red"></div>
        <form action="ControllerDealer.jsp" method="GET" onsubmit="return check()">
        
            
            
            
            
            
            <input type="hidden" name="txtDealerId" value="${param.dealerId}"/>
            <form action="ControllerDealer.jsp" method="GET" onsubmit="return checkDealer()">

            <div class="container">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8">
                        <div id="divMsg">${param.msg}</div>
                        <div class="panel panel-success">
                            <div class="panel-heading " align="center">
                                <b>Edit Dealer</b>
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
                                            <input class="form-control " placeholder="Username" name="txtUsername" type="text" value="${obj.txtUsername}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Password" name="txtPassword" type="password" value="${obj.txtPassword}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Confirm Password" name="txtConfirmPassword" type="password" value="${obj.txtPassword}"/>
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
                                            <input class="form-control " placeholder="Name" name="txtUserName" type="text" value="${obj.txtName}"/>
                                        </div>
                                    </div>
                                </div>


                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-calendar"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Date Of Birth" name="txtUserName" type="text" value="${obj.txtDob}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-phone-alt"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Phone" name="txtUserName" type="text" value="${obj.contact}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-phone"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Mobile" name="txtUserName" type="text" value="${obj.txtMobile}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-globe"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Email" name="txtUserName" type="text" value="${obj.txtEmail}"/>
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
                                            <textarea class="form-control " placeholder="Address" name="txtUserName" type="text">${obj.taAddress}</textarea>
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
                                                            <c:if test="${obj.ddlCountry==objC.countryId}">
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
                                                            <c:if test="${obj.ddlState==objSS.stateId}">
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
                                            <select id="ddlCity" name="ddlCity" class=" form-control">
                                                        <option selected="selected" value="0">select</option>
                                                        <c:forEach items="${LIST_CITIES}" var="objCI">
                                                            <c:set var="flag" value=""/>
                                                            <c:if test="${obj.ddlCity==objCI.cityId}">
                                                                <c:set var="flag" value="selected"/>

                                                            </c:if>
                                                            <option value="${objCI.cityId}" ${flag} >${objCI.name}</option>
                                                        </c:forEach>
                                                    </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-ban-circle"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Pin Code" name="txtUserName" type="text" value="${obj.txtPin}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="form-group pull-right">
                                            <input class="btn btn-success " type="submit" name="sbtnLogIn" value="Save">




                                            <input class="btn btn-success " type="reset" value="Cancel">
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
                        <strong>Edit Dealer</strong>
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
                                                <th align="left">
                                                    Username
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtUsername" id="txtUsername" value="${obj.txtUsername}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Password
                                                </th>
                                                <td>
                                                    <input type="password" class="txtStyle" name="txtPassword" id="txtPassword" value="${obj.txtPassword}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left" width ="30%">
                                                    Confirm Password
                                                </th>
                                                <td>
                                                    <input type="password" class="txtStyle"  name="txtConfirmPassword" id="txtConfirmPassword" value=""/>
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
                                                <th align="left" width="30%">
                                                    Name
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtName" id="txtName" value="${obj.txtName}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Office Phone
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtDob" id="txtDob" value="${obj.txtDob}"/>
                                                </td>
                                            </tr>

                                            <tr>
                                                <th align="left">
                                                    Mobile
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtMobile" id="txtMobile" value="${obj.txtMobile}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Email
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtEmail" id="txtEmail" value="${obj.txtEmail}"/>
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
                                                <th valign="top" align="left" width="30%">
                                                    Address  
                                                </th>
                                                <td>
                                                    <textarea name="taAddress" id="taAddress" rows="4" cols="27">${obj.taAddress}</textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Country
                                                </th>
                                                <td>
                                                    <select id="ddlCountry" name="ddlCountry">
                                                        <option selected="selected" value="0">Select</option>
                                                        <c:forEach items="${LIST_COUNTRIES}" var="objC">
                                                            <c:set var="flag" value=""/>
                                                            <c:if test="${obj.ddlCountry==objC.countryId}">
                                                                <c:set var="flag" value="selected"/>

                                                            </c:if>
                                                            <option value="${objC.countryId}" ${flag}>${objC.countryName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    State
                                                </th>
                                                <td>
                                                    <select id="ddlState" name="ddlState">
                                                        <option selected="selected" value="0">select</option>
                                                        <c:forEach items="${LIST_STATES}" var="objSS">
                                                            <c:set var="flag" value=""/>
                                                            <c:if test="${obj.ddlState==objSS.stateId}">
                                                                <c:set var="flag" value="selected"/>

                                                            </c:if>
                                                            <option value="${objSS.stateId}"  ${flag} >${objSS.stateName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    City
                                                </th>
                                                <td>
                                                    <select id="ddlCity" name="ddlCity">
                                                        <option selected="selected" value="0">select</option>
                                                        <c:forEach items="${LIST_CITIES}" var="objCI">
                                                            <c:set var="flag" value=""/>
                                                            <c:if test="${obj.ddlCity==objCI.cityId}">
                                                                <c:set var="flag" value="selected"/>

                                                            </c:if>
                                                            <option value="${objCI.cityId}" ${flag} >${objCI.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Pin
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtPin" id="txtPin" value="${obj.txtPin}"/>
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
                        <input type="button" class="button" name="btnBack" value="Back" onclick="window.location = 'ManageDealers.jsp'"/>
                    </td>
                </tr>
            </table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
