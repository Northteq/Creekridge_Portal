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
public class PurchaseOptionSoap implements Serializable {
	public static PurchaseOptionSoap toSoapModel(PurchaseOption model) {
		PurchaseOptionSoap soapModel = new PurchaseOptionSoap();

		soapModel.setPurchaseOptionId(model.getPurchaseOptionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPurchaseOptionName(model.getPurchaseOptionName());
		soapModel.setSequenceNumber(model.getSequenceNumber());

		return soapModel;
	}

	public static PurchaseOptionSoap[] toSoapModels(PurchaseOption[] models) {
		PurchaseOptionSoap[] soapModels = new PurchaseOptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseOptionSoap[][] toSoapModels(PurchaseOption[][] models) {
		PurchaseOptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseOptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseOptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseOptionSoap[] toSoapModels(List<PurchaseOption> models) {
		List<PurchaseOptionSoap> soapModels = new ArrayList<PurchaseOptionSoap>(models.size());

		for (PurchaseOption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseOptionSoap[soapModels.size()]);
	}

	public PurchaseOptionSoap() {
	}

	public long getPrimaryKey() {
		return _purchaseOptionId;
	}

	public void setPrimaryKey(long pk) {
		setPurchaseOptionId(pk);
	}

	public long getPurchaseOptionId() {
		return _purchaseOptionId;
	}

	public void setPurchaseOptionId(long purchaseOptionId) {
		_purchaseOptionId = purchaseOptionId;
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

	public String getPurchaseOptionName() {
		return _purchaseOptionName;
	}

	public void setPurchaseOptionName(String purchaseOptionName) {
		_purchaseOptionName = purchaseOptionName;
	}

	public long getSequenceNumber() {
		return _sequenceNumber;
	}

	public void setSequenceNumber(long sequenceNumber) {
		_sequenceNumber = sequenceNumber;
	}

	private long _purchaseOptionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _purchaseOptionName;
	private long _sequenceNumber;
}