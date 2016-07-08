<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <jsp:include page="stylesheet.jsp"/>
        <title></title>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <form action="ForgotPasswordServlet" method="post">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-success">
                            <div class="panel-heading " align="center">
                                <b>Forgot Password</b>
                            </div>
                            <div class="panel-body"  style="text-align: justify;">
                                <p>
                                    If you have forgotten your password, you can have it recover.
                                    Please enter your username address below to do so.
                                </p>
                                <p>
                                    An email with the instructions to recover your password will be sent to you.
                                </p>
                            </div>
                            <div class="panel-body">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Username" name="txtUserName" type="text">
                                    </div>
                                    <div class="form-group">

                                        <select class="form-control" id="sel1">
                                            <option class="active">Security Question</option>
                                            <c:forEach items="${LIST_SECURITY}" var="obj">
                                                <option value="${obj.securityQuestionId}">${obj.question}</option>
                                            </c:forEach>

                                        </select>



                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Answer" name="txtUserName" type="text">
                                    </div>
                                    <div class="form-group pull-right">
                                        <input class="btn btn-success " type="submit" name="sbtnLogIn" value="Submit">




                                        <input class="btn btn-success " type="reset" value="Cancel">
                                    </div>

                                </fieldset>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-md-3">

                </div>
            </div>
            
            
            
            
            
            
            
            
            
            
            
<!--            <table border="0" cellpadding="5" cellspacing="0" align="center">
                <tr>
                    <td align="center"><strong>Forgot Password</strong></td>
                </tr>
                <tr>
                    <td><label id="lblMsg" style="color:red"><small>${param.msg}</small></label></td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <div>If you have forgotten your password, you can have it recovered.
                                <br />
                                Please enter your username and email address below to do so.<br />
                                <br />
                                <label>  An email with the instructions to recover your password will be sent to you.</label>
                            </div>
                            <table border="0" cellpadding="5" cellspacing="0">
                                <tr>
                                    <td><strong>Username</strong></td>
                                    <td><input id="txtUsername" class="txtStyle" name="txtUsername" type="text" /></td>

                                </tr>
                                <tr>
                                    <td></td>
                                    <td align="right"><input id="sbtnSubmit" class="button" name="sbtnSubmit" type="submit" value="Submit" />&nbsp;<input id="btnCancel" class="button" name="btnCancel" type="button" value="Cancel" onclick="window.location = 'Login.jsp'" />
                                    </td>
                                </tr>
                            </table>
                            <c:if test="${param.msg.contains('successfully')}">
                                <hr/>
                                <div>
                                    Your Password has been sent to your email id.<br/>
                                    Please check your email for further instruction.<br/>
                                    Please <a href="Login.jsp">Click here</a> to go back to the login page.
                                </div>
                            </c:if>
                        </fieldset>
                    </td>
                </tr>
            </table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
