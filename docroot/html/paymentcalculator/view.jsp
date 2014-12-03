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


<c:if test="${creditApp.creditAppStatusId != 3 && viewOnly==false}">
	<c:import url="/html/paymentcalculator/applicationEdit.jsp"></c:import>
</c:if>

<!-- VIEW MODE -->


<c:if test="${creditApp.creditAppStatusId == 3 || viewMode}">
	<c:import url="/html/paymentcalculator/applicationView.jsp"></c:import>
</c:if>