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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Vendor service. Represents a row in the &quot;eCreekRidge_Vendor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.tamarack.creekridge.model.impl.VendorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.tamarack.creekridge.model.impl.VendorImpl}.
 * </p>
 *
 * @author pmacha
 * @see Vendor
 * @see com.tamarack.creekridge.model.impl.VendorImpl
 * @see com.tamarack.creekridge.model.impl.VendorModelImpl
 * @generated
 */
public interface VendorModel extends BaseModel<Vendor>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vendor model instance should use the {@link Vendor} interface instead.
	 */

	/**
	 * Returns the primary key of this vendor.
	 *
	 * @return the primary key of this vendor
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vendor.
	 *
	 * @param primaryKey the primary key of this vendor
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the vendor ID of this vendor.
	 *
	 * @return the vendor ID of this vendor
	 */
	public long getVendorId();

	/**
	 * Sets the vendor ID of this vendor.
	 *
	 * @param vendorId the vendor ID of this vendor
	 */
	public void setVendorId(long vendorId);

	/**
	 * Returns the company ID of this vendor.
	 *
	 * @return the company ID of this vendor
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this vendor.
	 *
	 * @param companyId the company ID of this vendor
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this vendor.
	 *
	 * @return the user ID of this vendor
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this vendor.
	 *
	 * @param userId the user ID of this vendor
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this vendor.
	 *
	 * @return the user uuid of this vendor
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this vendor.
	 *
	 * @param userUuid the user uuid of this vendor
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this vendor.
	 *
	 * @return the user name of this vendor
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this vendor.
	 *
	 * @param userName the user name of this vendor
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this vendor.
	 *
	 * @return the create date of this vendor
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this vendor.
	 *
	 * @param createDate the create date of this vendor
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this vendor.
	 *
	 * @return the modified date of this vendor
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this vendor.
	 *
	 * @param modifiedDate the modified date of this vendor
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the group ID of this vendor.
	 *
	 * @return the group ID of this vendor
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this vendor.
	 *
	 * @param groupId the group ID of this vendor
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the multi select product of this vendor.
	 *
	 * @return the multi select product of this vendor
	 */
	public boolean getMultiSelectProduct();

	/**
	 * Returns <code>true</code> if this vendor is multi select product.
	 *
	 * @return <code>true</code> if this vendor is multi select product; <code>false</code> otherwise
	 */
	public boolean isMultiSelectProduct();

	/**
	 * Sets whether this vendor is multi select product.
	 *
	 * @param multiSelectProduct the multi select product of this vendor
	 */
	public void setMultiSelectProduct(boolean multiSelectProduct);

	/**
	 * Returns the multi select purchase option of this vendor.
	 *
	 * @return the multi select purchase option of this vendor
	 */
	public boolean getMultiSelectPurchaseOption();

	/**
	 * Returns <code>true</code> if this vendor is multi select purchase option.
	 *
	 * @return <code>true</code> if this vendor is multi select purchase option; <code>false</code> otherwise
	 */
	public boolean isMultiSelectPurchaseOption();

	/**
	 * Sets whether this vendor is multi select purchase option.
	 *
	 * @param multiSelectPurchaseOption the multi select purchase option of this vendor
	 */
	public void setMultiSelectPurchaseOption(boolean multiSelectPurchaseOption);

	/**
	 * Returns the multi select term of this vendor.
	 *
	 * @return the multi select term of this vendor
	 */
	public boolean getMultiSelectTerm();

	/**
	 * Returns <code>true</code> if this vendor is multi select term.
	 *
	 * @return <code>true</code> if this vendor is multi select term; <code>false</code> otherwise
	 */
	public boolean isMultiSelectTerm();

	/**
	 * Sets whether this vendor is multi select term.
	 *
	 * @param multiSelectTerm the multi select term of this vendor
	 */
	public void setMultiSelectTerm(boolean multiSelectTerm);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Vendor vendor);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Vendor> toCacheModel();

	@Override
	public Vendor toEscapedModel();

	@Override
	public Vendor toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}