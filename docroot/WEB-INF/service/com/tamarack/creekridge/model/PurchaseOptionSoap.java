/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.tamarack.creekridge.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Tamarack Consulting
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