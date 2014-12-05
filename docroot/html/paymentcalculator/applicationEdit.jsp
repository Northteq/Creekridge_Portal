<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>


<liferay-ui:error key="errorProposalRequired"
	message="error-one-proposal-required" />
<liferay-ui:error key="runCalculatorRequired"
	message="error-run-calculator-required" />
<liferay-ui:success key="appSaved" message="app-saved-successfully" />



<aui:form method="post"
	name="applicationForm">
	<c:if test="${creditApp.creditAppId != 0}">
		<h3 id="screenTitle">Application #${creditApp.creditAppId} ${creditApp.customerName}</h3>
	</c:if>

	<c:if test="${creditApp.creditAppId == 0}">
		<h3>New Application</h3>
	</c:if>


	<c:import url="/html/paymentcalculator/buttons.jsp"></c:import>

	<liferay-ui:panel-container accordion="true" extended="false">
		<liferay-ui:panel title="Payment Calculator" id="paymentCalculator"
			state="${openSection=='paymentCalculator'? 'open' : 'collapsed' }">

			<aui:col span="3" first="true">
				<aui:input id="equipmentPrice" type="number" step="any"
					name="equipmentPrice" size="7" style="width:150px" required="true"
					value="${creditApp.equipmentPrice}"></aui:input>
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
				<button class="btn btn-danger btn-small" type="reset"
					onclick="resetAllSections();">
					<i class="icon-remove"></i> Clear
				</button>
				<button class="btn btn-success btn-small" type="submit"
					id="calculatePaymentsButton" onclick="return calculatePayments()">
					<i class="icon-th"></i> Calculate Payments
				</button>

			</aui:button-row>
		</liferay-ui:panel>

		<!-- PRICING OVERVIEW PANEL  -->

		<liferay-ui:panel title="Pricing Overview" id="pricingOvervewResults"
			state="${openSection=='pricingOverview'? 'open' : 'collapsed' }">
			<div id="proposalOptionsSection" style="display: none">

				<div id="proposalOptionsTable"></div>

				<aui:button-row>
					<a class="btn btn-small" id="navigateToCalculator"
						onclick="navigateToCalculator()"><i class="icon-backward"></i> Back to Calculator</a>
					<a class="btn btn-primary btn-small" id="createApplicationButton"
						onClick="processAppButton(0)"><i class="icon-forward"></i>
						Continue to Customer Info </a>
				</aui:button-row>
			</div>
		</liferay-ui:panel>

		<!-- APPLICATION PANEL  -->
		<c:if test="${creditApp.creditAppId != null}">

			<liferay-ui:panel title="Customer and Equipment Info"
				id="customerAndEquipmentInfo"
				state="${openSection=='customerAndEquipmentInfo'? 'open' : 'collapsed' }">

				<aui:fieldset column="false" label="Customer">
					<aui:input inlineField="true" name="customerName"
						value="${creditApp.customerName}"></aui:input>
					<aui:input inlineField="true" name="customerDBAName"
						label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
				</aui:fieldset>

				<aui:fieldset column="false" label="Customer Contact">
					<aui:input inlineField="true" name="customerContact"
						value="${creditApp.customerContact}"></aui:input>
					<aui:input inlineField="true" name="customerContactEmail"
						type="email" value="${creditApp.customerContactEmail}"></aui:input>
					<aui:input inlineField="true" name="customerContactPhone"
						type="tel" value="${creditApp.customerContactPhone}"></aui:input>
					<aui:input inlineField="true" name="customerContactFax"
						value="${creditApp.customerContactFax}"></aui:input>
				</aui:fieldset>

				<aui:fieldset column="false" label="Customer Address">
					<aui:input inlineField="true" name="customerAddress1"
						value="${creditApp.customerAddress1}"></aui:input>
					<aui:input inlineField="true" name="customerAddress2"
						value="${creditApp.customerAddress2}"></aui:input>
					<aui:input inlineField="true" name="customerCity"
						value="${creditApp.customerCity}"></aui:input>

					<aui:select inlineField="true" name="customerState"
						showEmptyOption="true">
						<c:forEach items="${statesList}" var="state">
							<aui:option value="${state.id}" label="${state.name}"
								selected="${creditApp.customerState == state.id}" />
						</c:forEach>
					</aui:select>
					<aui:input inlineField="true" name="customerZip"
						value="${creditApp.customerZip}"></aui:input>

				</aui:fieldset>

				<aui:fieldset column="false" span="12" label="Business Information">


					<aui:select inlineField="true" name="customerBusinessType"
						showEmptyOption="true">
						<c:forEach items="${corpTypeList}" var="corpType">
							<aui:option value="${corpType}" label="${corpType}"
								selected="${creditApp.customerBusinessType == corpType}" />
						</c:forEach>
					</aui:select>
					<fmt:formatDate value="${creditApp.customerBusinessStartDate}"
						pattern="MM/dd/yyyy" var="busStartDate" />
					<aui:input id="customerBusinessStartDate" inlineField="true"
						name="customerBusinessStartDate" value="${busStartDate}"></aui:input>

					<%-- <liferay-ui:input-date dayParam="d1" monthParam="m1" yearParam="y1"  yearValue="2014" monthValue="09" dayValue="25"  autoFocus="true">Open Day</liferay-ui:input-date>
 --%>
					<aui:select inlineField="true"
						name="customerBusinessIncorporatedState" showEmptyOption="true">
						<c:forEach items="${statesList}" var="state">
							<aui:option value="${state.id}" label="${state.name}"
								selected="${creditApp.customerBusinessIncorporatedState == state.id}" />
						</c:forEach>
					</aui:select>

					<aui:input inlineField="true" type="text"
						value="${creditApp.customerBusinessFederalTaxID}"
						name="customerBusinessFederalTaxID" />

				</aui:fieldset>

				<aui:fieldset>
					<aui:input type="textarea" rows="3" name="customerBusinessDesc"></aui:input>
				</aui:fieldset>

				<aui:fieldset label="Equipment Info">
					<fmt:formatNumber value="${creditApp.equipmentPrice}"
						type="CURRENCY" var="eqPrice" />
					<label>Equipment Price</label>${eqPrice} <br />
					<br />
					<aui:input type="checkbox" name="equipmentLocAsCustomerFlag"
						value="${creditApp.equipmentLocAsCustomerFlag}"
						onchange="copyCustomerAddress($(this))"></aui:input>

				</aui:fieldset>
				
				
				<aui:fieldset id="equipmentAddress" style="${creditApp.equipmentLocAsCustomerFlag==true ? 'display:none' : ''}">
					<aui:input inlineField="true" type="text"
						value="${creditApp.equipmentAddress1}" name="equipmentAddress1" />
					<aui:input inlineField="true" type="text"
						value="${creditApp.equipmentAddress2}" name="equipmentAddress2" />
					<aui:input inlineField="true" type="text"
						value="${creditApp.equipmentCity}" name="equipmentCity" />
					<aui:select inlineField="true" name="equipmentState"
						showEmptyOption="true">
						<c:forEach items="${statesList}" var="state">
							<aui:option value="${state.id}" label="${state.name}"
								selected="${creditApp.equipmentState == state.id}" />
						</c:forEach>
					</aui:select>
					<aui:input inlineField="true" type="text"
						value="${creditApp.equipmentZip}" name="equipmentZip" />
				</aui:fieldset>

				<aui:fieldset>
					<aui:input type="textarea" rows="3" name="equipmentDesc"
						value="${creditApp.equipmentDesc}"></aui:input>
				</aui:fieldset>
				
				<aui:button-row>
					
					
					<a class="btn btn-small" id="navigateToPricingOverview"
						onclick="navigateToPricingOverview()"><i class="icon-backward"></i>
						Back to Pricing Overview</a>
						
					<a class="btn btn-primary btn-small" id="navigateToBankReference"
						onclick="navigateToPrincipal()"><i class="icon-forward"></i>
						Continue to Principal</a>
				</aui:button-row>
				
			</liferay-ui:panel>

			<!-- http://fortawesome.github.io/Font-Awesome/3.2.1/icons/  -->
			
			<!-- PRINCIPAL INFO  -->
			<liferay-ui:panel title="principal-info-section" id="principalInfo"
				state="${openSection=='principalSection'? 'open' : 'collapsed' }">

				<c:import url="/html/paymentcalculator/principals/principalInformationTable.jsp"></c:import>
			</liferay-ui:panel>
			
			
			<!-- BANK REFERENCE  -->
			<liferay-ui:panel title="bank-reference-info-section"
				id="bankRefereceInfo"
				state="${openSection=='bankReferenceSection'? 'open' : 'collapsed' }">
				<c:import
					url="/html/paymentcalculator/bankreferences/bankReferenceTable.jsp"></c:import>
			</liferay-ui:panel>

		
		</c:if>

	</liferay-ui:panel-container>
	
	<c:import url="/html/paymentcalculator/buttons.jsp"></c:import>
	
</aui:form>



<style>
.purchaseOptionsColumn {
	text-align: center !important;
}
</style>