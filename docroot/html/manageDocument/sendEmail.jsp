<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@page import="com.tamarack.creekridge.service.*"%>
<%@page import="com.liferay.portal.kernel.util.*"%>
<%@page import="com.tamarack.creekridge.model.CreditAppDocument"%>

<%@ include file="init.jsp"%>

	

<portlet:actionURL  var="emailCreditAppDocumentUrl">
	<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="emailCreditAppDocument" />
</portlet:actionURL>

<%
long creditAppId= new Long(request.getSession().getAttribute("creditAppId").toString());
long creditAppDocumentId= new Long(request.getSession().getAttribute("creditAppDocumentId").toString());
CreditAppDocument creditAppDocument=CreditAppDocumentLocalServiceUtil.getCreditAppDocument(creditAppDocumentId);
CreditApp creditApp=CreditAppLocalServiceUtil.getCreditApp(creditAppId);
%>

<div class="container">
<h3>Email Attachment:</h3>
<aui:form action="<%=emailCreditAppDocumentUrl.toString() %>" name="fm" method="post" inlineLabels="true" onSubmit="javascript:window.close();">
<aui:input type="hidden"   name="creditAppDocumentId"  value="<%=creditAppDocumentId %>" />

<aui:input type="text"  label= "To Email Address:" name="toAddress" value="<%=creditApp.getCustomerContactEmail()%>" /> 
<aui:input type="text"  label= "Subject:" name="subject" />
<aui:input type="textarea"  label= "Body:" name="body" value="<%=\"Hello \"+ creditApp.getCustomerName() %>" rows="10"/>
<p>
	<i class="icon-paper-clip"></i>&nbsp;
	<%=creditAppDocument.getDocumentTitle()%>&nbsp; <%=!creditAppDocument.getDocumentFileName().equals(creditAppDocument.getDocumentTitle())?creditAppDocument.getDocumentFileName():"" %>
</p>
<aui:button type="submit"  value="Send Email"  /> 

</aui:form>
</div>
