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

import com.tamarack.creekridge.model.Vendor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Vendor in entity cache.
 *
 * @author pmacha
 * @see Vendor
 * @generated
 */
public class VendorCacheModel implements CacheModel<Vendor>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", multiSelectProduct=");
		sb.append(multiSelectProduct);
		sb.append(", multiSelectPurchaseOption=");
		sb.append(multiSelectPurchaseOption);
		sb.append(", multiSelectTerm=");
		sb.append(multiSelectTerm);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vendor toEntityModel() {
		VendorImpl vendorImpl = new VendorImpl();

		vendorImpl.setVendorId(vendorId);
		vendorImpl.setCompanyId(companyId);
		vendorImpl.setUserId(userId);

		if (userName == null) {
			vendorImpl.setUserName(StringPool.BLANK);
		}
		else {
			vendorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vendorImpl.setCreateDate(null);
		}
		else {
			vendorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vendorImpl.setModifiedDate(null);
		}
		else {
			vendorImpl.setModifiedDate(new Date(modifiedDate));
		}

		vendorImpl.setGroupId(groupId);
		vendorImpl.setMultiSelectProduct(multiSelectProduct);
		vendorImpl.setMultiSelectPurchaseOption(multiSelectPurchaseOption);
		vendorImpl.setMultiSelectTerm(multiSelectTerm);

		vendorImpl.resetOriginalValues();

		return vendorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vendorId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		groupId = objectInput.readLong();
		multiSelectProduct = objectInput.readBoolean();
		multiSelectPurchaseOption = objectInput.readBoolean();
		multiSelectTerm = objectInput.readBoolean();
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
		objectOutput.writeLong(groupId);
		objectOutput.writeBoolean(multiSelectProduct);
		objectOutput.writeBoolean(multiSelectPurchaseOption);
		objectOutput.writeBoolean(multiSelectTerm);
	}

	public long vendorId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long groupId;
	public boolean multiSelectProduct;
	public boolean multiSelectPurchaseOption;
	public boolean multiSelectTerm;
}