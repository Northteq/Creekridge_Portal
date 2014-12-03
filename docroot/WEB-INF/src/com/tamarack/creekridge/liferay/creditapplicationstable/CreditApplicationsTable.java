package com.tamarack.creekridge.liferay.creditapplicationstable;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.util.bridges.mvc.MVCPortlet;



/**
 * Portlet implementation class CreditApplicationsTable
 */
public class CreditApplicationsTable extends MVCPortlet {
 
	
	private static Log _log = LogFactory.getLog(CreditApplicationsTable.class);
	
	@Override
	
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		_log.info("render started");
		
		
		super.render(renderRequest, renderResponse);
		
		_log.info("render ended");
	}
	
//	public void viewApplication (ActionRequest actionRequest, ActionRequest actionResponse) {
//		//actionResponse.sendRedirect("/payment-calculator");
//	}
}
