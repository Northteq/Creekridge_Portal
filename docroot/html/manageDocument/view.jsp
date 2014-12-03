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
<%@page import="com.liferay.portal.util.PortalUtil"%>

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
<liferay-ui:success key="emailSent" message="email-sent-successfully"/>
<liferay-ui:success key="docGenerated" message="credit-doc-generated-successfully"/>
<liferay-ui:success key="propGenerated" message="credit-proposal-generated-successfully"/>
<liferay-ui:success key="docUploaded" message="document-uploaded-successfully"/>
<liferay-ui:success key="docDeleted" message="document-deleted-successfully"/>

<%
long creditAppId= new Long(request.getSession().getAttribute("creditAppId").toString());
CreditApp creditApp11=CreditAppLocalServiceUtil.getCreditApp(creditAppId);
System.out.print("Credit App Id: " + creditAppId);
%>

<aui:form action="<%=uploadToCreditAppDocumentUrl.toString() %>" name="fm" enctype="multipart/form-data" method="post">
<aui:input type="hidden"   name="creditAppId"  value="<%=creditAppId %>" />
  
<!-- Generate Doc Grid -->

<aui:row> 
	<aui:col span="12">
		<div class="appSummary">
			<h4>Application Summary</h4>
			<table class="table table-striped">
				<thead>
					<th>Application ID</th>
					<th>Customer Name</th>
					<th>Equipment Price</th>
					<th>View/Edit</th>
				</thead>
				<tbody>
					<td><%=creditApp11.getCreditAppId() %></td>
					<td><%=creditApp11.getCustomerName() %></td>
					<td><%=creditApp11.getEquipmentPrice() %></td>
					<td><a href="/group<%=themeDisplay.getScopeGroup().getFriendlyURL()%>/payment-calculator?creditAppId=<%=creditApp11.getCreditAppId() %>">Return to Credit App</a></td>
				</tbody>
			</table>
		</div>	
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="4">
		<div class="generateDocs">
			<h4>Generate Documents</h4>
			<h5><a  href="<%=manageDocumentUrl%>&documentType=creditApp&creditAppId=<%=creditApp11.getCreditAppId() %>" >Generate Credit App</a><br></h5>
			<h5><a  href="<%=manageDocumentUrl%>&documentType=proposal&creditAppId=<%=creditApp11.getCreditAppId()%>" >Generate Proposal</a></h5>
		</div>
	</aui:col> 
	<aui:col span="8" >
		<div class="uploadDocs">
			<h4>Upload Documents</h4>
			<aui:input type="text"  label= "Document Title" name="documentTitle" /> 
			Select File to Upload
			<aui:input type="file"  label= "" name="uploadedFile" /><aui:button type="submit"  label= "" value="Upload"  /> 
		</div>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="12">
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
	</aui:col>		
</aui:row>

</aui:form>
	