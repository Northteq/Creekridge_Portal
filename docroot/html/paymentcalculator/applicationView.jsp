<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<portlet:renderURL portletMode="view" var="editAppURL">
	<portlet:param name="viewOnly" value="<%=String.valueOf(false)%>" />
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:renderURL>
<c:if test="${creditApp.creditAppId != 0}">
	<h3 id="screenTitle">Application #${creditApp.creditAppId} ${creditApp.customerName}</h3>
</c:if>
<c:import url="/html/paymentcalculator/buttons.jsp"></c:import>

<aui:fieldset column="true" label="Customer Information">
	<dl class="dl-horizontal">
		<dt>Credit App#</dt>
		<dd>${creditApp.creditAppId}</dd>
		<dt>Name</dt>
		<dd>${creditApp.customerName}</dd>
		<dt>DBA Name</dt>
		<dd>${creditApp.customerDBAName}</dd>
		
		<dt>Phone</dt>
		<dd>${creditApp.customerContactPhone}</dd>
		<dt>Fax</dt>
		<dd>${creditApp.customerContactFax}</dd>
		<dt>Email</dt>
		<dd>${creditApp.customerContactEmail}</dd>
	</dl>
</aui:fieldset>

<aui:fieldset column="true" label="Customer Address">
	<dl class="dl-horizontal">
		<dt>Address Line 1</dt>
		<dd>${creditApp.customerAddress1}</dd>
		<dt>Address Line 2</dt>
		<dd>${creditApp.customerAddress2}</dd>
		<dt>City</dt>
		<dd>${creditApp.customerCity}</dd>
		<dt>State</dt>
		<dd>${creditApp.customerState}</dd>
		<dt>Zip</dt>
		<dd>${creditApp.customerZip}</dd>
	</dl>
</aui:fieldset>



<aui:fieldset column="true" label="Pricing Overview">

	<div id="proposalOptionsSection" style="display: none">

		<div id="proposalOptionsTable"></div>
	</div>
</aui:fieldset>

<aui:fieldset column="true" label="Business Info">
	<dl class="dl-horizontal">
		<dt>Type</dt>
		<dd>${creditApp.customerBusinessType}</dd>
		
		<dt>Start Date</dt>
		<dd><fmt:formatDate value="${creditApp.customerBusinessStartDate}"
						pattern="MM/dd/yyyy" var="busStartDate" />${busStartDate}</dd>
		<dt>Incorporated State</dt>
		<dd>${creditApp.customerBusinessIncorporatedState}</dd>
		<dt>Ferederal Tax Id</dt>
		<dd>${creditApp.customerBusinessFederalTaxID}</dd>
		
		<dt>Description</dt>
		<dd>${creditApp.customerBusinessDesc}</dd>
	</dl>
</aui:fieldset>

<aui:fieldset column="true" label="Equipment Information">
	<dl class="dl-horizontal">
		<dt>Description</dt>
		<dd>${creditApp.equipmentDesc}</dd>
		<dt>Equipment Price</dt>
		
		<fmt:formatNumber value="${creditApp.equipmentPrice}"
						type="CURRENCY" var="eqPrice" />
						
						
		<dd>${eqPrice}</dd>
		
	</dl>
</aui:fieldset>

<c:if test="${showPrincipals}">
	<aui:fieldset column="true" label="Principal Info">
		<div id="principalDataTable"></div>
		<c:import url="/html/paymentcalculator/principals/principalInformationTable.jsp"></c:import>
	</aui:fieldset>
</c:if>

<c:if test="${showBankRefs}">
	<aui:fieldset column="true" label="Bank Reference Info">
		<div id="bankReferenceDataTable"></div>
		<c:import url="/html/paymentcalculator/bankreferences/bankReferenceTable.jsp"></c:import>
	</aui:fieldset>
</c:if>

<style>
.dl-horizontal dt {
	min-width: 180px;
	padding-right: 20px;
}

.dl-horizontal > dd:after {
  display: table;
  content: "";
  clear: both;
}
</style>