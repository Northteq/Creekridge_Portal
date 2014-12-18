package com.tamarack.creekridge.folderpermissions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class FolderPermissions
 */

/**
 * Portlet implementation class FolderPermissions
 */
public class FolderPermissions extends MVCPortlet {
	private static Log _log = LogFactory.getLog(FolderPermissions.class);
	public void changePermissions (ActionRequest actionRequest, ActionResponse actionResponse) {
		
		try {
			long folderId = ParamUtil.getLong(actionRequest, "folderId");
			long userId = ParamUtil.getLong(actionRequest, "userId");
			
			DLFolder folder = DLFolderLocalServiceUtil.getFolder(folderId);
			User u = UserLocalServiceUtil.getUser(userId);
			
			ResourcePermission resourcePermission = null;
			
			resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(u.getCompanyId(),
				    DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(folder.getPrimaryKey()),10166);
			_log.info(resourcePermission);  
			
			// resourcePermission = ResourcePermissionLocalServiceUtil.createResourcePermission(CounterLocalServiceUtil.increment());
			 resourcePermission.setCompanyId(u.getCompanyId());
		     resourcePermission.setName(DLFolder.class.getName());
		    // resourcePermission.setScope(ResourceConstants. SCOPE_INDIVIDUAL);
		     resourcePermission.setPrimKey(String.valueOf(folder.getPrimaryKey()));
		     resourcePermission.setRoleId(10166);
		     resourcePermission.setOwnerId(userId);
		    
		     ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFolder.class.getName(), ActionKeys.VIEW);
		     resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
		     //ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
		     ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
			
			_log.info(folder);
			//Portal_ResourcePermissionService.
			
			//setIndividualResourcePermissions(long groupId, long companyId, String name, String primKey, long roleId, String[] actionIds)
			//com.liferay.portlet.documentlibrary.model.DLFolder
			
			SessionMessages.add(actionRequest, "permissionsSaved");
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "genericError");
			_log.error(e);
		}	
		
		
	}

}

