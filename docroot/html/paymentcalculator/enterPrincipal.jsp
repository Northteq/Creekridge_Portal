<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%
	request.setAttribute("creditAppId", ParamUtil.getString(request, "creditAppId"));
%>

<%@ include file="init.jsp"%>

<portlet:actionURL name="addCreditAppPrincipal" var="addCreditAppPrincipalURL">
	<portlet:param name="creditAppId" value="${creditAppId}" />
</portlet:actionURL>


<aui:container>
	<aui:form action="<%=addCreditAppPrincipalURL %>" method="post" name="principalForm">
	
		<aui:fieldset>
			<aui:input name="principalFirstName"></aui:input>
			<aui:input name="principalMiddleName"></aui:input>
			<aui:input name="principalLastName"></aui:input>
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" id="saveButton"></aui:button>
		</aui:button-row>
	</aui:form>
</aui:container>


<script type="text/javascript">
	

	
	
</script>