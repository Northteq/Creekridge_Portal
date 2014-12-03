<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ include file="init.jsp"%>

<%
	Boolean viewMode = ParamUtil.getBoolean(request, "viewOnly");
	request.setAttribute("viewOnly", viewMode);	
%>

<script src="<%= renderRequest.getContextPath()%>/js/jquery211.min.js" type="text/javascript"></script>

<link href="http://cdn.alloyui.com/2.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>


<c:if test="${creditApp.creditAppStatusId != 3 && viewOnly==false}">
	<c:import url="/html/paymentcalculator/applicationEdit.jsp"></c:import>
</c:if>

<!-- VIEW MODE -->


<c:if test="${creditApp.creditAppStatusId == 3 || viewMode}">
	<c:import url="/html/paymentcalculator/applicationView.jsp"></c:import>
</c:if>
