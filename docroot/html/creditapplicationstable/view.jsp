<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ include file="init.jsp"%>
<portlet:renderURL var="appTableActionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">   
	<portlet:param name="mvcPath" value="/html/creditapplicationstable/appTableActions.jsp"/>
</portlet:renderURL>

<liferay-ui:search-container emptyResultsMessage="There are no applications to display" delta="5">
    <liferay-ui:search-container-results>
    <% 
    
    List <CreditApp> tempResults = CreditAppLocalServiceUtil.getCreditAppByGroupId(scopeGroupId);
    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size();
    
    pageContext.setAttribute ("results", results);
    pageContext.setAttribute ("total", total);
    
    
    %>
   </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.tamarack.creekridge.model.CreditApp"
        keyProperty="creditAppId"
        modelVar="creditApp" escapedModel="<%= false %>">
        
        <liferay-ui:search-container-column-text
            name="application-number"
            property="creditAppId"
        />

        <liferay-ui:search-container-column-text
            name="credit-app-status"
            property="creditAppStatusId"
        />

        <liferay-ui:search-container-column-date
            name="create-date"
            property="createDate"
        />

        <liferay-ui:search-container-column-text
            name="equipment-price"
            property="equipmentPrice"
        />
        
        <liferay-ui:search-container-column-jsp
        path="/html/creditapplicationstable/appTableActions.jsp"
        align="right"
        name="Actions"
 		/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>


