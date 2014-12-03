<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ include file="../init.jsp"%>

<%
	request.setAttribute("creditAppId", ParamUtil.getString(request, "creditAppId"));
	State[] statesList=StateUtil.STATES;
	renderRequest.setAttribute("statesList", statesList);
%>



<portlet:actionURL name="addCreditAppPrincipal" var="addCreditAppPrincipalURL">
	<portlet:param name="creditAppId" value="${creditAppId}" />
</portlet:actionURL>


<aui:container>
	<aui:form action="<%=addCreditAppPrincipalURL %>" method="post" name="principalForm">
	
		<aui:fieldset>
			<aui:input name="principalFirstName" required="true" value="${principal.principalFirstName}"></aui:input>
			<aui:input name="principalMiddleName"></aui:input>
			<aui:input name="principalLastName" required="true"></aui:input>
			<aui:input name="principalSSN"></aui:input>
			<aui:input name="principalHomePhoneNumber"></aui:input>
			<aui:input name="principalAddress1"></aui:input>
			<aui:input name="principalAddress2"></aui:input>
			<aui:input name="principalCity"></aui:input>
			<aui:select inlineField="true" name="principalState"
				showEmptyOption="true">
				<c:forEach items="${statesList}" var="state">
					<aui:option value="${state.id}" label="${state.name}"
						selected="${principal.principalState == state.id}" />
				</c:forEach>
			</aui:select>
			<aui:input name="principalZip"></aui:input>
			<aui:input name="principalEmail" type="email"></aui:input>
		</aui:fieldset>
		<aui:button-row>
			<aui:button id="saveFormButton" value="Save" type="submit"></aui:button>
			<aui:button id="closePopupButton" value="Cancel" onclick="closePopup('')"></aui:button>
		</aui:button-row>
	</aui:form>
</aui:container>



<aui:script>
    Liferay.provide(window, 'closePopup', function(dialogId) {
        var A = AUI();
        var dialog = Liferay.Util.Window.getById('addPrincipalDialog');
        dialog.destroy();
    },
    ['liferay-util-window']
    );
</aui:script>