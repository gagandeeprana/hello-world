<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fair Organizer</title>
        
        <jsp:include page="stylesheet.jsp"/>
        <script type="text/javascript">
            var objHttp;
            var i=0;
            function getXMLHttpRequest(){

                objHttp = new XMLHttpRequest();
                if(objHttp == null){
                    objHttp = new ActiveXObject();
                }
                if(objHttp == null){
                    alert("Your browser doesn't support ajax");
                }
            }
            
            function showState(str)
            {

                i=1;
                getXMLHttpRequest();

                var url="getState.jsp";
                url=url+"?q="+str;

                objHttp.onreadystatechange = stateChanged;
                objHttp.open("GET",url,true);
                objHttp.send(null);
            }
            function showCity(str)
            {
                i=2;
                getXMLHttpRequest();
                var url="getCity.jsp";
                url=url+"?q="+str;
                objHttp.onreadystatechange = stateChanged;
                objHttp.open("GET",url,true);
                objHttp.send(null);
            }

            function stateChanged()
            {
                if (objHttp.readyState==4)
                {
                    if(i==1) {
                        document.getElementById("divState").innerHTML=objHttp.responseText
                        document.getElementById("divCity").innerHTML='<select id="ddlCity" name="ddlCity"><option value="-2" >Select</option></select>';
                }
                    else if(i==2){document.getElementById("divCity").innerHTML=objHttp.responseText;
                    }                  
                }
            }


        </script>
         <script type="text/javascript">
            function ValidateEditOperatorForm()
            {
               var strUsername = document.getElementById("txtUserName").value;
                if(isEmpty(strUsername))
                {
                    alert("Username Field can not be Empty ");
                    document.getElementById("txtUserName").focus();
                    return false;
                }
                else{
                    if(hasSpace(strUsername))
                    {
                        alert("Username must not have Spaces");
                        document.getElementById("txtUserName").value="";
                        document.getElementById("txtUserName").focus();
                        return false;
                    }
                    if(isAlphaNumeric(strUsername)==false)
                    {
                        alert("Username must have Alphanumeric characters only");
                        document.getElementById("txtUserName").value="";
                        document.getElementById("txtUserName").focus();
                        return false;
                    }
                    if(isNumeric(strUsername.charAt(0))){
                        alert("Username must start with Alphabet");
                        document.getElementById("txtUserName").value="";
                        document.getElementById("txtUserName").focus();
                        return false;
                    }

                    if(isInRange(6,20,strUsername)==false){
                        alert("Length of Username must be between 6-20");
                        document.getElementById("txtUserName").value="";
                        document.getElementById("txtUserName").focus();
                        return false;
                    }
                }

                var   strPassword=document.getElementById("txtPassword").value;
                if(isEmpty(strPassword)==true){ 
                    alert("Password is requigreen");
                    document.getElementById("txtPassword").focus();
                    return false;
                }
               
                var   strConfirmPassword=document.getElementById("txtConfirmPassword").value;
                if(strPassword!=strConfirmPassword){
                    alert("Confirm Password must match Password");
                    document.getElementById("txtConfirmPassword").value="";
                    document.getElementById("txtConfirmPassword").focus();
                    return false;
                } 
              
                  if((document.getElementById("rbActive").checked==false)&&(document.getElementById("rbInactive").checked==false))
                {
                    alert("Must select Status");
                    document.getElementById("rbActive").focus();
                    return false;
                }
                var strName = document.getElementById("txtName").value;
                if(isEmpty(strName))
                {
                    alert("Name Field cannot be Empty");
                    document.getElementById("txtName").focus();
                    return false;
                }
                if(isName(strName)==false)
                {
                    alert("Must enter valid name");
                    document.getElementById("txtName").value="";
                    document.getElementById("txtName").focus();
                    return false;
                }
               
                var strDOB = document.getElementById("txtDOB").value;
                if(isEmpty(strDOB))
                {
                    alert("Enter Date of Birth");
                    document.getElementById("txtDOB").focus();
                    return false;
                }
                if(isFutugreenate(strDOB))
                {
                    alert("Date of Birth can not be in Future");
                    document.getElementById("txtDOB").value="";
                    document.getElementById("txtDOB").focus();
                    return false;
                }
            strGender1=document.getElementById("rbMale").value;
                  strGender2=document.getElementById("rbFemale").value;
                 
                  if((document.getElementById("rbMale").checked==false)&&(document.getElementById("rbFemale").checked==false))
                {
                    alert("Must select Gender");
                    document.getElementById("rbMale").focus();
                    return false;
                }
                 var strPhone= document.getElementById("txtPhone").value;
                
                var strMobile= document.getElementById("txtMobile").value;
           
                if(isEmpty(strPhone)&&isEmpty(strMobile))
                {
                    alert("Enter Phone number or Mobile number");
                    document.getElementById("txtPhone").focus();
                    return false;
                }
               else
                {    
                    if(isEmpty(strPhone)==false)
                    {
                        if(isNumeric(strPhone)==false)  
                        {
                            alert("Invalid Phone Number");
                            document.getElementById("txtPhone").value="";
                            document.getElementById("txtPhone").focus();
                            return false;
                        }
                        if(isInRange(10, 15, strPhone)==false)
                        {
                            alert("Length of Phone Number must be between 10 to 14");
                            document.getElementById("txtPhone").focus();
                            return false;
                        }
                    }
                    if(isEmpty(strMobile)==false)
                    {
                        if(isNumeric(strMobile)==false)  
                        {
                            
                            alert("Invalid Mobile Number");
                            document.getElementById("txtMobile").value="";
                            document.getElementById("txtMobile").focus();
                    
                            return false;
                        }
                        if(isInRange(10, 15, strMobile)==false)
                        {
                            alert("Length of Mobile Number must be between 10 to 14");
                            document.getElementById("txtMobile").focus();
                            return false;
                        }
                    }
                }
                var   strEmailID=document.getElementById("txtEmailID").value;
                if(isEmpty(strEmailID)==true){ 
                    alert("Email id is requigreen");
                    document.getElementById("txtEmailID").focus();
                    return false;
                }
                if(isEmail(strEmailID)==false)
                    {
                    alert("Invalid Email Id");
                    document.getElementById("txtEmailID").focus();
                    return false;
                    }
                return true;
            }
        </script>
        
        
    </head>
    <body style="">
        <table border="0" cellpadding="0" cellspacing="0" width="100%" style="background-image: url('<%=getServletContext().getContextPath()%>/images/bg_body_new_inner2.png');
               background-position: top center; background-repeat: repeat-x;">
            <tr>
                <td align="center">
                    
                    <jsp:include page="header.jsp"/>
                    
                </td>
            </tr>
            <tr>
                <td align="center" style="background-image: url('<%=getServletContext().getContextPath()%>/images/__bg_body_new_inner2.gif');
                    background-repeat: repeat-x; background-position: top center; background-color: #fff;">
                    <div style="width: 981px; margin: 0 auto; min-height: 51px; max-height: 51px; height: 51px;
                         text-align: left">
                        
                        <jsp:include page="topmenu.jsp"/>
                        
                    </div>
                    <div style="width: 1020px; margin: 0 auto; min-height: 419px;  background-image: url('<%=getServletContext().getContextPath()%>/images/body_bg3.png');
                         background-position: top center; background-repeat: no-repeat;">
                        <div style="width: 940px; margin: 0 auto;padding: 10px;">

                            <jsp:include page="ViewEditOperator.jsp"/>

                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <div style="width: 981px; margin: 0 auto; min-height: 50px; max-height: 50px; height: 50px;">
                        
                        <jsp:include page="footer.jsp"/>
                        
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>
