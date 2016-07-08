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
      
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                Orders
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a href="ManageOrders.jsp">Manage Orders</a></li>
                    <li><a href="PlaceNewOrder.jsp">Place Orders</a></li>

            </ul>
        </li>
        <li>
            <a href="ViewFAQ.jsp">FAQ</a>
        </li>
        
        
        
        
       
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                Settings
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a href="ManageRequest.jsp">Request</a></li>
                    <li><a href="ChangePassword.jsp">Change Password</a></li>
                    
                    <li><a href="PostFeedback.jsp">Feedback</a></li>
                    <li><a href="../Logout.jsp">Logout</a></li>
            </ul>
        </li>





    </ul>


</nav>