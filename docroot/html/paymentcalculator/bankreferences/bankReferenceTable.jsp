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
       <portlet:param name="openSection" value="bankReferenceSection" />
</liferay-portlet:renderURL>
<liferay-ui:success key="bankReferenceSaved" message="reference-saved-successfully"/>
<liferay-ui:search-container emptyResultsMessage="There are no bank references to display" delta="5"  iteratorURL="<%=iteratorURL %>">
    <liferay-ui:search-container-results>
    <% 
    
    List <CreditAppBankReference> tempResults = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(creditApp.getCreditAppId());
    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size(); 
    
    pageContext.setAttribute ("results", results);
    pageContext.setAttribute ("total", total);
   	
    %>
    
    
    
   </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.tamarack.creekridge.model.CreditAppBankReference"
        keyProperty="bankReferenceId"
        modelVar="reference" escapedModel="<%= false %>">
        
        <liferay-ui:search-container-column-text
            
            property="bankReferenceId"
            
            
        />
        
        <%-- orderable="<%= true %>" --%>
        
       <liferay-ui:search-container-column-text
            property="bankReferenceName"
            name="bank-reference-name"
        />
        
        <liferay-ui:search-container-column-text
            property="bankReferenceContact"
             name="bank-reference-contact"
        />
         
        <liferay-ui:search-container-column-text
            property="bankReferencePhone"
             name="bank-reference-phone"
        />
        
        <liferay-ui:search-container-column-text
            property="bankReferenceAccountType"
             name="bank-reference-account-type"
        />
        
    <%-- 
        <liferay-ui:search-container-column-date
            name="principal-create-date"
            property="createDate"
        />
        
        <liferay-ui:search-container-column-date
            name="principal-modified-date"
            property="modifiedDate"
        />
         --%>
        
         <liferay-ui:search-container-column-jsp
        path="/html/paymentcalculator/bankreferences/referenceActions.jsp"
        align="right"
        name="Actions"
 		/>
  
<%-- 
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
        /> --%>
        
        <%-- <liferay-ui:search-container-column-jsp
        path="/creditapplicationstable/appTableActions.jsp"
        align="right"
 		/> --%>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator searchContainer="<%=searchContainer %>"/>
</liferay-ui:search-container>


<aui:script>
    Liferay.provide(window, 'refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },
    ['aui-dialog','aui-dialog-iframe']
    );
</aui:script>

<aui:script>
    Liferay.provide(window, 'closePopup', function(dialogId) {
        var A = AUI();
        var dialog = Liferay.Util.Window.getById(dialogId);
        dialog.destroy();
    },
    ['liferay-util-window']
    );
</aui:script>