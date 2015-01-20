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
	
<portlet:resourceURL var="getProductsForEqPriceURL"
	id="getProductsForEqPrice" />

<portlet:resourceURL var="calculatePaymentsURL" id="calculatePayments" />

<portlet:resourceURL var="updateUseForApplicationURL"
	id="updateUseForApplication" />

<portlet:resourceURL var="updateIncludeInProposalURL"
	id="updateIncludeInProposal" />



<portlet:actionURL name="saveApplicationInfo"
	var="saveApplicationInfoURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>

<portlet:actionURL name="saveAndExitApplication"
	var="saveAndExitApplicationURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>

<portlet:actionURL name="submitApplication" var="submitApplicationURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>

<portlet:actionURL name="manageDocs" var="manageDocsURL">
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:actionURL>

<script type="text/javascript">

var processProductsSelectionURL = "<%=processProductsSelectionURL%>";
var processPurchaseOptionsSelectionURL = "<%=processPurchaseOptionsSelectionURL%>";
var updateUseForApplicationURL = "<%=updateUseForApplicationURL%>";
var updateIncludeInProposalURL = "<%=updateIncludeInProposalURL%>";
var calculatePaymentsURL = "<%=calculatePaymentsURL%>";
var getProductsForEqPriceURL = "<%=getProductsForEqPriceURL%>";

var appFormId = '<portlet:namespace/>applicationForm';
var validator;

var addCustomError = function (message) {
	
	errMessage = '<ul><li><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span><span class="sr-only"></span>';
	errMessage += message;
	errMessage += '</li></ul>';
	
	$('#validationErrors').append(errMessage);
	$('#validationErrors').show();
};

var outputErrors = function (errors, errorSection) {
	var htmlError = '<ul>';
	
	for (i in errors) {
		var elId = errors[i];
		var fieldLabel = $('#'+elId).parent().find('label').text().replace('*', '');
		var fieldError = $('#'+elId).parent().find('.form-validator-stack').text();
		var fieldErrorSectionLabel = $('#'+elId).closest('fieldset').find('legend').find('span').text();
		//console.log($('#'+elId));
		htmlError +=  '<li><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span><span class="sr-only"></span>';
	 	htmlError += fieldErrorSectionLabel + ' ' + fieldLabel + ': ' + fieldError;
	 	htmlError += '</li>';
	}
	
	htmlError += '<ul/>';
	
	errorSection.append(htmlError);
};

var validateForm = function () {
	validator = Liferay.Form.get(appFormId).formValidator;
	$('#validationErrors').empty();
	validator.validate();
	if (validator.hasErrors()) {
		outputErrors (Object.keys(validator.errors), $('#validationErrors'));
		$('#validationErrors').show();
	} else {
		$('#validationErrors').hide();
	}
};

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
	
	var formEl = $('#'+appFormId);
	var postUrl = '';
	var redirectUrl = '';
	
	//move continue to customer info out of validation 
	if(action==-1){
		formEl.attr('action',"<%=saveApplicationInfoURL%>");
		$(formEl).submit();
		
  	} else { //validate form
  		validateForm();
  		if (!validator.hasErrors()) {
  			
  			if(action==0){
  				formEl.attr('action',"<%=saveApplicationInfoURL%>");
  				$(formEl).submit();
  				
  		  	} else if (action==1){
  		  		
  		  		console.log ('save and exit');
  		  		
  		  		$.ajax({
  		  	           type: "POST",
  		  	           url: '<%=saveAndExitApplicationURL%>',
  		  	           data: $(formEl).serialize(), // serializes the form's elements.
  		  	           success: function(data, request){
  		  	        	 console.log ('save and exit post success');
  		  	        	 window.location.href = 'view-applications';
  		  	           }
  	  	         });
  		  		
  		  		
  			} else if (action == 3) {
  				console.log ('manage docs');
  				$.ajax({
  		  	           type: "POST",
  		  	           url: '<%=manageDocsURL%>',
  		  	           data: $(formEl).serialize(), // serializes the form's elements.
  		  	           success: function(data){
  		  	        	 console.log ('manage docs post success');
  		  	        	 window.location.href = 'manage-documents?creditAppId=${creditApp.creditAppId}';
  		  	           }
  		         });
  			} else{
  				formEl.attr('action',"<%=submitApplicationURL%>");
  				$(formEl).submit();
  		  	}

  		} 
  	}
}

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
		
		$('#equipmentAddressSection').show();
	} else {
		$('#equipmentAddressSection').hide();
	}
};

	$(document).ready(function() {
		
		$('.label-required').text('*');
		
		//mask phones
		try{
			$(".phone").mask("(999) 999-9999");
			$(".ssnField").mask("999-99-9999");
			
		} catch (ex) {
			console.log (ex);
		}
	
		//mask date
		//$(".date").mask("99/99/9999",{placeholder:"mm/dd/yyyy"});
		
		try {
			getProductOptions(true);
			
		} catch (e) {
			console.log('error getting proposals ', e);
		}

		$(".alert-error:contains('Your request failed to complete.')").hide();
		checkSelectedOptions();
	});
	
	var populateProposalOptions = function () {
		var proposals;
		var proposalsString = '${proposalList}';
		
		if (proposalsString != "") {
			
			proposals = jQuery.parseJSON('${proposalList}');
			buildProposalOptionsTable(proposals);
			
			var poOptions = '';
			var poNameMap = {};
			var termNameMap = {};
			var termOptions = '';
			console.log(proposals);
			for (var i = 0; i < proposals.length; i++){
				var po = proposals[i];
				
				$.each ($('#productList').find('input'), function (index, el){
					if ($(el).val() == po.propOption.productId) {
						$(el).prop('checked', true);
					}
						
				});
				
				var poNameId = po.propOption.purchaseOptionId;
				
				if (poNameMap[poNameId] == undefined) {
					poNameMap[poNameId] = po.prodOptionName;
					
					poOptions += '<label class="checkbox">'
					poOptions += '<input type="checkbox" name="'
							+ po.prodOptionName + '" value="'
							+ po.propOption.purchaseOptionId
							+ '"  onchange="getTermsOptions()" checked="checked">'
							+ po.prodOptionName + '</input>';
					poOptions += '</label>';
				}
				
				var termNameId = po.propOption.termId;
				if (termNameMap[termNameId] == undefined) {
					termNameMap[termNameId] = po.termName;
					termOptions += '<label class="checkbox">'
					termOptions += '<input type="checkbox" checked="checked" name="'+ po.termName + '" value="'+ po.propOption.termId+'">'
							+ po.termName + '</input>';
					termOptions += '</label>';
				}
				
			} //end for po

			$('#purchaseOptionsList').append(poOptions);
			$('#purchaseOptionSection').show();
			
			$('#termsList').append(termOptions);
			$('#termSection').show();
			
			//need to disable claculate button
			$('#calculatePaymentsButton').attr("disabled", "disabled");
			
		}
	};

	var navigateToCalculator = function() {
		$("*[data-persist-id='paymentCalculator']").click();
	};

	var navigateToBankReference = function() {
		$("*[data-persist-id='bankRefereceInfo']").click();
	};

	var navigateToPrincipal = function() {
		$("*[data-persist-id='principalInfo']").click();
	};

	var navigateTocustomerAndEquipmentInfo = function() {
		$("*[data-persist-id='customerAndEquipmentInfo']").click();
	};

	var navigateToPricingOverview = function() {
		$("*[data-persist-id='pricingOvervewResults']").click();
	};

	var createRateFactorRuleRequestObjectString = function() {

		

		//get products
		var productBoxes = $('#productList input:checked');
		var prodList = []

		$.each(productBoxes, function(i, el) {
			prodList[i] = $(el).val();
		});

		//get purchase options
		var poBoxes = $('#purchaseOptionsList input:checked');
		var poList = [];

		$.each(poBoxes, function(i, el) {
			poList[i] = $(el).val();
		});

		//get terms
		var termBoxes = $('#termsList input:checked');
		var termList = [];

		$.each(termBoxes, function(i, el) {
			termList[i] = $(el).val();
		});

		var selectedOptions = {
			equipmentPrice : getEquipmentPrice(),
			products : prodList,
			purchaseOptions : poList,
			termOptions : termList,
			creditAppId: '${creditApp.creditAppId}'
		};

		$.each(productBoxes, function(i, el) {
			prodList[i] = $(el).val();
		});

		return JSON.stringify(selectedOptions);
	};

	var resetAllSections = function() {
		$('#purchaseOptionsList').empty();
		$('#termsList').empty();
		$('#termSection').hide();
		$('#purchaseOptionSection').hide();
		checkSelectedOptions();
	};
	
	var getEquipmentPrice = function () {
		var price = $('#<portlet:namespace/>equipmentPrice').val();
		price = price.replace(/[$,]+/g, "");
		
		console.log(price);
		return price;
	}
	
	var getProductOptions = function(onload) {
		$('#productList').empty();
		$('#productList').hide();
		
		$.ajax({
			type : "POST",
			url : getProductsForEqPriceURL,
			cache : false,
			dataType : "Json",
			data : {
				eqPrice : getEquipmentPrice()
			},
			success : function(data) {
				console.log('getProductOptions success: ', data);

				var prodOptions = '';
				$('#productList').empty();
				
				$.each(
					data,
					function(i, el) {
						prodOptions += '<label class="checkbox">';
						prodOptions += '<input type="checkbox" onchange="getPurchaseOptions();" name="'+ el.productName + '" value="'+ el.productId +'">' + el.productName + '</input>';
						prodOptions += '</label>';
					});

				$('#productList').append(prodOptions);
				$('#productList').show();
				
				if (onload) {
					populateProposalOptions(); //this populates the list of PO on load.
				} else {
					resetAllSections();
				}
					
					
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				console.log(textStatus);
				console.log(XMLHttpRequest);
				console.log(errorThrown);
			}
		});
	};


	var getPurchaseOptions = function() {
		
		$('#purchaseOptionsList').empty();
		$('#termsList').empty();
		var productBoxes = $('#productList input:checked');
		var prodList = []
		$.each(productBoxes, function(i, el) {
			prodList[i] = $(el).val();
		});

		if (prodList.length > 0) {

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

					$.each(data, function(i, el) {
						poOptions += '<label class="checkbox">';
						poOptions += '<input type="checkbox" name="' + el.purchaseOptionName + '" value="' 
								+ el.purchaseOptionId + '"  onchange="getTermsOptions()">'
								+ el.purchaseOptionName + '</input>';
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

	var getTermsOptions = function() {
		
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
				checkSelectedOptions();
				$.each(
					data,
					function(i, el) {
						termOptions += '<label class="checkbox">';
						termOptions += '<input type="checkbox" onchange="checkSelectedOptions();" name="'+ el.termName + '" value="'+ el.termId+'">' + el.termName + '</input>';
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

	var updateUseForApplication = function($this) {

		//autoselect the uinclude in proposal

		updateUseInProposalSelection($($this).parent().prev().children().prop('checked', true));
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

	var updateUseInProposalSelection = function($this) {
		var poId = $($this).val();
		var isChecked = $($this).is(':checked');

		$.ajax({
			type : "POST",
			url : updateIncludeInProposalURL,
			cache : false,
			dataType : "Json",
			data : {
				purchaseOptionId : poId,
				selectedValue : isChecked
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
	
		//remove validation 
		//https://github.com/TamarackConsulting/Creekridge_Portal/issues/158
		//validateForm();
		
		//if (!validator.hasErrors()) {
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
		//} else {
		//	console.log ('Errors: ', validator.errors);
		//}
	};

	var buildProposalOptionsTable = function(remoteData) {

		$('#proposalOptionsTable').empty();
		$('#proposalOptionsSection').hide();
		YUI().use(
			'aui-datatable',
			'aui-datatype',
			'datatable-sort',

			function(Y) {

				var currencyFormatter = function(o) {
					
					if (o.value > 0) {
						return Y.DataType.Number
						.format(
								o.value,
								{
									prefix : o.column.currencySymbol
											|| '$',
									decimalPlaces : o.column.decimalPlaces || 2,
									decimalSeparator : o.column.decimalSeparator
											|| '.',
									thousandsSeparator : o.column.thousandsSeparator
											|| ','
								});
					}
					
					
					else return '${customPaymentAmountMessage}';
				}

				var propFormatter = function(o) {

					//need to add input elements for some fields
					if (o.column.name == 'useForCreditApp') {
						
						var disabledBox = '${viewOnly==true ? "disabled=\"disabled\"" : ""}';
						var radioBox = '<input type="radio" name="useForCreditApp"';
						radioBox += disabledBox;
						radioBox += 'value="'
								+ o.data.propOption.proposalOptionId
								+ '"';

						if (o.data.propOption.useForCreditApp) {
							radioBox += 'checked ';
						}

						radioBox += ' onchange="updateUseForApplication($(this))"/>';

						if (o.data.propOption.paymentAmount == -1)
							return '';
						
						else return radioBox;

					} else if (o.column.name == 'includeInProposal') {
						var disabledBox = '${viewOnly==true ? "disabled=\"disabled\"" : ""}';
						var inputBox = '<input type="checkbox" name="includeInProposal"';
						inputBox += disabledBox;
						inputBox += ' value="'
								+ o.data.propOption.proposalOptionId
								+ '"';

						if (o.data.propOption.includeInProposal) {
							inputBox += 'checked ';
						}

						inputBox += ' onchange="updateUseInProposalSelection($(this))"/>';
						
						if (o.data.propOption.paymentAmount == -1)
							return '';
						
						else return inputBox;
						
					} else {
						return o.data.propOption[o.column.name];
					}
				}

				var nestedCols = [ {
					label : 'Option #',
					key : 'proposalOptionId',
					sortable : true,
					className : 'purchaseOptionsColumn'
				}, {
					key : 'productName',
					label : 'Product',
					className : 'purchaseOptionsColumn'
				}, {
					key : 'prodOptionName',
					label : 'Purchase Option',
					className : 'purchaseOptionsColumn'
				}, {
					key : 'termName',
					label : 'Term',
					className : 'purchaseOptionsColumn'
				}, {
					key : 'paymentAmount',
					label : 'Payment Amount',
					sortable : true,
					formatter : currencyFormatter,
					allowHTML : true,
					className : 'purchaseOptionsColumn'
				}, {
					key : 'propOption',
					label : 'Include in Proposal',
					formatter : propFormatter,
					allowHTML : true,
					name : 'includeInProposal',
					className : 'purchaseOptionsColumn'
				}, {
					key : 'useForCreditApp',
					label : 'Use for Application',
					formatter : propFormatter,
					allowHTML : true,
					name : 'useForCreditApp',
					className : 'purchaseOptionsColumn'
				} ];

				var dataTable = new Y.DataTable({
					columns : nestedCols,
					data : remoteData
				}).render('#proposalOptionsTable');
				$('#proposalOptionsSection').show();
				$('*[data-persist-id="pricingOvervewResults"]')
						.click();
			});
	};
	
	var checkSelectedOptions = function () {
		if ($("#productList input:checked").length > 0 && $("#purchaseOptionsList input:checked").length > 0 && $("#termsList input:checked").length > 0) {
			$('#calculatePaymentsButton').removeAttr('disabled');
			return true;
		} else {
			$('#calculatePaymentsButton').attr('disabled','disabled');
			return false;
		}
		
	};
	
	
</script>
