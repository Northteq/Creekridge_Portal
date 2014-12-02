/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 * @desctiption Utility class for getting different lists for the page
 */

package com.tamarack.creekridge.liferay.paymentcalculator;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;
=======
=======
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

>>>>>>> master
import javax.portlet.ActionRequest;
>>>>>>> master

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

<<<<<<< HEAD
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;
=======
import com.liferay.portal.kernel.util.ParamUtil;
import com.tamarack.creekridge.model.CreditApp;
<<<<<<< HEAD
>>>>>>> master
=======
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppPrincipal;
>>>>>>> master




public class PaymentCalculatorUtil {
	private static Log _log = LogFactory.getLog(PaymentCalculatorUtil.class);
	
	
<<<<<<< HEAD
	public List<RateFactorRule> fetchRatefactorOptionForCalculations(
			Long prodId, Long optionId, Long termId, Double eqPrice, Long vendorId) throws Exception {
		//main object passed from the page
		
		
		DynamicQuery rateFactorCriteriaQuery = DynamicQueryFactoryUtil
				.forClass(RateFactorRule.class,
						PortletClassLoaderUtil.getClassLoader());
		
		//only rules that are active and belong to a site/vendorId
		Criterion vendorIdCriteria = RestrictionsFactoryUtil.eq("vendorId",
				vendorId);
		Criterion activeFlagCriteria = RestrictionsFactoryUtil.eq("active",
				true);
		
		Criterion crit = RestrictionsFactoryUtil.eq("productId", prodId);
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("purchaseOptionId", optionId));
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("termId", termId));
		
		
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.le("minPrice", eqPrice));
		
		rateFactorCriteriaQuery.add(crit);
		

		rateFactorCriteriaQuery.add(vendorIdCriteria);
		rateFactorCriteriaQuery.add(activeFlagCriteria);
		
		//orderby price
		rateFactorCriteriaQuery.addOrder(OrderFactoryUtil.desc("minPrice"));
		
		
		@SuppressWarnings("unchecked")
		List<RateFactorRule> rateFactorRuleList = RateFactorRuleLocalServiceUtil
				.dynamicQuery(rateFactorCriteriaQuery);
		
		_log.info("fetched ratefactorrules: " + rateFactorRuleList);
		
		return rateFactorRuleList;
=======
	public static CreditApp populateAppFromRequest (ActionRequest actionRequest, CreditApp creditApp) {
		
		//map form fields to the application
		creditApp.setEquipmentPrice(ParamUtil.getDouble(actionRequest, "equipmentPrice"));
		creditApp.setCustomerName(ParamUtil.getString(actionRequest,"customerName"));
		creditApp.setCustomerDBAName(ParamUtil.getString(actionRequest,"customerDBAName"));
		creditApp.setCustomerBusinessDesc(ParamUtil.getString(actionRequest,"customerBusinessDesc"));
		creditApp.setCustomerBusinessFederalTaxID(ParamUtil.getString(actionRequest,"customerBusinessFederalTaxID"));
		creditApp.setCustomerBusinessIncorporatedState(ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date busStartDate=ParamUtil.getDate(actionRequest,"customerBusinessStartDate", dateFormat);
		creditApp.setCustomerBusinessStartDate(busStartDate);
		creditApp.setCustomerBusinessType(ParamUtil.getString(actionRequest,"customerBusinessType"));
		creditApp.setCustomerBusinessIncorporatedState(ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
		creditApp.setCustomerBusinessType(ParamUtil.getString(actionRequest,"customerBusinessType"));
		creditApp.setCustomerAddress1(ParamUtil.getString(actionRequest,"customerAddress1"));
		creditApp.setCustomerAddress2(ParamUtil.getString(actionRequest,"customerAddress1"));
		
		creditApp.setCustomerState(ParamUtil.getString(actionRequest,"customerState"));
		creditApp.setCustomerCity(ParamUtil.getString(actionRequest,"customerCity"));
		creditApp.setCustomerZip(ParamUtil.getString(actionRequest,"customerZip"));
		creditApp.setEquipmentAddress1(ParamUtil.getString(actionRequest,"equipmentAddress1"));
		creditApp.setEquipmentAddress2(ParamUtil.getString(actionRequest,"equipmentAddress2"));
		creditApp.setEquipmentState(ParamUtil.getString(actionRequest,"equipmentState"));
		creditApp.setEquipmentCity(ParamUtil.getString(actionRequest,"equipmentCity"));
		creditApp.setEquipmentZip(ParamUtil.getString(actionRequest,"equipmentZip"));
		creditApp.setEquipmentDesc(ParamUtil.getString(actionRequest,"equipmentDesc"));
		creditApp.setEquipmentLocAsCustomerFlag(ParamUtil.getBoolean(actionRequest,"equipmentLocAsCustomerFlag"));
		
		creditApp.setCustomerContact(ParamUtil.getString(actionRequest,"customerContact"));
		creditApp.setCustomerContactPhone(ParamUtil.getString(actionRequest,"customerContactPhone"));
		creditApp.setCustomerContactFax(ParamUtil.getString(actionRequest,"customerContactFax"));
		creditApp.setCustomerContactEmail(ParamUtil.getString(actionRequest,"customerContactEmail"));
		//_log.info ("populateAppFromRequest: " + creditApp);
		return creditApp;
>>>>>>> master
	}
	
	public static CreditAppPrincipal populatePrincipalFromRequest (ActionRequest actionRequest, CreditAppPrincipal principal) {
		
		principal.setPrincipalFirstName(ParamUtil.getString (actionRequest, "principalFirstName"));
		principal.setPrincipalMiddleName(ParamUtil.getString (actionRequest, "principalMiddleName"));
		principal.setPrincipalLastName(ParamUtil.getString (actionRequest, "principalLastName"));
		principal.setPrincipalSSN(ParamUtil.getString (actionRequest, "principalSSN"));
		principal.setPrincipalHomePhoneNumber(ParamUtil.getString (actionRequest, "principalHomePhoneNumber"));
		principal.setPrincipalAddress1(ParamUtil.getString (actionRequest, "principalAddress1"));
		principal.setPrincipalAddress2(ParamUtil.getString (actionRequest, "principalAddress2"));
		principal.setPrincipalCity(ParamUtil.getString (actionRequest, "principalCity"));
		principal.setPrincipalState(ParamUtil.getString (actionRequest, "principalState"));
		principal.setPrincipalZip(ParamUtil.getString (actionRequest, "principalZip"));
		principal.setPrincipalEmail(ParamUtil.getString (actionRequest, "principalEmail"));
		
		return principal;
	}
	
	public static CreditAppBankReference populateBankReferenceFromRequest (ActionRequest actionRequest, CreditAppBankReference reference) {
		
		reference.setBankReferenceName(ParamUtil.getString(actionRequest,"bankReferenceName"));
		reference.setBankReferenceContact(ParamUtil.getString(actionRequest,"bankReferenceContact"));
		reference.setBankReferencePhone(ParamUtil.getString(actionRequest,"bankReferencePhone"));
		reference.setBankReferenceAccountType(ParamUtil.getString(actionRequest,"bankReferenceAccountType"));
		reference.setBankReferenceAccountNumber(ParamUtil.getString(actionRequest,"bankReferenceAccountNumber"));
		
		return reference;
	}	
	
}
