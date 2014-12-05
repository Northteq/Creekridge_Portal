/**
 * Copyright (c) 2000-present Tamarack, Inc. All rights reserved.
 * @author tamarack
 * @desctiption Utility class for getting different lists for the page
 */

package com.tamarack.creekridge.liferay.paymentcalculator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ResourceRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalService;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;




public class PaymentCalculatorUtil {
	
	private static Log _log = LogFactory.getLog(PaymentCalculatorUtil.class);
	
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
		
		if(actionRequest.getParameter("equipmentLocAsCustomerFlag") != null)
			creditApp.setEquipmentLocAsCustomerFlag(ParamUtil.getBoolean(actionRequest,"equipmentLocAsCustomerFlag"));
		
		creditApp.setCustomerContact(ParamUtil.getString(actionRequest,"customerContact"));
		creditApp.setCustomerContactPhone(ParamUtil.getString(actionRequest,"customerContactPhone"));
		creditApp.setCustomerContactFax(ParamUtil.getString(actionRequest,"customerContactFax"));
		creditApp.setCustomerContactEmail(ParamUtil.getString(actionRequest,"customerContactEmail"));
		//_log.info ("populateAppFromRequest: " + creditApp);
		return creditApp;
	}
	
	
	
	public static CreditAppBankReference populateBankReferenceFromJsonString (String referenceJson, CreditAppBankReference reference) throws JSONException {
		JSONObject referenceJObj = JSONFactoryUtil.createJSONObject(referenceJson);
		reference.setCreditAppId(Long.valueOf(referenceJObj.getString("creditAppId")));
		reference.setBankReferenceName(referenceJObj.getString("bankReferenceName"));
		reference.setBankReferenceContact(referenceJObj.getString("bankReferenceContact"));
		reference.setBankReferencePhone(referenceJObj.getString("bankReferencePhone"));
		reference.setBankReferenceAccountType(referenceJObj.getString("bankReferenceAccountType"));
		reference.setBankReferenceAccountNumber(referenceJObj.getString("bankReferenceAccountNumber"));
		
		return reference;
	}	
	
	public static CreditAppPrincipal populatePrincipalFromJsonString (String principalJson, CreditAppPrincipal principal) throws JSONException {
	
			JSONObject principalJObj = JSONFactoryUtil.createJSONObject(principalJson);
			
			principal.setCreditAppId(Long.valueOf(principalJObj.getString("creditAppId")));
			principal.setPrincipalFirstName(principalJObj.getString("principalFirstName"));
			principal.setPrincipalMiddleName(principalJObj.getString("principalMiddleName"));
			principal.setPrincipalLastName(principalJObj.getString("principalLastName"));
			principal.setPrincipalSSN(principalJObj.getString("principalSSN"));
			principal.setPrincipalHomePhoneNumber(principalJObj.getString("principalHomePhoneNumber"));
			principal.setPrincipalAddress1(principalJObj.getString("principalAddress1"));
			principal.setPrincipalAddress2(principalJObj.getString("principalAddress2"));
			principal.setPrincipalCity(principalJObj.getString("principalCity"));
			principal.setPrincipalState(principalJObj.getString("principalState"));
			principal.setPrincipalZip(principalJObj.getString("principalZip"));
			principal.setPrincipalEmail(principalJObj.getString("principalEmail"));
			
		return principal;
		
	}
	
}
