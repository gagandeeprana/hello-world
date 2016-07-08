<%@page import="dpu.services.admin.ProductCategoryServicesImpl"%>
<%@page import="dpu.services.admin.ProductCategoryServicesDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dpu.beans.admin.ProductCategoryBean"%>
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
        <script type="text/javascript" src="../include/validations.js">

    </script>
    <script type="text/javascript">
        function valid() {
            var name = document.getElementById("txtTitle").value;
            var des = document.getElementById("taDescription").value;
            var vat = document.getElementById("txtVat").value;
            var sh = document.getElementById("txtShippingCharges").value;
            var msg = document.getElementById("divMsg");
            if (isEmpty(name)) {
                msg.innerHTML = "Name is required";
                document.getElementById("txtTitle").focus();
                return false;
            }
            if (isEmpty(des)) {
                msg.innerHTML = "Description is required";
                document.getElementById("taDescription").focus();
                return false;
            }
            if (isEmpty(vat)) {
                msg.innerHTML = "Vat is required";
                document.getElementById("txtVat").focus();
                return false;
            }
            if (isEmpty(sh)) {
                msg.innerHTML = "Shipping Charges is required";
                document.getElementById("txtShippingCharges").focus();
                return false;
            }
            return true;
        }
    </script> 
    </head>
    <body>
         <jsp:include page="mp_header.jsp"/>
                  <%
            ProductCategoryServicesDAO objServices = new ProductCategoryServicesImpl();
            ProductCategoryBean obj = objServices.getPCInfoById(Integer.parseInt(request.getParameter("categoryId")));
            pageContext.setAttribute("STATUS_"+obj.getStatus(),"checked");
            pageContext.setAttribute("obj", obj);
        %>
        <div id="divMsg" style="color:red"></div>
        <form action="ControllerPC.jsp" method="post" onsubmit="return valid()">
            <input type="hidden" name="txtcategoryId" value="${param.categoryId}"/>
        <table align="center" cellpadding="5">
            <tr>
                <td align="center">
                    <strong>Edit Product Category</strong>
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
                                            <td>
                                                <b>Title</b>
                                            </td>
                                            <td>
                                                <input type="text" class="txtStyle" name="txtTitle" id="txtTitle" value="${obj.txtTitle}">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Description</b>
                                            </td>
                                            <td>
                                                <textarea name="taDescription" id="taDescription" rows="4" cols="32">${obj.taDescription}</textarea>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <b>Status</b>
                                            </td>
                                            <td>
                                                <input type="radio" name="rbStatus" ${STATUS_1} value="1"/>Active
                                                <input type="radio" name="rbStatus" ${STATUS_0} value="0"/>InActive
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Vat</b>
                                            </td>
                                            <td>
                                                <input type="text" class="txtStyle" name="txtVat" id="txtVat" value="${obj.vat}"/>%
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Shipping Charges</b>
                                            </td>
                                            <td>
                                                <input type="text" class="txtStyle" name="txtShippingCharges" id="txtShippingCharges" value="${obj.charges}">
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
                    <input type="submit" class="button" name="sbtnUpdate" value="Update"/>
                    <input type="button" class="button" name="btnBack" value="Back" onclick="window.location='ManageProductCategory.jsp'"/>
                </td>
            </tr>
        </table>
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
