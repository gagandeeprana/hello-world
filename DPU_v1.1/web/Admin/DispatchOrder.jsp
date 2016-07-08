<%@page import="dpu.services.admin.ProcessedOrdersKanikaServicesImpl"%>
<%@page import="dpu.services.admin.ProcessedOrdersKanikaServicesDAO"%>
<%@page import="dpu.beans.admin.DealerInfoBean"%>
<%@page import="dpu.beans.admin.DispatchBean"%>
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
        <%
            ProcessedOrdersKanikaServicesDAO objServices = new ProcessedOrdersKanikaServicesImpl();
            DealerInfoBean obj = objServices.getDealerOrderInfoById(Integer.parseInt(request.getParameter("order_id")));
            pageContext.setAttribute("obj", obj);
        %>
        <form action="ControllerDO.jsp" method="post">
            <input type="hidden" name="order_id" value="${param.order_id}"/>
            <input type="hidden" name="order_dispatched_by" value="${sessionScope.userId}"/>

            <div class="container">
                <div class="row">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-8">
                        <div id="divMsg">${param.msg}</div>
                        <div class="panel panel-success">
                            <div class="panel-heading " align="center">
                                <b>Dispatch Order</b>
                            </div>
                            <div class="panel-heading " >
                                <b>Account Information</b>
                            </div>
                            <div class="panel-body" >
                                <div class="row" >
                                    <div class="col-md-12" >
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-user"></i>
                                            </span> 
                                            <input class="form-control " placeholder="Bill No" name="txtUsername" type="text" value="${param.order_id}"/>
                                        </div>
                                    </div>
                                </div>
                                </div>
                                <div class="panel-heading " >
                                    <b>Dealer Details</b>
                                </div>
                                <div class="panel-body" >
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                <input class="form-control " placeholder="Dealer Name" name="txtUserName" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >

                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-calendar"></i>
                                                </span> 
                                                <input class="form-control " placeholder="Contact" name="txtUserName" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-phone-alt"></i>
                                                </span> 
                                                <input class="form-control " placeholder="Email" name="txtUserName" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-12" >
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-home"></i>
                                                </span> 
                                                <textarea class="form-control " placeholder="Address" name="txtUserName" type="text"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    </div>
                                    <div class="panel-heading " >
                                        <b>Order Details</b>
                                    </div>
                                    <div class="panel-body" >



                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-ban-circle"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="Order Title" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-ban-circle"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="total Charges" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-ban-circle"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="Shipping Charges" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-ban-circle"></i>
                                                    </span> 
                                                    <input class="form-control " placeholder="Net Amount" name="txtUserName" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-12" >
                                                <div class="form-group pull-right">
                                                    <input class="btn btn-success " type="submit" name="sbtnDispatch" value="Dispatch">




                                                    <input class="btn btn-success " type="reset" value="Cancel">
                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="panel-body" >









                                    </div>

                                </div>
                                <div class="col-md-2">

                                </div>

                            </div>
                        </div>
                    </div>





















<!--                    <table align="center" cellpadding="5">
                        <tr>
                            <td align="center">
                                <strong>Dispatch Order</strong>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                <label id="lblMsg" style="color:red"><small>${param.result}</small></label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fieldset>
                                    <table>
                                        <tr>
                                            <td align="left">
                                                <b>Bill No</b>
                                                &nbsp;
                                                <input type="text" class="txtStyle" name="bill_no" value="${param.order_id}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <fieldset>
                                                    <legend><b>Dealer Details</b></legend>
                                                    <table>
                                                        <tr>
                                                            <th width="45%" align="left">
                                                                Dealer Name
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtDealerName" value="${obj.name}" readonly="readonly"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th width="45%" align="left">
                                                                Contact
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtContact"  readonly="readonly" value="${obj.contact}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th width="45%" align="left">
                                                                Email
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtEmail"  readonly="readonly" value="${obj.email}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th valign="top" width="45%" align="left">
                                                                Address
                                                            </th>
                                                            <td>
                                                                <textarea rows="4" cols="24" readonly="readonly">${obj.address}</textarea>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </fieldset>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <fieldset>
                                                    <legend><b>Order Details</b></legend>
                                                    <table>
                                                        <tr>
                                                            <th width="45%" align="left">
                                                                Order Title
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtOrderTitle" readonly="readonly" value="${obj.order_title}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th width="45%" align="left">
                                                                Total Charges
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtTotalCharges" readonly="readonly" value="${obj.total_charges}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th width="45%" align="left">
                                                                Shipping Charges
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtShippingCharges" readonly="readonly" value="${obj.shipping_charges}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th width="45%" align="left">
                                                                Net Amount
                                                            </th>
                                                            <td>
                                                                <input type="text" class="txtStyle" name="txtNetAmount" readonly="readonly" value="${obj.net_amount}"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </fieldset>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right" colspan="2">
                                                <input type="submit" class="button" name="sbtnDispatch" value="Dispatch"/>
                                                <input type="button" class="button" name="btnBack" value="Back" onclick="window.location = 'ManageProcessedOrders.jsp'"/>
                                            </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>

                    </table>-->
                    </form>
                    <jsp:include page="mp_footer.jsp"/>
                    </body>
                    </html>
