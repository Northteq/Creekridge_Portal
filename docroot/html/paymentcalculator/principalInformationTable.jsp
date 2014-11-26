<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ include file="init.jsp"%>


<liferay-ui:search-container emptyResultsMessage="There are no applications to display" delta="5">
    <liferay-ui:search-container-results>
    <% 
    Long creditAppId = (Long) request.getAttribute("creditAppId");
    List <CreditAppPrincipal> tempResults = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditAppId);
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
            name="principal-number"
            property="principalId"
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
        
        <%-- <liferay-ui:search-container-column-jsp
        path="/creditapplicationstable/appTableActions.jsp"
        align="right"
 		/> --%>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>