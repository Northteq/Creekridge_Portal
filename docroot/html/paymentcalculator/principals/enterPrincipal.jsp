<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%
	request.setAttribute("creditAppId", ParamUtil.getString(request, "creditAppId"));
%>

<%@ include file="../init.jsp"%>

<portlet:actionURL name="addCreditAppPrincipal" var="addCreditAppPrincipalURL">
	<portlet:param name="creditAppId" value="${creditAppId}" />
</portlet:actionURL>


<aui:container>
	<aui:form action="<%=addCreditAppPrincipalURL %>" method="post" name="principalForm">
	
		<aui:fieldset>
			<aui:input name="principalFirstName" required="true"></aui:input>
			<aui:input name="principalMiddleName"></aui:input>
			<aui:input name="principalLastName" required="true"></aui:input>
		</aui:fieldset>
		<aui:button-row>
			<aui:button id="saveFormButton" value="Save"></aui:button>
			<aui:button id="closePopupButton" value="Cancel"></aui:button>
		</aui:button-row>
	</aui:form>
</aui:container>


<script type="text/javascript">
	

	
	
</script>

<aui:script use="aui-base,aui-io-request">
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
</aui:script>
<aui:script use="aui-base">
    A.one('#closePopupButton').on('click', function(event) {
        Liferay.Util.getOpener().closePopup('addPrincipalDialog');
    });
</aui:script>