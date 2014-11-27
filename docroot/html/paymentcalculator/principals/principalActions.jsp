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
	
	CreditAppPrincipal principal = (CreditAppPrincipal) row.getObject();
	
	
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = CreditApp.class.getName();
	String primKey = String.valueOf (principal.getPrincipalId());
	
	//pass this back to the page after refresh
	String appId = String.valueOf (principal.getCreditAppId());

%>
<liferay-ui:icon-menu>
	<portlet:actionURL name="viewPrincipal" var="viewPrincipalURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
			
		</portlet:actionURL>
		<liferay-ui:icon image="edit" message="Edit"
			url="<%=viewPrincipalURL.toString()%>" />

</liferay-ui:icon-menu>

<liferay-ui:icon-menu>
	<portlet:actionURL name="deleteCreditAppPrincipal" var="deleteCreditAppPrincipalURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
			<portlet:param name="appId" value="<%=appId%>" />
		</portlet:actionURL>
		<liferay-ui:icon image="delete" message="Delete"
			url="<%=deleteCreditAppPrincipalURL.toString()%>" />

</liferay-ui:icon-menu>

<%-- 
<liferay-ui:icon-menu>
	<portlet:actionURL name="viewApplication" var="viewApplicationURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
		</portlet:actionURL>
		<liferay-ui:icon image="view" message="View"
			url="<%=viewApplicationURL.toString()%>" />

</liferay-ui:icon-menu> --%>


