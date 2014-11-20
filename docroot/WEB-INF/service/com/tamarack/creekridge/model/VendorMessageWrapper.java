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
 * This class is a wrapper for {@link VendorMessage}.
 * </p>
 *
 * @author pmacha
 * @see VendorMessage
 * @generated
 */
public class VendorMessageWrapper implements VendorMessage,
	ModelWrapper<VendorMessage> {
	public VendorMessageWrapper(VendorMessage vendorMessage) {
		_vendorMessage = vendorMessage;
	}

	@Override
	public Class<?> getModelClass() {
		return VendorMessage.class;
	}

	@Override
	public String getModelClassName() {
		return VendorMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vendorId", getVendorId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
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

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this vendor message.
	*
	* @return the primary key of this vendor message
	*/
	@Override
	public long getPrimaryKey() {
		return _vendorMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vendor message.
	*
	* @param primaryKey the primary key of this vendor message
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vendorMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vendor ID of this vendor message.
	*
	* @return the vendor ID of this vendor message
	*/
	@Override
	public long getVendorId() {
		return _vendorMessage.getVendorId();
	}

	/**
	* Sets the vendor ID of this vendor message.
	*
	* @param vendorId the vendor ID of this vendor message
	*/
	@Override
	public void setVendorId(long vendorId) {
		_vendorMessage.setVendorId(vendorId);
	}

	/**
	* Returns the company ID of this vendor message.
	*
	* @return the company ID of this vendor message
	*/
	@Override
	public long getCompanyId() {
		return _vendorMessage.getCompanyId();
	}

	/**
	* Sets the company ID of this vendor message.
	*
	* @param companyId the company ID of this vendor message
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vendorMessage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vendor message.
	*
	* @return the user ID of this vendor message
	*/
	@Override
	public long getUserId() {
		return _vendorMessage.getUserId();
	}

	/**
	* Sets the user ID of this vendor message.
	*
	* @param userId the user ID of this vendor message
	*/
	@Override
	public void setUserId(long userId) {
		_vendorMessage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vendor message.
	*
	* @return the user uuid of this vendor message
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vendorMessage.getUserUuid();
	}

	/**
	* Sets the user uuid of this vendor message.
	*
	* @param userUuid the user uuid of this vendor message
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vendorMessage.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vendor message.
	*
	* @return the user name of this vendor message
	*/
	@Override
	public java.lang.String getUserName() {
		return _vendorMessage.getUserName();
	}

	/**
	* Sets the user name of this vendor message.
	*
	* @param userName the user name of this vendor message
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vendorMessage.setUserName(userName);
	}

	/**
	* Returns the create date of this vendor message.
	*
	* @return the create date of this vendor message
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vendorMessage.getCreateDate();
	}

	/**
	* Sets the create date of this vendor message.
	*
	* @param createDate the create date of this vendor message
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vendorMessage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this vendor message.
	*
	* @return the modified date of this vendor message
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vendorMessage.getModifiedDate();
	}

	/**
	* Sets the modified date of this vendor message.
	*
	* @param modifiedDate the modified date of this vendor message
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vendorMessage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the key of this vendor message.
	*
	* @return the key of this vendor message
	*/
	@Override
	public java.lang.String getKey() {
		return _vendorMessage.getKey();
	}

	/**
	* Sets the key of this vendor message.
	*
	* @param key the key of this vendor message
	*/
	@Override
	public void setKey(java.lang.String key) {
		_vendorMessage.setKey(key);
	}

	/**
	* Returns the value of this vendor message.
	*
	* @return the value of this vendor message
	*/
	@Override
	public java.lang.String getValue() {
		return _vendorMessage.getValue();
	}

	/**
	* Sets the value of this vendor message.
	*
	* @param value the value of this vendor message
	*/
	@Override
	public void setValue(java.lang.String value) {
		_vendorMessage.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _vendorMessage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vendorMessage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vendorMessage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vendorMessage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vendorMessage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vendorMessage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vendorMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vendorMessage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vendorMessage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vendorMessage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vendorMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VendorMessageWrapper((VendorMessage)_vendorMessage.clone());
	}

	@Override
	public int compareTo(
		com.tamarack.creekridge.model.VendorMessage vendorMessage) {
		return _vendorMessage.compareTo(vendorMessage);
	}

	@Override
	public int hashCode() {
		return _vendorMessage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.VendorMessage> toCacheModel() {
		return _vendorMessage.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.VendorMessage toEscapedModel() {
		return new VendorMessageWrapper(_vendorMessage.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.VendorMessage toUnescapedModel() {
		return new VendorMessageWrapper(_vendorMessage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vendorMessage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vendorMessage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vendorMessage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VendorMessageWrapper)) {
			return false;
		}

		VendorMessageWrapper vendorMessageWrapper = (VendorMessageWrapper)obj;

		if (Validator.equals(_vendorMessage, vendorMessageWrapper._vendorMessage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VendorMessage getWrappedVendorMessage() {
		return _vendorMessage;
	}

	@Override
	public VendorMessage getWrappedModel() {
		return _vendorMessage;
	}

	@Override
	public void resetOriginalValues() {
		_vendorMessage.resetOriginalValues();
	}

	private VendorMessage _vendorMessage;
}