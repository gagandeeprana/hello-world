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
                var s = document.getElementById("txtCountryName").value;
                var msg = document.getElementById('lblMsg');
                if (isEmpty(s))
                {
                    msg.innerHTML = "Country Name cannot be blank";
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
                        <div align="center"><h2><b>Send Message</b></h2></div>

                        <div class="row">
                            <div class="col-md-12 col-xs-12 ">
                                <div class="panel panel-default">
                                    <div class="panel-body" >
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <b>Category</b>
                                                    </span> 
                                                    <select class="form-control">
                                                        <option>Select</option>
                                                        <option>Jokes</option>
                                                        <option>Technology</option>
                                                        <option>Travel</option>
                                                        <option>Misc.</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-phone"></i>
                                                    </span> 
                                                    <select class="form-control">
                                                        <option>Select</option>
                                                        <option>+91 9888903691</option>
                                                        <option>+91 9987435973</option>
                                                        <option>+91 8765465545</option>
                                                        <option>+91 2343567676</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <b>Language</b>
                                                    </span> 
                                                    <select class="form-control">
                                                        <option>Select</option>
                                                        <option>English</option>
                                                        <option>Hindi</option>
                                                        <option>Punjabi</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <b class="glyphicon glyphicon-send"></b>
                                                    </span> 
                                                    <textarea cols="60" rows="5" class="form-control"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="form-group pull-right">
                                                    <input class="btn btn-success " type="reset" value="Send Message">
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
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
