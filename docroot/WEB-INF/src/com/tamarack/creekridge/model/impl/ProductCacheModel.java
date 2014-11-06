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

import com.tamarack.creekridge.model.Product;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author pmacha
 * @see Product
 * @generated
 */
public class ProductCacheModel implements CacheModel<Product>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{productId=");
		sb.append(productId);
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
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", sequenceNumber=");
		sb.append(sequenceNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setProductId(productId);
		productImpl.setCompanyId(companyId);
		productImpl.setUserId(userId);

		if (userName == null) {
			productImpl.setUserName(StringPool.BLANK);
		}
		else {
			productImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productImpl.setCreateDate(null);
		}
		else {
			productImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productImpl.setModifiedDate(null);
		}
		else {
			productImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (productName == null) {
			productImpl.setProductName(StringPool.BLANK);
		}
		else {
			productImpl.setProductName(productName);
		}

		productImpl.setSequenceNumber(sequenceNumber);

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		productName = objectInput.readUTF();
		sequenceNumber = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(productId);
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

		if (productName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productName);
		}

		objectOutput.writeLong(sequenceNumber);
	}

	public long productId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String productName;
	public long sequenceNumber;
}