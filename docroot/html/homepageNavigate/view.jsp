<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"  %>

<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>

<portlet:defineObjects />


<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>


<%

ThemeDisplay td  = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

String currentUrl = td.getURLCurrent();

String root = currentUrl.substring(0, currentUrl.lastIndexOf("/"));

%>







<div class="container">
	<h3>
		Welcome to <b>Creekridge Capital</b>
	</h3>

	<div class="span2">
		<a class="btn btn-info btn-block" href="<%=root %>/payment-calculator">Pricing Calculation</a>
	</div>

	<div class="span2">
		<a class="btn btn-success btn-block" href="<%=root %>/view-application" >View Application </a>
	</div>
	
	<div class="span2">
		<a class="btn btn-danger btn-block" href="<%=root %>/document-material">Document &amp; Materials</a>
	</div>
	
	<div class="span2">
		<a class="btn btn-warning btn-block" href="<%=root %>/contact-info">Contact Info</a>
	</div>
	

</div>