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

import com.tamarack.creekridge.model.RateFactorRule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RateFactorRule in entity cache.
 *
 * @author Tamarack Consulting
 * @see RateFactorRule
 * @generated
 */
public class RateFactorRuleCacheModel implements CacheModel<RateFactorRule>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{rateFactorRuleId=");
		sb.append(rateFactorRuleId);
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
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", termId=");
		sb.append(termId);
		sb.append(", purchaseOptionId=");
		sb.append(purchaseOptionId);
		sb.append(", vendorId=");
		sb.append(vendorId);
		sb.append(", minPrice=");
		sb.append(minPrice);
		sb.append(", rateFactor=");
		sb.append(rateFactor);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", active=");
		sb.append(active);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RateFactorRule toEntityModel() {
		RateFactorRuleImpl rateFactorRuleImpl = new RateFactorRuleImpl();

		rateFactorRuleImpl.setRateFactorRuleId(rateFactorRuleId);
		rateFactorRuleImpl.setCompanyId(companyId);
		rateFactorRuleImpl.setUserId(userId);

		if (userName == null) {
			rateFactorRuleImpl.setUserName(StringPool.BLANK);
		}
		else {
			rateFactorRuleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rateFactorRuleImpl.setCreateDate(null);
		}
		else {
			rateFactorRuleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rateFactorRuleImpl.setModifiedDate(null);
		}
		else {
			rateFactorRuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		rateFactorRuleImpl.setProductId(productId);
		rateFactorRuleImpl.setTermId(termId);
		rateFactorRuleImpl.setPurchaseOptionId(purchaseOptionId);
		rateFactorRuleImpl.setVendorId(vendorId);
		rateFactorRuleImpl.setMinPrice(minPrice);
		rateFactorRuleImpl.setRateFactor(rateFactor);

		if (effectiveDate == Long.MIN_VALUE) {
			rateFactorRuleImpl.setEffectiveDate(null);
		}
		else {
			rateFactorRuleImpl.setEffectiveDate(new Date(effectiveDate));
		}

		rateFactorRuleImpl.setActive(active);

		if (expirationDate == Long.MIN_VALUE) {
			rateFactorRuleImpl.setExpirationDate(null);
		}
		else {
			rateFactorRuleImpl.setExpirationDate(new Date(expirationDate));
		}

		rateFactorRuleImpl.resetOriginalValues();

		return rateFactorRuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rateFactorRuleId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		productId = objectInput.readLong();
		termId = objectInput.readLong();
		purchaseOptionId = objectInput.readLong();
		vendorId = objectInput.readLong();
		minPrice = objectInput.readDouble();
		rateFactor = objectInput.readDouble();
		effectiveDate = objectInput.readLong();
		active = objectInput.readBoolean();
		expirationDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(rateFactorRuleId);
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
		objectOutput.writeLong(productId);
		objectOutput.writeLong(termId);
		objectOutput.writeLong(purchaseOptionId);
		objectOutput.writeLong(vendorId);
		objectOutput.writeDouble(minPrice);
		objectOutput.writeDouble(rateFactor);
		objectOutput.writeLong(effectiveDate);
		objectOutput.writeBoolean(active);
		objectOutput.writeLong(expirationDate);
	}

	public long rateFactorRuleId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long productId;
	public long termId;
	public long purchaseOptionId;
	public long vendorId;
	public double minPrice;
	public double rateFactor;
	public long effectiveDate;
	public boolean active;
	public long expirationDate;
}