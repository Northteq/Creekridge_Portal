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

import com.tamarack.creekridge.model.CreditAppStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditAppStatus in entity cache.
 *
 * @author pmacha
 * @see CreditAppStatus
 * @generated
 */
public class CreditAppStatusCacheModel implements CacheModel<CreditAppStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{CreditAppStatusId=");
		sb.append(CreditAppStatusId);
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
		sb.append(", creditAppStatusName=");
		sb.append(creditAppStatusName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CreditAppStatus toEntityModel() {
		CreditAppStatusImpl creditAppStatusImpl = new CreditAppStatusImpl();

		creditAppStatusImpl.setCreditAppStatusId(CreditAppStatusId);
		creditAppStatusImpl.setCompanyId(companyId);
		creditAppStatusImpl.setUserId(userId);

		if (userName == null) {
			creditAppStatusImpl.setUserName(StringPool.BLANK);
		}
		else {
			creditAppStatusImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creditAppStatusImpl.setCreateDate(null);
		}
		else {
			creditAppStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creditAppStatusImpl.setModifiedDate(null);
		}
		else {
			creditAppStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (creditAppStatusName == null) {
			creditAppStatusImpl.setCreditAppStatusName(StringPool.BLANK);
		}
		else {
			creditAppStatusImpl.setCreditAppStatusName(creditAppStatusName);
		}

		creditAppStatusImpl.resetOriginalValues();

		return creditAppStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		CreditAppStatusId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		creditAppStatusName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(CreditAppStatusId);
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

		if (creditAppStatusName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(creditAppStatusName);
		}
	}

	public long CreditAppStatusId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String creditAppStatusName;
}