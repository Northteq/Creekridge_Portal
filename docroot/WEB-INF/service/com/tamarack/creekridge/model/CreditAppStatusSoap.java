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

package com.tamarack.creekridge.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pmacha
 * @generated
 */
public class CreditAppStatusSoap implements Serializable {
	public static CreditAppStatusSoap toSoapModel(CreditAppStatus model) {
		CreditAppStatusSoap soapModel = new CreditAppStatusSoap();

		soapModel.setCreditAppStatusId(model.getCreditAppStatusId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreditAppStatusName(model.getCreditAppStatusName());

		return soapModel;
	}

	public static CreditAppStatusSoap[] toSoapModels(CreditAppStatus[] models) {
		CreditAppStatusSoap[] soapModels = new CreditAppStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditAppStatusSoap[][] toSoapModels(
		CreditAppStatus[][] models) {
		CreditAppStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreditAppStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditAppStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditAppStatusSoap[] toSoapModels(
		List<CreditAppStatus> models) {
		List<CreditAppStatusSoap> soapModels = new ArrayList<CreditAppStatusSoap>(models.size());

		for (CreditAppStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreditAppStatusSoap[soapModels.size()]);
	}

	public CreditAppStatusSoap() {
	}

	public long getPrimaryKey() {
		return _CreditAppStatusId;
	}

	public void setPrimaryKey(long pk) {
		setCreditAppStatusId(pk);
	}

	public long getCreditAppStatusId() {
		return _CreditAppStatusId;
	}

	public void setCreditAppStatusId(long CreditAppStatusId) {
		_CreditAppStatusId = CreditAppStatusId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCreditAppStatusName() {
		return _creditAppStatusName;
	}

	public void setCreditAppStatusName(String creditAppStatusName) {
		_creditAppStatusName = creditAppStatusName;
	}

	private long _CreditAppStatusId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _creditAppStatusName;
}