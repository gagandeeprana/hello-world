
<%@page import="dpu.services.admin.FaqServicesImpl"%>
<%@page import="dpu.services.admin.FaqServicesDAO"%>
<%@page import="dpu.beans.admin.FaqBean"%>
<head>
    <title></title>
    <jsp:include page="stylesheet.jsp"/>
    <script type="text/javascript" src="../include/validations.js">

    </script>
    <script type="text/javascript">
        function valid() {
            var faq = document.getElementById("taFAQ").value;
            var ans = document.getElementById("taAnswer").value;
            var msg = document.getElementById("divMsg");
            if (isEmpty(faq)) {
                msg.innerHTML = "FAQ is required";
                document.getElementById("taFAQ").focus();
                return false;
            }
            if (isEmpty(ans)) {
                msg.innerHTML = "Answer is required";
                document.getElementById("taAnswer").focus();
                return false;
            }
            return true;
        }
    </script> 
</head>
<body>
    <jsp:include page="mp_header.jsp"/>
    <%
        FaqServicesDAO objServices = new FaqServicesImpl();
        FaqBean obj = objServices.getFAQInfo(Integer.parseInt(request.getParameter("faqId")));

        pageContext.setAttribute("obj", obj);
    %>
    <div id="divMsg" style="color:red">

    </div>
    <form action="ControllerFaq.jsp" method="post" onsubmit="return valid()">
        <input type="hidden" name="faqId" value="${param.faqId}"/>
       <div class="container-fluid" style="margin-bottom: 24%;">
            <div class="row">
                <div class="col-md-3">

                </div>
                <div class="col-md-6 ">
                    <div align="center"><h2><b>Edit FAQ</b></h2></div>


                    <div class="row">
                        <div class="col-md-12 col-xs-12 ">
                            <div class="panel panel-default">
                                <div class="panel-body" >
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <input type="hidden" name="txtFaqId" value="${param.faqId}"/>
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-question-sign"></i>
                                                </span> 
                                                <textarea class="form-control " placeholder="FAQ" name="txtUserName" type="text">${obj.question}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-cd"></i>
                                                </span> 
                                                <textarea class="form-control " placeholder="Answer" name="txtUserName" type="text">${obj.answer}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="form-group pull-right">
                                                <input class="btn btn-success " type="submit" name="sbtnLogIn" value="Update">




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


        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
<!--        <table border="0" cellpadding="5" cellspacing="0" align="center">
            <tr>
                <td align="center">
                    <strong>
                        Edit  FAQ</strong><br />
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
                                    <textarea id="taFAQ" name="taFAQ" cols="32" rows="4">${obj.question}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td valign="top">
                                    <strong>Answer</strong>
                                </td>
                                <td>
                                    <textarea id="taAnswer" name="taAnswer" cols="32" rows="4">${obj.answer}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="right">
                                    <input id="sbtnUpdate" class="button" name="sbtnUpdate" type="submit" value="Update" />
                                    <input id="rbtnReset" class="button" name="rbtnReset" type="reset" value="Reset" />
                                    <input type="button" class="button" id="sbtnBack" name="sbtnBack" value="Back" onclick="window.location='ManageFAQ.jsp'"/>
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
