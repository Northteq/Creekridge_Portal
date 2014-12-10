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

import com.tamarack.creekridge.model.ProposalOption;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProposalOption in entity cache.
 *
 * @author Tamarack Consulting
 * @see ProposalOption
 * @generated
 */
public class ProposalOptionCacheModel implements CacheModel<ProposalOption>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{proposalOptionId=");
		sb.append(proposalOptionId);
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
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", termId=");
		sb.append(termId);
		sb.append(", purchaseOptionId=");
		sb.append(purchaseOptionId);
		sb.append(", rateFactorRuleId=");
		sb.append(rateFactorRuleId);
		sb.append(", paymentAmount=");
		sb.append(paymentAmount);
		sb.append(", equipmentPrice=");
		sb.append(equipmentPrice);
		sb.append(", includeInProposal=");
		sb.append(includeInProposal);
		sb.append(", useForCreditApp=");
		sb.append(useForCreditApp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProposalOption toEntityModel() {
		ProposalOptionImpl proposalOptionImpl = new ProposalOptionImpl();

		proposalOptionImpl.setProposalOptionId(proposalOptionId);
		proposalOptionImpl.setCompanyId(companyId);
		proposalOptionImpl.setUserId(userId);

		if (userName == null) {
			proposalOptionImpl.setUserName(StringPool.BLANK);
		}
		else {
			proposalOptionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			proposalOptionImpl.setCreateDate(null);
		}
		else {
			proposalOptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			proposalOptionImpl.setModifiedDate(null);
		}
		else {
			proposalOptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		proposalOptionImpl.setCreditAppId(creditAppId);
		proposalOptionImpl.setProductId(productId);
		proposalOptionImpl.setTermId(termId);
		proposalOptionImpl.setPurchaseOptionId(purchaseOptionId);
		proposalOptionImpl.setRateFactorRuleId(rateFactorRuleId);
		proposalOptionImpl.setPaymentAmount(paymentAmount);
		proposalOptionImpl.setEquipmentPrice(equipmentPrice);
		proposalOptionImpl.setIncludeInProposal(includeInProposal);
		proposalOptionImpl.setUseForCreditApp(useForCreditApp);

		proposalOptionImpl.resetOriginalValues();

		return proposalOptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		proposalOptionId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		creditAppId = objectInput.readLong();
		productId = objectInput.readLong();
		termId = objectInput.readLong();
		purchaseOptionId = objectInput.readLong();
		rateFactorRuleId = objectInput.readLong();
		paymentAmount = objectInput.readDouble();
		equipmentPrice = objectInput.readDouble();
		includeInProposal = objectInput.readBoolean();
		useForCreditApp = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(proposalOptionId);
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
		objectOutput.writeLong(productId);
		objectOutput.writeLong(termId);
		objectOutput.writeLong(purchaseOptionId);
		objectOutput.writeLong(rateFactorRuleId);
		objectOutput.writeDouble(paymentAmount);
		objectOutput.writeDouble(equipmentPrice);
		objectOutput.writeBoolean(includeInProposal);
		objectOutput.writeBoolean(useForCreditApp);
	}

	public long proposalOptionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creditAppId;
	public long productId;
	public long termId;
	public long purchaseOptionId;
	public long rateFactorRuleId;
	public double paymentAmount;
	public double equipmentPrice;
	public boolean includeInProposal;
	public boolean useForCreditApp;
}