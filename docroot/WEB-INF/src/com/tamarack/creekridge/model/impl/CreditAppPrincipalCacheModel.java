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

package com.tamarack.creekridge.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.tamarack.creekridge.model.CreditAppPrincipal;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditAppPrincipal in entity cache.
 *
 * @author Tamarack Consulting
 * @see CreditAppPrincipal
 * @generated
 */
public class CreditAppPrincipalCacheModel implements CacheModel<CreditAppPrincipal>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{principalId=");
		sb.append(principalId);
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
		sb.append(", principalFirstName=");
		sb.append(principalFirstName);
		sb.append(", principalMiddleName=");
		sb.append(principalMiddleName);
		sb.append(", principalLastName=");
		sb.append(principalLastName);
		sb.append(", principalSSN=");
		sb.append(principalSSN);
		sb.append(", principalHomePhoneNumber=");
		sb.append(principalHomePhoneNumber);
		sb.append(", principalAddress1=");
		sb.append(principalAddress1);
		sb.append(", principalAddress2=");
		sb.append(principalAddress2);
		sb.append(", principalCity=");
		sb.append(principalCity);
		sb.append(", principalState=");
		sb.append(principalState);
		sb.append(", principalZip=");
		sb.append(principalZip);
		sb.append(", principalEmail=");
		sb.append(principalEmail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CreditAppPrincipal toEntityModel() {
		CreditAppPrincipalImpl creditAppPrincipalImpl = new CreditAppPrincipalImpl();

		creditAppPrincipalImpl.setPrincipalId(principalId);
		creditAppPrincipalImpl.setCompanyId(companyId);
		creditAppPrincipalImpl.setUserId(userId);

		if (userName == null) {
			creditAppPrincipalImpl.setUserName(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creditAppPrincipalImpl.setCreateDate(null);
		}
		else {
			creditAppPrincipalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creditAppPrincipalImpl.setModifiedDate(null);
		}
		else {
			creditAppPrincipalImpl.setModifiedDate(new Date(modifiedDate));
		}

		creditAppPrincipalImpl.setCreditAppId(creditAppId);
		creditAppPrincipalImpl.setSequenceNumber(sequenceNumber);

		if (principalFirstName == null) {
			creditAppPrincipalImpl.setPrincipalFirstName(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalFirstName(principalFirstName);
		}

		if (principalMiddleName == null) {
			creditAppPrincipalImpl.setPrincipalMiddleName(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalMiddleName(principalMiddleName);
		}

		if (principalLastName == null) {
			creditAppPrincipalImpl.setPrincipalLastName(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalLastName(principalLastName);
		}

		if (principalSSN == null) {
			creditAppPrincipalImpl.setPrincipalSSN(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalSSN(principalSSN);
		}

		if (principalHomePhoneNumber == null) {
			creditAppPrincipalImpl.setPrincipalHomePhoneNumber(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalHomePhoneNumber(principalHomePhoneNumber);
		}

		if (principalAddress1 == null) {
			creditAppPrincipalImpl.setPrincipalAddress1(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalAddress1(principalAddress1);
		}

		if (principalAddress2 == null) {
			creditAppPrincipalImpl.setPrincipalAddress2(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalAddress2(principalAddress2);
		}

		if (principalCity == null) {
			creditAppPrincipalImpl.setPrincipalCity(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalCity(principalCity);
		}

		if (principalState == null) {
			creditAppPrincipalImpl.setPrincipalState(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalState(principalState);
		}

		if (principalZip == null) {
			creditAppPrincipalImpl.setPrincipalZip(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalZip(principalZip);
		}

		if (principalEmail == null) {
			creditAppPrincipalImpl.setPrincipalEmail(StringPool.BLANK);
		}
		else {
			creditAppPrincipalImpl.setPrincipalEmail(principalEmail);
		}

		creditAppPrincipalImpl.resetOriginalValues();

		return creditAppPrincipalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		principalId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		creditAppId = objectInput.readLong();
		sequenceNumber = objectInput.readLong();
		principalFirstName = objectInput.readUTF();
		principalMiddleName = objectInput.readUTF();
		principalLastName = objectInput.readUTF();
		principalSSN = objectInput.readUTF();
		principalHomePhoneNumber = objectInput.readUTF();
		principalAddress1 = objectInput.readUTF();
		principalAddress2 = objectInput.readUTF();
		principalCity = objectInput.readUTF();
		principalState = objectInput.readUTF();
		principalZip = objectInput.readUTF();
		principalEmail = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(principalId);
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

		if (principalFirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalFirstName);
		}

		if (principalMiddleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalMiddleName);
		}

		if (principalLastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalLastName);
		}

		if (principalSSN == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalSSN);
		}

		if (principalHomePhoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalHomePhoneNumber);
		}

		if (principalAddress1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalAddress1);
		}

		if (principalAddress2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalAddress2);
		}

		if (principalCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalCity);
		}

		if (principalState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalState);
		}

		if (principalZip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalZip);
		}

		if (principalEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principalEmail);
		}
	}

	public long principalId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creditAppId;
	public long sequenceNumber;
	public String principalFirstName;
	public String principalMiddleName;
	public String principalLastName;
	public String principalSSN;
	public String principalHomePhoneNumber;
	public String principalAddress1;
	public String principalAddress2;
	public String principalCity;
	public String principalState;
	public String principalZip;
	public String principalEmail;
}