<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@ include file="init.jsp"%>

<!-- EXISTING APPLICATION -->
	<c:if test="${creditApp.creditAppId != null}">
	
		<div class="span2">
			<button type="submit" class="btn btn-info" id="createApplicationButton"> Update Application </button>
		</div>
		
		<div class="span2">
			<button type="submit" class="btn btn-danger" id="createApplicationButton"> Submit Application </button>
		</div>
	
	</c:if>
	
	<!-- NEW APPLICATION  -->
	
	<c:if test="${creditApp.creditAppId == null}">
	
		<div class="span2">
			<button type="submit" class="btn btn-info" id="createApplicationButton"> Create Application </button>
		</div>
	
	</c:if>
	
	<div style="clear:both"> </div>
	<p/>