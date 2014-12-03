<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ include file="../init.jsp"%>


<%
	CreditApp creditApp = (CreditApp) request.getAttribute("creditApp");
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/paymentcalculator/view.jsp" />
       <portlet:param name="creditAppId" value="<%=String.valueOf(creditApp.getCreditAppId()) %>" />
       <portlet:param name="openSection" value="principalSection" />
</liferay-portlet:renderURL>

<portlet:renderURL var="enterPrincipalURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value="/html/paymentcalculator/principals/enterPrincipal.jsp" />
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
</portlet:renderURL>

<liferay-ui:success key="principalSaved" message="principal-saved-successfully"/>
<liferay-ui:error key="errorSavingPrincipal" message="error-principal-not-saved" />


<aui:button-row>
	<a class="btn btn-info"
		id="<portlet:namespace/>enterPrincipalButton"><i class="icon-male"></i> Add New Principal</a>
	<a class="btn btn-primary" id="navigateToBankReference"
		onclick="navigateToBankReference()"><i class="icon-meh"></i> Continue to Bank Reference</a>
	<a class="btn" id="navigateTocustomerAndEquipmentInfo"
		onclick="navigateTocustomerAndEquipmentInfo()"><i class="icon-meh"></i>
		Back to Customer and Equipment Info</a>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="There are no principal records to display" delta="5"  iteratorURL="<%=iteratorURL %>">
    <liferay-ui:search-container-results>
    <% 
    
    List <CreditAppPrincipal> tempResults = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditApp.getCreditAppId());
    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size(); 
    
    pageContext.setAttribute ("results", results);
    pageContext.setAttribute ("total", total);
   	
    %>
    
    
    
   </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.tamarack.creekridge.model.CreditAppPrincipal"
        keyProperty="principalId"
        modelVar="principal" escapedModel="<%= false %>">
        
        <liferay-ui:search-container-column-text
            
            property="principalId"
        />
        
        <liferay-ui:search-container-column-text
            name="principal-first-name"
            property="principalFirstName"
        />
        
        <liferay-ui:search-container-column-text
            name="principal-middle-name"
            property="principalMiddleName"
        />
        
        <liferay-ui:search-container-column-text
            name="principal-last-name"
            property="principalLastName"
        />
        
    
        <liferay-ui:search-container-column-date
            name="principal-create-date"
            property="createDate"
        />
        
        <liferay-ui:search-container-column-date
            name="principal-modified-date"
            property="modifiedDate"
        />
        
        
         <liferay-ui:search-container-column-jsp path="/html/paymentcalculator/principals/principalActions.jsp"
        align="right" name="Actions"/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator searchContainer="<%=searchContainer %>"/>
</liferay-ui:search-container>


<%-- PRINCIPAL POPUP  --%>
<aui:script use="aui-base, aui-io-plugin, liferay-util-window">
	
	
	
	
	
	
	A.one('#<portlet:namespace/>enterPrincipalButton').on('click',function(event) {
		
		var popUpWindow = Liferay.Util.Window.getWindow({
			dialog : {
				centered : true,
				constrain2view : true,
				modal : true,
				resizable : false,
				width : 475
			},
			id : 'addPrincipalDialog',
		});
		
		
		popUpWindow.plug(A.Plugin.IO, {
			autoLoad : false
		});
		popUpWindow.titleNode.html("Enter Principal");
		popUpWindow.io.set('uri','<%=enterPrincipalURL%>');
		popUpWindow.render();
		popUpWindow.show();
		popUpWindow.io.start();

	});
	
</aui:script>