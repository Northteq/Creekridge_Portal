package com.tamarack.creekridge.liferay.applicationstable;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;


public class CreditAppWrapper {
	public CreditApp creditApp;
	public long creditAppId;
	public String statusName;
	public String salesRepName;
	
	public CreditAppWrapper (CreditApp creditApp) throws PortalException, SystemException {
		this.creditApp = creditApp;
		this.creditAppId = creditApp.getCreditAppId();
		this.statusName = CreditAppStatusLocalServiceUtil.getCreditAppStatus(creditApp.getCreditAppStatusId()).getCreditAppStatusName();
		this.salesRepName = UserLocalServiceUtil.getUser(creditApp.getUserId()).getFullName();
	}
}
