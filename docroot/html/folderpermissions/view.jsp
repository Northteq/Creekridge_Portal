<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"  %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"  %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"  %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"  %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects /><portlet:defineObjects/>
<liferay-theme:defineObjects/>


<liferay-ui:success key="permissionsSaved"
	message="saved-successfully" />

	
<portlet:actionURL name="changePermissions"
	var="changePermissionsURL">
	
</portlet:actionURL>


<aui:form action="<%=changePermissionsURL %>">
	<aui:input name="folderId" label="Folder Id"/>
	<aui:input name="userId" label="User Id"/>
	<aui:button type="submit"></aui:button>
</aui:form>