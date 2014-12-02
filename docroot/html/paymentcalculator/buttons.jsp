<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>

<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil"%>
<%@ include file="init.jsp"%>


<%

ThemeDisplay td  = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

String currentUrl = td.getURLHome();

%>

<!-- EXISTING APPLICATION -->
	<c:if test="${creditApp.creditAppId != null}">
		<c:if test="${creditApp.creditAppStatusId != 3}">
			<div class="span2">
				<a class="btn btn-block" id="createApplicationButton" onClick="processAppButton(0)"><i class="icon-file"></i> Save </a>
			</div>
			
			<div class="span2">
				<a class="btn btn-block" id="createApplicationButton" onClick="processAppButton(2)"><i class="icon-file"></i> Save and Exit </a>
			</div>
			
			<div class="span2">
				<a class="btn btn-block" id="manageDocsButton" onClick="processAppButton(3)" href="<%=currentUrl %>/manage-documents?creditAppId=${creditApp.creditAppId}"><i class="icon-file"></i> Manage Documents </a>
			</div>
		
			<div class="span2">
				<a class="btn btn-success btn-block" id="submitApplicationButton" onClick="processAppButton(1)"><i class="icon-ok-sign"></i> Submit </a>
			</div>
			
			
		</c:if>
	</c:if>
	
	<!-- NEW APPLICATION  -->
	
	<c:if test="${creditApp.creditAppId == null}">
	
		<div class="span2">
			<a class="btn btn-info btn-block" id="createApplicationButton" onClick="processAppButton(0)"><i class="icon-file"></i> Save </a>
		</div>
	
	</c:if>
	
	
	
	<div style="clear:both"> </div>
	<p/>