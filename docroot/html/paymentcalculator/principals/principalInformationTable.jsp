<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ include file="../init.jsp"%>


<%
	CreditApp creditApp = (CreditApp) request.getAttribute("creditApp");
	request.setAttribute("creditAppId", ParamUtil.getString(request, "creditAppId"));
	State[] statesList=StateUtil.STATES;
	renderRequest.setAttribute("statesList", statesList);
	
	List <CreditAppPrincipal> principals = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditApp.getCreditAppId());
	
	request.setAttribute("principals",  JSONFactoryUtil.looseSerialize(principals));
%>



<portlet:actionURL name="addCreditAppPrincipal" var="addCreditAppPrincipalURL">
	<portlet:param name="creditAppId" value="${creditAppId}" />
</portlet:actionURL>


<portlet:resourceURL var="createPrincipalRecordURL"
	id="createPrincipalRecord" />
	
<portlet:resourceURL var="deletePrincipalRecordURL"
	id="deletePrincipalRecord" />

<div id="enterPrincipalSection">

<aui:container>
	<aui:form action="<%=addCreditAppPrincipalURL %>" method="post" name="principalForm">
	
		<aui:fieldset column="false" label="Principal Name">
			<aui:input inlineField="true" name="principalId" type="hidden"/>
			<aui:input inlineField="true" name="principalFirstName"></aui:input>
			<aui:input inlineField="true" name="principalMiddleName"></aui:input>
			<aui:input inlineField="true" name="principalLastName"></aui:input>
			
		</aui:fieldset>
			
		<aui:fieldset column="false" label="Additional Info">
			
			<aui:input inlineField="true" name="principalSSN"></aui:input>
			<aui:input inlineField="true" name="principalHomePhoneNumber"></aui:input>
			<aui:input inlineField="true" name="principalEmail" type="email"></aui:input>
			
		</aui:fieldset>
			
		<aui:fieldset column="false" label="Address">
			<aui:input inlineField="true" name="principalAddress1"></aui:input>
			<aui:input inlineField="true" name="principalAddress2"></aui:input>
			<aui:input inlineField="true" name="principalCity"></aui:input>
			<aui:select inlineField="true" name="principalState"
				showEmptyOption="true">
				<c:forEach items="${statesList}" var="state">
					<aui:option value="${state.id}" label="${state.name}"
						selected="${principal.principalState == state.id}" />
				</c:forEach>
			</aui:select>
			<aui:input inlineField="true" name="principalZip"></aui:input>
			
		</aui:fieldset>
	</aui:form>
</aui:container>
</div>



<aui:button-row>
	<a class="btn  btn-info" id="addRow">Add Principal</a>
	<a class="btn" id="addRow" onclick="navigateToBankReference()"><i class="icon-meh"></i>
						Continue to Bank Reference</a>
						
	<a class="btn" id="addRow" onclick="navigateTocustomerAndEquipmentInfo()"><i class="icon-meh"></i>
						Back to Customer Info</a>

	
</aui:button-row>

<p/>

<div id="principalDataTable"></div>
<script type="text/javascript">
YUI().use(
		  'aui-datatable',
		  'aui-datatype',
		  'datatable-sort',
		  'panel',
		  'dd-plugin',
			  
		function(A) {
	
	var createPrincipalRecordURL = '<%=createPrincipalRecordURL%>';
	var deletePrincipalRecordURL = '<%=deletePrincipalRecordURL%>';
	
	
	var tableData = ${principals};
	
	
	//Create the datatable with some gadget information.
	
	var principalFirstNameEl = $('#<portlet:namespace/>principalFirstName'),
		principalLastNameEl  = $('#<portlet:namespace/>principalLastName'),
		principalMiddleNameEl = $('#<portlet:namespace/>principalMiddleName'),
	    principalSSNEl = $('#<portlet:namespace/>principalSSN'),
	    principalIdEl = $('#<portlet:namespace/>principalId'),
	    principalAddress1El = $('#<portlet:namespace/>principalAddress1'),
	    principalAddress2El = $('#<portlet:namespace/>principalAddress2'),
	    principalCityEl = $('#<portlet:namespace/>principalCity'),
	    principalStateEl = $('#<portlet:namespace/>principalState'),
	    principalZipEl = $('#<portlet:namespace/>principalZip'),
	    principalEmailEl = $('#<portlet:namespace/>principalEmail'),
	    principalHomePhoneNumberEl = $('#<portlet:namespace/>principalHomePhoneNumber'),
		
	    buttonFormatter = function (o) {
		  	//console.log(o);
			var buttons = '<a class="btn" onclick="editRowAtIndex('+o.rowIndex+')">Edit</a> <a class="btn btn-danger" onclick="removeRowAtIndex('+o.rowIndex+')">Delete</a>';
		  	return buttons;
		},
		
		addressFormatter = function (o) {
		  	console.log(o);
			var addressOut = '';
			addressOut += o.data.principalAddress1 + '<br/>';
			addressOut += o.data.principalAddress2 + '<br/>';
			addressOut += o.data.principalCity + ', ';
			addressOut += o.data.principalState + ' ';
			addressOut += o.data.principalZip + ' ';
			
		  	return addressOut;
		},
	    
	    cols = [{key:'principalId',
	    		label:'Id',
	    		},
	            {
	    			key: 'principalFirstName',
	    			label: 'First Name'
	            },
	            {
	    			key: 'principalMiddleName',
	    			label: 'Middle Name'
	            },
	            {
	    			key: 'principalLastName',
	    			label: 'Last Name'
	            },
	            {
	    			key: 'principalSSN',
	    			label: 'SSN',
	    		
	            },
	            {
	    			key: 'principalHomePhoneNumber',
	    			label: 'Home Phone'
	            },
	            
	       
	            
	            {key: 'address',
		    		formatter: addressFormatter,
		    		allowHTML: true,
		    		label: 'Address',
		    	},
		    	{
	    			key: 'principalEmail',
	    			label: 'Email'
	            },
	            {key: 'actions',
	    		formatter: buttonFormatter,
	    		allowHTML: true,
	    		label: 'Actions',
	    		 }],
	
	     panel, nestedPanel;
	
 // Create the DataTable.

 console.log (A.WidgetPositionAlign.TL);

    // Create the main modal form.
    panel = new A.Panel({
        srcNode      : '#enterPrincipalSection',
        headerContent: 'Add Principal',
        //width        : 450,
        zIndex       : 5,
        //centered     : true,
        //constrain	 : '#portlet_paymentcalculator_WAR_CreekRidgeCapitalportlet',
        modal        : true,
        visible      : false,
        render       : true,
        plugins      : [A.Plugin.Drag],
       	xy:	[50,100]
       
    });

    panel.addButton({
        value  : 'Save',
        section: A.WidgetStdMod.FOOTER,
        action : function (e) {
            e.preventDefault();
            savePrincipal();
        }
    });

    panel.addButton({
        value  : 'Cancel',
        section: A.WidgetStdMod.FOOTER,
        action : function (e) {
            e.preventDefault();
            panel.hide();
        }
    });

    // When the addRowBtn is pressed, show the modal form.
    A.one('#addRow').on('click', function (e) {
    	$('#enterPrincipalSection').find('input').val('');
		$('#enterPrincipalSection').find('select').val('');
		
        panel.show();
    });
   
    var dt = new A.DataTable({
        columns: cols,
        data   : tableData,
        summary: 'Credit App Principals',
        caption: '',
        render : '#principalDataTable',
        message: 'test'
    });


     var savePrincipal = function () {
		var inputData = {
			principalId: principalIdEl.val(),
			creditAppId: '${creditApp.creditAppId}',
			principalFirstName: principalFirstNameEl.val(),
		    principalLastName : principalLastNameEl.val(),
		    principalMiddleName : principalMiddleNameEl.val(),
		    principalSSN : principalSSNEl.val(),
		    principalHomePhoneNumber :principalHomePhoneNumberEl.val(),
		    principalAddress1 :principalAddress1El.val(),
		    principalAddress2 :principalAddress2El.val(),
		    principalCity :  principalCityEl.val(),
			principalState : principalStateEl.val(),
		    principalZip: principalZipEl.val(),
			principalEmail :  principalEmailEl.val(),
			
		};
		var principalData = JSON.stringify(inputData);
		
		$.ajax({
				type : "POST",
				url : createPrincipalRecordURL,
				cache : false,
				dataType : "Json",
				data : {
					principal: principalData
				},
				success : function(data) {
					console.log('createPrincipalRecordURL success: ', data);
					tableData = data;
					dt.data.reset();
					dt.data.add(tableData);
					panel.hide();
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					console.log(textStatus);
					console.log(XMLHttpRequest);
					console.log(errorThrown);
				}
			});
	};

    
 // Define the addItem function - this will be called when 'Add Item' is
    // pressed on the modal form.
    function addItem(data) {
		dt.data.add(data);
        panel.hide();
    }
	
   
    
 	Liferay.provide(window, 'editRowAtIndex', function(index) {
 		var dataFromIndex = tableData[index];
 		
 		console.log ('dataFromIndex', dataFromIndex);
 		principalFirstNameEl.val(dataFromIndex.principalFirstName);
 		principalLastNameEl.val(dataFromIndex.principalLastName);
 		principalMiddleNameEl.val(dataFromIndex.principalMiddleName);
		principalIdEl.val( dataFromIndex.principalId);
		principalSSNEl.val(dataFromIndex.principalSSN);
		principalHomePhoneNumberEl.val( dataFromIndex.principalHomePhoneNumber);
		principalAddress1El.val( dataFromIndex.principalAddress1);
		principalAddress2El.val(  dataFromIndex.principalAddress2);
		principalCityEl.val( dataFromIndex.principalCity);
		principalStateEl.val( dataFromIndex.principalState);
		principalZipEl.val(  dataFromIndex.principalZip);
		principalEmailEl.val(  dataFromIndex.principalEmail);
 		panel.show();
    });
 	
	Liferay.provide(window, 'removeRowAtIndex', function(index) {
		

		$.ajax({
				type : "POST",
				url : deletePrincipalRecordURL,
				cache : false,
				dataType : "Json",
				data : {
					principal:  JSON.stringify(tableData[index])
				},
				success : function(data) {
					console.log('removeRowAtIndex success: ', data);
					tableData = data;
					dt.data.reset();
					dt.data.add(tableData);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					console.log(textStatus);
					console.log(XMLHttpRequest);
					console.log(errorThrown);
				}
			});
    });
    
   }); 
</script>

