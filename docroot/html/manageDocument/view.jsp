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



<%
long creditAppId= new Long(request.getSession().getAttribute("creditAppId").toString());
CreditApp creditApp11=CreditAppLocalServiceUtil.getCreditApp(creditAppId);
System.out.print("Credit App Id: " + creditAppId);
%>

<aui:form action="<%=uploadToCreditAppDocumentUrl.toString() %>" name="fm" enctype="multipart/form-data" method="post">
<aui:input type="hidden"   name="creditAppId"  value="<%=creditAppId %>" />
  

<div class="container-fluid">
	<div>
		<h4 class="screenTitle pull-left">Manage Documents for Application #<%=creditApp11.getCreditAppId() %></h4>
		<span class="pull-right">
			<a class="btn btn-small btn-back" id="navigateToCreditApp"
			href="/group<%=themeDisplay.getScopeGroup().getFriendlyURL()%>/payment-calculator?creditAppId=<%=creditApp11.getCreditAppId() %>"><i class="icon-backward"></i>
			Back to Credit App</a> 
			<a class="btn btn-small btn-back" id="navigateToCreditApp"
			href="/group<%=themeDisplay.getScopeGroup().getFriendlyURL()%>/view-applications"><i class="icon-backward"></i>
			Back to View Applications</a>
		</span>
	</div>
	<div class="clearfix"></div>
	<div>
	<aui:row>
		<aui:col span="3">
			<div class="screenSection generateDocs">
				<h4>Generate Documents</h4>
				<a href="<%=manageDocumentUrl%>&documentType=creditApp&creditAppId=<%=creditApp11.getCreditAppId() %>" >Generate Credit App</a><br>
				<a href="<%=manageDocumentUrl%>&documentType=proposal&creditAppId=<%=creditApp11.getCreditAppId()%>" >Generate Proposal</a>
			</div>
		</aui:col> 
		<aui:col span="1"></aui:col>
		<aui:col span="8" >
			<div class="screenSection uploadDocs">
				<h4>Upload Documents</h4>
				<aui:input type="text"  label= "Document Title" name="documentTitle" inlineLabel="true"  /> 
				<aui:input type="file"  label= "Select File to Upload" name="uploadedFile" inlineLabel="true" />
				<aui:button type="submit"  label= "" value="Upload"   /> 
			</div>
		</aui:col>
	</aui:row>
	</div>					

	<liferay-ui:success key="appSaved" message="Application Saved Successfully"/>
	<liferay-ui:success key="appUpdated" message="Application Updated Successfully"/>
	<liferay-ui:success key="docGenerated" message="Document Generated Successfully"/>
	<liferay-ui:success key="docUploaded" message="Document Uploaded Successfully"/>

	<div class="listingDocs">
		<h4>Documents Tied to Credit Application:</h4>
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
		
