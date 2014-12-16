<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ include file="init.jsp"%>

<%
	HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

	String viewOnlyString = httpReq.getParameter("viewOnly");
			ParamUtil.getString(request, "viewOnly");
	Boolean viewOnly; 
	if (viewOnlyString != null) {
		
	} else {
		viewOnlyString = httpReq.getParameter("viewOnly");
	} 
	
	viewOnly = Boolean.valueOf (viewOnlyString);
	request.setAttribute("viewOnly", viewOnly);	
	
	String openSection = ParamUtil.getString(request, "openSection", "paymentCalculator");
	request.setAttribute("openSection", openSection);
	
	
	long appId = ParamUtil.getLong(request, "creditAppId");
	
	if (appId != 0) {
		request.setAttribute("creditApp", CreditAppLocalServiceUtil.getCreditApp(appId)); 
	}

	State[] statesList=StateUtil.STATES;
	renderRequest.setAttribute("statesList", statesList);
	
	String [] corpTypeList =  {"Corporation", "Sole Prop", "LLC", "LLP", "Partnership", "S Corporation", "Government Entity"};
	renderRequest.setAttribute("corpTypeList", corpTypeList);
	
%>

<script src="<%= renderRequest.getContextPath()%>/js/jquery211.min.js" type="text/javascript"></script>

<link href="http://cdn.alloyui.com/2.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>
<c:import url="/html/paymentcalculator/paymentCalculatorJS.jsp"></c:import>

<c:if test="${creditApp.creditAppStatusId != 3 && viewOnly==false}">
	<c:import url="/html/paymentcalculator/applicationEdit.jsp"></c:import>
	<c:import url="/html/paymentcalculator/termsAndAgreement.jsp"></c:import>
</c:if>

<!-- VIEW MODE -->
<liferay-ui:success key="appSubmitted"
	message="app-submitted-successfully" />

<c:if test="${creditApp.creditAppStatusId == 3 || viewOnly}">
	<c:import url="/html/paymentcalculator/applicationView.jsp"></c:import>
	
</c:if>

