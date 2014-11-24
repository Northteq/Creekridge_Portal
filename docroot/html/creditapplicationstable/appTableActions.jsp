<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>


<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CreditApp creditApp = (CreditApp) row.getObject();
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = CreditApp.class.getName();
	String primKey = String.valueOf(creditApp.getCreditAppId());

%>
<liferay-ui:icon-menu>
	<portlet:actionURL name="viewApplication" var="viewApplicationURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
		</portlet:actionURL>
		<liferay-ui:icon image="edit" message="Edit"
			url="<%=viewApplicationURL.toString()%>" />

</liferay-ui:icon-menu>