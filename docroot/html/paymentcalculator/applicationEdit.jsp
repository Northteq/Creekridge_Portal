<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<%
	String openSection = ParamUtil.getString(request, "openSection", "paymentCalculator");
	request.setAttribute("openSection", openSection);
	
	HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
	long appId = ParamUtil.getLong(request, "creditAppId");
	
	if (appId != 0) {
		request.setAttribute("creditApp", CreditAppLocalServiceUtil.getCreditApp(appId)); 
	}

	State[] statesList=StateUtil.STATES;
	renderRequest.setAttribute("statesList", statesList);
	
	String [] corpTypeList =  {"Corporation", "Sole Prop", "LLC", "LLP", "Partnership", "S Corporation", "Government Entity"};
	renderRequest.setAttribute("corpTypeList", corpTypeList);
%>

<portlet:resourceURL var="processProductsSelectionURL"
	id="processProductsSelection" />

<portlet:resourceURL var="processPurchaseOptionsSelectionURL"
	id="processPurchaseOptionsSelection" />

<portlet:resourceURL var="calculatePaymentsURL" id="calculatePayments" />

<portlet:resourceURL var="updateUseForApplicationURL"
	id="updateUseForApplication" />

<portlet:resourceURL var="updateIncludeInProposalURL"
	id="updateIncludeInProposal" />

<portlet:actionURL name="saveApplicationInfo"
	var="saveApplicationInfoURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>

<portlet:actionURL name="submitApplication" var="submitApplicationURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>


<liferay-ui:error key="errorProposalRequired"
	message="error-one-proposal-required" />
<liferay-ui:error key="runCalculatorRequired"
	message="error-run-calculator-required" />
<liferay-ui:success key="appSaved" message="app-saved-successfully" />
<liferay-ui:success key="appSubmitted"
	message="app-submitted-successfully" />


<portlet:renderURL portletMode="view" var="viewAppURL">
	<portlet:param name="viewMode" value="<%=String.valueOf(true)%>" />
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:renderURL>


<portlet:renderURL var="enterBankReferenceURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value="/html/paymentcalculator/bankreferences/enterReference.jsp" />
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:renderURL>


<aui:form action="<%=saveApplicationInfoURL.toString()%>" method="post"
	name="applicationForm">
	<c:if test="${creditApp.creditAppId != 0}">
		<h3 id="appTitle">Application ${creditApp.creditAppId}</h3>
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
				<button class="btn btn-danger" type="reset"
					onclick="resetAllSections();">
					<i class="icon-remove"></i> Clear
				</button>
				<button class="btn btn-success" type="submit"
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
					<a class="btn" id="navigateToCalculator"
						onclick="navigateToCalculator()">Back to Calculator</a>
					<a class="btn btn-primary" id="createApplicationButton"
						onClick="processAppButton(0)"><i class="icon-file"></i>
						Continue </a>
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
					
					<a class="btn btn-primary" id="navigateToBankReference"
						onclick="navigateToPrincipal()"><i class="icon-meh"></i>
						Continue to Principal</a>
					<a class="btn" id="navigateToPricingOverview"
						onclick="navigateToPricingOverview()"><i class="icon-meh"></i>
						Back to Pricing Overview</a>
				</aui:button-row>
				
			</liferay-ui:panel>

			<!-- http://fortawesome.github.io/Font-Awesome/3.2.1/icons/  -->
			
			
			
			
			<!-- PRINCIPAL INFO  -->
			<liferay-ui:panel title="principal-info-section" id="principalInfo"
				state="${openSection=='principalSection'? 'open' : 'collapsed' }">

				<c:import
					url="/html/paymentcalculator/principals/principalInformationTable.jsp"></c:import>
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
</aui:form>

<%-- <script
	src="<%=renderRequest.getContextPath()%>/js/paymentcalculator.js"
	type="text/javascript"></script> --%>

<script type="text/javascript" charset="utf-8">

AUI().use('aui-datepicker', function(A) {
	new A.DatePicker({
		trigger : '#<portlet:namespace/>customerBusinessStartDate',
		calendar : {
			selectionMode : 'multiple',
			showPrevMonth : true,
			showNextMonth : true,
			yearRange : [ 1970, 2009 ],
		},
		year : true,
		popover : {
			zIndex : 1
		},
		on : {
			selectionChange : function(event) {
				console.log(event.newSelection)
			}
		}
	});
});

function processAppButton(action){
	
	var formEl = $('[name="<portlet:namespace/>applicationForm"]');
	console.log (formEl);
	console.log (action);
  if(action==0){
	  formEl.attr('action',"<%=saveApplicationInfoURL%>");
  }else{
	  formEl.attr('action',"<%=submitApplicationURL%>");
  }
  
  console.log (formEl, action);
  
  
  $(formEl).submit();
 
}
</script>


<script>
	var copyCustomerAddress = function(sameAddressEl) {

		if ($(sameAddressEl).is(':checked') == false) {
			
			
			$('#<portlet:namespace/>equipmentAddress1').val(
					$('#<portlet:namespace/>customerAddress1').val());
			$('#<portlet:namespace/>equipmentAddress2').val(
					$('#<portlet:namespace/>customerAddress2').val());
			$('#<portlet:namespace/>equipmentCity').val(
					$('#<portlet:namespace/>customerCity').val());
			$('#<portlet:namespace/>equipmentState').val(
					$('#<portlet:namespace/>customerState').val());
			$('#<portlet:namespace/>equipmentZip').val(
					$('#<portlet:namespace/>customerZip').val());
			
			$('#<portlet:namespace/>equipmentAddress').show();
		} else {
			$('#<portlet:namespace/>equipmentAddress').hide();
		}
	};
</script>


<script type="text/javascript">

var processProductsSelectionURL = "<%=processProductsSelectionURL%>";
var processPurchaseOptionsSelectionURL = "<%=processPurchaseOptionsSelectionURL%>";
var updateUseForApplicationURL = "<%=updateUseForApplicationURL%>";
var updateIncludeInProposalURL = "<%=updateIncludeInProposalURL%>";
var calculatePaymentsURL = "<%=calculatePaymentsURL%>";

	$(document).ready(function() {

		var proposals;
		var proposalsString = '${proposalList}';
		try {
			if (proposalsString != "") {
				proposals = jQuery.parseJSON('${proposalList}');
				buildProposalOptionsTable(proposals);
			}

		} catch (e) {
			console.log('error getting proposals ', e);
		}

		$(".alert-error:contains('Your request failed to complete.')").hide();
	});


var navigateToCalculator = function () {
	$("*[data-persist-id='paymentCalculator']").click();
};

var navigateToBankReference = function () {
	$("*[data-persist-id='bankRefereceInfo']").click();
};

var navigateToPrincipal = function () {
	$("*[data-persist-id='principalInfo']").click();
	
};

var navigateTocustomerAndEquipmentInfo = function () {
	$("*[data-persist-id='customerAndEquipmentInfo']").click();
	
};

var navigateToPricingOverview = function () {
	$("*[data-persist-id='pricingOvervewResults']").click();
	
};


var createRateFactorRuleRequestObjectString = function () {
	
	var eqPrice = $('[id$=equipmentPrice]').val();
	
	//get products
	var productBoxes = $('#productList input:checked');
	var prodList = []
	
	$.each(productBoxes, function (i, el) {
		prodList[i] = $(el).val();
	});
	
	
	//get purchase options
	var poBoxes = $('#purchaseOptionsList input:checked');
	var poList = [];
	
	$.each(poBoxes, function (i, el) {
		poList[i] = $(el).val();
	});
	
	//get terms
	var termBoxes = $('#termsList input:checked');
	var termList = [];
	
	$.each(termBoxes, function (i, el) {
		termList[i] = $(el).val();
	});
	
	
	var selectedOptions = {
			equipmentPrice: eqPrice,
			products: prodList,
			purchaseOptions: poList,
			termOptions: termList
	};
	
	$.each(productBoxes, function (i, el) {
		prodList[i] = $(el).val();
	});
	
	return JSON.stringify(selectedOptions);
};

var resetAllSections = function () {
	$('#purchaseOptionsList').empty();
	$('#termsList').empty();
	$('#termSection').hide();
	$('#purchaseOptionSection').hide();
};

var getPurchaseOptions = function () {
	
	var productBoxes = $('#productList input:checked');
	var prodList = []
	$.each(productBoxes, function (i, el) {
		prodList[i] = $(el).val();
	});
	
	
	if (prodList.length>0) {
		
		var dataJsonString = createRateFactorRuleRequestObjectString();

		$.ajax({
					type : "POST",
					url : processProductsSelectionURL,
					cache : false,
					dataType : "Json",
					data : {
						selectedOptions : dataJsonString
					},
					success : function(data) {
						console.log('getPurchaseOptions success: ', data);

						var poOptions = '';
						resetAllSections();
						
						$.each(
							data,
							function(i, el) {
								poOptions += '<label class="checkbox">'
								poOptions += '<input type="checkbox" name="'+ el.purchaseOptionName + '" value="'+ el.purchaseOptionId+'"  onchange="getTermsOptions()">'
										+ el.purchaseOptionName
										+ '</input>';
								poOptions += '</label>';
							});

						$('#purchaseOptionsList').append(poOptions);
						$('#purchaseOptionSection').show();
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						console.log(textStatus);
						console.log(XMLHttpRequest);
						console.log(errorThrown);
					}
				});
	} else {
		resetAllSections();
	}
	
	

};


var getTermsOptions = function () {

	
	var dataJsonString = createRateFactorRuleRequestObjectString();

	console.log('selectedProducts', dataJsonString);

	$.ajax({
			type : "POST",
			url : processPurchaseOptionsSelectionURL,
			cache : false,
			dataType : "Json",
			data : {
				selectedOptions : dataJsonString
			},
			success : function(data) {
				console.log('getTermsOptions success: ', data);

				var termOptions = '';
				$('#termsList').empty();
				
				$.each(
					data,
					function(i, el) {
						termOptions += '<label class="checkbox">'
							termOptions += '<input type="checkbox" name="'+ el.termName + '" value="'+ el.termId+'">'
								+ el.termName
								+ '</input>';
							termOptions += '</label>';
					});

				$('#termsList').append(termOptions);
				$('#termSection').show();
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				console.log(textStatus);
				console.log(XMLHttpRequest);
				console.log(errorThrown);
			}
		});

};

var updateUseForApplication = function ($this) {
	
	//autoselect the uinclude in proposal
	
	updateUseInProposalSelection ($($this).parent().prev().children().prop('checked', true));
	var poId = $($this).val();
	$.ajax({
		type : "POST",
		url : updateUseForApplicationURL,
		cache : false,
		dataType : "Json",
		data : {
			proposalOptionId : poId
		},
		success : function(data) {
			console.log('updateUseForApplication success: ', data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log(textStatus);
			console.log(XMLHttpRequest);
			console.log(errorThrown);
		}
	});
};


var updateUseInProposalSelection = function ($this) {	
	var poId = $($this).val();
	var isChecked = $($this).is(':checked');
	
	$.ajax({
			type : "POST",
			url : updateIncludeInProposalURL,
			cache : false,
			dataType : "Json",
			data : {
				purchaseOptionId : poId,
				selectedValue: isChecked
			},
			success : function(data) {
				console.log('updateUseInProposalSelection success: ', data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				console.log(textStatus);
				console.log(XMLHttpRequest);
				console.log(errorThrown);
			}
		});

	
};


var calculatePayments = function () {
	
	var dataJsonString = createRateFactorRuleRequestObjectString();

	$.ajax({
			type : "POST",
			url : calculatePaymentsURL,
			cache : false,
			dataType : "Json",
			data : {
				selectedOptions : dataJsonString
			},
			success : function(data) {
				console.log('calculatePayments success: ', data);
				buildProposalOptionsTable(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				console.log(textStatus);
				console.log(XMLHttpRequest);
				console.log(errorThrown);
			}
		});

	return false;
};

var buildProposalOptionsTable = function (remoteData) {
	
	$('#proposalOptionsTable').empty();
	$('#proposalOptionsSection').hide();
	YUI().use(
		  'aui-datatable',
		  'aui-datatype',
		  'datatable-sort',
			  
		function(Y) {
			
			var currencyFormatter = function (o) {
			    return Y.DataType.Number.format(o.value, {
			        prefix            : o.column.currencySymbol     || '$',
			        decimalPlaces     : o.column.decimalPlaces      || 2,
			        decimalSeparator  : o.column.decimalSeparator   || '.',
			        thousandsSeparator: o.column.thousandsSeparator || ','
			    });
			}
				  
			var propFormatter =	function (o) {
			  	
			  	//need to add input elements for some fields
			  	if (o.column.name == 'useForCreditApp') {
			  		var radioBox = '<input type="radio" name="useForCreditApp"';
			  		radioBox += 'value="'+ o.data.propOption.proposalOptionId+ '"';
			  		
			  		if (o.data.propOption.useForCreditApp) {
			  			radioBox += 'checked ';
			  		}
			  		
			  		radioBox += ' onchange="updateUseForApplication($(this))"/>';
			  		
			  		return  radioBox;
			  	
			  	
			  	} else if (o.column.name == 'includeInProposal') {
			  		
			  		var inputBox = '<input type="checkbox" name="includeInProposal"';
			  		inputBox += ' value="'+ o.data.propOption.proposalOptionId + '"';
			  		
			  		if (o.data.propOption.includeInProposal) {
			  			inputBox += 'checked ';
			  		}
			  		
			  		inputBox += ' onchange="updateUseInProposalSelection($(this))"/>';
			  		
			  		return inputBox;
			  	} else {
			  		return o.data.propOption[o.column.name];
			  	}	
			}
				  
			var nestedCols = [
				{
	             	label: 'Option #',
	                key: 'proposalOptionId',
	                sortable: true,
	                className: 'purchaseOptionsColumn'
				},
                { 
                	key: 'productName',
                  	label: 'Product',
                  	className: 'purchaseOptionsColumn'
                },
                { 
                	key: 'prodOptionName',
                    label: 'Purchase Option',
                    className: 'purchaseOptionsColumn'
                },       
                { 
               		key: 'termName',
                    label: 'Term',
                    className: 'purchaseOptionsColumn'
                },
                { 
                    key: 'paymentAmount',
                    label:'Payment Amount',
                    sortable: true,
                    formatter: currencyFormatter,
                    className: 'purchaseOptionsColumn'
                 },
                {
                	key: 'propOption',
                    label: 'Include in Proposal',
                    formatter: propFormatter,
                    allowHTML: true,
                    name: 'includeInProposal',
                    className: 'purchaseOptionsColumn'
                 },
                 {      
                  	key: 'useForCreditApp',
                  	label: 'Use for Credit Application',
                  	formatter: propFormatter,
                  	allowHTML: true,
                  	name: 'useForCreditApp',
                  	 className: 'purchaseOptionsColumn'
				  }];
			    
			    
		    		var dataTable = new Y.DataTable({
		    	        columns: nestedCols,
		    	        data: remoteData
		    		}).render('#proposalOptionsTable');
		    		$('#proposalOptionsSection').show();
			    	$('*[data-persist-id="pricingOvervewResults"]').click();
			  }
	);	
};
</script>


<style>
.purchaseOptionsColumn {
	text-align: center !important;
}
</style>