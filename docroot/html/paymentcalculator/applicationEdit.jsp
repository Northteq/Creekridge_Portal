<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

	<aui:col span="3">
		<aui:fieldset label="Customer Detail" column="true">
			<aui:input name="customerName" value="${creditApp.customerName}"></aui:input>
			<aui:input name="customerDBAName" label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
		</aui:fieldset>
	</aui:col>
			
	<aui:col span="3">
		<aui:fieldset label="Customer Contact Detail" column="true">
			<aui:input name="customerContact" label="Customer Contact"></aui:input>
			<aui:input name="contactPhone" label="Conatct Phone"></aui:input>
			<aui:input name="contactFax" label="Conatct Fax"></aui:input>
		</aui:fieldset>
	</aui:col>
	
	<aui:col span="3">
		<aui:fieldset label="Customer Address Info" column="true">
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
	</aui:col>