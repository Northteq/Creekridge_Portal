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

package com.tamarack.creekridge.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil;

/**
 * @author pmacha
 * @generated
 */
public abstract class CreditAppDocumentActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CreditAppDocumentActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CreditAppDocumentLocalServiceUtil.getService());
		setClass(CreditAppDocument.class);

		setClassLoader(com.tamarack.creekridge.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("CreditAppDocumentId");
	}
}