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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CreditApp}.
 * </p>
 *
 * @author pmacha
 * @see CreditApp
 * @generated
 */
public class CreditAppWrapper implements CreditApp, ModelWrapper<CreditApp> {
	public CreditAppWrapper(CreditApp creditApp) {
		_creditApp = creditApp;
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

	/**
	* Returns the primary key of this credit app.
	*
	* @return the primary key of this credit app
	*/
	@Override
	public long getPrimaryKey() {
		return _creditApp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this credit app.
	*
	* @param primaryKey the primary key of this credit app
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_creditApp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the credit app ID of this credit app.
	*
	* @return the credit app ID of this credit app
	*/
	@Override
	public long getCreditAppId() {
		return _creditApp.getCreditAppId();
	}

	/**
	* Sets the credit app ID of this credit app.
	*
	* @param creditAppId the credit app ID of this credit app
	*/
	@Override
	public void setCreditAppId(long creditAppId) {
		_creditApp.setCreditAppId(creditAppId);
	}

	/**
	* Returns the company ID of this credit app.
	*
	* @return the company ID of this credit app
	*/
	@Override
	public long getCompanyId() {
		return _creditApp.getCompanyId();
	}

	/**
	* Sets the company ID of this credit app.
	*
	* @param companyId the company ID of this credit app
	*/
	@Override
	public void setCompanyId(long companyId) {
		_creditApp.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this credit app.
	*
	* @return the user ID of this credit app
	*/
	@Override
	public long getUserId() {
		return _creditApp.getUserId();
	}

	/**
	* Sets the user ID of this credit app.
	*
	* @param userId the user ID of this credit app
	*/
	@Override
	public void setUserId(long userId) {
		_creditApp.setUserId(userId);
	}

	/**
	* Returns the user uuid of this credit app.
	*
	* @return the user uuid of this credit app
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditApp.getUserUuid();
	}

	/**
	* Sets the user uuid of this credit app.
	*
	* @param userUuid the user uuid of this credit app
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_creditApp.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this credit app.
	*
	* @return the user name of this credit app
	*/
	@Override
	public java.lang.String getUserName() {
		return _creditApp.getUserName();
	}

	/**
	* Sets the user name of this credit app.
	*
	* @param userName the user name of this credit app
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_creditApp.setUserName(userName);
	}

	/**
	* Returns the create date of this credit app.
	*
	* @return the create date of this credit app
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _creditApp.getCreateDate();
	}

	/**
	* Sets the create date of this credit app.
	*
	* @param createDate the create date of this credit app
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_creditApp.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this credit app.
	*
	* @return the modified date of this credit app
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _creditApp.getModifiedDate();
	}

	/**
	* Sets the modified date of this credit app.
	*
	* @param modifiedDate the modified date of this credit app
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_creditApp.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the vendor ID of this credit app.
	*
	* @return the vendor ID of this credit app
	*/
	@Override
	public long getVendorId() {
		return _creditApp.getVendorId();
	}

	/**
	* Sets the vendor ID of this credit app.
	*
	* @param vendorId the vendor ID of this credit app
	*/
	@Override
	public void setVendorId(long vendorId) {
		_creditApp.setVendorId(vendorId);
	}

	/**
	* Returns the credit app status ID of this credit app.
	*
	* @return the credit app status ID of this credit app
	*/
	@Override
	public long getCreditAppStatusId() {
		return _creditApp.getCreditAppStatusId();
	}

	/**
	* Sets the credit app status ID of this credit app.
	*
	* @param creditAppStatusId the credit app status ID of this credit app
	*/
	@Override
	public void setCreditAppStatusId(long creditAppStatusId) {
		_creditApp.setCreditAppStatusId(creditAppStatusId);
	}

	/**
	* Returns the product ID of this credit app.
	*
	* @return the product ID of this credit app
	*/
	@Override
	public long getProductId() {
		return _creditApp.getProductId();
	}

	/**
	* Sets the product ID of this credit app.
	*
	* @param productId the product ID of this credit app
	*/
	@Override
	public void setProductId(long productId) {
		_creditApp.setProductId(productId);
	}

	/**
	* Returns the term ID of this credit app.
	*
	* @return the term ID of this credit app
	*/
	@Override
	public long getTermId() {
		return _creditApp.getTermId();
	}

	/**
	* Sets the term ID of this credit app.
	*
	* @param termId the term ID of this credit app
	*/
	@Override
	public void setTermId(long termId) {
		_creditApp.setTermId(termId);
	}

	/**
	* Returns the purchase option ID of this credit app.
	*
	* @return the purchase option ID of this credit app
	*/
	@Override
	public long getPurchaseOptionId() {
		return _creditApp.getPurchaseOptionId();
	}

	/**
	* Sets the purchase option ID of this credit app.
	*
	* @param purchaseOptionId the purchase option ID of this credit app
	*/
	@Override
	public void setPurchaseOptionId(long purchaseOptionId) {
		_creditApp.setPurchaseOptionId(purchaseOptionId);
	}

	/**
	* Returns the rate factor rule ID of this credit app.
	*
	* @return the rate factor rule ID of this credit app
	*/
	@Override
	public long getRateFactorRuleId() {
		return _creditApp.getRateFactorRuleId();
	}

	/**
	* Sets the rate factor rule ID of this credit app.
	*
	* @param rateFactorRuleId the rate factor rule ID of this credit app
	*/
	@Override
	public void setRateFactorRuleId(long rateFactorRuleId) {
		_creditApp.setRateFactorRuleId(rateFactorRuleId);
	}

	/**
	* Returns the payment amount of this credit app.
	*
	* @return the payment amount of this credit app
	*/
	@Override
	public double getPaymentAmount() {
		return _creditApp.getPaymentAmount();
	}

	/**
	* Sets the payment amount of this credit app.
	*
	* @param paymentAmount the payment amount of this credit app
	*/
	@Override
	public void setPaymentAmount(double paymentAmount) {
		_creditApp.setPaymentAmount(paymentAmount);
	}

	/**
	* Returns the equipment price of this credit app.
	*
	* @return the equipment price of this credit app
	*/
	@Override
	public double getEquipmentPrice() {
		return _creditApp.getEquipmentPrice();
	}

	/**
	* Sets the equipment price of this credit app.
	*
	* @param equipmentPrice the equipment price of this credit app
	*/
	@Override
	public void setEquipmentPrice(double equipmentPrice) {
		_creditApp.setEquipmentPrice(equipmentPrice);
	}

	/**
	* Returns the equipment desc of this credit app.
	*
	* @return the equipment desc of this credit app
	*/
	@Override
	public java.lang.String getEquipmentDesc() {
		return _creditApp.getEquipmentDesc();
	}

	/**
	* Sets the equipment desc of this credit app.
	*
	* @param equipmentDesc the equipment desc of this credit app
	*/
	@Override
	public void setEquipmentDesc(java.lang.String equipmentDesc) {
		_creditApp.setEquipmentDesc(equipmentDesc);
	}

	/**
	* Returns the equipment loc as customer flag of this credit app.
	*
	* @return the equipment loc as customer flag of this credit app
	*/
	@Override
	public boolean getEquipmentLocAsCustomerFlag() {
		return _creditApp.getEquipmentLocAsCustomerFlag();
	}

	/**
	* Returns <code>true</code> if this credit app is equipment loc as customer flag.
	*
	* @return <code>true</code> if this credit app is equipment loc as customer flag; <code>false</code> otherwise
	*/
	@Override
	public boolean isEquipmentLocAsCustomerFlag() {
		return _creditApp.isEquipmentLocAsCustomerFlag();
	}

	/**
	* Sets whether this credit app is equipment loc as customer flag.
	*
	* @param equipmentLocAsCustomerFlag the equipment loc as customer flag of this credit app
	*/
	@Override
	public void setEquipmentLocAsCustomerFlag(
		boolean equipmentLocAsCustomerFlag) {
		_creditApp.setEquipmentLocAsCustomerFlag(equipmentLocAsCustomerFlag);
	}

	/**
	* Returns the equipment address1 of this credit app.
	*
	* @return the equipment address1 of this credit app
	*/
	@Override
	public java.lang.String getEquipmentAddress1() {
		return _creditApp.getEquipmentAddress1();
	}

	/**
	* Sets the equipment address1 of this credit app.
	*
	* @param equipmentAddress1 the equipment address1 of this credit app
	*/
	@Override
	public void setEquipmentAddress1(java.lang.String equipmentAddress1) {
		_creditApp.setEquipmentAddress1(equipmentAddress1);
	}

	/**
	* Returns the equipment address2 of this credit app.
	*
	* @return the equipment address2 of this credit app
	*/
	@Override
	public java.lang.String getEquipmentAddress2() {
		return _creditApp.getEquipmentAddress2();
	}

	/**
	* Sets the equipment address2 of this credit app.
	*
	* @param equipmentAddress2 the equipment address2 of this credit app
	*/
	@Override
	public void setEquipmentAddress2(java.lang.String equipmentAddress2) {
		_creditApp.setEquipmentAddress2(equipmentAddress2);
	}

	/**
	* Returns the equipment city of this credit app.
	*
	* @return the equipment city of this credit app
	*/
	@Override
	public java.lang.String getEquipmentCity() {
		return _creditApp.getEquipmentCity();
	}

	/**
	* Sets the equipment city of this credit app.
	*
	* @param equipmentCity the equipment city of this credit app
	*/
	@Override
	public void setEquipmentCity(java.lang.String equipmentCity) {
		_creditApp.setEquipmentCity(equipmentCity);
	}

	/**
	* Returns the equipment state of this credit app.
	*
	* @return the equipment state of this credit app
	*/
	@Override
	public java.lang.String getEquipmentState() {
		return _creditApp.getEquipmentState();
	}

	/**
	* Sets the equipment state of this credit app.
	*
	* @param equipmentState the equipment state of this credit app
	*/
	@Override
	public void setEquipmentState(java.lang.String equipmentState) {
		_creditApp.setEquipmentState(equipmentState);
	}

	/**
	* Returns the equipment zip of this credit app.
	*
	* @return the equipment zip of this credit app
	*/
	@Override
	public java.lang.String getEquipmentZip() {
		return _creditApp.getEquipmentZip();
	}

	/**
	* Sets the equipment zip of this credit app.
	*
	* @param equipmentZip the equipment zip of this credit app
	*/
	@Override
	public void setEquipmentZip(java.lang.String equipmentZip) {
		_creditApp.setEquipmentZip(equipmentZip);
	}

	/**
	* Returns the customer name of this credit app.
	*
	* @return the customer name of this credit app
	*/
	@Override
	public java.lang.String getCustomerName() {
		return _creditApp.getCustomerName();
	}

	/**
	* Sets the customer name of this credit app.
	*
	* @param CustomerName the customer name of this credit app
	*/
	@Override
	public void setCustomerName(java.lang.String CustomerName) {
		_creditApp.setCustomerName(CustomerName);
	}

	/**
	* Returns the customer d b a name of this credit app.
	*
	* @return the customer d b a name of this credit app
	*/
	@Override
	public java.lang.String getCustomerDBAName() {
		return _creditApp.getCustomerDBAName();
	}

	/**
	* Sets the customer d b a name of this credit app.
	*
	* @param CustomerDBAName the customer d b a name of this credit app
	*/
	@Override
	public void setCustomerDBAName(java.lang.String CustomerDBAName) {
		_creditApp.setCustomerDBAName(CustomerDBAName);
	}

	/**
	* Returns the customer address1 of this credit app.
	*
	* @return the customer address1 of this credit app
	*/
	@Override
	public java.lang.String getCustomerAddress1() {
		return _creditApp.getCustomerAddress1();
	}

	/**
	* Sets the customer address1 of this credit app.
	*
	* @param CustomerAddress1 the customer address1 of this credit app
	*/
	@Override
	public void setCustomerAddress1(java.lang.String CustomerAddress1) {
		_creditApp.setCustomerAddress1(CustomerAddress1);
	}

	/**
	* Returns the customer address2 of this credit app.
	*
	* @return the customer address2 of this credit app
	*/
	@Override
	public java.lang.String getCustomerAddress2() {
		return _creditApp.getCustomerAddress2();
	}

	/**
	* Sets the customer address2 of this credit app.
	*
	* @param CustomerAddress2 the customer address2 of this credit app
	*/
	@Override
	public void setCustomerAddress2(java.lang.String CustomerAddress2) {
		_creditApp.setCustomerAddress2(CustomerAddress2);
	}

	/**
	* Returns the customer city of this credit app.
	*
	* @return the customer city of this credit app
	*/
	@Override
	public java.lang.String getCustomerCity() {
		return _creditApp.getCustomerCity();
	}

	/**
	* Sets the customer city of this credit app.
	*
	* @param CustomerCity the customer city of this credit app
	*/
	@Override
	public void setCustomerCity(java.lang.String CustomerCity) {
		_creditApp.setCustomerCity(CustomerCity);
	}

	/**
	* Returns the customer state of this credit app.
	*
	* @return the customer state of this credit app
	*/
	@Override
	public java.lang.String getCustomerState() {
		return _creditApp.getCustomerState();
	}

	/**
	* Sets the customer state of this credit app.
	*
	* @param CustomerState the customer state of this credit app
	*/
	@Override
	public void setCustomerState(java.lang.String CustomerState) {
		_creditApp.setCustomerState(CustomerState);
	}

	/**
	* Returns the customer zip of this credit app.
	*
	* @return the customer zip of this credit app
	*/
	@Override
	public java.lang.String getCustomerZip() {
		return _creditApp.getCustomerZip();
	}

	/**
	* Sets the customer zip of this credit app.
	*
	* @param CustomerZip the customer zip of this credit app
	*/
	@Override
	public void setCustomerZip(java.lang.String CustomerZip) {
		_creditApp.setCustomerZip(CustomerZip);
	}

	/**
	* Returns the customer contact of this credit app.
	*
	* @return the customer contact of this credit app
	*/
	@Override
	public java.lang.String getCustomerContact() {
		return _creditApp.getCustomerContact();
	}

	/**
	* Sets the customer contact of this credit app.
	*
	* @param CustomerContact the customer contact of this credit app
	*/
	@Override
	public void setCustomerContact(java.lang.String CustomerContact) {
		_creditApp.setCustomerContact(CustomerContact);
	}

	/**
	* Returns the customer contact phone of this credit app.
	*
	* @return the customer contact phone of this credit app
	*/
	@Override
	public java.lang.String getCustomerContactPhone() {
		return _creditApp.getCustomerContactPhone();
	}

	/**
	* Sets the customer contact phone of this credit app.
	*
	* @param CustomerContactPhone the customer contact phone of this credit app
	*/
	@Override
	public void setCustomerContactPhone(java.lang.String CustomerContactPhone) {
		_creditApp.setCustomerContactPhone(CustomerContactPhone);
	}

	/**
	* Returns the customer contact fax of this credit app.
	*
	* @return the customer contact fax of this credit app
	*/
	@Override
	public java.lang.String getCustomerContactFax() {
		return _creditApp.getCustomerContactFax();
	}

	/**
	* Sets the customer contact fax of this credit app.
	*
	* @param CustomerContactFax the customer contact fax of this credit app
	*/
	@Override
	public void setCustomerContactFax(java.lang.String CustomerContactFax) {
		_creditApp.setCustomerContactFax(CustomerContactFax);
	}

	/**
	* Returns the customer contact email of this credit app.
	*
	* @return the customer contact email of this credit app
	*/
	@Override
	public java.lang.String getCustomerContactEmail() {
		return _creditApp.getCustomerContactEmail();
	}

	/**
	* Sets the customer contact email of this credit app.
	*
	* @param CustomerContactEmail the customer contact email of this credit app
	*/
	@Override
	public void setCustomerContactEmail(java.lang.String CustomerContactEmail) {
		_creditApp.setCustomerContactEmail(CustomerContactEmail);
	}

	/**
	* Returns the customer business desc of this credit app.
	*
	* @return the customer business desc of this credit app
	*/
	@Override
	public java.lang.String getCustomerBusinessDesc() {
		return _creditApp.getCustomerBusinessDesc();
	}

	/**
	* Sets the customer business desc of this credit app.
	*
	* @param CustomerBusinessDesc the customer business desc of this credit app
	*/
	@Override
	public void setCustomerBusinessDesc(java.lang.String CustomerBusinessDesc) {
		_creditApp.setCustomerBusinessDesc(CustomerBusinessDesc);
	}

	/**
	* Returns the customer business type of this credit app.
	*
	* @return the customer business type of this credit app
	*/
	@Override
	public java.lang.String getCustomerBusinessType() {
		return _creditApp.getCustomerBusinessType();
	}

	/**
	* Sets the customer business type of this credit app.
	*
	* @param CustomerBusinessType the customer business type of this credit app
	*/
	@Override
	public void setCustomerBusinessType(java.lang.String CustomerBusinessType) {
		_creditApp.setCustomerBusinessType(CustomerBusinessType);
	}

	/**
	* Returns the customer business start date of this credit app.
	*
	* @return the customer business start date of this credit app
	*/
	@Override
	public java.util.Date getCustomerBusinessStartDate() {
		return _creditApp.getCustomerBusinessStartDate();
	}

	/**
	* Sets the customer business start date of this credit app.
	*
	* @param CustomerBusinessStartDate the customer business start date of this credit app
	*/
	@Override
	public void setCustomerBusinessStartDate(
		java.util.Date CustomerBusinessStartDate) {
		_creditApp.setCustomerBusinessStartDate(CustomerBusinessStartDate);
	}

	/**
	* Returns the customer business incorporated state of this credit app.
	*
	* @return the customer business incorporated state of this credit app
	*/
	@Override
	public java.lang.String getCustomerBusinessIncorporatedState() {
		return _creditApp.getCustomerBusinessIncorporatedState();
	}

	/**
	* Sets the customer business incorporated state of this credit app.
	*
	* @param CustomerBusinessIncorporatedState the customer business incorporated state of this credit app
	*/
	@Override
	public void setCustomerBusinessIncorporatedState(
		java.lang.String CustomerBusinessIncorporatedState) {
		_creditApp.setCustomerBusinessIncorporatedState(CustomerBusinessIncorporatedState);
	}

	/**
	* Returns the customer business federal tax i d of this credit app.
	*
	* @return the customer business federal tax i d of this credit app
	*/
	@Override
	public java.lang.String getCustomerBusinessFederalTaxID() {
		return _creditApp.getCustomerBusinessFederalTaxID();
	}

	/**
	* Sets the customer business federal tax i d of this credit app.
	*
	* @param CustomerBusinessFederalTaxID the customer business federal tax i d of this credit app
	*/
	@Override
	public void setCustomerBusinessFederalTaxID(
		java.lang.String CustomerBusinessFederalTaxID) {
		_creditApp.setCustomerBusinessFederalTaxID(CustomerBusinessFederalTaxID);
	}

	@Override
	public boolean isNew() {
		return _creditApp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_creditApp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _creditApp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_creditApp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _creditApp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _creditApp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_creditApp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _creditApp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_creditApp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_creditApp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_creditApp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CreditAppWrapper((CreditApp)_creditApp.clone());
	}

	@Override
	public int compareTo(com.tamarack.creekridge.model.CreditApp creditApp) {
		return _creditApp.compareTo(creditApp);
	}

	@Override
	public int hashCode() {
		return _creditApp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.CreditApp> toCacheModel() {
		return _creditApp.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.CreditApp toEscapedModel() {
		return new CreditAppWrapper(_creditApp.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.CreditApp toUnescapedModel() {
		return new CreditAppWrapper(_creditApp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _creditApp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _creditApp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_creditApp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditAppWrapper)) {
			return false;
		}

		CreditAppWrapper creditAppWrapper = (CreditAppWrapper)obj;

		if (Validator.equals(_creditApp, creditAppWrapper._creditApp)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CreditApp getWrappedCreditApp() {
		return _creditApp;
	}

	@Override
	public CreditApp getWrappedModel() {
		return _creditApp;
	}

	@Override
	public void resetOriginalValues() {
		_creditApp.resetOriginalValues();
	}

	private CreditApp _creditApp;
}