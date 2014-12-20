<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"  %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"  %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"  %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"  %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%

	List <User> siteUsers = UserLocalServiceUtil.getGroupUsers(themeDisplay.getLayout().getGroupId());
	renderRequest.setAttribute("siteUsers", siteUsers);

	DLFolder parentFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getLayout().getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Reports");
	List <DLFolder> folders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getLayout().getGroupId(), parentFolder.getFolderId());
	renderRequest.setAttribute("folders", folders);

%>



<liferay-ui:success key="permissionsSaved"
	message="permissions-saved-successfully" />

	
<portlet:actionURL name="changePermissions"
	var="changePermissionsURL">
	
</portlet:actionURL>


<aui:form action="<%=changePermissionsURL %>">
	<aui:select inlineField="true" name="folderId" label="Folder"
		showEmptyOption="true" required="true">
		<c:forEach items="${folders}" var="f">
			<aui:option value="${f.folderId}" label="${f.name}"/>
		</c:forEach>	
	</aui:select>
	<aui:select inlineField="true" name="userId"
		showEmptyOption="true" required="true">
		<c:forEach items="${siteUsers}" var="u">
			<aui:option value="${u.userId}" label="${u.firstName} ${u.lastName} (${u.screenName})"/>
		</c:forEach>	
	</aui:select>
	<aui:button type="submit"></aui:button>
</aui:form>