<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@ include file="init.jsp"%>


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
            name="description"
            value="<%= String.valueOf(creditApp.getCreditAppStatusId()) %>"
        />

        <liferay-ui:search-container-column-text
            name="streetAddress"
            value="<%= String.valueOf(creditApp.getCreateDate()) %>"
        />

        <liferay-ui:search-container-column-text
            name="city"
            value="<%= String.valueOf(creditApp.getEquipmentPrice()) %>"
        />
        
        <liferay-ui:search-container-column-jsp
        path="/creditapplicationstable/appTableActions.jsp"
        align="right"
 		/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>