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
<portlet:renderURL var="emailPopupWindowURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" >  
    <portlet:param name="mvcPath" value="/html/manageDocument/sendEmail.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="printDocumentURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" >  
    <portlet:param name="mvcPath" value="/html/manageDocument/printCreditAppDocument.jsp"/>
</portlet:renderURL>
<portlet:resourceURL var="ajaxResourceUrl" />

<portlet:actionURL  var="deleteDocumentUrl">
	<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="deleteDocument" />
</portlet:actionURL>
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

<%-- <liferay-ui:icon-menu>
	
		<liferay-ui:icon image="print" message="Print"
			url="<%=\"javascript: var printWindow=window.open('\"+ printDocumentURL+\"&creditAppDocumentId=\"+primKey+\"', 'print', 'align=center,directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680');void('');printWindow.focus();\"%>" />

</liferay-ui:icon-menu> --%>
<liferay-ui:icon-menu>
	
		<liferay-ui:icon image="print" message="Print"
			url="<%=ajaxResourceUrl+\"&actionType=printAction&creditDocumentId=\"+creditAppDoc.getCreditAppDocumentId()%>" />

</liferay-ui:icon-menu>

<liferay-ui:icon-menu>

<liferay-ui:icon image="edit" message="Email" url="<%=\"javascript: var popupWindow=window.open('\"+ emailPopupWindowURL+\"&creditAppDocumentId=\"+primKey+\"', 'email', 'align=center,directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680');void('');popupWindow.focus();\"%>"/>

</liferay-ui:icon-menu>

<liferay-ui:icon-menu>
	
		<liferay-ui:icon image="delete" message="Delete"
			url="<%=deleteDocumentUrl+\"&creditAppDocumentId=\"+creditAppDoc.getCreditAppDocumentId()%>" />

</liferay-ui:icon-menu>
