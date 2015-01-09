<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>


<liferay-ui:error key="errorProposalRequired" message="error-one-proposal-required" />
<liferay-ui:error key="runCalculatorRequired" message="error-run-calculator-required" />
<liferay-ui:error key="genericError" message="generic-error"/>
<liferay-ui:success key="appSaved" message="app-saved-successfully" />

<script src="<%=request.getContextPath() %>/js/jquery.maskedinput.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/numeral.min.js"></script>

<div class="alert alert-danger" role="alert" id="validationErrors" style="display:none"></div>

<aui:form method="post" name="applicationForm">
	<c:if test="${creditApp.creditAppId != 0 && creditApp != null}">
		<h3 id="screenTitle">Application #${creditApp.creditAppId} ${creditApp.customerName}</h3>
	</c:if>

	<c:if test="${creditApp.creditAppId == 0}">
		<h3>New Application</h3>
	</c:if>
	
	<c:import url="/html/paymentcalculator/buttons.jsp"></c:import>

	<liferay-ui:panel-container accordion="true" extended="false">
		<liferay-ui:panel cssClass="payCalc" title="Payment Calculator" id="paymentCalculator"
			state="${openSection=='paymentCalculator'? 'open' : 'collapsed' }">
			<aui:col span="3" first="true"> 
				<fmt:formatNumber value="${creditApp.equipmentPrice}" var="eqPrice" type="CURRENCY"/>
				<aui:input id="equipmentPrice" step="any"
					name="equipmentPrice" size="7" style="width:150px"
					value="${eqPrice}" onchange="checkSelectedOptions(); $(this).val(numeral($(this).val()).format('$0,0.00'))">
					<%-- <aui:validator name="min">0.01</aui:validator> --%>
					 <aui:validator name="required" errorMessage="*"/>
					 <%-- <aui:validator name="number"/> --%>
					</aui:input> 
			</aui:col>

			<aui:col span="3" id="product">
				<h4>Pricing Products*</h4>
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

					<h4>Purchase Options*</h4>
					<aui:fieldset column="true">
						<div id="purchaseOptionsList"></div>

					</aui:fieldset>
				</div>
			</aui:col>

			<aui:col span="2" last="true" id="term">
				<div id="termSection" style="display: none">

					<h4>Terms*</h4>
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
				<button class="btn btn-success btn-small"
					id="calculatePaymentsButton" onclick="calculatePayments(); return false;">
					<i class="icon-th"></i> Calculate Payments
				</button>

			</aui:button-row>
		</liferay-ui:panel>

		<!-- PRICING OVERVIEW PANEL  -->

		<liferay-ui:panel cssClass="payCalc" title="Pricing Overview" id="pricingOvervewResults"
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
		<c:if test="${creditApp.creditAppStatusId == 2}">

			<liferay-ui:panel cssClass="payCalc" title="Customer and Equipment Info"
				id="customerAndEquipmentInfo"
				state="${openSection=='customerAndEquipmentInfo'? 'open' : 'collapsed' }">

				<aui:fieldset column="false" label="Customer">
					<aui:input inlineField="true" name="customerName"
						value="${creditApp.customerName}">
						<aui:validator name="required" />
					</aui:input>
					<aui:input inlineField="true" name="customerDBAName"
						label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
				</aui:fieldset>

				<aui:fieldset column="false" label="Customer Contact">
					<aui:input inlineField="true" name="customerContact"
						value="${creditApp.customerContact}">
						
						<aui:validator name="required" />
					</aui:input>
					<aui:input inlineField="true" name="customerContactEmail"
						 value="${creditApp.customerContactEmail}">
						<aui:validator name="email" />
						<aui:validator name="required" />
					</aui:input>
					<aui:input inlineField="true" name="customerContactPhone" cssClass="phone"
						value="${creditApp.customerContactPhone}">
							
						<aui:validator name="required" />
					</aui:input>
					<aui:input inlineField="true" name="customerContactFax" cssClass="phone"
						value="${creditApp.customerContactFax}">
						
					</aui:input>
				</aui:fieldset>

				<aui:fieldset column="false" label="Customer Address">
					<aui:input inlineField="true" name="customerAddress1"
						value="${creditApp.customerAddress1}">
						<aui:validator name="required" />
					</aui:input>
					
					<aui:input inlineField="true" name="customerAddress2"
						value="${creditApp.customerAddress2}">
					
					</aui:input>
					
					<aui:input inlineField="true" name="customerCity"
						value="${creditApp.customerCity}">
						<aui:validator name="required" />
					</aui:input>

					<aui:select inlineField="true" name="customerState"
						showEmptyOption="true" required="true">
						<c:forEach items="${statesList}" var="state">
							<aui:option value="${state.id}" label="${state.name}"
								selected="${creditApp.customerState == state.id}" />
						</c:forEach>
						
					</aui:select>
					<aui:input inlineField="true" name="customerZip"
						value="${creditApp.customerZip}">
						<aui:validator name="required" />
						</aui:input>

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
					<aui:input id="customerBusinessStartDate" inlineField="true" cssClass="date"
						name="customerBusinessStartDate" value="${busStartDate}">
						<aui:validator name="date"/>
					</aui:input>

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
					<aui:input type="textarea" rows="3" name="customerBusinessDesc" value="${creditApp.customerBusinessDesc}"></aui:input>
				</aui:fieldset>

				<aui:fieldset label="Equipment Info">
					
					<fmt:formatNumber value="${creditApp.equipmentPrice}"
						type="CURRENCY" var="eqPrice" />
					
					<aui:input inlineField="true" name="equipmentDesc" 
						value="${creditApp.equipmentDesc}">
						<aui:validator name="required" />	
					</aui:input>
				
					<aui:input inlineField="true" name="eqPrice" label="Equipment Price"
						value="${eqPrice}" disabled="true"/>
					
					<aui:input type="checkbox" name="equipmentLocAsCustomerFlag"
						value="${creditApp.equipmentLocAsCustomerFlag}" inline="true"
						onchange="copyCustomerAddress($(this))"></aui:input>

					<div id="equipmentAddressSection" style="${creditApp.equipmentLocAsCustomerFlag==true ? 'display:none' : ''}">
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
					</div>
					
					
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
			<liferay-ui:panel cssClass="payCalc" title="principal-info-section" id="principalInfo"
				state="${openSection=='principalSection'? 'open' : 'collapsed' }">
				
				
				<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
				
				<aui:button-row>
					<a class="btn  btn-info btn-small" id="addRow">Add Principal</a>
				</aui:button-row>
				
				</c:if>
				
				<p/>
				
				<div id="principalDataTable"></div>
				
				
				<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
				
				<aui:button-row>
					<a class="btn btn-small" id="addRow" onclick="navigateTocustomerAndEquipmentInfo()"><i class="icon-backward"></i>
										Back to Customer Info</a>
					<a class="btn btn-small" id="addRow" onclick="navigateToBankReference()"><i class="icon-forward"></i>
										Continue to Bank Reference</a>
				</aui:button-row>
				</c:if>
			</liferay-ui:panel>
			
			<!-- BANK REFERENCE  -->
			<liferay-ui:panel cssClass="payCalc" title="bank-reference-info-section"
				id="bankRefereceInfo"
				state="${openSection=='bankReferenceSection'? 'open' : 'collapsed' }">
				
				<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
				<aui:button-row>
					<a class="btn btn-info btn-small" id="addRefRow">Add Bank Reference</a>
					</aui:button-row>
					</c:if>
					
					<p/>
					
					<div id="bankReferenceDataTable"></div>
					
					<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
					<aui:button-row>
					<a class="btn btn-small" id="navigateToPrincipal" onclick="navigateToPrincipal()"><i class="icon-backward"></i> Back to Principal</a>
					</aui:button-row>
					</c:if>
			</liferay-ui:panel>
			
			
		</c:if>

	</liferay-ui:panel-container>
	
	<c:import url="/html/paymentcalculator/buttons.jsp"></c:import>
</aui:form>


<c:if test="${creditApp.creditAppStatusId == 2 && viewOnly==false}">
	<c:import url="/html/paymentcalculator/principals/principalInformationTable.jsp"></c:import>
	<c:import url="/html/paymentcalculator/bankreferences/bankReferenceTable.jsp"></c:import>

</c:if>

<style>
.purchaseOptionsColumn {
	text-align: center !important;
}
</style>