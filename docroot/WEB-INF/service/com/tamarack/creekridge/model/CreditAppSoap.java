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
public class CreditAppSoap implements Serializable {
	public static CreditAppSoap toSoapModel(CreditApp model) {
		CreditAppSoap soapModel = new CreditAppSoap();

		soapModel.setCreditAppId(model.getCreditAppId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVendorId(model.getVendorId());
		soapModel.setCreditAppStatusId(model.getCreditAppStatusId());
		soapModel.setProductId(model.getProductId());
		soapModel.setTermId(model.getTermId());
		soapModel.setPurchaseOptionId(model.getPurchaseOptionId());
		soapModel.setRateFactorRuleId(model.getRateFactorRuleId());
		soapModel.setPaymentAmount(model.getPaymentAmount());
		soapModel.setEquipmentPrice(model.getEquipmentPrice());
		soapModel.setEquipmentDesc(model.getEquipmentDesc());
		soapModel.setEquipmentLocAsCustomerFlag(model.getEquipmentLocAsCustomerFlag());
		soapModel.setEquipmentAddress1(model.getEquipmentAddress1());
		soapModel.setEquipmentAddress2(model.getEquipmentAddress2());
		soapModel.setEquipmentCity(model.getEquipmentCity());
		soapModel.setEquipmentState(model.getEquipmentState());
		soapModel.setEquipmentZip(model.getEquipmentZip());
		soapModel.setCustomerName(model.getCustomerName());
		soapModel.setCustomerDBAName(model.getCustomerDBAName());
		soapModel.setCustomerAddress1(model.getCustomerAddress1());
		soapModel.setCustomerAddress2(model.getCustomerAddress2());
		soapModel.setCustomerCity(model.getCustomerCity());
		soapModel.setCustomerState(model.getCustomerState());
		soapModel.setCustomerZip(model.getCustomerZip());
		soapModel.setCustomerContact(model.getCustomerContact());
		soapModel.setCustomerContactPhone(model.getCustomerContactPhone());
		soapModel.setCustomerContactFax(model.getCustomerContactFax());
		soapModel.setCustomerContactEmail(model.getCustomerContactEmail());
		soapModel.setCustomerBusinessDesc(model.getCustomerBusinessDesc());
		soapModel.setCustomerBusinessType(model.getCustomerBusinessType());
		soapModel.setCustomerBusinessStartDate(model.getCustomerBusinessStartDate());
		soapModel.setCustomerBusinessIncorporatedState(model.getCustomerBusinessIncorporatedState());
		soapModel.setCustomerBusinessFederalTaxID(model.getCustomerBusinessFederalTaxID());

		return soapModel;
	}

	public static CreditAppSoap[] toSoapModels(CreditApp[] models) {
		CreditAppSoap[] soapModels = new CreditAppSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditAppSoap[][] toSoapModels(CreditApp[][] models) {
		CreditAppSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreditAppSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditAppSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditAppSoap[] toSoapModels(List<CreditApp> models) {
		List<CreditAppSoap> soapModels = new ArrayList<CreditAppSoap>(models.size());

		for (CreditApp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreditAppSoap[soapModels.size()]);
	}

	public CreditAppSoap() {
	}

	public long getPrimaryKey() {
		return _creditAppId;
	}

	public void setPrimaryKey(long pk) {
		setCreditAppId(pk);
	}

	public long getCreditAppId() {
		return _creditAppId;
	}

	public void setCreditAppId(long creditAppId) {
		_creditAppId = creditAppId;
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

	public long getVendorId() {
		return _vendorId;
	}

	public void setVendorId(long vendorId) {
		_vendorId = vendorId;
	}

	public long getCreditAppStatusId() {
		return _creditAppStatusId;
	}

	public void setCreditAppStatusId(long creditAppStatusId) {
		_creditAppStatusId = creditAppStatusId;
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

	public long getRateFactorRuleId() {
		return _rateFactorRuleId;
	}

	public void setRateFactorRuleId(long rateFactorRuleId) {
		_rateFactorRuleId = rateFactorRuleId;
	}

	public double getPaymentAmount() {
		return _paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		_paymentAmount = paymentAmount;
	}

	public double getEquipmentPrice() {
		return _equipmentPrice;
	}

	public void setEquipmentPrice(double equipmentPrice) {
		_equipmentPrice = equipmentPrice;
	}

	public String getEquipmentDesc() {
		return _equipmentDesc;
	}

	public void setEquipmentDesc(String equipmentDesc) {
		_equipmentDesc = equipmentDesc;
	}

	public boolean getEquipmentLocAsCustomerFlag() {
		return _equipmentLocAsCustomerFlag;
	}

	public boolean isEquipmentLocAsCustomerFlag() {
		return _equipmentLocAsCustomerFlag;
	}

	public void setEquipmentLocAsCustomerFlag(
		boolean equipmentLocAsCustomerFlag) {
		_equipmentLocAsCustomerFlag = equipmentLocAsCustomerFlag;
	}

	public String getEquipmentAddress1() {
		return _equipmentAddress1;
	}

	public void setEquipmentAddress1(String equipmentAddress1) {
		_equipmentAddress1 = equipmentAddress1;
	}

	public String getEquipmentAddress2() {
		return _equipmentAddress2;
	}

	public void setEquipmentAddress2(String equipmentAddress2) {
		_equipmentAddress2 = equipmentAddress2;
	}

	public String getEquipmentCity() {
		return _equipmentCity;
	}

	public void setEquipmentCity(String equipmentCity) {
		_equipmentCity = equipmentCity;
	}

	public String getEquipmentState() {
		return _equipmentState;
	}

	public void setEquipmentState(String equipmentState) {
		_equipmentState = equipmentState;
	}

	public String getEquipmentZip() {
		return _equipmentZip;
	}

	public void setEquipmentZip(String equipmentZip) {
		_equipmentZip = equipmentZip;
	}

	public String getCustomerName() {
		return _CustomerName;
	}

	public void setCustomerName(String CustomerName) {
		_CustomerName = CustomerName;
	}

	public String getCustomerDBAName() {
		return _CustomerDBAName;
	}

	public void setCustomerDBAName(String CustomerDBAName) {
		_CustomerDBAName = CustomerDBAName;
	}

	public String getCustomerAddress1() {
		return _CustomerAddress1;
	}

	public void setCustomerAddress1(String CustomerAddress1) {
		_CustomerAddress1 = CustomerAddress1;
	}

	public String getCustomerAddress2() {
		return _CustomerAddress2;
	}

	public void setCustomerAddress2(String CustomerAddress2) {
		_CustomerAddress2 = CustomerAddress2;
	}

	public String getCustomerCity() {
		return _CustomerCity;
	}

	public void setCustomerCity(String CustomerCity) {
		_CustomerCity = CustomerCity;
	}

	public String getCustomerState() {
		return _CustomerState;
	}

	public void setCustomerState(String CustomerState) {
		_CustomerState = CustomerState;
	}

	public String getCustomerZip() {
		return _CustomerZip;
	}

	public void setCustomerZip(String CustomerZip) {
		_CustomerZip = CustomerZip;
	}

	public String getCustomerContact() {
		return _CustomerContact;
	}

	public void setCustomerContact(String CustomerContact) {
		_CustomerContact = CustomerContact;
	}

	public String getCustomerContactPhone() {
		return _CustomerContactPhone;
	}

	public void setCustomerContactPhone(String CustomerContactPhone) {
		_CustomerContactPhone = CustomerContactPhone;
	}

	public String getCustomerContactFax() {
		return _CustomerContactFax;
	}

	public void setCustomerContactFax(String CustomerContactFax) {
		_CustomerContactFax = CustomerContactFax;
	}

	public String getCustomerContactEmail() {
		return _CustomerContactEmail;
	}

	public void setCustomerContactEmail(String CustomerContactEmail) {
		_CustomerContactEmail = CustomerContactEmail;
	}

	public String getCustomerBusinessDesc() {
		return _CustomerBusinessDesc;
	}

	public void setCustomerBusinessDesc(String CustomerBusinessDesc) {
		_CustomerBusinessDesc = CustomerBusinessDesc;
	}

	public String getCustomerBusinessType() {
		return _CustomerBusinessType;
	}

	public void setCustomerBusinessType(String CustomerBusinessType) {
		_CustomerBusinessType = CustomerBusinessType;
	}

	public Date getCustomerBusinessStartDate() {
		return _CustomerBusinessStartDate;
	}

	public void setCustomerBusinessStartDate(Date CustomerBusinessStartDate) {
		_CustomerBusinessStartDate = CustomerBusinessStartDate;
	}

	public String getCustomerBusinessIncorporatedState() {
		return _CustomerBusinessIncorporatedState;
	}

	public void setCustomerBusinessIncorporatedState(
		String CustomerBusinessIncorporatedState) {
		_CustomerBusinessIncorporatedState = CustomerBusinessIncorporatedState;
	}

	public String getCustomerBusinessFederalTaxID() {
		return _CustomerBusinessFederalTaxID;
	}

	public void setCustomerBusinessFederalTaxID(
		String CustomerBusinessFederalTaxID) {
		_CustomerBusinessFederalTaxID = CustomerBusinessFederalTaxID;
	}

	private long _creditAppId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _vendorId;
	private long _creditAppStatusId;
	private long _productId;
	private long _termId;
	private long _purchaseOptionId;
	private long _rateFactorRuleId;
	private double _paymentAmount;
	private double _equipmentPrice;
	private String _equipmentDesc;
	private boolean _equipmentLocAsCustomerFlag;
	private String _equipmentAddress1;
	private String _equipmentAddress2;
	private String _equipmentCity;
	private String _equipmentState;
	private String _equipmentZip;
	private String _CustomerName;
	private String _CustomerDBAName;
	private String _CustomerAddress1;
	private String _CustomerAddress2;
	private String _CustomerCity;
	private String _CustomerState;
	private String _CustomerZip;
	private String _CustomerContact;
	private String _CustomerContactPhone;
	private String _CustomerContactFax;
	private String _CustomerContactEmail;
	private String _CustomerBusinessDesc;
	private String _CustomerBusinessType;
	private Date _CustomerBusinessStartDate;
	private String _CustomerBusinessIncorporatedState;
	private String _CustomerBusinessFederalTaxID;
}