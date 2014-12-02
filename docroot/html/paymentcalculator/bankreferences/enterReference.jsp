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

<portlet:actionURL name="addCreditAppBankReference" var="addCreditAppBankReferenceURL">
	<portlet:param name="creditAppId" value="${creditAppId}" />
	
</portlet:actionURL>


<aui:container>
	<aui:form action="<%=addCreditAppBankReferenceURL %>" method="post" name="bankReferenceForm">
	
		<aui:fieldset>
			<aui:input name="bankReferenceName" required="true"></aui:input>
			<aui:input name="bankReferenceContact"></aui:input>
			<aui:input name="bankReferencePhone"></aui:input>
			<aui:input name="bankReferenceAccountType"></aui:input>
			<aui:input name="bankReferenceAccountNumber"></aui:input>
		</aui:fieldset>
		<aui:button-row>
			<aui:button id="saveFormButto" value="Save" type="submit"></aui:button>
			<aui:button id="closePopupButton" value="Cancel"></aui:button>
		</aui:button-row>
	</aui:form>
</aui:container>


<script type="text/javascript">
	

	
	
</script>

<%-- <aui:script use="aui-base,aui-io-request">
    A.one('#saveFormButton').on('click', function(event) {
       var A = AUI();
       var url = '<%=addCreditAppBankReferenceURL.toString()%>';
       A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>bankReferenceForm'},
                on: {
                    success: function() {
                        Liferay.Util.getOpener().refreshPortlet();
                        Liferay.Util.getOpener().closePopup('addBankReferenceDialog');
                    }
                }
            }        );
    });
</aui:script> --%>
<aui:script use="aui-base">
    A.one('#closePopupButton').on('click', function(event) {
        Liferay.Util.getOpener().closePopup('addBankReferenceDialog');
    });
</aui:script>