<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="navigation">
    <ul>
        <li><a href="Homepage.jsp">Home</a></li>
            <c:if test="${sessionScope.userType.equalsIgnoreCase('admin')}">
            <li><a href="ManageEmployees.jsp">Employees</a>
                <div>
                    <ul style="width:100%;margin-left: 10px;">
                        <li><a href="AddEmployee.jsp">Add New Employee</a></li>
                    </ul>
                </div>
            </li>

        </c:if>
        <li><a href="ManageDealers.jsp">Dealers</a>
            <div>
                <ul style="width:100%;margin-left:10px;">
                    <li><a href="AddDealer.jsp">Add Dealer</a></li>
                </ul>
            </div>
        </li>
        <li><a href="#">Orders</a>
            <div>
                <ul style="margin-left:10px;">
                    <li style="min-width: 250px;width:250px;"><a href="ManageOrders.jsp">Manage Orders</a></li>
                    <li style="min-width: 250px;width:250px;"><a href="ManageProcessedOrders.jsp">Manage Processed Orders</a></li>
                </ul>
            </div>
        </li>
        <li><a href="">Manage</a>
            <div>
                <ul style="width:100%;margin-left:10px;">
                    <li><a href="ManageFAQ.jsp">FAQ</a>
                    <li><a href="ManageSecurityQuestions.jsp">Manage Security Question</a></li>
                    <li><a href="ManageFeedback.jsp">Manage Feedback</a></li>
                    <li><a href="ManageCountry.jsp">Manage Country</a></li>
                    <li><a href="ManageResponses.jsp">Manage Response</a></li>
                </ul>
            </div>
        </li>
        <c:if test="${sessionScope.userType.equalsIgnoreCase('admin')}">
            <li><a href="">Reports</a>
                <div>
                    <ul style="width:100%;margin-left:10px;">
                        <li><a href="../ReportServlet?fileName=EmployeeReport.jasper" target="_blank">Employees</a></li>
                        <li><a href="../ReportServlet?fileName=DealerReport.jasper" target="_blank">Dealers</a></li>
                    </ul>
                </div>
            </li>
        </c:if>
        <li><a href="#">Settings</a>
            <div>
                <ul style="width:100%;margin-left:10px;">
                    <li><a href="ManageProfile.jsp">Profile</a></li>
                    <li><a href="ChangePassword.jsp">Change password</a></li>
                    <li><a href="../Logout.jsp">Logout</a></li>
                </ul>
            </div>
        </li>
    </ul>
</div>