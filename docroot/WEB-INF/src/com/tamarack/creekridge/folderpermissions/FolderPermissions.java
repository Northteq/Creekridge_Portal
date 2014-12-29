package com.tamarack.creekridge.folderpermissions;



import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class FolderPermissions
 */

/**
 * Portlet implementation class FolderPermissions
 * http://itsliferay.blogspot.in/2012/11/add-resource-permission-in-lr-61.html
 */
public class FolderPermissions extends MVCPortlet {
	private static Log _log = LogFactory.getLog(FolderPermissions.class);
	
	
	public void changePermissions (ActionRequest actionRequest, ActionResponse actionResponse) {
		
		try {
			
			if (actionRequest.getMethod() == "GET") {
				SessionMessages.clear(actionRequest);
				return;
			}
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			
			long folderId = ParamUtil.getLong(actionRequest, "folderId");
			long userId = ParamUtil.getLong(actionRequest, "userId");
			
			Role ownerRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), "Owner");
			
			DLFolder folder = DLFolderLocalServiceUtil.getFolder(folderId);
			
			folder.setUserId(userId);
			
			DLFolderLocalServiceUtil.updateDLFolder(folder);
			
			ResourcePermission resourcePermissionView = null;
			
			resourcePermissionView = ResourcePermissionLocalServiceUtil.getResourcePermission(folder.getCompanyId(),
				    DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(folder.getPrimaryKey()), ownerRole.getRoleId());

			resourcePermissionView.setOwnerId(userId);
			
			ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermissionView);
			
		    			
			//in case admin forgot to set perms
			String [] actionsArrayString = {"VIEW", "ACCESS"};
			ResourcePermissionLocalServiceUtil.setOwnerResourcePermissions (folder.getCompanyId(), DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(folder.getPrimaryKey()),
					ownerRole.getRoleId(), userId, actionsArrayString);

			SessionMessages.add(actionRequest, "permissionsSaved");
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "genericError");
			_log.error(e);
		}	
		
		
	}

}

