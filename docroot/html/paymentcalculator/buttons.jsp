<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<!-- EXISTING APPLICATION -->
<<<<<<< HEAD
	<c:if test="${creditAppId != null}"><h3>Application ${creditAppId} </h3> 
	
		<div class="span2">
			<button type="submit" class="btn btn-success" id="createApplicationButton"> Update Application </button>
=======
	<c:if test="${creditApp.creditAppId != null}">
	
		<div class="span2">
			<button type="submit" class="btn btn-info" id="createApplicationButton"> Update Application </button>
>>>>>>> master
		</div>
		
		<div class="span2">
			<button type="submit" class="btn btn-danger" id="createApplicationButton"> Submit Application </button>
		</div>
	
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
			<button type="submit" class="btn btn-info" id="createApplicationButton"> Create Application </button>
>>>>>>> master
		</div>
	
	</c:if>
	
	<div style="clear:both"> </div>
	<p/>