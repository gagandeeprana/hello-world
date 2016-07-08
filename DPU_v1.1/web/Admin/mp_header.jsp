<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #footer {
        height: 30px;
        background-color: white;
        margin-top:30%;

        padding-top:10px;
        padding-bottom:30px;
    }
      .row{
        padding-bottom: 10px; 
    }


</style>
<header  style="background-color: white;margin-bottom: 0px;">
    <img src="../images/logo_new.png" class="img-responsive" style=""/>
</header>

<nav class="navbar navbar-inverse " >
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <ul class="nav navbar-nav collapse navbar-collapse" id="myNavbar">
        <li>
            <a href="Homepage.jsp" class="glyphicon glyphicon-home active"></a>
        </li>
        <c:if test="${sessionScope.userType.equalsIgnoreCase('admin')}">
            <li>
                <a href="ManageEmployees.jsp">Employees</a>
            </li>

        </c:if>
        <li>
            <a href="ManageDealers.jsp">Dealers</a>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                Orders
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="ManageOrders.jsp">Manage Orders</a>
                </li>
                <li>
                    <a href="ManageProcessedOrders.jsp">Manage Processed Orders</a>
                </li>

            </ul>
        </li>
        
        
        
        
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                Manage
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a href="ManageFAQ.jsp">FAQ</a>
                <li><a href="ManageSecurityQuestions.jsp">Manage Security Question</a></li>
                <li><a href="ManageFeedback.jsp">Manage Feedback</a></li>
                <li><a href="ManageCountry.jsp">Manage Country</a></li>
                <li><a href="ManageResponses.jsp">Manage Response</a></li>

            </ul>
        </li>
        <c:if test="${sessionScope.userType.equalsIgnoreCase('admin')}">

            
            
            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    Reports
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="../ReportServlet?fileName=EmployeeReport.jasper">Users</a>
                    </li>
                    <li>
                        <a href="../ReportServlet?fileName=DealerReport.jasper">Employees</a>
                    </li>
                </ul>
            </li>
        </c:if>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                Settings
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="ManageProfile.jsp">Profile</a>
                </li>
                <li>
                    <a href="ChangePassword.jsp">Change Password</a>
                </li>
                <li>
                    <a href="../Logout.jsp">Logout</a>
                </li>
            </ul>
        </li>





    </ul>


</nav>