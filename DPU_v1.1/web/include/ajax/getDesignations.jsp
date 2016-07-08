<%@page import="beans.*" %>
<%@page import="datalayer.*" %>
<%@page import="java.util.*" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    String id = request.getParameter("q");
    DepartmentServices departmentObjBean = new DepartmentServices();
    DesignationServices designationObjBean = new DesignationServices();
    ArrayList alst = designationObjBean.getAllActiveDesignationsAccToDepartment(Integer.parseInt(id));
    int rows = alst.size() / 3;
    if (alst.size() % 3 > 0) {
        rows++;
    }
    int columns = 3;
    int counter=0;
    int j=0;
    for (int i = 0; i < rows; i++) {
    counter=0;
    %><tr><%    
        while(counter<columns){
        if(j>=alst.size()){
            break;
        }
            DesignationMasterBean designationMasterBean=(DesignationMasterBean) alst.get(j);
%>        
    <td ><input type="checkbox" id="chkSelect" name="chkDesignations" value="<%=designationMasterBean.getDesignationId() %>" /></td>
    <td><%=designationMasterBean.getTxtDesignation() %></td>
<%
        counter++;
        j++;
    }
%></tr><%        
}        
%>
