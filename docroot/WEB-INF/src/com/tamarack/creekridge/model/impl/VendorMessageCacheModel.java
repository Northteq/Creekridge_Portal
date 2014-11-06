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

import com.tamarack.creekridge.model.VendorMessage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VendorMessage in entity cache.
 *
 * @author pmacha
 * @see VendorMessage
 * @generated
 */
public class VendorMessageCacheModel implements CacheModel<VendorMessage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{vendorId=");
		sb.append(vendorId);
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
		sb.append(", key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VendorMessage toEntityModel() {
		VendorMessageImpl vendorMessageImpl = new VendorMessageImpl();

		vendorMessageImpl.setVendorId(vendorId);
		vendorMessageImpl.setCompanyId(companyId);
		vendorMessageImpl.setUserId(userId);

		if (userName == null) {
			vendorMessageImpl.setUserName(StringPool.BLANK);
		}
		else {
			vendorMessageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vendorMessageImpl.setCreateDate(null);
		}
		else {
			vendorMessageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vendorMessageImpl.setModifiedDate(null);
		}
		else {
			vendorMessageImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (key == null) {
			vendorMessageImpl.setKey(StringPool.BLANK);
		}
		else {
			vendorMessageImpl.setKey(key);
		}

		if (value == null) {
			vendorMessageImpl.setValue(StringPool.BLANK);
		}
		else {
			vendorMessageImpl.setValue(value);
		}

		vendorMessageImpl.resetOriginalValues();

		return vendorMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vendorId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		key = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(vendorId);
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

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long vendorId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String key;
	public String value;
}