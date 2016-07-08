
<%@page import="properties.ReadFromPropertyFile"%>
<%@page import="dpu.beans.admin.CityBean"%>
<%@page import="dpu.services.admin.CityServices"%>
<%@page import="dpu.beans.admin.StateBean"%>
<%@page import="dpu.services.admin.StateServices"%>
<%@page import="dpu.services.admin.ProfileServices"%>
<%@page import="dpu.beans.admin.ProfileBean"%>
<%@page import="dpu.beans.admin.CountryBean"%>
<%@page import="java.util.List"%>
<%@page import="dpu.services.admin.CountryServices"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <jsp:include page="stylesheet.jsp"/>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <script type="text/javascript">
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
            function submitForm(buttonName)
            {
                var frm = document.getElementById('frmProfile');
                if (buttonName == 'btnUpload')
                {
                    frm.method = 'POST';
                    frm.action = '../UploadProfilePicServlet';
                    frm.enctype = 'multipart/form-data';
                    frm.submit();
                }
                else if (buttonName == 'btnUpdate') {
                    frm.method = 'GET';
                    frm.action = 'ControllerProfile.jsp';
                    frm.submit();
                }
            }

        </script>
    </head>
    <body>
        <%
            ProfileServices objServices = new ProfileServices();
            String userId = session.getAttribute("userId").toString();
            ProfileBean objUser = objServices.getUserInfoById(Integer.parseInt(userId));
            pageContext.setAttribute("obj", objUser);
            CountryServices obj = new CountryServices();
            List<CountryBean> lstCountries = obj.getAllCountries("");
            pageContext.setAttribute("LIST_COUNTRIES", lstCountries);
            StateServices objSS = new StateServices();
            List<StateBean> lstStates = objSS.getStatesByCountryId(objUser.getDdlCountry());
            pageContext.setAttribute("LIST_STATES", lstStates);
            CityServices objCI = new CityServices();
            List<CityBean> lstCities = objCI.getCitiesByStateId(objUser.getDdlState());
            pageContext.setAttribute("LIST_CITIES", lstCities);
            pageContext.setAttribute("imagePath", ReadFromPropertyFile.rootURL + "/" + userId + "/" + objUser.getFlImage());
        %>
        <jsp:include page="mp_header.jsp"/>
        <form id="frmProfile" onsubmit="">
           
            <input type="hidden" name="userId" value="${sessionScope.userId}"/>
            <input type="hidden" name="btnUpdate" value="${sessionScope.userId}"/>
            
            <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div align="center"><h2><b>Manage Profile</b></h2></div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                <input class="form-control " placeholder="Username" readonly="" name="txtUsername" value="  ${sessionScope.username}" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                <input class="form-control " placeholder="Name"  name="txtUsername" value="${obj.txtName}" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-2" >

                                            <b>Gender</b>
                                            <c:choose>
                                                <c:when test="${obj.rbGender.equalsIgnoreCase('M')}">
                                                    <c:set var="Male" value="checked"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:set var="Female" value="checked"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="col-md-10" >
                                            <label class="radio-inline">
                                                <input type="radio" name="gender" id="inlineCheckbox1" value="male" ${Male}/>
                                                Male
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="gender" id="inlineCheckbox2" value="female" ${Female}/>
                                                Female
                                            </label>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                <input class="form-control " placeholder="D.O.B"  name="txtUsername" value="${obj.txtDOB}" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                <input class="form-control " placeholder="Phone"  name="txtUsername" value="${obj.txtPhone}" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                <input class="form-control " placeholder="Mobile"  name="txtUsername" value="${obj.txtMobile}" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                <input class="form-control " placeholder="Email"  name="txtUsername" value="${obj.txtEmail}" type="text"/>
                                            </div>
                                        </div>
                                    </div>


                                </div>
                                <div class="col-md-6">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <img src="boy.jpg" alt="no image" class="img-responsive"/>
                                            <!--<img src="${imagepath}" alt="no image" class="img-responsive"/>-->

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <input type="file" name="flProfileImage" class=""/>

                                        </div>
                                        <div class="col-md-6">
                                            <input type="submit" name="btnUpload" value="Upload"  class="btn btn-success">

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-default" >
                                        <div class="panel-heading " >
                                            <b>Personal Information</b>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-user"></i>
                                                    </span> 
                                                    <textarea placeholder="address" name="taAddress" class="form-control">${obj.txtAddress}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-globe"></i>
                                                    </span> 
                                                    <select name="ddlCountry" id="ddlCountry" class="form-control">
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
                                                        <select name="ddlState" id="ddlState" class="form-control">
                                                        <option selected="selected" value="0">Select</option>
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
                                                    <div id="divC">
                                                        <select name="ddlCity" id="ddlCity" class="form-control">
                                                        <option selected="selected" value="0">Select</option>
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
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-ban-circle"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="Pin Code" value="${obj.txtPin}"  name="txtUserName" type="text"/>
                                                </div>
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
                    <div class="col-md-2">

                    </div>
                </div>
            </div>
        </div>

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
<!--            <table align="center">
                <tr><td colspan="2" align="center"><strong>Manage Profile</strong></td></tr>
                <tr>
                <tr>
                    <td>
                        <label id="lblMsg" style="color: red"><small>
                                ${param.msg}
                            </small></label>
                    </td>
                </tr>
                <td>
                    <table width="100%" style="font-size: small">
                        <tr>
                            <td>
                                <fieldset>
                                    <table>
                                        <tr>
                                            <td valign="bottom">
                                                <table width="100%">
                                                    <tr>
                                                        <th align="left" width="30%">
                                                            UserName
                                                        </th>
                                                        <td>
                                                            <label>
                                                                ${sessionScope.username}
                                                            </label>
                                                        </td>
                                                    <tr>
                                                        <th align="left" width="30%">
                                                            Name
                                                        </th>
                                                        <td>
                                                            <input type="text" class="txtStyle" name="txtName" value="${obj.txtName}"  />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th align="left" width="30%">
                                                            Gender
                                                        </th>
                                                        <td>
                                                            <input type="radio" name="rbGender" value="M" checked />Male
                                                            <input type="radio" name="rbGender" value="F" />Female
                                                        </td>
                                                    </tr>

                                                    <tr>
                                                        <th align="left" width="30%">
                                                            DOB
                                                        </th>
                                                        <td>
                                                            <input type="text" class="txtStyle" name="txtDOB" value="${obj.txtDOB}" />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th align="left" width="30%">
                                                            Phone
                                                        </th>
                                                        <td>
                                                            <input type="text" class="txtStyle" name="txtPhone" value="${obj.txtPhone}"/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th align="left" width="30%">
                                                            Mobile
                                                        </th>
                                                        <td>
                                                            <input type="text" class="txtStyle" name="txtMobile" value="${obj.txtMobile}" />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th align="left" width="30%">
                                                            Email
                                                        </th>
                                                        <td>
                                                            <input type="text" class="txtStyle" name="txtEmail" value="${obj.txtEmail}" />
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td valign="bottom">
                                                <table width="100%">
                                                    <tr>
                                                        <td align="center">
                                                            <img src="${imagePath}" width="120" height="142" alt="Screenshot-2"/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center">
                                                            <br/>
                                                            <input type="file" name="flProfileImage" value="Change" id="fileImage">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center">
                                                            <br/>
                                                            <input type="button" onclick="submitForm('btnUpload')" class="button" name="sbtnUploadImage" value="Upload">
                                                        </td>
                                                    </tr>
                                                </table>
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
                                    <fieldset style="font-size: medium" >
                                        <legend><b>Address Info</b></legend>
                                        <table align="center" width="100%">
                                            <tr>
                                                <th align="left" width="15%">
                                                    Address
                                                </th>
                                                <td>
                                                    <textarea name="txtAddress" rows="4" cols="32">${obj.txtAddress}</textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Country
                                                </th>
                                                <td>
                                                    <select name="ddlCountry" id="ddlCountry">
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
                                                    <select name="ddlState" id="ddlState">
                                                        <option selected="selected" value="0">Select</option>
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
                                                    <select name="ddlCity" id="ddlCity">
                                                        <option selected="selected" value="0">Select</option>
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
                                                    <input type="text" class="txtStyle" name="txtPin" value="${obj.txtPin}"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </fieldset>
                            <tr align="right">
                                <td>
                                    <input align="right" type="button" onclick="submitForm('btnUpdate')" class="button" name="sbtnUpdate" value="Update"/>
                                    <input align="right" type="button" class="button" name="btnBack" value="Back" onclick="window.location = 'Homepage.jsp'"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
