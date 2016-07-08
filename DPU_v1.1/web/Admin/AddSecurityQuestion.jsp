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
        <script>
            function check(){
            var  msg=document.getElementById("dmsg");
            var ques=document.getElementById("taQuestion").value;
            if(isEmpty(ques)||!(isInRange(10,100,ques)))
            {
                msg.innerHTML="Question field cannot be blank. Keep the length between 10 to 100 characters";
                document.getElementById("taQuestion").focus();
                return false;
            }
            
            return true;
        }
            </script>
    </head>
    <body>
         <jsp:include page="mp_header.jsp"/>
         <form  action="ControllerSQ.jsp" method="GET" onsubmit="return check()">
            <div class="container-fluid" style="margin-bottom: 24%;">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 ">
                           <div class="panel panel-default">
                                    <div class="panel-body" >
                        <div align="center"><h2><b>Add Security Question</b></h2></div>

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
                                                    <textarea class="form-control " placeholder="Question" name="txtUserName" type="text"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-2" >

                                                <b>Status</b>
                                            </div>
                                            <div class="col-md-10" >
                                                <label class="radio-inline">
                                                    <input type="radio" name="gender" id="inlineCheckbox1" value="Active" />
                                                    Active
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="gender" id="inlineCheckbox2" value="Inactive" />
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


             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
<!--             <table align="center" cellpadding="5" width="40%">
                <tr>
                    <td colspan="2" align="center">
                        <strong>
                            Add Security Question
                        </strong>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div id="dmsg" style="color: red;background-color: white;"></div>
                    </td>
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
                            <table align="center" width="100%">
                                <tr>
                                    <td>
                                        <label><b>Question</b></label>
                                    </td>
                                    <td>
                                        <textarea id="taQuestion" name="taQuestion" cols="32" rows="4"></textarea>
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
                                        <input type="submit" name="sbtnSave" class="button" value="Save"/>
                                        <input type="submit" name="sbtnSave&AddNew" class="button" value="Save & Add New"/>
                                        <input type="button" name="sbtnBack" class="button" onclick="window.location='ManageSecurityQuestions.jsp'" value="Back"/>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr></table>-->
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
