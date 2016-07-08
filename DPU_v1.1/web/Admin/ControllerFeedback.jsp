<%@page import="dpu.services.admin.FeedbackServicesImpl"%>
<%@page import="dpu.services.admin.FeedbackServicesDAO"%>
<jsp:useBean id="objFeedbackBean" class="dpu.beans.admin.FeedbackBean">
    <jsp:setProperty name="objFeedbackBean" property="*"/>
</jsp:useBean>
<%
    FeedbackServicesDAO objServices = new FeedbackServicesImpl();
    String result = "";
    if (request.getParameter("feedbackId") != null) {
        int feedbackId = Integer.parseInt(request.getParameter("feedbackId"));
        result = objServices.deleteFeedback(feedbackId);
        response.sendRedirect("ManageFeedback.jsp?msg=" + result);
    }
%>