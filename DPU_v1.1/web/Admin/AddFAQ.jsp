
<head>
    <title></title>
    <jsp:include page="stylesheet.jsp"/>
    <script type="text/javascript" src="../include/validations.js"></script>
        <script type="text/javascript">
            function check()
            {
                var faq=document.getElementById("txtFAQ").value;
                var ans=document.getElementById("txtAnswer").value;
                var msg=document.getElementById('dmsg');
                if(isEmpty(faq))
                {
                    msg.innerHTML="Question field cannot be blank";
                    document.getElementById("txtFAQ").focus();
                    return false;
                }
                if(isEmpty(ans))
                {
                    msg.innerHTML="Answer field cannot be blank";
                    document.getElementById("txtAnswer").focus();
                    return false;
                }
                return true;
            }
        </script>
</head>
<body>
     <jsp:include page="mp_header.jsp"/>
     <form action="ControllerFaq.jsp" method="post" onsubmit="return check()">
       <div class="container-fluid" style="margin-bottom: 24%;">
                    <div class="row">
                        <div class="col-md-3">

                        </div>
                        <div class="col-md-6 ">
                            <div align="center"><h2><b>Add FAQ</b></h2></div>


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
                                                        <textarea class="form-control " placeholder="FAQ" name="txtUserName" type="text"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row" >
                                                <div class="col-md-12" >
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="glyphicon glyphicon-cd"></i>
                                                        </span> 
                                                        <textarea class="form-control " placeholder="Answer" name="txtUserName" type="text"></textarea>
                                                    </div>
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
        
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
<!--         <table border="0" cellpadding="5" cellspacing="0" align="center">
            <tr>
                <td align="center"><strong>Add FAQ</strong></td>
            </tr>
            <tr>
                <td align="center">
                    <div id="dmsg" style="color:red; background-color:white;"></div></td>
            </tr>
              <tr>
                    <td align="left">
                        <label id ="lblMsg" style="color:red">
                            <small>${param.msg}</small></label>
                    </td>
            </tr>
            <tr>
                <td align="center">
                    <fieldset>
                        <table border="0" cellspacing="0" >
                            <tr>
                                <td valign="top">
                                    <strong>FAQ</strong>
                                </td>
                                <td>
                                    <textarea id="txtFAQ" name="txtFAQ" cols="32" rows="4"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td valign="top">
                                    <strong>Answer</strong>
                                </td>
                                <td>
                                    <textarea id="txtAnswer" name="txtAnswer" cols="32" rows="4"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="right">
                                    <input id="sbtnSave" name="sbtnSave" class="button" type="submit" value="Save" />
                                    <input id="sbtnSave&AddNew" class="button" name="rbtnSave&AddNew" type="submit" value="Save & Add New" />
                                    <input type="button" id="sbtnBack" class="button" name="sbtnBack" value="Back" onclick="window.location='ManageFAQ.jsp'"/>
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
