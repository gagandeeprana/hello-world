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
        <script>
            function check() {
                var msg = document.getElementById("dmsg");
                var title = document.getElementById("txtTitle").value;
                var desc = document.getElementById("taDescription").value;
                var vat = document.getElementById("txtVat").value;
                var ship = document.getElementById("txtShippingCharges").value;
                if (isEmpty(title))
                {
                    msg.innerHTML = "Please Enter the title of the product";
                    document.getElementById("txtTitle").focus();
                    return false;
                }
                if (isEmpty(desc) || !(isInRange(10, 100, desc)))
                {
                    msg.innerHTML = "Description needs to be entered. Minimum 10 characters and maximum 100 characters required";
                    document.getElementById("taDescription").focus();
                    return false;
                }
                if (isEmpty(vat))
                {
                    msg.innerHTML = "Mention the Value Added Taxes. Enter '0' if n/a";
                    document.getElementById("txtVat").focus();
                    return false;
                }
                if (isEmpty(ship))
                {
                    msg.innerHTML = "Please Enter the shipping cahrges for the product";
                    document.getElementById("txtShippingCharges").focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="mp_header.jsp"/>
        <form action="ControllerPC.jsp" method="GET" onsubmit="return check()">
            <table align="center" cellpadding="5">
                <tr>
                    <td align="center">
                        <strong>Add Product Category</strong>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <div id="dmsg" style="color: red;background-color: white;"></div>
                    </td>
                </tr>
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
                                                    Title
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtTitle" id="txtTitle"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Description
                                                    </td>
                                                <td>
                                                    <textarea name="taDescription" rows="4" cols="32" id="taDescription"></textarea>
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
                                            <tr>
                                                <th align="left">
                                                    Vat
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtVat" id="txtVat"/>%
                                                </td>
                                            </tr>
                                            <tr>
                                                <th align="left">
                                                    Shipping Charges
                                                </th>
                                                <td>
                                                    <input type="text" class="txtStyle" name="txtShippingCharges" id="txtShippingCharges"/>per kg
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
                        <input type="button" name="btnBack" class="button" value="Back" onclick="window.location = 'ManageProductCategory.jsp'"/>
                    </td>
                </tr>
            </table>
        </form>
        <jsp:include page="mp_footer.jsp"/>
    </body>
</html>
