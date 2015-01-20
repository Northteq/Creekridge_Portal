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

import com.tamarack.creekridge.model.Term;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Term in entity cache.
 *
 * @author Tamarack Consulting
 * @see Term
 * @generated
 */
public class TermCacheModel implements CacheModel<Term>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{termId=");
		sb.append(termId);
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
		sb.append(", termMonths=");
		sb.append(termMonths);
		sb.append(", termName=");
		sb.append(termName);
		sb.append(", sequenceNumber=");
		sb.append(sequenceNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Term toEntityModel() {
		TermImpl termImpl = new TermImpl();

		termImpl.setTermId(termId);
		termImpl.setCompanyId(companyId);
		termImpl.setUserId(userId);

		if (userName == null) {
			termImpl.setUserName(StringPool.BLANK);
		}
		else {
			termImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			termImpl.setCreateDate(null);
		}
		else {
			termImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			termImpl.setModifiedDate(null);
		}
		else {
			termImpl.setModifiedDate(new Date(modifiedDate));
		}

		termImpl.setTermMonths(termMonths);

		if (termName == null) {
			termImpl.setTermName(StringPool.BLANK);
		}
		else {
			termImpl.setTermName(termName);
		}

		termImpl.setSequenceNumber(sequenceNumber);

		termImpl.resetOriginalValues();

		return termImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		termId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		termMonths = objectInput.readLong();
		termName = objectInput.readUTF();
		sequenceNumber = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(termId);
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
		objectOutput.writeLong(termMonths);

		if (termName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(termName);
		}

		objectOutput.writeLong(sequenceNumber);
	}

	public long termId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long termMonths;
	public String termName;
	public long sequenceNumber;
}