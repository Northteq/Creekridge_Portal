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

package com.tamarack.creekridge.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.tamarack.creekridge.service.ClpSerializer;
import com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;
import com.tamarack.creekridge.service.ProductLocalServiceUtil;
import com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil;
import com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil;
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;
import com.tamarack.creekridge.service.TermLocalServiceUtil;
import com.tamarack.creekridge.service.VendorLocalServiceUtil;
import com.tamarack.creekridge.service.VendorMessageLocalServiceUtil;

/**
 * @author pmacha
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CreditAppLocalServiceUtil.clearService();

			CreditAppBankReferenceLocalServiceUtil.clearService();

			CreditAppDocumentLocalServiceUtil.clearService();

			CreditAppPrincipalLocalServiceUtil.clearService();

			CreditAppStatusLocalServiceUtil.clearService();

			ProductLocalServiceUtil.clearService();

			ProposalOptionLocalServiceUtil.clearService();

			PurchaseOptionLocalServiceUtil.clearService();

			RateFactorRuleLocalServiceUtil.clearService();

			TermLocalServiceUtil.clearService();

			VendorLocalServiceUtil.clearService();

			VendorMessageLocalServiceUtil.clearService();
		}
	}
}