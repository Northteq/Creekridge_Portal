/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 * @desctiption Utility class for getting different lists for the page
 */

package com.tamarack.creekridge.liferay.paymentcalculator;

import javax.portlet.ActionRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.tamarack.creekridge.model.CreditApp;




public class PaymentCalculatorUtil {
	private static Log _log = LogFactory.getLog(PaymentCalculatorUtil.class);
	
	
	public static CreditApp populateAppFromRequest (ActionRequest actionRequest, CreditApp creditApp) {
		
		//map form fields to the application
		creditApp.setEquipmentPrice(ParamUtil.getDouble(actionRequest, "equipmentPrice"));
		creditApp.setCustomerName(ParamUtil.getString(actionRequest,"customerName"));
		creditApp.setCustomerDBAName(ParamUtil.getString(actionRequest,"customerDBAName"));
		
		/*
		 * 
		 * 
						long purchaseOptionId=ParamUtil.getLong(actionRequest,"purchaseOptionId");
						long termId=ParamUtil.getLong(actionRequest,"termId");
						long ratefactorId=ParamUtil.getLong(actionRequest,"ratefactorId");
						double equipmentPrice=ParamUtil.getDouble(actionRequest,"equipmentPrice");
						
						RateFactorRule rateFactorRule= (RateFactorRule) RateFactorRuleLocalServiceUtil.getRateFactorRuleByMatchingEquipmentPrice(0, true, productId, termId, purchaseOptionId, equipmentPrice);
						request.getSession().setAttribute("rateFactorRuleId",new Long(rateFactorRule.getRateFactorRuleId()).toString());	
						request.getSession().setAttribute("equipmentPrice",equipmentPrice);	
						
						Double rateFactorValue=rateFactorRule.getRateFactor();
						Double paymentAmount= rateFactorValue *1;
						// Auditing Values
				
						
						
						CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus(actionType);
						creditApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
						creditApp.setCustomerBusinessDesc(ParamUtil.getString(actionRequest,"customerBusinessDesc"));
						creditApp.setCustomerBusinessFederalTaxID(ParamUtil.getString(actionRequest,"customerBusinessFederalTaxID"));
						creditApp.setCustomerBusinessIncorporatedState(ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
						sdf.setLenient(true);
						Date customerBusinessStartDate = null;
						customerBusinessStartDate = sdf.parse(ParamUtil.getString(actionRequest,"customerBusinessStartDate"));
						creditApp.setCustomerBusinessStartDate(customerBusinessStartDate);
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
						
						request.getSession().setAttribute("customerBusinessDesc",ParamUtil.getString(actionRequest,"customerBusinessDesc"));
						request.getSession().setAttribute("customerBusinessFederalTaxID",ParamUtil.getString(actionRequest,"customerBusinessFederalTaxID"));
						request.getSession().setAttribute("customerBusinessIncorporatedState",ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
						request.getSession().setAttribute("customerBusinessStartDate",ParamUtil.getString(actionRequest,"customerBusinessStartDate"));
						request.getSession().setAttribute("customerBusinessType",ParamUtil.getString(actionRequest,"customerBusinessType"));
						request.getSession().setAttribute("customerAddress1",ParamUtil.getString(actionRequest,"customerAddress1"));
						request.getSession().setAttribute("customerAddress1",ParamUtil.getString(actionRequest,"customerAddress1"));
						
						
						
						
						request.getSession().setAttribute("customerState",ParamUtil.getString(actionRequest,"customerState"));
						request.getSession().setAttribute("customerCity",ParamUtil.getString(actionRequest,"customerCity"));
						request.getSession().setAttribute("customerZip",ParamUtil.getString(actionRequest,"customerZip"));
						request.getSession().setAttribute("equipmentAddress1",ParamUtil.getString(actionRequest,"equipmentAddress1"));
						request.getSession().setAttribute("equipmentAddress2",ParamUtil.getString(actionRequest,"equipmentAddress2"));
						request.getSession().setAttribute("equipmentState",ParamUtil.getString(actionRequest,"equipmentState"));
						request.getSession().setAttribute("equipmentCity",ParamUtil.getString(actionRequest,"equipmentCity"));
						request.getSession().setAttribute("equipmentZip",ParamUtil.getString(actionRequest,"equipmentZip"));
						request.getSession().setAttribute("equipmentDesc",ParamUtil.getString(actionRequest,"equipmentDesc"));
						request.getSession().setAttribute("equipmentLocAsCustomerFlag",ParamUtil.getBoolean(actionRequest,"equipmentLocAsCustomerFlag"));
						request.getSession().setAttribute("equipmentPrice",ParamUtil.getDouble(actionRequest,"equipmentPrice"));
						request.getSession().setAttribute("actionType",ParamUtil.getString(actionRequest,"actionType"));
						creditApp.setVendorId(rateFactorRule.getVendorId());
		*/
		
		
		return creditApp;
	}
	
}
