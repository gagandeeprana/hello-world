<%@page import="dpu.services.admin.StateServicesImpl"%>
<%@page import="dpu.services.admin.StateServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.StateBean"%>
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
            function checkState() {
                var tc = document.getElementById("txtStateName").value;
                var msg = document.getElementById("city");
                if (isEmpty(tc)) {
                    msg.innerHTML = "State name is required";
                    document.getElementById("txtStateName").focus();
                    return false;
                }
                return true;
            }

        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            StateServicesDAO objServices = new StateServicesImpl();
            String stateId = "0";
            if (request.getParameter("stateId") != null) {
                stateId = request.getParameter("stateId");
            }
            StateBean obj = objServices.getStateInfoById(Integer.parseInt(request.getParameter("stateId")));
            pageContext.setAttribute("obj", obj);
        %>   
        <div id="city" style="color: red;">

        </div>

        <form action="ControllerState.jsp" method="GET" onsubmit="return checkState()">
            <input type="hidden" name="txtStateId" value="${param.stateId}"/>
           <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                        <div align="center"><h2><b>Edit State</b></h2></div>
                        <div class="row" style="margin-bottom: 5px;">
                            <div class="col-md-9 ">
                                <b>Country: </b>${sessionScope.cName}
                            </div>


                        </div>

                        <div class="row">
                            <div class="col-md-12 col-xs-12 ">
                                <div class="panel panel-default">
                                    <div class="panel-body" >
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-user"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="State Name" name="txtUserName"  value="${obj.stateName}" type="text"/>
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
                <tr>
                    <td colspan="2" align="center">
                        <strong>Edit State</strong>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table align="center">
                                <tr>
                                    <td>
                                        <b>Country:</b>
                                    </td>
                                    <td>
                                        <label id="lblCountry">${sessionScope.cName}</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left">
                                        <label id="lblState"><b>State Name:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="txtStyle" name="txtStateName" id="txtStateName" value="${obj.stateName}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left">
                                        <label><b>Status</b></label>
                                    </td>
                                    <td>
                                        <input type="radio" name="rbStatus" value="1" checked/>Active
                                        <input type="radio" name="rbStatus" value="0"/>InActive
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input type="submit" class="button" name="sbtnUpdate" value="Update"/>
                                        <input type="submit" class="button" name="sbtnBack" value="Back" onclick="window.location = 'ManageStates.jsp'"/>
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
