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

package com.tamarack.creekridge.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProposalOption}.
 * </p>
 *
 * @author pmacha
 * @see ProposalOption
 * @generated
 */
public class ProposalOptionWrapper implements ProposalOption,
	ModelWrapper<ProposalOption> {
	public ProposalOptionWrapper(ProposalOption proposalOption) {
		_proposalOption = proposalOption;
	}

	@Override
	public Class<?> getModelClass() {
		return ProposalOption.class;
	}

	@Override
	public String getModelClassName() {
		return ProposalOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proposalOptionId", getProposalOptionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppId", getCreditAppId());
		attributes.put("productId", getProductId());
		attributes.put("termId", getTermId());
		attributes.put("purchaseOptionId", getPurchaseOptionId());
		attributes.put("rateFactorRuleId", getRateFactorRuleId());
		attributes.put("paymentAmount", getPaymentAmount());
		attributes.put("equipmentPrice", getEquipmentPrice());
		attributes.put("includeInProposal", getIncludeInProposal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proposalOptionId = (Long)attributes.get("proposalOptionId");

		if (proposalOptionId != null) {
			setProposalOptionId(proposalOptionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long creditAppId = (Long)attributes.get("creditAppId");

		if (creditAppId != null) {
			setCreditAppId(creditAppId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		Long purchaseOptionId = (Long)attributes.get("purchaseOptionId");

		if (purchaseOptionId != null) {
			setPurchaseOptionId(purchaseOptionId);
		}

		Long rateFactorRuleId = (Long)attributes.get("rateFactorRuleId");

		if (rateFactorRuleId != null) {
			setRateFactorRuleId(rateFactorRuleId);
		}

		Double paymentAmount = (Double)attributes.get("paymentAmount");

		if (paymentAmount != null) {
			setPaymentAmount(paymentAmount);
		}

		Double equipmentPrice = (Double)attributes.get("equipmentPrice");

		if (equipmentPrice != null) {
			setEquipmentPrice(equipmentPrice);
		}

		Boolean includeInProposal = (Boolean)attributes.get("includeInProposal");

		if (includeInProposal != null) {
			setIncludeInProposal(includeInProposal);
		}
	}

	/**
	* Returns the primary key of this proposal option.
	*
	* @return the primary key of this proposal option
	*/
	@Override
	public long getPrimaryKey() {
		return _proposalOption.getPrimaryKey();
	}

	/**
	* Sets the primary key of this proposal option.
	*
	* @param primaryKey the primary key of this proposal option
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_proposalOption.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the proposal option ID of this proposal option.
	*
	* @return the proposal option ID of this proposal option
	*/
	@Override
	public long getProposalOptionId() {
		return _proposalOption.getProposalOptionId();
	}

	/**
	* Sets the proposal option ID of this proposal option.
	*
	* @param proposalOptionId the proposal option ID of this proposal option
	*/
	@Override
	public void setProposalOptionId(long proposalOptionId) {
		_proposalOption.setProposalOptionId(proposalOptionId);
	}

	/**
	* Returns the company ID of this proposal option.
	*
	* @return the company ID of this proposal option
	*/
	@Override
	public long getCompanyId() {
		return _proposalOption.getCompanyId();
	}

	/**
	* Sets the company ID of this proposal option.
	*
	* @param companyId the company ID of this proposal option
	*/
	@Override
	public void setCompanyId(long companyId) {
		_proposalOption.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this proposal option.
	*
	* @return the user ID of this proposal option
	*/
	@Override
	public long getUserId() {
		return _proposalOption.getUserId();
	}

	/**
	* Sets the user ID of this proposal option.
	*
	* @param userId the user ID of this proposal option
	*/
	@Override
	public void setUserId(long userId) {
		_proposalOption.setUserId(userId);
	}

	/**
	* Returns the user uuid of this proposal option.
	*
	* @return the user uuid of this proposal option
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _proposalOption.getUserUuid();
	}

	/**
	* Sets the user uuid of this proposal option.
	*
	* @param userUuid the user uuid of this proposal option
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_proposalOption.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this proposal option.
	*
	* @return the user name of this proposal option
	*/
	@Override
	public java.lang.String getUserName() {
		return _proposalOption.getUserName();
	}

	/**
	* Sets the user name of this proposal option.
	*
	* @param userName the user name of this proposal option
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_proposalOption.setUserName(userName);
	}

	/**
	* Returns the create date of this proposal option.
	*
	* @return the create date of this proposal option
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _proposalOption.getCreateDate();
	}

	/**
	* Sets the create date of this proposal option.
	*
	* @param createDate the create date of this proposal option
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_proposalOption.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this proposal option.
	*
	* @return the modified date of this proposal option
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _proposalOption.getModifiedDate();
	}

	/**
	* Sets the modified date of this proposal option.
	*
	* @param modifiedDate the modified date of this proposal option
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_proposalOption.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the credit app ID of this proposal option.
	*
	* @return the credit app ID of this proposal option
	*/
	@Override
	public long getCreditAppId() {
		return _proposalOption.getCreditAppId();
	}

	/**
	* Sets the credit app ID of this proposal option.
	*
	* @param creditAppId the credit app ID of this proposal option
	*/
	@Override
	public void setCreditAppId(long creditAppId) {
		_proposalOption.setCreditAppId(creditAppId);
	}

	/**
	* Returns the product ID of this proposal option.
	*
	* @return the product ID of this proposal option
	*/
	@Override
	public long getProductId() {
		return _proposalOption.getProductId();
	}

	/**
	* Sets the product ID of this proposal option.
	*
	* @param productId the product ID of this proposal option
	*/
	@Override
	public void setProductId(long productId) {
		_proposalOption.setProductId(productId);
	}

	/**
	* Returns the term ID of this proposal option.
	*
	* @return the term ID of this proposal option
	*/
	@Override
	public long getTermId() {
		return _proposalOption.getTermId();
	}

	/**
	* Sets the term ID of this proposal option.
	*
	* @param termId the term ID of this proposal option
	*/
	@Override
	public void setTermId(long termId) {
		_proposalOption.setTermId(termId);
	}

	/**
	* Returns the purchase option ID of this proposal option.
	*
	* @return the purchase option ID of this proposal option
	*/
	@Override
	public long getPurchaseOptionId() {
		return _proposalOption.getPurchaseOptionId();
	}

	/**
	* Sets the purchase option ID of this proposal option.
	*
	* @param purchaseOptionId the purchase option ID of this proposal option
	*/
	@Override
	public void setPurchaseOptionId(long purchaseOptionId) {
		_proposalOption.setPurchaseOptionId(purchaseOptionId);
	}

	/**
	* Returns the rate factor rule ID of this proposal option.
	*
	* @return the rate factor rule ID of this proposal option
	*/
	@Override
	public long getRateFactorRuleId() {
		return _proposalOption.getRateFactorRuleId();
	}

	/**
	* Sets the rate factor rule ID of this proposal option.
	*
	* @param rateFactorRuleId the rate factor rule ID of this proposal option
	*/
	@Override
	public void setRateFactorRuleId(long rateFactorRuleId) {
		_proposalOption.setRateFactorRuleId(rateFactorRuleId);
	}

	/**
	* Returns the payment amount of this proposal option.
	*
	* @return the payment amount of this proposal option
	*/
	@Override
	public double getPaymentAmount() {
		return _proposalOption.getPaymentAmount();
	}

	/**
	* Sets the payment amount of this proposal option.
	*
	* @param paymentAmount the payment amount of this proposal option
	*/
	@Override
	public void setPaymentAmount(double paymentAmount) {
		_proposalOption.setPaymentAmount(paymentAmount);
	}

	/**
	* Returns the equipment price of this proposal option.
	*
	* @return the equipment price of this proposal option
	*/
	@Override
	public double getEquipmentPrice() {
		return _proposalOption.getEquipmentPrice();
	}

	/**
	* Sets the equipment price of this proposal option.
	*
	* @param equipmentPrice the equipment price of this proposal option
	*/
	@Override
	public void setEquipmentPrice(double equipmentPrice) {
		_proposalOption.setEquipmentPrice(equipmentPrice);
	}

	/**
	* Returns the include in proposal of this proposal option.
	*
	* @return the include in proposal of this proposal option
	*/
	@Override
	public boolean getIncludeInProposal() {
		return _proposalOption.getIncludeInProposal();
	}

	/**
	* Returns <code>true</code> if this proposal option is include in proposal.
	*
	* @return <code>true</code> if this proposal option is include in proposal; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncludeInProposal() {
		return _proposalOption.isIncludeInProposal();
	}

	/**
	* Sets whether this proposal option is include in proposal.
	*
	* @param includeInProposal the include in proposal of this proposal option
	*/
	@Override
	public void setIncludeInProposal(boolean includeInProposal) {
		_proposalOption.setIncludeInProposal(includeInProposal);
	}

	@Override
	public boolean isNew() {
		return _proposalOption.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_proposalOption.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _proposalOption.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_proposalOption.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _proposalOption.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _proposalOption.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_proposalOption.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _proposalOption.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_proposalOption.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_proposalOption.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_proposalOption.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProposalOptionWrapper((ProposalOption)_proposalOption.clone());
	}

	@Override
	public int compareTo(
		com.tamarack.creekridge.model.ProposalOption proposalOption) {
		return _proposalOption.compareTo(proposalOption);
	}

	@Override
	public int hashCode() {
		return _proposalOption.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.ProposalOption> toCacheModel() {
		return _proposalOption.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.ProposalOption toEscapedModel() {
		return new ProposalOptionWrapper(_proposalOption.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.ProposalOption toUnescapedModel() {
		return new ProposalOptionWrapper(_proposalOption.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _proposalOption.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _proposalOption.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_proposalOption.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProposalOptionWrapper)) {
			return false;
		}

		ProposalOptionWrapper proposalOptionWrapper = (ProposalOptionWrapper)obj;

		if (Validator.equals(_proposalOption,
					proposalOptionWrapper._proposalOption)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProposalOption getWrappedProposalOption() {
		return _proposalOption;
	}

	@Override
	public ProposalOption getWrappedModel() {
		return _proposalOption;
	}

	@Override
	public void resetOriginalValues() {
		_proposalOption.resetOriginalValues();
	}

	private ProposalOption _proposalOption;
}