<html>
    <head>
        <title></title>
        <jsp:include page="stylesheet.jsp"/>
    </head>
    <body>
      
        <jsp:include page="mp_header.jsp"/>
        <form action="AuthServlet" method="post">
            <div class="container-fluid " >
                <div class="row " align="">

                    <div class="col-md-7 "></div>

                    <div class="col-md-5 ">
                        <div style="color: red"><b>
                                ${param.msg}</b>
                        </div>
                        <div class="panel panel-success" >
                            <div class="panel-heading ">
                                Login                            
                            </div>
                            <div class="panel-body">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Username" name="txtUsername" type="text">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="txtPassword" type="password" value="">
                                    </div>
                                    <div class="form-group ">
                                        <input class="btn btn-success " type="submit" name="sbtnLogin" value="Login">




                                        <input class="btn btn-success " type="reset" value="Reset">
                                    </div>
                                    <div class="form-group ">
                                        <a href="ForgotPassword.jsp">Forgot Password ?</a>
                                        <!--<a href="SignUp.jsp">Sign Up</a>-->

                                    </div>
                                </fieldset>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
















<!--
            <table border="0" cellpadding="5" cellspacing="0" align="center">
                <tr>
                    <td align="left">
                        <label id="lblMsg" style="color:red">
                            <small>${param.msg}</small></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <legend><b>Login</b></legend>
                            <table border="0" cellspacing="0">
                                <tr>
                                    <td>
                                        <strong>Username</strong>
                                    </td>
                                    <td>
                                        <input id="txtUserName" class="txtStyle" name="txtUsername" type="text" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>Password</strong>
                                    </td>
                                    <td>
                                        <input id="txtPassword" class="txtStyle" name="txtPassword" type="password" />
                                    </td>
                                </tr>

                                <tr>
                                    <td align="right" colspan="2">
                                        <input id="sbtnLogIn" name="sbtnLogin" class="button" type="submit" value="Login" />
                                        <input id="btnReset" name="btnReset" type="reset" class="button" value="Reset" />
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" colspan="2">
                                        <a href="ForgotPassword.jsp"><em>Forgot Password ?</em></a>
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
