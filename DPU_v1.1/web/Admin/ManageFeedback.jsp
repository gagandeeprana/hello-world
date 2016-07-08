<%@page import="dpu.services.admin.FeedbackServicesImpl"%>
<%@page import="dpu.services.admin.FeedbackServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.FeedbackBean"%>
<%@page import="java.util.List"%>
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
        <% FeedbackServicesDAO objServices = new FeedbackServicesImpl();

            List<FeedbackBean> lstFeedback = null;
            if (request.getParameter("sbtnFilter") != null) {
                String st = request.getParameter("txtFrom");
                String et = request.getParameter("txtTo");
                lstFeedback = objServices.getAllFeedbacks(st, et);
            } else {
                lstFeedback = objServices.getAllFeedbacks("", "");
            }
            pageContext.setAttribute("LIST_FEEDBACK", lstFeedback);
        %>
        <form action="#" method="GET">

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8 ">
                        <div class="panel">
                            <div class="panel-body">
                                <div align="center"><h2><b>Manage FeedBack</b></h2></div>
                                <div class="row">
                                    <div class="col-md-2 ">

                                    </div>
                                    <div class="col-md-4 ">



                                        <input class="form-control pull-right" placeholder="From" name="txtFrom" type="text" value="">

                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">

                                            <input class="form-control pull-right" placeholder="To" name="txtTo" type="text" value="">






                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">



                                            <input class="btn btn-success  " type="submit" name="sbtnSearch" value="Filter">




                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 col-xs-6 ">
                                        <table class="table table-hover table-responsive ">

                                            <thead>
                                                <tr>
                                                    <th>S.no</th>
                                                    <th>Feedback</th>
                                                    <th>Posted By</th>
                                                    <th>Date</th>
                                                    <th>Links</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${LIST_FEEDBACK}" var="obj" varStatus="i">
                                                    <tr>
                                                        <td>${i.index+1}</td>
                                                        <td>${obj.feedback}</td>
                                                        <td>${obj.posted_by}</td>
                                                        <td>${obj.dt}</td>
                                                        <td><a href = "ControllerFeedback.jsp?feedbackId=${obj.feedbackId}">Delete</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">

                    </div>
                </div>
            </div>


















<!--            <table align="center" cellpadding="5">

                <tr>
                    <td align="center">
                        <strong>Manage Feedback</strong>
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
                        <table align="center" width="100%">
                            <tr>
                                <td>
                                    <label><b>From</b></label>
                                    <input type="text" class="txtStyle" name="txtFrom"/>
                                </td>
                                <td>
                                    <label><b>To</b></label>
                                    <input type="text" class="txtStyle" name="txtTo"/>
                                </td>
                                <td>
                                    <input type="submit" class="button" name="sbtnFilter" value="Filter"/>
                                </td>
                            </tr>
                        </table>
                    </td> 
                </tr>
                <tr>
                    <td>
                        <table align="center" style="border-collapse: collapse" border="1" width = 100%>
                            <tr>
                                <th>
                                    S.No.
                                </th>
                                <th>
                                    Feedback
                                </th>
                                <th>
                                    Posted By
                                </th>
                                <th>
                                    Date
                                </th>
                                <th>
                                    Links
                                </th>
                            </tr>
                            <c:forEach items="${LIST_FEEDBACK}" var="obj" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${obj.feedback}</td>
                                    <td>${obj.posted_by}</td>
                                    <td>${obj.dt}</td>
                                    <td><a href = "ControllerFeedback.jsp?feedbackId=${obj.feedbackId}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div id="divfk" style="border-collapse: collapse; border-style: inset;border: 1px black">
                            <b>Feedback :</b><label>Good Website</label><br/>
                            <b>Posted By :</b><label>chandan</label><br/>
                            <b>Date :</b><label>2014-09-09</label>
                        </div>
                    </td>
                </tr>
            </table>-->

        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
