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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppPrincipal;




public class PaymentCalculatorUtil {
	private static Log _log = LogFactory.getLog(PaymentCalculatorUtil.class);
	
	
	public static CreditApp populateAppFromRequest (ActionRequest actionRequest, CreditApp creditApp) {
		
		//map form fields to the application
		_log.info("setting price" + ParamUtil.getDouble(actionRequest, "equipmentPrice"));
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
