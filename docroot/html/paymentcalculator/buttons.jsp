<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>
 
<%@ include file="init.jsp"%>

<portlet:renderURL var="viewApplicationsURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>" >  
			<portlet:param name="mvcPath" value="/html/viewCreditApplication/view.jsp"/>
			<portlet:param name="creditAppId" value="${creditApp.creditAppId}"/>
</portlet:renderURL>




<!-- EXISTING APPLICATION -->
	<c:if test="${creditApp.creditAppId != null}">
		<c:if test="${creditApp.creditAppStatusId != 3}">
			<div class="span2">
				<a class="btn btn-block  btn-save" id="saveApplicationButton" onClick="processAppButton(0)"><i class="icon-save"></i> Save </a>
			</div>
			
			<div class="span2">
				<a class="btn btn-block btn-saveexit" id="exitApplicationButton" href="<%=viewApplicationsURL %>" onClick="processAppButton(0)"><i class="icon-signout"></i> Save and Exit </a>
			</div>
			
			<div class="span2">
				<a class="btn btn-block btn-managedocs" id="manageDocsButton" href="manage-documents?creditAppId=${creditApp.creditAppId}"><i class="icon-file"></i> Manage Documents </a>
			</div>
		
			<div class="span2">
				<a class="btn btn-success btn-block btn-submit" id="submitApplicationButton" onClick="processAppButton(1)"><i class="icon-ok-sign"></i> Submit </a>
			</div>
			
			
		</c:if>
	</c:if>
	
	<!-- NEW APPLICATION  -->
	
	<%-- <c:if test="${creditApp.creditAppId == null}">
	
		<div class="span2">
			<a class="btn btn-info btn-block" id="createApplicationButton" onClick="processAppButton(0)"><i class="icon-file"></i> Save </a>
		</div>
	
	</c:if> --%>
	
	
	
	<div style="clear:both"> </div>
	<p/>