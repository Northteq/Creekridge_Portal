<%--
/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 */
--%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"  %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"  %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"  %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"  %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page import="com.tamarack.creekridge.model.CreditApp"%>
<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.util.*"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>
