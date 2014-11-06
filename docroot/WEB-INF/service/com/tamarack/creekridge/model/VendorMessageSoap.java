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
public class VendorMessageSoap implements Serializable {
	public static VendorMessageSoap toSoapModel(VendorMessage model) {
		VendorMessageSoap soapModel = new VendorMessageSoap();

		soapModel.setVendorId(model.getVendorId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setKey(model.getKey());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static VendorMessageSoap[] toSoapModels(VendorMessage[] models) {
		VendorMessageSoap[] soapModels = new VendorMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VendorMessageSoap[][] toSoapModels(VendorMessage[][] models) {
		VendorMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VendorMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VendorMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VendorMessageSoap[] toSoapModels(List<VendorMessage> models) {
		List<VendorMessageSoap> soapModels = new ArrayList<VendorMessageSoap>(models.size());

		for (VendorMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VendorMessageSoap[soapModels.size()]);
	}

	public VendorMessageSoap() {
	}

	public long getPrimaryKey() {
		return _vendorId;
	}

	public void setPrimaryKey(long pk) {
		setVendorId(pk);
	}

	public long getVendorId() {
		return _vendorId;
	}

	public void setVendorId(long vendorId) {
		_vendorId = vendorId;
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

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _vendorId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _key;
	private String _value;
}