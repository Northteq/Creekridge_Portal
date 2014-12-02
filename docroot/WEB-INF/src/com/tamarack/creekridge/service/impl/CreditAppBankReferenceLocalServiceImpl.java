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
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.service.base.CreditAppBankReferenceLocalServiceBaseImpl;

/**
 * The implementation of the credit app bank reference local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.tamarack.creekridge.service.CreditAppBankReferenceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pmacha
 * @see com.tamarack.creekridge.service.base.CreditAppBankReferenceLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil
 */
public class CreditAppBankReferenceLocalServiceImpl
	extends CreditAppBankReferenceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil} to access the credit app bank reference local service.
	 */
	
	public List<CreditAppBankReference> getCreditAppBankReferenceByCreditApp(long creditAppId) throws Exception
	{
		return creditAppBankReferencePersistence.findByCreditAppId(creditAppId);
		
	}
	
	/** 
	  * @author olegforce
	  * @param user 
	  * @param themeDisplay
	  * @return CreditApp 
	  * @throws SystemException, PortalException
	  */ 
	 	public CreditAppBankReference addCreditAppBankReference (User user, ThemeDisplay themeDisplay) throws PortalException, SystemException {
	 		
	 		CreditAppBankReference newReference = creditAppBankReferencePersistence.create(CounterLocalServiceUtil.increment(CreditAppBankReference.class.getName()));
	 		newReference.setCompanyId(user.getCompanyId());
	 		newReference.setUserId(user.getUserId());
	 		newReference.setUserName(user.getScreenName());
	 		newReference.setModifiedDate(new Date());
	 		newReference.setCreateDate(new Date());
	 		//newPrincipal.setGroupId (themeDisplay.getLayout().getGroupId());
	 		//newPrincipal.setVendorId (themeDisplay.getLayout().getGroupId());
	 		
	 		return creditAppBankReferencePersistence.update(newReference);
	 		
	 	}
	
}