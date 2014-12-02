<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil"%>
<%@ include file="init.jsp"%>


<!-- EXISTING APPLICATION -->
<<<<<<< HEAD
	<c:if test="${creditAppId != null}"><h3>Application ${creditAppId} </h3> 
	
		<div class="span2">
			<button type="submit" class="btn btn-success" id="createApplicationButton"> Update Application </button>
=======
	<c:if test="${creditApp.creditAppId != null}">
<<<<<<< HEAD
	
		<div class="span2">
			<button type="submit" class="btn btn-info" id="createApplicationButton"> Update Application </button>
>>>>>>> master
		</div>
=======
		<c:if test="${creditApp.creditAppStatusId != 3}">
			<div class="span2">
				<a class="btn btn-info btn-block" id="createApplicationButton" onClick="processAppButton(0)"><i class="icon-file"></i> Save </a>
			</div>
			
			<div class="span2">
				<a class="btn btn-warning btn-block" id="createApplicationButton" onClick="processAppButton(2)"><i class="icon-file"></i> Save and Exit </a>
			</div>
			
			<div class="span2">
				<a class="btn btn-inverse btn-block" id="createApplicationButton" onClick="processAppButton(3)"><i class="icon-file"></i> Manage Documents </a>
			</div>
>>>>>>> master
		
			<div class="span2">
				<a class="btn btn-danger btn-block" id="submitApplicationButton" onClick="processAppButton(1)"><i class="icon-ok-sign"></i> Submit </a>
			</div>
			
			
		</c:if>
	</c:if>
	
<<<<<<< HEAD
	
	<!-- NEW APPLICATION  -->
	
	<c:if test="${creditAppId == null}">
	
		<div class="span2">
			<button type="submit" class="btn btn-success" id="createApplicationButton"> Create Application </button>
=======
	<!-- NEW APPLICATION  -->
	
	<c:if test="${creditApp.creditAppId == null}">
	
		<div class="span2">
<<<<<<< HEAD
			<button type="submit" class="btn btn-info" id="createApplicationButton"> Create Application </button>
>>>>>>> master
=======
			<a class="btn btn-info btn-block" id="createApplicationButton" onClick="processAppButton(0)"><i class="icon-file"></i> Save </a>
>>>>>>> master
		</div>
	
	</c:if>
	
	
	
	<div style="clear:both"> </div>
	<p/>