<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
alert ('included');
=======
alert('hellp');
>>>>>>> master
=======


var navigateToCalculator = function () {
	$("*[data-persist-id='paymentCalculator']").click();
};

var navigateToBankReference = function () {
	$("*[data-persist-id='bankRefereceInfo']").click();
	$("*[data-persist-id='principalInfo']").click();
};

var navigateToPrincipal = function () {
	$("*[data-persist-id='bankRefereceInfo']").click();
	$("*[data-persist-id='principalInfo']").click();
	
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
>>>>>>> master
=======
>>>>>>> master
