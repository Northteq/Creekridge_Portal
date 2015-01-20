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
<<<<<<< HEAD
	<c:if test="${creditAppId != null}"><h3>Application ${creditAppId} </h3> 
	
		<div class="span2">
			<button type="submit" class="btn btn-success" id="createApplicationButton"> Update Application </button>
=======
	<c:if test="${creditApp.creditAppId != null}">
<<<<<<< HEAD
<<<<<<< HEAD
	
		<div class="span2">
			<button type="submit" class="btn btn-info" id="createApplicationButton"> Update Application </button>
>>>>>>> master
		</div>
=======
		<c:if test="${creditApp.creditAppStatusId != 3}">
=======
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
>>>>>>> master
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
<<<<<<< HEAD
>>>>>>> master
=======
		</c:if>	
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
			<div class="span2">
				<a class="btn btn-block btn-small btn-saveexit" id="exitApplicationButton" onClick="processAppButton(1)"><i class="icon-signout"></i> Save and Exit </a>
			</div>
		</c:if>
>>>>>>> master
		
		<c:if test="${creditApp.creditAppStatusId == 3  || viewOnly==true}">
			<div class="span2">
				<a class="btn btn-block btn-small btn-saveexit" id="exitApplicationButton" href="view-applications"><i class="icon-signout"></i> View Applications </a>
			</div>
		</c:if>
		
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
			<div class="span2">
				<a class="btn btn-block btn-small btn-managedocs" id="manageDocsButton" onClick="processAppButton(3)"><i class="icon-file"></i> Manage Documents </a>
			</div>
		</c:if>
		
		<c:if test="${viewOnly==true}">
			<div class="span2">
				<a class="btn btn-block btn-small btn-managedocs" id="manageDocsButton" href="manage-documents?creditAppId=${creditApp.creditAppId}"><i class="icon-file"></i> Manage Documents </a>
			</div>
		</c:if>
		
		<c:if test="${creditApp.creditAppStatusId == 2  && viewOnly==false}">
			<div class="span2">
				<a class="btn btn-success btn-small btn-block btn-submit" id="submitApplicationButton"><i class="icon-ok-sign"></i> Submit </a>
			</div>
		</c:if>	
		
	</c:if>
	
<<<<<<< HEAD
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
	
	
	
=======
>>>>>>> master
	<div style="clear:both"> </div>
	<p/>
