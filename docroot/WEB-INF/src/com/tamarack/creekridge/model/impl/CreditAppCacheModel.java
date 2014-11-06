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

package com.tamarack.creekridge.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.tamarack.creekridge.model.CreditApp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditApp in entity cache.
 *
 * @author pmacha
 * @see CreditApp
 * @generated
 */
public class CreditAppCacheModel implements CacheModel<CreditApp>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{creditAppId=");
		sb.append(creditAppId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", vendorId=");
		sb.append(vendorId);
		sb.append(", creditAppStatusId=");
		sb.append(creditAppStatusId);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", termId=");
		sb.append(termId);
		sb.append(", purchaseOptionId=");
		sb.append(purchaseOptionId);
		sb.append(", rateFactorRuleId=");
		sb.append(rateFactorRuleId);
		sb.append(", paymentAmount=");
		sb.append(paymentAmount);
		sb.append(", equipmentPrice=");
		sb.append(equipmentPrice);
		sb.append(", equipmentDesc=");
		sb.append(equipmentDesc);
		sb.append(", equipmentLocAsCustomerFlag=");
		sb.append(equipmentLocAsCustomerFlag);
		sb.append(", equipmentAddress1=");
		sb.append(equipmentAddress1);
		sb.append(", equipmentAddress2=");
		sb.append(equipmentAddress2);
		sb.append(", equipmentCity=");
		sb.append(equipmentCity);
		sb.append(", equipmentState=");
		sb.append(equipmentState);
		sb.append(", equipmentZip=");
		sb.append(equipmentZip);
		sb.append(", CustomerName=");
		sb.append(CustomerName);
		sb.append(", CustomerDBAName=");
		sb.append(CustomerDBAName);
		sb.append(", CustomerAddress1=");
		sb.append(CustomerAddress1);
		sb.append(", CustomerAddress2=");
		sb.append(CustomerAddress2);
		sb.append(", CustomerCity=");
		sb.append(CustomerCity);
		sb.append(", CustomerState=");
		sb.append(CustomerState);
		sb.append(", CustomerZip=");
		sb.append(CustomerZip);
		sb.append(", CustomerContact=");
		sb.append(CustomerContact);
		sb.append(", CustomerContactPhone=");
		sb.append(CustomerContactPhone);
		sb.append(", CustomerContactFax=");
		sb.append(CustomerContactFax);
		sb.append(", CustomerContactEmail=");
		sb.append(CustomerContactEmail);
		sb.append(", CustomerBusinessDesc=");
		sb.append(CustomerBusinessDesc);
		sb.append(", CustomerBusinessType=");
		sb.append(CustomerBusinessType);
		sb.append(", CustomerBusinessStartDate=");
		sb.append(CustomerBusinessStartDate);
		sb.append(", CustomerBusinessIncorporatedState=");
		sb.append(CustomerBusinessIncorporatedState);
		sb.append(", CustomerBusinessFederalTaxID=");
		sb.append(CustomerBusinessFederalTaxID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CreditApp toEntityModel() {
		CreditAppImpl creditAppImpl = new CreditAppImpl();

		creditAppImpl.setCreditAppId(creditAppId);
		creditAppImpl.setCompanyId(companyId);
		creditAppImpl.setUserId(userId);

		if (userName == null) {
			creditAppImpl.setUserName(StringPool.BLANK);
		}
		else {
			creditAppImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creditAppImpl.setCreateDate(null);
		}
		else {
			creditAppImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creditAppImpl.setModifiedDate(null);
		}
		else {
			creditAppImpl.setModifiedDate(new Date(modifiedDate));
		}

		creditAppImpl.setVendorId(vendorId);
		creditAppImpl.setCreditAppStatusId(creditAppStatusId);
		creditAppImpl.setProductId(productId);
		creditAppImpl.setTermId(termId);
		creditAppImpl.setPurchaseOptionId(purchaseOptionId);
		creditAppImpl.setRateFactorRuleId(rateFactorRuleId);
		creditAppImpl.setPaymentAmount(paymentAmount);
		creditAppImpl.setEquipmentPrice(equipmentPrice);

		if (equipmentDesc == null) {
			creditAppImpl.setEquipmentDesc(StringPool.BLANK);
		}
		else {
			creditAppImpl.setEquipmentDesc(equipmentDesc);
		}

		creditAppImpl.setEquipmentLocAsCustomerFlag(equipmentLocAsCustomerFlag);

		if (equipmentAddress1 == null) {
			creditAppImpl.setEquipmentAddress1(StringPool.BLANK);
		}
		else {
			creditAppImpl.setEquipmentAddress1(equipmentAddress1);
		}

		if (equipmentAddress2 == null) {
			creditAppImpl.setEquipmentAddress2(StringPool.BLANK);
		}
		else {
			creditAppImpl.setEquipmentAddress2(equipmentAddress2);
		}

		if (equipmentCity == null) {
			creditAppImpl.setEquipmentCity(StringPool.BLANK);
		}
		else {
			creditAppImpl.setEquipmentCity(equipmentCity);
		}

		if (equipmentState == null) {
			creditAppImpl.setEquipmentState(StringPool.BLANK);
		}
		else {
			creditAppImpl.setEquipmentState(equipmentState);
		}

		if (equipmentZip == null) {
			creditAppImpl.setEquipmentZip(StringPool.BLANK);
		}
		else {
			creditAppImpl.setEquipmentZip(equipmentZip);
		}

		if (CustomerName == null) {
			creditAppImpl.setCustomerName(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerName(CustomerName);
		}

		if (CustomerDBAName == null) {
			creditAppImpl.setCustomerDBAName(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerDBAName(CustomerDBAName);
		}

		if (CustomerAddress1 == null) {
			creditAppImpl.setCustomerAddress1(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerAddress1(CustomerAddress1);
		}

		if (CustomerAddress2 == null) {
			creditAppImpl.setCustomerAddress2(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerAddress2(CustomerAddress2);
		}

		if (CustomerCity == null) {
			creditAppImpl.setCustomerCity(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerCity(CustomerCity);
		}

		if (CustomerState == null) {
			creditAppImpl.setCustomerState(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerState(CustomerState);
		}

		if (CustomerZip == null) {
			creditAppImpl.setCustomerZip(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerZip(CustomerZip);
		}

		if (CustomerContact == null) {
			creditAppImpl.setCustomerContact(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerContact(CustomerContact);
		}

		if (CustomerContactPhone == null) {
			creditAppImpl.setCustomerContactPhone(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerContactPhone(CustomerContactPhone);
		}

		if (CustomerContactFax == null) {
			creditAppImpl.setCustomerContactFax(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerContactFax(CustomerContactFax);
		}

		if (CustomerContactEmail == null) {
			creditAppImpl.setCustomerContactEmail(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerContactEmail(CustomerContactEmail);
		}

		if (CustomerBusinessDesc == null) {
			creditAppImpl.setCustomerBusinessDesc(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerBusinessDesc(CustomerBusinessDesc);
		}

		if (CustomerBusinessType == null) {
			creditAppImpl.setCustomerBusinessType(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerBusinessType(CustomerBusinessType);
		}

		if (CustomerBusinessStartDate == Long.MIN_VALUE) {
			creditAppImpl.setCustomerBusinessStartDate(null);
		}
		else {
			creditAppImpl.setCustomerBusinessStartDate(new Date(
					CustomerBusinessStartDate));
		}

		if (CustomerBusinessIncorporatedState == null) {
			creditAppImpl.setCustomerBusinessIncorporatedState(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerBusinessIncorporatedState(CustomerBusinessIncorporatedState);
		}

		if (CustomerBusinessFederalTaxID == null) {
			creditAppImpl.setCustomerBusinessFederalTaxID(StringPool.BLANK);
		}
		else {
			creditAppImpl.setCustomerBusinessFederalTaxID(CustomerBusinessFederalTaxID);
		}

		creditAppImpl.resetOriginalValues();

		return creditAppImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		creditAppId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		vendorId = objectInput.readLong();
		creditAppStatusId = objectInput.readLong();
		productId = objectInput.readLong();
		termId = objectInput.readLong();
		purchaseOptionId = objectInput.readLong();
		rateFactorRuleId = objectInput.readLong();
		paymentAmount = objectInput.readDouble();
		equipmentPrice = objectInput.readDouble();
		equipmentDesc = objectInput.readUTF();
		equipmentLocAsCustomerFlag = objectInput.readBoolean();
		equipmentAddress1 = objectInput.readUTF();
		equipmentAddress2 = objectInput.readUTF();
		equipmentCity = objectInput.readUTF();
		equipmentState = objectInput.readUTF();
		equipmentZip = objectInput.readUTF();
		CustomerName = objectInput.readUTF();
		CustomerDBAName = objectInput.readUTF();
		CustomerAddress1 = objectInput.readUTF();
		CustomerAddress2 = objectInput.readUTF();
		CustomerCity = objectInput.readUTF();
		CustomerState = objectInput.readUTF();
		CustomerZip = objectInput.readUTF();
		CustomerContact = objectInput.readUTF();
		CustomerContactPhone = objectInput.readUTF();
		CustomerContactFax = objectInput.readUTF();
		CustomerContactEmail = objectInput.readUTF();
		CustomerBusinessDesc = objectInput.readUTF();
		CustomerBusinessType = objectInput.readUTF();
		CustomerBusinessStartDate = objectInput.readLong();
		CustomerBusinessIncorporatedState = objectInput.readUTF();
		CustomerBusinessFederalTaxID = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(creditAppId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(vendorId);
		objectOutput.writeLong(creditAppStatusId);
		objectOutput.writeLong(productId);
		objectOutput.writeLong(termId);
		objectOutput.writeLong(purchaseOptionId);
		objectOutput.writeLong(rateFactorRuleId);
		objectOutput.writeDouble(paymentAmount);
		objectOutput.writeDouble(equipmentPrice);

		if (equipmentDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentDesc);
		}

		objectOutput.writeBoolean(equipmentLocAsCustomerFlag);

		if (equipmentAddress1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentAddress1);
		}

		if (equipmentAddress2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentAddress2);
		}

		if (equipmentCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentCity);
		}

		if (equipmentState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentState);
		}

		if (equipmentZip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentZip);
		}

		if (CustomerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerName);
		}

		if (CustomerDBAName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerDBAName);
		}

		if (CustomerAddress1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerAddress1);
		}

		if (CustomerAddress2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerAddress2);
		}

		if (CustomerCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerCity);
		}

		if (CustomerState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerState);
		}

		if (CustomerZip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerZip);
		}

		if (CustomerContact == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerContact);
		}

		if (CustomerContactPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerContactPhone);
		}

		if (CustomerContactFax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerContactFax);
		}

		if (CustomerContactEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerContactEmail);
		}

		if (CustomerBusinessDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerBusinessDesc);
		}

		if (CustomerBusinessType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerBusinessType);
		}

		objectOutput.writeLong(CustomerBusinessStartDate);

		if (CustomerBusinessIncorporatedState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerBusinessIncorporatedState);
		}

		if (CustomerBusinessFederalTaxID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CustomerBusinessFederalTaxID);
		}
	}

	public long creditAppId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long vendorId;
	public long creditAppStatusId;
	public long productId;
	public long termId;
	public long purchaseOptionId;
	public long rateFactorRuleId;
	public double paymentAmount;
	public double equipmentPrice;
	public String equipmentDesc;
	public boolean equipmentLocAsCustomerFlag;
	public String equipmentAddress1;
	public String equipmentAddress2;
	public String equipmentCity;
	public String equipmentState;
	public String equipmentZip;
	public String CustomerName;
	public String CustomerDBAName;
	public String CustomerAddress1;
	public String CustomerAddress2;
	public String CustomerCity;
	public String CustomerState;
	public String CustomerZip;
	public String CustomerContact;
	public String CustomerContactPhone;
	public String CustomerContactFax;
	public String CustomerContactEmail;
	public String CustomerBusinessDesc;
	public String CustomerBusinessType;
	public long CustomerBusinessStartDate;
	public String CustomerBusinessIncorporatedState;
	public String CustomerBusinessFederalTaxID;
}