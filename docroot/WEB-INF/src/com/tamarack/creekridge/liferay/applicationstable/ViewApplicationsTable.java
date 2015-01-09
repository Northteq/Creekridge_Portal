package com.tamarack.creekridge.liferay.applicationstable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;
import com.tamarack.creekridge.liferay.paymentcalculator.PaymentCalculatorUtil;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppStatus;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;


/**
 * Portlet implementation class ViewApplicationsTable
 */
public class ViewApplicationsTable extends MVCPortlet {
	
	private static Log _log = LogFactory.getLog(ViewApplicationsTable.class);

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
				List <CreditApp> creditAppList = CreditAppLocalServiceUtil.getCreditAppByGroupId(groupId);
				List <CreditAppWrapper> creditApps = new ArrayList<CreditAppWrapper>();
				if (creditAppList != null) {
					for (CreditApp creditApp:creditAppList) {
						creditApps.add(new CreditAppWrapper(creditApp));
					}
				}
				
				String creditAppJson = "{\"data\":" + JSONFactoryUtil.looseSerialize(creditApps) + "}";
				resourceResponse.getWriter().write(creditAppJson);
				_log.info ("getCreditApplicationsJson sending apps back \n" +  creditAppJson);
				
			} catch (Exception e) {
				_log.error(e.getMessage());
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
			
		}
		
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	public void cancelApplication (ActionRequest actionRequest, ActionResponse actionResponse) {
		
		_log.info("cancelApplication called");
		CreditApp creditApp = null;
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		
		try {
			_log.info("cancelApplication creditAppId: " + creditAppId);
			creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			creditApp.setCreditAppStatusId(4);
			CreditAppLocalServiceUtil.updateCreditApp(creditApp);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}
}
