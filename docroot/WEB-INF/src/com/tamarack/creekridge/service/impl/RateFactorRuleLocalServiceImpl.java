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

import com.liferay.portal.kernel.exception.SystemException;
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
 * @author tamarack consulting
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
	public List<RateFactorRule> getRateFactorRuleByVendor(long vendorId, boolean active) throws Exception
	{
		return rateFactorRulePersistence.findByVendor(active, vendorId);
		
	}
	
	public List <RateFactorRule> getRateFactorRuleByProductPurchaseOption  (Boolean active, long vendorId, long productId, long purchaseOptionId) throws SystemException
	{		
		return rateFactorRulePersistence.findByVendorProductPurchaseOption(active, vendorId, productId, purchaseOptionId);

	}
	
	public List <RateFactorRule> getRateFactorRuleByVendorProduct (Boolean active, long vendorId, long productId) throws SystemException
	{		
		return rateFactorRulePersistence.findByVendorProduct(active, vendorId, productId);
	}
	
	public List<RateFactorRule> getRateFactorRuleByVendorProductOptionTermPrice (Boolean active, long vendorId ,long productId, long purchaseOptionId, long termId, long minPrice) throws Exception
	{
		return rateFactorRulePersistence.findByVendorProductOptionTermPrice(active, vendorId, productId, purchaseOptionId, termId, minPrice);
		
	}

}