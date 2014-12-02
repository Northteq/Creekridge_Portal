<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@page import="com.tamarack.creekridge.model.CreditAppPrincipal"%>
<%@ include file="../init.jsp"%>


<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);  
	
	CreditAppBankReference reference = (CreditAppBankReference) row.getObject();
	
	
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = CreditApp.class.getName();
	String primKey = String.valueOf (reference.getBankReferenceId());
	
	//pass this back to the page after refresh
	String appId = String.valueOf (reference.getCreditAppId());

%>
<liferay-ui:icon-menu>
	<portlet:actionURL name="editCreditAppBankReference" var="editCreditAppBankReferenceURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
			<portlet:param name="creditAppId" value="<%=appId%>" />
		</portlet:actionURL>
		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editCreditAppBankReferenceURL.toString()%>" />

</liferay-ui:icon-menu>

<liferay-ui:icon-menu>
	<portlet:actionURL name="deleteCreditAppBankReference" var="deleteCreditAppBankReferenceURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
			<portlet:param name="creditAppId" value="<%=appId%>" />
		</portlet:actionURL>
		<liferay-ui:icon image="delete" message="Delete"
			url="<%=deleteCreditAppBankReferenceURL.toString()%>" />

</liferay-ui:icon-menu>

<%-- 
<liferay-ui:icon-menu>
	<portlet:actionURL name="viewApplication" var="viewApplicationURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
		</portlet:actionURL>
		<liferay-ui:icon image="view" message="View"
			url="<%=viewApplicationURL.toString()%>" />

</liferay-ui:icon-menu> --%>


