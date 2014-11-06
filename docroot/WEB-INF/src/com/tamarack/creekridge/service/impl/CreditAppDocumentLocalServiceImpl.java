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

import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.service.base.CreditAppDocumentLocalServiceBaseImpl;

/**
 * The implementation of the credit app document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.tamarack.creekridge.service.CreditAppDocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pmacha
 * @see com.tamarack.creekridge.service.base.CreditAppDocumentLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil
 */
public class CreditAppDocumentLocalServiceImpl
	extends CreditAppDocumentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil} to access the credit app document local service.
	 */
	
	public List<CreditAppDocument> getCreditAppDocumentByCreditAppId( long creditAppId) throws Exception {
		return creditAppDocumentPersistence.findByCreditAppId(creditAppId);
	}
}