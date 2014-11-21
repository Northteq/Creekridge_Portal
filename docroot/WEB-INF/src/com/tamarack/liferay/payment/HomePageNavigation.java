package com.tamarack.liferay.payment;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class HomePageNavigation
 */
public class HomePageNavigation extends MVCPortlet {
       
    /**
     * @see MVCPortlet#MVCPortlet()
     */
    public HomePageNavigation() {
        super();
    }
    private static Log _log = LogFactory.getLog(HomePageNavigation.class);


@Override
public void doView(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {
	// TODO Auto-generated method stub
	
	
	super.doView(renderRequest, renderResponse);
	
}
}
