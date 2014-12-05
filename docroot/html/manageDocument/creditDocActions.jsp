<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@page import="com.tamarack.creekridge.model.CreditAppDocument"%>
<%@page import="com.liferay.portal.kernel.dao.search.*"%>
<%@page import="com.liferay.portal.kernel.portlet.*" %>
<%@ include file="init.jsp"%>

<portlet:resourceURL var="ajaxResourceUrl" />
<portlet:renderURL var="emailPopupWindowURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" >  
			<portlet:param name="mvcPath" value="/html/manageDocument/sendEmail.jsp"/>
</portlet:renderURL>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CreditAppDocument creditAppDoc = (CreditAppDocument) row.getObject();
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = CreditAppDocument.class.getName();
	String primKey = String.valueOf(creditAppDoc.getCreditAppDocumentId());

%>

<liferay-ui:icon-menu>
	
		<liferay-ui:icon image="view" message="View"
			url="<%=ajaxResourceUrl+\"&actionType=downloadAction&creditDocumentId=\"+creditAppDoc.getCreditAppDocumentId()%>" />

</liferay-ui:icon-menu>
&nbsp;
<liferay-ui:icon-menu>
	
		<liferay-ui:icon  image="message" message="Email" cssClass="emailPopupWindow" url="<%=emailPopupWindowURL+\"&creditAppDocumentId=\"+creditAppDoc.getCreditAppDocumentId()%>" target="_blank" id="<%=new Long(creditAppDoc.getCreditAppDocumentId()).toString() %>"/>

</liferay-ui:icon-menu>
&nbsp;

<liferay-ui:icon-menu>
	
		<liferay-ui:icon image="delete" message="Delete"
			url="<%=ajaxResourceUrl+\"&actionType=deleteAction&creditDocumentId=\"+creditAppDoc.getCreditAppDocumentId()%>" />

</liferay-ui:icon-menu>
