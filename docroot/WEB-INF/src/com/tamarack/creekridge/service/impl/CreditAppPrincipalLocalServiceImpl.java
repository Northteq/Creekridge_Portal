/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.tamarack.creekridge.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.CreditAppStatus;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;
import com.tamarack.creekridge.service.base.CreditAppPrincipalLocalServiceBaseImpl;

/**
 * The implementation of the credit app principal local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.tamarack.creekridge.service.CreditAppPrincipalLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pmacha
 * @see com.tamarack.creekridge.service.base.CreditAppPrincipalLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil
 */
public class CreditAppPrincipalLocalServiceImpl
	extends CreditAppPrincipalLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil} to access the credit app principal local service.
	 */
	
	/*public List<CreditAppPrincipal> getCreditAppPrincipalByCreditAppId(long creditAppId) throws Exception
	{
		List<CreditAppPrincipal> principalList=new ArrayList<CreditAppPrincipal>();
		 principalList=creditAppPrincipalPersistence.findByCreditAppId(creditAppId);
		return principalList;
		
	}
*/
	
	 public List<CreditAppPrincipal>  getCreditAppPrincipalByCreditAppId( long creditAppId)  throws Exception {
		return creditAppPrincipalPersistence.findByCreditAppId(creditAppId); 
	 }
	 
	 /** 
	  * @author olegforce
	  * @param user 
	  * @param themeDisplay
	  * @return CreditApp 
	  * @throws SystemException, PortalException
	  */ 
	 	public CreditAppPrincipal addCreditAppPrincipal (User user, ThemeDisplay themeDisplay) throws PortalException, SystemException {
	 		
	 		CreditAppPrincipal newPrincipal = creditAppPrincipalPersistence.create(CounterLocalServiceUtil.increment(CreditAppPrincipal.class.getName()));
	 		newPrincipal.setCompanyId(user.getCompanyId());
	 		newPrincipal.setUserId(user.getUserId());
	 		newPrincipal.setUserName(user.getScreenName());
	 		newPrincipal.setModifiedDate(new Date());
	 		newPrincipal.setCreateDate(new Date());
	 		//newPrincipal.setGroupId (themeDisplay.getLayout().getGroupId());
	 		//newPrincipal.setVendorId (themeDisplay.getLayout().getGroupId());
	 		
	 		return creditAppPrincipalPersistence.update(newPrincipal);
	 		
	 	}
	
}