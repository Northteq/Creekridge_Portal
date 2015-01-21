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

<portlet:actionURL var="generateDocumentsURL" 
	name="generateDocuments">
	<portlet:param name="creditAppId" value="${creditAppId}"/>
</portlet:actionURL>

<portlet:actionURL  var="uploadToCreditAppDocumentUrl" name="uploadToCreditAppDocument">
</portlet:actionURL>

<portlet:actionURL  var="emailCreditAppDocumentUrl" name="emailCreditAppDocument">
</portlet:actionURL>




<portlet:resourceURL var="ajaxResourceUrl" />


<liferay-ui:success key="appSaved" message="Application Saved Successfully"/>
<liferay-ui:success key="appUpdated" message="Application Updated Successfully"/>
<liferay-ui:success key="docGenerated" message="Document Generated Successfully"/>
<liferay-ui:success key="docUploaded" message="Document Uploaded Successfully"/>
<liferay-ui:error key="genericError" message="Error occurred while generating file"/>




<%

long creditAppId = 0;
CreditApp creditApp11 = CreditAppLocalServiceUtil.createCreditApp(999);

try {
	String tempAppIdString = request.getSession().getAttribute("creditAppId").toString();
	
	if (tempAppIdString.isEmpty())  {
		creditAppId = ParamUtil.getLong (request, "creditAppId");
	} else {
		creditAppId = new Long (tempAppIdString);
	}
		
	
	creditApp11 = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
	System.out.println ("manage docs jsp ---- > Credit App Id: " + creditAppId);

} catch (Exception e) {
	System.out.println (e);
}

%>



  

<div class="container-fluid">

	<div>
		<h4 class="screenTitle pull-left">Manage Documents for Application #<%=creditApp11.getCreditAppId() %></h4>
	</div>
	
	<aui:button-row>
			<a class="btn btn-small btn-back" id="navigateToCreditApp"
			href="/group<%=themeDisplay.getScopeGroup().getFriendlyURL()%>/payment-calculator?creditAppId=<%=creditApp11.getCreditAppId() %>"><i class="icon-backward"></i>
			Back to Credit App</a> 
			<a class="btn btn-small btn-back" id="navigateToCreditApp"
			href="/group<%=themeDisplay.getScopeGroup().getFriendlyURL()%>/view-applications"><i class="icon-backward"></i>
			Back to View Applications</a>
	</aui:button-row>
		
		
	<div class="clearfix"></div>
	<div style="margin-bottom: 10px;">
	<aui:row>
		<aui:col span="3">
			<div class="screenSection generateDocs">
				<h4>Generate Documents</h4>
				<%-- <a href="<%=manageDocumentUrl%>&documentType=creditApp&creditAppId=<%=creditApp11.getCreditAppId() %>" >Generate Credit App</a><br>
				<a href="<%=manageDocumentUrl%>&documentType=proposal&creditAppId=<%=creditApp11.getCreditAppId()%>" >Generate Proposal</a> --%>
				<aui:form  method="POST" action="<%=generateDocumentsURL %>" name="docsForm">
					<c:forEach items="${templateOptions}" var="template">
						<aui:input type="checkbox" value="${template.name}" name="htmlTemplates" label="${template.label}"/>
					</c:forEach>
					<input type="submit" class="btn" value="Generate Selected Documents"/>
				</aui:form>
			</div>
		</aui:col> 
		<aui:col span="1"></aui:col>
		<aui:col span="8" >
			<div class="screenSection uploadDocs">
				<h4>Upload Documents</h4>
				
				<aui:form action="<%=uploadToCreditAppDocumentUrl.toString() %>" name="fm" enctype="multipart/form-data" method="post">
					<aui:input type="hidden"   name="creditAppId"  value="<%=creditAppId %>" />
					<aui:input type="text"  label= "Document Title" name="documentTitle" inlineLabel="true"  /> 
					<aui:input type="file"  label= "Select File to Upload" name="uploadedFile" inlineLabel="true" />
					<aui:button type="submit"  label= "" value="Upload"   /> 
				</aui:form>
			</div>
		</aui:col>
	</aui:row>
	</div>					

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



	<portlet:renderURL var="emailPopupWindowURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" >  
			<portlet:param name="mvcPath" value="/html/manageDocument/sendEmail.jsp? %>"/>
</portlet:renderURL>	 	
			
<%-- <aui:script>
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
</aui:script> --%>
