<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>
<% 
	State[] statesList=StateUtil.STATES;
	renderRequest.setAttribute("statesList", statesList);
	
	String [] corpTypeList =  {"Corporation", "Sole Prop", "LLC", "LLP", "Partnership", "S Corporation", "Government Entity"};
	renderRequest.setAttribute("corpTypeList", corpTypeList);
	
%>

<liferay-ui:tabs names="Customer Info,Customer Contact Info,Customer Address Info, Business Info, Equipment Info, Principal Information, Bank Reference" refresh="<%=false %>">
    <liferay-ui:section>
       <aui:fieldset label="Customer Info" column="false">
			<aui:input name="customerName" value="${creditApp.customerName}"></aui:input>
			<aui:input name="customerDBAName" label="DBA Name" value="${creditApp.customerDBAName}"></aui:input>
		</aui:fieldset>
    </liferay-ui:section>
    <liferay-ui:section>
           <aui:fieldset label="Customer Contact Info" column="true">
			<aui:input name="customerContact" label="Customer Contact"></aui:input>
			<aui:input name="contactPhone" label="Conatct Phone"></aui:input>
			<aui:input name="contactFax" label="Conatct Fax"></aui:input>
		</aui:fieldset>
    </liferay-ui:section>
    <liferay-ui:section>
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
    </liferay-ui:section>
     <liferay-ui:section>
     <aui:fieldset label="Business Info" column="true">
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
     
     
     </liferay-ui:section>
     
      <liferay-ui:section>
     	
			
		<aui:fieldset label="Equipment Info" column="true">
			<label class="control-label">Equipment Price</label>
			<span>${creditApp.equipmentPrice}</span>
		</aui:fieldset>

     </liferay-ui:section>
     
      <liferay-ui:section>
     	
			
		<aui:fieldset label="Principal Information" column="true">
			
			
			
			
		</aui:fieldset>

     </liferay-ui:section>
     
     <liferay-ui:section>
     	
			
		<aui:fieldset label="Credit Application Bank Reference Information" column="true">
			
		</aui:fieldset>

     </liferay-ui:section>
   
</liferay-ui:tabs>
	
	