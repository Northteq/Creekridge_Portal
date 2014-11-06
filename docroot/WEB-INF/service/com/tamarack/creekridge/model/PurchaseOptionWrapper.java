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
 * This class is a wrapper for {@link PurchaseOption}.
 * </p>
 *
 * @author pmacha
 * @see PurchaseOption
 * @generated
 */
public class PurchaseOptionWrapper implements PurchaseOption,
	ModelWrapper<PurchaseOption> {
	public PurchaseOptionWrapper(PurchaseOption purchaseOption) {
		_purchaseOption = purchaseOption;
	}

	@Override
	public Class<?> getModelClass() {
		return PurchaseOption.class;
	}

	@Override
	public String getModelClassName() {
		return PurchaseOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("purchaseOptionId", getPurchaseOptionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("purchaseOptionName", getPurchaseOptionName());
		attributes.put("sequenceNumber", getSequenceNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long purchaseOptionId = (Long)attributes.get("purchaseOptionId");

		if (purchaseOptionId != null) {
			setPurchaseOptionId(purchaseOptionId);
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

		String purchaseOptionName = (String)attributes.get("purchaseOptionName");

		if (purchaseOptionName != null) {
			setPurchaseOptionName(purchaseOptionName);
		}

		Long sequenceNumber = (Long)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}
	}

	/**
	* Returns the primary key of this purchase option.
	*
	* @return the primary key of this purchase option
	*/
	@Override
	public long getPrimaryKey() {
		return _purchaseOption.getPrimaryKey();
	}

	/**
	* Sets the primary key of this purchase option.
	*
	* @param primaryKey the primary key of this purchase option
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_purchaseOption.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the purchase option ID of this purchase option.
	*
	* @return the purchase option ID of this purchase option
	*/
	@Override
	public long getPurchaseOptionId() {
		return _purchaseOption.getPurchaseOptionId();
	}

	/**
	* Sets the purchase option ID of this purchase option.
	*
	* @param purchaseOptionId the purchase option ID of this purchase option
	*/
	@Override
	public void setPurchaseOptionId(long purchaseOptionId) {
		_purchaseOption.setPurchaseOptionId(purchaseOptionId);
	}

	/**
	* Returns the company ID of this purchase option.
	*
	* @return the company ID of this purchase option
	*/
	@Override
	public long getCompanyId() {
		return _purchaseOption.getCompanyId();
	}

	/**
	* Sets the company ID of this purchase option.
	*
	* @param companyId the company ID of this purchase option
	*/
	@Override
	public void setCompanyId(long companyId) {
		_purchaseOption.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this purchase option.
	*
	* @return the user ID of this purchase option
	*/
	@Override
	public long getUserId() {
		return _purchaseOption.getUserId();
	}

	/**
	* Sets the user ID of this purchase option.
	*
	* @param userId the user ID of this purchase option
	*/
	@Override
	public void setUserId(long userId) {
		_purchaseOption.setUserId(userId);
	}

	/**
	* Returns the user uuid of this purchase option.
	*
	* @return the user uuid of this purchase option
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOption.getUserUuid();
	}

	/**
	* Sets the user uuid of this purchase option.
	*
	* @param userUuid the user uuid of this purchase option
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_purchaseOption.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this purchase option.
	*
	* @return the user name of this purchase option
	*/
	@Override
	public java.lang.String getUserName() {
		return _purchaseOption.getUserName();
	}

	/**
	* Sets the user name of this purchase option.
	*
	* @param userName the user name of this purchase option
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_purchaseOption.setUserName(userName);
	}

	/**
	* Returns the create date of this purchase option.
	*
	* @return the create date of this purchase option
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _purchaseOption.getCreateDate();
	}

	/**
	* Sets the create date of this purchase option.
	*
	* @param createDate the create date of this purchase option
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_purchaseOption.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this purchase option.
	*
	* @return the modified date of this purchase option
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _purchaseOption.getModifiedDate();
	}

	/**
	* Sets the modified date of this purchase option.
	*
	* @param modifiedDate the modified date of this purchase option
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_purchaseOption.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the purchase option name of this purchase option.
	*
	* @return the purchase option name of this purchase option
	*/
	@Override
	public java.lang.String getPurchaseOptionName() {
		return _purchaseOption.getPurchaseOptionName();
	}

	/**
	* Sets the purchase option name of this purchase option.
	*
	* @param purchaseOptionName the purchase option name of this purchase option
	*/
	@Override
	public void setPurchaseOptionName(java.lang.String purchaseOptionName) {
		_purchaseOption.setPurchaseOptionName(purchaseOptionName);
	}

	/**
	* Returns the sequence number of this purchase option.
	*
	* @return the sequence number of this purchase option
	*/
	@Override
	public long getSequenceNumber() {
		return _purchaseOption.getSequenceNumber();
	}

	/**
	* Sets the sequence number of this purchase option.
	*
	* @param sequenceNumber the sequence number of this purchase option
	*/
	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_purchaseOption.setSequenceNumber(sequenceNumber);
	}

	@Override
	public boolean isNew() {
		return _purchaseOption.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_purchaseOption.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _purchaseOption.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_purchaseOption.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _purchaseOption.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _purchaseOption.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_purchaseOption.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _purchaseOption.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_purchaseOption.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_purchaseOption.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_purchaseOption.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PurchaseOptionWrapper((PurchaseOption)_purchaseOption.clone());
	}

	@Override
	public int compareTo(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption) {
		return _purchaseOption.compareTo(purchaseOption);
	}

	@Override
	public int hashCode() {
		return _purchaseOption.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.PurchaseOption> toCacheModel() {
		return _purchaseOption.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.PurchaseOption toEscapedModel() {
		return new PurchaseOptionWrapper(_purchaseOption.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.PurchaseOption toUnescapedModel() {
		return new PurchaseOptionWrapper(_purchaseOption.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _purchaseOption.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _purchaseOption.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_purchaseOption.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PurchaseOptionWrapper)) {
			return false;
		}

		PurchaseOptionWrapper purchaseOptionWrapper = (PurchaseOptionWrapper)obj;

		if (Validator.equals(_purchaseOption,
					purchaseOptionWrapper._purchaseOption)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PurchaseOption getWrappedPurchaseOption() {
		return _purchaseOption;
	}

	@Override
	public PurchaseOption getWrappedModel() {
		return _purchaseOption;
	}

	@Override
	public void resetOriginalValues() {
		_purchaseOption.resetOriginalValues();
	}

	private PurchaseOption _purchaseOption;
}