<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<portlet:renderURL portletMode="view" var="editAppURL">
	<portlet:param name="viewMode" value="<%= String.valueOf(false)%>" />
</portlet:renderURL>



	<liferay-ui:icon
		   image="tool"
		   message="Edit Credit App"
		   label="<%= true%>"
		   method="get"
		   url="<%= editAppURL%>"
		   useDialog="<%= false%>"
		   
		  />

<aui:panel label="Address Info">

<address>
  <strong><aui-field>${creditApp.customerName}</strong><br>
  ${creditApp.customerAddress1}<br>
  ${creditApp.customerAddress2}<br>
  ${creditApp.customerCity}, ${creditApp.customerState} ${creditApp.customerZip}<br>
  <abbr title="Phone">P:</abbr> ${creditApp.customerContactPhone}<br>
  <abbr title="Fax">F:</abbr> ${creditApp.customerContactFax}<br>
  <abbr title="Email">E:</abbr> ${creditApp.customerContactEmail}<br>
</address>

</aui:panel>

 
<address>
  <strong>Full Name</strong><br>
  <a href="mailto:#">first.last@example.com</a>
</address>