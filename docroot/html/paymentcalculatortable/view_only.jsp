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
<%@page import="com.tamarack.creekridge.model.CreditAppPrincipal"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="java.util.*"%>
<portlet:defineObjects />

<%

List<TempPrincipal> creditAppPrincipalList=new ArrayList<TempPrincipal>();
List<TempBankAccount> bankReferenceAccountList=new ArrayList<TempBankAccount>();
List<TempProposalOption> proposalOptionList= new ArrayList<TempProposalOption>();
List<String> termNameList=(ArrayList<String>)request.getAttribute("termNameList");
List<String> productNameList=(ArrayList<String>)request.getAttribute("productNameList");
List<String> purchaseOptionList=(ArrayList<String>)request.getAttribute("purchaseOptionList");

List<String> termNameListResult=(ArrayList<String>)request.getSession().getAttribute("termNameListResult");
List<String> productNameListResult=(ArrayList<String>)request.getSession().getAttribute("productNameListResult");
List<String> purchaseOptionListResult=(ArrayList<String>)request.getSession().getAttribute("purchaseOptionListResult");

if(termNameListResult == null){
	termNameListResult= new ArrayList<String>();
}
if(productNameListResult == null){
	productNameListResult= new ArrayList<String>();
}
if(purchaseOptionListResult == null){
	purchaseOptionListResult= new ArrayList<String>();
} else {

}
Map<String,String> termNameListMap=(HashMap<String,String>)request.getSession().getAttribute("termNameListMap");
Map<String,String> productNameListMap=(HashMap<String,String>)request.getSession().getAttribute("productNameListMap");
Map<String,String> purchaseOptionListMap=(HashMap<String,String>)request.getSession().getAttribute("purchaseOptionListMap");
if(termNameListMap == null){
	termNameListMap= new HashMap<String,String>();
}
if(productNameListMap == null){
	productNameListMap= new HashMap<String,String>();
}
if(purchaseOptionListMap == null){
	purchaseOptionListMap= new HashMap<String,String>();
}
 if(request.getSession().getAttribute("proposalOptionList") != null){
    proposalOptionList=(ArrayList<TempProposalOption>)request.getSession().getAttribute("proposalOptionList");
    System.out.println("Proposal Option List "+ proposalOptionList);
 }
 
if(request.getAttribute("creditAppPrincipalList") != null){
   creditAppPrincipalList=(ArrayList<TempPrincipal>)request.getAttribute("creditAppPrincipalList");
 
} 
if(request.getAttribute("bankReferenceAccountList") != null)
 bankReferenceAccountList=(ArrayList<TempBankAccount>)request.getAttribute("bankReferenceAccountList");


String actionType =(String)request.getAttribute("actionType");
long bankReferenceId=0;
if (request.getAttribute("bankReferenceId") != null){
      bankReferenceId= new Long(request.getAttribute("bankReferenceId").toString()).longValue();
}
long principalId=0;
if (request.getAttribute("principalId") != null){
   principalId= new Long(request.getAttribute("principalId").toString());
}
int index;
if (request.getAttribute("index") != null ){
	 index=new Long(request.getAttribute("index").toString()).intValue();	
} else if (request.getAttribute("index") == null && (com.liferay.portal.util.PortalUtil.getOriginalServletRequest(request).getParameter("creditAppId") != null)) {
	index=2;
} else {
	index=0;
}
%>
<portlet:actionURL var="submitPaymentCalculatorUrl" >
<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="submitPaymentCalculator" />
</portlet:actionURL>

<portlet:actionURL var="updateCreditAppPrincipalUrl" >
<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateCreditAppPrincipal" />
</portlet:actionURL>

<portlet:actionURL var="updateCreditAppUrl" >
<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateCreditApp" />
</portlet:actionURL>

<portlet:renderURL var="paymentCalculatorUrl">
	<portlet:param name="jspPage" value="/web/vendor1/payment-calculator?clear=clear'" />
</portlet:renderURL>

<portlet:actionURL var="updateCreditAppBankReferenceUrl" >
   <portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateCreditAppBankAccountReference" />
</portlet:actionURL>

<portlet:resourceURL var="ajaxResourceUrl" />


<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>


<style type="text/css">

.boxed {
  border: 1px solid black ;
  margin: 5px;
  padding: 5px;
}
 th {
    border: 1px solid black;
}

</style>
<script>

  $(function() {

    //$( "#accordion" ).accordion();
	  $("#accordion").accordion({ active: <%=index %>, 
		                          event: "click",  
		                          alwaysOpen:true, 
		                          header: "h4",
		                          autoHeight: false,
		                          heightStyle: "content", 
		                          collapsible: true,
		                          beforeActivate: function(event, ui) {
		                              // The accordion believes a panel is being opened
		                             if (ui.newHeader[0]) {
		                                 var currHeader  = ui.newHeader;
		                                 var currContent = currHeader.next('.ui-accordion-content');
		                              // The accordion believes a panel is being closed
		                             } else {
		                                 var currHeader  = ui.oldHeader;
		                                 var currContent = currHeader.next('.ui-accordion-content');
		                             }
		                              // Since we've changed the default behavior, this detects the actual status
		                             var isPanelSelected = currHeader.attr('aria-selected') == 'true';
		                             
		                              // Toggle the panel's header
		                             currHeader.toggleClass('ui-corner-all',isPanelSelected).toggleClass('accordion-header-active ui-state-active ui-corner-top',!isPanelSelected).attr('aria-selected',((!isPanelSelected).toString()));
		                             
		                             // Toggle the panel's icon
		                             currHeader.children('.ui-icon').toggleClass('ui-icon-triangle-1-e',isPanelSelected).toggleClass('ui-icon-triangle-1-s',!isPanelSelected);
		                             
		                              // Toggle the panel's content
		                             currContent.toggleClass('accordion-content-active',!isPanelSelected)    
		                             if (isPanelSelected) { currContent.slideUp(); }  else { currContent.slideDown(); }

		                             return false; // Cancels the default action
		                         }
	  });
	  $( "#<portlet:namespace />businessStartDate" ).datepicker();
	 
  });

  </script>


<div id="accordion">
<h4>Payment Calculator</h4>

<div>
<aui:form name="creditApp" method="post" action="<%=submitPaymentCalculatorUrl%>" >
	<table style="width:100%">
	<thead align="left">
	<tr valign="top">
			<td align="left">
				<p>&nbsp;&nbsp;</p>
			</td>
			
			<td align="left">
				<div>Select One or More Product</div>
				
			</td>
			<td>
				<p></p>
			</td>
			<td align="left">
				<div id="purchaseOptionHeader" style="display:<%=productNameListMap.size() > 0 ? "block":"none"%>">Select One or More Purchase Option:</div>
				
			</td>
			<td align="left">
				<p></p>
			</td>
			<td align="left">
				<div id="termOptionHeader" style="display:<%=purchaseOptionListMap.size() > 0 ? "block":"none"%>" >Select One or More Terms:</div>
				
			</td>
		</tr>
	</thead>
	<tbody align="left">
		<tr valign="top">
			<td align="left">
				<div class="box">
					
					<aui:input disabled="true" type="text" label="" name="equipmentPrice" value="<%=request.getAttribute(\"equipmentPrice\")%>">Equipment Price</aui:input>
				</div>
			</td>
			
			<td align="left" nowrap="nowrap">
				<div class="boxed">
				
				 <%  for (int i=0; i<productNameList.size();i++) {%> 
				      <input disabled="disabled" type="checkbox" onclick="javascript:getPurchaseOption('<%=productNameList.get(i) %>')" <%=productNameListMap.get(productNameList.get(i)) != null?"checked":""%> value="<%=productNameList.get(i)%>"  name="<%="productPricing"+i%>" />&nbsp;<%=ProductLocalServiceUtil.getProduct(new Long(productNameList.get(i)).longValue()).getProductName() %><br>
						<%} %>
				</div>
			</td>
			<td align="left">
				<p></p>
			</td>
			<td align="left" nowrap="nowrap">
				<div class="boxed" id="purchaseOption" style="display:<%=purchaseOptionListResult.size() > 0 ? "block":"none"%>"> 
				<% 
						for ( int j=0; j < purchaseOptionListResult.size(); j++) {%> 
						     <input  disabled="disabled"	type="checkbox"  onclick="javascript:getTermOption('<%=purchaseOptionListResult.get(j)%>')" <%=purchaseOptionListMap.get(purchaseOptionListResult.get(j)) != null?"checked":"" %> value="<%=purchaseOptionListResult.get(j)%>" name="<%="purchaseOption"+j%>" />&nbsp;<%=PurchaseOptionLocalServiceUtil.getPurchaseOption(new Long(purchaseOptionListResult.get(j)).longValue()).getPurchaseOptionName()%><br> 
						
						<%} %>
			   </div>
			  
			</td>
			<td align="left">
				<div>
			</div>
			</td>
			<td align="left" nowrap="nowrap">
				
				<div class="boxed" id="termOption" style="display:<%=termNameListResult.size() > 0 ? "block":"none"%>">  
						<% for (int k=0; k < termNameListResult.size();k++) {%> 
						  <aui:input disabled="true" type="checkbox" checked="<%=termNameListMap.get(termNameListResult.get(k)) != null%>" value="<%=termNameListResult.get(k)%>" label="" name="<%=\"termOption\"+k%>"></aui:input><%=TermLocalServiceUtil.getTerm(new Long(termNameListResult.get(k)).longValue()).getTermName()%><br>
					<%} %>
				 </div>
				 
			</td>
		</tr>
		</tbody>
	</table>
</aui:form>
</div>
<% if (proposalOptionList.size() > 0) { %>
<h4>Payment Calculator Results</h4>
<div id="calculationResults" style="display:<%=(proposalOptionList.size() > 0 ?"block":"none")%>" >
<aui:form name="results" method="post" action="<%=submitPaymentCalculatorUrl%>" >
			
 <table border="1">
 <thead>
    <tr>
			<td>Option</td>
			<td>Product</td>
			<td>Purchase Option	</td>
			<td>Term</td>
			<td>Payment Amount</td>
			<td>Included in Proposal</td>
			<td>Use For Application</td>
		</tr>
</thead>
<tbody>
	<%  
		TempProposalOption proposalOption = new TempProposalOption();
      for (int i=0;i < proposalOptionList.size();i++) {
      
    	  proposalOption=proposalOptionList.get(i);
      %>

		<tr>
			<td> <%="Option "+(i+1)%>

			</td>
			<td><%=ProductLocalServiceUtil.getProduct(proposalOption.getProductId()).getProductName()%> 

			</td>
			<td> <%=PurchaseOptionLocalServiceUtil.getPurchaseOption(proposalOption.getPurchaseOptionId()).getPurchaseOptionName()%> 

			</td>
			<td><%=TermLocalServiceUtil.getTerm(proposalOption.getTermId()).getTermName()%>
			</td>
			<td> <%=proposalOption.getPaymentAmount()%>
			</td>
			<td nowrap="nowrap"><aui:input type="checkbox" checked="<%=proposalOption.getIncludeInProposal()%>" value="<%=proposalOption.getProposalId()%>" label="" name="<%=\"includeInProposal\" +i%>"></aui:input>
			</td>
			<% if(request.getSession().getAttribute("useForApplication") != null ){ %>
			<td nowrap="nowrap"><aui:input type="radio" label="" value="<%=proposalOption.getProposalId()%>" name="useForApplication" checked="<%=request.getSession().getAttribute(\"useForApplication\") != null ? new Long(proposalOption.getProposalId()).toString().equalsIgnoreCase(request.getSession().getAttribute(\"useForApplication\").toString()):false%>"></aui:input>
			</td> 
			<%} else { %>
			<td nowrap="nowrap"><aui:input type="radio" label="" value="<%=proposalOption.getProposalId()%>" name="useForApplication" checked="<%=proposalOption.isUseForApplication()%>"></aui:input>
			</td>  		
			<%} %>															
		</tr>
	<%} %>
	</tbody>
	</table>
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
	<table style="width:100%">
		<tr valign="top">
			<td>
				<div><b>Customer</b> Info:</div>
				<div class="boxed">
				<br>Customer Name<br> 
				 <aui:input disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerName\")%>" name="customerName" />
				<br>DBA Name<br>
				  <aui:input disabled="true" type="text" label=""  value="<%=request.getAttribute(\"customerDBAName\")%>" name="customerDBAName" />
			     </div>
			</td>
			<td>
				<div>Customer <b>Contact</b> Info:</div>
				<div class="boxed">
				<br> Customer Contact <br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerContact\")%>"	name="customerContact" />
				<br><b>Contact Phone</b><br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerContactPhone\")%>"	name="customerContactPhone" />
				<br>Contact Fax<br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerContactFax\")%>"	name="customerContactFax" />
				<br>Contact Email<br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerContactEmail\")%>"	name="customerContactEmail" />
			    </div>
			</td>
			<td>
				<div>Customer <b>Address</b> Info:</div>
				<div class="boxed">
				<br> Customer Address <br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerAddress1\")%>"	name="customerAddress1" /><br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerAddress2\")%>"	name="customerAddress2" />
				<br><b>City</b><br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerCity\")%>"	name="customerCity" />
				<br>State<br>
				<select disabled="disabled" name="customerState" >
				 <option value="">Select One</option>
				 <% State[] customerState=StateUtil.STATES;
				   for (int i=0; i<customerState.length;i++){%>
				   	 <option value="<%= customerState[i].getId()%>" <%= customerState[i].getId().equalsIgnoreCase((String)request.getAttribute("customerState"))?"selected":""%> ><%= customerState[i].getName()%></option>
				  <% } %>
				 </select>
				
				<br>Zip<br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerZip\")%>"	name="customerZip" />
				  </div>
			</td>
			<td>
				<div><b>Business</b> Info</div>
				<div class="boxed">
                <br> Business Description <br>
				<aui:input 	disabled="true" type="textarea" label=""  value="<%=request.getAttribute(\"customerBusinessDesc\")%>"	name="customerBusinessDesc" />
				<br><b>Business Type</b><br>
				<select disabled="disabled" name="customerBusinessType" >
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
				<aui:input 	disabled="true" type="text" label=""  value="<%=request.getAttribute(\"customerBusinessStartDate\")%>"	name="customerBusinessStartDate" id="businessStartDate"/>
				<br>Incorporated State<br>
				<select disabled="disabled" name="customerBusinessIncorporatedState" >
				 <option value="">Select One</option>
				 <% State[] customerBusinessIncorporatedState=StateUtil.STATES;
				   for (int i=0; i<customerBusinessIncorporatedState.length;i++){%>
				   	 <option value="<%= customerBusinessIncorporatedState[i].getId()%>" <%= customerBusinessIncorporatedState[i].getId().equalsIgnoreCase((String)request.getAttribute("customerBusinessIncorporatedState"))?"selected":""%> ><%= customerBusinessIncorporatedState[i].getName()%></option>
				  <% } %>
				 </select>
				<br>Federal Tax Id<br>
				<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"customerBusinessFederalTaxID\")%>"	name="customerBusinessFederalTaxID" />
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
				  <aui:input disabled="true" type="text" label=""  value="<%=request.getAttribute(\"equipmentDesc\")%>" name="equipmentDesc" />
			</td>
			<td>
				<div>Equipment <b>Location</b></div>
				<div class="boxed">
					 <aui:input disabled="true" label=""	type="radio" value="EquipmentLocationSameAsCustomer" name="equipmentLocAsCustomerFlag" checked="<%=request.getAttribute(\"equipmentLocAsCustomerFlag\") != null ? \"EquipmentLocationSameAsCustomer\".equalsIgnoreCase(request.getAttribute(\"equipmentLocAsCustomerFlag\").toString()):false%>" />Equipment Location Same As Customer<br>
					 <aui:input disabled="true" label=""	type="radio" value="DifferentLocation"	name="equipmentLocAsCustomerFlag" checked="<%= request.getAttribute(\"equipmentLocAsCustomerFlag\") != null ? \"DifferentLocation\".equalsIgnoreCase(request.getAttribute(\"equipmentLocAsCustomerFlag\").toString()):false%>" />Different Location
				</div>
			</td>
			<td>
			<div style="display:<%=request.getAttribute("equipmentLocAsCustomerFlag") != null ?("EquipmentLocationSameAsCustomer".equalsIgnoreCase(request.getAttribute("equipmentLocAsCustomerFlag").toString())?"none":"block"):"block"%>">
				<div>Equipment<b>Address</b> Info:</div>
				<div class="boxed">
					<br> Customer Address <br>
					<aui:input 	 disabled="true" type="text" label="" value="<%=request.getAttribute(\"equipmentAddress1\")%>"	name="equipmentAddress1" /><br>
					<aui:input 	disabled="true" type="text" label="" value="<%=request.getAttribute(\"equipmentAddress2\")%>"	name="equipmentAddress2" />
					<br><b>City</b><br>
					<aui:input disabled="true"	type="text" label="" value="<%=request.getAttribute(\"equipmentCity\")%>"	name="equipmentCity" />
					<br>State<br>
					<select disabled="disabled" name="equipmentState" >
				     <option value="">Select One</option>
				     <% State[] equipmentState=StateUtil.STATES;
				       for (int i=0; i<equipmentState.length;i++){%>
				   	      <option value="<%= equipmentState[i].getId()%>" <%= equipmentState[i].getId().equalsIgnoreCase((String)request.getAttribute("equipmentState"))?"selected":""%> ><%= equipmentState[i].getName()%></option>
				       <% } %>
				     </select>
					
					<br>Zip<br>
					<aui:input disabled="true"	type="text" label="" value="<%=request.getAttribute(\"equipmentZip\")%>"	name="equipmentZip" />
				</div>
			 </div>
			</td>
			
		</tr>
	</table>


<table><tr><td nowrap="nowrap">
</td></tr></table>
</div>
</aui:form>
</div>
<h4>Principal Information</h4>
 <div style="display:<%=(request.getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getAttribute("creditAppId").toString()) ?"block":"none")%>" > 

	<table style="width:100%">
		<tr valign="top">
			<td nowrap="nowrap" align="left" width="50%" >
			<div class="boxed">
			<table style="width:450px">
			
			 <tr valign="top">
			    <th ><b>LastName</b></th><th><b>FirstName</b></th><th><b>SSN</b></th>
			 </tr>
			<div id="principalIdDiv">
			  <% 
			   if( creditAppPrincipalList != null) {
				   for ( int i=0; i<creditAppPrincipalList.size();i++){%>
			   		
			   <tr valign="top" >
			    <td><%=creditAppPrincipalList.get(i).getPrincipalLastName()%></td>
			    <td><%=creditAppPrincipalList.get(i).getPrincipalFirstName()%></td>
			    <td><%=creditAppPrincipalList.get(i).getPrincipalSSN()%></td>
		
			  </tr>
			 
			   <%} 
			  }%>
			  </div>
			</table>
			</div>
			</td>
		</tr>
	</table>
</div>

<h4>Credit Application Bank Reference Information</h4>
 <div  align="left" style="display:<%=(request.getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getAttribute("creditAppId").toString()) ?"block":"none")%>" > 
<div align="left" >

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
		</tr>
		
	<%} 
	}%>
	</table>
</div>
</div>
<%} %>
</div>