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
            function check()
            {
                var s=document.getElementById("txtCountryName").value;
                var msg=document.getElementById('lblMsg');
                if(isEmpty(s))
                {
                    msg.innerHTML="Country Name cannot be blank";
                    document.getElementById("txtCountryName").focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
         <jsp:include page="mp_header.jsp"/>
         <form action="ControllerCountry.jsp" method="GET" onsubmit="return check()">
            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                        <div align="center"><h2><b>Add Country</b></h2></div>

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
                                                    <input class="form-control " placeholder="Country Name" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-2" >

                                                <b>Status</b>
                                            </div>
                                            <div class="col-md-10" >
                                                <label class="radio-inline">
                                                    <input type="radio" name="gender" id="inlineCheckbox1" value="male" />
                                                    Active
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="gender" id="inlineCheckbox2" value="female" />
                                                    InActive
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="form-group pull-right">
                                                    <input class="btn btn-success " type="submit" name="sbtnLogIn" value="Save">
                                                    <input class="btn btn-success " type="submit" name="sbtnLogIn" value="Save& Add New">




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
             
             
             
             
             
             
             
             
             
             
             
<!--             <table align="center" cellpadding="5">
                <tr>
                    <td align="center">
                  <div id="dmsg" style="color:red; background-color:white;"></div>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <strong>
                            Add Country
                        </strong>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label id="lblMsg" style="color:red">
                            <small>Add Country Details below</small>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table>
                                <tr>
                                    <td>
                                        <label><b>Country Name</b></label>
                                    </td>
                                    <td>
                                        <input type="text" class="txtStyle" name="txtCountryName" id="txtCountryName"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><b>Status</b></label>
                                    </td>
                                    <td>
                                        <input type="radio" name="rbStatus" value="1" checked="checked"/>Active
                                        <input type="radio" name="rbStatus" value="0"/>InActive
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input class="button" type="submit" name="sbtnSave" value="Save"/>
                                        <input class="button" type="submit" name="sbtnSave&AddNew" value="Save & Add New"/>
                                        <input class="button" type="button" name="sbtnBack" value="Back" onclick="window.location='ManageCountry.jsp'"/>
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
