

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"  %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"  %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"  %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"  %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*"%>
<%@page import="com.liferay.util.*"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>

<!-- Model  -->
<%@page import="com.tamarack.creekridge.model.CreditApp"%>
<%@page import="com.tamarack.creekridge.model.CreditAppPrincipal"%>
<%@page import="com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<script src="<%= renderRequest.getContextPath()%>/js/jquery211.min.js" type="text/javascript"></script>

<link href="http://cdn.alloyui.com/2.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>


