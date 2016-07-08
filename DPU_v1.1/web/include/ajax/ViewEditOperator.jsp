
<%@page  import="datalayer.admin.ManageOperatorServices,beans.admin.AddEditOperatorBean" %>
<%@page import="datalayer.admin.CountryStateCityServices,beans.admin.CountryStateCityBean" %>
<%@page import="java.util.ArrayList" %>
<%
    ManageOperatorServices objServices=new ManageOperatorServices();
    AddEditOperatorBean objBean=objServices.viewOperatorDetail(request.getParameter("userid"));
    CountryStateCityServices objCountryService=new CountryStateCityServices();
    ArrayList al=objCountryService.getAllCountryList();
    ArrayList als;
    ArrayList alc;
%>
<form action="AddEditOperatorController.jsp" method="post" onsubmit="return ValidateEditOperatorForm()">
    <!--<form action="AddEditOperatorController.jsp" method="post" >-->

    <table border="0" cellpadding="0" cellspacing="0" align="center">
            <tr>
                <td align="center">
                    <strong>
                        Edit Operator</strong>
                </td>
            </tr>
        <%
            if (request.getParameter("msg") != null) {
                String msg = request.getParameter("msg");
        %>
        <tr><td align="left"><label id ="msg" align="left" ><%=msg%></label></td></tr>
        <% }%>
            <tr>
                <td>
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td>
                                <fieldset>
                                    <legend><strong><em>Account Information </em></strong></legend>
                                    <table border="0" cellpadding="5" cellspacing="0">
                                        <tr>
                                            <td><input type="hidden" name="txtUserId" value="<%=objBean.getTxtUserId()%>"/></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Login Name</strong>
                                            </td>
                                            <td>
                                                <input id="txtUserName" name="txtUserName" type="text" value="<%=objBean.getTxtUserName()%>" class="txtStyle"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Password</strong>
                                            </td>
                                            <td>
                                                <input id="txtPassword" name="txtPassword" type="password" value="<%=objBean.getTxtPassword()%>" class="txtStyle"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Confirm Password</strong>
                                            </td>
                                            <td>
                                                <input id="txtConfirmPassword" name="txtConfirmPassword" type="password" value="<%=objBean.getTxtPassword()%>" class="txtStyle"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Status</strong>
                                            </td>
                                            <td>
                                                <table border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                    <%
                                                            if(objBean.getRbStatus().equals("1")){
                                                                %>
                                                    <td>    <input id="rbActive" name="rbStatus" type="radio" checked value="1" />
                                                        </td>
                                                        <td>
                                                            <label>Active</label>
                                                        </td>

                                                        <td>
                                                            <input id="rbInactive" name="rbStatus" type="radio" value="0"/>
                                                        </td>
                                                        <td>
                                                            <label>Inactive</label>
                                                        </td>
                                                        <%
                                                            }else{
                                                             %>
                                                    <td>    <input id="rbActive" name="rbStatus" type="radio" value="1" />
                                                        </td>
                                                        <td>
                                                            <label>Active</label>
                                                        </td>

                                                        <td>
                                                            <input id="rbInactive" name="rbStatus" type="radio" checked="" value="0"/>
                                                        </td>
                                                        <td>
                                                            <label>Inactive</label>
                                                        </td>
                                                        <%
                                                            }
                                                %>
                                                       
                                                        
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fieldset>
                                    <legend><strong><em>Personal Information</em></strong> </legend>
                                    <table border="0" cellpadding="5" cellspacing="0">
                                       
                                        <tr>
                                            <td>
                                                <strong>Name</strong>
                                            </td>
                                            <td>
                                                <input id="txtName" name="txtName" type="text" value="<%=objBean.getTxtName()%>" class="txtStyle"/>
                                            </td>
                                        </tr>
                                       
                                        <tr>
                                            <td>
                                                <strong>DOB</strong>
                                            </td>
                                            <td>
                                                <input id="txtDOB" name="txtDOB" type="text" value="<%=objBean.getTxtDOB()%>" class="txtStyle"/>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Gender</strong>
                                            </td>
                                            <td>
                                                <table border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <%
                                                            if(objBean.getRbGender().equals("1")){
                                                                %>
                                                        <td>
                                                            <input id="rbMale" name="rbGender" type="radio" value="1" checked="checked" />
                                                        </td>
                                                        <td>
                                                            <label> Male</label>
                                                        </td>

                                                        <td>
                                                            <input id="rbFemale" name="rbGender" value="0" type="radio" />
                                                        </td>
                                                        <td>
                                                            <label>Female</label>
                                                        </td>
                                                        <%
                                                            }else{
                                                             %>
                                                             <td>
                                                            <input id="rbMale" name="rbGender" type="radio" value="1"  />
                                                        </td>
                                                        <td>
                                                            <label> Male</label>
                                                        </td>

                                                        <td>
                                                            <input id="rbFemale" name="rbGender" value="0" type="radio" checked/>
                                                        </td>
                                                        <td>
                                                            <label>Female</label>
                                                        </td>
                                                             
                                                              <%
                                                            }
                                                %>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Phone</strong>
                                            </td>
                                            <td>
                                                <input id="txtPhone" name="txtPhone" type="text" value="<%=objBean.getTxtPhone()%>" class="txtStyle"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Mobile</strong>
                                            </td>
                                            <td>
                                                <input id="txtMobile" name="txtMobile" type="text" value="<%=objBean.getTxtMobile()%>" class="txtStyle"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Email Id</strong>
                                            </td>
                                            <td>
                                                <input id="txtEmailID" name="txtEmailId" type="text" value="<%=objBean.getTxtEmailId()%>" class="txtStyle"/>
                                            </td>
                                        </tr>                                       
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fieldset>
                                    <legend><strong><em>Address Information </em></strong></legend>
                                    <table border="0" cellpadding="5" cellspacing="0">
                                        <tr>
                                            <td>
                                                <strong>Address</strong>
                                            </td>
                                            <td>
                                                <textarea id="taAddress" name="taAddress" cols="23" rows="2"><%=objBean.getTaAddress()%></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Country</strong>
                                            </td>
                                            <td>
                                                <select id="ddlCountry" name="ddlCountry" onchange="showState(this.value)">
						    <option value="-2">Select</option>
                                                    <%
                                        
                                        for(int i=0;i<al.size();i++){
                                            String str="";
                                            CountryStateCityBean objBean1=(CountryStateCityBean)al.get(i);
                                            if(objBean.getDdlCountry()==objBean1.getTxtCountryId()){
                                                str="selected";
                                            }
                                            %>
                                            <option value="<%=objBean1.getTxtCountryId()%>" <%=str%>><%=objBean1.getDdlCountryName()%></option>
                                    
                                    <%
                                        }
%>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>State</strong>
                                            </td>
                                            <td><div id="divState">
                                                <select id="ddlState" name="ddlState">
                                                    <option value="-2">Select</option>
						    <%
                                                             als=objCountryService.getAllStateList(objBean.getDdlCountry());
    alc=objCountryService.getAllCityList(objBean.getDdlState());
                                        for(int i=0;i<als.size();i++){
                                            String str="";
                                            CountryStateCityBean objBean2=(CountryStateCityBean)als.get(i);
                                            if(objBean.getDdlState()==objBean2.getTxtStateId()){
                                                str="selected";
                                            }
                                            %>
                                            <option value="<%=objBean2.getTxtStateId()%>" <%=str%>><%=objBean2.getDdlStateName()%></option>
                                    
                                    <%
                                        }%>
                                                </select>
                                                </div>
                                            </td>
                                        </tr>
                                                        
                                        <tr>
                                            <td>
                                                <strong>City</strong>
                                            </td>
                                            <td><div id="divCity">
                                                <select id="ddlCIty" name="ddlCity">
                                                    <option value="-2">Select</option>
						     <%
                                        
                                        for(int i=0;i<alc.size();i++){
                                            String str="";
                                            CountryStateCityBean objBean2=(CountryStateCityBean)alc.get(i);
                                            if(objBean.getDdlCity()==objBean2.getTxtCityId()){
                                                str="selected";
                                            }
                                            %>
                                            <option value="<%=objBean2.getTxtCityId()%>" <%=str%>><%=objBean2.getDdlCityName()%></option>
                                    
                                    <%
                                        }
%>
                                                </select>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Pin Code</strong>
                                            </td>
                                            <td>
                                                <input id="txtPinCode" name="txtPinCode" type="text" value="<%=objBean.getTxtPinCode()%>" class="txtStyle"/>
                                            </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <input id="sbtnUpdate" name="sbtnUpdate" type="submit" value="Update" class="button"/>
                                
                                <input id="rbtnReset" name="rbtnReset" type="reset" value="Reset" class="button"/>
                                <input id="btnBackToOperator" name="btnBackToOperator" type="button" value="Back to Operators" class="button" onclick="window.location='ManageOperators.jsp'"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        </form>