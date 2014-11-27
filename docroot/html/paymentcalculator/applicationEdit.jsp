<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>
<% 

	//keep track of panel state
	String customerInfoSectionState = ParamUtil.getString(request, "customerInfoSectionState", "collapsed");
	String customerContactInfoSectionState	= ParamUtil.getString(request, "customerContactInfoSectionState", "collapsed");
	String customerAddressInfoState = ParamUtil.getString(request, "customerAddressInfoState", "collapsed");
	String businessInfoSectionState = ParamUtil.getString(request, "businessInfoSectionState", "collapsed");
	String equipmentInfoSectionState = ParamUtil.getString(request, "equipmentInfoSectionState", "collapsed");
	 
	
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
		 	


<liferay-ui:panel title="Customer Info" id="customerInfo" state="<%=customerInfoSectionState %>" >
		         <aui:fieldset column="false" label="Customer Info">
					<aui:input inlineField="true" name="customerName" value="${creditApp.customerName}"></aui:input>
					<aui:input inlineField="true"  name="customerDBAName" label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
				</aui:fieldset>
				
				<aui:fieldset column="false" label="Customer Contact Info">
					<aui:input inlineField="true" name="customerContact" label="Customer Contact"></aui:input>
					<aui:input inlineField="true" name="contactPhone" label="Conatct Phone"></aui:input>
					<aui:input inlineField="true" name="contactFax" label="Conatct Fax"></aui:input>
				</aui:fieldset>
				
				<aui:fieldset column="false" label="Customer Address Info">
					<aui:input inlineField="true" name="customerAddress1"></aui:input>
					<aui:input inlineField="true" name="customerAddress2"></aui:input>
					<aui:input inlineField="true" name="customerCity"></aui:input>
					
					<aui:select inlineField="true" name="customerState" showEmptyOption="true">
						 
						 <% State[] customerState=StateUtil.STATES;
						   for (int i=0; i<customerState.length;i++){%>
						   	 <aui:option value="<%= customerState[i].getId()%>" label="<%= customerState[i].getName()%>">
						   	 
						   	 </aui:option>
						  <% } %>
					 </aui:select>
					 <aui:input inlineField="true" name="customerZip"></aui:input>
		
				</aui:fieldset>
				
				<aui:fieldset column="false" span="12">
					<aui:input inlineField="true" type="textarea" rows="3" name="customerBusinessDesc"></aui:input>
					
					<aui:select inlineField="true" name="customerBusinessType" showEmptyOption="true">
				        <c:forEach items="${corpTypeList}" var="corpType">
				            <aui:option value="${corpType}" label="${corpType}" selected="${creditApp.customerBusinessType == corpType}"/>
				        </c:forEach>
				    </aui:select>
					
					<aui:input inlineField="true" name="customerBusinessStartDate" value="${creditApp.customerBusinessStartDate}"></aui:input>
					
					
					
					<aui:select inlineField="true" name="customerBusinessIncorporatedState" showEmptyOption="true">
				        <c:forEach items="${statesList}" var="state">
				            <aui:option value="${state.id}" label="${state.name}" selected="${creditApp.customerBusinessIncorporatedState == state.id}"/>
				        </c:forEach>
				    </aui:select>
					
					<aui:input inlineField="true" type="text" value="${creditApp.customerBusinessFederalTaxID}" name="customerBusinessFederalTaxID" />
		
				</aui:fieldset>
				
		 	</liferay-ui:panel>
		 	
		 	
		 
		 	
		 	<liferay-ui:panel title="Equipment Info" id="equipmentInfo" state="<%=equipmentInfoSectionState %>" >
		 		<aui:fieldset  column="true">
					<label class="control-label">Equipment Price</label>
					<span>${creditApp.equipmentPrice}</span>
				</aui:fieldset>
		 	</liferay-ui:panel>
		 	
		 	
		 	
		 	<liferay-ui:panel title="Principal Information" id="principalInfo" state="<%=principalInfoSectionState %>" >
		 
					<aui:button-row>
						<aui:button name="enterPrincipalButton" id="enterPrincipalButton" 
					 		value="Add New Principal"> </aui:button>
					 	
					</aui:button-row>
				
					<liferay-ui:icon
					    image="tool"
					    message="Add Principal"
					    label="<%= true%>"
					    method="get"
					    url="<%= enterPrincipalURL%>"
					    useDialog="<%= true%>"
					    
				    />
		
		 			<c:import url="/html/paymentcalculator/principals/principalInformationTable.jsp"></c:import>
		 		
		 
		 	</liferay-ui:panel>
		 	
		 	<liferay-ui:panel title="Credit Application Bank Reference Information" id="equipmentInfo" state="<%=equipmentInfoSectionState %>" >
		 		<aui:fieldset column="true">
			
				</aui:fieldset>
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