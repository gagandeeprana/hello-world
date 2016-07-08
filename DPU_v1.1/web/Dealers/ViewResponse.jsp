<%@page import="dpu.services.dealers.RequestServicesImpl"%>
<%@page import="dpu.services.dealers.RequestServicesDAO"%>
<%@page import="dpu.beans.dealers.ResponseBean"%>
<%@page import="dpu.beans.dealers.RequestBean"%>
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
        <%
            RequestServicesDAO objServices = new RequestServicesImpl();
            ResponseBean obj = objServices.getRequestInfo(Integer.parseInt(request.getParameter("request_id")));

            pageContext.setAttribute("obj", obj);
        %>

        <form>
          
            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                         <label id="lblMsg" style="color: red"><small>${param.msg}</small></label>
                        <div align="center"><h2><b>View Response</b></h2>
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
                                                ${obj.request_title}
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-question-sign"></i>
                                                    </span> 
                                                    <textarea class="form-control " placeholder="Description" name="txtUserName" type="text">${obj.request_description}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                                <div class="row" >
                                            <div class="col-md-3" >
                                                <b>Request Date</b>
                                            </div>
                                            <div class="col-md-9" >
                                              ${obj.request_date}
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-cd"></i>
                                                    </span> 
                                                    <textarea class="form-control " placeholder="Response" name="txtUserName" type="text">${obj.request_description}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="form-group pull-right">
                                                     <input type="button" name="sbtnBack" value="Back" class="btn btn-success" onclick="history.go(-1)"  />
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

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
<!--            
            <table align="center" cellpadding="5">
                <tr>
                    <td align="center">
                        <strong>
                            View Reponse
                        </strong><br/>
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
                                        <label>${obj.request_title}</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><b>Description</b></label>
                                    </td>
                                    <td>
                                        <textarea id="taDescription" cols="32" rows="4">${obj.request_description}</textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Request Date :</b>
                                    </td>
                                    <td>
                                        <label>${obj.request_date}</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label><b>Description</b></label>
                                    </td>
                                    <td>
                                        <textarea id="taDescription" cols="32" rows="4" readonly>${obj.response_description}</textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <input type="button" name="sbtnBack" value="Back" class="button" onclick="history.go(-1)"  />
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
