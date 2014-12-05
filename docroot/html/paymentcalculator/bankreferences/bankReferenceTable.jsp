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
			
	String [] accountTypesList =  {"Checking", "Savings", "Line Of Credit", "Term Loan", "Lease"};
	renderRequest.setAttribute("accountTypesList", accountTypesList);
	
	List <CreditAppBankReference> bankRefs = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(creditApp.getCreditAppId());
	
	request.setAttribute("bankRefs",  JSONFactoryUtil.looseSerialize(bankRefs));
%>

<portlet:resourceURL var="createReferenceRecordURL"
	id="createReferenceRecord" />
	
<portlet:resourceURL var="deleteReferenceRecordURL"
	id="deleteReferenceRecord" />

<div id="enterReferenceSection">

<aui:container>
	<aui:form method="post" name="principalForm">
	
		<aui:fieldset column="false">
			<aui:input name="bankReferenceId" type="hidden"/>
			<aui:input inlineField="true" name="bankReferenceName"></aui:input>
			<aui:input inlineField="true" name="bankReferenceContact"></aui:input>
			<aui:input inlineField="true" name="bankReferencePhone"></aui:input>
			<aui:select inlineField="true"
				name="bankReferenceAccountType" showEmptyOption="true">
				<c:forEach items="${accountTypesList}" var="accType">
					<aui:option value="${accType}" label="${accType}"/>
				</c:forEach>
			</aui:select>
			
			<aui:input inlineField="true" name="bankReferenceAccountNumber"></aui:input>
		</aui:fieldset>
	</aui:form>
</aui:container>
</div>

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
<script type="text/javascript">

YUI().use(
		  'aui-datatable',
		  'aui-datatype',
		  'datatable-sort',
		  'panel',
		  'dd-plugin',
			  
		function(A) {
	
	var createReferenceRecordURL = '<%=createReferenceRecordURL%>';
	var deleteReferenceRecordURL = '<%=deleteReferenceRecordURL%>';
	
	
	var refTableData = ${bankRefs};
	
	
	//Create the datatable with some gadget information.
	
	var bankReferenceIdEl = $('#<portlet:namespace/>bankReferenceId'),
		bankReferenceNameEl  = $('#<portlet:namespace/>bankReferenceName'),
		bankReferenceContactEl = $('#<portlet:namespace/>bankReferenceContact'),
		bankReferencePhoneEl = $('#<portlet:namespace/>bankReferencePhone'),
		bankReferenceAccountTypeEl = $('#<portlet:namespace/>bankReferenceAccountType'),
		bankReferenceAccountNumberEl = $('#<portlet:namespace/>bankReferenceAccountNumber'),
	   
		
	    buttonFormatter = function (o) {
		  	//console.log(o);
		  	var viewOnly = ${viewOnly};
			var buttons = '<a class="btn" onclick="editRefAtIndex('+o.rowIndex+')">Edit</a> <a class="btn btn-danger" onclick="removeRefAtIndex('+o.rowIndex+')">Delete</a>';
		  	
			if (!viewOnly)
			return buttons;
		},
	    
	    cols = [
	            {key:'bankReferenceId',
	    		label:'Id',
	    		},
	            {
	    			key: 'bankReferenceName',
	    			label: 'Name'
	            },
	            {
	    			key: 'bankReferenceContact',
	    			label: 'Contact'
	            },
	            {
	    			key: 'bankReferencePhone',
	    			label: 'Phone'
	            },
	            {
	    			key: 'bankReferenceAccountType',
	    			label: 'Account Type',
	    			
	            },
	            {
	    			key: 'bankReferenceAccountNumber',
	    			label: 'Account Number'
	            },
	            {key: 'actions',
		    		formatter: buttonFormatter,
		    		allowHTML: true,
		    		label: 'Actions',
		    	}
	       
	            
	    ],
	
	    refTable, panel, nestedPanel;
	
 	// Create the DataTable.
    refTable = new A.DataTable({
        columns: cols,
        data   : refTableData,
        summary: 'Credit App Bank References',
        caption: '',
        render : '#bankReferenceDataTable',
    });

    // Create the main modal form.
    panel = new A.Panel({
        srcNode      : '#enterReferenceSection',
        headerContent: 'Add Bank Reference',
        //width        : 450,
        zIndex       : 5,
        centered     : true,
        //constrain	 : '#appTitle',
        modal        : true,
        visible      : false,
        render       : document.body,
        plugins      : [A.Plugin.Drag],
       
    });

    panel.addButton({
        value  : 'Save',
        section: A.WidgetStdMod.FOOTER,
        action : function (e) {
        	e.preventDefault();
            saveReference();
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
    if ( A.one('#addRefRow') != null) {
    	 A.one('#addRefRow').on('click', function (e) {
    	    	$('#enterReferenceSection').find('input').val('');
    			$('#enterReferenceSection').find('select').val('');
    			
    	        panel.show();
    	    });
    }
    
    


     var saveReference = function () {
		var inputData = {
			bankReferenceId: bankReferenceIdEl.val(),
			creditAppId: '${creditApp.creditAppId}',
			bankReferenceName: bankReferenceNameEl.val(),
			bankReferenceAccountType : bankReferenceAccountTypeEl.val(),
			bankReferenceAccountNumber : bankReferenceAccountNumberEl.val(),
			bankReferenceContact : bankReferenceContactEl.val(),
			bankReferencePhone :bankReferencePhoneEl.val(),
			
		};
		
		console.log (inputData);
		
		$.ajax({
				type : "POST",
				url : createReferenceRecordURL,
				cache : false,
				dataType : "Json",
				data : {
					reference: JSON.stringify(inputData)
				},
				success : function(data) {
					console.log('createReferenceRecordURL success: ', data);
					refTableData = data;
					refTable.data.reset();
					refTable.data.add(refTableData);
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
	
   
    
 	Liferay.provide(window, 'editRefAtIndex', function(index) {
 		var dataFromIndex = refTableData[index];
 		
 		console.log ('dataFromIndex', dataFromIndex);
 		bankReferenceIdEl.val(dataFromIndex.bankReferenceId);
 		bankReferenceNameEl.val(dataFromIndex.bankReferenceName);
 		bankReferenceContactEl.val(dataFromIndex.bankReferenceContact);
 		bankReferencePhoneEl.val(dataFromIndex.bankReferencePhone);
 		bankReferenceAccountTypeEl.val( dataFromIndex.bankReferenceAccountType);
 		bankReferenceAccountNumberEl.val(dataFromIndex.bankReferenceAccountNumber);
		
 		panel.show();
    });
 	
	Liferay.provide(window, 'removeRefAtIndex', function(index) {
		
		var ref = refTableData[index];
		ref.creditAppId = '${creditApp.creditAppId}';
		
		$.ajax({
				type : "POST",
				url : deleteReferenceRecordURL,
				cache : false,
				dataType : "Json",
				data : {
					reference: JSON.stringify(ref)
				},
				success : function(data) {
					console.log('removeRefAtIndex success: ', data);
					refTableData = data;
					refTable.data.reset();
					refTable.data.add(refTableData);
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