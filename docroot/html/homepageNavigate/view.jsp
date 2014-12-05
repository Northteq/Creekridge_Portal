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


<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>

<portlet:renderURL var="seedDataURL">

	<portlet:param name="mvcPath" value="/html/homepageNavigate/seedData.jsp" />
</portlet:renderURL>

<a href="<%=seedDataURL %>" style="display:none">Seed Data</a>

<div class="container">
	<h3>
		Welcome to <b>Creekridge Capital</b>
	</h3>

	<div class="span2">
		<a class="btn btn-info btn-block" href="payment-calculator"><i class="icon-pencil"></i> Payment Calculator</a>
	</div>

	<div class="span2">
		<a class="btn btn-success btn-block" href="view-application"><i class="icon-pencil"></i> View Application </a>
	</div>
	
	
	<div class="span2">
		<a class="btn btn-inverse btn-block" href="manage-documents"><i class="icon-book"></i> Document &amp; Materials</a>
	</div>
	
	<div class="span2">
		<a class="btn btn-warning btn-block" href="contact-info"><i class="icon-user"></i> Contact Info</a>
	</div>
	

</div>