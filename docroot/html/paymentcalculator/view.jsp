<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<portlet:resourceURL var="processProductsSelectionURL"
	id="processProductsSelection" />
	
<portlet:resourceURL var="processPurchaseOptionsSelectionURL"
	id="processPurchaseOptionsSelection" />


<portlet:resourceURL var="calculatePaymentsURL"
	id="calculatePayments" />

<liferay-ui:panel-container accordion="true" extended="false">
	<liferay-ui:panel title="Payment Calculator" id="paymentCalculator" persistState="false" state="open">
		<aui:form>
			<aui:col span="3" first="true">
				<aui:input id="equipmentPrice" name="equipmentPrice" size="7" style="width:150px"  label="Equipment Price" required="true"></aui:input>
			</aui:col>

			<aui:col span="3" id="product">
				<h4>Pricing Products</h4>
				<aui:fieldset column="true">

					<div id="productList">
						<c:forEach items="${productOptions}" var="product">
							<aui:input type="checkbox" name="productCheckbox"
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
				<aui:button value="Clear"></aui:button>
				<a class="btn btn-success" id="calculatePaymentsButton" onclick="calculatePayments()"> Calculate Payments </a>
			
			</aui:button-row>
		</aui:form>
	</liferay-ui:panel>

	<liferay-ui:panel title="Pricing Overview" state="collapsed" id="pricingOvervewResults">
    	<div id="proposalOptionsSection"></div>
 </liferay-ui:panel>

	<liferay-ui:panel title="Application" state="collapsed">
        Application goes here
 </liferay-ui:panel>
</liferay-ui:panel-container>


<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/paymentcalculator.js"></script> --%>

<script type="text/javascript">


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

var getPurchaseOptions = function () {
	
	var productBoxes = $('#productList input:checked');
	var prodList = []
	$.each(productBoxes, function (i, el) {
		prodList[i] = $(el).val();
	});
	
	var url = "<%=processProductsSelectionURL%>";
	var dataJsonString = createRateFactorRuleRequestObjectString();

	console.log('selectedProducts', dataJsonString);

	$.ajax({
				type : "POST",
				url : url,
				cache : false,
				dataType : "Json",
				data : {
					selectedOptions : dataJsonString
				},
				success : function(data) {
					console.log('getPurchaseOptions success: ', data);

					var poOptions = '';
					$('#purchaseOptionsList').empty();
					$('#termsList').empty();
					$('#termSection').hide();
					$('#purchaseOptionSection').hide();
					
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

};


var getTermsOptions = function () {

	var url = "<%=processPurchaseOptionsSelectionURL%>";	
	var dataJsonString = createRateFactorRuleRequestObjectString();

	console.log('selectedProducts', dataJsonString);

	$.ajax({
			type : "POST",
			url : url,
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


var calculatePayments = function () {
	console.log('calculating payments');
	
	var url = "<%=calculatePaymentsURL%>";	
	var dataJsonString = createRateFactorRuleRequestObjectString();

	console.log('selectedProducts', dataJsonString);

	$.ajax({
			type : "POST",
			url : url,
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

	
};

var buildProposalOptionsTable = function (remoteData) {
	
	$('#proposalOptionsSection').empty();
	
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
			  		return '<input type="radio" name="useForCreditApp" value="'+ o.data.propOption.proposalOptionId+ '"/>';
			  	} else if (o.column.name == 'includeInProposal') {
			  		return '<input type="checkbox" name="includeInProposal" value="'+ o.data.propOption.proposalOptionId+ '"/>';
			  	} else {
			  		return o.data.propOption[o.column.name];
			  	}	
			}
				  
			var nestedCols = [
				{
	             	label: 'Proposal Option',
	                key: 'proposalOptionId',
	                sortable: true,
				},
                { 
                	key: 'productName',
                  	label: 'Product Name',
                },
                { 
                	key: 'prodOptionName',
                    label: 'Purchase Option',
                },       
                { 
               		key: 'termName',
                    label: 'Term',
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
				  },
                  {
                     key: 'eqPrice',
                     label:'Equipment Price',
                     formatter: currencyFormatter,
                   },
                   { 
                       key: 'paymentAmount',
                       label:'Payment Amount',
                       sortable: true,
                       formatter: currencyFormatter,
                    }];
			    
			    
		    		var dataTable = new Y.DataTable({
		    	        columns: nestedCols,
		    	        data: remoteData
		    		}).render('#proposalOptionsSection');
			    
			    	$('*[data-persist-id="pricingOvervewResults"]').click();
			  }
	);
	
	
};


</script>


<style>
.purchaseOptionsColumn {
	text-align:center !important;
}
</style>