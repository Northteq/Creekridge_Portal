<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ include file="init.jsp"%>

<%
	HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

<<<<<<< HEAD
String openSection = ParamUtil.getString(request, "openSection", "paymentCalculator");
request.setAttribute("openSection", openSection);

HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
long appId = ParamUtil.getLong(request, "creditAppId");

if (appId != 0) {
	request.setAttribute("creditApp", CreditAppLocalServiceUtil.getCreditApp(appId));
}

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
Boolean viewMode = ParamUtil.getBoolean(request, "viewMode");
request.setAttribute("viewMode", viewMode);
>>>>>>> master

%>

<script src="<%= renderRequest.getContextPath()%>/js/paymentcalculator.js" type="text/javascript"></script>

>>>>>>> master
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
  
  console.log (formEl, action);
  
  
  $(formEl).submit();
 
}
</script>

<portlet:renderURL portletMode="view" var="viewAppURL">
	<portlet:param name="viewMode" value="<%= String.valueOf(true)%>" />
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}"/>
</portlet:renderURL>



<c:if test="${creditApp.creditAppStatusId != 3 && viewMode==false}">

<<<<<<< HEAD
<<<<<<< HEAD
<aui:form action="<%=saveApplicationInfoURL.toString() %>" method="post" >
	<aui:input type="hidden" value="${creditAppId}" name="creditAppId"/>
	 <c:import url="/html/paymentcalculator/buttons.jsp"></c:import>
	
	
=======
<aui:form action="<%=saveApplicationInfoURL.toString() %>" method="post">
	<aui:input type="hidden" name="creditAppId" value="${creditApp.creditAppId}"/>
=======
	<c:if test="${creditApp.creditAppId != 0}">
		<liferay-ui:icon
		   image="tool"
		   message="Preview Credit App"
		   label="<%= true%>"
		   method="get"
		   url="<%= viewAppURL%>"
		   useDialog="<%= false%>"
		   
		  />
	</c:if>

<aui:form action="<%=saveApplicationInfoURL.toString() %>" method="post" name="applicationForm">
>>>>>>> master
	<c:if test="${creditApp.creditAppId != 0}">
		<h3>Application ${creditApp.creditAppId} </h3> 
 	</c:if>
	
	<c:if test="${creditApp.creditAppId == 0}">
		<h3>New Application</h3> 
 	</c:if>
 	
 	
 	 <c:import url="/html/paymentcalculator/buttons.jsp"></c:import>
>>>>>>> master

	<liferay-ui:panel-container accordion="true" extended="false">
		<liferay-ui:panel title="Payment Calculator" id="paymentCalculator" state="${openSection=='paymentCalculator'? 'open' : 'collapsed' }">
				
				<aui:col span="3" first="true">	
				 	<aui:input id="equipmentPrice" type="number" step="any" name="equipmentPrice" size="7" style="width:150px" required="true" value="${creditApp.equipmentPrice}"></aui:input>
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
=======
	String viewOnlyString = httpReq.getParameter("viewOnly");
			ParamUtil.getString(request, "viewOnly");
	Boolean viewOnly; 
	if (viewOnlyString != null) {
		
	} else {
		viewOnlyString = httpReq.getParameter("viewOnly");
	} 
>>>>>>> master
	
	viewOnly = Boolean.valueOf (viewOnlyString);
	request.setAttribute("viewOnly", viewOnly);	
	
	String openSection = ParamUtil.getString(request, "openSection", "paymentCalculator");
	request.setAttribute("openSection", openSection);
	
	
	long appId = ParamUtil.getLong(request, "creditAppId");
	
<<<<<<< HEAD
		<liferay-ui:panel title="Pricing Overview" id="pricingOvervewResults" state="${openSection=='pricingOverview'? 'open' : 'collapsed' }">
	    	<div id="proposalOptionsSection" style="display:none">
	    			
	    		<div id="proposalOptionsTable"></div>
	   		
	    		<aui:button-row>
	    			<!-- <button type="submit" class="btn btn-info" id="createApplicationButton"> Create Application </button> -->
	    			<a class="btn btn-success" id="navigateToCalculator" onclick="navigateToCalculator()">Back to Calculator</a>
	    		</aui:button-row>
	    	</div>
	 	</liferay-ui:panel>
	 	
	 	<!-- APPLICATION PANEL  -->
		<c:if test="${creditApp.creditAppId != null}">
			<c:import url="/html/paymentcalculator/applicationEdit.jsp"></c:import>
	 	</c:if>
	 	
	</liferay-ui:panel-container>
<<<<<<< HEAD
<<<<<<< HEAD
	 <c:import url="/html/paymentcalculator/buttons.jsp"></c:import>
</aui:form>


<script type="text/javascript">

=======
	
	
	
=======
>>>>>>> master
</aui:form>

<script type="text/javascript">

var processProductsSelectionURL = "<%=processProductsSelectionURL%>";
var processPurchaseOptionsSelectionURL = "<%=processPurchaseOptionsSelectionURL%>";
var updateUseForApplicationURL = "<%=updateUseForApplicationURL%>";
var updateIncludeInProposalURL = "<%=updateIncludeInProposalURL%>";
var calculatePaymentsURL = "<%=calculatePaymentsURL%>";

<<<<<<< HEAD

>>>>>>> master
var navigateToCalculator = function () {
	$("*[data-persist-id='paymentCalculator']").click();
};

$(document).ready(function () {
<<<<<<< HEAD
	
=======
>>>>>>> master
	var proposals = jQuery.parseJSON('${proposalList}');
	
	console.log ("proposals on load", proposals);
	
	if (proposals != '') {
<<<<<<< HEAD
		
		buildProposalOptionsTable(proposals);
	}
=======
		buildProposalOptionsTable(proposals);
	}
	
	$(".alert-error:contains('Your request failed to complete.')").hide();
	
>>>>>>> master
		
});


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
<<<<<<< HEAD
		var url = "<%=processProductsSelectionURL%>";
=======
		
>>>>>>> master
		var dataJsonString = createRateFactorRuleRequestObjectString();

		console.log('selectedProducts', dataJsonString);

		$.ajax({
					type : "POST",
<<<<<<< HEAD
					url : url,
=======
					url : processProductsSelectionURL,
>>>>>>> master
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

<<<<<<< HEAD
	var url = "<%=processPurchaseOptionsSelectionURL%>";	
=======
	
>>>>>>> master
	var dataJsonString = createRateFactorRuleRequestObjectString();

	console.log('selectedProducts', dataJsonString);

	$.ajax({
			type : "POST",
<<<<<<< HEAD
			url : url,
=======
			url : processPurchaseOptionsSelectionURL,
>>>>>>> master
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
	
	
	var poId = $($this).val();
<<<<<<< HEAD
	var url = '<%=updateUseForApplicationURL%>';
	$.ajax({
		type : "POST",
		url : url,
=======
	$.ajax({
		type : "POST",
		url : updateUseForApplicationURL,
>>>>>>> master
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


<<<<<<< HEAD
var updateUseInProposalSelection = function ($this) {
	console.log('updateSelectedForProposal');
	
	var url = "<%=updateIncludeInProposalURL%>";	
=======
var updateUseInProposalSelection = function ($this) {	
>>>>>>> master
	var poId = $($this).val();
	var isChecked = $($this).is(':checked');
	
	$.ajax({
			type : "POST",
<<<<<<< HEAD
			url : url,
=======
			url : updateIncludeInProposalURL,
>>>>>>> master
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
<<<<<<< HEAD
	console.log('calculating payments');
	
	var url = "<%=calculatePaymentsURL%>";	
	var dataJsonString = createRateFactorRuleRequestObjectString();

	console.log('selectedProducts', dataJsonString);

	$.ajax({
			type : "POST",
			url : url,
=======
	
	var dataJsonString = createRateFactorRuleRequestObjectString();

	$.ajax({
			type : "POST",
			url : calculatePaymentsURL,
>>>>>>> master
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
			  	console.log ('propFormatter', o);
			  	
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
<<<<<<< HEAD
				  },
                 /*  {
                     key: 'eqPrice',
                     label:'Equipment Price',
                     formatter: currencyFormatter,
                     className: 'purchaseOptionsColumn'
                   }, */
                   ];
=======
				  }];
>>>>>>> master
			    
			    
		    		var dataTable = new Y.DataTable({
		    	        columns: nestedCols,
		    	        data: remoteData
		    		}).render('#proposalOptionsTable');
		    		$('#proposalOptionsSection').show();
			    	$('*[data-persist-id="pricingOvervewResults"]').click();
			  }
<<<<<<< HEAD
	);
	
	
=======
	);	
>>>>>>> master
};
=======
$(document).ready(function () {
	
	var proposals;
	var proposalsString = '${proposalList}';
	try {
		if (proposalsString != "") {
			proposals = jQuery.parseJSON('${proposalList}');
			buildProposalOptionsTable(proposals);
		}
		
	} catch (e) {
		console.log ('error getting proposals ', e);
	}

	$(".alert-error:contains('Your request failed to complete.')").hide();
});
>>>>>>> master
=======
	if (appId != 0) {
		request.setAttribute("creditApp", CreditAppLocalServiceUtil.getCreditApp(appId)); 
	}

	State[] statesList=StateUtil.STATES;
	renderRequest.setAttribute("statesList", statesList);
	
	String [] corpTypeList =  {"Corporation", "Sole Prop", "LLC", "LLP", "Partnership", "S Corporation", "Government Entity"};
	renderRequest.setAttribute("corpTypeList", corpTypeList);
	
%>
>>>>>>> master

<script src="<%= renderRequest.getContextPath()%>/js/jquery211.min.js" type="text/javascript"></script>

<link href="http://cdn.alloyui.com/2.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>
<c:import url="/html/paymentcalculator/paymentCalculatorJS.jsp"></c:import>

<c:if test="${creditApp.creditAppStatusId != 3 && viewOnly==false}">
	<c:import url="/html/paymentcalculator/applicationEdit.jsp"></c:import>
	<c:import url="/html/paymentcalculator/termsAndAgreement.jsp"></c:import>
</c:if>

<!-- VIEW MODE -->
<liferay-ui:success key="appSubmitted"
	message="app-submitted-successfully" />

<c:if test="${creditApp.creditAppStatusId == 3 || viewOnly}">
	<c:import url="/html/paymentcalculator/applicationView.jsp"></c:import>
	
</c:if>

