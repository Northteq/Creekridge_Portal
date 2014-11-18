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

import com.tamarack.creekridge.model.PurchaseOption;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PurchaseOption in entity cache.
 *
 * @author pmacha
 * @see PurchaseOption
 * @generated
 */
public class PurchaseOptionCacheModel implements CacheModel<PurchaseOption>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{purchaseOptionId=");
		sb.append(purchaseOptionId);
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
		sb.append(", purchaseOptionName=");
		sb.append(purchaseOptionName);
		sb.append(", sequenceNumber=");
		sb.append(sequenceNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PurchaseOption toEntityModel() {
		PurchaseOptionImpl purchaseOptionImpl = new PurchaseOptionImpl();

		purchaseOptionImpl.setPurchaseOptionId(purchaseOptionId);
		purchaseOptionImpl.setCompanyId(companyId);
		purchaseOptionImpl.setUserId(userId);

		if (userName == null) {
			purchaseOptionImpl.setUserName(StringPool.BLANK);
		}
		else {
			purchaseOptionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			purchaseOptionImpl.setCreateDate(null);
		}
		else {
			purchaseOptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			purchaseOptionImpl.setModifiedDate(null);
		}
		else {
			purchaseOptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (purchaseOptionName == null) {
			purchaseOptionImpl.setPurchaseOptionName(StringPool.BLANK);
		}
		else {
			purchaseOptionImpl.setPurchaseOptionName(purchaseOptionName);
		}

		purchaseOptionImpl.setSequenceNumber(sequenceNumber);

		purchaseOptionImpl.resetOriginalValues();

		return purchaseOptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		purchaseOptionId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		purchaseOptionName = objectInput.readUTF();
		sequenceNumber = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(purchaseOptionId);
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

		if (purchaseOptionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(purchaseOptionName);
		}

		objectOutput.writeLong(sequenceNumber);
	}

	public long purchaseOptionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String purchaseOptionName;
	public long sequenceNumber;
}