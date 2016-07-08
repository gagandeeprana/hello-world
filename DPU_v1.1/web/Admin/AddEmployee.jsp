<%@page import="dpu.services.admin.CountryServicesImpl"%>
<%@page import="dpu.services.admin.CountryServicesDAO"%>
<%@page import="dpu.beans.admin.CountryBean"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            function checkEmployee()
            {
                var un = document.getElementById("txtUsername").value;
                var pwd = document.getElementById("txtPassword").value;
                var cpwd = document.getElementById("txtConfirmPassword").value;
                var n = document.getElementById("txtName").value;
                var dob = document.getElementById("txtDob").value;
                var op = document.getElementById("txtPhone").value;
                var mob = document.getElementById("txtMobile").value;
                var mail = document.getElementById("txtEmail").value;
                var add = document.getElementById("taAddress").value;
                var ddlC = document.getElementById("ddlCountry").value;
                var ddlS = document.getElementById("ddlState").value;
                var ddlCI = document.getElementById("ddlCity").value;
                var pin = document.getElementById("txtPin").value;
                var msg = document.getElementById("lblMsg");
                if (isEmpty(un))
                {
                    msg.innerHTML = "Username cannot be blank";
                    document.getElementById("txtUsername").focus();
                    return false;
                }
                if (isEmpty(pwd) || !(isInRange(6, 16, pwd)) || isAlphaNumeric(pwd))
                {
                    msg.innerHTML = "Password field cannot be blank. Minimum 6 charcters reqd, maximum 16.It should also have one small letter, one capital letter and one alpha numeric character";
                    document.getElementById("txtPassword").focus();
                    return false;
                }
                if (isEmpty(cpwd) || cpwd != pwd)
                {
                    msg.innerHTML = "You have to confirm password.Passwords must match";
                    document.getElementById("txtConfirmPassword").focus();
                    return false;
                }
                if (isEmpty(n))
                {
                    msg.innerHTML = "Name field cannot be blank";
                    document.getElementById("txtName").focus();
                    return false;
                }
                if (isEmpty(dob))
                {
                    msg.innerHTML = "date of birth is required";
                    document.getElementById("txtDob").focus();
                    return false;
                }
                if (isEmpty(op) || !(isNumeric(op)))
                {
                    msg.innerHTML = "office phone no is required";
                    document.getElementById("txtPhone").focus();
                    return false;
                }
                if (isEmpty(mob) || !(isInRange(10, 10, mob)) || !(isNumeric(mob)))
                {
                    msg.innerHTML = "Mobile no is required.It should be of 10 digits";
                    document.getElementById("txtMobile").focus();
                    return false;
                }
                if (isEmpty(mail))
                {
//                    alert("in mail");
                    msg.innerHTML = "Email field cannot be blank";
                    document.getElementById("txtEmail").focus();
                    return false;
                }
                if (isEmpty(add) || !(isInRange(10, 100, add)))
                {
                    msg.innerHTML = "Please Enter valid complete Address. ";
                    document.getElementById("taAddress").focus();
                    return false;
                }
                if (ddlC == 0)
                {
                    msg.innerHTML = "Please enter something in order to search";
                    document.getElementById("ddlCountry").focus();
                    return false;
                }
                if (ddlS == 0)
                {
                    msg.innerHTML = "Please enter something in order to search";
                    document.getElementById("ddlState").focus();
                    return false;
                }
                if (ddlCI == 0)
                {
                    msg.innerHTML = "Please enter something in order to search";
                    document.getElementById("ddlCity").focus();
                    return false;
                }
                if (isEmpty(pin) || (!isInRange(6, 6, pin)))
                {
                    msg.innerHTML = "Enter the pin code of your area";
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
            CountryServicesDAO obj = new CountryServicesImpl();
            List<CountryBean> lstCountries = obj.getAllCountries("");
            pageContext.setAttribute("LIST_COUNTRIES", lstCountries);
        %>
        <form action="ControllerEmployee.jsp" method="GET" onsubmit="return checkEmployee()">
            <div class="container">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8">
                        <div id="divMsg">${param.msg}</div>
                        <div class="panel panel-success">
                            <div class="panel-heading " align="center">
                                <b>Add Employee</b>
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
                                            <input type="text" class="form-control" placeholder="UserName" name="txtUsername" id="txtUsername"/>

                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input type="password" class="form-control" placeholder="Password" name="txtPassword" id="txtPassword"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span> 
                                            <input type="password" class="form-control" placeholder="Confirm Password" name="txtConfirmPassword" id="txtConfirmPassword"/>
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
                                            <input type="text" class="form-control" placeholder="Name" name="txtName" id="txtName"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-2" >

                                        <b>Gender</b>
                                    </div>
                                    <div class="col-md-10" >
                                        <label class="radio-inline">
                                            <input type="radio" name="rbGender" value="M" checked="checked"/>Male
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="rbGender" value="F"/>Female
                                        </label>
                                    </div>
                                </div>


                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-calendar"></i>
                                            </span> 
                                            <input type="text" class="form-control" placeholder="D.O.B" name="txtDob" id="txtDob"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-phone-alt"></i>
                                            </span> 
                                            <input type="text" class="form-control" placeholder="Phone" name="txtPhone" id="txtPhone"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-phone"></i>
                                            </span> 
                                            <input type="text" class="form-control" placeholder="Mobile" name="txtMobile" id="txtMobile"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-globe"></i>
                                            </span> 
                                            <input type="text" class="form-control" placeholder="Email" name="txtEmail" id="txtEmail"/>
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
                                            <textarea id="taAddress" name="taAddress" class="form-control" placeholder="Address"></textarea>
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
                                                <c:forEach items="${LIST_COUNTRIES}" var="obj">
                                                    <option value="${obj.countryId}">${obj.countryName}</option>
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
                                                <select name="ddlState" id="ddlState" class="form-control" onchange="getCity()">
                                                    <option selected="selected" value="0">Select</option>
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
                                                <select id="ddlCity" name="ddlCity" class=" form-control">
                                                    <option selected="selected" value="0">Select</option>
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
                                            <input type="text" class="form-control" placeholder="Pin Code" name="txtPin" id="txtPin"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="form-group pull-right">

                                            <input type="submit" class="btn btn-success" name="sbtnSave" value="Save"/>
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
                                    <strong>Add Employee</strong>
                                </td>
                            </tr> <tr>
                                <td>
                                    <label id="lblMsg" style="color:red">
                                        <small>lblMsg</small>
                                    </label>
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
                                                                <input type="text" class="txtStyle" name="txtUsername" id="txtUsername"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">
                                                                Password
                                                            </th>
                                                            <td>
                                                                <input type="password" class="txtStyle" name="txtPassword" id="txtPassword"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th width ="30%" align="left">
                                                                Confirm Password
                                                            </th>
                                                            <td>
                                                                <input type="password" class="txtStyle" name="txtConfirmPassword" id="txtConfirmPassword"/>
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
                                                                <input type="text" class="txtStyle" name="txtName" id="txtName"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">
                                                                Gender
                                                            </th>
                                                            <td>
                                                                <input type="radio" name="rbGender" value="M" checked="checked"/>Male
                                                                <input type="radio" name="rbGender" value="F"/>Female
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">
                                                                DOB
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtDob" id="txtDob"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">
                                                                Phone
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtPhone" id="txtPhone"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">
                                                                Mobile
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtMobile" id="txtMobile"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">
                                                                Email
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtEmail" id="txtEmail"/>
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
                                                        <b>
                                                            Address Info
                                                        </b>
                                                    </legend>
                                                    <table width="100%">
                                                        <tr>
                                                            <th valign="top" align="left" width="30%">
                                                                Address  
                                                            </th>
                                                            <td>
                                                                <textarea id="taAddress" name="taAddress" rows="4" cols="32"></textarea>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">
                                                                Country
                                                            </th>
                                                            <td>
            
                                                                <select id="ddlCountry" name="ddlCountry">
                                                                    <option selected="selected" value="0">Select</option>
            <c:forEach items="${LIST_COUNTRIES}" var="obj">
                <option value="${obj.countryId}">${obj.countryName}</option>
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
            <option selected="selected" value="0">Select</option>
        </select>
    </td>
</tr>
<tr>
    <th align="left">
        City
    </th>
    <td>
        <select id="ddlCity" name="ddlCity">
            <option selected="selected" value="0">Select</option>
        </select>
    </td>
</tr>
<tr>
    <th align="left">
        Pin
    </th>
    <td>
        <input type="text" class="txtStyle" name="txtPin" id="txtPin"/>
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
<input type="submit" class="button" name="sbtnSave" value="Save"/>
<input type="button" class="button" name="btnBack" value="Back" onclick="window.location = 'ManageEmployees.jsp'"/>
</td>
</tr>
</table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
