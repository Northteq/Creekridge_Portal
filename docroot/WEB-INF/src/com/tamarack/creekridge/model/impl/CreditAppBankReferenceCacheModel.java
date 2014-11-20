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

import com.tamarack.creekridge.model.CreditAppBankReference;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditAppBankReference in entity cache.
 *
 * @author pmacha
 * @see CreditAppBankReference
 * @generated
 */
public class CreditAppBankReferenceCacheModel implements CacheModel<CreditAppBankReference>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{bankReferenceId=");
		sb.append(bankReferenceId);
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
		sb.append(", creditAppId=");
		sb.append(creditAppId);
		sb.append(", sequenceNumber=");
		sb.append(sequenceNumber);
		sb.append(", bankReferenceName=");
		sb.append(bankReferenceName);
		sb.append(", bankReferenceContact=");
		sb.append(bankReferenceContact);
		sb.append(", bankReferencePhone=");
		sb.append(bankReferencePhone);
		sb.append(", bankReferencAccountType=");
		sb.append(bankReferencAccountType);
		sb.append(", bankReferenceAccountNumber=");
		sb.append(bankReferenceAccountNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CreditAppBankReference toEntityModel() {
		CreditAppBankReferenceImpl creditAppBankReferenceImpl = new CreditAppBankReferenceImpl();

		creditAppBankReferenceImpl.setBankReferenceId(bankReferenceId);
		creditAppBankReferenceImpl.setCompanyId(companyId);
		creditAppBankReferenceImpl.setUserId(userId);

		if (userName == null) {
			creditAppBankReferenceImpl.setUserName(StringPool.BLANK);
		}
		else {
			creditAppBankReferenceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creditAppBankReferenceImpl.setCreateDate(null);
		}
		else {
			creditAppBankReferenceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creditAppBankReferenceImpl.setModifiedDate(null);
		}
		else {
			creditAppBankReferenceImpl.setModifiedDate(new Date(modifiedDate));
		}

		creditAppBankReferenceImpl.setCreditAppId(creditAppId);
		creditAppBankReferenceImpl.setSequenceNumber(sequenceNumber);

		if (bankReferenceName == null) {
			creditAppBankReferenceImpl.setBankReferenceName(StringPool.BLANK);
		}
		else {
			creditAppBankReferenceImpl.setBankReferenceName(bankReferenceName);
		}

		if (bankReferenceContact == null) {
			creditAppBankReferenceImpl.setBankReferenceContact(StringPool.BLANK);
		}
		else {
			creditAppBankReferenceImpl.setBankReferenceContact(bankReferenceContact);
		}

		if (bankReferencePhone == null) {
			creditAppBankReferenceImpl.setBankReferencePhone(StringPool.BLANK);
		}
		else {
			creditAppBankReferenceImpl.setBankReferencePhone(bankReferencePhone);
		}

		if (bankReferencAccountType == null) {
			creditAppBankReferenceImpl.setBankReferencAccountType(StringPool.BLANK);
		}
		else {
			creditAppBankReferenceImpl.setBankReferencAccountType(bankReferencAccountType);
		}

		if (bankReferenceAccountNumber == null) {
			creditAppBankReferenceImpl.setBankReferenceAccountNumber(StringPool.BLANK);
		}
		else {
			creditAppBankReferenceImpl.setBankReferenceAccountNumber(bankReferenceAccountNumber);
		}

		creditAppBankReferenceImpl.resetOriginalValues();

		return creditAppBankReferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bankReferenceId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		creditAppId = objectInput.readLong();
		sequenceNumber = objectInput.readLong();
		bankReferenceName = objectInput.readUTF();
		bankReferenceContact = objectInput.readUTF();
		bankReferencePhone = objectInput.readUTF();
		bankReferencAccountType = objectInput.readUTF();
		bankReferenceAccountNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bankReferenceId);
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
		objectOutput.writeLong(creditAppId);
		objectOutput.writeLong(sequenceNumber);

		if (bankReferenceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankReferenceName);
		}

		if (bankReferenceContact == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankReferenceContact);
		}

		if (bankReferencePhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankReferencePhone);
		}

		if (bankReferencAccountType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankReferencAccountType);
		}

		if (bankReferenceAccountNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankReferenceAccountNumber);
		}
	}

	public long bankReferenceId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creditAppId;
	public long sequenceNumber;
	public String bankReferenceName;
	public String bankReferenceContact;
	public String bankReferencePhone;
	public String bankReferencAccountType;
	public String bankReferenceAccountNumber;
}