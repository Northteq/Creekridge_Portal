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
 * This class is a wrapper for {@link Vendor}.
 * </p>
 *
 * @author pmacha
 * @see Vendor
 * @generated
 */
public class VendorWrapper implements Vendor, ModelWrapper<Vendor> {
	public VendorWrapper(Vendor vendor) {
		_vendor = vendor;
	}

	@Override
	public Class<?> getModelClass() {
		return Vendor.class;
	}

	@Override
	public String getModelClassName() {
		return Vendor.class.getName();
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
		attributes.put("groupId", getGroupId());
		attributes.put("multiSelectProduct", getMultiSelectProduct());
		attributes.put("multiSelectPurchaseOption",
			getMultiSelectPurchaseOption());
		attributes.put("multiSelectTerm", getMultiSelectTerm());

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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Boolean multiSelectProduct = (Boolean)attributes.get(
				"multiSelectProduct");

		if (multiSelectProduct != null) {
			setMultiSelectProduct(multiSelectProduct);
		}

		Boolean multiSelectPurchaseOption = (Boolean)attributes.get(
				"multiSelectPurchaseOption");

		if (multiSelectPurchaseOption != null) {
			setMultiSelectPurchaseOption(multiSelectPurchaseOption);
		}

		Boolean multiSelectTerm = (Boolean)attributes.get("multiSelectTerm");

		if (multiSelectTerm != null) {
			setMultiSelectTerm(multiSelectTerm);
		}
	}

	/**
	* Returns the primary key of this vendor.
	*
	* @return the primary key of this vendor
	*/
	@Override
	public long getPrimaryKey() {
		return _vendor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vendor.
	*
	* @param primaryKey the primary key of this vendor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vendor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vendor ID of this vendor.
	*
	* @return the vendor ID of this vendor
	*/
	@Override
	public long getVendorId() {
		return _vendor.getVendorId();
	}

	/**
	* Sets the vendor ID of this vendor.
	*
	* @param vendorId the vendor ID of this vendor
	*/
	@Override
	public void setVendorId(long vendorId) {
		_vendor.setVendorId(vendorId);
	}

	/**
	* Returns the company ID of this vendor.
	*
	* @return the company ID of this vendor
	*/
	@Override
	public long getCompanyId() {
		return _vendor.getCompanyId();
	}

	/**
	* Sets the company ID of this vendor.
	*
	* @param companyId the company ID of this vendor
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vendor.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vendor.
	*
	* @return the user ID of this vendor
	*/
	@Override
	public long getUserId() {
		return _vendor.getUserId();
	}

	/**
	* Sets the user ID of this vendor.
	*
	* @param userId the user ID of this vendor
	*/
	@Override
	public void setUserId(long userId) {
		_vendor.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vendor.
	*
	* @return the user uuid of this vendor
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vendor.getUserUuid();
	}

	/**
	* Sets the user uuid of this vendor.
	*
	* @param userUuid the user uuid of this vendor
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vendor.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vendor.
	*
	* @return the user name of this vendor
	*/
	@Override
	public java.lang.String getUserName() {
		return _vendor.getUserName();
	}

	/**
	* Sets the user name of this vendor.
	*
	* @param userName the user name of this vendor
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vendor.setUserName(userName);
	}

	/**
	* Returns the create date of this vendor.
	*
	* @return the create date of this vendor
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vendor.getCreateDate();
	}

	/**
	* Sets the create date of this vendor.
	*
	* @param createDate the create date of this vendor
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vendor.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this vendor.
	*
	* @return the modified date of this vendor
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vendor.getModifiedDate();
	}

	/**
	* Sets the modified date of this vendor.
	*
	* @param modifiedDate the modified date of this vendor
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vendor.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the group ID of this vendor.
	*
	* @return the group ID of this vendor
	*/
	@Override
	public long getGroupId() {
		return _vendor.getGroupId();
	}

	/**
	* Sets the group ID of this vendor.
	*
	* @param groupId the group ID of this vendor
	*/
	@Override
	public void setGroupId(long groupId) {
		_vendor.setGroupId(groupId);
	}

	/**
	* Returns the multi select product of this vendor.
	*
	* @return the multi select product of this vendor
	*/
	@Override
	public boolean getMultiSelectProduct() {
		return _vendor.getMultiSelectProduct();
	}

	/**
	* Returns <code>true</code> if this vendor is multi select product.
	*
	* @return <code>true</code> if this vendor is multi select product; <code>false</code> otherwise
	*/
	@Override
	public boolean isMultiSelectProduct() {
		return _vendor.isMultiSelectProduct();
	}

	/**
	* Sets whether this vendor is multi select product.
	*
	* @param multiSelectProduct the multi select product of this vendor
	*/
	@Override
	public void setMultiSelectProduct(boolean multiSelectProduct) {
		_vendor.setMultiSelectProduct(multiSelectProduct);
	}

	/**
	* Returns the multi select purchase option of this vendor.
	*
	* @return the multi select purchase option of this vendor
	*/
	@Override
	public boolean getMultiSelectPurchaseOption() {
		return _vendor.getMultiSelectPurchaseOption();
	}

	/**
	* Returns <code>true</code> if this vendor is multi select purchase option.
	*
	* @return <code>true</code> if this vendor is multi select purchase option; <code>false</code> otherwise
	*/
	@Override
	public boolean isMultiSelectPurchaseOption() {
		return _vendor.isMultiSelectPurchaseOption();
	}

	/**
	* Sets whether this vendor is multi select purchase option.
	*
	* @param multiSelectPurchaseOption the multi select purchase option of this vendor
	*/
	@Override
	public void setMultiSelectPurchaseOption(boolean multiSelectPurchaseOption) {
		_vendor.setMultiSelectPurchaseOption(multiSelectPurchaseOption);
	}

	/**
	* Returns the multi select term of this vendor.
	*
	* @return the multi select term of this vendor
	*/
	@Override
	public boolean getMultiSelectTerm() {
		return _vendor.getMultiSelectTerm();
	}

	/**
	* Returns <code>true</code> if this vendor is multi select term.
	*
	* @return <code>true</code> if this vendor is multi select term; <code>false</code> otherwise
	*/
	@Override
	public boolean isMultiSelectTerm() {
		return _vendor.isMultiSelectTerm();
	}

	/**
	* Sets whether this vendor is multi select term.
	*
	* @param multiSelectTerm the multi select term of this vendor
	*/
	@Override
	public void setMultiSelectTerm(boolean multiSelectTerm) {
		_vendor.setMultiSelectTerm(multiSelectTerm);
	}

	@Override
	public boolean isNew() {
		return _vendor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vendor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vendor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vendor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vendor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vendor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vendor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vendor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vendor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vendor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vendor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VendorWrapper((Vendor)_vendor.clone());
	}

	@Override
	public int compareTo(com.tamarack.creekridge.model.Vendor vendor) {
		return _vendor.compareTo(vendor);
	}

	@Override
	public int hashCode() {
		return _vendor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.Vendor> toCacheModel() {
		return _vendor.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.Vendor toEscapedModel() {
		return new VendorWrapper(_vendor.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.Vendor toUnescapedModel() {
		return new VendorWrapper(_vendor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vendor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vendor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vendor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VendorWrapper)) {
			return false;
		}

		VendorWrapper vendorWrapper = (VendorWrapper)obj;

		if (Validator.equals(_vendor, vendorWrapper._vendor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Vendor getWrappedVendor() {
		return _vendor;
	}

	@Override
	public Vendor getWrappedModel() {
		return _vendor;
	}

	@Override
	public void resetOriginalValues() {
		_vendor.resetOriginalValues();
	}

	private Vendor _vendor;
}