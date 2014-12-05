<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>
 
<%@ include file="init.jsp"%>

<portlet:renderURL portletMode="view" var="viewAppURL">
	<portlet:param name="viewOnly" value="<%=String.valueOf(true)%>" />
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
	<portlet:param name="mvcPath" value="/html/paymentcalculator/view.jsp" />
	
</portlet:renderURL>

<portlet:renderURL portletMode="view" var="editAppURL">
	<portlet:param name="viewOnly" value="<%=String.valueOf(false)%>" />
	<portlet:param name="creditAppId" value="${creditApp.creditAppId}" />
	<portlet:param name="mvcPath" value="/html/paymentcalculator/view.jsp" />
	
</portlet:renderURL>


<!-- EXISTING APPLICATION -->
	<c:if test="${creditApp.creditAppId != null}">
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
			<div class="span2">
				<a class="btn btn-block btn-small btn-viewApp" id="viewAppButton" href="payment-calculator?creditAppId=${creditApp.creditAppId}&viewOnly=true"><i class="icon-file"></i> View </a>
			</div>
		</c:if>	
		
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==true}">
			<div class="span2">
				<a class="btn btn-block btn-small btn-editApp" id="editAppButton" href="payment-calculator?creditAppId=${creditApp.creditAppId}&viewOnly=false"><i class="icon-file"></i> Edit </a>
			</div>
		</c:if>	
		
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
			<div class="span2">
				<a class="btn btn-block btn-small  btn-save" id="saveApplicationButton" onClick="processAppButton(0)"><i class="icon-save"></i> Save </a>
			</div>
		</c:if>	
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
			<div class="span2">
				<a class="btn btn-block btn-small btn-saveexit" id="exitApplicationButton" href="view-applications" onClick="processAppButton(0)"><i class="icon-signout"></i> Save and Exit </a>
			</div>
		</c:if>
		
		<c:if test="${creditApp.creditAppStatusId == 3  || viewOnly==true}">
			<div class="span2">
				<a class="btn btn-block btn-small btn-saveexit" id="exitApplicationButton" href="view-applications"><i class="icon-signout"></i> View Applications </a>
			</div>
		</c:if>
		
			<div class="span2">
				<a class="btn btn-block btn-small btn-managedocs" id="manageDocsButton" href="manage-documents?creditAppId=${creditApp.creditAppId}"><i class="icon-file"></i> Manage Documents </a>
			</div>
		
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
			<div class="span2">
				<a class="btn btn-success btn-small btn-block btn-submit" id="submitApplicationButton"><i class="icon-ok-sign"></i> Submit </a>
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