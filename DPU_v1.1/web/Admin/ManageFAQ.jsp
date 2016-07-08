
<%@page import="dpu.services.admin.FaqServicesImpl"%>
<%@page import="dpu.services.admin.FaqServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="dpu.beans.admin.FaqBean"%>
<head>
    <jsp:include page="stylesheet.jsp"/>
    <title></title>
</head>
<body>
    <jsp:include page="mp_header.jsp"/>
    <%
        FaqServicesDAO objServices = new FaqServicesImpl();
        List<FaqBean> lstFaq = objServices.getAllFaq();
        if (request.getParameter("ddlStatus") != null) {

            lstFaq = objServices.getAllFaqByStatus(request.getParameter("ddlStatus"));
            pageContext.setAttribute("st_"+request.getParameter("ddlStatus"), "selected='selected'");
        }
        pageContext.setAttribute("LIST_FAQ", lstFaq);
    %>
    <form action="ManageFAQ.jsp">

       <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">

            </div>
            <div class="col-md-8 ">
                <div class="panel ">
                    <div class="panel-body ">
                        <div align="center"><h2><b>Manage FAQ</b></h2></div>
                        <div class="row">
                            <div class="col-md-9">
                                <div class="form-group ">
                                    <input class="btn btn-success " type="button" name="sbtnSearch" value="Add FAQ" onclick="window.location = 'AddFAQ.jsp'">


                                </div>



                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <select name="ddlStatus" class="form-control">
                                        <option value="">Status</option>
                                        <option value="1" ${STATUS_1}>Active</option>
                                        <option value="0" ${STATUS_0}>InActive</option>
                                    </select>




                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 col-xs-6 ">
                                <table class="table table-hover table-responsive ">

                                    <thead>
                                        <tr>
                                            <th>S.no</th>
                                            <th>FAQ</th>
                                            <th>Answer</th>
                                            <th>Status</th>
                                            <th>Links</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <c:forEach items="${LIST_FAQ}" var="obj" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${obj.question}</td>
                                <td>${obj.answer}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${obj.status==0}">
                                            <c:set var="status" value="InActive"></c:set>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="status" value="Active"></c:set>
                                        </c:otherwise>
                                    </c:choose>

                                    <a href="ControllerFaq.jsp?faqId=${obj.faqId}&status=${obj.status}">${status}</a></td>
                                <td><a href="EditFAQ.jsp?faqId=${obj.faqId}">View & Edit</a></td>
                            </tr>
                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">

                    </div>
                </div>
            </div>
        </div>
    </div>

 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
<!--        <table border="0" cellpadding="5" cellspacing="0" align="center">

            <tr>
                <td align="center" colspan="2">
                    <strong>
                        Manage FAQ</strong>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label id="lblMsg" style="color:red">
                        <small>${param.msg}</small>
                    </label>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <input type="button" class="button" id="btnAddFAQ" name="btnAddFAq" onclick="window.location = 'AddFAQ.jsp'" value="Add FAQ"/>
                </td>
                <td align="right">
                    <b>Status</b>
                    <select name="ddlStatus" onchange="submit()">
                        <option value="2" ${st_2}>Select</option>
                        <option value="1" ${st_1}>Active</option>
                        <option value="0" ${st_0}>InActive</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <table border="1" style="border-collapse: collapse; border-style: inset" cellspacing="0" >
                        <tr>
                            <th>
                                FAQ Id
                            </th>
                            <th>
                                FAQ</th>
                            <th>
                                Answer</th>
                            <th>
                                Status
                            </th>
                            <th>Links
                            </th>
                        </tr>

                        <c:forEach items="${LIST_FAQ}" var="obj" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${obj.question}</td>
                                <td>${obj.answer}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${obj.status==0}">
                                            <c:set var="status" value="InActive"></c:set>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="status" value="Active"></c:set>
                                        </c:otherwise>
                                    </c:choose>

                                    <a href="ControllerFaq.jsp?faqId=${obj.faqId}&status=${obj.status}">${status}</a></td>
                                <td><a href="EditFAQ.jsp?faqId=${obj.faqId}">View & Edit</a></td>
                            </tr>
                        </c:forEach>

                    </table>
                </td>
            </tr>
        </table>-->
    </form>
    <jsp:include page="mp_footer.jsp"/>
</body>
</html>
