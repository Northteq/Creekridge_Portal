package com.tamarack.creekridge.liferay.applicationstable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;


/**
 * Portlet implementation class ViewApplicationsTable
 */
public class ViewApplicationsTable extends MVCPortlet {
	
	private static Log _log = LogFactory.getLog(ViewApplicationsTable.class);
	boolean isCreekRidgeSalesManager = false;
	boolean isVendorSaleRep = false;
	
	@Override 
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getLayout().getGroupId();

			List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId());
			List<UserGroupRole> siteRoles = new ArrayList<UserGroupRole>();
			
			for (UserGroupRole userGroupRole : userGroupRoles) {
				int roleType = userGroupRole.getRole().getType();
				if (roleType == com.liferay.portal.model.RoleConstants.TYPE_SITE) {
		 			siteRoles.add(userGroupRole);
		 			System.out.println(" Custom Role "+userGroupRole.getRole().getName());
		 			if("salesManager".equalsIgnoreCase(userGroupRole.getRole().getName())){
			 			isCreekRidgeSalesManager=true;
						break;
					}
		 		}
			}
			
			if(!isCreekRidgeSalesManager) {
				for (UserGroupRole userGroupRole : userGroupRoles) {
					int roleType = userGroupRole.getRole().getType();
						if (roleType == RoleConstants.TYPE_SITE) {
			 			siteRoles.add(userGroupRole);
			 			System.out.println(" Custom Role "+userGroupRole.getRole().getName());
			 			if("salesRep".equalsIgnoreCase(userGroupRole.getRole().getName())){
							isVendorSaleRep=true;
							break;
				         }
			          }
			      }
		  	} //if !isCreekRidgeSalesManager
			
	
			
			
			Set <String> repNames = new HashSet<String>();
			
			List <User> siteUsers = UserLocalServiceUtil.getGroupUsers(groupId);
			
			for (User u : siteUsers) {
				repNames.add(u.getFullName());
			}
			
			List <String> siteUserList = new ArrayList<String>();
			
			for (Object o : repNames) {
				siteUserList.add(o.toString());
			}
			
			renderRequest.setAttribute("siteUsers", JSONFactoryUtil.looseSerialize(repNames));
			renderRequest.setAttribute("isVendorSaleRep", isVendorSaleRep);
			renderRequest.setAttribute("isCreekRidgeSalesManager", isCreekRidgeSalesManager);
			
		} catch (Exception e) {
			_log.error("error in render");
			_log.error(e);
			e.printStackTrace();
		}
		
		
		super.render(renderRequest, renderResponse);
	}
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		
		_log.info(resourceRequest.getResourceID());
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		
		if (resourceRequest.getResourceID().equalsIgnoreCase(
				"getCreditApplicationsJson")) {
			try {
				_log.info ("getCreditApplicationsJson called");
				List <CreditApp> creditAppList;
				if (!isVendorSaleRep) {
					creditAppList = CreditAppLocalServiceUtil.getCreditAppByNotDraftByGroupId(groupId);  
				} else {
					creditAppList = CreditAppLocalServiceUtil.getCreditAppByNotDraftByGroupIdUserId (groupId, themeDisplay.getUser().getUserId());
				}  
				 
				List <CreditAppWrapper> creditApps = new ArrayList<CreditAppWrapper>();
				
				if (creditAppList != null) {
					for (CreditApp creditApp:creditAppList) {
						CreditAppWrapper caw = new CreditAppWrapper(creditApp);
						creditApps.add(caw);
						
					}
				}
				
				String creditAppJson = "{ \"data\":" + JSONFactoryUtil.looseSerialize(creditApps) + "}";
				resourceResponse.getWriter().write(creditAppJson);
				_log.info ("getCreditApplicationsJson sending apps back \n" +  creditAppJson);
				
			} catch (Exception e) {
				_log.error(e.getMessage());
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
			
		}
		
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	public void changeApplicationStatus (ActionRequest actionRequest, ActionResponse actionResponse) {
		
		_log.info("changeApplicationStatus called");
		CreditApp creditApp = null;
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		long statusId =  ParamUtil.getLong(actionRequest, "statusId");
		try {
			_log.info("changeApplicationStatus creditAppId: " + creditAppId);
			_log.info("changeApplicationStatus statusId: " + statusId);
			creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			creditApp.setCreditAppStatusId(statusId);
			CreditAppLocalServiceUtil.updateCreditApp(creditApp);
			
		} catch (Exception e) {
			_log.error(e);
		}	
	}
}
