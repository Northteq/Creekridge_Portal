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
	<c:if test="${creditApp.creditAppId != null}">
		<c:if test="${creditApp.creditAppStatusId != 3}">
			<div class="span2">
				<button type="submit" class="btn btn-info" id="createApplicationButton" onClick="processAppButton(0)"><i class="icon-file"></i> Update Application </button>
			</div>
		
			<div class="span2">
				<button type="submit" class="btn btn-danger" id="submitApplicationButton" onClick="processAppButton(1)"><i class="icon-ok-sign"></i> Submit Application </button>
			</div>
		</c:if>
	</c:if>
	
	<!-- NEW APPLICATION  -->
	
	<c:if test="${creditApp.creditAppId == null}">
	
		<div class="span2">
			<button type="submit" class="btn btn-info" id="createApplicationButton"><i class="icon-file"></i> Create Application </button>
		</div>
	
	</c:if>
	
	
	
	<div style="clear:both"> </div>
	<p/>