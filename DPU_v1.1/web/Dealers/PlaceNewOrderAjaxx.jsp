<%@page import="dpu.services.admin.ProductsServicesImpl"%>
<%@page import="dpu.beans.admin.ProductsBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="dpu.beans.dealers.OrderItembean"%>
<%@page import="java.util.List"%>
<%
    System.out.println("PLACE ORDER");
    List<OrderItembean> lstOrderedItems = null;
    if (session.getAttribute("LIST_ITEMS") != null) {
        lstOrderedItems = (List<OrderItembean>) session.getAttribute("LIST_ITEMS");
    } else {
        lstOrderedItems = new ArrayList<OrderItembean>();
    }
    System.out.println("PLACE ORDER");
    OrderItembean obj = new OrderItembean();
    obj.setProduct_id(Integer.parseInt(request.getParameter("productId")));
    ProductsBean objP = new ProductsServicesImpl().getProductInfoById(obj.getProduct_id());
    obj.setProduct_title(objP.getTxtProductTitle());
    System.out.println("PLACE ORDER");
    obj.setPrice(Double.parseDouble(objP.getTxtPrice()));
    obj.setQuantity(Integer.parseInt(request.getParameter("quantity")));

    boolean flag = false;
    for (int i = 0; i < lstOrderedItems.size(); i++) {
        OrderItembean objOIB = lstOrderedItems.get(i);
        if (objOIB.getProduct_id() == obj.getProduct_id()) {
            if (request.getParameter("update") != null) {
                objOIB.setQuantity(obj.getQuantity());
            } else {
                objOIB.setQuantity(objOIB.getQuantity() + obj.getQuantity());
            }
            flag = true;
            break;
        }
    }
    if (!flag) {
        lstOrderedItems.add(obj);
    }

    System.out.println("PLACE ORDER" + lstOrderedItems.size());
    session.setAttribute("LIST_ITEMS", lstOrderedItems);
%>
<c:if test="${sessionScope.LIST_ITEMS.size()>0}">
    <table width="100%" class="table table-hover table-responsive ">

        <tr>
            <th>
                S.No.
            </th>
            <th>
                Product Name
            </th>
            <th>
                Price
            </th>
            <th>
                Quantity
            </th>
        </tr>
        <c:forEach items="${sessionScope.LIST_ITEMS}" var="obj" varStatus="i">
            <tr align="">
                <td>
                    ${i.index+1}
                </td>
                <td>
                    ${obj.product_title}
                </td>
                <td>
                    Rs.${obj.price}
                </td>
                <td>
                    <a href="javascript:modifyQUntity(${obj.product_id})" id="quantity${obj.product_id}"> ${obj.quantity}</a>
                    <input name="txtQEdit" type="text" id="txtQuantity${obj.product_id}" value="${obj.quantity}" /><input name="btnQUpdate" type="button" id="btn${obj.product_id}" value="Update" onclick="updateQUntity(${obj.product_id})"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<script>hideAll()</script>