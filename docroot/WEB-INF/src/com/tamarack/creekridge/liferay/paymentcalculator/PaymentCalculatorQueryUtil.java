package com.tamarack.creekridge.liferay.paymentcalculator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;

public class PaymentCalculatorQueryUtil {
	
	private static Log _log = LogFactory.getLog(PaymentCalculatorQueryUtil.class);

	public List<RateFactorRule> fetchRatefactorOption(String currentSelectedOptions, long vendorId)
			throws Exception {
		
		//main object passed from the page
		JSONObject options = JSONFactoryUtil.createJSONObject(currentSelectedOptions);
		JSONArray productIdList = options.getJSONArray("products");
		JSONArray purchaseOptionIdList = options.getJSONArray("purchaseOptions");
		
		List<RateFactorRule> rateFactorRuleList = new ArrayList <RateFactorRule> ();
	
		
		if (productIdList.length()>0 && purchaseOptionIdList.length()>0) {
			for (int i = 0; i < productIdList.length(); i++) {
				for (int j = 0; j < purchaseOptionIdList.length(); j++) {
					rateFactorRuleList.addAll(RateFactorRuleLocalServiceUtil.getRateFactorRuleByProductPurchaseOptionPrice(true, vendorId, productIdList.getLong(i),  purchaseOptionIdList.getLong(j), 
							options.getDouble("equipmentPrice")));
				}
			}
		} else if (productIdList.length()>0) {
			for (int i = 0; i < productIdList.length(); i++) {
				rateFactorRuleList.addAll(RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorProductPrice(true, vendorId, productIdList.getLong(i),
						options.getDouble("equipmentPrice")));
			}
		}
		
		_log.info("fetchRatefactorOption list: " + rateFactorRuleList);
		
		return rateFactorRuleList;
	}
	
	public List<RateFactorRule> fetchRatefactorOptionForCalculations(
			Long productId, Long purchaseOptionId, Long termId, long eqPrice, long vendorId) throws Exception {

		
		List<RateFactorRule> rateFactorRuleList = RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorProductOptionTermPrice(true, vendorId, productId, purchaseOptionId, termId, eqPrice);
		_log.info("fetchRatefactorOptionForCalculations fetched ratefactorrules: " + rateFactorRuleList);
		
		return rateFactorRuleList;
	}
	
	@SuppressWarnings("unchecked")
	public List <RateFactorRule> fetchActiveProductsForEquipmentPrice (long vendorId, double eqPrice) throws SystemException {
		List<RateFactorRule> rfrList = new ArrayList <RateFactorRule> ();
		_log.info("fetchActiveProductsForEquipmentPrice vendorId: " + vendorId);
		_log.info("fetchActiveProductsForEquipmentPrice eqPrice: " + eqPrice);
		
		DynamicQuery rfrQuery = DynamicQueryFactoryUtil.forClass(
				RateFactorRule.class, PortletClassLoaderUtil.getClassLoader());
		
		
		rfrQuery.add(PropertyFactoryUtil.forName("active").eq(true));
		rfrQuery.add(PropertyFactoryUtil.forName("vendorId").eq(vendorId));
		rfrQuery.add(PropertyFactoryUtil.forName("minPrice").lt(eqPrice));
		
		
		rfrList = RateFactorRuleLocalServiceUtil.dynamicQuery(rfrQuery);
		_log.info("fetchActiveProductsForEquipmentPrice rfrList returned: " + rfrList);
		return rfrList;
		
	}

}
