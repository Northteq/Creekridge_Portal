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

<!-- Email Options -->
<div>
<H4>Attachment</H4><br>
<%=creditAppDocument.getDocumentTitle()%>&nbsp; <%=!creditAppDocument.getDocumentFileName().equals(creditAppDocument.getDocumentTitle())?creditAppDocument.getDocumentFileName():"" %>
</div>
<div><br>
<aui:form action="<%=emailCreditAppDocumentUrl.toString() %>" name="fm" method="post" onSubmit="javascript:window.close();">
<aui:input type="hidden"   name="creditAppDocumentId"  value="<%=creditAppDocumentId %>" />

<aui:input type="text"  label= "Email Address:" name="toAddress" /> 
<aui:input type="text"  label= "Subject:" name="subject" />
<aui:input type="textarea" resizable="true" label= "Body:" name="body" multiple="true"  max="500" value="<%=\"Hello \"+ creditApp.getCustomerName() %>"/>
<aui:button type="submit"  value="Send Email"  /> 

</aui:form>
</div>
