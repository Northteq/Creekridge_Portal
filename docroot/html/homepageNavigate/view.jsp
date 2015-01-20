<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"  %>

<<<<<<< HEAD
<portlet:defineObjects />


<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
=======
<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>

<portlet:defineObjects />


<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>

<portlet:renderURL var="seedDataURL">

	<portlet:param name="mvcPath" value="/html/homepageNavigate/seedData.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewApplicationsURL">

<<<<<<< HEAD
>>>>>>> master
=======
	<portlet:param name="mvcPath" value="/html/viewCreditApplication/view.jsp" />
</portlet:renderURL>
>>>>>>> master

<a href="<%=seedDataURL %>" style="display:none">Seed Data</a>

<div class="container">
	<h3>
		Welcome to <b>Creekridge Capital</b>
	</h3>

	<div class="span2">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		<a class="btn btn-info btn-block" href="/web/vendor1/payment-calculator">Pricing Calculation</a>
	</div>

	<div class="span2">
		<a class="btn btn-success btn-block" href="/web/vendor1/view-application" >View Application </a>
	</div>
	
	<div class="span2">
		<a class="btn btn-danger btn-block" href="/web/vendor1/document-material">Document &amp; Materials</a>
	</div>
	
	<div class="span2">
		<a class="btn btn-warning btn-block" href="/web/vendor1/contact-info">Contact Info</a>
=======
		<a class="btn btn-info btn-block" href="<%=root %>/payment-calculator">Pricing Calculation</a>
=======
		<a class="btn btn-info btn-block" href="<%=root %>/payment-calculator"><i class="icon-pencil"></i> Payment Calculator</a>
>>>>>>> master
=======
		<a class="btn btn-info btn-block" href="payment-calculator"><i class="icon-pencil"></i> Payment Calculator</a>
>>>>>>> master
	</div>

	<div class="span2">
		<a class="btn btn-success btn-block" href="view-applications"><i class="icon-th-list"></i> View Applications </a>
	</div>
	
	
	<div class="span2">
		<a class="btn btn-inverse btn-block" href="manage-documents"><i class="icon-book"></i> Document &amp; Materials</a>
	</div>
	
	<div class="span2">
<<<<<<< HEAD
<<<<<<< HEAD
		<a class="btn btn-warning btn-block" href="<%=root %>/contact-info">Contact Info</a>
>>>>>>> master
=======
		<a class="btn btn-warning btn-block" href="<%=root %>/contact-info"><i class="icon-user"></i> Contact Info</a>
>>>>>>> master
=======
		<a class="btn btn-warning btn-block" href="contact-info"><i class="icon-user"></i> Contact Info</a>
>>>>>>> master
	</div>
	

</div>