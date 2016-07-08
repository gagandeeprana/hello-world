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
            function check(){
              var request=document.getElementById("txtRequestTitle").value;
              var des=document.getElementById("taDescription").value;
              var msg=document.getElementById("lblMsg");
              if(isEmpty(request)){
                  msg.innerHTML="Request Title field is empty";
                  document.getElementById("txtRequestTitle").focus();
                  return false;
              }
              if(isEmpty(des)){
                  msg.innerHTML="Description field is empty";
                  document.getElementById("taDescription").focus();
                  return false;
              }
              return true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <form action="RequestController.jsp" method="post" onsubmit="return check()">
            <input type="hidden" name="txtUserId" value="${sessionScope.userId}"/>
            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                        <label id="lblMsg" style="color: red"><small>${param.msg}</small></label>
                                <div align="center"><h2><b>Post Request</b></h2>
                    </div>



                    <div class="row">
                        <div class="col-md-12 col-xs-12 ">
                            <div class="panel panel-default">
                                    <div class="panel-body" >
                                       
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-question-sign"></i>
                                                    </span> 
                                                    <textarea class="form-control " placeholder="Request Title" name="txtUserName" type="text">${sessionScope.description}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-cd"></i>
                                                    </span> 
                                                    <textarea class="form-control " placeholder="Description" name="txtUserName" type="text"></textarea>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="form-group pull-right">
                                                    <input class="btn btn-success " type="submit" name="sbtnLogIn" value="Post">




                                                    <input class="btn btn-success " type="reset" value="Cancel">
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
                    <td align="center">
                        <strong>
                            Post Request
                        </strong>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label id="lblMsg" style="color:red">
                            <small>${param.msg}</small>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table>
                                <tr>
                                    <td>
                                        <b>Request Title :</b>
                                    </td>
                                    <td>
                                        <input type="text" name="txtRequestTitle" id="txtRequestTitle" class="txtStyle"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><b>Description</b></label>
                                    </td>
                                    <td>
                                        <textarea  name="taDescription" id="taDescription" cols="30" rows="3"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input type="submit" name="sbtnPost" value="Post" class="button"/>
                                        <input type="button" name="btnCancel" value="Cancel" class="button" onclick="window.location='ManageRequest.jsp'"/>
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
