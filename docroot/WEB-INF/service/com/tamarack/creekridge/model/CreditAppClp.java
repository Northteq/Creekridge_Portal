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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.tamarack.creekridge.service.ClpSerializer;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pmacha
 */
public class CreditAppClp extends BaseModelImpl<CreditApp> implements CreditApp {
	public CreditAppClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CreditApp.class;
	}

	@Override
	public String getModelClassName() {
		return CreditApp.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _creditAppId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCreditAppId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _creditAppId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("creditAppId", getCreditAppId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("vendorId", getVendorId());
		attributes.put("creditAppStatusId", getCreditAppStatusId());
		attributes.put("productId", getProductId());
		attributes.put("termId", getTermId());
		attributes.put("purchaseOptionId", getPurchaseOptionId());
		attributes.put("rateFactorRuleId", getRateFactorRuleId());
		attributes.put("paymentAmount", getPaymentAmount());
		attributes.put("equipmentPrice", getEquipmentPrice());
		attributes.put("equipmentDesc", getEquipmentDesc());
		attributes.put("equipmentLocAsCustomerFlag",
			getEquipmentLocAsCustomerFlag());
		attributes.put("equipmentAddress1", getEquipmentAddress1());
		attributes.put("equipmentAddress2", getEquipmentAddress2());
		attributes.put("equipmentCity", getEquipmentCity());
		attributes.put("equipmentState", getEquipmentState());
		attributes.put("equipmentZip", getEquipmentZip());
		attributes.put("CustomerName", getCustomerName());
		attributes.put("CustomerDBAName", getCustomerDBAName());
		attributes.put("CustomerAddress1", getCustomerAddress1());
		attributes.put("CustomerAddress2", getCustomerAddress2());
		attributes.put("CustomerCity", getCustomerCity());
		attributes.put("CustomerState", getCustomerState());
		attributes.put("CustomerZip", getCustomerZip());
		attributes.put("CustomerContact", getCustomerContact());
		attributes.put("CustomerContactPhone", getCustomerContactPhone());
		attributes.put("CustomerContactFax", getCustomerContactFax());
		attributes.put("CustomerContactEmail", getCustomerContactEmail());
		attributes.put("CustomerBusinessDesc", getCustomerBusinessDesc());
		attributes.put("CustomerBusinessType", getCustomerBusinessType());
		attributes.put("CustomerBusinessStartDate",
			getCustomerBusinessStartDate());
		attributes.put("CustomerBusinessIncorporatedState",
			getCustomerBusinessIncorporatedState());
		attributes.put("CustomerBusinessFederalTaxID",
			getCustomerBusinessFederalTaxID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long creditAppId = (Long)attributes.get("creditAppId");

		if (creditAppId != null) {
			setCreditAppId(creditAppId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
		}

		Long creditAppStatusId = (Long)attributes.get("creditAppStatusId");

		if (creditAppStatusId != null) {
			setCreditAppStatusId(creditAppStatusId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		Long purchaseOptionId = (Long)attributes.get("purchaseOptionId");

		if (purchaseOptionId != null) {
			setPurchaseOptionId(purchaseOptionId);
		}

		Long rateFactorRuleId = (Long)attributes.get("rateFactorRuleId");

		if (rateFactorRuleId != null) {
			setRateFactorRuleId(rateFactorRuleId);
		}

		Double paymentAmount = (Double)attributes.get("paymentAmount");

		if (paymentAmount != null) {
			setPaymentAmount(paymentAmount);
		}

		Double equipmentPrice = (Double)attributes.get("equipmentPrice");

		if (equipmentPrice != null) {
			setEquipmentPrice(equipmentPrice);
		}

		String equipmentDesc = (String)attributes.get("equipmentDesc");

		if (equipmentDesc != null) {
			setEquipmentDesc(equipmentDesc);
		}

		Boolean equipmentLocAsCustomerFlag = (Boolean)attributes.get(
				"equipmentLocAsCustomerFlag");

		if (equipmentLocAsCustomerFlag != null) {
			setEquipmentLocAsCustomerFlag(equipmentLocAsCustomerFlag);
		}

		String equipmentAddress1 = (String)attributes.get("equipmentAddress1");

		if (equipmentAddress1 != null) {
			setEquipmentAddress1(equipmentAddress1);
		}

		String equipmentAddress2 = (String)attributes.get("equipmentAddress2");

		if (equipmentAddress2 != null) {
			setEquipmentAddress2(equipmentAddress2);
		}

		String equipmentCity = (String)attributes.get("equipmentCity");

		if (equipmentCity != null) {
			setEquipmentCity(equipmentCity);
		}

		String equipmentState = (String)attributes.get("equipmentState");

		if (equipmentState != null) {
			setEquipmentState(equipmentState);
		}

		String equipmentZip = (String)attributes.get("equipmentZip");

		if (equipmentZip != null) {
			setEquipmentZip(equipmentZip);
		}

		String CustomerName = (String)attributes.get("CustomerName");

		if (CustomerName != null) {
			setCustomerName(CustomerName);
		}

		String CustomerDBAName = (String)attributes.get("CustomerDBAName");

		if (CustomerDBAName != null) {
			setCustomerDBAName(CustomerDBAName);
		}

		String CustomerAddress1 = (String)attributes.get("CustomerAddress1");

		if (CustomerAddress1 != null) {
			setCustomerAddress1(CustomerAddress1);
		}

		String CustomerAddress2 = (String)attributes.get("CustomerAddress2");

		if (CustomerAddress2 != null) {
			setCustomerAddress2(CustomerAddress2);
		}

		String CustomerCity = (String)attributes.get("CustomerCity");

		if (CustomerCity != null) {
			setCustomerCity(CustomerCity);
		}

		String CustomerState = (String)attributes.get("CustomerState");

		if (CustomerState != null) {
			setCustomerState(CustomerState);
		}

		String CustomerZip = (String)attributes.get("CustomerZip");

		if (CustomerZip != null) {
			setCustomerZip(CustomerZip);
		}

		String CustomerContact = (String)attributes.get("CustomerContact");

		if (CustomerContact != null) {
			setCustomerContact(CustomerContact);
		}

		String CustomerContactPhone = (String)attributes.get(
				"CustomerContactPhone");

		if (CustomerContactPhone != null) {
			setCustomerContactPhone(CustomerContactPhone);
		}

		String CustomerContactFax = (String)attributes.get("CustomerContactFax");

		if (CustomerContactFax != null) {
			setCustomerContactFax(CustomerContactFax);
		}

		String CustomerContactEmail = (String)attributes.get(
				"CustomerContactEmail");

		if (CustomerContactEmail != null) {
			setCustomerContactEmail(CustomerContactEmail);
		}

		String CustomerBusinessDesc = (String)attributes.get(
				"CustomerBusinessDesc");

		if (CustomerBusinessDesc != null) {
			setCustomerBusinessDesc(CustomerBusinessDesc);
		}

		String CustomerBusinessType = (String)attributes.get(
				"CustomerBusinessType");

		if (CustomerBusinessType != null) {
			setCustomerBusinessType(CustomerBusinessType);
		}

		Date CustomerBusinessStartDate = (Date)attributes.get(
				"CustomerBusinessStartDate");

		if (CustomerBusinessStartDate != null) {
			setCustomerBusinessStartDate(CustomerBusinessStartDate);
		}

		String CustomerBusinessIncorporatedState = (String)attributes.get(
				"CustomerBusinessIncorporatedState");

		if (CustomerBusinessIncorporatedState != null) {
			setCustomerBusinessIncorporatedState(CustomerBusinessIncorporatedState);
		}

		String CustomerBusinessFederalTaxID = (String)attributes.get(
				"CustomerBusinessFederalTaxID");

		if (CustomerBusinessFederalTaxID != null) {
			setCustomerBusinessFederalTaxID(CustomerBusinessFederalTaxID);
		}
	}

	@Override
	public long getCreditAppId() {
		return _creditAppId;
	}

	@Override
	public void setCreditAppId(long creditAppId) {
		_creditAppId = creditAppId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppId", long.class);

				method.invoke(_creditAppRemoteModel, creditAppId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_creditAppRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_creditAppRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_creditAppRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_creditAppRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_creditAppRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVendorId() {
		return _vendorId;
	}

	@Override
	public void setVendorId(long vendorId) {
		_vendorId = vendorId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorId", long.class);

				method.invoke(_creditAppRemoteModel, vendorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreditAppStatusId() {
		return _creditAppStatusId;
	}

	@Override
	public void setCreditAppStatusId(long creditAppStatusId) {
		_creditAppStatusId = creditAppStatusId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppStatusId",
						long.class);

				method.invoke(_creditAppRemoteModel, creditAppStatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_productId = productId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setProductId", long.class);

				method.invoke(_creditAppRemoteModel, productId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTermId() {
		return _termId;
	}

	@Override
	public void setTermId(long termId) {
		_termId = termId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setTermId", long.class);

				method.invoke(_creditAppRemoteModel, termId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPurchaseOptionId() {
		return _purchaseOptionId;
	}

	@Override
	public void setPurchaseOptionId(long purchaseOptionId) {
		_purchaseOptionId = purchaseOptionId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setPurchaseOptionId",
						long.class);

				method.invoke(_creditAppRemoteModel, purchaseOptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRateFactorRuleId() {
		return _rateFactorRuleId;
	}

	@Override
	public void setRateFactorRuleId(long rateFactorRuleId) {
		_rateFactorRuleId = rateFactorRuleId;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setRateFactorRuleId",
						long.class);

				method.invoke(_creditAppRemoteModel, rateFactorRuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPaymentAmount() {
		return _paymentAmount;
	}

	@Override
	public void setPaymentAmount(double paymentAmount) {
		_paymentAmount = paymentAmount;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentAmount", double.class);

				method.invoke(_creditAppRemoteModel, paymentAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getEquipmentPrice() {
		return _equipmentPrice;
	}

	@Override
	public void setEquipmentPrice(double equipmentPrice) {
		_equipmentPrice = equipmentPrice;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentPrice",
						double.class);

				method.invoke(_creditAppRemoteModel, equipmentPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEquipmentDesc() {
		return _equipmentDesc;
	}

	@Override
	public void setEquipmentDesc(String equipmentDesc) {
		_equipmentDesc = equipmentDesc;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentDesc", String.class);

				method.invoke(_creditAppRemoteModel, equipmentDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEquipmentLocAsCustomerFlag() {
		return _equipmentLocAsCustomerFlag;
	}

	@Override
	public boolean isEquipmentLocAsCustomerFlag() {
		return _equipmentLocAsCustomerFlag;
	}

	@Override
	public void setEquipmentLocAsCustomerFlag(
		boolean equipmentLocAsCustomerFlag) {
		_equipmentLocAsCustomerFlag = equipmentLocAsCustomerFlag;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentLocAsCustomerFlag",
						boolean.class);

				method.invoke(_creditAppRemoteModel, equipmentLocAsCustomerFlag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEquipmentAddress1() {
		return _equipmentAddress1;
	}

	@Override
	public void setEquipmentAddress1(String equipmentAddress1) {
		_equipmentAddress1 = equipmentAddress1;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentAddress1",
						String.class);

				method.invoke(_creditAppRemoteModel, equipmentAddress1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEquipmentAddress2() {
		return _equipmentAddress2;
	}

	@Override
	public void setEquipmentAddress2(String equipmentAddress2) {
		_equipmentAddress2 = equipmentAddress2;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentAddress2",
						String.class);

				method.invoke(_creditAppRemoteModel, equipmentAddress2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEquipmentCity() {
		return _equipmentCity;
	}

	@Override
	public void setEquipmentCity(String equipmentCity) {
		_equipmentCity = equipmentCity;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentCity", String.class);

				method.invoke(_creditAppRemoteModel, equipmentCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEquipmentState() {
		return _equipmentState;
	}

	@Override
	public void setEquipmentState(String equipmentState) {
		_equipmentState = equipmentState;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentState",
						String.class);

				method.invoke(_creditAppRemoteModel, equipmentState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEquipmentZip() {
		return _equipmentZip;
	}

	@Override
	public void setEquipmentZip(String equipmentZip) {
		_equipmentZip = equipmentZip;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentZip", String.class);

				method.invoke(_creditAppRemoteModel, equipmentZip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerName() {
		return _CustomerName;
	}

	@Override
	public void setCustomerName(String CustomerName) {
		_CustomerName = CustomerName;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerName", String.class);

				method.invoke(_creditAppRemoteModel, CustomerName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerDBAName() {
		return _CustomerDBAName;
	}

	@Override
	public void setCustomerDBAName(String CustomerDBAName) {
		_CustomerDBAName = CustomerDBAName;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerDBAName",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerDBAName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerAddress1() {
		return _CustomerAddress1;
	}

	@Override
	public void setCustomerAddress1(String CustomerAddress1) {
		_CustomerAddress1 = CustomerAddress1;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerAddress1",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerAddress1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerAddress2() {
		return _CustomerAddress2;
	}

	@Override
	public void setCustomerAddress2(String CustomerAddress2) {
		_CustomerAddress2 = CustomerAddress2;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerAddress2",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerAddress2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerCity() {
		return _CustomerCity;
	}

	@Override
	public void setCustomerCity(String CustomerCity) {
		_CustomerCity = CustomerCity;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerCity", String.class);

				method.invoke(_creditAppRemoteModel, CustomerCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerState() {
		return _CustomerState;
	}

	@Override
	public void setCustomerState(String CustomerState) {
		_CustomerState = CustomerState;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerState", String.class);

				method.invoke(_creditAppRemoteModel, CustomerState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerZip() {
		return _CustomerZip;
	}

	@Override
	public void setCustomerZip(String CustomerZip) {
		_CustomerZip = CustomerZip;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerZip", String.class);

				method.invoke(_creditAppRemoteModel, CustomerZip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerContact() {
		return _CustomerContact;
	}

	@Override
	public void setCustomerContact(String CustomerContact) {
		_CustomerContact = CustomerContact;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerContact",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerContact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerContactPhone() {
		return _CustomerContactPhone;
	}

	@Override
	public void setCustomerContactPhone(String CustomerContactPhone) {
		_CustomerContactPhone = CustomerContactPhone;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerContactPhone",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerContactPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerContactFax() {
		return _CustomerContactFax;
	}

	@Override
	public void setCustomerContactFax(String CustomerContactFax) {
		_CustomerContactFax = CustomerContactFax;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerContactFax",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerContactFax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerContactEmail() {
		return _CustomerContactEmail;
	}

	@Override
	public void setCustomerContactEmail(String CustomerContactEmail) {
		_CustomerContactEmail = CustomerContactEmail;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerContactEmail",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerContactEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerBusinessDesc() {
		return _CustomerBusinessDesc;
	}

	@Override
	public void setCustomerBusinessDesc(String CustomerBusinessDesc) {
		_CustomerBusinessDesc = CustomerBusinessDesc;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerBusinessDesc",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerBusinessDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerBusinessType() {
		return _CustomerBusinessType;
	}

	@Override
	public void setCustomerBusinessType(String CustomerBusinessType) {
		_CustomerBusinessType = CustomerBusinessType;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerBusinessType",
						String.class);

				method.invoke(_creditAppRemoteModel, CustomerBusinessType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomerBusinessStartDate() {
		return _CustomerBusinessStartDate;
	}

	@Override
	public void setCustomerBusinessStartDate(Date CustomerBusinessStartDate) {
		_CustomerBusinessStartDate = CustomerBusinessStartDate;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerBusinessStartDate",
						Date.class);

				method.invoke(_creditAppRemoteModel, CustomerBusinessStartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerBusinessIncorporatedState() {
		return _CustomerBusinessIncorporatedState;
	}

	@Override
	public void setCustomerBusinessIncorporatedState(
		String CustomerBusinessIncorporatedState) {
		_CustomerBusinessIncorporatedState = CustomerBusinessIncorporatedState;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerBusinessIncorporatedState",
						String.class);

				method.invoke(_creditAppRemoteModel,
					CustomerBusinessIncorporatedState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerBusinessFederalTaxID() {
		return _CustomerBusinessFederalTaxID;
	}

	@Override
	public void setCustomerBusinessFederalTaxID(
		String CustomerBusinessFederalTaxID) {
		_CustomerBusinessFederalTaxID = CustomerBusinessFederalTaxID;

		if (_creditAppRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerBusinessFederalTaxID",
						String.class);

				method.invoke(_creditAppRemoteModel,
					CustomerBusinessFederalTaxID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCreditAppRemoteModel() {
		return _creditAppRemoteModel;
	}

	public void setCreditAppRemoteModel(BaseModel<?> creditAppRemoteModel) {
		_creditAppRemoteModel = creditAppRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _creditAppRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_creditAppRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CreditAppLocalServiceUtil.addCreditApp(this);
		}
		else {
			CreditAppLocalServiceUtil.updateCreditApp(this);
		}
	}

	@Override
	public CreditApp toEscapedModel() {
		return (CreditApp)ProxyUtil.newProxyInstance(CreditApp.class.getClassLoader(),
			new Class[] { CreditApp.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CreditAppClp clone = new CreditAppClp();

		clone.setCreditAppId(getCreditAppId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVendorId(getVendorId());
		clone.setCreditAppStatusId(getCreditAppStatusId());
		clone.setProductId(getProductId());
		clone.setTermId(getTermId());
		clone.setPurchaseOptionId(getPurchaseOptionId());
		clone.setRateFactorRuleId(getRateFactorRuleId());
		clone.setPaymentAmount(getPaymentAmount());
		clone.setEquipmentPrice(getEquipmentPrice());
		clone.setEquipmentDesc(getEquipmentDesc());
		clone.setEquipmentLocAsCustomerFlag(getEquipmentLocAsCustomerFlag());
		clone.setEquipmentAddress1(getEquipmentAddress1());
		clone.setEquipmentAddress2(getEquipmentAddress2());
		clone.setEquipmentCity(getEquipmentCity());
		clone.setEquipmentState(getEquipmentState());
		clone.setEquipmentZip(getEquipmentZip());
		clone.setCustomerName(getCustomerName());
		clone.setCustomerDBAName(getCustomerDBAName());
		clone.setCustomerAddress1(getCustomerAddress1());
		clone.setCustomerAddress2(getCustomerAddress2());
		clone.setCustomerCity(getCustomerCity());
		clone.setCustomerState(getCustomerState());
		clone.setCustomerZip(getCustomerZip());
		clone.setCustomerContact(getCustomerContact());
		clone.setCustomerContactPhone(getCustomerContactPhone());
		clone.setCustomerContactFax(getCustomerContactFax());
		clone.setCustomerContactEmail(getCustomerContactEmail());
		clone.setCustomerBusinessDesc(getCustomerBusinessDesc());
		clone.setCustomerBusinessType(getCustomerBusinessType());
		clone.setCustomerBusinessStartDate(getCustomerBusinessStartDate());
		clone.setCustomerBusinessIncorporatedState(getCustomerBusinessIncorporatedState());
		clone.setCustomerBusinessFederalTaxID(getCustomerBusinessFederalTaxID());

		return clone;
	}

	@Override
	public int compareTo(CreditApp creditApp) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				creditApp.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditAppClp)) {
			return false;
		}

		CreditAppClp creditApp = (CreditAppClp)obj;

		long primaryKey = creditApp.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{creditAppId=");
		sb.append(getCreditAppId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", vendorId=");
		sb.append(getVendorId());
		sb.append(", creditAppStatusId=");
		sb.append(getCreditAppStatusId());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", termId=");
		sb.append(getTermId());
		sb.append(", purchaseOptionId=");
		sb.append(getPurchaseOptionId());
		sb.append(", rateFactorRuleId=");
		sb.append(getRateFactorRuleId());
		sb.append(", paymentAmount=");
		sb.append(getPaymentAmount());
		sb.append(", equipmentPrice=");
		sb.append(getEquipmentPrice());
		sb.append(", equipmentDesc=");
		sb.append(getEquipmentDesc());
		sb.append(", equipmentLocAsCustomerFlag=");
		sb.append(getEquipmentLocAsCustomerFlag());
		sb.append(", equipmentAddress1=");
		sb.append(getEquipmentAddress1());
		sb.append(", equipmentAddress2=");
		sb.append(getEquipmentAddress2());
		sb.append(", equipmentCity=");
		sb.append(getEquipmentCity());
		sb.append(", equipmentState=");
		sb.append(getEquipmentState());
		sb.append(", equipmentZip=");
		sb.append(getEquipmentZip());
		sb.append(", CustomerName=");
		sb.append(getCustomerName());
		sb.append(", CustomerDBAName=");
		sb.append(getCustomerDBAName());
		sb.append(", CustomerAddress1=");
		sb.append(getCustomerAddress1());
		sb.append(", CustomerAddress2=");
		sb.append(getCustomerAddress2());
		sb.append(", CustomerCity=");
		sb.append(getCustomerCity());
		sb.append(", CustomerState=");
		sb.append(getCustomerState());
		sb.append(", CustomerZip=");
		sb.append(getCustomerZip());
		sb.append(", CustomerContact=");
		sb.append(getCustomerContact());
		sb.append(", CustomerContactPhone=");
		sb.append(getCustomerContactPhone());
		sb.append(", CustomerContactFax=");
		sb.append(getCustomerContactFax());
		sb.append(", CustomerContactEmail=");
		sb.append(getCustomerContactEmail());
		sb.append(", CustomerBusinessDesc=");
		sb.append(getCustomerBusinessDesc());
		sb.append(", CustomerBusinessType=");
		sb.append(getCustomerBusinessType());
		sb.append(", CustomerBusinessStartDate=");
		sb.append(getCustomerBusinessStartDate());
		sb.append(", CustomerBusinessIncorporatedState=");
		sb.append(getCustomerBusinessIncorporatedState());
		sb.append(", CustomerBusinessFederalTaxID=");
		sb.append(getCustomerBusinessFederalTaxID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.CreditApp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>creditAppId</column-name><column-value><![CDATA[");
		sb.append(getCreditAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorId</column-name><column-value><![CDATA[");
		sb.append(getVendorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditAppStatusId</column-name><column-value><![CDATA[");
		sb.append(getCreditAppStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termId</column-name><column-value><![CDATA[");
		sb.append(getTermId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purchaseOptionId</column-name><column-value><![CDATA[");
		sb.append(getPurchaseOptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rateFactorRuleId</column-name><column-value><![CDATA[");
		sb.append(getRateFactorRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentAmount</column-name><column-value><![CDATA[");
		sb.append(getPaymentAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentPrice</column-name><column-value><![CDATA[");
		sb.append(getEquipmentPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentDesc</column-name><column-value><![CDATA[");
		sb.append(getEquipmentDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentLocAsCustomerFlag</column-name><column-value><![CDATA[");
		sb.append(getEquipmentLocAsCustomerFlag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentAddress1</column-name><column-value><![CDATA[");
		sb.append(getEquipmentAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentAddress2</column-name><column-value><![CDATA[");
		sb.append(getEquipmentAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentCity</column-name><column-value><![CDATA[");
		sb.append(getEquipmentCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentState</column-name><column-value><![CDATA[");
		sb.append(getEquipmentState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentZip</column-name><column-value><![CDATA[");
		sb.append(getEquipmentZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerName</column-name><column-value><![CDATA[");
		sb.append(getCustomerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerDBAName</column-name><column-value><![CDATA[");
		sb.append(getCustomerDBAName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerAddress1</column-name><column-value><![CDATA[");
		sb.append(getCustomerAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerAddress2</column-name><column-value><![CDATA[");
		sb.append(getCustomerAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerCity</column-name><column-value><![CDATA[");
		sb.append(getCustomerCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerState</column-name><column-value><![CDATA[");
		sb.append(getCustomerState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerZip</column-name><column-value><![CDATA[");
		sb.append(getCustomerZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerContact</column-name><column-value><![CDATA[");
		sb.append(getCustomerContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerContactPhone</column-name><column-value><![CDATA[");
		sb.append(getCustomerContactPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerContactFax</column-name><column-value><![CDATA[");
		sb.append(getCustomerContactFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerContactEmail</column-name><column-value><![CDATA[");
		sb.append(getCustomerContactEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerBusinessDesc</column-name><column-value><![CDATA[");
		sb.append(getCustomerBusinessDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerBusinessType</column-name><column-value><![CDATA[");
		sb.append(getCustomerBusinessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerBusinessStartDate</column-name><column-value><![CDATA[");
		sb.append(getCustomerBusinessStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerBusinessIncorporatedState</column-name><column-value><![CDATA[");
		sb.append(getCustomerBusinessIncorporatedState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CustomerBusinessFederalTaxID</column-name><column-value><![CDATA[");
		sb.append(getCustomerBusinessFederalTaxID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _creditAppId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _creditAppRemoteModel;
}