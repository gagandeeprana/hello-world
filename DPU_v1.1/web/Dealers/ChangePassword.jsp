<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <jsp:include page="stylesheet.jsp"/>
        <title>Change Password</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <script type="text/javascript" src="../include/validations.js">

        </script>
        <script type="text/javascript">
            function check() {
                
                var pwd = document.getElementById("txtPassword").value;
                var npwd = document.getElementById("txtNewPassword").value;
                
                var cpwd = document.getElementById("txtConfirmPassword").value;
                var msg = document.getElementById("lblMsg");
                
                if (isEmpty(pwd)) {
                    msg.innerHTML = "Old Password Field is Empty";
                    document.getElementById("txtPassword").focus();
                    return false;
                }
                if (isEmpty(npwd)) {
                    msg.innerHTML = "New Password Field is Empty";
                    document.getElementById("txtNewPassword").focus();
                    return false;
                }
                if (isInRange(6, 20, npwd))
                {
                    msg.innerHTML = "New Password Field is exceeding its range";
                    document.getElementById("txtNewPassword").focus();
                    return false;
                }
                if (!npwd.equals(cpwd)) {
                    msg.innerHTML = "Confirm Password Field is not matched with the new password";
                    document.getElementById("txtConfirmPassword").focus();
                    return false;
                }
                return  true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <form action="../ChangePasswordServlet" method="get" onsubmit="return check()">
            
            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                           <div class="panel panel-default">
                                    <div class="panel-body" >
                        <div align="center"><h2><b>Change Password</b></h2></div>

                        <div class="row">
                            <div class="col-md-12 col-xs-12 ">
                             
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-lock"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="Current Password" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-lock"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="New Password" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-lock"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="Confirm Password" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="form-group pull-right">
                                                    <input class="btn btn-success " type="submit" name="sbtnLogIn" value="Change">




                                                    <input class="btn btn-success " type="reset" value="Reset">
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
                    <td align="center"><strong>Change Password</strong></td>
                </tr>
                <tr>
                    <td align="left">
                        <label id ="lblMsg" style="color:red">
                            <small>${param.msg}</small></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table width="100%">
                                <tr>
                                    <td>
                                        <b>Old Password</b>
                                    </td>
                                    <td>
                                        <input type="password" name="txtPassword" id="txtPassword" class="txtStyle"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>New Password</b>
                                    </td>
                                    <td>

                                        <input type="password" name="txtNewPassword" id="txtNewPassword" class="txtStyle"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Confirm Password</b>
                                    </td>
                                    <td>

                                        <input type="password" name="txtConfirmPassword" id="txtConfirmPassword" class="txtStyle"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right"><input id="sbtnSubmit" name="sbtnChange" type="submit" value="Save" class="button"/><input id="btnCancel" name="btnCancel" type="button" class="button" value="Cancel" onclick="window.location='Homepage.jsp'" />
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
