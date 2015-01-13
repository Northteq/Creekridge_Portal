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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppStatus;
import com.tamarack.creekridge.service.CreditAppLocalService;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;
import com.tamarack.creekridge.service.base.CreditAppLocalServiceBaseImpl;

/**
 * The implementation of the credit app local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.tamarack.creekridge.service.CreditAppLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pmacha
 * @see com.tamarack.creekridge.service.base.CreditAppLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.CreditAppLocalServiceUtil
 */
public class CreditAppLocalServiceImpl  extends CreditAppLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.tamarack.creekridge.service.CreditAppLocalServiceUtil} to access the credit app local service.
	 */
private static Log _log = LogFactory.getLog(CreditAppLocalService.class);
	
	
/** 
 *  
 * @param user 
 * @param themeDisplay
 * @return CreditApp 
 * @throws SystemException, PortalException
 */ 
	public CreditApp addCreditApp (User user, ThemeDisplay themeDisplay) throws PortalException, SystemException {
		
		CreditApp newApp = creditAppPersistence.create(CounterLocalServiceUtil.increment(CreditApp.class.getName()));
		newApp.setCompanyId(user.getCompanyId());
		newApp.setUserId(user.getUserId());
		newApp.setUserName(user.getScreenName());
		newApp.setModifiedDate(new Date());
		newApp.setCreateDate(new Date());
		newApp.setGroupId (themeDisplay.getLayout().getGroupId());
		newApp.setVendorId (themeDisplay.getLayout().getGroupId());
		newApp.setEquipmentLocAsCustomerFlag(true);
		CreditAppStatus creditAppStatus;
		
		try {
			
			_log.info("getting app status value for \"Draft\"");
			creditAppStatus = CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus("Draft");
			if (creditAppStatus != null) {
				_log.info("\"Draft\" status id found");
				newApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
			}
		} catch (Exception e) {
			_log.error(e);
		}
			
		//resourceLocalService.addResources(newApp.getCompanyId(), newApp.getGroupId(), newApp.getUserId(), CreditApp.class.getName(), 
		//			newApp.getCreditAppId(), false, false, false);
		
		return creditAppPersistence.update(newApp);
		
	}
	
	
	/** 
	  *  
	  * @param standard 
	  * @return List<CreditApp> 
	  * @throws SystemException 
	  */  
	 public List<CreditApp> getCreditAppByGroupId (long groupId) throws SystemException{  
		 return this.creditAppPersistence.findByGroupId(groupId);
	 } 
	 
	 /** 
	  *  
	  * @param standard 
	  * @return List<CreditApp> 
	  * @throws SystemException 
	  */  
	 public List<CreditApp> getCreditAppByGroupIdByUserId (long groupId, long userId) throws SystemException{  
		 return this.creditAppPersistence.findByGroupIdUserId(groupId, userId);
	 } 
	 
	 /** 
	  *  
	  * @param standard 
	  * @return List<CreditApp> 
	  * @throws SystemException 
	  */  
	 public List<CreditApp> getCreditAppByNotDraftByGroupId (long groupId) throws SystemException{  
		 return this.creditAppPersistence.findByNotDraftGroupId(groupId);
	 } 
	 
	 /** 
	  *  
	  * @param standard 
	  * @return List<CreditApp> 
	  * @throws SystemException 
	  */  
	 public List<CreditApp> getCreditAppByNotDraftByGroupIdUserId (long groupId, long userId) throws SystemException{  
		 return this.creditAppPersistence.findByNotDraftGroupIdUserId(groupId, userId);
	 } 
}