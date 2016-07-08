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
              var feed=document.getElementById("taFeedback").value;
              var msg=document.getElementById("lblMsg");
              if(isEmpty(feed)){
                  msg.innerHTML="feedback field is empty";
                  document.getElementById("taFeedback").focus();
                  return false;
              }
              return true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <form action="FeedbackController.jsp" method="post" onsubmit="return check()">
            <input type="hidden" name="txtuserId" value="${sessionScope.userId}"/>
            
            
             <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                        <label id="lblMsg" style="color: red"><small>${param.msg}</small></label>
                        <div align="center"><h2><b>Post Feedback</b></h2>
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
                                                    <textarea class="form-control " placeholder="Feedback" name="txtUserName" type="text">${sessionScope.description}</textarea>
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
                            Post Feedback
                        </strong>
                    </td>
                </tr>
		<tr>
                    <td align="left">
                        <label id="lblMsg" style="color:red">
                            <small>${param.result}</small>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table>
                                <tr>
                                    <td valign="top">
                                        <b>Feedback</b>
                                    </td>
                                    <td>
                                        <textarea name="taFeedback" id="taFeedback"  cols="32" rows="4"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input type="submit" name="sbtnPost" value="Post" class="button"/>
                                        <input type="button" name="btnCancel" value="Cancel" class="button" onclick="window.location='Homepage.jsp'"/>
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
