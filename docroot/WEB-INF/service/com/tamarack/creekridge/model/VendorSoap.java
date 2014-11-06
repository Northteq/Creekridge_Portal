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
public class VendorSoap implements Serializable {
	public static VendorSoap toSoapModel(Vendor model) {
		VendorSoap soapModel = new VendorSoap();

		soapModel.setVendorId(model.getVendorId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setMultiSelectProduct(model.getMultiSelectProduct());
		soapModel.setMultiSelectPurchaseOption(model.getMultiSelectPurchaseOption());
		soapModel.setMultiSelectTerm(model.getMultiSelectTerm());

		return soapModel;
	}

	public static VendorSoap[] toSoapModels(Vendor[] models) {
		VendorSoap[] soapModels = new VendorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VendorSoap[][] toSoapModels(Vendor[][] models) {
		VendorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VendorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VendorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VendorSoap[] toSoapModels(List<Vendor> models) {
		List<VendorSoap> soapModels = new ArrayList<VendorSoap>(models.size());

		for (Vendor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VendorSoap[soapModels.size()]);
	}

	public VendorSoap() {
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public boolean getMultiSelectProduct() {
		return _multiSelectProduct;
	}

	public boolean isMultiSelectProduct() {
		return _multiSelectProduct;
	}

	public void setMultiSelectProduct(boolean multiSelectProduct) {
		_multiSelectProduct = multiSelectProduct;
	}

	public boolean getMultiSelectPurchaseOption() {
		return _multiSelectPurchaseOption;
	}

	public boolean isMultiSelectPurchaseOption() {
		return _multiSelectPurchaseOption;
	}

	public void setMultiSelectPurchaseOption(boolean multiSelectPurchaseOption) {
		_multiSelectPurchaseOption = multiSelectPurchaseOption;
	}

	public boolean getMultiSelectTerm() {
		return _multiSelectTerm;
	}

	public boolean isMultiSelectTerm() {
		return _multiSelectTerm;
	}

	public void setMultiSelectTerm(boolean multiSelectTerm) {
		_multiSelectTerm = multiSelectTerm;
	}

	private long _vendorId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;
	private boolean _multiSelectProduct;
	private boolean _multiSelectPurchaseOption;
	private boolean _multiSelectTerm;
}