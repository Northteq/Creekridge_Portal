package com.tamarack.creekridge.liferay.paymentcalculator;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
					rateFactorRuleList.addAll(RateFactorRuleLocalServiceUtil.getRateFactorRuleByProductPurchaseOption(true, vendorId, productIdList.getLong(i),  purchaseOptionIdList.getLong(j)));
				}
			}
		} else if (productIdList.length()>0) {
			for (int i = 0; i < productIdList.length(); i++) {
				rateFactorRuleList.addAll(RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorProduct(true, vendorId, productIdList.getLong(i)));
			}
		}

		return rateFactorRuleList;
	}
	
	public List<RateFactorRule> fetchRatefactorOptionForCalculations(
			Long productId, Long purchaseOptionId, Long termId, long eqPrice, long vendorId) throws Exception {

		
		List<RateFactorRule> rateFactorRuleList = RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorProductOptionTermPrice(true, vendorId, productId, purchaseOptionId, termId, eqPrice);
		_log.info("fetchRatefactorOptionForCalculations fetched ratefactorrules: " + rateFactorRuleList);
		
		return rateFactorRuleList;
	}

}
