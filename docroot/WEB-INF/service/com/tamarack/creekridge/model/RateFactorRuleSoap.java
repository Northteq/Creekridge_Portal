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
public class RateFactorRuleSoap implements Serializable {
	public static RateFactorRuleSoap toSoapModel(RateFactorRule model) {
		RateFactorRuleSoap soapModel = new RateFactorRuleSoap();

		soapModel.setRateFactorRuleId(model.getRateFactorRuleId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProductId(model.getProductId());
		soapModel.setTermId(model.getTermId());
		soapModel.setPurchaseOptionId(model.getPurchaseOptionId());
		soapModel.setVendorId(model.getVendorId());
		soapModel.setMinPrice(model.getMinPrice());
		soapModel.setRateFactor(model.getRateFactor());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setActive(model.getActive());
		soapModel.setExpirationDate(model.getExpirationDate());

		return soapModel;
	}

	public static RateFactorRuleSoap[] toSoapModels(RateFactorRule[] models) {
		RateFactorRuleSoap[] soapModels = new RateFactorRuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RateFactorRuleSoap[][] toSoapModels(RateFactorRule[][] models) {
		RateFactorRuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RateFactorRuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RateFactorRuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RateFactorRuleSoap[] toSoapModels(List<RateFactorRule> models) {
		List<RateFactorRuleSoap> soapModels = new ArrayList<RateFactorRuleSoap>(models.size());

		for (RateFactorRule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RateFactorRuleSoap[soapModels.size()]);
	}

	public RateFactorRuleSoap() {
	}

	public long getPrimaryKey() {
		return _rateFactorRuleId;
	}

	public void setPrimaryKey(long pk) {
		setRateFactorRuleId(pk);
	}

	public long getRateFactorRuleId() {
		return _rateFactorRuleId;
	}

	public void setRateFactorRuleId(long rateFactorRuleId) {
		_rateFactorRuleId = rateFactorRuleId;
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

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getTermId() {
		return _termId;
	}

	public void setTermId(long termId) {
		_termId = termId;
	}

	public long getPurchaseOptionId() {
		return _purchaseOptionId;
	}

	public void setPurchaseOptionId(long purchaseOptionId) {
		_purchaseOptionId = purchaseOptionId;
	}

	public long getVendorId() {
		return _vendorId;
	}

	public void setVendorId(long vendorId) {
		_vendorId = vendorId;
	}

	public double getMinPrice() {
		return _minPrice;
	}

	public void setMinPrice(double minPrice) {
		_minPrice = minPrice;
	}

	public double getRateFactor() {
		return _rateFactor;
	}

	public void setRateFactor(double rateFactor) {
		_rateFactor = rateFactor;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	private long _rateFactorRuleId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _productId;
	private long _termId;
	private long _purchaseOptionId;
	private long _vendorId;
	private double _minPrice;
	private double _rateFactor;
	private Date _effectiveDate;
	private boolean _active;
	private Date _expirationDate;
}