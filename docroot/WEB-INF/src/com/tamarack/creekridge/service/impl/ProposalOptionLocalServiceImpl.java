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
import com.tamarack.creekridge.model.ProposalOption;
import com.tamarack.creekridge.service.ProposalOptionLocalService;
import com.tamarack.creekridge.service.base.ProposalOptionLocalServiceBaseImpl;

/**
 * The implementation of the proposal option local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.tamarack.creekridge.service.ProposalOptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pmacha
 * @see com.tamarack.creekridge.service.base.ProposalOptionLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil
 */
public class ProposalOptionLocalServiceImpl
	extends ProposalOptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil} to access the proposal option local service.
	 */
   public List<ProposalOption> getProposalOptionByCreditAppId(long creditAppId) throws Exception{
	   return proposalOptionPersistence.findByCreditAppId(creditAppId);
   }
   
   
   @SuppressWarnings("unused")
   private static Log _log = LogFactory.getLog(ProposalOptionLocalService.class);
	
	
   /** 
    *  
    * @param user 
    * @param themeDisplay
    * @return CreditApp 
    * @throws SystemException, PortalException
    */ 
   	public ProposalOption addProposalOption (User user, ThemeDisplay themeDisplay) throws PortalException, SystemException {
   		
   		ProposalOption newOp = proposalOptionPersistence.create(CounterLocalServiceUtil.increment(ProposalOption.class.getName()));
   		
   		newOp.setCompanyId(user.getCompanyId());
   		newOp.setUserId(user.getUserId());
   		newOp.setUserName(user.getScreenName());
   		newOp.setModifiedDate(new Date());
   		newOp.setCreateDate(new Date());
   		
   			
   		//resourceLocalService.addResources(newApp.getCompanyId(), newApp.getGroupId(), newApp.getUserId(), CreditApp.class.getName(), 
   		//			newApp.getCreditAppId(), false, false, false);
   		
   		
   		//removed 1-19-15 to avoid creating empty propoptions
   		//return proposalOptionPersistence.update(newOp);
   		return newOp;
   		
   	}
}