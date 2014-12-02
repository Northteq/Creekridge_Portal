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

import com.tamarack.creekridge.model.CreditAppDocument;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditAppDocument in entity cache.
 *
 * @author tamarack
 * @see CreditAppDocument
 * @generated
 */
public class CreditAppDocumentCacheModel implements CacheModel<CreditAppDocument>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{CreditAppDocumentId=");
		sb.append(CreditAppDocumentId);
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
		sb.append(", documentTitle=");
		sb.append(documentTitle);
		sb.append(", documentFileName=");
		sb.append(documentFileName);

		return sb.toString();
	}

	@Override
	public CreditAppDocument toEntityModel() {
		CreditAppDocumentImpl creditAppDocumentImpl = new CreditAppDocumentImpl();

		creditAppDocumentImpl.setCreditAppDocumentId(CreditAppDocumentId);
		creditAppDocumentImpl.setCompanyId(companyId);
		creditAppDocumentImpl.setUserId(userId);

		if (userName == null) {
			creditAppDocumentImpl.setUserName(StringPool.BLANK);
		}
		else {
			creditAppDocumentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creditAppDocumentImpl.setCreateDate(null);
		}
		else {
			creditAppDocumentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creditAppDocumentImpl.setModifiedDate(null);
		}
		else {
			creditAppDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		creditAppDocumentImpl.setCreditAppId(creditAppId);
		creditAppDocumentImpl.setSequenceNumber(sequenceNumber);

		if (documentTitle == null) {
			creditAppDocumentImpl.setDocumentTitle(StringPool.BLANK);
		}
		else {
			creditAppDocumentImpl.setDocumentTitle(documentTitle);
		}

		if (documentFileName == null) {
			creditAppDocumentImpl.setDocumentFileName(StringPool.BLANK);
		}
		else {
			creditAppDocumentImpl.setDocumentFileName(documentFileName);
		}

		creditAppDocumentImpl.resetOriginalValues();

		return creditAppDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		CreditAppDocumentId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		creditAppId = objectInput.readLong();
		sequenceNumber = objectInput.readLong();
		documentTitle = objectInput.readUTF();
		documentFileName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(CreditAppDocumentId);
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

		if (documentTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(documentTitle);
		}

		if (documentFileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(documentFileName);
		}
	}

	public long CreditAppDocumentId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creditAppId;
	public long sequenceNumber;
	public String documentTitle;
	public String documentFileName;
}