 <%@page import="dpu.services.admin.ProductCategoryServicesImpl"%>
<%@page import="dpu.services.admin.ProductCategoryServicesDAO"%>
<%@page import="dpu.beans.admin.ProductCategoryBean"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                var title=document.getElementById("txtProductTitle").value;
                var code=document.getElementById("txtProductCode").value;
                var mod=document.getElementById("txtModelNo").value;
                var ddlC=document.getElementById("ddlCategory").value;
                var com=document.getElementById("txtCompany").value;
                var price=document.getElementById("txtPrice").value;
                var desc=document.getElementById("taDescription").value;
                var msg=document.getElementById("dmsg");
                if(isEmpty(title))
                {
                    msg.innerHTML="title field cannot be blank";
                    document.getElementById("txtProductTitle").focus();
                    return false;
                }
                if(isEmpty(code))
                {
                    msg.innerHTML="Product Code cannot be blank";
                    document.getElementById("txtProductCode").focus();
                    return false;
                }
                if(isEmpty(mod))
                {
                    msg.innerHTML="Enter model no";
                    document.getElementById("txtModelNo").focus();
                    return false;
                }
                if(ddlC ==0 )
                {
                    msg.innerHTML="Category needs to be selected";
                    document.getElementById("ddlCategory").focus();
                    return false;
                }
                if(isEmpty(com))
                {
                    msg.innerHTML="Company name cannot be blank";
                    document.getElementById("txtCompany").focus();
                    return false;
                }
                if(isEmpty(price))
                {
                    msg.innerHTML="Everything has a price!";
                    document.getElementById("txtPrice").focus();
                    return false;
                }
                if(isEmpty(desc))
                {
                    msg.innerHTML="Enter the description";
                    document.getElementById("taDescription").focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
         <jsp:include page="mp_header.jsp"/>
         <%
             ProductCategoryServicesDAO objServices=new ProductCategoryServicesImpl();
             List<ProductCategoryBean> lstCategories=objServices.getAllProductCategories("");
             pageContext.setAttribute("LIST_CATEGORIES", lstCategories);
          %>
          <form action="ControllerProduct.jsp" method="GET" onsubmit="return check()">
        <table align="center" cellpadding="5">
            <tr>
                <td align="center">
                    <strong>Add Product</strong>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <div id="dmsg" style="color: red;background-color: white;"></div>
                </td>
            </tr>
		<tr>
                <td align="left">
                    <label id="lblMsg" style="color:red"><small>${param.msg}</small></label>
                </td>
            </tr>
            <tr>
                <td>
                    <table width="100%">
                        <tr>
                            <td>
                                <fieldset>

                                    <table width="100%">
                                        <tr>
                                            <th width="30%" align="left">
                                                Product Title
                                            </th>
                                            <td>
                                                <input type="text" class="txtStyle" name="txtProductTitle" id="txtProductTitle"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th width="30%" align="left">
                                                Product Code
                                            </th>
                                            <td>
                                                <input type="text" class="txtStyle" name="txtProductCode" id="txtProductCode"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th width="30%" align="left">
                                                Model No
                                            </th>
                                            <td>
                                                <input type="text" class="txtStyle" name="txtModelNo" id="txtModelNo"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th width="30%" align="left">
                                                Category
                                            </th>
                                            <td>
                                                <select name="ddlCategory" id="ddlCategory">
                                                    <option value="0">Select</option>
                                                    <c:forEach items="${LIST_CATEGORIES}" var="obj">
                                                        <option value="${obj.categoryId}">${obj.title}</option>
                                                    </c:forEach>   
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th width="30%" align="left">
                                                Company
                                            </th>
                                            <td>
                                                <input type="text" class="txtStyle" name="txtCompany" id="txtCompany"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th width="30%" align="left">
                                                Price
                                            </th>
                                            <td>
                                                <input type="text" class="txtStyle" name="txtPrice" id="txtPrice"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th align="left">
                                                Description
                                            </th>
                                            <td>
                                                <textarea id="taDescription" name="taDescription" rows="4" cols="32"></textarea>
                                            </td>
                                        </tr>

                                        <tr>
                                            <th align="left">
                                                Status
                                            </th>
                                            <td>
                                                <input type="radio" name="rbStatus" value="1" checked="checked"/>Active
                                                <input type="radio" name="rbStatus" value="0"/>InActive
                                            </td>
                                        </tr>
                                        
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr>
                <td align="right">
                    <input type="submit" name="sbtnSave" class="button" value="Save"/>
                    <input type="submit" name="sbtnSaveAddNew" class="button" value="Save & Add New"/>
                    <input type="button" name="btnBack" class="button" value="Back" onclick="window.location='ManageProducts.jsp'"/>
                </td>
            </tr>
        </table>
         </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
