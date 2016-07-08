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
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <form action="ControllerResponse.jsp" method="GET">
               <input type="hidden" name="request_id" value="${param.requestId}">
                <input type="hidden" name="response_user_id" value="${sessionScope.userId}">
            
            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                         <label id="lblMsg" style="color: red"><small>${param.msg}</small></label>
                        <div align="center"><h2><b>Post Response</b></h2>
                        </div>



                        <div class="row">
                            <div class="col-md-12 col-xs-12 ">
                                <div class="panel panel-default">
                                    <div class="panel-body" >
                                        <div class="row" >
                                            <div class="col-md-3" >
                                                <b>Request</b>
                                            </div>
                                            <div class="col-md-9" >
                                                ${param.requestTitle}
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-question-sign"></i>
                                                    </span> 
                                                    <textarea class="form-control " placeholder="Description" name="txtUserName" type="text">${param.description}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                                <div class="row" >
                                            <div class="col-md-3" >
                                                <b>Request Date</b>
                                            </div>
                                            <div class="col-md-9" >
                                              ${param.requestDate}
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-cd"></i>
                                                    </span> 
                                                    <textarea class="form-control " placeholder="Response" name="txtUserName" type="text"></textarea>
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

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            

<!--            <table align="center" style="border-collapse: collapse;" cellpadding="5">
             
                <tr>
                    <td align="center" colspan="2">
                        <strong>
                            Post Response
                        </strong>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label id="lblMsg" style="color: red"><small>${param.msg}</small></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table width="100%" style="border-collapse: collapse">
                                <tr>
                                    <td>
                                        <b>Request</b>
                                    </td>
                                    <td>
                                        <label>${param.requestTitle}</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><b>Description</b></label>
                                    </td>
                                    <td>
                                        <textarea id="taDescription" name="taDescription">${param.description}</textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Request Date</b>
                                    </td>
                                    <td>
                                        <label>${param.requestDate}</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><b>Response</b></label>
                                    </td>
                                    <td>
                                        <textarea id="taResponse" name="taResponse"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input type="submit" class="button" name="sbtnPost" value="Post"/>
                                        <input type="button" class="button" name="btnCancel" value="Cancel" onclick="window.location = 'ManageResponses.jsp'"/>
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
