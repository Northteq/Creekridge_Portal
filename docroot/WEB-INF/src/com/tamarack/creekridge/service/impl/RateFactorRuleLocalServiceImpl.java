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

import java.util.List;

import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.service.base.RateFactorRuleLocalServiceBaseImpl;

/**
 * The implementation of the rate factor rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.tamarack.creekridge.service.RateFactorRuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pmacha
 * @see com.tamarack.creekridge.service.base.RateFactorRuleLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil
 */
public class RateFactorRuleLocalServiceImpl
	extends RateFactorRuleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil} to access the rate factor rule local service.
	 */
	public List<RateFactorRule> getRateFactorRuleByVendorIdActiveStatus(long vendorId, boolean active) throws Exception
	{
		return rateFactorRulePersistence.findByA_V(vendorId, active);
		
	}
	
	public RateFactorRule getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(long vendorId, boolean active,long productId, long termId, long purchaseOptionId) throws Exception
	{
		return rateFactorRulePersistence.findByA_V_P_T_P(active, vendorId, productId, termId, purchaseOptionId);
		
	}
	
	public RateFactorRule getRateFactorRuleByMatchingEquipmentPrice(long vendorId, boolean active,long productId, long termId, long purchaseOptionId, double equipmentPrice) throws Exception
	{
		return rateFactorRulePersistence.findByA_V_P_T_P(active, vendorId, productId, termId, purchaseOptionId);
		
	}
}