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
			<aui:button id="closePopupButton" value="Cancel"></aui:button>
		</aui:button-row>
	</aui:form>
</aui:container>


<script type="text/javascript">
	

	
	
</script>

<%-- <aui:script use="aui-base,aui-io-request">
    A.one('#saveFormButton').on('click', function(event) {
       var A = AUI();
       var url = '<%=addCreditAppPrincipalURL.toString()%>';
       A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>principalForm'},
                on: {
                    success: function() {
                        Liferay.Util.getOpener().refreshPortlet();
                        Liferay.Util.getOpener().closePopup('addPrincipalDialog');
                    }
                }
            }        );
    });
</aui:script> --%>
<aui:script use="aui-base">
	console.log ('closing dialog');
    A.one('#closePopupButton').on('click', function(event) {
        Liferay.Util.getOpener().closePopup('addPrincipalDialog');
    });
</aui:script>