<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<<<<<<< HEAD
<<<<<<< HEAD




<liferay-ui:panel collapsible="false" title="Customer Information">
	<aui:col span="3" first="true" id="customerDetailCol">
		<liferay-ui:panel collapsible="false" title="Customer Detail">

			<aui:input name="customerName" label="Customer Name" value="${creditApp.customerName}"></aui:input>
			<aui:input name="customerDBAName" label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
		</liferay-ui:panel>
	</aui:col>

	<aui:col span="3" id="customerInfoCol">
		<liferay-ui:panel collapsible="false" title="Customer Contact Info">
			<aui:input name="customerContact" label="Customer Contact"></aui:input>
			<aui:input name="contactPhone" label="Conatct Phone"></aui:input>
		</liferay-ui:panel>
	</aui:col>
</liferay-ui:panel>


<%-- <liferay-ui:panel collapsible="true" title="Principal Information">

		<aui:col span="3" first="true" id="customerDetailCol">
			<liferay-ui:panel collapsible="false" title="Customer Detail">
				<aui:input name="First Name"></aui:input>
				<aui:input name="First Name"></aui:input>
				<aui:input name="First Name"></aui:input>
				<aui:input name="First Name"></aui:input>

			</liferay-ui:panel>
		</aui:col>

		<aui:col span="3" id="customerInfoCol">
			<liferay-ui:panel collapsible="false" title="Customer Contact Info">
				<aui:fieldset column="true">

					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
				</aui:fieldset>
			</liferay-ui:panel>
		</aui:col>
</liferay-ui:panel> --%>

<%-- <liferay-ui:panel collapsible="true"
	title="Credit Application Bank Reference Information">

		<aui:col span="3" first="true" id="customerDetailCol">
			<liferay-ui:panel collapsible="false" title="Customer Detail">
				<aui:input name="First Name"></aui:input>
				<aui:input name="First Name"></aui:input>
				<aui:input name="First Name"></aui:input>
				<aui:input name="First Name"></aui:input>

			</liferay-ui:panel>
		</aui:col>

		<aui:col span="3" id="customerInfoCol">
			<liferay-ui:panel collapsible="false" title="Customer Contact Info">
				<aui:fieldset column="true">

					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
					<aui:input name="First Name"></aui:input>
				</aui:fieldset>
			</liferay-ui:panel>
		</aui:col>
</liferay-ui:panel> --%>


<!-- old code from Pius  -->

<%-- <%if (request.getSession().getAttribute("creditAppId") == null || "".equalsIgnoreCase(request.getSession().getAttribute("creditAppId").toString())) {%>

    <aui:button-row>
		<aui:button type="submit" name="Create Proposal or Credit Application" value="Create Proposal or Credit Application"  onClick="javascript:assignActionTypeResults('createCreditAppOrProposal');"/>
    </aui:button-row>
 <%} else {%>
  <aui:button-row>
		<aui:button type="submit" name="Update Proposal Option" value="Update Proposal Option"  onClick="javascript:assignActionTypeResults('updateCreditProposal');"/>
    </aui:button-row>
    <%} %>
   </aui:form>
</div>
<%} else if (request.getSession().getAttribute("zeroRateFactor") != null){%>
<h4><font style="background-color: lightgrey ">Payment Calculator Results</font></h4>
<div>
 Zero Factor Found Message<%=request.getSession().getAttribute("zeroRateFactor") %>
</div>
<%}
if (request.getSession().getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getSession().getAttribute("creditAppId").toString())) {%>
	<h4><font style="background-color: lightgrey">Customer Information</font></h4>

<div style="display:<%=(request.getSession().getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getSession().getAttribute("creditAppId").toString()) ?"block":"none")%>" id="creditApplication">
<aui:form name="customerEquipment" method="post" action="<%=submitPaymentCalculatorUrl%>" >
<aui:input type="hidden"	name="actionType"  value="<%=actionType%>"/>
<aui:input type="hidden" label="" name="equipmentPrice" value="<%=request.getAttribute(\"equipmentPrice\")%>"></aui:input>
	<table style="width:100%">
		<tr valign="top">
			<td>
				<div><b>Customer</b> Info:</div>
				<div class="boxed">
				<br>Customer Name<br> 
				 <aui:input type="text" label="" value="<%=request.getAttribute(\"customerName\")%>" name="customerName" />
				<br>DBA Name<br>
				  <aui:input type="text" label=""  value="<%=request.getAttribute(\"customerDBAName\")%>" name="customerDBAName" />
			     </div>
			</td>
			<td>
				<div>Customer <b>Contact</b> Info:</div>
				<div class="boxed">
				<br> Customer Contact <br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerContact\")%>"	name="customerContact" />
				<br><b>Contact Phone</b><br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerContactPhone\")%>"	name="customerContactPhone" />
				<br>Contact Fax<br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerContactFax\")%>"	name="customerContactFax" />
				<br>Contact Email<br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerContactEmail\")%>"	name="customerContactEmail" />
			    </div>
			</td>
			<td>
				<div>Customer <b>Address</b> Info:</div>
				<div class="boxed">
				<br> Customer Address <br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerAddress1\")%>"	name="customerAddress1" /><br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerAddress2\")%>"	name="customerAddress2" />
				<br><b>City</b><br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerCity\")%>"	name="customerCity" />
				<br>State<br>
				<select name="customerState" >
				 <option value="">Select One</option>
				 <% State[] customerState=StateUtil.STATES;
				   for (int i=0; i<customerState.length;i++){%>
				   	 <option value="<%= customerState[i].getId()%>" <%= customerState[i].getId().equalsIgnoreCase((String)request.getAttribute("customerState"))?"selected":""%> ><%= customerState[i].getName()%></option>
				  <% } %>
				 </select>
				
				<br>Zip<br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerZip\")%>"	name="customerZip" />
				  </div>
			</td>
			<td>
				<div><b>Business</b> Info</div>
				<div class="boxed">
                <br> Business Description <br>
				<aui:input 	type="textarea" label=""  value="<%=request.getAttribute(\"customerBusinessDesc\")%>"	name="customerBusinessDesc" />
				<br><b>Business Type</b><br>
				<select name="customerBusinessType" >
				 <option value="">Select One</option>
				 <option value="Corporation" <%="Corporation".equalsIgnoreCase((String)request.getAttribute("customerBusinessType"))?"selected":""%>>Corporation</option>
				 <option value="Sole Prop" <%="Sole Prop".equalsIgnoreCase((String)request.getAttribute("customerBusinessType"))?"selected":""%> >Sole Prop</option>
				 <option value="LLC" <%="LLC".equalsIgnoreCase((String)request.getAttribute("customerBusinessType"))?"selected":""%> >LLC</option>
				 <option value="LLP" <%="LLP".equalsIgnoreCase((String)request.getAttribute("customerBusinessType"))?"selected":""%> >LLP</option>
				 <option value="Partnership" <%="Partnership".equalsIgnoreCase((String)request.getAttribute("customerBusinessType"))?"selected":""%> >Partnership</option>
				 <option value="S-Corporation" <%="S Corporation".equalsIgnoreCase((String)request.getAttribute("customerBusinessType"))?"selected":""%> >S-Corporation</option>
				 <option value="Government Entity" <%="Government Entity".equalsIgnoreCase((String)request.getAttribute("customerBusinessType"))?"selected":""%>>Government Entity</option>
				</select>
				
				<br><b>Business StartDate</b><br>
				<aui:input 	type="text" label=""  value="<%=request.getAttribute(\"customerBusinessStartDate\")%>"	name="customerBusinessStartDate" id="businessStartDate"/>
				<br>Incorporated State<br>
				<select name="customerBusinessIncorporatedState" >
				 <option value="">Select One</option>
				 <% State[] customerBusinessIncorporatedState=StateUtil.STATES;
				   for (int i=0; i<customerBusinessIncorporatedState.length;i++){%>
				   	 <option value="<%= customerBusinessIncorporatedState[i].getId()%>" <%= customerBusinessIncorporatedState[i].getId().equalsIgnoreCase((String)request.getAttribute("customerBusinessIncorporatedState"))?"selected":""%> ><%= customerBusinessIncorporatedState[i].getName()%></option>
				  <% } %>
				 </select>
				<br>Federal Tax Id<br>
				<aui:input 	type="text" label="" value="<%=request.getAttribute(\"customerBusinessFederalTaxID\")%>"	name="customerBusinessFederalTaxID" />
				</div>
			</td>
		</tr>
	</table>

<font size="4" style="background-color:lightgrey">Equipment Information</font>

<div>
	<table style="width:80%">
		<tr valign="top">
			<td>
				Equipment Price (without Tax)<br> <%=request.getAttribute("equipmentPrice")%>
				<br>Equipment Description<br>
				  <aui:input type="text" label=""  value="<%=request.getAttribute(\"equipmentDesc\")%>" name="equipmentDesc" />
			</td>
			<td>
				<div>Equipment <b>Location</b></div>
				<div class="boxed">
					 <aui:input  label=""	type="radio" value="EquipmentLocationSameAsCustomer" name="equipmentLocAsCustomerFlag" checked="<%=request.getAttribute(\"equipmentLocAsCustomerFlag\") != null ? \"EquipmentLocationSameAsCustomer\".equalsIgnoreCase(request.getAttribute(\"equipmentLocAsCustomerFlag\").toString()):false%>" />Equipment Location Same As Customer<br>
					 <aui:input  label=""	type="radio" value="DifferentLocation"	name="equipmentLocAsCustomerFlag" checked="<%= request.getAttribute(\"equipmentLocAsCustomerFlag\") != null ? \"DifferentLocation\".equalsIgnoreCase(request.getAttribute(\"equipmentLocAsCustomerFlag\").toString()):false%>" />Different Location
				</div>
			</td>
			<td>
			<div style="display:<%=request.getAttribute("equipmentLocAsCustomerFlag") != null ?("EquipmentLocationSameAsCustomer".equalsIgnoreCase(request.getAttribute("equipmentLocAsCustomerFlag").toString())?"none":"block"):"block"%>">
				<div>Equipment<b>Address</b> Info:</div>
				<div class="boxed">
					<br> Customer Address <br>
					<aui:input 	type="text" label="" value="<%=request.getAttribute(\"equipmentAddress1\")%>"	name="equipmentAddress1" /><br>
					<aui:input 	type="text" label="" value="<%=request.getAttribute(\"equipmentAddress2\")%>"	name="equipmentAddress2" />
					<br><b>City</b><br>
					<aui:input 	type="text" label="" value="<%=request.getAttribute(\"equipmentCity\")%>"	name="equipmentCity" />
					<br>State<br>
					<select name="equipmentState" >
				     <option value="">Select One</option>
				     <% State[] equipmentState=StateUtil.STATES;
				       for (int i=0; i<equipmentState.length;i++){%>
				   	      <option value="<%= equipmentState[i].getId()%>" <%= equipmentState[i].getId().equalsIgnoreCase((String)request.getAttribute("equipmentState"))?"selected":""%> ><%= equipmentState[i].getName()%></option>
				       <% } %>
				     </select>
					
					<br>Zip<br>
					<aui:input 	type="text" label="" value="<%=request.getAttribute(\"equipmentZip\")%>"	name="equipmentZip" />
				</div>
			 </div>
			</td>
			
		</tr>
	</table>


<table><tr><td nowrap="nowrap">
<aui:button-row>
	    <aui:button type="button" value="Return to Payment Calculator" name="Return to Payment Calculator"  onClick="<%=paymentCalculatorUrl.toString() %>"/>&nbsp;
		<aui:button type="button" value="Manage Document" name="Manage Document" onClick=""/>&nbsp;
		<aui:button type="submit" value="Save Application" name="Save Credit Application" onClick="javascript:assignActionTypeCustomerEquipment('Saved')"/>&nbsp; 
		<aui:button type="submit" name="Submit Application"  value="Submit Credit Application" onClick="javascript:assignActionTypeCustomerEquipment('Submitted')"/>&nbsp; 
</aui:button-row>
</td></tr></table>
</div>
</aui:form>
</div>

<div style="display:<%=( request.getSession().getAttribute("creditAppId") != null || request.getSession().getAttribute("actionType") != null && ( "principalEntered".equalsIgnoreCase(request.getSession().getAttribute("actionType").toString()) || "Saved".equalsIgnoreCase(request.getSession().getAttribute("actionType").toString())) ?"block":"none")%>" id="principal"">

<h4><font style="background-color:lightgrey">Principal Information</font></h4>
 <div style="display:<%=(request.getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getAttribute("creditAppId").toString()) ?"block":"none")%>" > 


<aui:form name="principal" method="post" action="<%=updateCreditAppPrincipalUrl%>">
<aui:input type="hidden" value="<%=request.getAttribute(\"principalId\")%>" name="creditAppPrincipalId" />
<aui:input type="hidden" value="" name="principalActionType" />

	<table style="width:50%">
		<tr valign="top">
			<td align="left" width="50%">
				<div><b>Add/Edit Principal</b> Info:</div>
				<div class="boxed">
				<table width="20%">
					<tr>
						<td> First Name &nbsp;</td> <td> &nbsp;&nbsp;</td> <td>Address Line 1</td>
					</tr>
				    <tr>
						<td><aui:input type="text" label="" value="<%=request.getAttribute(\"principalFirstName\")%>" name="principalFirstName" /></td>
				 		<td>&nbsp;&nbsp;</td>
				 		<td><aui:input type="text" label=""  value="<%=request.getAttribute(\"principalAddress1\")%>" name="principalAddress1" /></td>
			        </tr>
			        <tr>
						
				 		<td>Middle<br><aui:input type="text" label="" value="<%=request.getAttribute(\"principalMiddleName\")%>" name="principalMiddleName" /></td>
				 		<td>&nbsp;&nbsp;</td>
				 		<td>&nbsp;&nbsp;</td>
				 		
			        </tr>
				    <tr>
			    
						<td>Last Name</td> <td>&nbsp; &nbsp;&nbsp;</td> <td>Address Line 2</td>
					</tr>
				    <tr>
						<td> <aui:input type="text" label="" value="<%=request.getAttribute(\"principalLastName\")%>" name="principalLastName" /></td>
				        <td>&nbsp; &nbsp;&nbsp;</td>
				        <td><aui:input type="text" label=""  value="<%=request.getAttribute(\"principalAddress2\")%>" name="principalAddress2" /></td>
			        </tr>
				    <tr>
			    	  <td>SSN </td><td>&nbsp; &nbsp;&nbsp;</td> <td>City</td>
			    	 </tr>
			    	 <tr>
				      <td><aui:input type="text" label="" value="<%=request.getAttribute(\"principalSSN\")%>" name="principalSSN" /></td>
				      <td>&nbsp; &nbsp;&nbsp;</td>
				      <td><aui:input type="text" label=""  value="<%=request.getAttribute(\"principalCity\")%>" name="principalCity" /></td>
			        </tr>
				    <tr>
				       <td> Home Phone </td><td>&nbsp; &nbsp;&nbsp;</td> <td>State</td>
				    </tr>
				    <tr>
				 		<td><aui:input type="text" label="" value="<%=request.getAttribute(\"principalHomePhoneNumber\")%>" name="principalHomePhoneNumber" /></td>
				 		<td>&nbsp; &nbsp;&nbsp;</td>
				 		<td>
				 		<select name="principalState" >
				     		<option value="">Select One</option>
				     			<% State[] principalState=StateUtil.STATES;
				       				for (int i=0; i<principalState.length;i++){%>
				   	      				<option value="<%= principalState[i].getId()%>" <%= principalState[i].getId().equalsIgnoreCase((String)request.getAttribute("principalState"))?"selected":""%> ><%= principalState[i].getName()%></option>
				       			<% } %>
				     		</select>
				 		</td>
			    	
			         </tr>
				    <tr>
				      <td>Email Address </td><td>&nbsp; &nbsp;&nbsp;</td> <td>Zip</td>
				     </tr>
				     <tr> 
				      <td><aui:input type="text" label="" value="<%=request.getAttribute(\"principalEmailAddress\")%>" name="principalEmailAddress" /></td>
				      <td>&nbsp; &nbsp;&nbsp;</td>
				      <td><aui:input type="text" label=""  value="<%=request.getAttribute(\"principalZip\")%>" name="principalZip" /></td>
			   	   </tr>
			   	   </table>
			   	   </div>
			</td>
			<td nowrap="nowrap" align="left" width="50%" >
			<div class="boxed">
			<table style="width:450px">
			
			 <tr valign="top">
			    <th ><b>LastName</b></th><th><b>FirstName</b></th><th><b>SSN</b></th><th><b>Edit</b></th><th><b>Remove</b></th>
			 </tr>
			<div id="principalIdDiv">
			  <% 
			   if( creditAppPrincipalList != null) {
				   for ( int i=0; i<creditAppPrincipalList.size();i++){%>
			   		
			   <tr valign="top" >
			    <td><%=creditAppPrincipalList.get(i).getPrincipalLastName()%></td>
			    <td><%=creditAppPrincipalList.get(i).getPrincipalFirstName()%></td>
			    <td><%=creditAppPrincipalList.get(i).getPrincipalSSN()%></td>
			    <td><button  type="submit"  name="Edit" value="Edit" onclick="javascript:assignPrincipalActionType('view','<%=creditAppPrincipalList.get(i).getPrincipalId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/edit.png" %>'/></button></td>
		        <td><button  type="submit"  name="Delete" value="Delete" onclick="javascript:assignPrincipalActionType('delete','<%=creditAppPrincipalList.get(i).getPrincipalId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/remove.png" %>' /></button></td>
		
			  </tr>
			 
			   <%} 
			  }%>
			  </div>
			</table>
			</div>
			</td>
		</tr>
	</table>

<aui:button-row>
	
	<%if (request.getAttribute("principalId") != null) { %>
	   <button type="submit" name="Submit" value="Update Principal" onclick="javascript:assignPrincipalActionType('edit','<%=request.getAttribute("principalId")%>')">Edit Principal</button>
	<%} %>
	  <button type="reset" name="Submit" value="Reset" />Reset</button>
	  <button type="submit" name="Submit" value="Add Principal">Add Principal</button>
</aui:button-row>
</aui:form>
</div>

<h4><font style="background-color:lightgrey">Credit Application Bank Reference Information</font></h4>
 <div  align="left" style="display:<%=(request.getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getAttribute("creditAppId").toString()) ?"block":"none")%>" > 
<div align="left" >
<aui:form name="bankReference" method="post" action="<%=updateCreditAppBankReferenceUrl%>">
<aui:input type="hidden" value="<%=request.getAttribute(\"bankReferenceId\")%>" name="bankReferenceId" />
<aui:input type="hidden" value="" name="bankReferenceActionType" />

   <div><b>Bank Reference Information Add/Edit </b> Info:</div>
	<table style="width:800px" >
	
	<tr>
			<th>
			Name
			</th>
			<th>
			Contact
			</th>
			<th>
			Phone
			</th>
			<th>
			Account Type
			</th>
			<th>
			Account Number
			</th>
			<th>
			Edit
			</th>
			<th>
			Remove
			</th>
	</tr>
	
	<!-- <div id="bankAccountIdDiv" style="width:400px" > -->
		<% if (bankReferenceAccountList != null){
		  for( int i=0; i<bankReferenceAccountList.size();i++){
			
			%>
		
		<tr>
			<td>
				 <%=bankReferenceAccountList.get(i).getBankReferenceName()%>
			 </td>
			 <td>
				 <%=bankReferenceAccountList.get(i).getBankReferenceContact()%>
			 </td>
			<td>
				 <%=bankReferenceAccountList.get(i).getBankReferencePhone()%>
			 </td>
			<td>
				 <%=bankReferenceAccountList.get(i).getBankReferencAccountType()%>
			 </td>
			<td>
				<%=bankReferenceAccountList.get(i).getBankReferenceAccountNumber()%>
			</td>
			 
			<td><button  type="submit"  name="View" value="Edit" onclick="javascript:assignBankReferenceActionType('view','<%=bankReferenceAccountList.get(i).getBankReferenceId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/edit.png" %>'/></button>
			</td>
		    <td><button  type="submit"  name="Delete" value="Delete" onclick="javascript:assignBankReferenceActionType('delete','<%=bankReferenceAccountList.get(i).getBankReferenceId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/remove.png" %>' /></button>
		    </td>
		
		</tr>
		
	<%} 
	}%>
	<!-- </div> -->
	
	<tr align="left">
	
			<td >
				 <aui:input type="text"  autoSize="false" size="20" label=""  name="bankReferenceAccountName"  value="<%=request.getAttribute(\"bankReferenceAccountName\") %>"/>
			 </td>
			 <td>
				 <aui:input type="text" autoSize="false"  size="20" label=""  name="bankReferenceAccountContact" value="<%=request.getAttribute(\"bankReferenceAccountContact\") %>"/>
			 </td>
			<td>
				 <aui:input type="text" autoSize="false" size="12" label="" name="bankReferenceAccountPhone" value="<%=request.getAttribute(\"bankReferenceAccountPhone\") %>"/>
			 </td>
			<td valign="top">
				
			     <select name="bankReferenceAccountType" >
				 	<option value="">Select One</option>
				 	<option value="Checking" <%="Checking".equalsIgnoreCase((String)request.getAttribute("bankReferenceAccountType"))?"selected":""%>>Checking</option>
				 	<option value="Savings" <%="Savings".equalsIgnoreCase((String)request.getAttribute("bankReferenceAccountType"))?"selected":""%> >Savings</option>
				 	<option value="Line of Credit" <%="Line of Credit".equalsIgnoreCase((String)request.getAttribute("bankReferenceAccountType"))?"selected":""%> >Line of Credit</option>
				 	<option value="Term Loan" <%="Term Loan".equalsIgnoreCase((String)request.getAttribute("bankReferenceAccountType"))?"selected":""%> >Term Loan</option>
				 	<option value="Lease" <%="Lease".equalsIgnoreCase((String)request.getAttribute("bankReferenceAccountType"))?"selected":""%> >Lease</option>
				</select>
			
			 </td>
			<td>
				 <aui:input type="text" label="" autoSize="false" size="12" name="bankReferenceAccountNumber" value="<%=request.getAttribute(\"bankReferenceAccountNumber\") %>"/>
			 </td>
		
        <td>&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;</td>
        </tr>
	</table>
	<aui:button-row>
		<%if (bankReferenceId > 0) { %>
	            <button type="submit" name="Submit" value="Edit" onclick="javascript:assignBankReferenceActionType('edit','<%=bankReferenceId%>')">Update Retrieved Record</button>
	        <%} %>
	         <button type="reset" name="Submit" value="Reset">Reset</button>
	         <button type="submit" name="Submit" value="Add">Add New Record</button>
	</aui:button-row>

</aui:form>
</div>
</div>
<%} %>
</div>
 --%>
=======
	<aui:col span="3">
		<aui:fieldset label="Customer Detail" column="true">
			<aui:input name="customerName" value="${creditApp.customerName}"></aui:input>
			<aui:input name="customerDBAName" label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
		</aui:fieldset>
	</aui:col>
			
	<aui:col span="3">
		<aui:fieldset label="Customer Contact Detail" column="true">
			<aui:input name="customerContact" label="Customer Contact"></aui:input>
			<aui:input name="contactPhone" label="Conatct Phone"></aui:input>
			<aui:input name="contactFax" label="Conatct Fax"></aui:input>
		</aui:fieldset>
	</aui:col>
	
	<aui:col span="3">
		<aui:fieldset label="Customer Address Info" column="true">
			<aui:input name="customerAddress1"></aui:input>
			<aui:input name="customerAddress2"></aui:input>
			<aui:input name="customerCity"></aui:input>
			
			<aui:select name="customerState" showEmptyOption="true">
				 
				 <% State[] customerState=StateUtil.STATES;
				   for (int i=0; i<customerState.length;i++){%>
				   	 <aui:option value="<%= customerState[i].getId()%>" label="<%= customerState[i].getName()%>">
				   	 
				   	 </aui:option>
				  <% } %>
			 </aui:select>
			 <aui:input name="customerZip"></aui:input>

		</aui:fieldset>
	</aui:col>
>>>>>>> master
=======
<portlet:renderURL portletMode="view" var="editAppURL">
	<portlet:param name="viewMode" value="<%= String.valueOf(false)%>" />
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}"/>
</portlet:renderURL>

 <c:import url="/html/paymentcalculator/buttons.jsp"></c:import>


	<liferay-ui:icon
		   image="tool"
		   message="Edit Credit App"
		   label="<%= true%>"
		   method="get"
		   url="<%= editAppURL%>"
		   useDialog="<%= false%>"
		   
		  />

<aui:panel label="Address Info">

<address>
  <strong><aui-field>${creditApp.customerName}</strong><br>
  ${creditApp.customerAddress1}<br>
  ${creditApp.customerAddress2}<br>
  ${creditApp.customerCity}, ${creditApp.customerState} ${creditApp.customerZip}<br>
  <abbr title="Phone">P:</abbr> ${creditApp.customerContactPhone}<br>
  <abbr title="Fax">F:</abbr> ${creditApp.customerContactFax}<br>
  <abbr title="Email">E:</abbr> ${creditApp.customerContactEmail}<br>
</address>

</aui:panel>

 
<address>
  <strong>Full Name</strong><br>
  <a href="mailto:#">first.last@example.com</a>
</address>
>>>>>>> master
