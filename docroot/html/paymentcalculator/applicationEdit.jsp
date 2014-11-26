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
	
	State[] statesList=StateUtil.STATES;
	renderRequest.setAttribute("statesList", statesList);
	
	String [] corpTypeList =  {"Corporation", "Sole Prop", "LLC", "LLP", "Partnership", "S Corporation", "Government Entity"};
	renderRequest.setAttribute("corpTypeList", corpTypeList);
	
%>


<liferay-ui:panel title="Customer Info" id="customerInfo" state="<%=customerInfoSectionState %>" >
		         <aui:fieldset label="Customer Info" column="false">
					<aui:input name="customerName" value="${creditApp.customerName}"></aui:input>
					<aui:input name="customerDBAName" label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
				</aui:fieldset>
		 	</liferay-ui:panel>
		 	
		 	<liferay-ui:panel title="Customer Contact Info" id="customerContactInfo" state="<%=customerContactInfoSectionState %>" >
	          	<aui:fieldset column="true">
					<aui:input name="customerContact" label="Customer Contact"></aui:input>
					<aui:input name="contactPhone" label="Conatct Phone"></aui:input>
					<aui:input name="contactFax" label="Conatct Fax"></aui:input>
				</aui:fieldset>
		 	</liferay-ui:panel>
		 	
		 	<liferay-ui:panel title="Customer Address Info" id="customerAddressInfo" state="<%=customerAddressInfoState %>" >
		         <aui:fieldset column="true">
					<aui:input name="customerAddress1"></aui:input>
					<aui:input name="customerAddress2"></aui:input>
					<aui:input name="customerCity"></aui:input>
					
					<aui:select name="customerState" showEmptyOption="true">
						 
						 <% State[] customerState=StateUtil.STATES;
						   for (int i=0; i<customerState.length;i++){%>
						   	 <aui:option value="<%= customerState[i].getId()%>" label="<%= customerState[i].getName()%>">
						   	 
						   	 </aui:option>
						  <% } %>
					 </aui:select>
					 <aui:input name="customerZip"></aui:input>
		
				</aui:fieldset>
		 	</liferay-ui:panel>
		 	
		 	<liferay-ui:panel title="Business Info" id="businessInfo" state="<%=businessInfoSectionState %>" >
		         <aui:fieldset column="false">
					<aui:input type="textarea" rows="3" name="customerBusinessDesc"></aui:input>
					
					<aui:select name="customerBusinessType" showEmptyOption="true">
				        <c:forEach items="${corpTypeList}" var="corpType">
				            <aui:option value="${corpType}" label="${corpType}" selected="${creditApp.customerBusinessType == corpType}"/>
				        </c:forEach>
				    </aui:select>
					
					<aui:input name="customerBusinessStartDate" value="${creditApp.customerBusinessStartDate}"></aui:input>
					
					
					
					<aui:select name="customerBusinessIncorporatedState" showEmptyOption="true">
				        <c:forEach items="${statesList}" var="state">
				            <aui:option value="${state.id}" label="${state.name}" selected="${creditApp.customerBusinessIncorporatedState == state.id}"/>
				        </c:forEach>
				    </aui:select>
					
					<aui:input type="text" value="${creditApp.customerBusinessFederalTaxID}" name="customerBusinessFederalTaxID" />
		
				</aui:fieldset>
		 	</liferay-ui:panel>
		 	
		 	<liferay-ui:panel title="Equipment Info" id="equipmentInfo" state="<%=equipmentInfoSectionState %>" >
		 		<aui:fieldset  column="true">
					<label class="control-label">Equipment Price</label>
					<span>${creditApp.equipmentPrice}</span>
				</aui:fieldset>
		 	</liferay-ui:panel>
		 	
		 	<liferay-ui:panel title="Principal Information" id="equipmentInfo" state="<%=equipmentInfoSectionState %>" >
		 
					<aui:button name="enterPrincipalButton" id="enterPrincipalButton" 
					 value="Add New Principal"> </aui:button>
				

		 		
		 		
		 
		 	</liferay-ui:panel>
		 	
		 	<liferay-ui:panel title="Credit Application Bank Reference Information" id="equipmentInfo" state="<%=equipmentInfoSectionState %>" >
		 		<aui:fieldset column="true">
			
				</aui:fieldset>
		 	</liferay-ui:panel>
		 	
		<portlet:renderURL var="enterPrincipalURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">  
			<portlet:param name="mvcPath" value="/html/paymentcalculator/enterPrincipal.jsp"/>
		</portlet:renderURL>		 	
		 	
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
												
											}
										}
									).plug(
										A.Plugin.DialogIframe, {
											autoLoad: false,
											uri: '<%=enterPrincipalURL%>'
										}).render();
					popUpWindow.show();
					popUpWindow.titleNode.html("Enter Principal");
					
				
				});
			});
		</aui:script>