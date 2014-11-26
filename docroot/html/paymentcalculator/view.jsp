<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<%

String calculatorSectionState = ParamUtil.getString(request, "calculatorSectionState", "open");
String pricingOvervewSectionState = ParamUtil.getString(request, "pricingOvervewSectionState", "collapsed");

%>


<script src="<%= renderRequest.getContextPath()%>/js/paymentcalculator.js" type="text/javascript"></script>

<portlet:resourceURL var="processProductsSelectionURL"
	id="processProductsSelection" />
	
<portlet:resourceURL var="processPurchaseOptionsSelectionURL"
	id="processPurchaseOptionsSelection" />


<portlet:resourceURL var="calculatePaymentsURL"
	id="calculatePayments" />
	
<portlet:resourceURL var="updateUseForApplicationURL"
	id="updateUseForApplication" />

<portlet:resourceURL var="updateIncludeInProposalURL"
	id="updateIncludeInProposal" />

<portlet:actionURL name="saveApplicationInfo" var="saveApplicationInfoURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>

<portlet:actionURL name="submitApplication" var="submitApplicationURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>


<liferay-ui:error key="errorProposalRequired" message="error-one-proposal-required" />
<liferay-ui:error key="runCalculatorRequired" message="error-run-calculator-required" />
<liferay-ui:success key="appSaved" message="app-saved-successfully"/>
<liferay-ui:success key="appUpdated" message="app-updated-successfully"/>
<liferay-ui:success key="appSubmitted" message="app-submitted-successfully"/>



<script type="text/javascript" charset="utf-8">
function processAppButton(action){
	
	var formEl = $('[name="<portlet:namespace/>applicationForm"]');
	console.log (formEl);
	console.log (action);
  if(action==0){
	  formEl.attr('action',"<%=saveApplicationInfoURL%>");
  }else{
	  formEl.attr('action',"<%=submitApplicationURL%>");
  }
 
}
</script>

<c:if test="${creditApp.creditAppStatusId != 3}">

<aui:form action="<%=saveApplicationInfoURL.toString() %>" method="post" name="applicationForm">
	<c:if test="${creditApp.creditAppId != 0}">
		<h3>Application ${creditApp.creditAppId} </h3> 
 	</c:if>
	
	<c:if test="${creditApp.creditAppId == 0}">
		<h3>New Application</h3> 
 	</c:if>
 	
 	
 	 <c:import url="/html/paymentcalculator/buttons.jsp"></c:import>

	<liferay-ui:panel-container accordion="true" extended="false">
		<liferay-ui:panel title="Payment Calculator" id="paymentCalculator" state="<%=calculatorSectionState %>">
				
				<aui:col span="3" first="true">
					<aui:input id="equipmentPrice" type="number" step="any" name="equipmentPrice" size="7" style="width:150px"  label="Equipment Price" required="true" value="${creditApp.equipmentPrice}"></aui:input>
				</aui:col>
	
				<aui:col span="3" id="product">
					<h4>Pricing Products</h4>
					<aui:fieldset column="true">
	
						<div id="productList">
							<c:forEach items="${productOptions}" var="product">
								<aui:input type="checkbox" name="${product.productId}"
									label="${product.productName}" value="${product.productId}"
									onchange="getPurchaseOptions()"></aui:input>
							</c:forEach>
						</div>
					</aui:fieldset>
				</aui:col>
	
				<aui:col span="3" id="purchaseOption">
					<div id="purchaseOptionSection" style="display: none">
	
						<h4>Purchase Options</h4>
						<aui:fieldset column="true">
							<div id="purchaseOptionsList"></div>
	
						</aui:fieldset>
					</div>
				</aui:col>
	
				<aui:col span="2" last="true" id="term">
					<div id="termSection" style="display: none">
	
						<h4>Terms</h4>
						<aui:fieldset column="true">
							<div id="termsList"></div>
	
						</aui:fieldset>
					</div>
				</aui:col>
				
				<aui:button-row>
					<button class="btn btn-danger" type="reset" onclick="resetAllSections();"><i class="icon-remove"></i> Clear</button>
					<button class="btn btn-success" type="submit" id="calculatePaymentsButton" onclick="return calculatePayments()"><i class="icon-th"></i> Calculate Payments </button>
				
				</aui:button-row>
		</liferay-ui:panel>
		
		<!-- PRICING OVERVIEW PANEL  -->
	
		<liferay-ui:panel title="Pricing Overview" id="pricingOvervewResults" state="<%=pricingOvervewSectionState%>">
	    	<div id="proposalOptionsSection" style="display:none">
	    			
	    		<div id="proposalOptionsTable"></div>
	   		
	    		<aui:button-row>
	    			<button type="submit" class="btn btn-info" id="createApplicationButton"> Create Application </button>
	    			<a class="btn btn-success" id="navigateToCalculator" onclick="navigateToCalculator()">Back to Calculator</a>
	    		</aui:button-row>
	    	</div>
	 	</liferay-ui:panel>
	 	
	 	<!-- APPLICATION PANEL  -->
		<c:if test="${creditApp.creditAppId != null}">
		
			<c:import url="/html/paymentcalculator/applicationEdit.jsp"></c:import>
			
	 	</c:if>
	 	
	</liferay-ui:panel-container>
	
	
	
	
</aui:form>




<script type="text/javascript">

var processProductsSelectionURL = "<%=processProductsSelectionURL%>";
var processPurchaseOptionsSelectionURL = "<%=processPurchaseOptionsSelectionURL%>";
var updateUseForApplicationURL = "<%=updateUseForApplicationURL%>";
var updateIncludeInProposalURL = "<%=updateIncludeInProposalURL%>";
var calculatePaymentsURL = "<%=calculatePaymentsURL%>";



$(document).ready(function () {
	
	var proposals;
	var proposalsString = '${proposalList}';
	try {
		
		console.log ('${proposalList}', proposalsString);
		
		if (proposalsString != "") {
			proposals = jQuery.parseJSON('${proposalList}');
			buildProposalOptionsTable(proposals);
		}
		
	} catch (e) {
		console.log ('error getting proposals ', e);
	}

	$(".alert-error:contains('Your request failed to complete.')").hide();
	
		
});

</script>

<style>
.purchaseOptionsColumn {
	text-align:center !important;
}
</style>



</c:if>




<!-- SUBMITTED APPS  -->


<c:if test="${creditApp.creditAppStatusId == 3}">

<c:import url="/html/paymentcalculator/applicationView.jsp"></c:import>

</c:if>