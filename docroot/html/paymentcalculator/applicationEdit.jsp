<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>
<% 

	//keep track of panel state
	String customerAndEquipmentInfoSectionState = ParamUtil.getString(request, "customerAndEquipmentInfoSectionState", "collapsed");
	String principalInfoSectionState = (String) request.getAttribute("principalInfoSectionState");
	
	if(principalInfoSectionState == null || principalInfoSectionState == "") 
		principalInfoSectionState = ParamUtil.getString(request, "principalInfoSectionState");
	
	System.out.println ("principalInfoSectionState " + principalInfoSectionState);
	
	State[] statesList=StateUtil.STATES;
	renderRequest.setAttribute("statesList", statesList);
	
	String [] corpTypeList =  {"Corporation", "Sole Prop", "LLC", "LLP", "Partnership", "S Corporation", "Government Entity"};
	renderRequest.setAttribute("corpTypeList", corpTypeList);
	
%>

<portlet:renderURL var="enterPrincipalURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">  
	<portlet:param name="mvcPath" value="/html/paymentcalculator/principals/enterPrincipal.jsp"/>
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}"/>
</portlet:renderURL>		 	
		 	


<liferay-ui:panel title="Customer and Equipment Info" id="customerAndEquipmentInfo" state="<%=customerAndEquipmentInfoSectionState %>" >
		        
		        <aui:fieldset column="false" label="Customer">
					<aui:input inlineField="true" name="customerName" value="${creditApp.customerName}"></aui:input>
					<aui:input inlineField="true"  name="customerDBAName" label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
				</aui:fieldset>
				
				<aui:fieldset column="false" label="Customer Contact">
					<aui:input inlineField="true" name="customerContact" value="${creditApp.customerContact}"></aui:input>
					<aui:input inlineField="true" name="customerContactEmail" type="email" value="${creditApp.customerContactEmail}"></aui:input>
					<aui:input inlineField="true" name="customerContactPhone" type="tel" value="${creditApp.customerContactPhone}"></aui:input>
					<aui:input inlineField="true" name="customerContactFax" value="${creditApp.customerContactFax}"></aui:input>
				</aui:fieldset>
				
				<aui:fieldset column="false" label="Customer Address">
					<aui:input inlineField="true" name="customerAddress1" value="${creditApp.customerAddress1}"></aui:input>
					<aui:input inlineField="true" name="customerAddress2" value="${creditApp.customerAddress2}"></aui:input>
					<aui:input inlineField="true" name="customerCity" value="${creditApp.customerCity}"></aui:input>
					
					<aui:select inlineField="true" name="customerState" showEmptyOption="true">
					  	<c:forEach items="${statesList}" var="state">
				            <aui:option value="${state.id}" label="${state.name}" selected="${creditApp.customerState == state.id}"/>
				        </c:forEach>
					 </aui:select>
					 <aui:input inlineField="true" name="customerZip" value="${creditApp.customerZip}"></aui:input>
		
				</aui:fieldset>
				
				<aui:fieldset column="false" span="12" label="Business Information">
					
					
					<aui:select inlineField="true" name="customerBusinessType" showEmptyOption="true">
				        <c:forEach items="${corpTypeList}" var="corpType">
				            <aui:option value="${corpType}" label="${corpType}" selected="${creditApp.customerBusinessType == corpType}"/>
				        </c:forEach>
				    </aui:select>
					<fmt:formatDate value="${creditApp.customerBusinessStartDate}" pattern="MM/dd/yyyy" var="busStartDate"/> 
					<aui:input id="customerBusinessStartDate" inlineField="true" name="customerBusinessStartDate" value="${busStartDate}" type="date"></aui:input>
					
					<aui:select inlineField="true" name="customerBusinessIncorporatedState" showEmptyOption="true">
				        <c:forEach items="${statesList}" var="state">
				            <aui:option value="${state.id}" label="${state.name}" selected="${creditApp.customerBusinessIncorporatedState == state.id}"/>
				        </c:forEach>
				    </aui:select>
					
					<aui:input inlineField="true" type="text" value="${creditApp.customerBusinessFederalTaxID}" name="customerBusinessFederalTaxID" />
		
				</aui:fieldset>
				
				<aui:fieldset>
					<aui:input type="textarea" rows="3" name="customerBusinessDesc"></aui:input>
				</aui:fieldset>
				
				<aui:fieldset  label="Equipment Info">
					<fmt:formatNumber value="${creditApp.equipmentPrice}" type="CURRENCY" var="eqPrice"/> 
				 	<label>Equipment Price</label>${eqPrice} <br/> <br/>
					<aui:input type="checkbox" name="equipmentLocAsCustomerFlag" value="${creditApp.equipmentLocAsCustomerFlag}" onchange="copyCustomerAddress($(this))"></aui:input>
					
				</aui:fieldset>
				
				<aui:fieldset>
					<aui:input inlineField="true" type="text" value="${creditApp.equipmentAddress1}" name="equipmentAddress1" />
					<aui:input inlineField="true" type="text" value="${creditApp.equipmentAddress2}" name="equipmentAddress2" />
					<aui:input inlineField="true" type="text" value="${creditApp.equipmentCity}" name="equipmentCity" />
					<aui:select inlineField="true" name="equipmentState" showEmptyOption="true">
				        <c:forEach items="${statesList}" var="state">
				            <aui:option value="${state.id}" label="${state.name}" selected="${creditApp.equipmentState == state.id}"/>
				        </c:forEach>
				    </aui:select>
				    <aui:input inlineField="true" type="text" value="${creditApp.equipmentZip}" name="equipmentZip" />
				</aui:fieldset>
				
				<aui:fieldset>
					<aui:input type="textarea" rows="3" name="equipmentDesc" value="${creditApp.equipmentDesc}"></aui:input>
				</aui:fieldset>
				
		 	</liferay-ui:panel>
		 	
		 	<liferay-ui:panel title="principal-info-section" id="principalInfo" state="<%=principalInfoSectionState %>" >
		 
					<aui:button-row>
						<aui:button name="enterPrincipalButton" id="enterPrincipalButton" 
					 		value="Add New Principal"> </aui:button>
					 	
					</aui:button-row>
				
					<%-- <liferay-ui:icon
					    image="tool"
					    message="Add Principal"
					    label="<%= true%>"
					    method="get"
					    url="<%= enterPrincipalURL%>"
					    useDialog="<%= true%>"
					    
				    /> --%>
		
		 			<c:import url="/html/paymentcalculator/principals/principalInformationTable.jsp"></c:import>
		 		
		 
		 	</liferay-ui:panel>
		 	
		<aui:script>
			AUI().use('aui-base',
				'aui-dialog-iframe',
				 
				function(A) {
				A.one('#<portlet:namespace />enterPrincipalButton').on('click', function(event){ 
					var popUpWindow=Liferay.Util.Window.getWindow({
											dialog: {
												centered: true,
												constrain2view: true,
												//cssClass: 'yourCSSclassName',
												modal: true,
												resizable: false,
												width: 600,
												
												
											},
											id: 'addPrincipalDialog',
											title: 'Enter Principal', 
											uri: '<%=enterPrincipalURL%>',
										}
									).render();
					popUpWindow.show();
				});
			});
		</aui:script>
		
		
		<aui:script>
		AUI().use('aui-datepicker',
			function(A) {
				new A.DatePicker({
			        trigger: '#<portlet:namespace/>customerBusinessStartDate',
			        calendar: {
			            selectionMode: 'multiple',
			            showPrevMonth: true,
			            showNextMonth: true,
			            yearRange: [ 1970, 2009 ],
		          	},
		          	year:true,
			        popover: {
			          zIndex: 1
			        },
			        on: {
			          selectionChange: function(event) {
			            console.log(event.newSelection)
			          }
			        }
			      }
			    );
			  });
	</aui:script>
	
	
	<script>
	
	var copyCustomerAddress = function (sameAddressEl) {
		
		if ($(sameAddressEl).is(':checked')) {
			$('#<portlet:namespace/>equipmentAddress1').val($('#<portlet:namespace/>customerAddress1').val());
			$('#<portlet:namespace/>equipmentAddress2').val($('#<portlet:namespace/>customerAddress2').val());
			$('#<portlet:namespace/>equipmentCity').val($('#<portlet:namespace/>customerCity').val());
			$('#<portlet:namespace/>equipmentState').val($('#<portlet:namespace/>customerState').val());
			$('#<portlet:namespace/>equipmentZip').val($('#<portlet:namespace/>customerZip').val());
		}
		
	};
	</script>