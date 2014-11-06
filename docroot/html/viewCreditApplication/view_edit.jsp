<%@page import="com.tamarack.creekridge.model.Term"%>
<%@page import="com.tamarack.creekridge.model.PurchaseOption"%>
<%@page import="com.tamarack.creekridge.model.Product"%>
<%@page import="com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppStatus"%>
<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@page import="com.tamarack.liferay.payment.TempBankAccount"%>
<%@page import="com.liferay.util.*"%>
<%@page import="com.tamarack.liferay.payment.TempProposalOption"%>
<%@page import="com.tamarack.liferay.payment.TempPrincipal"%>
<%@page import="com.tamarack.creekridge.service.TermLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.ProductLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.ProposalOption"%>
<%@page import="com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppBankReference"%>
<%@page import="com.tamarack.creekridge.model.CreditApp"%>
<%@page import="com.tamarack.creekridge.model.CreditAppPrincipal"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="java.util.*"%>
<portlet:defineObjects />

<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long creditAppId= new Long(request.getSession().getAttribute("viewCreditApp").toString()).longValue();

CreditApp creditApp=CreditAppLocalServiceUtil.getCreditApp(creditAppId);
List<CreditAppStatus> creditAppStatusList=CreditAppStatusLocalServiceUtil.getCreditAppStatuses(-1, -1);
List<CreditAppPrincipal> creditAppPrincipalList=CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditAppId);
List<CreditAppBankReference> creditAppBankReferenceList=CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(creditAppId);
List<ProposalOption> proposalOptionList=ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditAppId);
List<Product> productList=ProductLocalServiceUtil.getProducts(-1,-1);
List<PurchaseOption> purchaseOptionist=PurchaseOptionLocalServiceUtil.getPurchaseOptions(-1,-1);
List<Term> termOptionList= TermLocalServiceUtil.getTerms(-1, -1);



boolean isOmniAdmin=themeDisplay.getPermissionChecker().isOmniadmin();
boolean isGroupOwner = themeDisplay.getPermissionChecker().isGroupOwner(themeDisplay.getScopeGroupId());
boolean isCreekRidgeSalesManager=false;
User user = themeDisplay.getUser();
for (int i=0;i<user.getRoles().size();i++){
	System.out.println(user.getRoles().get(i).getName());
	if("CreekRidge Sales Manager".equalsIgnoreCase(user.getRoles().get(i).getName())){
		isCreekRidgeSalesManager=true;
		break;
	}
}
Map<Long,String> statusMap= new HashMap<Long,String>();
for (int j=0;j<creditAppStatusList.size();j++){
	statusMap.put(creditAppStatusList.get(j).getCreditAppStatusId(), creditAppStatusList.get(j).getCreditAppStatusName());
}

%>
<portlet:actionURL var="updateCreditAppUrl" >
  <portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateCreditApp" />
</portlet:actionURL>
<html>

<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script> --%>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.3/css/jquery.dataTables.css">
  
<!-- jQuery -->
<!-- <script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script> -->
  
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.3/js/jquery.dataTables.js"></script>


<script>
   $(document).ready(function () {
    
	   $('#creditAppView').DataTable();
  });

</script>
<!-- <style type="text/css">.boxed { -->
/*   border: 1px solid black ; */
/*   margin: 5px; */
/*   padding: 5px; */
/* } */
<!-- </style> -->
</head>


<div align="center" width="100%"  id="calculatorResults">
	<H4><font style="background-color: lightgrey">Proposal Optional </font></H4>
</div>

 <table  id="creditAppView" class="display">

<tbody>
	<%  
		TempProposalOption proporsalOption = new TempProposalOption();
      for (int i=0;i<proposalOptionList.size();i++) {
      
    	   proporsalOption=proposalOptionList.get(i);
      %>

		<tr>
			<td> <%="Option "+i%>

			</td>
			<td><%=ProductLocalServiceUtil.getProduct(proporsalOption.getProductId()).getProductName()%> 

			</td>
			<td> <%=PurchaseOptionLocalServiceUtil.getPurchaseOption(proporsalOption.getPurchaseOptionId()).getPurchaseOptionName()%> 

			</td>
			<td><%=TermLocalServiceUtil.getTerm(proporsalOption.getTermId()).getTermName()%>
			</td>
			<td> <%=proporsalOption.getPaymentAmount()%>
			</td>
			<td nowrap="nowrap"><aui:input type="checkbox" value="<%=proporsalOption.getProposalId()%>" label="" name="<%=\"includeInProposal\" +i%>"></aui:input>
			</td>
			<td nowrap="nowrap"><aui:input type="radio" label="" value="<%=proporsalOption.getProposalId()%>" name="useForApplication"></aui:input>
			</td>  																	
		</tr>
	<%} %>
	</tbody>
	</table>
	
<div align="center" width="100%">
	<H4><font style="background-color: lightgrey">Customer and Equipment</font></H4>
</div>

 <table  id="creditAppView" class="display">

<div>
	<table width="100%">
		<tr valign="top">
			<td>
				<div><b>Customer</b> Info:</div>
				<div class="boxed">
				<br>Customer Name<br> 
				 <aui:input type="text" label="" value="<%=request.getSession().getAttribute(\"customerName\")%>" name="customerName" />
				<br>DBA Name<br>
				  <aui:input type="text" label=""  value="<%=request.getSession().getAttribute(\"customerDBAName\")%>" name="customerDBAName" />
			     </div>
			</td>
			<td>
				<div>Customer <b>Contact</b> Info:</div>
				<div class="boxed">
				<br> Customer Contact <br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerContact\")%>"	name="customerContact" />
				<br><b>Contact Phone</b><br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerContactPhone\")%>"	name="customerContactPhone" />
				<br>Contact Fax<br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerContactFax\")%>"	name="customerContactFax" />
				<br>Contact Email<br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerContactEmail\")%>"	name="customerContactEmail" />
			    </div>
			</td>
			<td>
				<div>Customer <b>Address</b> Info:</div>
				<div class="boxed">
				<br> Customer Address <br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerAddress1\")%>"	name="customerAddress1" /><br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerAddress2\")%>"	name="customerAddress2" />
				<br><b>City</b><br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerCity\")%>"	name="customerCity" />
				<br>State<br>
				<select name="customerState" >
				 <option value="">Select One</option>
				 <% State[] states=StateUtil.STATES;
				   for (int i=0; i<states.length;i++){%>
				   	 <option value="<%= states[i].getId()%>" selected="<%= states[i].getId().equalsIgnoreCase((String)request.getSession().getAttribute("customerState"))?"selected":""%>" ><%= states[i].getName()%></option>
				  <% } %>
				 </select>
				
				<br>Zip<br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerZip\")%>"	name="customerZip" />
				  </div>
			</td>
			<td>
				<div><b>Business</b> Info</div>
				<div class="boxed">
                <br> Business Description <br>
				<aui:input 	type="textarea" label=""  value="<%=request.getSession().getAttribute(\"customerBusinessDesc\")%>"	name="customerBusinessDesc" />
				<br><b>Business Type</b><br>
				<select name="customerBusinessType" >
				<option value="">Select One</option>
				 <option value="Corporation" selected="<%= "Corporation".equalsIgnoreCase((String)request.getSession().getAttribute("customerBusinessType"))?"selected":""%>">Corporation</option>
				 <option value="Sole Prop" <%= "Sole Prop".equalsIgnoreCase((String)request.getSession().getAttribute("customerBusinessType"))?"selected":""%>>Sole Prop</option>
				 <option value="LLC" <%= "LLC".equalsIgnoreCase((String)request.getSession().getAttribute("customerBusinessType"))?"selected":""%>>LLC</option>
				 <option value="LLP" <%= "LLP".equalsIgnoreCase((String)request.getSession().getAttribute("customerBusinessType"))?"selected":""%>>LLP</option>
				 <option value="Partnership" <%= "Partnership".equalsIgnoreCase((String)request.getSession().getAttribute("customerBusinessType"))?"selected":""%>>Partnership</option>
				 <option value="S-Corporation" <%= "S Corporation".equalsIgnoreCase((String)request.getSession().getAttribute("customerBusinessType"))?"selected":""%>>S-Corporation</option>
				 <option value="Government Entity" <%= "Government Entity".equalsIgnoreCase((String)request.getSession().getAttribute("customerBusinessType"))?"selected":""%>>Government Entity</option>
				</select>
				<br><b>Business StartDate</b><br>
				<aui:input 	type="date" label=""  value="<%=request.getSession().getAttribute(\"customerBusinessStartDate\")%>"	name="customerBusinessStartDate" />
				<br>Incorporated State<br>
				<select name="customerBusinessIncorporatedState" >
				 <option value="">Select One</option>
				 <% State[] customerBusinessIncorporatedState=StateUtil.STATES;
				   for (int i=0; i<customerBusinessIncorporatedState.length;i++){%>
				   	 <option value="<%= customerBusinessIncorporatedState[i].getId()%>" <%= customerBusinessIncorporatedState[i].getId().equalsIgnoreCase((String)request.getSession().getAttribute("customerBusinessIncorporatedState"))?"selected":""%> ><%= customerBusinessIncorporatedState[i].getName()%></option>
				  <% } %>
				 </select>
				<br>Federal Tax Id<br>
				<aui:input 	type="text" label="" value="<%=request.getSession().getAttribute(\"customerBusinessFederalTaxID\")%>"	name="customerBusinessFederalTaxID" />
				</div>
			</td>
		</tr>
	</table>
</div>
	</table>
		
	<hr>
<div align="left">
	<H4><font style="background-color:lightgrey">Principal Information</font></H4>
</div>
<aui:form name="principal" method="post" action="<%=updateCreditAppPrincipalUrl%>">
<aui:input type="hidden" value="" name="principalId" />
<aui:input type="hidden" value="" name="principalActionType" />
<div>
	<table width="50%">
		<tr valign="top">
			<td align="left" width="50%">
				<div><b>Add/Edit Principal</b> Info:</div>
				<div class="boxed">
				<table width="20%">
					<tr>
						<td> First Name &nbsp;</td> <td> Middle &nbsp;&nbsp;</td> <td>Address Line 1</td>
					</tr>
				    <tr>
						<td><aui:input type="text" label="" value="<%=request.getSession().getAttribute(\"principalFirstName\")%>" name="principalFirstName" /></td>
				 		<td><aui:input type="text" label="" value="<%=request.getSession().getAttribute(\"principalMiddleName\")%>" name="principalMiddleName" /></td>
				 		<td><aui:input type="text" label=""  value="<%=request.getSession().getAttribute(\"principalAddress1\")%>" name="principalAddress1" /></td>
			        </tr>
				    <tr>
			    
						<td>Last Name</td> <td>&nbsp; &nbsp;&nbsp;</td> <td>Address Line 2</td>
					</tr>
				    <tr>
						<td> <aui:input type="text" label="" value="<%=request.getSession().getAttribute(\"principalLastName\")%>" name="principalLastName" /></td>
				        <td>&nbsp; &nbsp;&nbsp;</td>
				        <td><aui:input type="text" label=""  value="<%=request.getSession().getAttribute(\"principalAddress2\")%>" name="principalAddress2" /></td>
			        </tr>
				    <tr>
			    	  <td>SSN </td><td>&nbsp; &nbsp;&nbsp;</td> <td>City</td>
			    	 </tr>
			    	 <tr>
				      <td><aui:input type="text" label="" value="<%=request.getSession().getAttribute(\"principalSSN\")%>" name="principalSSN" /></td>
				      <td>&nbsp; &nbsp;&nbsp;</td>
				      <td><aui:input type="text" label=""  value="<%=request.getSession().getAttribute(\"principalCity\")%>" name="principalCity" /></td>
			        </tr>
				    <tr>
				       <td> Home Phone </td><td>&nbsp; &nbsp;&nbsp;</td> <td>State</td>
				    </tr>
				    <tr>
				 		<td><aui:input type="text" label="" value="<%=request.getSession().getAttribute(\"principalHomePhoneNumber\")%>" name="principalPhone" /></td>
				 		<td>&nbsp; &nbsp;&nbsp;</td>
				 		<td>
				 		<select name="principalState" >
				     		<option value="">Select One</option>
				     			<% State[] principalState=StateUtil.STATES;
				       				for (int i=0; i<principalState.length;i++){%>
				   	      				<option value="<%= principalState[i].getId()%>" <%= principalState[i].getId().equalsIgnoreCase((String)request.getSession().getAttribute("principalState"))?"selected":""%> ><%= principalState[i].getName()%></option>
				       			<% } %>
				     		</select>
				 		</td>
			    	
			         </tr>
				    <tr>
				      <td>Email Address </td><td>&nbsp; &nbsp;&nbsp;</td> <td>Zip</td>
				     </tr>
				     <tr> 
				      <td><aui:input type="text" label="" value="<%=request.getSession().getAttribute(\"principalEmail\")%>" name="principalEmailAddress" /></td>
				      <td>&nbsp; &nbsp;&nbsp;</td>
				      <td><aui:input type="text" label=""  value="<%=request.getSession().getAttribute(\"principalZip\")%>" name="principalZip" /></td>
			   	   </tr>
			   	   </table>
			   	   </div>
			</td>
			<td nowrap="nowrap" align="left" width="50%" >
			<div class="boxed">
			<table width="100%">
			
			 <tr valign="top" bordercolor="black" background="lightgrey">
			    <td ><b>LastName</b></td><td><b>FirstName</b></td><td><b>SSN</b></td><td><b>Edit</b></td><td><b>Remove</b></td>
			 </tr>
			
			
			 <% 
			   if( creditAppPrincipalList != null) {
				   for ( int i=0; i<creditAppPrincipalList.size();i++){%>
			   			
			 <tr valign="top">
			    <td><%=creditAppPrincipalList.get(i).getPrincipalLastName()%></td>
			    <td><%=creditAppPrincipalList.get(i).getPrincipalFirstName()%></td>
			    <td><%=creditAppPrincipalList.get(i).getPrincipalSSN() %></td>
			    <td><aui:button  type="submit"  onclick="javascript:assignPrincipalActionType('edit','<%=creditAppPrincipalList.get(i).getPrincipalId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/edit.png" %>'/></aui:button></td>
		        <td><aui:button  type="submit"  onclick="javascript:assignPrincipalActionType('delete','<%=creditAppPrincipalList.get(i).getPrincipalId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/remove.png" %>' /></aui:button></td>
		
			 </tr>
			   <%} 
			  }%>
			  
			</table>
			</div>
			</td>
		</tr>
	</table>
</div>
<aui:button-row>
	<span><aui:button type="submit" name="Submit" value="Submit"/></span>
</aui:button-row>
</aui:form>
</div>

<div id="bankAccountReference"">

<hr>
<div align="left">
	<H4><font style="background-color:lightgrey">Credit Application Bank Reference Information Information</font></H4>
</div>
<aui:form name="bankReference" method="post" action="<%=updateCreditAppBankReferenceUrl%>">
<aui:input type="hidden" value="" name="bankReferenceId" />
<aui:input type="hidden" value="" name="bankReferenceActionType" />
<div>
   <div><b>Bank Reference Information Add/Edit </b> Info:</div>
	<table width="100">
	<thead>
	<tr>
			<td>
			Name
			</td>
			<td>
			Contact
			</td>
			<td>
			Phone
			</td>
			<td>
			Account Type
			</td>
			<td>
			Account Number
			</td>
			<td>
			Edit
			</td>
			<td>
			Remove
			</td>
	</tr>
	</thead>
	<tbody>
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
			 
			<td><aui:button  type="submit"  onclick="javascript:assignBankReferenceActionType('edit','<%=bankReferenceAccountList.get(i).getBankReferenceId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/edit.png" %>'/></aui:button></td>
		    <td><aui:button  type="submit"  onclick="javascript:assignBankReferenceActionType('delete','<%=bankReferenceAccountList.get(i).getBankReferenceId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/remove.png" %>' /></aui:button></td>
		
		</tr>
	<%} 
	}%>
	<tr>
			<td>
				 <aui:input type="text" label=""  name="bankReferenceAccountName" />
			 </td>
			 <td>
				 <aui:input type="text" label=""  name="bankReferenceAccountContanct" />
			 </td>
			<td>
				 <aui:input type="text" label="" name="bankReferenceAccountPhone" />
			 </td>
			<td>
				 <aui:input type="text" label=""  name="bankReferenceAccountType" />
			 </td>
			<td>
				 <aui:input type="text" label=""  name="bankReferenceAccountNumber" />
			 </td>
			 
			<td colspan="2" align="center">
			<aui:button-row>
				<span><aui:button type="submit" name="Submit" value="Add"/></span>
			</aui:button-row>    
			</td>
		</tr>
	</tbody>
	</table>
</div>

</aui:form>
<hr>

</div>

</html>