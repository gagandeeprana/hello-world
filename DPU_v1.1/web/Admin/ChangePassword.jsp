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
    </head>
    <body>
        <form action="../ChangePasswordServlet" method="GET">
         <jsp:include page="mp_header.jsp"/>
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
            
            
            
            
         
         
         
         
         
         
         
         
         
         
         
<!--         <table align="center" cellpadding="5">
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
                                <input type="password" class="txtStyle" name="txtPassword" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>New Password</b>
                            </td>
                            <td>

                                <input type="password" class="txtStyle" name="txtNewPassword" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Confirm Password</b>
                            </td>
                            <td>

                                <input type="password" class="txtStyle" name="txtConfirmPassword" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right"><input id="sbtnSubmit" class="button" name="sbtnChange" type="submit" value="Save"/><input id="btnCancel" class="button" name="btnCancel" type="button" value="Cancel" onclick="window.location='Homepage.jsp'" />
                            </td>
                        </tr>
                    </table>
		</fieldset>
                </td>
            </tr>

        </table>-->
        <jsp:include page="mp_footer.jsp"/>
        </form>
    </body>
</html>
