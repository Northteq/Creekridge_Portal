package com.tamarack.creekridge.liferay.paymentcalculator;

import java.awt.List;

import com.liferay.portal.kernel.util.Validator;
import com.tamarack.creekridge.model.CreditApp;

public class CreditAppValidator {
	public static boolean validateApplication (CreditApp creditApp, List errors) {
		boolean isValid = true;
		
		
		if (Validator.isNull(creditApp.getCustomerName())) {
			errors.add("customer-name-required");
			isValid = false;
		}
		
		
		return isValid;
	}
}
