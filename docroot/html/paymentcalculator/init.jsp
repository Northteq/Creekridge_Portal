

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"  %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"  %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"  %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"  %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*"%>
<<<<<<< HEAD
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
=======
<%@page import="com.liferay.util.*"%>
<%@page import="java.text.NumberFormat" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>

<!-- Model  -->
<%@page import="com.tamarack.creekridge.model.CreditApp"%>
<<<<<<< HEAD
>>>>>>> master
=======
<%@page import="com.tamarack.creekridge.model.CreditAppPrincipal"%>
<%@page import="com.tamarack.creekridge.model.CreditAppBankReference"%>
<%@page import="com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil;" %>

>>>>>>> master
<portlet:defineObjects/>
<liferay-theme:defineObjects/>


