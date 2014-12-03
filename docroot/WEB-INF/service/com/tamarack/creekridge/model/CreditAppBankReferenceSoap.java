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
 * @author tamarack
 * @generated
 */
public class CreditAppBankReferenceSoap implements Serializable {
	public static CreditAppBankReferenceSoap toSoapModel(
		CreditAppBankReference model) {
		CreditAppBankReferenceSoap soapModel = new CreditAppBankReferenceSoap();

		soapModel.setBankReferenceId(model.getBankReferenceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreditAppId(model.getCreditAppId());
		soapModel.setSequenceNumber(model.getSequenceNumber());
		soapModel.setBankReferenceName(model.getBankReferenceName());
		soapModel.setBankReferenceContact(model.getBankReferenceContact());
		soapModel.setBankReferencePhone(model.getBankReferencePhone());
		soapModel.setBankReferenceAccountType(model.getBankReferenceAccountType());
		soapModel.setBankReferenceAccountNumber(model.getBankReferenceAccountNumber());

		return soapModel;
	}

	public static CreditAppBankReferenceSoap[] toSoapModels(
		CreditAppBankReference[] models) {
		CreditAppBankReferenceSoap[] soapModels = new CreditAppBankReferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditAppBankReferenceSoap[][] toSoapModels(
		CreditAppBankReference[][] models) {
		CreditAppBankReferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreditAppBankReferenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditAppBankReferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditAppBankReferenceSoap[] toSoapModels(
		List<CreditAppBankReference> models) {
		List<CreditAppBankReferenceSoap> soapModels = new ArrayList<CreditAppBankReferenceSoap>(models.size());

		for (CreditAppBankReference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreditAppBankReferenceSoap[soapModels.size()]);
	}

	public CreditAppBankReferenceSoap() {
	}

	public long getPrimaryKey() {
		return _bankReferenceId;
	}

	public void setPrimaryKey(long pk) {
		setBankReferenceId(pk);
	}

	public long getBankReferenceId() {
		return _bankReferenceId;
	}

	public void setBankReferenceId(long bankReferenceId) {
		_bankReferenceId = bankReferenceId;
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

	public long getCreditAppId() {
		return _creditAppId;
	}

	public void setCreditAppId(long creditAppId) {
		_creditAppId = creditAppId;
	}

	public long getSequenceNumber() {
		return _sequenceNumber;
	}

	public void setSequenceNumber(long sequenceNumber) {
		_sequenceNumber = sequenceNumber;
	}

	public String getBankReferenceName() {
		return _bankReferenceName;
	}

	public void setBankReferenceName(String bankReferenceName) {
		_bankReferenceName = bankReferenceName;
	}

	public String getBankReferenceContact() {
		return _bankReferenceContact;
	}

	public void setBankReferenceContact(String bankReferenceContact) {
		_bankReferenceContact = bankReferenceContact;
	}

	public String getBankReferencePhone() {
		return _bankReferencePhone;
	}

	public void setBankReferencePhone(String bankReferencePhone) {
		_bankReferencePhone = bankReferencePhone;
	}

	public String getBankReferenceAccountType() {
		return _bankReferenceAccountType;
	}

	public void setBankReferenceAccountType(String bankReferenceAccountType) {
		_bankReferenceAccountType = bankReferenceAccountType;
	}

	public String getBankReferenceAccountNumber() {
		return _bankReferenceAccountNumber;
	}

	public void setBankReferenceAccountNumber(String bankReferenceAccountNumber) {
		_bankReferenceAccountNumber = bankReferenceAccountNumber;
	}

	private long _bankReferenceId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creditAppId;
	private long _sequenceNumber;
	private String _bankReferenceName;
	private String _bankReferenceContact;
	private String _bankReferencePhone;
	private String _bankReferenceAccountType;
	private String _bankReferenceAccountNumber;
}