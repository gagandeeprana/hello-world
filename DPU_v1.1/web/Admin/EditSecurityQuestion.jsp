<%@page import="dpu.services.admin.SecurityQuestionServicesDAO"%>
<%@page import="dpu.services.admin.SecurityQuestionServicesImpl"%>
<%@page import="dpu.beans.admin.QuestionsBean"%>
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
                var que = document.getElementById("taQuestion").value;
                var msg = document.getElementById("divMsg");
                if (isEmpty(que)) {
                    msg.innerHTML = "question is required";
                    document.getElementById("taQuestion").focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <%
            SecurityQuestionServicesDAO objServices = new SecurityQuestionServicesImpl();
            QuestionsBean obj = objServices.getSQInfoById(Integer.parseInt(request.getParameter("qId")));
            pageContext.setAttribute("STATUS_" + obj.getStatus(), "checked='checked'");
            pageContext.setAttribute("obj", obj);
        %>
        <div id="divMsg" style="color:red"></div>
        <form action="ControllerSQ.jsp" method="post" onsubmit="return check()">
            <input type="hidden" name="txtSecurityId" value="${param.qId}"/>
            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                           <div class="panel panel-default">
                                    <div class="panel-body" >
                        <div align="center">
                            <input type="hidden" name="txtQstnId" value="${param.securityQuestionId}"/>
                            <h2><b>Edit Security Question</b></h2></div>

                        <label id="lblMsg" style="color: red">
                            <small>
                                ${param.msg}</small>
                        </label>
                        <div class="row">
                            <div class="col-md-12 col-xs-12 ">
                             
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-question-sign"></i>
                                                    </span> 
                                                    <textarea class="form-control " placeholder="Question" name="txtUserName" type="text">${obj.taQuestion}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-2" >

                                                <b>Status</b>
                                            </div>
                                            <div class="col-md-10" >
                                                <label class="radio-inline">
                                                    <input type="radio" name="gender"${STATUS_1} id="inlineCheckbox1" value="Active" />
                                                    Active
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="gender" ${STATUS_0} id="inlineCheckbox2" value="Inactive" />
                                                    InActive
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="form-group pull-right">
                                                    <input class="btn btn-success " type="submit" name="sbtnUpdate" value="Update">




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
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
<!--            <table align="center" width="35%" cellpadding="5">
                <tr>
                    <td colspan="2" align="center">
                        <strong>Edit Security Question</strong><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table align="center" width="100%">

                                <tr>
                                    <td valign="top">
                                        <label><b>Question</b></label>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="32" name="taQuestion" id="taQuestion">${obj.taQuestion}</textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><b>Status</b></label>
                                    </td>
                                    <td>
                                        <input type="radio" name="rbStatus" ${STATUS_1} value="1"/>Active
                                        <input type="radio" name="rbStatus" ${STATUS_0} value="0"/>InActive
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input type="submit" class="button" name="sbtnUpdate" value="Update"/>
                                        <input type="button" class="button" name="sbtnBack" value="Back" onclick="window.location='ManageSecurityQuestions.jsp'"/>
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
