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
 * This class is a wrapper for {@link CreditAppStatus}.
 * </p>
 *
 * @author pmacha
 * @see CreditAppStatus
 * @generated
 */
public class CreditAppStatusWrapper implements CreditAppStatus,
	ModelWrapper<CreditAppStatus> {
	public CreditAppStatusWrapper(CreditAppStatus creditAppStatus) {
		_creditAppStatus = creditAppStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return CreditAppStatus.class;
	}

	@Override
	public String getModelClassName() {
		return CreditAppStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("CreditAppStatusId", getCreditAppStatusId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppStatusName", getCreditAppStatusName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long CreditAppStatusId = (Long)attributes.get("CreditAppStatusId");

		if (CreditAppStatusId != null) {
			setCreditAppStatusId(CreditAppStatusId);
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

		String creditAppStatusName = (String)attributes.get(
				"creditAppStatusName");

		if (creditAppStatusName != null) {
			setCreditAppStatusName(creditAppStatusName);
		}
	}

	/**
	* Returns the primary key of this credit app status.
	*
	* @return the primary key of this credit app status
	*/
	@Override
	public long getPrimaryKey() {
		return _creditAppStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this credit app status.
	*
	* @param primaryKey the primary key of this credit app status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_creditAppStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the credit app status ID of this credit app status.
	*
	* @return the credit app status ID of this credit app status
	*/
	@Override
	public long getCreditAppStatusId() {
		return _creditAppStatus.getCreditAppStatusId();
	}

	/**
	* Sets the credit app status ID of this credit app status.
	*
	* @param CreditAppStatusId the credit app status ID of this credit app status
	*/
	@Override
	public void setCreditAppStatusId(long CreditAppStatusId) {
		_creditAppStatus.setCreditAppStatusId(CreditAppStatusId);
	}

	/**
	* Returns the company ID of this credit app status.
	*
	* @return the company ID of this credit app status
	*/
	@Override
	public long getCompanyId() {
		return _creditAppStatus.getCompanyId();
	}

	/**
	* Sets the company ID of this credit app status.
	*
	* @param companyId the company ID of this credit app status
	*/
	@Override
	public void setCompanyId(long companyId) {
		_creditAppStatus.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this credit app status.
	*
	* @return the user ID of this credit app status
	*/
	@Override
	public long getUserId() {
		return _creditAppStatus.getUserId();
	}

	/**
	* Sets the user ID of this credit app status.
	*
	* @param userId the user ID of this credit app status
	*/
	@Override
	public void setUserId(long userId) {
		_creditAppStatus.setUserId(userId);
	}

	/**
	* Returns the user uuid of this credit app status.
	*
	* @return the user uuid of this credit app status
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppStatus.getUserUuid();
	}

	/**
	* Sets the user uuid of this credit app status.
	*
	* @param userUuid the user uuid of this credit app status
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_creditAppStatus.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this credit app status.
	*
	* @return the user name of this credit app status
	*/
	@Override
	public java.lang.String getUserName() {
		return _creditAppStatus.getUserName();
	}

	/**
	* Sets the user name of this credit app status.
	*
	* @param userName the user name of this credit app status
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_creditAppStatus.setUserName(userName);
	}

	/**
	* Returns the create date of this credit app status.
	*
	* @return the create date of this credit app status
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _creditAppStatus.getCreateDate();
	}

	/**
	* Sets the create date of this credit app status.
	*
	* @param createDate the create date of this credit app status
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_creditAppStatus.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this credit app status.
	*
	* @return the modified date of this credit app status
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _creditAppStatus.getModifiedDate();
	}

	/**
	* Sets the modified date of this credit app status.
	*
	* @param modifiedDate the modified date of this credit app status
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_creditAppStatus.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the credit app status name of this credit app status.
	*
	* @return the credit app status name of this credit app status
	*/
	@Override
	public java.lang.String getCreditAppStatusName() {
		return _creditAppStatus.getCreditAppStatusName();
	}

	/**
	* Sets the credit app status name of this credit app status.
	*
	* @param creditAppStatusName the credit app status name of this credit app status
	*/
	@Override
	public void setCreditAppStatusName(java.lang.String creditAppStatusName) {
		_creditAppStatus.setCreditAppStatusName(creditAppStatusName);
	}

	@Override
	public boolean isNew() {
		return _creditAppStatus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_creditAppStatus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _creditAppStatus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_creditAppStatus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _creditAppStatus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _creditAppStatus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_creditAppStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _creditAppStatus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_creditAppStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_creditAppStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_creditAppStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CreditAppStatusWrapper((CreditAppStatus)_creditAppStatus.clone());
	}

	@Override
	public int compareTo(
		com.tamarack.creekridge.model.CreditAppStatus creditAppStatus) {
		return _creditAppStatus.compareTo(creditAppStatus);
	}

	@Override
	public int hashCode() {
		return _creditAppStatus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.CreditAppStatus> toCacheModel() {
		return _creditAppStatus.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppStatus toEscapedModel() {
		return new CreditAppStatusWrapper(_creditAppStatus.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppStatus toUnescapedModel() {
		return new CreditAppStatusWrapper(_creditAppStatus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _creditAppStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _creditAppStatus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_creditAppStatus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditAppStatusWrapper)) {
			return false;
		}

		CreditAppStatusWrapper creditAppStatusWrapper = (CreditAppStatusWrapper)obj;

		if (Validator.equals(_creditAppStatus,
					creditAppStatusWrapper._creditAppStatus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CreditAppStatus getWrappedCreditAppStatus() {
		return _creditAppStatus;
	}

	@Override
	public CreditAppStatus getWrappedModel() {
		return _creditAppStatus;
	}

	@Override
	public void resetOriginalValues() {
		_creditAppStatus.resetOriginalValues();
	}

	private CreditAppStatus _creditAppStatus;
}