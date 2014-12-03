<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@page import="com.tamarack.creekridge.service.*"%>
<%@page import="com.liferay.portal.kernel.util.*"%>
<%@page import="com.tamarack.creekridge.model.CreditAppDocument"%>
<%@page import="com.liferay.portal.kernel.portlet.*" %>

<%@ include file="init.jsp"%>


<portlet:actionURL  var="manageDocumentUrl">
	<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="manageDocument" />
</portlet:actionURL>

<portlet:actionURL  var="uploadToCreditAppDocumentUrl">
	<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="uploadToCreditAppDocument" />
</portlet:actionURL>

<portlet:actionURL  var="emailCreditAppDocumentUrl">
	<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="emailCreditAppDocument" />
</portlet:actionURL>


<portlet:resourceURL var="ajaxResourceUrl" />

<liferay-ui:success key="appSaved" message="app-saved-successfully"/>
<liferay-ui:success key="appUpdated" message="app-updated-successfully"/>
<liferay-ui:success key="docGenerated" message="document-generated-successfully"/>
<liferay-ui:success key="docUploaded" message="document-uploaded-successfully"/>

<%
long creditAppId= new Long(request.getSession().getAttribute("creditAppId").toString());
CreditApp creditApp11=CreditAppLocalServiceUtil.getCreditApp(creditAppId);
System.out.print("Credit App Id: " + creditAppId);
%>

<!-- Credit Summary -->
<div>
Application Summary<br>
Application ID:<%=creditApp11.getCreditAppId() %><br>
Customer Name: <%=creditApp11.getCustomerName() %><br>
Equipment Price:<%=creditApp11.getEquipmentPrice() %><br>

</div>

<aui:form action="<%=uploadToCreditAppDocumentUrl.toString() %>" name="fm" enctype="multipart/form-data" method="post">
<aui:input type="hidden"   name="creditAppId"  value="<%=creditAppId %>" />
  
<!-- Generate Doc Grid -->

<aui:row> 
<aui:col width="40"> 

<a  href="<%=manageDocumentUrl%>&documentType=creditApp&creditAppId=<%=creditApp11.getCreditAppId() %>" >Generate Credit App</a><br>
<a  href="<%=manageDocumentUrl%>&documentType=proposal&creditAppId=<%=creditApp11.getCreditAppId()%>" >Generate Proposal</a>
</aui:col> 
<aui:col width="10"> 
</aui:col> 
<aui:col width="50" span="2" >
<aui:input type="text"  label= "Document Title" name="documentTitle" /> 
Select File to Upload
<aui:input type="file"  label= "" name="uploadedFile" /><aui:button type="submit"  label= "" value="Upload"  /> 
</aui:col>
</aui:row>
<div>
<liferay-ui:search-container emptyResultsMessage="There are no generated documents to display" delta="5">
    <liferay-ui:search-container-results>
    <% 
    
    
    List <CreditAppDocument> tempResults = CreditAppDocumentLocalServiceUtil.getCreditAppDocumentByCreditAppId(creditAppId);
    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size();
    
    pageContext.setAttribute ("results", results);
    pageContext.setAttribute ("total", total);
    
    
    %>
   </liferay-ui:search-container-results>

    <liferay-ui:search-container-row   className="com.tamarack.creekridge.model.CreditAppDocument"
        keyProperty="creditAppDocumentId"
        modelVar="creditAppDocument" escapedModel="<%= false %>">
        
        <liferay-ui:search-container-column-text
            name="document-title"
            property="documentTitle"
        />

        <liferay-ui:search-container-column-text
            name="file-name"
            property="documentFileName"
        />

        <liferay-ui:search-container-column-text
            name="create-date"
            property="createDate" 
        />

       <liferay-ui:search-container-column-jsp
        path="/html/manageDocument/creditDocActions.jsp"
        align="right"
        name="Actions"
   />
        
        

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>
</div>
</aui:form>
	<portlet:renderURL var="emailPopupWindowURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" >  
			<portlet:param name="mvcPath" value="/html/manageDocument/sendEmail.jsp? %>"/>
</portlet:renderURL>	 	
			
		<aui:script>
			AUI().use('aui-base',
				'aui-dialog-iframe',
				 
				function(A) {
				A.one('.emailPopupWindow111').on('click', function(event){ 
				 alert('data '+ A.one('.emailPopupWindow').get('data'));
					var popUpWindow=Liferay.Util.Window.getWindow({
											dialog: {
												centered: true,
												constrain2view: true,
												modal: true,
												resizable: false,
												width: 600,
												
											}
										}
									).plug(
										A.Plugin.DialogIframe, {
											autoLoad: false,
											uri: '<%=emailPopupWindowURL%>'+ '&creditAppDocumentId='+ A.one('.emailPopupWindow').get('id')
										}).render();
				  
					popUpWindow.show();
					popUpWindow.titleNode.html("Send Email");
					popUpWindow.io.start();
				
				});
			});
		</aui:script>
		
		<script>
			
				 
				function test() {
			
				 
					var popUpWindow=Liferay.Util.Window.getWindow({
											dialog: {
												centered: true,
												constrain2view: true,
												modal: true,
												resizable: false,
												width: 600,
												
											}
										}
									).plug(
										A.Plugin.DialogIframe, {
											autoLoad: false,
											uri: '<%=emailPopupWindowURL%>'+ '&creditAppDocumentId='+ A.one('.emailPopupWindow').get('id')
										}).render();
				  
					popUpWindow.show();
					popUpWindow.titleNode.html("Send Email");
					popUpWindow.io.start();
				
				
			}
		</script>
		
