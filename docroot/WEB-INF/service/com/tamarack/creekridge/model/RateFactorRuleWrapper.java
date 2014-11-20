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

package com.tamarack.creekridge.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RateFactorRule}.
 * </p>
 *
 * @author pmacha
 * @see RateFactorRule
 * @generated
 */
public class RateFactorRuleWrapper implements RateFactorRule,
	ModelWrapper<RateFactorRule> {
	public RateFactorRuleWrapper(RateFactorRule rateFactorRule) {
		_rateFactorRule = rateFactorRule;
	}

	@Override
	public Class<?> getModelClass() {
		return RateFactorRule.class;
	}

	@Override
	public String getModelClassName() {
		return RateFactorRule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rateFactorRuleId", getRateFactorRuleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("productId", getProductId());
		attributes.put("termId", getTermId());
		attributes.put("purchaseOptionId", getPurchaseOptionId());
		attributes.put("vendorId", getVendorId());
		attributes.put("minPrice", getMinPrice());
		attributes.put("rateFactor", getRateFactor());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("active", getActive());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rateFactorRuleId = (Long)attributes.get("rateFactorRuleId");

		if (rateFactorRuleId != null) {
			setRateFactorRuleId(rateFactorRuleId);
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

		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
		}

		Double minPrice = (Double)attributes.get("minPrice");

		if (minPrice != null) {
			setMinPrice(minPrice);
		}

		Double rateFactor = (Double)attributes.get("rateFactor");

		if (rateFactor != null) {
			setRateFactor(rateFactor);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}

	/**
	* Returns the primary key of this rate factor rule.
	*
	* @return the primary key of this rate factor rule
	*/
	@Override
	public long getPrimaryKey() {
		return _rateFactorRule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rate factor rule.
	*
	* @param primaryKey the primary key of this rate factor rule
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rateFactorRule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rate factor rule ID of this rate factor rule.
	*
	* @return the rate factor rule ID of this rate factor rule
	*/
	@Override
	public long getRateFactorRuleId() {
		return _rateFactorRule.getRateFactorRuleId();
	}

	/**
	* Sets the rate factor rule ID of this rate factor rule.
	*
	* @param rateFactorRuleId the rate factor rule ID of this rate factor rule
	*/
	@Override
	public void setRateFactorRuleId(long rateFactorRuleId) {
		_rateFactorRule.setRateFactorRuleId(rateFactorRuleId);
	}

	/**
	* Returns the company ID of this rate factor rule.
	*
	* @return the company ID of this rate factor rule
	*/
	@Override
	public long getCompanyId() {
		return _rateFactorRule.getCompanyId();
	}

	/**
	* Sets the company ID of this rate factor rule.
	*
	* @param companyId the company ID of this rate factor rule
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rateFactorRule.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rate factor rule.
	*
	* @return the user ID of this rate factor rule
	*/
	@Override
	public long getUserId() {
		return _rateFactorRule.getUserId();
	}

	/**
	* Sets the user ID of this rate factor rule.
	*
	* @param userId the user ID of this rate factor rule
	*/
	@Override
	public void setUserId(long userId) {
		_rateFactorRule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rate factor rule.
	*
	* @return the user uuid of this rate factor rule
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRule.getUserUuid();
	}

	/**
	* Sets the user uuid of this rate factor rule.
	*
	* @param userUuid the user uuid of this rate factor rule
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rateFactorRule.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rate factor rule.
	*
	* @return the user name of this rate factor rule
	*/
	@Override
	public java.lang.String getUserName() {
		return _rateFactorRule.getUserName();
	}

	/**
	* Sets the user name of this rate factor rule.
	*
	* @param userName the user name of this rate factor rule
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rateFactorRule.setUserName(userName);
	}

	/**
	* Returns the create date of this rate factor rule.
	*
	* @return the create date of this rate factor rule
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rateFactorRule.getCreateDate();
	}

	/**
	* Sets the create date of this rate factor rule.
	*
	* @param createDate the create date of this rate factor rule
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rateFactorRule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rate factor rule.
	*
	* @return the modified date of this rate factor rule
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rateFactorRule.getModifiedDate();
	}

	/**
	* Sets the modified date of this rate factor rule.
	*
	* @param modifiedDate the modified date of this rate factor rule
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rateFactorRule.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the product ID of this rate factor rule.
	*
	* @return the product ID of this rate factor rule
	*/
	@Override
	public long getProductId() {
		return _rateFactorRule.getProductId();
	}

	/**
	* Sets the product ID of this rate factor rule.
	*
	* @param productId the product ID of this rate factor rule
	*/
	@Override
	public void setProductId(long productId) {
		_rateFactorRule.setProductId(productId);
	}

	/**
	* Returns the term ID of this rate factor rule.
	*
	* @return the term ID of this rate factor rule
	*/
	@Override
	public long getTermId() {
		return _rateFactorRule.getTermId();
	}

	/**
	* Sets the term ID of this rate factor rule.
	*
	* @param termId the term ID of this rate factor rule
	*/
	@Override
	public void setTermId(long termId) {
		_rateFactorRule.setTermId(termId);
	}

	/**
	* Returns the purchase option ID of this rate factor rule.
	*
	* @return the purchase option ID of this rate factor rule
	*/
	@Override
	public long getPurchaseOptionId() {
		return _rateFactorRule.getPurchaseOptionId();
	}

	/**
	* Sets the purchase option ID of this rate factor rule.
	*
	* @param purchaseOptionId the purchase option ID of this rate factor rule
	*/
	@Override
	public void setPurchaseOptionId(long purchaseOptionId) {
		_rateFactorRule.setPurchaseOptionId(purchaseOptionId);
	}

	/**
	* Returns the vendor ID of this rate factor rule.
	*
	* @return the vendor ID of this rate factor rule
	*/
	@Override
	public long getVendorId() {
		return _rateFactorRule.getVendorId();
	}

	/**
	* Sets the vendor ID of this rate factor rule.
	*
	* @param vendorId the vendor ID of this rate factor rule
	*/
	@Override
	public void setVendorId(long vendorId) {
		_rateFactorRule.setVendorId(vendorId);
	}

	/**
	* Returns the min price of this rate factor rule.
	*
	* @return the min price of this rate factor rule
	*/
	@Override
	public double getMinPrice() {
		return _rateFactorRule.getMinPrice();
	}

	/**
	* Sets the min price of this rate factor rule.
	*
	* @param minPrice the min price of this rate factor rule
	*/
	@Override
	public void setMinPrice(double minPrice) {
		_rateFactorRule.setMinPrice(minPrice);
	}

	/**
	* Returns the rate factor of this rate factor rule.
	*
	* @return the rate factor of this rate factor rule
	*/
	@Override
	public double getRateFactor() {
		return _rateFactorRule.getRateFactor();
	}

	/**
	* Sets the rate factor of this rate factor rule.
	*
	* @param rateFactor the rate factor of this rate factor rule
	*/
	@Override
	public void setRateFactor(double rateFactor) {
		_rateFactorRule.setRateFactor(rateFactor);
	}

	/**
	* Returns the effective date of this rate factor rule.
	*
	* @return the effective date of this rate factor rule
	*/
	@Override
	public java.util.Date getEffectiveDate() {
		return _rateFactorRule.getEffectiveDate();
	}

	/**
	* Sets the effective date of this rate factor rule.
	*
	* @param effectiveDate the effective date of this rate factor rule
	*/
	@Override
	public void setEffectiveDate(java.util.Date effectiveDate) {
		_rateFactorRule.setEffectiveDate(effectiveDate);
	}

	/**
	* Returns the active of this rate factor rule.
	*
	* @return the active of this rate factor rule
	*/
	@Override
	public boolean getActive() {
		return _rateFactorRule.getActive();
	}

	/**
	* Returns <code>true</code> if this rate factor rule is active.
	*
	* @return <code>true</code> if this rate factor rule is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _rateFactorRule.isActive();
	}

	/**
	* Sets whether this rate factor rule is active.
	*
	* @param active the active of this rate factor rule
	*/
	@Override
	public void setActive(boolean active) {
		_rateFactorRule.setActive(active);
	}

	/**
	* Returns the expiration date of this rate factor rule.
	*
	* @return the expiration date of this rate factor rule
	*/
	@Override
	public java.util.Date getExpirationDate() {
		return _rateFactorRule.getExpirationDate();
	}

	/**
	* Sets the expiration date of this rate factor rule.
	*
	* @param expirationDate the expiration date of this rate factor rule
	*/
	@Override
	public void setExpirationDate(java.util.Date expirationDate) {
		_rateFactorRule.setExpirationDate(expirationDate);
	}

	@Override
	public boolean isNew() {
		return _rateFactorRule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rateFactorRule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rateFactorRule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rateFactorRule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rateFactorRule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rateFactorRule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rateFactorRule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rateFactorRule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rateFactorRule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rateFactorRule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rateFactorRule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RateFactorRuleWrapper((RateFactorRule)_rateFactorRule.clone());
	}

	@Override
	public int compareTo(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule) {
		return _rateFactorRule.compareTo(rateFactorRule);
	}

	@Override
	public int hashCode() {
		return _rateFactorRule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.RateFactorRule> toCacheModel() {
		return _rateFactorRule.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.RateFactorRule toEscapedModel() {
		return new RateFactorRuleWrapper(_rateFactorRule.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.RateFactorRule toUnescapedModel() {
		return new RateFactorRuleWrapper(_rateFactorRule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rateFactorRule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rateFactorRule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rateFactorRule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RateFactorRuleWrapper)) {
			return false;
		}

		RateFactorRuleWrapper rateFactorRuleWrapper = (RateFactorRuleWrapper)obj;

		if (Validator.equals(_rateFactorRule,
					rateFactorRuleWrapper._rateFactorRule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RateFactorRule getWrappedRateFactorRule() {
		return _rateFactorRule;
	}

	@Override
	public RateFactorRule getWrappedModel() {
		return _rateFactorRule;
	}

	@Override
	public void resetOriginalValues() {
		_rateFactorRule.resetOriginalValues();
	}

	private RateFactorRule _rateFactorRule;
}