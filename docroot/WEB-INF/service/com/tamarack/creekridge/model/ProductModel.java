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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Product service. Represents a row in the &quot;eCreekRidge_Product&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.tamarack.creekridge.model.impl.ProductModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.tamarack.creekridge.model.impl.ProductImpl}.
 * </p>
 *
 * @author pmacha
 * @see Product
 * @see com.tamarack.creekridge.model.impl.ProductImpl
 * @see com.tamarack.creekridge.model.impl.ProductModelImpl
 * @generated
 */
public interface ProductModel extends AuditedModel, BaseModel<Product> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a product model instance should use the {@link Product} interface instead.
	 */

	/**
	 * Returns the primary key of this product.
	 *
	 * @return the primary key of this product
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this product.
	 *
	 * @param primaryKey the primary key of this product
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the product ID of this product.
	 *
	 * @return the product ID of this product
	 */
	public long getProductId();

	/**
	 * Sets the product ID of this product.
	 *
	 * @param productId the product ID of this product
	 */
	public void setProductId(long productId);

	/**
	 * Returns the company ID of this product.
	 *
	 * @return the company ID of this product
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this product.
	 *
	 * @param companyId the company ID of this product
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this product.
	 *
	 * @return the user ID of this product
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this product.
	 *
	 * @param userId the user ID of this product
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this product.
	 *
	 * @return the user uuid of this product
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this product.
	 *
	 * @param userUuid the user uuid of this product
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this product.
	 *
	 * @return the user name of this product
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this product.
	 *
	 * @param userName the user name of this product
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this product.
	 *
	 * @return the create date of this product
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this product.
	 *
	 * @param createDate the create date of this product
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this product.
	 *
	 * @return the modified date of this product
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this product.
	 *
	 * @param modifiedDate the modified date of this product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the product name of this product.
	 *
	 * @return the product name of this product
	 */
	@AutoEscape
	public String getProductName();

	/**
	 * Sets the product name of this product.
	 *
	 * @param productName the product name of this product
	 */
	public void setProductName(String productName);

	/**
	 * Returns the sequence number of this product.
	 *
	 * @return the sequence number of this product
	 */
	public long getSequenceNumber();

	/**
	 * Sets the sequence number of this product.
	 *
	 * @param sequenceNumber the sequence number of this product
	 */
	public void setSequenceNumber(long sequenceNumber);

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
	public int compareTo(Product product);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Product> toCacheModel();

	@Override
	public Product toEscapedModel();

	@Override
	public Product toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}